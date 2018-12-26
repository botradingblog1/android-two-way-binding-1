package com.mobile.justmobiledev.twowaybindingsampleapp.employees;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobile.justmobiledev.twowaybindingsampleapp.databinding.FragmentEmployeeDetailBinding;

import com.mobile.justmobiledev.twowaybindingsampleapp.R;

public class EmployeeDetailFragment extends Fragment {
    private final String TAG = getClass().getSimpleName();

    private EmployeeDetailViewModel viewModel;
    private FragmentEmployeeDetailBinding binding;

    public EmployeeDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Get the VM
        viewModel = ViewModelProviders.of(getActivity()).get(EmployeeDetailViewModel.class);

        // Bind the VM
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_employee_detail,container,false);
        binding.setVm(viewModel);
        binding.setLifecycleOwner(this);

        return binding.getRoot();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
