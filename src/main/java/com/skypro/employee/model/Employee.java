package com.skypro.employee.model;

public class Employee {
    private static int counter;
    private final int id;
    private final String firsrName;
    private final String lastName;
    private final int department;
    private final int salary;

    public Employee(String firsrName, String lastName, int department, int salary) {
        this.firsrName = firsrName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;

        this.id=counter++;
    }

    public int getId() {
        return id;
    }

    public String getFirsrName() {
        return firsrName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firsrName='" + firsrName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                '}';
    }
}
