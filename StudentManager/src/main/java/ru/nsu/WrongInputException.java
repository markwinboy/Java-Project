package ru.nsu;

public class WrongInputException extends Exception{
    public WrongInputException(){
        super("Введен неправильный запрос");
    }
}
