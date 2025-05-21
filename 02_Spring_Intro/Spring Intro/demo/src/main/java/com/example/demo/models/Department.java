package com.example.demo.models;

import jakarta.persistence.Id;

public class Department {
    @Id
    private String deptname;

    public Department(String deptname) {
        this.deptname = deptname;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptname='" + deptname + '\'' +
                '}';
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }
}
