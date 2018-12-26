package com.mobile.justmobiledev.twowaybindingsampleapp.employees;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;

import com.mobile.justmobiledev.twowaybindingsampleapp.models.employee.Employee;

public class EmployeeDetailViewModel extends ViewModel {
    private MutableLiveData<Employee> employee = new MutableLiveData<>();
    private IOnSaveButtonClicked callback;

    public void setEmployee(Employee employee){
        this.employee.setValue(employee);
    }

    public void setCallback(IOnSaveButtonClicked callback){
        this.callback = callback;
    }

    public LiveData<Employee> getEmployee(){
        return employee;
    }

    public void onSaveButtonClick(){
        if (callback != null) callback.onSaveButtonClicked(employee.getValue());
    }

    public interface IOnSaveButtonClicked{
        void onSaveButtonClicked(final Employee employee);
    }
}
