package com.practice.javacode.streams;

import com.practice.javacode.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class HighestSalaryByDept {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR", 50000),
                new Employee("Bob", "IT", 70000),
                new Employee("Charlie", "HR", 60000),
                new Employee("David", "IT", 80000),
                new Employee("Eve", "Finance", 90000),
                new Employee("Frank", "Finance", 85000)
        );

        // Group by department and find employee with max salary
        Map<String, Optional<Employee>> highestByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))
                ));

        // Print results
        highestByDept.forEach((dept, emp) ->
                System.out.println(dept + " -> " + emp.get().getName() + " : " + emp.get().getSalary())
        );
    }
}

