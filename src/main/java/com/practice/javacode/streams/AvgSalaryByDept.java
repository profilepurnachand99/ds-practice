package com.practice.javacode.streams;

import com.practice.javacode.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AvgSalaryByDept {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR", 50000),
                new Employee("Bob", "IT", 70000),
                new Employee("Charlie", "HR", 60000),
                new Employee("David", "IT", 80000),
                new Employee("Eve", "Finance", 90000)
        );

        // 1. Average salary by department
        Map<String, Double> avgSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));

        System.out.println("Average salary by department:");
        avgSalaryByDept.forEach((dept, avg) ->
                System.out.println(dept + " -> " + avg)
        );

        // 2. Department with highest average salary
        Map.Entry<String, Double> highestDept = avgSalaryByDept.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);

        System.out.println("\nDepartment with highest average salary:");
        if (highestDept != null) {
            System.out.println(highestDept.getKey() + " -> " + highestDept.getValue());
        }
    }
}

