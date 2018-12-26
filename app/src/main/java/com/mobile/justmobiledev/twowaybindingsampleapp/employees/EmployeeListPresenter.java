package com.mobile.justmobiledev.twowaybindingsampleapp.employees;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.view.View;

import com.mobile.justmobiledev.twowaybindingsampleapp.MyApplication;
import com.mobile.justmobiledev.twowaybindingsampleapp.R;
import com.mobile.justmobiledev.twowaybindingsampleapp.models.employee.Employee;
import com.mobile.justmobiledev.twowaybindingsampleapp.models.employee.EmployeeGenerator;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

import javax.inject.Inject;

public class EmployeeListPresenter {

    private static final int EMPLOYEES_TO_GENERATE = 20;
    private EmployeeDetailViewModel viewModel;

    @Inject
    EmployeeGenerator employeeGenerator;

    private EmployeeListActivity view;
    private Map<String, Employee> employeeList;
    private Random generator;

    public EmployeeListPresenter(EmployeeListActivity activity){
        this.view = activity;
        generator = new Random();

        ((MyApplication) MyApplication.getApplication()).getEmployeeComponent().inject(this);

        // Create a View Model
        viewModel = ViewModelProviders.of(view).get(EmployeeDetailViewModel.class);

        // Set Callback
        viewModel.setCallback(new EmployeeDetailViewModel.IOnSaveButtonClicked() {
            @Override
            public void onSaveButtonClicked(Employee employee) {
                // Update employee list
                employeeList.put(employee.getEmployeeId(), employee);

                view.updateEmployeeList(new ArrayList<>(employeeList.values()));

                view.showInfo(view.getString(R.string.employee_list_listview_updated));

                view.hideKeyboard();
            }
        });

        // Load data
        loadEmployeeList();
    }

    private void loadEmployeeList(){
        // Generate bogus data
        employeeList = employeeGenerator.generateEmployees(EMPLOYEES_TO_GENERATE);

        // Update UI
        view.updateEmployeeList(new ArrayList(employeeList.values()));

        // Load a random employee
        Employee[] values = employeeList.values().toArray(new Employee[0]);
        Employee employee = values[generator.nextInt(values.length)];
        onEmployeeSelected(employee);
    }

    public void onEmployeeSelected(final Employee employee){
        // Update detail fragment
        view.showInfo(view.getString(R.string.employee_list_loading_employee, employee.getFullName()));

        // Update VM
        viewModel.setEmployee(employee);
    }
}

