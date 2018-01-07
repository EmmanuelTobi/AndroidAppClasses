package com.example.cosmic.androidappclasses;

import android.support.annotation.Keep;

@Keep
public class UserModel {

    public String username;
    public String userphoto;
    public String date;
    public String email;

    public UserModel(String memail, String musername, String muserphoto, String mDate) {
        this.email = memail;
        this.username = musername;
        this.userphoto = muserphoto;
        this.date = mDate;
    }

}
