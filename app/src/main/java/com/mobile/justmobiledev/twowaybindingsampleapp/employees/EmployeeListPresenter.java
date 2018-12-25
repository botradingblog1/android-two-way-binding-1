package com.mobile.justmobiledev.twowaybindingsampleapp.employees;

import android.view.View;

import com.mobile.justmobiledev.twowaybindingsampleapp.models.employee.EmployeeGenerator;

import javax.inject.Inject;

public class EmployeeListPresenter {

    @Inject
    EmployeeGenerator employeeGenerator;

    private View view;

    public EmployeeListPresenter(View view){
        this.view = view;
    }



}

