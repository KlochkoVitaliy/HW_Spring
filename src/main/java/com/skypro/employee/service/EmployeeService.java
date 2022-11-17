package com.skypro.employee.service;

import com.skypro.employee.model.Employee;
import com.skypro.employee.record.EmployeeRequest;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final Map<Integer, Employee> employees = new HashMap<>();
    private final Map<Integer,Employee> employeesAverageSalary = new HashMap<>();


    public Collection<Employee> getAllEmployees() {
        return this.employees.values();
    }

    public Employee addEmployee(EmployeeRequest employeeRequest) {
        if (employeeRequest.getFirstName() == null || employeeRequest.getLastName() == null) {
            throw new IllegalArgumentException("Имя не задано");
        }
        Employee employee = new Employee(employeeRequest.getFirstName(),
                employeeRequest.getLastName(),
                employeeRequest.getDepartment(),
                employeeRequest.getSalary());
        this.employees.put(employee.getId(), employee);
        return employee;
    }

    public int getSalarySum() {
        return employees.values().stream().mapToInt(Employee::getSalary).sum();
    }

    public List<Employee> getSalaryMin() {
        Comparator<Employee> comparator = Comparator.comparing( Employee :: getSalary);
        List<Employee> minSalary = employees.values().stream()
                .min(comparator)
                .stream()
                .collect(Collectors.toList());
        return minSalary;
    }
    public List<Employee> getSalaryMax() {
        Comparator<Employee> comparator = Comparator.comparing( Employee :: getSalary);
        List<Employee> maxSalary = employees.values().stream()
                .max(comparator)
                .stream()
                .collect(Collectors.toList());
        return maxSalary;
    }
    public double getAverageSum () {
        return getSalarySum() / employees.size();
    }
    public Collection<Employee> getSalaryAverage() {
        for (Map.Entry<Integer, Employee> entry : employees.entrySet()) {
            if (entry.getValue().getSalary() > getAverageSum()) {
                employeesAverageSalary.put(entry.getKey(), entry.getValue());
            }
        }
        return this.employeesAverageSalary.values();


        //return employees.values().stream().mapToInt(Employee::getId).average().getAsDouble();
    }
}
