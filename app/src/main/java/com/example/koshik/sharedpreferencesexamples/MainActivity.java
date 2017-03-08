package com.example.koshik.sharedpreferencesexamples;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText passWord, userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        passWord = (EditText) findViewById(R.id.etpassword);
        userName = (EditText) findViewById(R.id.etname);
    }

    public void Next(View view) {
        Toast.makeText(this, "Data was Saved Successfully ", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, ActivityB.class);
        startActivity(intent);

    }

    public void Save(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("nameMain", userName.getText().toString());
        editor.putString("passwordMain", passWord.getText().toString());
        editor.commit();
    }

}



