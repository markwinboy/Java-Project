package ru.nsu.lesson6_1;

public class IncorrectInputData extends Exception {
    public IncorrectInputData() {
        super("Чет количество столбцов матрицы и количество строк вектора не совпадают(");
    }
}
