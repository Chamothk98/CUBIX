package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.firebase.database.*;

import java.util.ArrayList;

public class Allpay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allpay);
        final ListView stdListview;

        final ArrayList<String> rid;
        final ArrayList<String> cno;
        final ArrayList<String> nam;


            stdListview = findViewById(R.id.fbListview);


            rid = new ArrayList<String>();
            cno = new ArrayList<String>();
            nam = new ArrayList<String>();


            final ArrayList<String> StudentStrList = new ArrayList<>();


            DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("PIZZA");

        dbRef.addValueEventListener(new ValueEventListener() {

                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                        String StudentStr = dsp.getKey();
                        StudentStrList.add(StudentStr);
                    }
                    for(int i =0 ; i<StudentStrList.size(); i++){
                        DatabaseReference readRef2 = FirebaseDatabase.getInstance().getReference().child("PIZZA_Add");

                        readRef2.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                                    String strcontent, strname, strprice;

                                    strcontent = snapshot.child("content").getValue().toString();
                                    strname = snapshot.child("name").getValue().toString();
                                    strprice = snapshot.child("price").getValue().toString();

                                    rid.add(strname);
                                    cno.add(strcontent);
                                    nam.add(strprice);

                                    MyStudentAdapter adapter = new MyStudentAdapter(getApplicationContext(), rid, cno, nam);
                                    stdListview.setAdapter(adapter);
                                }
                            }
                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        }
    }
    class MyStudentAdapter extends ArrayAdapter<String> {

        Context context;

        ArrayList rid;
        ArrayList cno;
        ArrayList nam;


        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View stdrow = layoutInflater.inflate(R.layout.view, parent, false);

            TextView tvrid = stdrow.findViewById(R.id.tvrid);
            TextView tvcno = stdrow.findViewById(R.id.tvcno);
            TextView tvnam = stdrow.findViewById(R.id.tvname);
            Button paycus = stdrow.findViewById(R.id.pay_cus_btn);


            tvrid.setText(rid.get(position).toString());
            tvcno.setText(cno.get(position).toString());
            tvnam.setText(nam.get(position).toString());

            paycus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(getContext(), payment.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    view.getContext().startActivity(intent);



                }
            });


            return stdrow;


        }


        MyStudentAdapter(Context c, ArrayList rid, ArrayList cno, ArrayList nam) {
            super(c, R.layout.view, R.id.tvrid, rid);
            this.context = c;

            this.rid = rid;
            this.cno = cno;
            this.nam = nam;


        }

    }


