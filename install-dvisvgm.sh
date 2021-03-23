#!/bin/bash
set -xeuo pipefail
IFS=$'\n\t'

PREFIX="${1:-/usr/local/dvisvgm}"
TEX="$(kpsewhich -var SELFAUTOLOC)"

echo "$PREFIX, $TEX"

brew install automake freetype ghostscript potrace

# download the sources
mkdir -p "$PREFIX/source/texk"
cd "$PREFIX/source/"

# see https://www.tug.org/texlive/svn/
rsync -av --exclude=.svn tug.org::tldevsrc/Build/source/build-aux .
rsync -av --exclude=.svn tug.org::tldevsrc/Build/source/texk/kpathsea texk/

git clone git@github.com:mgieseki/dvisvgm.git

# compile kpathsea
cd texk/kpathsea

# patch SELFAUTOLOC
perl -0777 -i.bak \
    -pe 's|(kpathsea_selfdir \(kpathsea kpse, const_string argv0\)\n{)|$1\n  return xstrdup("'"$TEX"'");\n|g' \
    progname.c
./configure --prefix="$PREFIX/"

make
make install

# compile dvisvgm
cd ../../dvisvgm

./autogen.sh
CPPFLAGS="-I$PREFIX/include/" LDFLAGS="-L$PREFIX/lib/" ./configure --prefix="$PREFIX/"
make
make check
make install
