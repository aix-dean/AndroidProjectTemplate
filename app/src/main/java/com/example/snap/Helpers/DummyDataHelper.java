package com.example.snap.Helpers;

import com.example.snap.DataModel.QuestionModel;

import java.util.ArrayList;
import java.util.HashMap;

public class DummyDataHelper {


    public static ArrayList<QuestionModel> getQuestionModels(){
        ArrayList<QuestionModel> questionModels = new ArrayList<>();
        QuestionModel name = new QuestionModel();
        name.setQuestion("Name");
        ArrayList<String> nameKeywords = new ArrayList<>();
        nameKeywords.add("name");
        nameKeywords.add("firstName");
        nameKeywords.add("first name");
        nameKeywords.add("full name");
        nameKeywords.add("fullName");
        name.setKeyWords(nameKeywords);

        QuestionModel age = new QuestionModel();
        age.setQuestion("Age");
        ArrayList<String> ageKeywords = new ArrayList<>();
        ageKeywords.add("age");
        age.setKeyWords(ageKeywords);

        QuestionModel temp = new QuestionModel();
        temp.setQuestion("Temperature");
        ArrayList<String> tempKeywords = new ArrayList<>();
        tempKeywords.add("temperature");
        temp.setKeyWords(tempKeywords);

        QuestionModel headAche = new QuestionModel();
        headAche.setQuestion("Headache");
        ArrayList<String> headAcheKeywords = new ArrayList<>();
        headAcheKeywords.add("head ache");
        headAcheKeywords.add("headache");
        headAcheKeywords.add("head pain");
        headAcheKeywords.add("headPain");
        headAcheKeywords.add("have headache");
        headAcheKeywords.add("have head pain");
        headAche.setKeyWords(headAcheKeywords);

        QuestionModel soreThroat = new QuestionModel();
        soreThroat.setQuestion("Sore Throat");
        ArrayList<String> soreThroatKeywords = new ArrayList<>();
        soreThroatKeywords.add("sore throat");
        soreThroatKeywords.add("soreThroat");
        soreThroatKeywords.add("sore throat");
        soreThroatKeywords.add("throatPain");
        soreThroatKeywords.add("have soreThroat");
        soreThroatKeywords.add("have throatPain");
        soreThroat.setKeyWords(soreThroatKeywords);

        QuestionModel bodyPain = new QuestionModel();
        bodyPain.setQuestion("Body Pain");
        ArrayList<String> bodyPainKeywords = new ArrayList<>();
        bodyPainKeywords.add("body");
        bodyPainKeywords.add("ache");
        bodyPainKeywords.add("pain");
        bodyPainKeywords.add("body pain");
        bodyPainKeywords.add("sore body");
        bodyPainKeywords.add("sore body");
        bodyPainKeywords.add("have sore body");
        bodyPainKeywords.add("have body pain");
        bodyPain.setKeyWords(bodyPainKeywords);

        QuestionModel fever = new QuestionModel();
        headAche.setQuestion("Fever");
        ArrayList<String> feverKeywords = new ArrayList<>();
        feverKeywords.add("high");
        feverKeywords.add("fever");
        feverKeywords.add("have fever");
        fever.setKeyWords(feverKeywords);


        questionModels.add(name);
        questionModels.add(age);
        questionModels.add(temp);
        questionModels.add(headAche);
        questionModels.add(soreThroat);
        questionModels.add(bodyPain);
        questionModels.add(fever);
        return questionModels;

    }

}
