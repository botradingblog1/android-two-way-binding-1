package com.mobile.justmobiledev.twowaybindingsampleapp.employees;

import com.mobile.justmobiledev.twowaybindingsampleapp.models.employee.Employee;

import java.util.ArrayList;

public interface EmployeeListActivityMVP {
    void updateEmployeeList(final ArrayList<Employee> employeeList);
    void showInfo(final String message);
    void hideKeyboard();
}
