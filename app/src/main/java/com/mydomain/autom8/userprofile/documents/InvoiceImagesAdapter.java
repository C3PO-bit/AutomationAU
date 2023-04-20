package com.mydomain.autom8.userprofile.documents;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mydomain.autom8.databinding.ActivityInvoiceImageBinding;
import com.mydomain.autom8.model.InvoiceImage;

public class InvoiceImagesAdapter extends RecyclerView.Adapter<InvoiceImagesAdapter.InvoiceViewHolder> {


     @NonNull
     @Override
     public InvoiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         return null;
     }

     @Override
     public void onBindViewHolder(@NonNull InvoiceViewHolder holder, int position) {

     }

     @Override
     public int getItemCount() {
         return 0;
     }

     class InvoiceViewHolder extends RecyclerView.ViewHolder {

         private ActivityInvoiceImageBinding binding;

         public InvoiceViewHolder(@NonNull View itemView) {
             super(itemView);
             binding = ActivityInvoiceImageBinding.bind(itemView);
         }


     }

}
