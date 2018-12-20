package com.example.asus.mybus;

import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.firebase.client.Firebase;

public class next_booking_page extends AppCompatActivity {
    Firebase myFirebase;
    DatabaseReference mref,dref,count_inc_ref;
    private FirebaseAuth auth;

    private TextView total_fare,showing_seats,seats_available,test;
    int seats ,available_int_seat,variable_seat= 0,check=0;
    String busid,userfare;
    String user_src=MainActivity.final_src;
    String user_dest=MainActivity.final_dest;
    private Button confirm;
    Spinner spin_seats;
    String final_seat,user_email;
    //Intent intent=new Intent();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_booking_page);
        TextView textViewid = findViewById(R.id.activity_next_booking_bus_id_display);
        Intent receiverIntent = getIntent();
        confirm = findViewById(R.id.activity_next_booking_button_confirm);
        total_fare = findViewById(R.id.total_fare);
        showing_seats = findViewById(R.id.activity_next_booking_showing_seats);
        spin_seats = findViewById(R.id.activity_next_booking_spinner);
        mref = FirebaseDatabase.getInstance().getReference("User");
        busid = receiverIntent.getStringExtra("Busid");
        seats_available = findViewById(R.id.activity_next_booking_avail_count);
        auth = FirebaseAuth.getInstance();
        textViewid.setText(busid);
        user_email=auth.getCurrentUser().getEmail().toString();
        dref = FirebaseDatabase.getInstance().getReference().child("Seatdata").child(busid).child("Seats");
        dref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                try {

                    String seats_count = dataSnapshot.getValue().toString();
                    available_int_seat = Integer.parseInt(seats_count);
                    if(available_int_seat>=25)
                    {
                        Toast.makeText(next_booking_page.this, "Bus is full !!!", Toast.LENGTH_SHORT).show();
                        seats_available.setText("0");


                    }
                    else
                    {
                        available_int_seat = 25 - available_int_seat;

                        String final_count_of_occupid_seat = Integer.toString(available_int_seat);
                        seats_available.setText(final_count_of_occupid_seat);


                    }


                } catch (NumberFormatException ne) {
                    Toast.makeText(next_booking_page.this, "can't parse", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        spin_seats.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                final_seat = spin_seats.getItemAtPosition(spin_seats.getSelectedItemPosition()).toString();
                showing_seats.setText(final_seat);
                try {
                    seats = Integer.parseInt(showing_seats.getText().toString());
                    if(available_int_seat-seats>=0 && seats_available.getText()!="0") {
                        check=1;
                        int final_fare = seats * 5;
                        String tostring_finalfare = Integer.toString(final_fare);
                        total_fare.setText(tostring_finalfare);
                        userfare = tostring_finalfare;
                    }
                    else
                    {
                        Toast.makeText(next_booking_page.this, "Not available", Toast.LENGTH_SHORT).show();
                        total_fare.setText("Can't be calculated!");

                    }
                } catch (NumberFormatException ne) {
                    Toast.makeText(next_booking_page.this, "can't parse", Toast.LENGTH_SHORT).show();

                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(total_fare.getText().toString().equals("Can't be calculated!"))
                {
                    Toast.makeText(next_booking_page.this, "Sorry! Can't book!", Toast.LENGTH_SHORT).show();
                }
                else if(showing_seats.getText().equals("0"))
                {
                    Toast.makeText(next_booking_page.this, "Please select seats!", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    showAlertDialog();

                }

            }
        });
    }

    public void showAlertDialog ()
    {
        AlertDialog alertDialog = new AlertDialog.Builder(next_booking_page.this)
                .create();

        alertDialog.setTitle("Are you sure?");
        alertDialog.setMessage("Please click on \"Yes\" to continue!\n\nYour final amount is Rs." + total_fare.getText().toString());

        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (!TextUtils.isEmpty(showing_seats.getText())) {

                    count_inc_ref= FirebaseDatabase.getInstance().getReference().child("Seatdata").child(busid).child("Seats");
                    count_inc_ref.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            try {

                                String seats_count = dataSnapshot.getValue().toString();
                                variable_seat = Integer.parseInt(seats_count);
                                variable_seat = variable_seat + seats;
                                String final_count_of_occupid_seat = Integer.toString(variable_seat);
                                count_inc_ref.setValue(final_count_of_occupid_seat);
                                String id = mref.push().getKey();
                                Users users = new Users(id, busid, userfare, final_seat, user_src, user_dest);
                                mref.child(login_user.phone).child(id).setValue(users);
                                Intent intent=new Intent(next_booking_page.this,ticket_booked_menu.class);
                                startActivity(intent);
                            } catch (NumberFormatException ne) {
                                Toast.makeText(next_booking_page.this, "sorry can't parse", Toast.LENGTH_SHORT).show();

                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });


                    Toast.makeText(next_booking_page.this, "Seat confirmed", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(next_booking_page.this, "please enter no of seats you want to book", Toast.LENGTH_SHORT).show();

                }


            }
        });

        alertDialog.show();
    }


}