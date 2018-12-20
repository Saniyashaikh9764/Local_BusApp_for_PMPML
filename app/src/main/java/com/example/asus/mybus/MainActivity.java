package com.example.asus.mybus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.QuickContactBadge;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   private Spinner spinner_source,spinner_dest;
   private TextView src,dest;
   private Button nextbt;
   public static String final_src,final_dest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nextbt=findViewById(R.id.main_Button_next);
        spinner_source=findViewById(R.id.activity_main_source_spinner);
        spinner_dest=findViewById(R.id.activity_main_dest_spinner);
    src=findViewById(R.id.Activity_main_source_text);
    dest=findViewById(R.id.Activity_main_dest_text);


        spinner_dest.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
       @Override
       public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

           final_dest = spinner_dest.getItemAtPosition(spinner_dest.getSelectedItemPosition()).toString();

           dest.setText(final_dest);
           }

       @Override
       public void onNothingSelected(AdapterView<?> parent) {

       }


   });
        spinner_source.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                final_src = spinner_source.getItemAtPosition(spinner_source.getSelectedItemPosition()).toString();

                src.setText(final_src);


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


       // getset ssrc=new getset(final_src,final_dest);

        nextbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(final_src!=final_dest)
                {
                    Intent intent =new Intent(MainActivity.this,Booking.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Source and Destination Should not be same", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
}
