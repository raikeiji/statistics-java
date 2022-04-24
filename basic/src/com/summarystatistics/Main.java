// based on : https://javadevcentral.com/summary-statistics-in-java-8

package com.summarystatistics;

import java.net.SocketTimeoutException;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

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

        // Using Summary Statistics in Primitive Streams (IntSummaryStatistics)

        IntSummaryStatistics employeeAgeStatistics = emp.stream().mapToInt(Employee::getAge).summaryStatistics();

        printIntSummaryStatistics("Employee Age Statistics", employeeAgeStatistics);

        // SummaryStatistics on a DoubleStream

        DoubleSummaryStatistics employeeSalaryStatistics = emp.stream().mapToDouble(Employee::getSalary)
                .summaryStatistics();

        printDoubleSummaryStatistics("Employee Salary Statistics", employeeSalaryStatistics);

        // (SummaryStatistics on a DoubleStream) Employee Salary Statistics for Berlin
        // Employees

        DoubleSummaryStatistics employeeSalaryStatisticsInBerlin = emp.stream()
                .filter(employee -> employee.getCity().equals("Berlin")).mapToDouble(Employee::getSalary)
                .summaryStatistics();

        printDoubleSummaryStatistics("Employee Salary Statistics for Berlin Employees",
                employeeSalaryStatisticsInBerlin);

        // (SummaryStatistics on a DoubleStream) Employee Salary Statistics for LONDON
        // Employees

        DoubleSummaryStatistics employeeSalaryStatisticsInLondon = emp.stream()
                .filter(employee -> employee.getCity().equals("London")).mapToDouble(Employee::getSalary)
                .summaryStatistics();

        printDoubleSummaryStatistics("Employee Salary Statistics for LONDON Employees",
                employeeSalaryStatisticsInLondon);

        // Example SummaryStatistics on a LongStream

        LongSummaryStatistics longSummary = LongStream.range(1, 100).summaryStatistics();
        
        printLongSummaryStatistics("LongSummaryStatistics for range 1-100", longSummary);

        // Creating SummaryStatistics using Stream.collect
        // Collectors.summarizingInt

        IntSummaryStatistics empAgeStatistics = emp.stream().collect(Collectors.summarizingInt(Employee::getAge));

        printIntSummaryStatistics("Employee Age Statistics", empAgeStatistics);

        // Creating SummaryStatistics using Stream.collect
        // Collectors.summarizingDouble

        DoubleSummaryStatistics employeeSalaryStat = emp.stream().collect(Collectors.summarizingDouble(Employee::getSalary));

        printDoubleSummaryStatistics("Employee Salary Statistics", employeeSalaryStat);

        // Creating SummaryStatistics using Stream.collect
        // Example Collectors.summarizingDouble

        LongSummaryStatistics longSummaryStat = List.of(1L, 2L, 3L, 4L, 5L).stream().collect(Collectors.summarizingLong(Long::longValue));

        printLongSummaryStatistics("LongSummaryStatistics for range 1-5", longSummaryStat);

    }

    public static void printIntSummaryStatistics(String message, IntSummaryStatistics intsummary) {

        System.out.println(message);
        System.out.println("Count\t : " + intsummary.getCount());
        System.out.println("Average\t : " + intsummary.getAverage());
        System.out.println("Minimal\t : " + intsummary.getMin());
        System.out.println("Maximum\t : " + intsummary.getMax());
        System.out.println("Sum\t : " + intsummary.getSum());

    }

    public static void printDoubleSummaryStatistics(String message, DoubleSummaryStatistics doublesummary) {

        System.out.println(message);
        System.out.println("Count\t : " + doublesummary.getCount());
        System.out.println("Average\t : " + doublesummary.getAverage());
        System.out.println("Minimal\t : " + doublesummary.getMin());
        System.out.println("Maximum\t : " + doublesummary.getMax());
        System.out.println("Sum\t : " + doublesummary.getSum());

    }

    // Example method of LongSummaryStatistics

    public static void printLongSummaryStatistics(String message, LongSummaryStatistics longSummaryStatistics) {

        System.out.println(message);
        System.out.println("Count: " + longSummaryStatistics.getCount());
        System.out.println("Avg: " + longSummaryStatistics.getAverage());
        System.out.println("Min: " + longSummaryStatistics.getMin());
        System.out.println("Max: " + longSummaryStatistics.getMax());
        System.out.println("Sum: " + longSummaryStatistics.getSum());
        System.out.println();

    }
}
