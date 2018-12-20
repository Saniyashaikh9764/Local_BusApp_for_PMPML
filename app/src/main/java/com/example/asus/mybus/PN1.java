package com.example.asus.mybus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PN1 extends AppCompatActivity {
    Button inc,dec,resett;
    TextView seatscount;
    FirebaseDatabase mDatabase;
    DatabaseReference mDatabaseRef,dref;
    static int counter=0;
    int limit=25;
    String seat_count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pn1);
        inc=findViewById(R.id.pn1_activity_increase_button);
        dec=findViewById(R.id.pn1_activity_decrement_button);
        resett=findViewById(R.id.pn1_activity_reset_button);
        seatscount=findViewById(R.id.seatcount_textview_activity_pn1);

        dref = FirebaseDatabase.getInstance().getReference().child("Seatdata").child("PN1").child("Seats");

        dref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                seat_count=dataSnapshot.getValue().toString();
                counter=Integer.parseInt(seat_count);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



        inc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(counter<=24 && counter>=0)
                {
                    counter=counter+1;
                    seatscount.setText(Integer.toString(counter));
                    dref.setValue(counter);


                }
                else
                {
                    Toast.makeText(PN1.this, "Bus is Full!!!", Toast.LENGTH_SHORT).show();
                }




            }
        });

        dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(counter>=1)
                {
                    counter=counter-1;
                    seatscount.setText(Integer.toString(counter));
                    dref.setValue(counter);


                }
                else
                {
                    Toast.makeText(PN1.this, "Bus is Empty!!!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        resett.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                seatscount.setText("0");
                dref.setValue("0");
            }
        });

    }}




