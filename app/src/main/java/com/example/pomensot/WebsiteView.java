package com.example.pomensot;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebsiteView extends AppCompatActivity {

    WebView webView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website_view);

        webView = findViewById(R.id.webView);

        webView.setWebViewClient(new WebViewClient());

        webView.loadUrl("https://www.google.it/");
    }

    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
            Toast.makeText(this, "Going back inside a WebView", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "Exciting a WebView", Toast.LENGTH_SHORT).show();
            super.onBackPressed();
        }
    }
}