package com.example.uploadpdf;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class PDFtLiving extends AppCompatActivity {
    PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdftliving);
        pdfView = findViewById(R.id.pdfLiving);
        pdfView.fromAsset("Living.pdf").load();
    }
}