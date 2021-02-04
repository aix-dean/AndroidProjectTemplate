package com.example.snap.DialogFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.snap.Interfaces.OnRequestLoginResult;
import com.example.snap.databinding.DialogRequestUserLoginBinding;
import com.google.android.material.button.MaterialButton;

public class LoginRequestDialog extends DialogFragment {
    private DialogRequestUserLoginBinding binder;
    private MaterialButton okBtn;
    private MaterialButton cancelBtn;
    private OnRequestLoginResult callback;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binder = DialogRequestUserLoginBinding.inflate(inflater,container,false);
        return binder.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        okBtn = binder.okBtn;
        cancelBtn = binder.cancelBtn;


        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.onLoginRequestOk();
            }
        });
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getDialog() != null)
                    getDialog().dismiss();
            }
        });
    }

    public void setCallback(OnRequestLoginResult callback) {
        this.callback = callback;
    }
}
