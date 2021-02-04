package com.example.snap.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.snap.Helpers.FirebaseAuthHelper;
import com.example.snap.databinding.FragmentProfileBinding;

public class ProfileFragment extends Fragment {
    private FragmentProfileBinding binder;
    private TextView nameTV;
    private TextView ageTV;
    private TextView genderTV;
    private TextView emailTV;
    private TextView residenceTV;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        System.out.println("YOU ARE NOW IN PROFILE FRAG");
        binder = FragmentProfileBinding.inflate(inflater,container,false);
        return binder.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nameTV = binder.nameValue;
        ageTV = binder.ageValue;
        genderTV = binder.genderValue;
        emailTV = binder.emailValue;
        residenceTV = binder.residenceValue;

        if(FirebaseAuthHelper.getCurrentUser() == null){

            //No current user logged in, show dialog box then go to
        }


    }
}
