package com.example.myapplication;

import android.text.TextUtils;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class payment extends AppCompatActivity {
    EditText name, address, qty;
    Button btn_pay, btn_contact;
    DatabaseReference dbRef;
    paymentInsert Payment1;
    RadioButton cashe;
    RadioButton visa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);




        name = findViewById(R.id.name);
        address = findViewById(R.id.address);
        qty = findViewById(R.id.qty);

        btn_pay = findViewById(R.id.paybtn);
        btn_contact = findViewById(R.id.contactus);
        Payment1 = new paymentInsert();
        cashe = (RadioButton) findViewById(R.id.cash1);
        visa = (RadioButton) findViewById(R.id.vcard1);

        btn_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("paymentInsert");

                try {
                    if(TextUtils.isEmpty(name.getText().toString())){
                        Toast.makeText(getApplicationContext(), "Please enter the name", Toast.LENGTH_SHORT).show();
                    }
                    else if(TextUtils.isEmpty(address.getText().toString())){
                        Toast.makeText(getApplicationContext(), "Please enter the address", Toast.LENGTH_SHORT).show();
                    }
                    else if(TextUtils.isEmpty(qty.getText().toString())){
                        Toast.makeText(getApplicationContext(), "Please enter  number", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Payment1.setName(name.getText().toString().trim());
                        Payment1.setAddress(address.getText().toString().trim());
                        Payment1.setQty(Integer.parseInt(qty.getText().toString().trim()));


                        dbRef.child(Payment1.getName().toString()).setValue(Payment1);
                        clear();
                        Toast.makeText(getApplicationContext(), "Pay Sucessfully", Toast.LENGTH_SHORT).show();
                    }

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Invalid num", Toast.LENGTH_SHORT).show();


                }
            }
        });
    }

    public void clear() {
        name.setText("");
        address.setText("");
        qty.setText("");



    }


}



