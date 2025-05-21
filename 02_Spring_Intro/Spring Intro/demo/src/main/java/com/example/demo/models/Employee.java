package com.example.demo.models;

import jakarta.persistence.Id;

public class Employee {
    private String name;
    @Id
    private int id;
    private Department dept;

    public Employee(String name, int id, Department dept) {
        this.name = name;
        this.id = id;
        this.dept = dept;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", dept=" + dept +
                '}';
    }
}
