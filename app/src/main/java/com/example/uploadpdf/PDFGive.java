package com.example.uploadpdf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class PDFGive extends AppCompatActivity {
    PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfgive);
        pdfView = findViewById(R.id.pdfGive);
        pdfView.fromAsset("Give and Take.pdf").load();
    }
}