package com.example.myapplication;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.*;

public class contactus extends AppCompatActivity {

    EditText txtName, txtEmail, txtPhone, txtWebsite, txtMessage;
    Button btnSubmit,btnUpdate,btnDelete,btnSearch;
    DatabaseReference dbRef;
    contactusrecords conus;

    private void clearControls(){
        txtName.setText("");
        txtEmail.setText("");
        txtPhone.setText("");
        txtWebsite.setText("");
        txtMessage.setText("");

    }

    //Insert Method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactus);

        txtName = findViewById(R.id.txtName);
        txtEmail = findViewById(R.id.txtEmail);
        txtPhone = findViewById(R.id.txtPhone);
        txtWebsite = findViewById(R.id.txtWebsite);
        txtMessage = findViewById(R.id.txtMessage);

        btnSearch = findViewById(R.id.btnSearch);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        btnSubmit = findViewById(R.id.btnSubmit);

        //Insert Method

        btnSubmit.setOnClickListener(new View.OnClickListener() {

            contactusrecords conus = new contactusrecords();

            @Override
            public void onClick(View view) {


                dbRef = FirebaseDatabase.getInstance().getReference().child("contactusrecords");
                try {
                    if (TextUtils.isEmpty(txtName.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter name", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(txtEmail.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter email", Toast.LENGTH_SHORT).show();
                    else {

                        conus.setName(txtName.getText().toString().trim());
                        conus.setEmail(txtEmail.getText().toString().trim());
                        conus.setPhoneNo(txtPhone.getText().toString().trim());
                        conus.setWebsite(txtWebsite.getText().toString().trim());
                        conus.setMessage(txtMessage.getText().toString().trim());

                        dbRef.push().setValue(conus);
                        dbRef.child("contact").setValue(conus);

                        //dbRef.child(conus.getName()).setValue(conus);

                        Toast.makeText(getApplicationContext(), "Data Saved Successfully", Toast.LENGTH_SHORT).show();
                        clearControls();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Please enter a message", Toast.LENGTH_SHORT).show();
                }
            }


        });

        //Update Method

        btnUpdate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                DatabaseReference updateRef = FirebaseDatabase.getInstance().getReference().child("contactusrecords");
                updateRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        contactusrecords conus = new contactusrecords();

                        if(dataSnapshot.hasChild(txtName.getText().toString())){

                            conus.setName(txtName.getText().toString());
                            conus.setEmail(txtEmail.getText().toString());
                            conus.setPhoneNo(txtPhone.getText().toString());
                            conus.setWebsite(txtWebsite.getText().toString());
                            conus.setMessage(txtMessage.getText().toString());

                            DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("contactusrecords").child(txtName.getText().toString());
                            dbRef.setValue(conus);

                            Toast.makeText(getApplicationContext(),"Data Update Successfully!",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"No sourse to update ",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        //Search Method

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // DatabaseReference FindRef = FirebaseDatabase.getInstance().getReference().child("Driver").child("983081894V");
                DatabaseReference FindsRef = FirebaseDatabase.getInstance().getReference().child("contactusrecords");

                dbRef = FirebaseDatabase.getInstance().getReference().child("contactusrecords").child(txtName.getText().toString());
                //Log.i("NIC", txtSearch.getText().toString());
                dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        try {

                            if (dataSnapshot.hasChildren()) {

                                txtName.setText(dataSnapshot.child("name").getValue().toString());
                                txtEmail.setText(dataSnapshot.child("email").getValue().toString());
                                txtPhone.setText(dataSnapshot.child("phoneNo").getValue().toString());
                                txtWebsite.setText(dataSnapshot.child("website").getValue().toString());
                                txtMessage.setText(dataSnapshot.child("message").getValue().toString());
                            }
                            else{
                                Toast.makeText(getApplicationContext(), "No Source to Display", Toast.LENGTH_SHORT).show();
                            }
                        }catch (Exception ex){

                            Toast.makeText(getApplicationContext(), ex.getMessage().toString(), Toast.LENGTH_SHORT).show();

                        }


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        //Delete Method

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference delRef = FirebaseDatabase.getInstance().getReference().child("contactusrecords");
                delRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild(txtName.getText().toString())){
                            DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("contactusrecords").child(txtName.getText().toString());
                            dbRef.removeValue();

                            Toast.makeText(getApplicationContext(),"Data deleted succesfully!",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"No Source to delete!",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }

}

