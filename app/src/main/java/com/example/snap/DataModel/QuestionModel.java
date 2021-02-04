package com.example.snap.DataModel;

import java.util.ArrayList;

public class QuestionModel {
    private String question;
    private Object answer;
    private String answerType;
    private ArrayList<String> keyWords;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList<String> getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(ArrayList<String> keyWords) {
        this.keyWords = keyWords;
    }

    public void setAnswer(Object answer) {
        this.answer = answer;
    }

    public void setAnswerType(String answerType) {
        this.answerType = answerType;
    }
}
