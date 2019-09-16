package com.example.myapplication;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class showorderdetails extends AppCompatActivity {

    EditText orderID, deliveryAddress, totalPrice, vehicleNo, startTime, deliveryTime;
    Button btnSubmit;
    //DatabaseReference dbRef;
    showorderdetailsrecords showorde;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showorderdetails);

        orderID = findViewById(R.id.orderID);
        deliveryAddress = findViewById(R.id.deliveryAddress);
        totalPrice = findViewById(R.id.totalPrice);
        vehicleNo = findViewById(R.id.vehicleNo);
        startTime = findViewById(R.id.startTime);
        deliveryTime = findViewById(R.id.deliveryTime);

        btnSubmit = findViewById(R.id.btnSubmit);

        showorde = new showorderdetailsrecords();

        //dbRef = FireBaseDatabase.getInstance().getReference().child("showorderdetailsrecords");
        try {
            if (TextUtils.isEmpty(startTime.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please start time", Toast.LENGTH_SHORT).show();
            else {
                showorde.setStarttime(startTime.getText().toString().trim());
                showorde.setEndtime(deliveryTime.getText().toString().trim());

                //dbRef.push().setValue(showorde);

                Toast.makeText(getApplicationContext(), "Data Saved Successfully", Toast.LENGTH_SHORT).show();
                clearControls();
            }
        } catch (NumberFormatException e) {
            Toast.makeText(getApplicationContext(), "Please enter delivery time", Toast.LENGTH_SHORT).show();
        }
    }

    private void clearControls() {
        orderID.setText("");
        deliveryAddress.setText("");
        totalPrice.setText("");
        vehicleNo.setText("");
        startTime.setText("");
        deliveryTime.setText("");

    }

    //DatabaseReference upRef = FirebaseDatabase.getInstance().getReference().child("showorderdetailsrecords");
    //upRef.addListenerForSingleValueEvent(new ValueEventListener() {

       /* @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot){
            if ()
        }

}*/
}
