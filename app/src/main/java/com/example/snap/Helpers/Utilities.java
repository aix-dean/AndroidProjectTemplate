package com.example.snap.Helpers;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;

import java.security.MessageDigest;

public class Utilities {


    private static String generateKeyHash(Context context) {
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = (MessageDigest.getInstance("SHA"));
                md.update(signature.toByteArray());
                return new String(Base64.encode(md.digest(), 0));
            }
        }catch (Exception e) {
            Log.e("exception", e.toString());
        }
        return "key hash not found";
    }
}
