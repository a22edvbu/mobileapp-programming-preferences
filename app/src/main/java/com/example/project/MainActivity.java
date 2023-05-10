package com.example.project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharePref;
    private SharedPreferences.Editor sharePrefEditor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sharePref = getPreferences(MODE_PRIVATE);
        sharePrefEditor = sharePref.edit();

        TextView prefTextRef=new TextView(this);
        prefTextRef = (TextView)findViewById(R.id.textView);
        prefTextRef.setText(sharePref.getString("sharedPrefString", "Du måste skriva in ditt namn för att det ska visas här."));

        Button buttonMain = findViewById(R.id.buttonGoSecond);
        buttonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent screenIntent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(screenIntent);
            }
        });
    }
}
