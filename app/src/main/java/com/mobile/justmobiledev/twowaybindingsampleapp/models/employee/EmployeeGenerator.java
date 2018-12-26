package com.mobile.justmobiledev.twowaybindingsampleapp.models.employee;

import com.mobile.justmobiledev.twowaybindingsampleapp.models.base.PersonFactory;
import com.mobile.justmobiledev.twowaybindingsampleapp.models.base.PersonTypeEnum;
import com.mobile.justmobiledev.twowaybindingsampleapp.models.employee.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

public class EmployeeGenerator {

    @Inject
    public EmployeeGenerator(){ }

    public static Map<String, Employee> generateEmployees(int numEmployees){

        Map<String, Employee> employeeMap = new HashMap<>();
        for (int i=0; i < numEmployees; i++){
            PersonFactory factory = new PersonFactory();
            Employee employee = (Employee)factory.createPerson(PersonTypeEnum.EMPLOYEE);
            employeeMap.put(employee.getEmployeeId(), employee);
        }

        return employeeMap;
    }
}
