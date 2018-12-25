package com.mobile.justmobiledev.twowaybindingsampleapp.employees;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

import com.mobile.justmobiledev.twowaybindingsampleapp.R;

import static android.view.View.VISIBLE;

public class EmployeeListActivity extends AppCompatActivity implements EmployeeListActivityMVP {

    EmployeeListPresenter presenter;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        progressBar = findViewById(R.id.progressBar);

        // Create presenter
        presenter = new EmployeeListPresenter((View)this);

    }

    @Override
    public void showProgress(boolean show) {
        if (show){
            progressBar.setVisibility(VISIBLE);
        }
        else {
            progressBar.setVisibility(View.GONE);
        }
    }
}
