package com.example.asus.mybus;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ticket_booked_menu extends AppCompatActivity {
    private RecyclerView mlist;
    private DatabaseReference mdatabase;
    Toolbar toolbart;
    FirebaseRecyclerAdapter adapter;

    FirebaseRecyclerAdapter<Blog,BlogViewHolder>firebaseRecyclerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_booked_menu);
        toolbart=findViewById(R.id.toolbartickets);
        toolbart.setTitle("Select to cancel");
        mdatabase= FirebaseDatabase.getInstance().getReference().child("User").child(login_user.phone);
        mdatabase.keepSynced(true);
        mlist=(RecyclerView)findViewById(R.id.recyclerview);
        mlist.setHasFixedSize(true);
        mlist.setLayoutManager(new LinearLayoutManager(this));


    }


    @Override
    protected void onStart(){
        super.onStart();


      firebaseRecyclerAdapter =new FirebaseRecyclerAdapter<Blog,BlogViewHolder>
                (Blog.class,R.layout.single_cardview_bus,BlogViewHolder.class,mdatabase)
        {
            @Override
            protected  void populateViewHolder(BlogViewHolder viewHolder, Blog model, final int position)
            {


                // viewHolder.setBusid(model.getUserbusid());
                viewHolder.setId(model.getUserid());
                viewHolder.setsource(model.getUsrs());
                viewHolder.setdest(model.getUdest());
                viewHolder.setFare(model.getUserfare());
                viewHolder.setNoofseats(model.getNoofseats());

                viewHolder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder=new AlertDialog.Builder(ticket_booked_menu.this);
                        builder.setMessage("Do you want to cancel this booking?").setCancelable(false)
                                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        firebaseRecyclerAdapter.getRef(position).removeValue();
                                        firebaseRecyclerAdapter.notifyItemRemoved(position);
                                        Toast.makeText(ticket_booked_menu.this, "Your booking has been cancelled succcessfully!", Toast.LENGTH_SHORT).show();


                                    }
                                }

                                ).setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();

                            }
                        });
                        AlertDialog dialog=builder.create();
                        dialog.setTitle("Delete Ticket");
                        dialog.show();


                    }
                });


            }

        };
        mlist.setAdapter(firebaseRecyclerAdapter);


    }

    public static class BlogViewHolder extends RecyclerView.ViewHolder
    {

        View mView;
        public BlogViewHolder(View itemview)
        {
            super(itemview);
            mView=itemview;
        }
        public void setNoofseats(String noofseats) {
            TextView showing_seats=(TextView) mView.findViewById(R.id.show_nos);
            showing_seats.setText(noofseats);
        }
        public void setsource(String source) {
            TextView showing_seats=(TextView) mView.findViewById(R.id.show_source);
            showing_seats.setText(source);
        }
        public void setdest(String destination) {
            TextView showing_seats=(TextView) mView.findViewById(R.id.show_dest);
            showing_seats.setText(destination);
        }
        /* public void setBusid(String bid) {
             TextView showing_seats=(TextView) mView.findViewById(R.id.show_busid);
             showing_seats.setText(bid);
         }*/
        public void setFare(String fare) {
            TextView showing_seats=(TextView) mView.findViewById(R.id.show_fare);
            showing_seats.setText(fare);
        }
        public void setId(String id) {
            TextView showing_seats=(TextView) mView.findViewById(R.id.show_userid);
            showing_seats.setText(id);
        }
    }


}

