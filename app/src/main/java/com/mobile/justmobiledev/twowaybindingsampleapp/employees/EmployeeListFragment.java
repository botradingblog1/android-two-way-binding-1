package com.mobile.justmobiledev.twowaybindingsampleapp.employees;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobile.justmobiledev.twowaybindingsampleapp.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class EmployeeListFragment extends Fragment {

    public EmployeeListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_employee_list, container, false);
    }
}
