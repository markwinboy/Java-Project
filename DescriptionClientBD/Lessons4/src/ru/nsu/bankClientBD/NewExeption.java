package ru.nsu.bankClientBD;

public class NewExeption extends Exception {
    public NewExeption() {
        super("Такой клиент уже существует)");
    }
}
