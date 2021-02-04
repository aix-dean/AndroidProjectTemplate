package com.example.snap.Helpers;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;

public class AppPermissionHelper {
    public static final int REQUEST_CAMERA_PERMISSION = 201;

    public static boolean cameraPermissionGranted(Context context){
        return ActivityCompat.checkSelfPermission(context, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED;
    }
    public static void requestPermission(Context context){
        ActivityCompat.requestPermissions((Activity) context,new String[]{Manifest.permission.CAMERA},REQUEST_CAMERA_PERMISSION);
    }

}
