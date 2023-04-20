package com.mydomain.autom8.dashboard.forms;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mydomain.autom8.R;
import com.mydomain.autom8.dashboard.IOnClickListener;
import com.mydomain.autom8.databinding.ItemFormsBinding;
import com.mydomain.autom8.model.Forms;

import java.util.ArrayList;
import java.util.List;

public class FormsAdapter extends RecyclerView.Adapter<FormsAdapter.FormsViewHolder> {
    private List<Forms> formsList;
    IOnClickListener onClickListener;

    public void addAll(List<Forms> forms,IOnClickListener onClickListener) {
        formsList = new ArrayList<>();
        formsList.clear();
        formsList.addAll(forms);
        this.onClickListener = onClickListener;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FormsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_forms, parent, false);
        return new FormsViewHolder(view,onClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull FormsViewHolder holder, int position) {
        holder.bind(formsList.get(position));
    }

    @Override
    public int getItemCount() {
        return formsList.size();
    }

    static class FormsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ItemFormsBinding binding;
        IOnClickListener onClickListener;

        public FormsViewHolder(@NonNull View itemView, IOnClickListener onClickListener) {
            super(itemView);
            binding = ItemFormsBinding.bind(itemView);
            this.onClickListener = onClickListener;
            itemView.setOnClickListener(this);
        }

        public void bind(Forms forms) {
            binding.cardFormTitle.setText(forms.title);
        }

        @Override
        public void onClick(View view) {
            onClickListener.onItemClick(getAdapterPosition());
        }
    }
}
