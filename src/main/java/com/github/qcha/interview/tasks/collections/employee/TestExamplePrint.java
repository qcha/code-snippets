package com.github.qcha.interview.tasks.collections.employee;

import com.github.qcha.interview.tasks.collections.employee.Employee;

import java.util.Arrays;

public class TestExamplePrint {
    public static void main(String[] args){
        Printer.print(Arrays.asList(
                new Employee("Самый главный босс", ""),
                new Employee("Босс поменьше1", "Самый главный босс"),
                new Employee("Маленький босс1", "Босс поменьше1"),
                new Employee("Маленький босс2", "Босс поменьше1"),
                new Employee("Трудяга1", "Маленький босс1"),
                new Employee("Трудяга2", "Маленький босс1"),
                new Employee("Трудяга3", "Маленький босс2"),
                new Employee("Трутень", "Трудяга2"),
                new Employee("Босс поменьше2", "Самый главный босс"),
                new Employee("Стажер", "Трутень"),
                new Employee("Вообще лох какой то", "Стажер")
        ));
    }
}
