package com.mobile.justmobiledev.twowaybindingsampleapp.di.modules;

import com.mobile.justmobiledev.twowaybindingsampleapp.models.employee.EmployeeGenerator;

import dagger.Module;
import dagger.Provides;

@Module
public class EmployeeListModule {

    @Provides
    static EmployeeGenerator provideEmployeeGenerator() {
        return new EmployeeGenerator();
    }
}

