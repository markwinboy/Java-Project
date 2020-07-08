package ru.nsu.lesson6_1;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.lang.Integer.parseInt;

public class File {

    private  String name;

    public File(String name) {
        this.name = name;
    }

    public int[][] fileReaderMatrix() throws IOException {
        List<String> allrows = Files.readAllLines(Paths.get(name));
        String[] allrows1= (allrows.get(0).replaceAll("\"", "").split(","));
        int counter = allrows1.length;
        int count = allrows.size();
        int[][] matrix = new int[count-2][counter];
        for(int i=0;i<matrix.length;i++) {
            String[] allrowsClone = (allrows.get(i).replaceAll("\"", "").split(","));
            for (int j = 0; j < counter; j++) {
                matrix[i][j] = parseInt(allrowsClone[j]);
            }
        }
        return matrix;
    }

    public int[] fileReaderVector() throws IOException {
        File matrix1 = new File(name);
        List<String> allrows = Files.readAllLines(Paths.get(name));
        int count = allrows.size();
        String[] allrows1=(allrows.get(count-1).replaceAll("\"", "").split(","));
        int[] vector = new int[allrows1.length];
        for (int i =0; i<allrows1.length;i++){
            vector[i]= parseInt(allrows1[i]);
        }
        return vector;
    }

    public void fileWriterMatrix(String[][] matrix) throws IOException {
        CSVWriter writer = new CSVWriter(new FileWriter(name));
        for(int i = 0;i<matrix.length;i++){
            writer.writeNext(matrix[i]);
        }
        writer.close();
    }
}
