package com.mobile.justmobiledev.twowaybindingsampleapp.models.employee;

import com.mobile.justmobiledev.twowaybindingsampleapp.models.base.PersonFactory;
import com.mobile.justmobiledev.twowaybindingsampleapp.models.base.PersonTypeEnum;
import com.mobile.justmobiledev.twowaybindingsampleapp.models.employee.Employee;

import java.util.ArrayList;

public class EmployeeGenerator {

    public static ArrayList<Employee> generateEmployees(int numEmployees){

        ArrayList<Employee> employeeList = new ArrayList<>();
        for (int i=0; i < numEmployees; i++){
            PersonFactory factory = new PersonFactory();
            Employee employee = (Employee)factory.createPerson(PersonTypeEnum.EMPLOYEE);
            employeeList.add(employee);
        }

        return employeeList;
    }

}
