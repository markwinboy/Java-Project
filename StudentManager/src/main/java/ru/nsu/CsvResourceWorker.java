package ru.nsu;

import ru.nsu.model.Group;
import ru.nsu.model.Student;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvResourceWorker implements ResourceWorker{
    private List<Group> groupList;
    public static List<File> parserDirectory(String directory){
        List<File> results = new ArrayList<>();
        File[] files = new File(directory).listFiles();
        for (File file : files) {
            if (file.isFile() & file.getName().split("\\.")[1].equalsIgnoreCase("csv")) {
                results.add(file);
            }
        }
        return results;
    }
    @Override
    public List<Group> readGroups(String directory) throws IOException {
        List<File> results = new ArrayList<>();
        File[] files = new File(directory).listFiles();
        for (File file : files) {
            if (file.isFile() & file.getName().split("\\.")[1].equalsIgnoreCase("csv")) {
                List<String> allrows = Files.readAllLines(Paths.get(file.getName()));
                int count = allrows.size();
                int counter = (allrows.get(0).replaceAll("\"", "").split(",")).length;
                Student[] argList = new Student[count];
                String[] listOfStudent = new String[counter];
                for(int i=0;i<count;i++) {
                    String[] allrowsClone = (allrows.get(i).replaceAll("\"", "").split(","));
                    for (int j = 0; j < counter; j++) {
                        listOfStudent[j] = allrowsClone[j];
                    }
                    Student student = new Student(listOfStudent[0],
                            listOfStudent[1],
                            listOfStudent[2],
                            listOfStudent[3]);

                    argList[i]= student;
                }
                Group group = new Group(file.getName().split("\\.")[0],argList);
                results.add(file);
            }
        }
        return results;
    }

}
