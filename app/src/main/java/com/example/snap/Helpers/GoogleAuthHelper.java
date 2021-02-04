package com.example.snap.Helpers;

import android.content.Context;
import android.content.Intent;

import com.example.snap.Interfaces.OnGoogleSignInSuccess;
import com.example.snap.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class GoogleAuthHelper {
    private GoogleSignInClient mGoogleSignInClient;
    private OnGoogleSignInSuccess callback;
    public static final int RC_SIGN_IN = 101;
    public void initialize(Context context,OnGoogleSignInSuccess cb){
        if(mGoogleSignInClient == null) {
                callback = cb;
                GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                        .requestIdToken(context.getString(R.string.default_web_client_id))
                        .requestEmail()
                        .build();
                mGoogleSignInClient = GoogleSignIn.getClient(context,gso);
        }



    }

    public Intent getSignInIntent(){

        return mGoogleSignInClient.getSignInIntent();
    }

    public void onActivityResultGoogleSignIn(Intent data){
        Task<GoogleSignInAccount> task =  GoogleSignIn.getSignedInAccountFromIntent(data);
        try {
            GoogleSignInAccount account = task.getResult(ApiException.class);
            if(account != null)
            FirebaseAuthHelper.handleGoogleAccessToken(account.getIdToken(),callback);


        }catch(ApiException e){


        }


    }
}
