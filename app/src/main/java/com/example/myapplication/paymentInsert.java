package com.example.myapplication;

public class paymentInsert {
    String name;
    String address;
   int qty;


    public paymentInsert() {
    }

    public paymentInsert(String name, String address,  int qty) {
        this.name = name;
        this.address = address;
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

   public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }


}
