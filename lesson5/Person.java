package ru.nsu.lesson5;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class Person {
    private String firstName;
    private String lastName;
    private String middleName;
    private String date;

    public Person(String firstName, String lastName, String middleName, String date) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.date =date;
    }

    public String getInformation(){
        return firstName+","+lastName+","+middleName+","+date;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(middleName, person.middleName) &&
                Objects.equals(date, person.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, middleName, date);
    }

    public String getDate() {
        return this.date;
    }
}
