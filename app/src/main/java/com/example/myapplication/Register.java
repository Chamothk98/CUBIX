package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public  void submit(View V){
        Toast tst = Toast.makeText(getApplicationContext(),"Submit", Toast.LENGTH_SHORT);
        tst.show();
    }
}
