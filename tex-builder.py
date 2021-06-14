import argparse
import re

if __name__ == '__main__':
    parser = argparse.ArgumentParser()
    parser.add_argument('--file', type=argparse.FileType('rt', encoding='UTF-8'),
                        required=True)
    args = parser.parse_args()
    if not ".tex.md" in (args.file.name):
        print("Only use me with .tex.md files please!")
        exit()
    output_file = args.file.name.replace('.tex', '')
    regex = re.compile(r"\$(.*?)\$")
    with open(output_file, "w") as output:
        for line in args.file:
            output.write(re.sub(
                regex, r'<img style="transform: translateY(0.1em)background: white" src="https://render.githubusercontent.com/render/math?math=\g<1>">', line))
    args.file.close()
