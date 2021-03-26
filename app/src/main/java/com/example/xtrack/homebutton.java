package com.example.xtrack;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import pl.droidsonroids.gif.GifImageView;

public class homebutton extends AppCompatActivity {
    GifImageView button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_home);
        button = findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opentrackingphase();

            }

            private void opentrackingphase() {
                Intent intent = new Intent(getApplicationContext(), trackingphase.class);
                startActivity(intent);
            }
        });
    }}