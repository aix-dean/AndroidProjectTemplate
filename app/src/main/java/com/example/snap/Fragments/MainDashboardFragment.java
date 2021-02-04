package com.example.snap.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.snap.Activities.MainActivity;
import com.example.snap.DialogFragments.LoginRequestDialog;
import com.example.snap.Helpers.AppPermissionHelper;
import com.example.snap.Helpers.FirebaseAuthHelper;
import com.example.snap.Helpers.QRScannerHelper;
import com.example.snap.Interfaces.OnPermissionResult;
import com.example.snap.Interfaces.OnQrCodeScanned;
import com.example.snap.Interfaces.OnRequestLoginResult;
import com.example.snap.R;
import com.example.snap.databinding.FragmentMainDashboardBinding;
import com.google.android.material.navigation.NavigationView;

public class MainDashboardFragment extends Fragment implements OnPermissionResult, OnQrCodeScanned , OnRequestLoginResult {

    private FragmentMainDashboardBinding binder;
    private NavController navController;
    private SurfaceView qrScannerSV;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;


    private QRScannerHelper scannerHelper;
    public static final String SCANNED_QR = "ScannedQR";

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        MainActivity activity = (MainActivity) getActivity();
        if(activity != null)
        activity.instantiateCallBack(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binder = FragmentMainDashboardBinding.inflate(inflater,container,false);
        return binder.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        qrScannerSV = binder.qrScannerSurfaceView;
        navigationView = binder.nvView;
        drawerLayout = binder.drawerLayout;

        initNavViewAndDrawerLayout();


        scannerHelper = new QRScannerHelper();
        scannerHelper.setCallback(this);
        scannerHelper.initQRScannerPreview(requireContext(),qrScannerSV,getActivity());


    }
    LoginRequestDialog loginRequestDialog;
    private void initNavViewAndDrawerLayout(){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(drawerLayout.isDrawerOpen(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                switch (item.getItemId()){
                    case R.id.nav_menu_profile:
                        if(FirebaseAuthHelper.getCurrentUser() == null){
                            if(loginRequestDialog == null){
                                loginRequestDialog = new LoginRequestDialog();
                                loginRequestDialog.setCallback(MainDashboardFragment.this);
                                loginRequestDialog.show(getChildFragmentManager(),"Login Request");
                            }
                        }else{
                            navController.navigate(R.id.action_mainDashboardFragment_to_profileFragment);

                        }
                    break;
                    case R.id.nav_menu_settings:
                        //Go to settings fragment

                        break;


                }


                return true;
            }
        });


    }

    @Override
    public void onLoginRequestOk() {

        loginRequestDialog = null;
        navController.navigate(R.id.action_mainDashboardFragment_to_profileFragment);

    }

    @Override
    public void onResume() {
        super.onResume();
        scannerHelper.initQRScannerPreview(requireContext(),qrScannerSV,getActivity());

    }

    @Override
    public void onPermissionGranted(int requestCode) {
        if(requestCode == AppPermissionHelper.REQUEST_CAMERA_PERMISSION)
            scannerHelper.initQRScannerPreview(requireContext(),qrScannerSV,getActivity());


    }

    @Override
    public void barcodeScanned(String value) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(SCANNED_QR,value);
        navController.navigate(R.id.action_mainDashboardFragment_to_webViewFragment,bundle);
        System.out.println("BARCODE DETECTED: " + value);

    }
}
