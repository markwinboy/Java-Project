package ru.nsu.lesson5;

import com.opencsv.CSVWriter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public final class Database{

    private static Database instance;
    public String dataName;
    public static File database;
    private static int counter ;

    private Database(String dataName) {

        database = new File(dataName);
    }

    public static Database getInstance(String value) {
        if (instance == null) {
            instance = new Database(value);
        }
        return instance;
    }

    public int getCount() {
        return counter;
    }

    public void appCount() throws IOException {
        List<String> allrows = Files.readAllLines(Paths.get("Database.csv"));
//        System.out.println(allrows.get(0));
        counter = parseInt(allrows.get(0).replaceAll("\"","").split(",")[6]);
        counter += 1;
        CSVWriter writer = new CSVWriter(new FileWriter("Database.csv"));
        for(String row: allrows){
            writer.writeNext(row.replaceAll("\"","").split(","));
        }
        writer.close();
    }

    public void setCount(int count) throws IOException, TooManyLoginAttemptsException {
        List<String> allrows = Files.readAllLines(Paths.get("Database.csv"));
        System.out.println(count);
        counter = count;
        System.out.println(counter);
        CSVWriter writer = new CSVWriter(new FileWriter("Database.csv"));
        for (String row: allrows){
            String[] rowClone=(row.replaceAll("\"","").split(","));
            writer.writeNext((rowClone[0]+","+rowClone[1]+","+rowClone[2]+","+rowClone[3]+","
                    +rowClone[4]+","+rowClone[5]+","+counter).split(","));
        }
        writer.close();
        if (counter==5){
            throw new TooManyLoginAttemptsException();
        }
        throw new WrongCredentialsException();


}
}