package com.example.snap.RecyclerViewAdapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.snap.DataModel.ChecklistQuestionModel;
import com.example.snap.R;

import java.util.ArrayList;

public class SymptomsRVAdapter extends RecyclerView.Adapter<SymptomsRVAdapter.CheckListViewHolder> {
    private ArrayList<ChecklistQuestionModel> questionModels;


    public SymptomsRVAdapter(ArrayList<ChecklistQuestionModel> questionModels) {
        this.questionModels = questionModels;
    }

    @NonNull
    @Override
    public CheckListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_health_checklist_1,parent,false);
        return new CheckListViewHolder(layout);

    }

    @Override
    public void onBindViewHolder(@NonNull CheckListViewHolder holder, int position) {
        ChecklistQuestionModel checklistQuestionModel = questionModels.get(position);
        holder.numTV.setText(checklistQuestionModel.getNumber());
        holder.questionTV.setText(checklistQuestionModel.getQuestion());
        holder.questionDescTV.setText(checklistQuestionModel.getQuestionDesc());

        holder.bind();
    }

    @Override
    public int getItemCount() {
        return  questionModels.size();

    }

    class CheckListViewHolder extends RecyclerView.ViewHolder{
        private TextView numTV;
        private TextView questionTV;
        private TextView questionDescTV;
        private CheckBox yesCb;
        private CheckBox noCb;
        public CheckListViewHolder(@NonNull View itemView) {
            super(itemView);
            numTV = itemView.findViewById(R.id.letterOfSymptomTV);
            questionTV = itemView.findViewById(R.id.nameOfSymptomTV);
            questionDescTV = itemView.findViewById(R.id.symptomDescTV);

            yesCb = itemView.findViewById(R.id.yesCb);
            noCb = itemView.findViewById(R.id.noCb);
        }

        public void bind(){

            noCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if(b){
                        if(yesCb.isChecked())
                            yesCb.setChecked(false);
                    }
                }
            });
            yesCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if(b){
                        if(noCb.isChecked())
                            noCb.setChecked(false);
                    }
                }
            });

        }
    }
}
