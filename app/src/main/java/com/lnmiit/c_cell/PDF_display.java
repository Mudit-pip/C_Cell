package com.lnmiit.c_cell;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.pdf.PdfRenderer;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PDF_display extends AppCompatActivity {

    private WebView pdfWebView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pdf_display);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        pdfWebView = findViewById(R.id.pdfWebView);
        progressBar = findViewById(R.id.progressBar);


        WebSettings webSettings = pdfWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);


        pdfWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                progressBar.setVisibility(View.GONE);
                pdfWebView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                showError();
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                showError();
            }
        });

        pdfWebView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                if (progress < 100) {
                    progressBar.setVisibility(View.VISIBLE);
                } else {
                    progressBar.setVisibility(View.GONE);
                }
            }
        });

        loadPdf();

    }


    private void loadPdf() {
        pdfWebView.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);

        Intent intent = getIntent();
        String pdfUrl = intent.getStringExtra("pdfUrl");
        int op = intent.getIntExtra("operation", 1);

        if (pdfUrl != null) {
            if (op == 0) {
                pdfWebView.loadUrl(pdfUrl);
            } else {
                pdfWebView.loadUrl("https://docs.google.com/gview?embedded=true&url=" + pdfUrl);
            }
        } else {
            showError();
        }
    }

    private void showError() {
        progressBar.setVisibility(View.GONE);
        Toast.makeText(this, "Error loading PDF", Toast.LENGTH_SHORT).show();
    }

    private void injectCSS() {
        try {
            pdfWebView.loadUrl("javascript:(function() {" +
                    "var style = document.createElement('style');" +
                    "style.innerHTML = 'body { display: flex; justify-content: center; align-items: center; height: 100vh; }';" +
                    "document.head.appendChild(style);" +
                    "})()");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}