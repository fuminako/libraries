package org.example;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;
    private int salary;
    private int department;
    private static int counter = 0;
    private final int id;

    public Employee(String firstName, String lastName, int department, int salary) {
        if (StringUtils.isAlpha(firstName) && !StringUtils.isBlank(firstName)) {
            this.firstName = StringUtils.capitalize(firstName);
        } else {
            throw new RuntimeException("Status 400 Bad Request");
        }
        if (StringUtils.isAlpha(lastName) && !StringUtils.isBlank(lastName)) {
            this.lastName = StringUtils.capitalize(lastName);
        } else {
            throw new RuntimeException("Status 400 Bad Request");
        }
        this.salary = salary;
        this.department = department;
        id = counter++;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;

    }

    public String getLastName() {
        return lastName;

    }

    public int getSalary() {
        return salary;

    }

    public int getDepartment() {
        return department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public String toString() {
        return "ФИО сотрудника: " + firstName + lastName + "; Отдел сотрудника: " + department + "; Зарплата сотрудника: " + salary + " Id: " + id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && id == employee.id && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, department, id);
    }
}
