package com.mobile.justmobiledev.twowaybindingsampleapp.employees;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobile.justmobiledev.twowaybindingsampleapp.R;
import com.mobile.justmobiledev.twowaybindingsampleapp.models.employee.Employee;

import java.util.ArrayList;
import java.util.List;


public class EmployeeListFragment extends Fragment implements EmployeeListAdapter.ItemClickListener{
    private ArrayList<Employee> employeeList;
    private EmployeeListAdapter listAdapter;
    private OnSelectedItemClickListener callback;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_employee_list, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_employee_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Create list adapter
        employeeList = new ArrayList<>();
        listAdapter = new EmployeeListAdapter(getContext(), employeeList);
        listAdapter.setClickListener(this);

        // Set adapter
        recyclerView.setAdapter(listAdapter);

        return view;
    }

    @Override
    public void onItemClick(View view, int position) {
        //Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
        if (callback != null){
            Employee employee = listAdapter.getItem(position);
            callback.onEmployeeSelected(employee);
        }
    }

    void updateEmployeeList(ArrayList<Employee> employeeList){
        this.employeeList.clear();
        this.employeeList.addAll(employeeList);
        listAdapter.notifyDataSetChanged();
    }

    public void setOnSelectedItemClickListener(Activity activity) {
        callback = (OnSelectedItemClickListener)activity;
    }

    public interface OnSelectedItemClickListener {
        void onEmployeeSelected(Employee selectedEmployee);
    }
}
