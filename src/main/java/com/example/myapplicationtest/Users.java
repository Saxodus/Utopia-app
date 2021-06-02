package com.example.myapplicationtest;

import com.google.gson.annotations.SerializedName;

public class Users {


    @SerializedName("id")
    private int userID;

    public int getUserID() {
        return userID;
    }
}
