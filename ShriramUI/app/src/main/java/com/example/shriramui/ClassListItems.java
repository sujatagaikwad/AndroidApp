package com.example.shriramui;

public class ClassListItems {
    public String name;
    public String city;
    public String address;public String mobile;
    public String requirement;



    public ClassListItems(String mobile, String name, String city, String requirement , String address) {
        this.name = name;
        this.city =city;
        this.address =address;
        this.mobile =mobile;
        this.requirement = requirement;

    }



    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public String getMobile() {
        return mobile;
    }

    public String getRequirement() {
        return requirement;
    }
}
