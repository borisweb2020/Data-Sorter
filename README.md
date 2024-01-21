# Data Sorter

DataSortedApp is a command-line Java program for filtering data from text files based on their types.

## Description

The program reads lines from input text files, determines their type (integer, floating-point number or string) and writes them to the corresponding output files. By default, result files are overwritten. The `-a` option allows appending data to existing files.

## Usage

1. Clone the repository to your computer:

```bash
git clone https://github.com/borisweb2020/Eltex-landing-page.git
```

2. Add text files `<name-file>.txt` to the _**Data-Sorter**_ directory.

```bash
Data of any type
String type
word
Integer type
5001
Floating-point number type
1.0002
```

3. Compile the executable file:

```bash
javac DataSortedApp.java
```

4. Run the program:

```bash
# Default mode
java DataSortedApp <name-file>.txt <name-file-2>.txt

# With the -a option
java DataSortedApp -a <name-file>.txt <name-file-2>.txt
```
