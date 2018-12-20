package com.example.asus.mybus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class Timetable extends AppCompatActivity {

    private TextView katraj;
    private TextView nigadi;
    private TextView punestation;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_timetable);
        katraj=findViewById(R.id.timetable_katraj);
        nigadi=findViewById(R.id.timetable_nigadi);
        punestation=findViewById(R.id.timetable_punestation);


        katraj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Timetable.this,timetableofkatraj.class);
                startActivity(intent);
            }
        });

        nigadi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Timetable.this,timetableofnigadi.class);
                startActivity(intent);
            }
        });

        punestation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Timetable.this,timetableofPunestation.class);
                startActivity(intent);
            }
        });

        }
}
