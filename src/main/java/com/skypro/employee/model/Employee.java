package com.skypro.employee.model;

import org.apache.commons.lang3.StringUtils;

public class Employee {
    private static int counter;
    private final int id;
    private String firsrName;
    private String lastName;
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

    public void  setFirsrName(String firsrName) {
        if (StringUtils.isBlank(firsrName) || !StringUtils.isAlpha(firsrName)) {
            throw new RuntimeException("400 Bad Request");
        }
        this.firsrName = StringUtils.capitalize(firsrName);
    }

    public String getFirsrName() {
        return firsrName;
    }

    public void  setLastName(String lastName) {
        if (StringUtils.isBlank(lastName) || !StringUtils.isAlpha(lastName)) {
            throw new RuntimeException("400 Bad Request");
        }
        this.lastName = StringUtils.capitalize(lastName);
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
        return
                "№ п/п: " + id +
                ", Фамилия - '" + firsrName + '\'' +
                ", Имя - '" + lastName + '\'' +
                ", отдел - " + department +
                ", зарплата - " + salary
                ;
    }
}
