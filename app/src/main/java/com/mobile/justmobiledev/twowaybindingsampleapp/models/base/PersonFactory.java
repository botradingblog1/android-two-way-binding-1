package com.mobile.justmobiledev.twowaybindingsampleapp.models.base;

import com.mobile.justmobiledev.twowaybindingsampleapp.models.employee.Employee;

import org.fluttercode.datafactory.impl.DataFactory;

import java.util.UUID;

public class PersonFactory {

    public Person createPerson(PersonTypeEnum personType){

        if (personType == PersonTypeEnum.UNKNOWN) return null;

        // Employee type
        if (personType == PersonTypeEnum.EMPLOYEE){
            // Add some fake data
            DataFactory dataFactory = new DataFactory();
            Employee employee = new Employee(UUID.randomUUID().toString(), dataFactory.getFirstName(), dataFactory.getLastName());
            employee.setBusinessName(dataFactory.getBusinessName());

            return employee;
        }

        return null;
    }
}
