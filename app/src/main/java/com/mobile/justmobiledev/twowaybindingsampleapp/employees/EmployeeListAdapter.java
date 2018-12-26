package com.mobile.justmobiledev.twowaybindingsampleapp.employees;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.mobile.justmobiledev.twowaybindingsampleapp.R;
import com.mobile.justmobiledev.twowaybindingsampleapp.models.employee.Employee;

import java.util.List;

public class EmployeeListAdapter extends RecyclerView.Adapter<EmployeeListAdapter.ViewHolder> {
    private List<Employee> employeeList;
    private LayoutInflater inflater;
    private ItemClickListener clickListener;

    // data is passed into the constructor
    EmployeeListAdapter(Context context, List<Employee> list) {
        this.inflater = LayoutInflater.from(context);
        this.employeeList = list;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.employee_list_row, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Employee employee = employeeList.get(position);
        holder.fullNameTextView.setText(employee.getFirstName() + " "+employee.getLastName());
        holder.businessNameTextView.setText(employee.getBusinessName());
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return employeeList.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView fullNameTextView;
        TextView businessNameTextView;

        ViewHolder(View itemView) {
            super(itemView);
            fullNameTextView = itemView.findViewById(R.id.textview_full_name);
            businessNameTextView = itemView.findViewById(R.id.textview_business_name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (clickListener != null) clickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    Employee getItem(int id) {
        return employeeList.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}