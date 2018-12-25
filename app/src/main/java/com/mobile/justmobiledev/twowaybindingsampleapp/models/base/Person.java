package com.mobile.justmobiledev.twowaybindingsampleapp.models.base;

import java.util.UUID;

public class Person {
    protected String id;
    protected String firstName;
    protected String lastName;

    public Person(){
        id = UUID.randomUUID().toString();
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId(){
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName(){
        return lastName;
    }
}
