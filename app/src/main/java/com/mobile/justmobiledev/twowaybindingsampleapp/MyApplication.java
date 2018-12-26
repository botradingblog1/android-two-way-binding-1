package com.mobile.justmobiledev.twowaybindingsampleapp;

import android.app.Application;

import com.mobile.justmobiledev.twowaybindingsampleapp.di.components.EmployeeComponent;


public class MyApplication extends Application {

    private EmployeeComponent employeeComponent;
    private static Application application;

    @Override
    public void onCreate() {
        super.onCreate();

        employeeComponent = com.mobile.justmobiledev.twowaybindingsampleapp.di.components.DaggerEmployeeComponent.create();

        application = this;
    }

    public EmployeeComponent getEmployeeComponent() {
        return employeeComponent;
    }

    public static Application getApplication(){
        return application;
    }
}