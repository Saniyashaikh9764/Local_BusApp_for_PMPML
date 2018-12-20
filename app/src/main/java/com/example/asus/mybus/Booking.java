package com.example.asus.mybus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class Booking extends AppCompatActivity {
TextView avail_seats,busid,bus_time,bus_fare,res;
    Toolbar mToolbar;

String gsrc,gdest;
  ArrayList<String[]>cities= new ArrayList<String[]>();
    ArrayList<String> avlbl_buses=new ArrayList<String>();
    ArrayList<Integer>fare=new ArrayList<Integer>();
   ArrayList<Integer>duration=new ArrayList<Integer>();
int flag=0;

ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        listView=findViewById(R.id.listview_id);
        mToolbar = (Toolbar) findViewById(R.id.toolbarbooking);
        mToolbar.setTitle("Available Buses are");


       int k=0;
        gsrc=MainActivity.final_src;
        gdest=MainActivity.final_dest;
        String[] kn1  = {"KN1","Katraj","Swargate","Shivajinagar","Khadki","Pimpri","Nigadi",""};
        cities.add(kn1);
        String[] ks1  = {"KS1","Katraj","Balajinagar","Swargate","Deccan","Shivajinagar",""};
        cities.add(ks1);
        String[] kp1  = {"KP1","Katraj","Balajinagar","Swargate","Shivajinagar","Pune",""};
        cities.add(kp1);


        String[] nk1  = {"NK1","Nigadi","Pimpri","Khadki","Shivajinagar","Swargate","Katraj",""};
        cities.add(nk1);
        String[] ns1  = {"NS1","Nigadi","Pimpri","Khadki","Shivajinagar",""};
        cities.add(ns1);
        String[] np1  = {"NP1","Nigadi","Chinchwad","Pimpri","Khadki","shivajinagar","Pune",""};
        cities.add(np1);

        String[] pn1  = {"PN1","Pune","Shivajinagar","Khadki","Pimpri","Chinchwad","Nigadi",""};
        cities.add(pn1);
        String[] pk1  = {"PK1","Pune","Shivajinagar","Swargate","Balajinagar","Katraj",""};
        cities.add(pk1);
        String[] ps1  = {"PS1","Pune","Ramnagar","Shivajinagar","Swargate",""};
        cities.add(ps1);

       for(int i=0;i<cities.size();i++)
        {
            int j=0,s1=0,d1=0;
            String[] ff=cities.get(i);
            while(ff[j]!="")
            {
                if(ff[j].equals(gsrc))
                {
                    s1=j;
                }
                if(ff[j].equals(gdest))
                {
                    d1=j;
                }
                if(s1!=0&&d1!=0&&s1<d1)
                {
                    avlbl_buses.add(cities.get(i)[0]);
                    fare.add((d1-s1)*10);
                    duration.add((d1-s1)*5);
                    j++;
                    k++;
                    flag=1;
                    break;
                }

                j++;
            }
        }
        if(flag==0)
        {
            Toast.makeText(Booking.this, "Sorry no bus is Available", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(Booking.this,home_page.class);
            startActivity(intent);

        }
        else
        {
            ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,avlbl_buses);
            listView.setAdapter(arrayAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent mIntent = new Intent(Booking.this, next_booking_page.class);

                    mIntent.putExtra("Busid", avlbl_buses.get(position));
                    startActivity(mIntent);

                }
            });
        }




    }

}
