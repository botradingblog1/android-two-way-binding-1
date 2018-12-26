package com.mobile.justmobiledev.twowaybindingsampleapp.employees;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.mobile.justmobiledev.twowaybindingsampleapp.R;
import com.mobile.justmobiledev.twowaybindingsampleapp.models.employee.Employee;

import java.util.ArrayList;

import static android.view.View.VISIBLE;

public class EmployeeListActivity extends AppCompatActivity implements EmployeeListActivityMVP, EmployeeListFragment.OnSelectedItemClickListener {

    private EmployeeListPresenter presenter;
    private ProgressBar progressBar;
    private EmployeeListAdapter listAdapter;
    private EmployeeListFragment employeeListFragment;
    private EmployeeDetailFragment employeeDetailFragment;
    private TextView outputTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_list);

        setTitle(getString(R.string.employee_list));

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        progressBar = findViewById(R.id.progressBar);

        outputTextView = findViewById(R.id.textview_info_output);
        outputTextView.setText(R.string.employee_list_select_employee);

        // Don't set focus on EditText
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        // Create presenter
        presenter = new EmployeeListPresenter(this);
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        // Get a reference to the fragments
        if (fragment instanceof EmployeeListFragment) {
            employeeListFragment = (EmployeeListFragment) fragment;
            // Register click listener
            employeeListFragment.setOnSelectedItemClickListener(this);
        }
        else if (fragment instanceof EmployeeDetailFragment) {
            employeeDetailFragment = (EmployeeDetailFragment) fragment;
        }
    }

    @Override
    public void updateEmployeeList(final ArrayList<Employee> employeeList){
        employeeListFragment.updateEmployeeList(employeeList);
    }

    @Override
    public void onEmployeeSelected(Employee selectedEmployee){
        presenter.onEmployeeSelected(selectedEmployee);
    }

    @Override
    public void showInfo(final String message) {
        outputTextView.setText(message);
    }

    @Override
    public void hideKeyboard() {
        InputMethodManager inputManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }
}
