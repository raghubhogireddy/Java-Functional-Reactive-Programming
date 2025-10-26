package io.codr.lambdas;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Employee> employees = EmployeeDataBase.getAllEmployees();

        // forEach
        //forEachEmployee(employees);

        // filter
        //filterEmployee(employees);

        // map
        //mapEmployee(employees);

        // flatMap

        //flatMapEmployee(employees);

        // sorted
        //sortEmployee(employees);

        // sorted - desc
        //sortEmployeeDesc(employees);

        //max/min
        //maxMinEmployee(employees);

        //groupingBy
        //groupingByEmployee(employees);

        //findFirst
        //findFirstBYDept(employees);

        //findAny
        //findAny(employees);

        //anyMatch, allMatch, noneMatch
        //anyOrAllOrNoneMatch(employees);

        //limit
        //limitByTopPaidEmployee(employees);

        //skip(long)
        skpEmployee(employees);


    }

    private static void skpEmployee(List<Employee> employees) {
        List<Employee> skipEmployees = employees.stream().skip(5)
                .collect(Collectors.toList());
        System.out.println(skipEmployees);
    }

    private static void limitByTopPaidEmployee(List<Employee> employees) {
        List<String> limitByTopPaidEmp = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .map(Employee::getName)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(limitByTopPaidEmp);
    }

    private static void anyOrAllOrNoneMatch(List<Employee> employees) {
        boolean isAnyDevEmployeeExist = employees.stream()
                .anyMatch(employee -> employee.getDept().equals("Development"));
        System.out.println(isAnyDevEmployeeExist);


        boolean isAllEmplSalaryGreater = employees.stream()
                .allMatch(employee -> employee.getSalary() > 50000);
        System.out.println(isAllEmplSalaryGreater);


        boolean isInValidDept = employees.stream()
                .noneMatch(employee -> employee.getDept().equals("abc"));
        System.out.println(isInValidDept);


    }

    private static void findAny(List<Employee> employees) {
        Employee devEmployee = employees.stream()
                .filter(employee -> employee.getDept().equals("Development"))
                .findAny().orElseGet(Employee::new);
        System.out.println(devEmployee);

        employees.stream()
                .filter(employee -> employee.getDept().equals("abc"))
                .findAny().orElseThrow(() -> new IllegalArgumentException("Employee for dept not found"));
    }

    private static void findFirstBYDept(List<Employee> employees) {
        Employee devEmployee = employees.stream()
                .filter(employee -> employee.getDept().equals("Development"))
                .findFirst().orElseGet(Employee::new);
        System.out.println(devEmployee);

        employees.stream()
                .filter(employee -> employee.getDept().equals("abc"))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Employee for dept not found"));


    }

    private static void groupingByEmployee(List<Employee> employees) {
        Map<String, List<Employee>> groupBYGender = employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender));
        System.out.println(groupBYGender);

        Map<String, List<String>> groupByGenderAndName = employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender,
                        Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println(groupByGenderAndName);

        Map<String, Long> groupByGenderAndCount = employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(groupByGenderAndCount);
    }

    private static void maxMinEmployee(List<Employee> employees) {
        // max
        Optional<Employee> max = employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary));
        System.out.println(max.get());

        // min
        Optional<Employee> min = employees.stream()
                .min(Comparator.comparingDouble(Employee::getSalary));
        System.out.println(min.get());
    }

    private static void sortEmployeeDesc(List<Employee> employees) {
        LinkedHashSet<Employee> employeeByHighSalary = employees.stream()
                .sorted(Collections.reverseOrder(Comparator.comparingDouble(Employee::getSalary)))
                .collect(Collectors.toCollection(LinkedHashSet::new));

        employeeByHighSalary.forEach(System.out::println);
    }

    private static void sortEmployee(List<Employee> employees) {
        LinkedHashSet<Employee> employeeBySalary = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .collect(Collectors.toCollection(LinkedHashSet::new));

        employeeBySalary.forEach(System.out::println);
    }

    private static void flatMapEmployee(List<Employee> employees) {
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

    private static void mapEmployee(List<Employee> employees) {
        List<String> mapResult = employees.stream()
                .map(Employee::getDept)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(mapResult);
    }

    private static void filterEmployee(List<Employee> employees) {
        Map<String, String> collect = employees.stream()
                .filter(employee -> "Development".equals(employee.getDept()))
                .collect(Collectors.toMap(Employee::getName, Employee::getDept));
        System.out.println(collect);
    }

    private static void forEachEmployee(List<Employee> employees) {
        employees.forEach(employee -> System.out.println(employee.getName() + ", Salary : " + employee.getSalary()));
        employees.forEach(System.out::println);
    }
}
