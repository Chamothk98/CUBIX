package com.example.myapplication;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Update extends AppCompatActivity {
    EditText name,qty,address,visanum,cash;
    Button update;
    Update1 upd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);



            name = findViewById(R.id.editTextname);
            qty = findViewById(R.id.editTextqty);
            address = findViewById(R.id.editTextaddress);
            visanum = findViewById(R.id.editTextvisa);
            update = findViewById(R.id.update);
            upd = new Update1();
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{

                    upd.setName(name.getText().toString().trim());
                    upd.setQty(qty.getText().toString().trim());
                    upd.setAddress(address.getText().toString().trim());
                    upd.setVisanum(visanum.getText().toString().trim());
                    Toast.makeText(getApplicationContext(),"Data Update Successfully",Toast.LENGTH_SHORT).show();
                }catch (Exception e){

                }
            }
        });




    }

}
