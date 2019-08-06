package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void Menu(View view){
        Intent Me = new Intent(this,Add.class);
        startActivity(Me);
    }
    public void Update(View view){
        Intent Up = new Intent(this,Update.class);
        startActivity(Up);
    }

    public void Delete(View V){
        Toast myTst = Toast.makeText(getApplicationContext(),"Deleted",Toast.LENGTH_SHORT);
        myTst.show();

    }
}
