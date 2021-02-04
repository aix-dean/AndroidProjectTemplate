package com.example.snap.DataModel;

public class SnapUser {
    public static final String NAME ="name";
    public static final String BIRTHDAY ="bday";
    public static final String AGE ="age";
    public static final String RESIDENCE ="residence";
    public static final String GENDER ="gender";


    private String name;
    private String email;
    private String birthday;
    private int age;
    private String residence;
    private String gender;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
