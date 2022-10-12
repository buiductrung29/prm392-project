package com.fptu.bookaholic.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.fptu.bookaholic.R;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();
    }
}