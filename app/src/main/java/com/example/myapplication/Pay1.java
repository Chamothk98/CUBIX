package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class Pay1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay1);
    }

    public  void pay(View V){
        Toast tst = Toast.makeText(getApplicationContext(),"pay", Toast.LENGTH_SHORT);
        tst.show();
    }
}
