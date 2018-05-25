package com.example.android.androidjokes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainLibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library_main);

        Intent intent = getIntent();

        String importedJoke = intent.getStringExtra("Joke");

        TextView textView = findViewById(R.id.textView);
        textView.setText(importedJoke);
    }
}