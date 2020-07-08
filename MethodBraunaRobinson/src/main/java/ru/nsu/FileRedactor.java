package ru.nsu;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.lang.Integer.parseInt;

public class FileRedactor {
    private  String name;

    public FileRedactor(String name) {
        this.name = name;
    }

    public int[][] fileReaderMatrix() throws IOException {
        List<String> allrows = Files.readAllLines(Paths.get(name));
        String[] allrows1= (allrows.get(0).replaceAll("\"", "").split(","));
        int counter = allrows1.length;
        int count = allrows.size();
        int[][] matrix = new int[count][counter];
        for(int i=0;i<matrix.length;i++) {
            String[] allrowsClone = (allrows.get(i).replaceAll("\"", "").split(","));
            for (int j = 0; j < counter; j++) {
                matrix[i][j] = parseInt(allrowsClone[j]);
            }
        }
        return matrix;
    }
}
