package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.Driver;

public class update_menu extends AppCompatActivity {

    TextView Name,Price,Content,SER;
    Button Search,Del;
    DatabaseReference dbref;



    Driver driver;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_menu);

        SER = findViewById(R.id.SER);
        Name = findViewById(R.id.Name);
        Price = findViewById(R.id.Price);
        Content = findViewById(R.id.Content);

        Search = findViewById(R.id.Search);
//        btnSearch = findViewById(R.id.button12);
        Del = findViewById(R.id.Del);


        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // DatabaseReference FindRef = FirebaseDatabase.getInstance().getReference().child("Driver").child("983081894V");
                dbref = FirebaseDatabase.getInstance().getReference().child("PIZZA").child(SER.getText().toString().trim());
                //Log.i("NIC", txtSearch.getText().toString());
                dbref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        try {
                            if (dataSnapshot.hasChildren()) {
                                Content.setText(dataSnapshot.child("content").getValue().toString());
                                Name.setText(dataSnapshot.child("name").getValue().toString());
                                Price.setText(dataSnapshot.child("price").getValue().toString());
                            }
                            else{
                                Toast.makeText(update_menu.this, "No Source to Display", Toast.LENGTH_SHORT).show();
                            }
                        }catch (Exception ex){

                            Toast.makeText(update_menu.this, ex.getMessage().toString(), Toast.LENGTH_SHORT).show();

                        }


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });



        Del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                DatabaseReference delRef = FirebaseDatabase.getInstance().getReference().child("Driver");
                delRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        if (dataSnapshot.hasChild(Name.getText().toString())){

                            dbref = FirebaseDatabase.getInstance().getReference().child("Driver").child(Name.getText().toString());
                            dbref.removeValue();
                            clearAll();

                            Toast.makeText(update_menu.this, "Remove Successfully", Toast.LENGTH_SHORT).show();
                        }

                        else{

                            Toast.makeText(update_menu.this, "No Source to Delete", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }

    public void clearAll() {

        SER.setText("");
        Name.setText("");
        Price.setText("");
        Content.setText("");


    }





}