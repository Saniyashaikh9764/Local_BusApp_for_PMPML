package com.example.asus.mybus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Conductor_activity extends AppCompatActivity {
    TextView ks,kp,kn,nk,ns,np,pn,pk,ps;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conductor_activity);
ks=findViewById(R.id.activity_conductor_ks1);
kp=findViewById(R.id.activity_conductor_kp1);
kn=findViewById(R.id.activity_conductor_kn1);
nk=findViewById(R.id.activity_conductor_nk1);
ns=findViewById(R.id.activity_conductor_ns1);
np=findViewById(R.id.activity_conductor_np1);
pn=findViewById(R.id.activity_conductor_pn1);
pk=findViewById(R.id.activity_conductor_pk1);
ps=findViewById(R.id.activity_conductor_ps1);
        ps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Conductor_activity.this,PS1.class);
                startActivity(intent);
            }
        });
        pk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Conductor_activity.this,PK1.class);
                startActivity(intent);
            }
        });

        pn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Conductor_activity.this,PN1.class);
                startActivity(intent);
            }
        });
        ks.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(Conductor_activity.this,KS1.class);
        startActivity(intent);
    }
});

        kn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Conductor_activity.this,KN1.class);
                startActivity(intent);
            }
        });
        kp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Conductor_activity.this,KP1.class);
                startActivity(intent);
            }
        });
        nk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Conductor_activity.this,NK1.class);
                startActivity(intent);
            }
        });

        ns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Conductor_activity.this,NS1.class);
                startActivity(intent);
            }
        });
        np.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Conductor_activity.this,NP1.class);
                startActivity(intent);
            }
        });

    }}




