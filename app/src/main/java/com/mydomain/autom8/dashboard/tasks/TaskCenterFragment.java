package com.mydomain.autom8.dashboard.tasks;

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

import com.mydomain.autom8.dashboard.IOnClickListener;
import com.mydomain.autom8.databinding.FragmentTaskCenterBinding;
import com.mydomain.autom8.model.TaskCenterItems;

import java.util.ArrayList;
import java.util.List;

public class TaskCenterFragment extends Fragment implements IOnClickListener {

    private FragmentTaskCenterBinding binding;
    private TaskCenterAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentTaskCenterBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupUi();
    }

      private void setupUi() {
        adapter = new TaskCenterAdapter();
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter.addAll(getItems(),this::onItemClick);

}

    private List<TaskCenterItems> getItems() {
        List<TaskCenterItems> items = new ArrayList<>();
        items.add(new TaskCenterItems(1, "Assignments","Lorem Ipsum","home"));
        items.add(new TaskCenterItems(2, "Invoices","Lorem Ipsum","invoice"));
        items.add(new TaskCenterItems(3, "E-Forms","Lorem Ipsum","document"));
        return items;
    }


    //navigate to pending invoices screen
    private void seePendingInvoices() {

    }
    @Override
    public void onItemClick(int position) {
        getItems().get(position);

        if (position == 0) {
            NavDirections directions = TaskCenterFragmentDirections.actionTaskCenterFragmentToAssignmentsFragment();
            Navigation.findNavController(getView()).navigate(directions);
        } else if(position == 1) {
            NavDirections directions = TaskCenterFragmentDirections.actionTaskCenterFragmentToInvoicesFragment();
            Navigation.findNavController(getView()).navigate(directions);

        } else if(position == 2) {
            NavDirections directions = TaskCenterFragmentDirections.actionTaskCenterFragmentToEformFragment();
            Navigation.findNavController(getView()).navigate(directions);
        }
    }
}