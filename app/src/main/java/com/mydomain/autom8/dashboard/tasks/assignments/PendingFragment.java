package com.mydomain.autom8.dashboard.tasks.assignments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mydomain.autom8.dashboard.IOnClickListener;
import com.mydomain.autom8.databinding.FragmentPendingBinding;
import com.mydomain.autom8.model.PendingInvoice;

import java.util.ArrayList;
import java.util.List;


public class PendingFragment extends Fragment  implements IOnClickListener {
    private FragmentPendingBinding binding;
    private PendingInvoicesAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentPendingBinding.inflate(inflater,container,false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupUi();
    }

    private void setupUi() {
        adapter =  new PendingInvoicesAdapter();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(adapter);
        adapter.addAll(getInvoices(),this::onItemClick);
    }


    private List<PendingInvoice> getInvoices() {
        List<PendingInvoice> invoices = new ArrayList<>();
        invoices.add(new PendingInvoice(0, "Invoice 1","Description for invoice 1","124$","02 May,2022"));
        return invoices;
    }


    @Override
    public void onItemClick(int position) {
        getInvoices().get(position);

        Intent intent = new Intent(this.getContext(),InvoiceActivity.class);
        startActivity(intent);
    }
}