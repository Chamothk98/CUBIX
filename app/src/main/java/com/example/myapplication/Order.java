package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Order extends AppCompatActivity {
    Button b;
    private Object Order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectpizza);
    }

    public void accept(View view)
    {
        Intent accept = new Intent(this, orderrecords.class);
        startActivity(accept);
    }

    public void update(View view)
    {
        Intent update = new Intent(this,OrderUpdate.class);
        startActivity(update);
    }

    public void toast(View view)
    {
        Toast.makeText(Order.this, "Order Deleted!", Toast.LENGTH_SHORT).show();
    }




}
