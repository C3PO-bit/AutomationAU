package com.mydomain.autom8.userprofile.homedashboard;

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
import com.mydomain.autom8.databinding.ItemDashboardBinding;
import com.mydomain.autom8.model.Dashboard;

import java.util.ArrayList;
import java.util.List;

public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.DashboardViewHolder> {

    private List<Dashboard> dashboardList;
    private IOnClickListener onClickListener;

    public void addAll(List<Dashboard> dashboards, IOnClickListener onClickListener) {
        dashboardList = new ArrayList<>();
        dashboardList.clear();
        dashboardList.addAll(dashboards);
        this.onClickListener = onClickListener;
        notifyDataSetChanged();

    }
    @NonNull
    @Override
    public DashboardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_dashboard,parent,false);
        return new DashboardViewHolder(view,onClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull DashboardViewHolder holder, int position) {
        holder.bind(dashboardList.get(position));
    }

    @Override
    public int getItemCount() {
        return dashboardList.size();
    }

    static class DashboardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ItemDashboardBinding binding;
        IOnClickListener onClickListener;
        public DashboardViewHolder(@NonNull View itemView, IOnClickListener onClickListener) {
            super(itemView);
            binding = ItemDashboardBinding.bind(itemView);
            this.onClickListener = onClickListener;
            itemView.setOnClickListener(this);

        }

        public void bind(Dashboard dashboard) {

            binding.icon.setImageDrawable(getImage(dashboard.itemIcon));
            binding.description.setText(dashboard.itemDescription);
        }
        private Drawable getImage(String imageName) {
            Context context = binding.icon.getContext();
                    Resources resources = context.getResources();
            final int resourceId = resources.getIdentifier(imageName, "drawable",
                    context.getPackageName());
            return ContextCompat.getDrawable(context,resourceId);
        }


        @Override
        public void onClick(View view) {
            onClickListener.onItemClick(getAdapterPosition());
        }
    }

}
