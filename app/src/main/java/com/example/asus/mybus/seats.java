package com.example.asus.mybus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class seats extends AppCompatActivity {

    private TextView mseats,seatkn1,seatkp1,seatnk1,seatns1,seatnp1,seatpn1,seatpk1,seatps1;
    Toolbar mToolbar;
    FirebaseDatabase mDatabase;
    private DatabaseReference databaseReference,drefkn1,drefkp1,drefnk1,drefns1,drefnp1,drefpn1,drefpk1,drefps1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seats);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("Available seats for bus");
       drefkn1= FirebaseDatabase.getInstance().getReference().child("Seatdata").child("KN1").child("Seats");
       drefkp1= FirebaseDatabase.getInstance().getReference().child("Seatdata").child("KP1").child("Seats");
       drefnk1= FirebaseDatabase.getInstance().getReference().child("Seatdata").child("NK1").child("Seats");
       drefns1= FirebaseDatabase.getInstance().getReference().child("Seatdata").child("NS1").child("Seats");
       drefnp1= FirebaseDatabase.getInstance().getReference().child("Seatdata").child("NP1").child("Seats");
       drefpn1= FirebaseDatabase.getInstance().getReference().child("Seatdata").child("PN1").child("Seats");
       drefpk1= FirebaseDatabase.getInstance().getReference().child("Seatdata").child("PK1").child("Seats");
       drefps1= FirebaseDatabase.getInstance().getReference().child("Seatdata").child("PS1").child("Seats");
       databaseReference = FirebaseDatabase.getInstance().getReference().child("Seatdata").child("KS1").child("Seats");

        mseats = findViewById(R.id.seats_avail_count_ks1);
        seatkn1 = findViewById(R.id.seats_avail_kn1_count);
        seatkp1 = findViewById(R.id.seats_avail_kp1_count);
        seatnk1 = findViewById(R.id.seats_avail_nk1_count);
        seatns1 = findViewById(R.id.seats_avail_ns1_count);
        seatnp1 = findViewById(R.id.seats_avail_np1_count);
        seatpn1 = findViewById(R.id.seats_avail_pn1_count);
        seatpk1 = findViewById(R.id.seats_avail_pk1_count);
        seatps1 = findViewById(R.id.seats_avail_ps1_count);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {

                int xxx;
                String seats_count=dataSnapshot.getValue().toString();
                xxx=Integer.parseInt(seats_count);
                xxx=25-xxx;
                seats_count=Integer.toString(xxx);
                mseats.setText(seats_count);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        drefkn1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {

                int xxx;
                String seats_count=dataSnapshot.getValue().toString();
                xxx=Integer.parseInt(seats_count);
                xxx=25-xxx;
                seats_count=Integer.toString(xxx);
                seatkn1.setText(seats_count);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        drefkp1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                int xxx;
                String seats_count=dataSnapshot.getValue().toString();
                xxx=Integer.parseInt(seats_count);
                xxx=25-xxx;
                seats_count=Integer.toString(xxx);
                seatkp1.setText(seats_count);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        drefnk1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {

                int xxx;
                String seats_count=dataSnapshot.getValue().toString();
                xxx=Integer.parseInt(seats_count);
                xxx=25-xxx;
                seats_count=Integer.toString(xxx);
                seatnk1.setText(seats_count);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        drefns1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {

                int xxx;
                String seats_count=dataSnapshot.getValue().toString();
                xxx=Integer.parseInt(seats_count);
                xxx=25-xxx;
                seats_count=Integer.toString(xxx);
                seatns1.setText(seats_count);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        drefnp1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {

                int xxx;
                String seats_count=dataSnapshot.getValue().toString();
                xxx=Integer.parseInt(seats_count);
                xxx=25-xxx;
                seats_count=Integer.toString(xxx);
                seatnp1.setText(seats_count);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        drefpn1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {

                int xxx;
                String seats_count=dataSnapshot.getValue().toString();
                xxx=Integer.parseInt(seats_count);
                xxx=25-xxx;
                seats_count=Integer.toString(xxx);
                seatpn1.setText(seats_count);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        drefpk1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {

                int xxx;
                String seats_count=dataSnapshot.getValue().toString();
                xxx=Integer.parseInt(seats_count);
                xxx=25-xxx;
                seats_count=Integer.toString(xxx);
                seatpk1.setText(seats_count);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        drefps1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {

                int xxx;
                String seats_count=dataSnapshot.getValue().toString();
                xxx=Integer.parseInt(seats_count);
                xxx=25-xxx;
                seats_count=Integer.toString(xxx);
                seatps1.setText(seats_count);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });





        /*
        mDatabaseRef.addValueEventListener(new ValueEventListener() {

            @Override

            public void onDataChange(DataSnapshot dataSnapshot) {

                String s = dataSnapshot.child("KS1").child("Seats").getValue(String.class);



                setTextView(s);

            }


            @Override
            public void onCancelled(DatabaseError databaseError) {
                setTextView("Failed database reading");


            }




        });*/


    }

}