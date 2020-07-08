package ru.nsu.model;

import java.util.List;

public class Group {
    private String name;
    private List<Student> listStudent;

    public Group(String name, List<Student> listStudent) {
        this.name = name;
        this.listStudent = listStudent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getListStudent() {
        return listStudent;
    }

    public void setListStudent(List<Student> listStudent) {
        this.listStudent = listStudent;
    }
}
