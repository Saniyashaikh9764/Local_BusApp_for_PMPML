package com.example.asus.mybus;
        import android.content.Intent;
        import android.support.annotation.NonNull;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuInflater;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;
        import android.widget.Toast;
        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.auth.FirebaseUser;

public class home_page extends AppCompatActivity {

    private TextView timetable,seat,booking,cancle,location;
    FirebaseAuth auth;
    FirebaseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        location=findViewById(R.id.activity_main_location);
        timetable=findViewById(R.id.activity_home_page_timetable);
        seat=findViewById(R.id.activity_main_seats);
        booking=findViewById(R.id.activity_main_booking);
        cancle=findViewById(R.id.activity_main_cancellation);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        timetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(home_page.this,Timetable.class);
                startActivity(intent);

            }
        });
        seat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(home_page.this,seats.class);
                startActivity(intent);


            }
        });
        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(home_page.this,MainActivity.class);
                startActivity(intent);


            }
        });
        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(home_page.this,ticket_booked_menu.class);
                startActivity(intent);


            }
        });

        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(home_page.this,MapsActivity.class);
                startActivity(intent);


            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.booked_tickets)
        {
            Intent intent=new Intent(home_page.this,ticket_booked_menu.class);
            startActivity(intent);
        }
        if(item.getItemId()==R.id.about_us)
        {
            Intent intent=new Intent(home_page.this,aboutus.class);
            startActivity(intent);
        }
        if(item.getItemId()==R.id.admin_login)
        {
            Intent intent=new Intent(home_page.this,admin_activity.class);
            startActivity(intent);
        }
        if(item.getItemId()==R.id.logout)
        {
            auth.signOut();
            startActivity(new Intent(home_page.this, login_user.class));
        }

        return super.onOptionsItemSelected(item);
    }
}
