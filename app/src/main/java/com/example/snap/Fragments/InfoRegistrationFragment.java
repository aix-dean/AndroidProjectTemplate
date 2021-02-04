package com.example.snap.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.snap.DataModel.SnapUser;
import com.example.snap.Helpers.FacebookAuthHelper;
import com.example.snap.Helpers.FireStoreRepositoryHelper;
import com.example.snap.R;
import com.example.snap.databinding.FragmentInfoRegistrationBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class InfoRegistrationFragment extends Fragment {
    private NavController navController;

    private FragmentInfoRegistrationBinding binder;
    private TextInputEditText nameET;
    private TextInputEditText bdayET;
    private TextInputEditText emailET;
    private TextInputEditText genderET;
    private TextInputEditText residenceET;
    private TextInputEditText ageET;
    private MaterialButton nextBtn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binder = FragmentInfoRegistrationBinding.inflate(inflater,container,false);
        return binder.getRoot();


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        nameET = binder.nameET;
        bdayET = binder.bdayET;
        emailET = binder.emailET;
        genderET = binder.genderET;
        residenceET = binder.residenceET;
        ageET = binder.ageET;
        nextBtn = binder.nextBtn;

        //Get Data in bundle
        if(getArguments() != null){
            String name = getArguments().getString(FacebookAuthHelper.FB_NAME);
            String email = getArguments().getString(FacebookAuthHelper.FB_EMAIL);
            String bday = getArguments().getString(FacebookAuthHelper.FB_BDay);


            //Set Data to UI
            if(name != null && !name.equals(""))
                nameET.setText(name);
            if(email != null && !email.equals(""))
                emailET.setText(email);
            if(bday != null && !bday.equals(""))
                bdayET.setText(bday);
        }

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validateValue()){
                    saveInfoToFireStore();
                    navController.navigate(R.id.action_infoRegistrationFragment_to_healthChecklistFragment,getBundle());

                }

            }
        });


    }
    private void saveInfoToFireStore(){
        String name = Objects.requireNonNull(nameET.getText()).toString().trim();
        String email = Objects.requireNonNull(emailET.getText()).toString().trim();
        String birthday = Objects.requireNonNull(bdayET.getText()).toString().trim();
        String age = Objects.requireNonNull(ageET.getText()).toString().trim();
        String residence = Objects.requireNonNull(residenceET.getText()).toString().trim();
        String gender = Objects.requireNonNull(genderET.getText()).toString().trim();

        SnapUser user = new SnapUser();
        user.setName(name);
        user.setEmail(email);
        user.setBirthday(birthday);
        user.setAge(Integer.parseInt(age));
        user.setResidence(residence);
        user.setGender(gender);

        FireStoreRepositoryHelper.saveUserInfoToFireStore(user);

    }

    private Bundle getBundle(){
        String name = Objects.requireNonNull(nameET.getText()).toString().trim();
        String birthday = Objects.requireNonNull(bdayET.getText()).toString().trim();
        String age = Objects.requireNonNull(ageET.getText()).toString().trim();
        String residence = Objects.requireNonNull(residenceET.getText()).toString().trim();
        String gender = Objects.requireNonNull(genderET.getText()).toString().trim();

        Bundle bundle = new Bundle();
        bundle.putSerializable(SnapUser.NAME,name);
        bundle.putSerializable(SnapUser.BIRTHDAY,birthday);
        bundle.putSerializable(SnapUser.AGE,age);
        bundle.putSerializable(SnapUser.RESIDENCE,residence);
        bundle.putSerializable(SnapUser.GENDER,gender);

        return bundle;


    }
    private boolean validateValue(){
        if(Objects.requireNonNull(nameET.getText()).toString().trim().equals("")){
            nameET.setError("Name is required");
            return false;
        }

        return true;
    }


}
