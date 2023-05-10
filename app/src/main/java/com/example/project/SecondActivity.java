package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private SharedPreferences sharePref;
    private SharedPreferences.Editor sharePrefEditor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        sharePref = getSharedPreferences("sharedPrefString", MODE_PRIVATE);
        sharePrefEditor = sharePref.edit();
        EditText addName = findViewById(R.id.editTextAddName);
        addName.setText(sharePref.getString("sharedPrefString", "Du måste skriva in ditt namn för att det ska visas här."));

        Button buttonSecond = findViewById(R.id.buttonSend);
        buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent screenIntent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(screenIntent);
            }
        });
    }
    public void storedPrefData() {
        EditText editText = findViewById(R.id.editTextAddName);
        sharePrefEditor.putString("sharedPrefString", editText.getText().toString());
        sharePrefEditor.apply();
    }
}