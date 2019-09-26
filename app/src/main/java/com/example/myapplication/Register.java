package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class Register extends AppCompatActivity {
    EditText fname, lname, Uname, address, email, phonenum, pword, repeatpassword, NIC;
    ImageView photo;
    Button submit;
    DatabaseReference dbRef;
    Register_1 register_1;

    private boolean isValidation(String nt2) {
        if (!Pattern.matches("[a-zA-Z]+", nt2)) {
            return nt2.length() != 8;
        }
        return false;
    }
    private boolean isphonenum(String nt3) {
        if (!Pattern.matches("[a-zA-Z]+", nt3)) {
            return nt3.length() != 10;
        }
        return false;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        photo = (ImageView) findViewById(R.id.photo);
        NIC = findViewById(R.id.NIC);
        fname = findViewById(R.id.fname);
        lname = findViewById(R.id.lname);
        Uname = findViewById(R.id.Uname);
        address = findViewById(R.id.address);
        email = findViewById(R.id.Email);
        phonenum = findViewById(R.id.phonenum);
        pword = findViewById(R.id.pword);
        repeatpassword = findViewById(R.id.repeatpassword);

        submit = findViewById(R.id.submit);
        register_1 = new Register_1();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("Register_1");

                try {
                    if (TextUtils.isEmpty(NIC.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Please enter the First name", Toast.LENGTH_SHORT).show();
                    } else if (TextUtils.isEmpty(fname.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Please enter the First name", Toast.LENGTH_SHORT).show();
                    } else if (TextUtils.isEmpty(lname.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Please enter last  last name", Toast.LENGTH_SHORT).show();
                    } else if (TextUtils.isEmpty(Uname.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Please enter last  User name", Toast.LENGTH_SHORT).show();
                    } else if (TextUtils.isEmpty(address.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Please enter last Address", Toast.LENGTH_SHORT).show();
                    } else if (TextUtils.isEmpty(email.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Please enter email", Toast.LENGTH_SHORT).show();
                    }else if(isphonenum(phonenum.getText().toString()))
                    {
                        Toast.makeText(getApplicationContext(),"Enter 10 digits",Toast.LENGTH_SHORT).show();
                    }
                    else if (isValidation(pword.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Please enter password", Toast.LENGTH_SHORT).show();
                    } else if (TextUtils.isEmpty(repeatpassword.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Please enter repeat password", Toast.LENGTH_SHORT).show();




                    } else {
                        register_1.setNIC(NIC.getText().toString().trim());
                        register_1.setFname(fname.getText().toString().trim());
                        register_1.setLname(lname.getText().toString().trim());
                        register_1.setUname(Uname.getText().toString().trim());
                        register_1.setAddress(address.getText().toString().trim());
                        register_1.setEmail(email.getText().toString().trim());
                        register_1.setPhonenum(phonenum.getText().toString().trim());
                        register_1.setPword(pword.getText().toString().trim());
                        register_1.setRepeatpassword(repeatpassword.getText().toString().trim());


                        dbRef.child(register_1.getNIC().toString()).setValue(register_1);
                      clear();
                        Toast.makeText(getApplicationContext(), "Submit Sucessfully", Toast.LENGTH_SHORT).show();


                    }
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Invalid num", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void  clear(){
        NIC.setText("");
        fname.setText("");
        lname.setText("");
        Uname.setText("");
        address.setText("");
        email.setText("");
        phonenum.setText("");
        pword.setText("");
        repeatpassword.setText("");



    }

    public void Clickview(View v){
       Intent intent = new Intent(this,Register_11.class);
       startActivity(intent);
    }

}






