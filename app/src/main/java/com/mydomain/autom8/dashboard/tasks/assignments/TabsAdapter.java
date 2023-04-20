package com.mydomain.autom8.dashboard.tasks.assignments;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class TabsAdapter extends FragmentStateAdapter {

    private String[] tabs = {"Pending","Approved","Rejected"};

    public TabsAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
       switch (position) {
           case 0:
               return new PendingFragment();
           case 1:
               return new ApprovedFragment();
           case 2:
               return new RejectFragment();
           default:
               return null;
       }
    }

    @Override
    public int getItemCount() {
        return tabs.length;
    }
}
