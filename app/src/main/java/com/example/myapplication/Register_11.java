package com.example.myapplication;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.firebase.database.*;
import org.xmlpull.v1.sax2.Driver;

public class Register_11 extends AppCompatActivity {

    EditText fname, lname, uname, address, email, cnum, password, rpassword, NIC;
    Button search, update, delete;
    DatabaseReference dbRef;
    Register_1 register_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_11);

        register_2 = new Register_1();

        NIC = findViewById(R.id.NIC);
        fname = findViewById(R.id.fname);
        lname = findViewById(R.id.lname);
        uname = findViewById(R.id.uname);
        address = findViewById(R.id.address);
        email = findViewById(R.id.email);
        cnum = findViewById(R.id.cnum);
        password = findViewById(R.id.password);
        rpassword = findViewById(R.id.rpassword);


        search = findViewById(R.id.search);
        delete = findViewById(R.id.delete);
        update = findViewById(R.id.update);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("Register_1").child(NIC.getText().toString());
                dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        try {
                            if (dataSnapshot.hasChildren()) {
                                NIC.setText((dataSnapshot.child("nic").getValue().toString().trim()));

                                fname.setText((dataSnapshot.child("fname").getValue().toString()));
                                lname.setText((dataSnapshot.child("lname").getValue().toString()));
                                uname.setText((dataSnapshot.child("uname").getValue().toString()));
                                address.setText((dataSnapshot.child("address").getValue().toString()));
                                email.setText((dataSnapshot.child("email").getValue().toString()));
                                cnum.setText((dataSnapshot.child("phonenum").getValue().toString()));
                                password.setText((dataSnapshot.child("pword").getValue().toString()));
                                rpassword.setText((dataSnapshot.child("repeatpassword").getValue().toString()));


                            } else {
                                Toast.makeText(Register_11.this, "No show one", Toast.LENGTH_SHORT).show();
                            }

                        } catch (Exception e) {


                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dbRef = FirebaseDatabase.getInstance().getReference().child("Register_1").child(NIC.getText().toString());

                openDialog();

                Toast.makeText(Register_11.this, "Remove success", Toast.LENGTH_SHORT).show();
            }
        });


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    //register_2.setNIC(NIC.getText().toString().trim());
                    register_2.setFname(fname.getText().toString().trim());
                    register_2.setLname(lname.getText().toString().trim());
                    register_2.setAddress(address.getText().toString().trim());
                    register_2.setEmail(email.getText().toString().trim());
                    register_2.setPhonenum(cnum.getText().toString().trim());
                    register_2.setPword(password.getText().toString().trim());
                    register_2.setUname(uname.getText().toString().trim());
                    register_2.setRepeatpassword(rpassword.getText().toString().trim());
                    dbRef = FirebaseDatabase.getInstance().getReference().child("Register_1").child(NIC.getText().toString());
                    dbRef.setValue(register_2);
                    clear();

                    Toast.makeText(getApplicationContext(), "Update Successful", Toast.LENGTH_SHORT).show();

                } catch (Exception e) {

                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

    private void openDialog() {
        final AlertDialog dialog = new AlertDialog.Builder(this).setTitle("Conformation Box").setMessage("Do you want to delete ?")
                .setPositiveButton("Ok", null).setNegativeButton("Cancel", null).show();
        Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
        Button negative = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);
        negative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Register_11.class);
                startActivity(intent);
                dialog.dismiss();
            }
        });
        positiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbRef.removeValue();
                clear();
                dialog.dismiss();

                Toast.makeText(Register_11.this, "Delete success", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void clear() {
        NIC.setText("");
        fname.setText("");
        lname.setText("");
        uname.setText("");
        address.setText("");
        email.setText("");
        cnum.setText("");
        password.setText("");
        rpassword.setText("");
        NIC.setText("");


    }
}




