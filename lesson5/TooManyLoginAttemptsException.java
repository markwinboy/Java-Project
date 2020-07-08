package ru.nsu.lesson5;

import java.lang.reflect.Executable;

public class TooManyLoginAttemptsException extends Exception {
    public TooManyLoginAttemptsException(){
        super("Чет слишком много запросов");
    }
}
