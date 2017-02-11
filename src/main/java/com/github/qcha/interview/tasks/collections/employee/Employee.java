package com.github.qcha.interview.tasks.collections.employee;

/**
 * Класс описывает сотрудника компании.
 * id - имя сотрудника.
 * managerId - имя сотрудника, которому подчиняется данный сотрудник.
 */
public class Employee {
    private String id;
    private String managerId;

    public Employee(String id, String managerId) {
        this.id = id;
        this.managerId = managerId;
    }

    public String getId() {
        return id;
    }

    public String getManagerId() {
        return managerId;
    }
}