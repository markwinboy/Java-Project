package ru.nsu;

public class DuplicateGroupException extends Exception {
    public DuplicateGroupException(){
        super("Данные группы уже загружены");
    }
}
