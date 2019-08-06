package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Cart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
    }



    public  void  Pay(View v){
        Intent Pay = new Intent(this,Pay1.class);
        startActivity(Pay);
    }


    public  void  Update(View v){
        Intent Update = new Intent(this,UpdateDetails.class);
        startActivity(Update);
    }


public  void delete(View V){
    Toast tst = Toast.makeText(getApplicationContext(),"Deleted", Toast.LENGTH_SHORT);
    tst.show();
}



    }



