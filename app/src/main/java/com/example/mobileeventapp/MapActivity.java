package com.example.mobileeventapp;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MapActivity extends AppCompatActivity {


    @SuppressLint("SetJavaScriptEnabled")
    private WebView myWebView;
    private String url ="https://osm.org/go/0OPjbxI--?m=";
    private String location="&map_id=Skyrim";
    private String filter="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        this.setTitle("ReportMap");
        // Obtain the webView by ID
        /*WebView*/myWebView = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        // performance hacks!
        webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        //webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);

        // multi-touch zoom
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        //myWebView.loadUrl("https://www.google.com");


        myWebView.loadUrl(url);
        myWebView.setWebViewClient(new WebViewClient());


    }
}
