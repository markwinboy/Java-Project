package ru.nsu;

public class StudentArguments {
    private String firstName;
    private String secondName;
    private String lastName;
    private String birhdayDate;

    public StudentArguments(String firstName, String secondName, String lastName, String birhdayDate) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.birhdayDate = birhdayDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirhdayDate() {
        return birhdayDate;
    }

    public void setBirhdayDate(String birhdayDate) {
        this.birhdayDate = birhdayDate;
    }
}
