package com.mydomain.autom8.userprofile.documents;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mydomain.autom8.R;
import com.mydomain.autom8.dashboard.IOnClickListener;
import com.mydomain.autom8.databinding.ItemDocumentsBinding;
import com.mydomain.autom8.model.Documents;

import java.util.ArrayList;
import java.util.List;

public class DocumentsAdapter extends RecyclerView.Adapter<DocumentsAdapter.DocumentsViewHolder> {

    private List<Documents> documentsList;
    private IOnClickListener onClickListener;
    public void addAll(List<Documents> documents,IOnClickListener onClickListener) {
        documentsList = new ArrayList<>();
        documentsList.clear();
        documentsList.addAll(documents);
        this.onClickListener = onClickListener;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DocumentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_documents, parent, false);
        return new DocumentsViewHolder(view,onClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull DocumentsViewHolder holder, int position) {
        holder.bind(documentsList.get(position));
    }

    @Override
    public int getItemCount() {
        return documentsList.size();
    }

    class DocumentsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ItemDocumentsBinding binding;
        IOnClickListener onClickListener;
        public DocumentsViewHolder(@NonNull View itemView,IOnClickListener onClickListener) {
            super(itemView);
            binding = ItemDocumentsBinding.bind(itemView);
            this.onClickListener = onClickListener;
            itemView.setOnClickListener(this);
        }

        public void bind(Documents documents) {
            binding.itemText.setText(documents.folder_name);
        }

        @Override
        public void onClick(View view) {
            onClickListener.onItemClick(getAdapterPosition());
        }
    }
}
