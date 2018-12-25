package com.mobile.justmobiledev.twowaybindingsampleapp.di.components;

import com.mobile.justmobiledev.twowaybindingsampleapp.di.modules.EmployeeListModule;
import com.mobile.justmobiledev.twowaybindingsampleapp.employees.EmployeeListActivity;

import dagger.Component;


@Component(modules = EmployeeListModule.class)
interface EmployeeListComponent {

    void inject(EmployeeListActivity employeeListActivity);

}

