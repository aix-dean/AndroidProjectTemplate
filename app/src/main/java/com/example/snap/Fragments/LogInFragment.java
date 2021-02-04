package com.example.snap.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.snap.DataModel.HTMLModel;
import com.example.snap.Helpers.HTMLIDHelper;
import com.example.snap.Interfaces.OnGoogleSignInSuccess;
import com.example.snap.Helpers.FacebookAuthHelper;
import com.example.snap.Helpers.GoogleAuthHelper;
import com.example.snap.Interfaces.OnRegistrationSuccess;
import com.example.snap.R;
import com.example.snap.databinding.FragmentLoginBinding;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.common.SignInButton;

import java.util.ArrayList;


public class LogInFragment extends Fragment implements OnRegistrationSuccess, OnGoogleSignInSuccess {
    private FragmentLoginBinding binder;
    private LoginButton loginButton;
    private SignInButton googleSignIn;
    private NavController navController;
    private TextView goToCameraFrag;
    private TextView goToWebViewFrag;

    //Helpers
    private GoogleAuthHelper googleAuthHelper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binder = FragmentLoginBinding.inflate(inflater, container, false);

        FacebookAuthHelper.registerLoginCallback(this);

        googleAuthHelper = new GoogleAuthHelper();
        googleAuthHelper.initialize(requireContext(),this);
        return binder.getRoot();

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);


        loginButton = binder.fbSignIn;
        loginButton.setReadPermissions(FacebookAuthHelper.getFbBtnPermission());
        loginButton.setFragment(this);

        googleSignIn = binder.googleSignIn;
        googleSignIn.setSize(SignInButton.SIZE_WIDE);
        googleSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(googleAuthHelper.getSignInIntent(),GoogleAuthHelper.RC_SIGN_IN);
            }
        });

        goToCameraFrag = binder.goToCameraFragmentTV;
        goToCameraFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_mainFragment_to_mainDashboardFragment);
            }
        });

        goToWebViewFrag = binder.goToWebviewFragmentTV;

        goToWebViewFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_mainFragment_to_webViewFragment);
            }
        });
        for (HTMLModel htmlModel:  HTMLIDHelper.getHtmlIds()){
            System.out.println("ID: " + htmlModel.getId() +" TYPE: " + htmlModel.getInputType() +" NAME: " + htmlModel.getName());
        }

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {


        if(requestCode == GoogleAuthHelper.RC_SIGN_IN){
            googleAuthHelper.onActivityResultGoogleSignIn(data);

        }else{
            FacebookAuthHelper.registerOnActivityResult(requestCode,resultCode,data);

        }
        super.onActivityResult(requestCode, resultCode, data);
    }





    @Override
    public void onSuccess(Bundle bundle) {

    navController.navigate(R.id.action_mainFragment_to_infoRegistrationFragment,bundle);
    }

    @Override
    public void onSuccess() {
        navController.navigate(R.id.action_mainFragment_to_infoRegistrationFragment);

    }

    @Override
    public void onUserSignIn() {

    }
}
