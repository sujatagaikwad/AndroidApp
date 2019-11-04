package com.example.shriramui;

public class Last_order {
    private String  id;
    private String name;
    private String address;
    private String mobileno;
    private String washingtextview;
    private String Repairprice;

    public Last_order(String id, String name, String address, String mobileno, String washingtextview, String repairprice) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.mobileno = mobileno;
        this.washingtextview = washingtextview;
        this. Repairprice = repairprice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getWashingtextview() {
        return washingtextview;
    }

    public void setWashingtextview(String washingtextview) {
        this.washingtextview = washingtextview;
    }

    public String getRepairprice() {
        return Repairprice;
    }

    public void setRepairprice(String repairprice) {
        Repairprice = repairprice;
    }
}
