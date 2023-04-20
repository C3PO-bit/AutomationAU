package com.mydomain.autom8.dashboard.submitted;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mydomain.autom8.R;
import com.mydomain.autom8.databinding.FragmentSubmittedFormsBinding;


public class SubmittedFormsFragment extends Fragment {

    private FragmentSubmittedFormsBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSubmittedFormsBinding.inflate(inflater);
        return binding.getRoot();
    }
}