package com.example.asus.mybus;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class admin_activity extends AppCompatActivity{


    private String officialNumber = "pmpl";
    private String officialPassword = "pmpl";

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_activity);

        Context context = this;
        final EditText editTextMobile = findViewById(R.id.edittext_mobile_activity_admin);
        final EditText editTextPassword = findViewById(R.id.edittext_password_activity_admin);
        editTextPassword.setError("Atleast one number or symbol is required");
        Button buttonLogin = findViewById(R.id.button_login_activity_admin);

        buttonLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String mobileNumber = editTextMobile.getText().toString();
                String password = editTextPassword.getText().toString();

                if (TextUtils.isEmpty(mobileNumber))
                {
                    editTextMobile.setError("Required");
                    return;
                }

                if (mobileNumber.equals(officialNumber) && password.equals(officialPassword))
                {
                    Toast.makeText(admin_activity.this, "Login Success", Toast.LENGTH_SHORT).show();

                    Intent homeIntent = new Intent(admin_activity.this, Conductor_activity.class);
                    startActivity(homeIntent);
                }
                else
                {
                    Toast.makeText(admin_activity.this, "Login Failed !!!", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

}
