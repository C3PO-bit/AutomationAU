package com.mydomain.autom8.dashboard.forms;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mydomain.autom8.R;
import com.mydomain.autom8.databinding.FragmentGeneralFormBinding;


public class GeneralFormFragment extends Fragment {

    private FragmentGeneralFormBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentGeneralFormBinding.inflate(inflater);
        return binding.getRoot();
    }
}