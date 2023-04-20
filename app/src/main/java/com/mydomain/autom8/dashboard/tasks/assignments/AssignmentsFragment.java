package com.mydomain.autom8.dashboard.tasks.assignments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.mydomain.autom8.R;
import com.mydomain.autom8.databinding.FragmentAssignmentsBinding;

public class AssignmentsFragment extends Fragment {

    private FragmentAssignmentsBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAssignmentsBinding.inflate(inflater,container,false);
        return binding.getRoot();

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupUi();
    }

    //tab layout
    private void setupUi() {

        TabLayout tabLayout = binding.tablayout;
        String[] titles = new String[] {"Pending","Approved","Rejected"};
        ViewPager2 viewPager2 = binding.viewPager;
        TabsAdapter adapter = new TabsAdapter(getActivity());
        viewPager2.setAdapter(adapter);

        new TabLayoutMediator(tabLayout,viewPager2,((tab, position) -> tab.setText(titles[position]))).attach();


    }


}