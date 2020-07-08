package ru.nsu;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class App
{
    public static void main( String[] args ) throws IOException, DuplicateGroupException, WrongInputException {
        if(args.length==0){
            throw new WrongInputException();
        }
        if (args[0].equalsIgnoreCase("updateDB") & args.length==2){
            List<File> result = CsvResourceWorker.parserDirectory(args[1]);
            for(int i =0;i<result.size();i++){
                DataBaseGroup dbgroup = new DataBaseGroup("jdbc:mysql://remotemysql.com:3306/8ljJofQNya",
                        "8ljJofQNya","uUuS8PpNfM");
                String group = result.get(i).getName().split("\\.")[0];
                if(!dbgroup.groupCheck(group)){
                    dbgroup.unloading(group);
                }
                    StudentArguments[] listOfStudent = csvReader.arrayOfStudent(result.get(i).getPath());
                    DataBaseStudent dbStudent = new DataBaseStudent();
                    dbStudent.unloading(listOfStudent,group);

            }
        }else if(args[0].equalsIgnoreCase("printAll")){
            DataBaseStudent dbStudent = new DataBaseStudent();
            dbStudent.downloading();

    }
}
}
