package ru.nsu.lesson5;

public class WrongCredentialsException extends Error {
    public WrongCredentialsException() {
        super("Такого пользователя нет(");
    }

}
