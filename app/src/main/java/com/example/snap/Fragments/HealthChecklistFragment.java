package com.example.snap.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.snap.DataModel.CheckListAnswerModel;
import com.example.snap.DataModel.SnapUser;
import com.example.snap.Helpers.ChecklistQuestionHelper;
import com.example.snap.Helpers.FireStoreRepositoryHelper;
import com.example.snap.Interfaces.OnChecklistSubmittion;
import com.example.snap.R;
import com.example.snap.RecyclerViewAdapters.ChecklistRVAdapter;
import com.example.snap.RecyclerViewAdapters.ChecklistWithETRVAdapter;
import com.example.snap.RecyclerViewAdapters.SymptomsRVAdapter;
import com.example.snap.databinding.FragmentHealthChecklistBinding;

import java.util.Objects;

public class HealthChecklistFragment extends Fragment implements OnChecklistSubmittion {
    private FragmentHealthChecklistBinding binder;
    private RecyclerView healthChecklistRV;
    private CheckBox officialVisitCb;
    private CheckBox personalVisitCb;
    private EditText companyNameET;
    private EditText companyAddressET;
    private EditText nameET;
    private EditText residenceET;
    private EditText ageET;
    private EditText sexET;
    private EditText temperatureET;
    private Button submitBtn;


    private NavController navController;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binder = FragmentHealthChecklistBinding.inflate(inflater, container, false);
        return binder.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        nameET = binder.nameET;
        residenceET = binder.residenceET;
        ageET = binder.ageET;
        sexET = binder.sexET;
        temperatureET = binder.temperatureET;
        healthChecklistRV = binder.healthCheckListRV;
        officialVisitCb = binder.officialVisitCb;
        personalVisitCb = binder.personalVisitCb;
        companyNameET = binder.companyNameET;
        companyAddressET = binder.companyAddressET;
        submitBtn = binder.submitChecklistBtn;
        companyNameET.setEnabled(false);
        companyAddressET.setEnabled(false);

