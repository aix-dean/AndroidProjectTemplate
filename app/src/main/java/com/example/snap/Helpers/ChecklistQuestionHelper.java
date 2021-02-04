package com.example.snap.Helpers;

import com.example.snap.DataModel.ChecklistQuestionModel;

import java.util.ArrayList;

public class ChecklistQuestionHelper {

    public static ArrayList<ChecklistQuestionModel> getQCheckList(){
        ArrayList<ChecklistQuestionModel> questionModels = new ArrayList<>();



        //Question 2 Contact Trace
        ChecklistQuestionModel q5 = new ChecklistQuestionModel();
        q5.setNumber("2.");
        q5.setQuestion("Have you worked together or stayed in the same close environment of a confirmed" +
                " COVID-19 case?");
        q5.setQuestionDesc("(May kasama ka ba o nakatrabahong tao na kumpirmadong may COVID-19/may impeksyon ng coronavirus)");
        ChecklistQuestionModel q6 = new ChecklistQuestionModel();
        q6.setNumber("3.");
        q6.setQuestion("Have you had any contact with anyone with fever,cough,colds and sore throat in the past 2 weeks?");
        q6.setQuestionDesc("(Mayroon ka bang nakasama na may lagnat. ubo, sipon o sakit ng lalamunan sa nakalipas ng dalawang(2)lingo)");
        ChecklistQuestionModel q7 = new ChecklistQuestionModel();
        q7.setNumber("4.");
        q7.setQuestion("Have you travelled outside of the Philippines in the last 14 days?");
        q7.setQuestionDesc("(Ikaw ba ay nagbyahe sa labas ng Pilipinas sa nakalipas na 14 na araw)");


        questionModels.add(q5);
        questionModels.add(q6);
        questionModels.add(q7);

        return questionModels;

    }

    public static ArrayList<ChecklistQuestionModel> getListWithSpecifyAnswer(){
        ArrayList<ChecklistQuestionModel> questionModels = new ArrayList<>();
        //Question 1 Symptoms question
        ChecklistQuestionModel q1 = new ChecklistQuestionModel();
        q1.setNumber("5.");
        q1.setQuestion("Have you travelled to any area in NCR aside from your home?");
        q1.setQuestionDesc("Specify(Sabihin kung saan)");
        ChecklistQuestionModel q2 = new ChecklistQuestionModel();
        q2.setNumber("6.");
        q2.setQuestion("Sino sa inyo and nagsideline ng grab/lalamove(kotse, bisikleta,motorsiklo) " +
                "o iba pang pagdedeliver noong nakaraang dalawang (2) buwan simula noong lockdown");
        q2.setQuestionDesc("Specify (Sabihin kung sino)");
        ChecklistQuestionModel q3 = new ChecklistQuestionModel();
        q3.setNumber("7.");
        q3.setQuestion("Sino sa inyo ang mga namamalengke? Kailan ang huling petsa na kayo ay namalengke.");
        q3.setQuestionDesc("Petsa");

        questionModels.add(q1);
        questionModels.add(q2);
        questionModels.add(q3);
        return questionModels;

    }
    public static ArrayList<ChecklistQuestionModel> getSymptomsList(){
        ArrayList<ChecklistQuestionModel> questionModels = new ArrayList<>();


        //Question 1 Symptoms question
        ChecklistQuestionModel q1 = new ChecklistQuestionModel();
        q1.setNumber("a.");
        q1.setQuestion("Sore Throat");
        q1.setQuestionDesc("(pananakit ng lalamunan/masakit lumunok)");
        ChecklistQuestionModel q2 = new ChecklistQuestionModel();
        q2.setNumber("b.");
        q2.setQuestion("Body Pains");
        q2.setQuestionDesc("(pananakit ng katawan)");
        ChecklistQuestionModel q3 = new ChecklistQuestionModel();
        q3.setNumber("c.");
        q3.setQuestion("Headache");
        q3.setQuestionDesc("(pananakit ng katawan)");
        ChecklistQuestionModel q4 = new ChecklistQuestionModel();
        q4.setNumber("d.");
        q4.setQuestion("Fever for the past few days");
        q4.setQuestionDesc("(Lagnat sa nakalipas na mga araw)");
        questionModels.add(q1);
        questionModels.add(q2);
        questionModels.add(q3);
        questionModels.add(q4);

        return questionModels;

    }
    public static ArrayList<ChecklistQuestionModel> getQuestionOne(){
            ArrayList<ChecklistQuestionModel> questionModels = new ArrayList<>();
            ChecklistQuestionModel model = new ChecklistQuestionModel();
            model.setNumber("1.");
            model.setQuestion("Are you experiencing:");
            model.setQuestionDesc("(nakakaranas ka ba ng:)");
            questionModels.add(model);
            return questionModels;


    }
}
