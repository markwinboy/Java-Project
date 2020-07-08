package ru.nsu.lesson6_1;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateMatrix {
    public static void main(String[] args ) throws IOException {
        int[][] matrix = new int[1000][1000];
        String[] sum = new String[1000];
        CSVWriter writer = new CSVWriter(new FileWriter("Database.csv"));
        final Random random = new Random();  // Генератор случайных чисел.
        for (int row = 0; row < matrix.length; ++row) {          // Цикл по строкам матрицы.
            for (int col = 0; col < matrix[row].length; ++col) { // Цикл по столбцам матрицы.
                matrix[row][col] = random.nextInt(100);
                sum[col]=String.valueOf(matrix[row][col]);
            }
            writer.writeNext(sum);
        }
//        CSVWriter writer = new CSVWriter(new FileWriter("Database2.csv"));

        writer.writeNext("".split(""));
        writer.writeNext(sum);
        writer.close();
    }
}
