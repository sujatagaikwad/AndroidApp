package com.example.shriramui;

public class Orders {

    private String  name;
    private String city;
    private String address;
    private String mobile;
    private String requirement;

    public Orders(String name,String city , String address, String mobileno ,String requirement) {
        this.name=name;
        this.city=city;
        this.address=address;
        this.mobile=mobileno;
        this.requirement=requirement;
    }

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }
}
