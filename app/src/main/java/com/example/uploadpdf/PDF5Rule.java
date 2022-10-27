package com.example.uploadpdf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class PDF5Rule extends AppCompatActivity {

    PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf5_rule);
        pdfView = findViewById(R.id.pdf5rule);
        pdfView.fromAsset("5 Rule.pdf").load();
    }
}