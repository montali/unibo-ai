# Contributing

Files are grouped by course and module in their respective folders. Typical structure looks like this:

- Course folder
  - `*.tex.md`: Raw notes containing LaTeX code with formulas
  - `*.md`: Compiled notes where formulas has been compiled to images
  - `examples`: Code examples

## Compiling `.tex.md` files

`.tex.md` files can be compiled to normal `.md` files with the [`readme2tex`](https://github.com/leegao/readme2tex) python module.

Full installation and usage instructions for `readme2tex` can be found [here](https://github.com/leegao/readme2tex#installation).

### Installation

With `python` 2.7 or superior and `pip` installed run this command:

```
sudo pip install readme2tex
```

### Usage

With `readme2tex` installed run:

```
python3 -m readme2tex --nocdn --readme path_to_input.tex.md --output  path_to_output.md
```

Alternatevily, to compile all files in the project run the [`compile_tex_md.bat`](compile_tex_md.bat) script from Windows or the [`compile_tex_md.sh`](compile_tex_md.sh) script from Linux.
(NOTE: the [`compile_tex_md.sh`](compile_tex_md.sh) script is not yet complete, your contribute to complete it would be apreciated)