        setBundleDataToUI();
        initClickListeners();
        initHealthChecklistRV();


    }

    @Override
    public void onSubmit() {
        navController.popBackStack();
    }

    private void setBundleDataToUI() {
        if(getArguments() == null) return;
        nameET.setText(getArguments().getString(SnapUser.NAME,""));
        sexET.setText(getArguments().getString(SnapUser.GENDER,""));
        residenceET.setText(getArguments().getString(SnapUser.RESIDENCE,""));
        ageET.setText(getArguments().getString(SnapUser.AGE,""));
        sexET.setText(getArguments().getString(SnapUser.GENDER,""));

    }

    private void initHealthChecklistRV() {
        ChecklistRVAdapter questionOne = new ChecklistRVAdapter(ChecklistQuestionHelper.getQuestionOne());
        SymptomsRVAdapter symptoms = new SymptomsRVAdapter(ChecklistQuestionHelper.getSymptomsList());
        ChecklistRVAdapter questions = new ChecklistRVAdapter(ChecklistQuestionHelper.getQCheckList());
        ChecklistWithETRVAdapter questionsWithET = new ChecklistWithETRVAdapter(ChecklistQuestionHelper.getListWithSpecifyAnswer());
        ConcatAdapter concatAdapter = new ConcatAdapter();
        concatAdapter.addAdapter(questionOne);
        concatAdapter.addAdapter(symptoms);
        concatAdapter.addAdapter(questions);
        concatAdapter.addAdapter(questionsWithET);

        healthChecklistRV.setAdapter(concatAdapter);


    }

    private void initClickListeners() {

        personalVisitCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    if (officialVisitCb.isChecked())
                        officialVisitCb.setChecked(false);
                } else {
                    companyNameET.setEnabled(false);
                    companyAddressET.setEnabled(false);

                }
            }
        });
        officialVisitCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    if (personalVisitCb.isChecked())
                        personalVisitCb.setChecked(false);


                }
                companyNameET.setEnabled(b);
                companyAddressET.setEnabled(b);
            }
        });

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compileUIValues();
            }
        });

    }


    //A function that accesses the checkbox of the RecyclerView
    private Comparable<Boolean> getValueOfCheckBoxFromRV(int pos) {
        RecyclerView.ViewHolder vh = healthChecklistRV.findViewHolderForAdapterPosition(pos);
        if (vh != null) {
            CheckBox yesCb = vh.itemView.findViewById(R.id.yesCb);
            CheckBox noCb = vh.itemView.findViewById(R.id.noCb);

            if (yesCb.isChecked() && !noCb.isChecked())
                return true;
            else if (noCb.isChecked() && !yesCb.isChecked())
                return false;

        }


        return null;
    }

    private void compileUIValues() {
        Boolean hasSoreThroat = (Boolean) getValueOfCheckBoxFromRV(1);
        Boolean hasBodyPain = (Boolean) getValueOfCheckBoxFromRV(2);
        Boolean hasHeadache = (Boolean) getValueOfCheckBoxFromRV(3);
        Boolean hasFeverLastFewDays = (Boolean) getValueOfCheckBoxFromRV(4);
        Boolean haveWrkdTgtherWaCovidPerson = (Boolean) getValueOfCheckBoxFromRV(5);
        Boolean haveContactWaCovidPerson = (Boolean) getValueOfCheckBoxFromRV(6);
        Boolean travelledOutsideOfPH = (Boolean) getValueOfCheckBoxFromRV(7);
        Boolean travelledAnywhereInNcr = (Boolean) getValueOfCheckBoxFromRV(8);
        Boolean haveASideline = (Boolean) getValueOfCheckBoxFromRV(9);
        Boolean haveGoneToWetMarket = (Boolean) getValueOfCheckBoxFromRV(10);

        if (hasSoreThroat == null ||
                hasBodyPain == null ||
                hasHeadache == null ||
                hasFeverLastFewDays == null ||
                haveWrkdTgtherWaCovidPerson == null ||
                haveContactWaCovidPerson == null ||
                travelledOutsideOfPH == null ||
                travelledAnywhereInNcr == null ||
                haveASideline == null ||
                haveGoneToWetMarket == null) {
            Toast.makeText(getContext(), "Please check if all checkbox have input", Toast.LENGTH_SHORT).show();
        } else {


            boolean isValid;
            boolean isValid1;
            boolean isValid2;

            if (travelledAnywhereInNcr.equals(true))
                isValid = validateEditText(Objects.requireNonNull(getEditTxtFromRV(8)));
                else
            isValid =true;

            if (haveASideline.equals(true))
                isValid1 = validateEditText(Objects.requireNonNull(getEditTxtFromRV(9)));
            else
                isValid1 = true;

            if (haveGoneToWetMarket.equals(true))
                 isValid2 = validateEditText(Objects.requireNonNull(getEditTxtFromRV(10)));
            else
                isValid2 = true;

            if(!isValid || !isValid1 || !isValid2)
                return;


            CheckListAnswerModel checkList = new CheckListAnswerModel();
            checkList.setName(nameET.getText().toString().trim());
            checkList.setResidence(residenceET.getText().toString().trim());
            checkList.setAge(ageET.getText().toString().trim());
            checkList.setTemperature(Integer.parseInt(temperatureET.getText().toString().trim()));
            checkList.setSex(sexET.getText().toString().trim());

            String natureOfVisit = "";
            if(officialVisitCb.isChecked()){
                natureOfVisit = CheckListAnswerModel.OFFICIAL_VISIT;
                checkList.setCompanyName(companyNameET.getText().toString().trim());
                checkList.setCompanyAddress(companyAddressET.getText().toString().trim());
            }else if(personalVisitCb.isChecked()){
                natureOfVisit =CheckListAnswerModel.PERSONAL_VISIT;
                checkList.setCompanyName("");
                checkList.setCompanyAddress("");

            }

            checkList.setNatureOfVisit(natureOfVisit);
            checkList.setTemperature(Integer.parseInt(temperatureET.getText().toString().trim()));
            checkList.setHasSoreThroat(hasSoreThroat);
            checkList.setHasBodyPains(hasBodyPain);
            checkList.setHasHeadache(hasHeadache);
            checkList.setHasFeverPastFewDays(hasFeverLastFewDays);
            checkList.setHaveWorkedInSameEnvtOfConfmCase(haveWrkdTgtherWaCovidPerson);
            checkList.setHaveHadContactWithSymptoms(haveContactWaCovidPerson);
            checkList.setHasTraveledOutsideOfPh(travelledOutsideOfPH);
            checkList.setHaveTravelledAroundNcr(travelledAnywhereInNcr);
            checkList.setHaveTravelledArndNcrAnswer(Objects.requireNonNull(getEditTxtFromRV(8)).getText().toString().trim());
            checkList.setHaveASLineOfDlvry(haveASideline);
            checkList.setHaveASLineOfDlvryAnswer(Objects.requireNonNull(getEditTxtFromRV(9)).getText().toString().trim());
            checkList.setHaveGoneToWetMarket(haveGoneToWetMarket);
            checkList.setHaveGoneToWetMarketAnswer(Objects.requireNonNull(getEditTxtFromRV(10)).getText().toString().trim());


            FireStoreRepositoryHelper.saveHeathChecklistToFireStore(checkList,this);


        }


    }

    private boolean validateEditText(EditText editText) {
        if (editText.getText().toString().trim().equals("")) {
            editText.setError("Field is required");
            return false;
        }

        return true;
    }

    private EditText getEditTxtFromRV(int pos) {
        RecyclerView.ViewHolder vh = healthChecklistRV.findViewHolderForAdapterPosition(pos);
        if (vh != null) {
            return vh.itemView.findViewById(R.id.specifyAnswerET);
        }

        return null;
    }
}
