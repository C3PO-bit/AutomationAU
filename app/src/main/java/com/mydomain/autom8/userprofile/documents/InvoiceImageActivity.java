package com.mydomain.autom8.userprofile.documents;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import com.mydomain.autom8.Constants;
import com.mydomain.autom8.R;
import com.mydomain.autom8.databinding.ActivityInvoiceImageBinding;
import com.mydomain.autom8.databinding.ItemDocumentsBinding;

public class InvoiceImageActivity extends AppCompatActivity {

    private ActivityInvoiceImageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInvoiceImageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Bitmap bitmap = getIntent().getExtras().getParcelable("name");
        binding.invoiceImage.setImageBitmap(bitmap);
    }

}