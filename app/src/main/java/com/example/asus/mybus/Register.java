package com.example.asus.mybus;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.ProviderQueryResult;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    DatabaseReference mref;
    private EditText inputEmail, inputPassword,inputmobile;
    private FirebaseAuth auth;
    private Button btnSignUp;
    private ProgressDialog PD;
    static String phone;



    @Override    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        PD = new ProgressDialog(this);
        PD.setMessage("Loading...");
        PD.setCancelable(true);
        PD.setCanceledOnTouchOutside(false);

        auth = FirebaseAuth.getInstance();

        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(Register.this, home_page.class));
            finish();
        }

        inputEmail = (EditText) findViewById(R.id.email);
        inputmobile = (EditText) findViewById(R.id.mobile);
        inputPassword = (EditText) findViewById(R.id.password);
        btnSignUp = (Button) findViewById(R.id.sign_up_button);
        inputmobile.setError("Mobile no is required!");
        inputEmail.setError("Email is required");

        mref = FirebaseDatabase.getInstance().getReference("User");

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override            public void onClick(View view) {
                final String email = inputEmail.getText().toString();
                phone = inputmobile.getText().toString();
                final String password = inputPassword.getText().toString();

                if (TextUtils.isEmpty(phone))
                {
                    inputmobile.setError("Required");
                    return;
                }
                if (TextUtils.isEmpty(email))
                {
                    inputEmail.setError("Required");
                    return;
                }
                mref.child(phone);
                auth.fetchProvidersForEmail(inputEmail.getText().toString()).addOnCompleteListener(new OnCompleteListener<ProviderQueryResult>() {
                    @Override
                    public void onComplete(@NonNull Task<ProviderQueryResult> task) {
                        boolean check=!task.getResult().getProviders().isEmpty();
                        if(!check)
                        {
                            try {
                                if (password.length() > 0 && email.length() > 0) {
                                    PD.show();
                                    auth.createUserWithEmailAndPassword(email, password)
                                            .addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                                                @Override
                                                public void onComplete(@NonNull Task<AuthResult> task) {
                                                    if (!task.isSuccessful()) {
                                                        Toast.makeText(
                                                                Register.this,
                                                                "Authentication Failed",
                                                                Toast.LENGTH_LONG).show();
                                                        Log.v("error", task.getResult().toString());
                                                    } else {
                                                        Intent intent = new Intent(Register.this, home_page.class);
                                                        startActivity(intent);
                                                        finish();
                                                    }
                                                    PD.dismiss();
                                                }
                                            });
                                } else {
                                    Toast.makeText(
                                            Register.this,
                                            "Fill All Fields",
                                            Toast.LENGTH_LONG).show();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        }
                        else
                        {
                            Toast.makeText(Register.this, "Email already exists!", Toast.LENGTH_LONG).show();
                        }

                    }
                });


            }
        });




    }

}







