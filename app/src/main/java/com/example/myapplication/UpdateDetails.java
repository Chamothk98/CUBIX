package com.example.myapplication;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class UpdateDetails extends AppCompatActivity {
    EditText  qty,name,address, visanum,cash;
    Button update;
    Update1 upd;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_details);




    }


    public  void done(View V){
        Toast tst = Toast.makeText(getApplicationContext(),"done", Toast.LENGTH_SHORT);
        tst.show();
    }
}
