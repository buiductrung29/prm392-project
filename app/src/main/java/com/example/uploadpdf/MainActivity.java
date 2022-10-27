package com.example.uploadpdf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imgLiving,imgRule,imgGivebook,imgBadass,imgBoudarie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgLiving = findViewById(R.id.tLiving);
        imgRule = findViewById(R.id.tRule);
        imgGivebook = findViewById(R.id.tGive);
        imgBadass = findViewById(R.id.tBadass);
        imgBoudarie = findViewById(R.id.tBound);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//            Intent intent = new Intent(MainActivity.this,PDFActivity.class);
//            startActivity(intent);
//            }
//        });
        imgGivebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PDFGive.class);
                startActivity(intent);
            }
        });
        imgLiving.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PDFtLiving.class);
                startActivity(intent);
            }
        });
        imgRule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PDF5Rule.class);
                startActivity(intent);
            }
        });
        imgBadass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PDFBadass.class);
                startActivity(intent);
            }
        });
        imgBoudarie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PDFBoundaries.class);
                startActivity(intent);
            }
        });
    }
}