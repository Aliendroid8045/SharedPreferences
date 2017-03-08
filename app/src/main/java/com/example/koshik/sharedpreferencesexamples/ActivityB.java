package com.example.koshik.sharedpreferencesexamples;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityB extends AppCompatActivity {
    EditText username, password;
    public static final String DEFAULT = "N/A";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        username = (EditText) findViewById(R.id.etname);
        password = (EditText) findViewById(R.id.etpassword);
    }

    public void Load(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        String nameLoad = sharedPreferences.getString("nameMain", DEFAULT);
        String passwordLoad = sharedPreferences.getString("passwordMain", DEFAULT);

        if (nameLoad.equals(DEFAULT) || passwordLoad.equals(DEFAULT)) {
            Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Data Loaded Successfully", Toast.LENGTH_SHORT).show();
            username.setText(nameLoad);
            password.setText(passwordLoad);
        }

    }

    public void Previous(View view) {
       // Intent intent = new Intent();
        startActivity(new Intent(ActivityB.this, MainActivity.class));
    }
}
