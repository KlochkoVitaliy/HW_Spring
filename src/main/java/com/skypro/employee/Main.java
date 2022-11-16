package com.skypro.employee;

import com.skypro.employee.model.Employee;

public class Main {
    private static void printAllEmployees(Employee[] array) {
        for (Employee employee : array) {
            if (employee != null) {
                System.out.println(employee);
            } else {
                System.out.println("Данных нет!!");
            }
        }
    }

    public static void main(String[] args) {

        Employee ivanovIvan = new Employee("Иванов ", "Иван", 1, 1_000);
        Employee petrovPetr = new Employee("Петров", "Петр", 2, 10_000);
        Employee vasilevVasia = new Employee("Васильев", "Вася", 3, 20_000);
        Employee konovKonor = new Employee("Конов", "Конор", 2, 30_000);
        Employee olegovOleg = new Employee("Олегов", "Олег", 1, 40_000);

        Employee[] employees = new Employee[5];
        printAllEmployees(employees);
        employees[0] = ivanovIvan;
        employees[1] = petrovPetr;
        employees[2] = vasilevVasia;
        employees[3] = konovKonor;
        employees[4] = olegovOleg;
        printAllEmployees(employees);

    }
}
