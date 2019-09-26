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

public class showorderdetails extends AppCompatActivity {

    EditText orderID, deliveryAddress, totalPrice, vehicleNo, startTime, deliveryTime;
    Button btnSubmit;
    DatabaseReference dbRef;
    showorderdetailsrecords showorder;

    private void clearControls() {
        vehicleNo.setText("");
        startTime.setText("");
        deliveryTime.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showorderdetails);

        showorder = new showorderdetailsrecords();


       /* orderID = findViewById(R.id.orderID);
        deliveryAddress = findViewById(R.id.deliveryAddress);
        totalPrice = findViewById(R.id.totalPrice);*/
        vehicleNo = findViewById(R.id.vehicleNo);
        startTime = findViewById(R.id.startTime);
        deliveryTime = findViewById(R.id.deliveryTime);

        btnSubmit = findViewById(R.id.btnSubmit);

        //Insert Method
        btnSubmit.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {


                dbRef = FirebaseDatabase.getInstance().getReference().child("showorderdetailsrecords");
                try {
                    if (TextUtils.isEmpty(vehicleNo.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter Vehicle No", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(startTime.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter start time", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(deliveryTime.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter delivery time", Toast.LENGTH_SHORT).show();
                    else {

                        showorder.setVehicleno(vehicleNo.getText().toString().trim());
                        showorder.setStarttime(startTime.getText().toString().trim());
                        showorder.setEndtime(deliveryTime.getText().toString().trim());

                        //dbRef.push().setValue(showorder);
                       // dbRef.child("contact").setValue(showorder);

                        dbRef.child(showorder.getVehicleno()).setValue(showorder);

                        Toast.makeText(getApplicationContext(), "Data Saved Successfully", Toast.LENGTH_SHORT).show();
                        clearControls();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Data Saved UnSuccessfully", Toast.LENGTH_SHORT).show();
                }
            }


        });

    }
}
