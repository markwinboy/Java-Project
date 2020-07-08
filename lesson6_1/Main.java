package ru.nsu.lesson6_1;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.lang.Integer.parseInt;
import static ru.nsu.lesson6_1.Matrix.*;

public class Main {
    public static void main(String[] args) throws IOException, IncorrectInputData, InterruptedException {
        File database = new File("Database.csv");
        int[][] matrix = database.fileReaderMatrix();
        int[][] matrix2 = database.fileReaderMatrix();

//      Перемножение матрицы и матрицы обычным способом
        long startTime1 = System.currentTimeMillis();
        System.out.println("MultiplierMatMat");
        String[][] matrixNew = multiplyMatrixes(matrix,matrix2);
        long stopTime1 = System.currentTimeMillis();
        long elapsedTime = stopTime1 - startTime1;
        File database1 = new File("Database1.csv");
        database1.fileWriterMatrix(matrixNew);

//      Перемножение матрицы и матрицы с помощью потоков
        long startTime2 = System.currentTimeMillis();
        System.out.println("\nMultiplierThreadMtrix");
        matrixNew = multiplyMM(matrix,matrix2, 10);
        long stopTime2 = System.currentTimeMillis();
        long elapsedTime2 = stopTime2 - startTime2;
        File database2 = new File("Database2.csv");
        database2.fileWriterMatrix(matrixNew);

        System.out.println(((elapsedTime-elapsedTime2)*100/elapsedTime2)+"%");
        System.out.println(elapsedTime);
        System.out.println(elapsedTime2);


    }



}
