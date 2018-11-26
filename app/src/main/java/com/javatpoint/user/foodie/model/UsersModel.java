package com.javatpoint.user.foodie.model;

public class UsersModel {
    private String Name;
    private String Password;
    private String Email_ID;
    private String Phone_Number;

    public UsersModel() {
    }

    public UsersModel(String phone_no, String name, String password, String email_ID) {
        Name = name;
        Password = password;
        Email_ID = email_ID;
        Phone_Number = phone_no;

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail_ID() {
        return Email_ID;
    }

    public void setEmail_ID(String email_ID) {
        Email_ID = email_ID;
    }

    public String getPhone_Number() {
        return Phone_Number;
    }

    public void setPhone_Number(String phone_Number) {
        Phone_Number = phone_Number;
    }
}
