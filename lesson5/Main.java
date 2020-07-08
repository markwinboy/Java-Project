package ru.nsu.lesson5;

import ru.nsu.exercise2.Client;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) throws DuplicateAccountException, IOException, TooManyLoginAttemptsException {
        Person person1 = new Person("Mark", "Karapetyants","Surenovich", "18-01-2000");
        Person person2 = new Person("Markel", "Karapetyan","Surenov", "18-01-1999");
        Person person3 = new Person("Nikita", "Gorevoi","Alekseevich", "19-03-1999");
        MailAccountManager databas = new AccountManager();
//        databas.registerNewAccount("mark_18.01","qwerty",person1);
//        databas.registerNewAccount("mark_18.02","qwert",person2);
//        databas.registerNewAccount("nikita_19.03","12345",person3);
        databas.removeAccount("mark_18.02","qwert");
        System.out.println(databas.hasAccount("mark_18.02"));
        System.out.println(databas.numOfAccounts());
        System.out.println(databas.getPerson("mark_18.0","qwert"));
    }
}
