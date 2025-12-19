package com.practice.javacode;

public class Employee {
    private String name;
    private String department;
    private double salary;

    // constructor, getters, setters
    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}

