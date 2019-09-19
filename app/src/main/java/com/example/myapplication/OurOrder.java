package com.example.myapplication;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class OurOrder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_our_order);
    }




    public void Menu(View view){
        Intent Me = new Intent(this,Menu.class);
        startActivity(Me);
    }

    public void add(View view){
        Intent Ad = new Intent(this,update_menu.class);
        startActivity(Ad);
    }


}

