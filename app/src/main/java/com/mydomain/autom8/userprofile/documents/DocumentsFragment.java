package com.mydomain.autom8.userprofile.documents;

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
import com.mydomain.autom8.databinding.FragmentDocumentsBinding;
import com.mydomain.autom8.model.Documents;

import java.util.ArrayList;
import java.util.List;


public class DocumentsFragment extends Fragment implements IOnClickListener {
    private FragmentDocumentsBinding binding;
    private DocumentsAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDocumentsBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupUi();
    }

    private void setupUi() {
        adapter = new DocumentsAdapter();
        binding.foldersRecyclerview.setAdapter(adapter);
        binding.foldersRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter.addAll(getDocumentItems(),this::onItemClick);
    }

    private List<Documents> getDocumentItems() {
        List<Documents> documents = new ArrayList<>();
        documents.add(new Documents(1,"Invoice images"));

        return documents;
    }

    @Override
    public void onItemClick(int position) {
        getDocumentItems().get(position);

        Intent intent = new Intent(this.getContext(),InvoiceImageActivity.class);
        startActivity(intent);
    }
}