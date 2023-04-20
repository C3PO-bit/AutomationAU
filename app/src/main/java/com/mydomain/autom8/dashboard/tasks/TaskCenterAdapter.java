package com.mydomain.autom8.dashboard.tasks;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.mydomain.autom8.R;
import com.mydomain.autom8.dashboard.IOnClickListener;
import com.mydomain.autom8.databinding.ItemTaskCenterBinding;
import com.mydomain.autom8.model.TaskCenterItems;

import java.util.ArrayList;
import java.util.List;

public class TaskCenterAdapter extends RecyclerView.Adapter<TaskCenterAdapter.TaskViewHolder> {

    private List<TaskCenterItems> items;
    private IOnClickListener onClickListener;

    public void addAll(List<TaskCenterItems> itemsList, IOnClickListener onClickListener) {
        items = new ArrayList<>();
        items.clear();
        items.addAll(itemsList);
        this.onClickListener = onClickListener;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_task_center, parent, false);
        return new TaskViewHolder(view,onClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class TaskViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ItemTaskCenterBinding binding;
        IOnClickListener onClickListener;

        public TaskViewHolder(@NonNull View itemView, IOnClickListener onClickListener) {
            super(itemView);
            binding = ItemTaskCenterBinding.bind(itemView);
            this.onClickListener = onClickListener;
          itemView.setOnClickListener(this);
        }

        public void bind(TaskCenterItems taskCenterItems) {
            binding.cardTitle.setText(taskCenterItems.titleName);
            binding.cardSubtitle.setText(taskCenterItems.subtitle);
            binding.cardIcon.setImageDrawable(getImage(taskCenterItems.iconName));
        }

        private Drawable getImage(String imageName) {
            Context context = binding.cardIcon.getContext();
            Resources resources = context.getResources();
            final int resourceId = resources.getIdentifier(imageName, "drawable",
                    context.getPackageName());
            return ContextCompat.getDrawable(context, resourceId);
        }

        @Override
        public void onClick(View view) {
            onClickListener.onItemClick(getAdapterPosition());
        }
    }
}
