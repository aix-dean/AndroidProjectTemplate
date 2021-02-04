package com.example.snap.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;

import com.example.snap.Helpers.AppPermissionHelper;
import com.example.snap.Helpers.FireStoreRepositoryHelper;
import com.example.snap.Interfaces.OnPermissionResult;
import com.example.snap.R;
import com.facebook.FacebookSdk;
import com.google.firebase.BuildConfig;

import java.security.MessageDigest;
import java.security.Permission;

public class MainActivity extends AppCompatActivity {
    private OnPermissionResult cb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FireStoreRepositoryHelper.enableFireStoreOfflinePersistence();


        setContentView(R.layout.activity_main);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == AppPermissionHelper.REQUEST_CAMERA_PERMISSION){
            if(permissions[0].equals(Manifest.permission.CAMERA)){
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    cb.onPermissionGranted(AppPermissionHelper.REQUEST_CAMERA_PERMISSION);
                }

            }


        }

    }
    public void instantiateCallBack(OnPermissionResult callback){
        this.cb = callback;
    }
}