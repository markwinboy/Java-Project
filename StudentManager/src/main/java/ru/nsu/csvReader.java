package ru.nsu;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.lang.Integer.parseInt;

public class csvReader {

    public static StudentArguments[] arrayOfStudent(String name ) throws IOException {
        List<String> allrows = Files.readAllLines(Paths.get(name));
        int count = allrows.size();
        int counter = (allrows.get(0).replaceAll("\"", "").split(",")).length;
        StudentArguments[] argList = new StudentArguments[count];
        String[] listOfStudent = new String[counter];
        for(int i=0;i<count;i++) {
            String[] allrowsClone = (allrows.get(i).replaceAll("\"", "").split(","));
            for (int j = 0; j < counter; j++) {
                listOfStudent[j] = allrowsClone[j];
            }
            StudentArguments student = new StudentArguments(listOfStudent[0],
                    listOfStudent[1],
                    listOfStudent[2],
                    listOfStudent[3]);
            argList[i]= student;
        }
        return argList;
    }
}
