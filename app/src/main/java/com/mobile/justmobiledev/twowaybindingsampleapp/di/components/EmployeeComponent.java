package com.mobile.justmobiledev.twowaybindingsampleapp.di.components;

import com.mobile.justmobiledev.twowaybindingsampleapp.di.modules.AppModule;
import com.mobile.justmobiledev.twowaybindingsampleapp.di.modules.EmployeeModule;
import com.mobile.justmobiledev.twowaybindingsampleapp.employees.EmployeeListPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules={AppModule.class, EmployeeModule.class})
public interface EmployeeComponent {
    void inject(EmployeeListPresenter presenter);

}

