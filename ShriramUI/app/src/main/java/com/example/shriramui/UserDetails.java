package com.example.shriramui;

public class UserDetails {

    public  String userId;
    private static UserDetails user;
    private UserDetails(){
        this.userId="";
    }

    public static UserDetails getInstance(){
        if(null == user){
            user=new UserDetails();
        }
        return user;
    }
    public  void setUserId(String userId){
        this.userId=userId;
    }

    public String getUserId(){
        return this.userId;
    }
}
