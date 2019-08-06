package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class showorders extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showorders);
    }
    public void getOrders2(View view){

        Intent intent2 = new Intent(showorders.this, showorderdetails.class);
        startActivity(intent2);
    }
}
