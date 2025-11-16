package com.neuropediatoolkit;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class WebViewActivity extends AppCompatActivity {

    private WebView webView;
    private FloatingActionButton closeButton;
    private FloatingActionButton shareButton;
    private ProgressBar progressBar;
    private String currentUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        // Get URL from intent
        currentUrl = getIntent().getStringExtra("url");
        if (currentUrl == null) {
            finish();
            return;
        }

        // Initialize views
        webView = findViewById(R.id.webView);
        closeButton = findViewById(R.id.closeButton);
        shareButton = findViewById(R.id.shareButton);
        progressBar = findViewById(R.id.progressBar);

        // Configure WebView
        setupWebView();

        // Set up buttons
        closeButton.setOnClickListener(v -> finish());
        shareButton.setOnClickListener(v -> shareUrl());

        // Load URL
        webView.loadUrl(currentUrl);
    }

    private void setupWebView() {
        WebSettings webSettings = webView.getSettings();
        
        // Habilitar JavaScript
        webSettings.setJavaScriptEnabled(true);
        
        // Habilitar zoom
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        
        // Configurar para móvil
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        
        // Mejor renderizado
        webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        webSettings.setDomStorageEnabled(true);
        webSettings.setDatabaseEnabled(true);
        
        // User agent móvil (fuerza versión móvil de sitios)
        String userAgent = webSettings.getUserAgentString();
        webSettings.setUserAgentString(userAgent.replace("wv", ""));
        
        // WebViewClient para manejar navegación
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                currentUrl = url;
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        // WebChromeClient para progreso de carga
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                progressBar.setProgress(newProgress);
            }
        });
    }

    private void shareUrl() {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, currentUrl);
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, webView.getTitle());
        startActivity(Intent.createChooser(shareIntent, "Compartir"));
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
            // Animación al cerrar (desliza hacia la derecha)
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        }
    }

    @Override
    public void finish() {
        super.finish();
        // Animación al cerrar (desliza hacia la derecha)
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    @Override
    protected void onDestroy() {
        if (webView != null) {
            webView.destroy();
        }
        super.onDestroy();
    }
}
