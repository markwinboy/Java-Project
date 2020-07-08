package ru.nsu.lesson5;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AccountManager implements MailAccountManager {

    private Database data = Database.getInstance("C:\\Users\\Mark\\IdeaProjects\\Lessons4\\src\\ru\\nsu\\lesson5\\Database.csv");
//    private int count = data.getCount();

    @Override
    public void registerNewAccount(String email, String password, Person person) throws DuplicateAccountException, IOException {
        /**
         * Метод проверяет, что данный аккаунт в базе отсутствует, и создает новую
         запись,
         * в противном случае выбрасывает проверяемую ошибку
         DuplicateAccountException
         */
        try {
            File file = new File(data.database.getName());
            if(hasAccount(email)){
                throw new DuplicateAccountException();
                }
            CSVWriter writer = new CSVWriter(new FileWriter(data.database.getName(), true));
            writer.writeNext((email+","+password+","+person.getInformation()+","+0).split(","));
            writer.close();
            }catch (Exception e) {
            e.printStackTrace();
        }

        }



    @Override
    public void removeAccount(String email, String password) {
        /**
         * Метод удаляет пользователя, если логин и пароль введены верно. В обратном
         случае выбрасывает
         * непроверяемую ошибку WrongCredentialsException
         */
        try {
//            CSVReader reader = new CSVReader(new FileReader(data.database.getName()), ',','"', 0);
            List<String> allrows = Files.readAllLines(Paths.get(data.database.getName()));
            int count = allrows.size();
            for(String row: allrows){
                String rowClone = row.replaceAll("\"", "");
                if(rowClone.split(",")[0].equalsIgnoreCase(email) && rowClone.split(",")[1].equalsIgnoreCase(password)){
                    allrows.remove(row);
                    break;
                }

            }

            if (allrows.size()==count){
                throw new WrongCredentialsException();
            }
            CSVWriter writer = new CSVWriter(new FileWriter(data.database.getName()));
            for (String row: allrows){
                writer.writeNext(row.replaceAll("\"","").split(","));
            }
            writer.close();
        }
        catch (Exception | WrongCredentialsException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean hasAccount(String email) {
        /**
         * Метод возвращает true если пользователь с данным логином существует
         */
        try {
            List<String> allrows = Files.readAllLines(Paths.get(data.database.getName()));
            for(String row: allrows){
                String rowClone = row.replaceAll("\"","");
                if(rowClone.split(",")[0].equals(email)){
                    return true;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Person getPerson(String email, String password) throws TooManyLoginAttemptsException {
        /**
         * Метод возвращает Person если логин и пароль совпадают, или выбрасывает
         исключение WrongCredentialsException.
         * Если неудачных попыток авторизоваться больше 5 то выбрасывается
         проверяемое исключение TooManyLoginAttemptsException
         */
        try {
            List<String> allrows = Files.readAllLines(Paths.get(data.database.getName()));
            int count= Integer.parseInt(allrows.get(0).replaceAll("\"","").split(",")[6]);
            for(String row: allrows){
                String rowClone = row.replaceAll("\"","");
                if((rowClone.split(",")[0].equals(email) & rowClone.split(",")[1].equals(password))){
                    return new Person(row.split(",")[2],row.split(",")[3],row.split(",")[4],row.split(",")[5]);
                }
            }
            data.appCount();
            count = data.getCount();
            if (count<=5){
                data.setCount(count);
            }
            else{
                count = 0;
                data.setCount(count);
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    @Override
    public int numOfAccounts() {
        /**
         * Метод возвращает кол-во аккаунтов в базе
         */
        List<String[]> allrows = null;
        try {
            CSVReader reader = new CSVReader(new FileReader(data.database.getName()), ',','"', 0);
            allrows = reader.readAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int count = allrows.size();
        return count;
    }
}
