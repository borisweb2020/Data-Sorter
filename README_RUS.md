# Data Sorter

DataSortedApp - это программа командной строки на Java для фильтрации данных из текстовых файлов в зависимости от их типа.

## Описание

Программа считывает строки из входных текстовых файлов, определяет их тип (целое число, вещественное число или строка) и записывает в соответствующие выходные файлы. По умолчанию файлы результатов перезаписываются. С помощью опции `-a` можно задать режим добавления в существующие файлы.

## Использование

1. Склонируйте репозиторий на свой компьютер:

```bash
git clone https://github.com/borisweb2020/Eltex-landing-page.git
```

2. Добавьте в директорию _**Data-Sorter**_ текстовые файлы `<name-file>.txt`

```bash
Данные любого типа
типа Строка
слово
типа Целое число
5001
типа Вещественное число
1,0002
```
3. Скомпилируйте исполняемый файл:

```bash
javac DataSortedApp.java
```

4. Запуск программы:

```bash
# По умолчанию
java DataSortedApp <name-file>.txt <name-file-2>.txt

# С опцией -a
java DataSortedApp -a <name-file>.txt <name-file-2>.txt
```