package com.example.myapplication;

public class Update1 {
    private  String  qty;
    private  String name;
    private  String address;
    private  String visanum;
    private  String cash;

    public Update1() {
    }

    public Update1(String qty, String name, String address, String visanum, String cash) {
        this.qty = qty;
        this.name = name;
        this.address = address;
        this.visanum = visanum;
        this.cash = cash;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
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

    public String getVisanum() {
        return visanum;
    }

    public void setVisanum(String visanum) {
        this.visanum = visanum;
    }

    public String getCash() {
        return cash;
    }

    public void setCash(String cash) {
        this.cash = cash;
    }
}
