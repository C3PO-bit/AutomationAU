package com.mydomain.autom8.dashboard.forms;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mydomain.autom8.R;
import com.mydomain.autom8.dashboard.IOnClickListener;
import com.mydomain.autom8.databinding.FragmentFormsBinding;
import com.mydomain.autom8.model.Forms;

import java.util.ArrayList;
import java.util.List;


public class FormsFragment extends Fragment implements IOnClickListener {

    private FragmentFormsBinding binding;
    private FormsAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFormsBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupUi();
    }

    private void setupUi() {
        adapter = new FormsAdapter();
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter.addAll(getForms(),this::onItemClick);
    }


    private List<Forms> getForms(){
        List<Forms> forms = new ArrayList<>();
        forms.add(new Forms(1,"General Form"));
        return forms;
    }

    @Override
    public void onItemClick(int position) {
        getForms().get(position);

        if (position == 0) {
            NavDirections directions = FormsFragmentDirections.actionFormsFragmentToGeneralFormFragment();
            Navigation.findNavController(getView()).navigate(directions);
        }
    }
}