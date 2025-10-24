package io.codr.lambdas;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Employee> employees = EmployeeDataBase.getAllEmployees();

        // forEach
        employees.forEach(employee -> System.out.println(employee.getName() + ", Salary : " + employee.getSalary()));
        employees.forEach(System.out::println);

        // filter
        Map<String, String> collect = employees.stream()
                .filter(employee -> "Development".equals(employee.getDept()))
                .collect(Collectors.toMap(Employee::getName, Employee::getDept));
        System.out.println(collect);

        // map
        List<String> mapResult = employees.stream()
                .map(Employee::getDept)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(mapResult);

        // flatMap

        //just using map
        Set<Set<String>> mapMapResult = employees.stream()
                .map(employee -> employee.getProjects().stream()
                        .map(Project::getName)
                        .collect(Collectors.toSet())).collect(Collectors.toSet());
        System.out.println(mapMapResult);

        //using flatMap
        Set<String> flatMapResult = employees.stream()
                .flatMap(employee -> employee.getProjects().stream())
                .map(Project::getName)
                .sorted().collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println(flatMapResult);


    }
}
