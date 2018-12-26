package com.mobile.justmobiledev.twowaybindingsampleapp.models.employee;

import com.mobile.justmobiledev.twowaybindingsampleapp.models.base.Person;

public class Employee extends Person {
    private String employeeId;
    private String businessName;

    public Employee(String employeeId, String firstName, String lastName){
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeId(){
        return employeeId;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
        }

    public String getBusinessName(){
        return businessName;
    }

    public String getFullName(){
        return firstName + " "+ getLastName();
    }
}
