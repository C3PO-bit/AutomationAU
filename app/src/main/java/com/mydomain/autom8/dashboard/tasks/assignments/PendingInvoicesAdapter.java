package com.mydomain.autom8.dashboard.tasks.assignments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mydomain.autom8.R;
import com.mydomain.autom8.dashboard.IOnClickListener;
import com.mydomain.autom8.databinding.ItemPendingInvoicesBinding;
import com.mydomain.autom8.model.PendingInvoice;
import com.mydomain.autom8.userprofile.IOnBackClickListener;

import java.util.ArrayList;
import java.util.List;

public class PendingInvoicesAdapter extends RecyclerView.Adapter<PendingInvoicesAdapter.PendingInvoicesViewHolder> {

    private List<PendingInvoice> approvedInvoices;
    private IOnClickListener onClickListener;

    public void addAll(List<PendingInvoice> invoices, IOnClickListener onClickListener) {
        approvedInvoices = new ArrayList<>();
        approvedInvoices.clear();
        approvedInvoices.addAll(invoices);
        this.onClickListener = onClickListener;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PendingInvoicesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_pending_invoices, parent, false);
        return new PendingInvoicesViewHolder(view, onClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull PendingInvoicesViewHolder holder, int position) {
        holder.bind(approvedInvoices.get(position));
    }

    @Override
    public int getItemCount() {
        return approvedInvoices.size();
    }

    static class PendingInvoicesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ItemPendingInvoicesBinding binding;
        IOnClickListener onClickListener;

        public PendingInvoicesViewHolder(@NonNull View itemView, IOnClickListener onClickListener) {
            super(itemView);
            binding = ItemPendingInvoicesBinding.bind(itemView);
            this.onClickListener = onClickListener;
            itemView.setOnClickListener(this);
        }

        public void bind(PendingInvoice invoice) {
            binding.invoiceTitle.setText(invoice.invoiceTitle);
            binding.invoiceDescription.setText(invoice.invoiceDescription);
            binding.invoicePrice.setText(invoice.invoicePrice);
            binding.invoiceDate.setText(invoice.invoiceDate);
        }


        @Override
        public void onClick(View view) {
            onClickListener.onItemClick(getAdapterPosition());

        }
    }
}
