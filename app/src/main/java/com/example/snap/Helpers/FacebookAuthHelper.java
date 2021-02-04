package com.example.snap.Helpers;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.snap.Interfaces.OnRegistrationSuccess;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;

public class FacebookAuthHelper {
    private static CallbackManager callbackManager;

    public static final String FB_NAME = "FacebookName";
    public static final String FB_EMAIL = "FacebookEmail";
    public static final String FB_BDay = "FacebookBirthDay";


    private static final String EMAIL = "email";
    private static final String PUBLIC_PROFILE = "public_profile";
    private static final String USER_BIRTHDAY = "user_birthday";

    public static boolean hasUserLoggedIn(){
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        return accessToken != null && !accessToken.isExpired();
    }
    public static Profile getCurrentProfile(){

        return Profile.getCurrentProfile();
    }

    public static void registerLoginCallback(OnRegistrationSuccess callback) {
        if(callbackManager != null) return;
        callbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        FirebaseAuthHelper.handleFacebookAccessToken(loginResult.getAccessToken(),callback);

                    }

                    @Override
                    public void onCancel() {
                    }

                    @Override
                    public void onError(FacebookException exception) {
                    }
                });

    }
    public static void registerOnActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        callbackManager.onActivityResult(requestCode, resultCode, data);

    }
    public static void getProfileDataUsingGraphRequest(AccessToken accessToken,OnRegistrationSuccess callback){
        GraphRequest request = GraphRequest.newMeRequest(accessToken,
                new GraphRequest.GraphJSONObjectCallback()
                {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        if(response.getError() != null) {
                            System.out.println("Graph Request: Error Occurred");

                        }
                        else{
                            System.out.println("Graph Request: Success");
                            String fbUserId = object.optString("id");
                            String fbUserFirstName = object.optString("name");
                            String fbUserEmail = object.optString("email");
                            String gender = object.optString("gender");
                            String birthday = object.optString("birthday");
//                            System.out.println( "Email: " + fbUserEmail + "\nName: " +fbUserFirstName +
//                                    "\nGender" +gender +"\nBirthday" +birthday+ "\nID: " + fbUserId);
                            Bundle bundle = new Bundle();
                            bundle.putSerializable(FB_NAME,fbUserFirstName);
                            bundle.putString(FB_EMAIL,fbUserEmail);
                            bundle.putString(FB_BDay,birthday);

                           String name = String.valueOf(bundle.getSerializable(FB_NAME));
                           String email = String.valueOf(bundle.getSerializable(FB_EMAIL));
                           String bday = String.valueOf(bundle.getSerializable(FB_BDay));
                            System.out.println(name +" " + email + " " + bday);

                            callback.onSuccess(bundle);

                        }
                    }
                });
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,name,email,gender, birthday");
        request.setParameters(parameters);
        request.executeAsync();

    }
    public static List<String> getFbBtnPermission(){
       return Arrays.asList(PUBLIC_PROFILE,EMAIL,USER_BIRTHDAY);
    }
}
