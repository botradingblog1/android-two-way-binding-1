package com.mobile.justmobiledev.twowaybindingsampleapp.di.modules;

import com.mobile.justmobiledev.twowaybindingsampleapp.models.employee.EmployeeGenerator;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class EmployeeModule {

    @Provides
    @Singleton
    static EmployeeGenerator provideEmployeeGenerator() {
        return new EmployeeGenerator();
    }
}

