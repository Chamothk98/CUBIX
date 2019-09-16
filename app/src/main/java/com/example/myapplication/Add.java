package com.example.myapplication;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Add extends AppCompatActivity {

    EditText Name,Price,Content;
    Button Add;
   DatabaseReference dbref;
   itemadd itm;


   private void clearControlls(){

       Name.setText("");
       Price.setText("");
       Content.setText("");
   }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Name = findViewById(R.id.Name);
        Price = findViewById(R.id.Price);
        Content = findViewById(R.id.Content);

        Add = findViewById(R.id.Add);
        itm = new itemadd();


        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dbref = FirebaseDatabase.getInstance().getReference().child("OrderRecordsAdd");


                try {
                    if (TextUtils.isEmpty(Name.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please Enter", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(Price.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please Enter", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(Content.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please Enter", Toast.LENGTH_SHORT).show();


                    else {///take inputs
                        itm.setName(Name.getText().toString().trim());
                        itm.setPrice(Price.getText().toString().trim());
                        itm.setContent(Content.getText().toString().trim());

                        ///insert to database
                        dbref.push().setValue(itm);
                        dbref.child("itm1").setValue(itm);

                        ///Feedback
                        Toast.makeText(getApplicationContext(), "Data added Successfully", Toast.LENGTH_LONG).show();
                        clearControlls();


                    }
                }

                catch (NumberFormatException e)
                {
                    Toast.makeText(getApplicationContext(),"Invalid Details",Toast.LENGTH_SHORT).show();
                }

            }
        });





    }


    public void add(View view){
        Intent Ad = new Intent(this,Add.class);
        startActivity(Ad);
    }
}
