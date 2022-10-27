package com.example.uploadpdf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class PDFBadass extends AppCompatActivity {

    PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfbadass);
        pdfView = findViewById(R.id.pdfBadass);
        pdfView.fromAsset("Badass.pdf").load();
    }
}