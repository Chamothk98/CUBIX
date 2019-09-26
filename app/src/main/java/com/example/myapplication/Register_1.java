package com.example.myapplication;

public class Register_1 {
    private  String fname;
    private  String lname;
    private  String Uname;
    private  String address;
    private  String email;
    private  String phonenum;
    private  String pword;
    private  String repeatpassword;
    private String NIC;

    public Register_1() {
    }

    public Register_1(String fname, String lname, String uname, String address, String email, String phonenum, String pword, String repeatpassword, String NIC) {
        this.fname = fname;
        this.lname = lname;
        Uname = uname;
        this.address = address;
        this.email = email;
        this.phonenum = phonenum;
        this.pword = pword;
        this.repeatpassword = repeatpassword;
        this.NIC = NIC;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUname() {
        return Uname;
    }

    public void setUname(String uname) {
        Uname = uname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getPword() {
        return pword;
    }

    public void setPword(String pword) {
        this.pword = pword;
    }

    public String getRepeatpassword() {
        return repeatpassword;
    }

    public void setRepeatpassword(String repeatpassword) {
        this.repeatpassword = repeatpassword;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }
}
