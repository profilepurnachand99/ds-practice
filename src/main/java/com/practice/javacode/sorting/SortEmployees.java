package com.practice.javacode.sorting;

import com.practice.javacode.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortEmployees {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR", 50000),
                new Employee("Bob", "IT", 70000),
                new Employee("Charlie", "HR", 60000),
                new Employee("David", "IT", 80000),
                new Employee("Eve", "Finance", 90000)
        );

        // Sort by salary descending
        List<Employee> sortedEmployees = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .collect(Collectors.toList());

        // Print results
        sortedEmployees.forEach(System.out::println);
    }
}

