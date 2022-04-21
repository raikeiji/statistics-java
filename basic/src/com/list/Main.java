package com.list;

import java.util.List;

class Employee {

    private String name;
    private String city;
    private int age;
    private double salary;

    public Employee(String name, String city, int age, double salary) {
        this.name = name;
        this.city = city;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

}

public class Main {
    public static void main(String[] args) {
        List<Employee> emp = List.of(
                new Employee("Doe", "Berlin", 25, 12_000),
                new Employee("John", "Sydney", 22, 9000),
                new Employee("Mary", "Berlin", 29, 13_000),
                new Employee("Mike", "London", 34, 10_500),
                new Employee("Adams", "London", 32, 11_500),
                new Employee("Harry", "Berlin", 35, 12_000));

        // Streaming the list multiple times

        // We stream the list multiple times to find the average, minimum, and maximum.

        double avgAge = emp.stream().mapToInt(Employee::getAge).average().orElse(0);

        int minAge = emp.stream().mapToInt(Employee::getAge).min().orElse(0);

        int maxAge = emp.stream().mapToInt(Employee::getAge).max().orElse(0);

        System.out.println("Average Age\t\t : " + avgAge);
        System.out.println("Minimal Age\t\t : " + minAge);
        System.out.println("Maximum Age\t\t : " + maxAge);

        // Using conventional ‘for’ loop

        int sumOfAge = 0;
        int minimumAge = Integer.MAX_VALUE;
        int maximumAge = Integer.MIN_VALUE;
        for (Employee employee : emp) {
            sumOfAge += employee.getAge();
            minimumAge = Math.min(minimumAge, employee.getAge());
            maximumAge = Math.max(maximumAge, employee.getAge());
        }
        System.out.println("Average age: " + ((double) sumOfAge / emp.size()));
        System.out.println("Minimum age: " + minimumAge);
        System.out.println("Maximum age: " + maximumAge);
    }
}
