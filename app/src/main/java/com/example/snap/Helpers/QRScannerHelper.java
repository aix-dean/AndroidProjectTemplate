package com.example.snap.Helpers;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

import com.example.snap.Interfaces.OnQrCodeScanned;
import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import java.io.IOException;

public class QRScannerHelper {
    private BarcodeDetector barcodeDetector;
    private CameraSource cameraSource;
    private OnQrCodeScanned callback;

    @SuppressLint("MissingPermission")
    public void initQRScannerPreview(Context context, SurfaceView surfaceView, Activity activity){
        try {
            if(cameraSource != null) return;

                barcodeDetector = new BarcodeDetector.Builder(context)
                    .setBarcodeFormats(Barcode.ALL_FORMATS)
                    .build();

            cameraSource = new CameraSource.Builder(context,barcodeDetector)
                    .setRequestedPreviewSize(1920,1080)
                    .setRequestedFps(60.0F)
                    .setAutoFocusEnabled(true).build();

            surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
                @Override
                public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {

                }
                @Override
                public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {
                    if(AppPermissionHelper.cameraPermissionGranted(context)){
                        try {
                            cameraSource.start(surfaceHolder);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }else{
                        AppPermissionHelper.requestPermission(context);
                    }
                }

                @Override
                public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
                    if(AppPermissionHelper.cameraPermissionGranted(context)){
                        try {

                            cameraSource.release();
                            cameraSource.stop();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }else{
                        AppPermissionHelper.requestPermission(context);
                    }
                }
            });


            barcodeDetector.setProcessor(new Detector.Processor<Barcode>() {
                @Override
                public void release() {

                }

                @Override
                public void receiveDetections(@NonNull Detector.Detections<Barcode> detections) {
                    final SparseArray<Barcode> barcodeSparseArray = detections.getDetectedItems();
                    if(barcodeSparseArray.size() != 0){
                        String scannedValue = barcodeSparseArray.valueAt(0).displayValue;
                        barcodeDetector.release();


                        activity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if(callback != null)
                                    callback.barcodeScanned(scannedValue);
                                else
                                    System.out.println("Error sending scanned value; 'OnQrCodeScanned' is null");
                                cameraSource.release();
                                cameraSource.stop();

                            }
                        });


                    }

                }
            });


        }catch (Exception e){
            System.out.println("Initializing QR Scanner preview exception: " + e.getMessage());
        }

    }

    public void setCallback(OnQrCodeScanned callback) {
        this.callback = callback;
    }
}
