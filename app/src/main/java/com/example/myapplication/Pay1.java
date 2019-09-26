package com.example.myapplication;

import android.os.Bundle;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Pay1 extends AppCompatActivity {
    EditText editTextqty,editTextname,editTextaddress,editTextvisaCard,editTextcash;
    Button pay,home;
    //payment paym;
    DatabaseReference dbRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay1);

        editTextqty= findViewById(R.id.editTextqty);
        editTextname= findViewById(R.id.editTextname);
        editTextaddress = findViewById(R.id.editTextaddress);
        editTextvisaCard = findViewById(R.id.editTextvisa);

        pay =findViewById(R.id.pay_cus_btn);
        home =findViewById(R.id.Home);

        //paym = new payment();

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("payment");
                try{
                    if(TextUtils.isEmpty(editTextqty.getText().toString())){
                        Toast.makeText(getApplicationContext(),"Please enter the First qty",Toast.LENGTH_SHORT).show();
                    }
                    else  if(TextUtils.isEmpty(editTextname.getText().toString())){
                        Toast.makeText(getApplicationContext(),"Please enter last  last name",Toast.LENGTH_SHORT).show();
                    }
                    else  if(TextUtils.isEmpty(editTextaddress.getText().toString())){
                        Toast.makeText(getApplicationContext(),"Please enter last  last address",Toast.LENGTH_SHORT).show();
                    }
                    else {
                       // paym.setEditTextqty(editTextqty.getText().toString().trim());
                      //  paym.setEditTextname(editTextname.getText().toString().trim());
                       // paym.setEditTextaddress(editTextaddress.getText().toString().trim());
                       // paym.setEditTextvisanum(editTextvisaCard.getText().toString().trim());
                      //  dbRef.push().setValue(paym);
                        Toast.makeText(getApplicationContext(),"pay Successfully", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){

                }

            }





        });

        }
        }
