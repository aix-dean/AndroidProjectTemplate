package com.example.snap.Helpers;

import androidx.annotation.NonNull;

import com.example.snap.Interfaces.OnGoogleSignInSuccess;
import com.example.snap.Interfaces.OnRegistrationSuccess;
import com.facebook.AccessToken;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import java.util.Objects;

public class FirebaseAuthHelper {
    private static final FirebaseAuth mAuth = FirebaseAuth.getInstance();



    public static void handleFacebookAccessToken(AccessToken token, OnRegistrationSuccess callback) {
        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            if(task.getResult() != null){
                                if(Objects.requireNonNull(task.getResult().getAdditionalUserInfo()).isNewUser())
                                    FacebookAuthHelper.getProfileDataUsingGraphRequest(token,callback);
                                else{
                                    System.out.println("User in not new ");
                                }
                            }


                        }
                    }
                });
    }
    public static void handleGoogleAccessToken(String idToken, OnGoogleSignInSuccess cb){
        System.out.println("Handling Google Access Token");
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        mAuth.signInWithCredential(credential)
               .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull Task<AuthResult> task) {
                       if(task.getException() == null){
                           if(task.getResult() != null){
                               if(task.getResult().getAdditionalUserInfo().isNewUser())
                               cb.onSuccess();
                               else
                               System.out.println("Google Sign: User is not new");
                           }

                       }
                       else
                           System.out.println(task.getException().getMessage());
                   }
               });



    }
    public static FirebaseUser getCurrentUser(){
            return mAuth.getCurrentUser();
    }

}
