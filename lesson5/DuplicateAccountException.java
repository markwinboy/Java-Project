package ru.nsu.lesson5;

public class DuplicateAccountException extends Exception {
    public DuplicateAccountException(){
        super("Данный аккаунт уже существует");
    }

}
