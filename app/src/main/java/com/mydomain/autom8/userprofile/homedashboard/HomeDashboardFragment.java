package com.mydomain.autom8.userprofile.homedashboard;

import static android.app.Activity.RESULT_OK;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.Toolbar;

import com.mydomain.autom8.Constants;
import com.mydomain.autom8.R;
import com.mydomain.autom8.dashboard.IOnClickListener;
import com.mydomain.autom8.databinding.FragmentHomeDashboardBinding;
import com.mydomain.autom8.model.Dashboard;
import com.mydomain.autom8.model.InvoiceImage;
import com.mydomain.autom8.userprofile.documents.InvoiceImageActivity;

import java.util.ArrayList;
import java.util.List;


public class HomeDashboardFragment extends Fragment implements IOnClickListener {



    private FragmentHomeDashboardBinding binding;
    private DashboardAdapter adapter;

    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeDashboardBinding.inflate(inflater);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupUi();
        statusBarTextColor();
    }


    //set status bar text color
    private void statusBarTextColor() {
        getActivity().getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
    }

    //main method that will display all the items in the main dashboard screen
    private void setupUi() {
        adapter = new DashboardAdapter();
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        adapter.addAll(getDashboardItems(),this::onItemClick);
        navigateToPendingInvoices();
        openCamera();
    }


    //open camera
    private void openCamera() {
        binding.cameraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
            Bitmap imageData = null;
            if (resultCode == RESULT_OK) {
                imageData = (Bitmap) data.getExtras().get("data");
                Intent intent = new Intent(this.getContext(),InvoiceImageActivity.class);
                intent.putExtra("name",imageData);
                startActivity(intent);
            }
        }
    }

    //List of items that are visible in the dashboard screen
    public List<Dashboard> getDashboardItems() {
        List<Dashboard> dashboardList = new ArrayList<>();
        dashboardList.add(new Dashboard(1, "file","SUBMIT FORMS",R.color.teal_200 ));
        dashboardList.add(new Dashboard(2, "submitted_form","SUBMITTED FORMS", R.color.end_color));
        dashboardList.add(new Dashboard(3, "task","TASK CENTER", R.color.start_color2));
        dashboardList.add(new Dashboard(4, "report","REPORT CENTER", R.color.end_color2));
        return dashboardList;
    }


    //navigate from pending invoices container to pending invoice list
    private void navigateToPendingInvoices() {
        binding.pendingInvoiceContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavDirections directions = HomeDashboardFragmentDirections.actionHomeDashboardFragmentToAssignmentsFragment();
                Navigation.findNavController(getView()).navigate(directions);
            }
        });
    }



    //navigate from dashboard to fragments
    @Override
    public void onItemClick(int position) {
        getDashboardItems().get(position);

        if (position == 0) {
            NavDirections directions = HomeDashboardFragmentDirections.actionHomeDashboardFragmentToFormsFragment();
            Navigation.findNavController(getView()).navigate(directions);

        } else if (position == 1) {
            NavDirections directions = HomeDashboardFragmentDirections.actionHomeDashboardFragmentToSubmittedFormsFragment();
            Navigation.findNavController(getView()).navigate(directions);
        } else if(position == 2) {
            NavDirections directions = HomeDashboardFragmentDirections.actionHomeDashboardFragmentToTaskCenterFragment();
            Navigation.findNavController(getView()).navigate(directions);
        } else if (position == 3) {
            NavDirections directions = HomeDashboardFragmentDirections.actionHomeDashboardFragmentToReportCenterFragment();
            Navigation.findNavController(getView()).navigate(directions);
        }
    }


}