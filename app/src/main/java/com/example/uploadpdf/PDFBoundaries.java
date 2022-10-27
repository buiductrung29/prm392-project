package com.example.uploadpdf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class PDFBoundaries extends AppCompatActivity {

    PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfboundaries);
        pdfView = findViewById(R.id.pdfBound);
        pdfView.fromAsset("Boundaries.pdf").load();
    }
}