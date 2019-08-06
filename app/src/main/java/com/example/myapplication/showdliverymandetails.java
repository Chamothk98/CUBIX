package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class showdliverymandetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showdeliverymandetails);
    }
    public void getOrders1(View view){

        Intent intent1 = new Intent(showdliverymandetails.this, showorders.class);
        startActivity(intent1);
    }
}
