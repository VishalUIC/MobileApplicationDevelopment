package edu.vishal.cs478.gridviewproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by visha on 10/6/2017.
 */

public class ContextMenuWebPage extends AppCompatActivity {
    String urls[]={"https://www.acura.com/","https://www.audiusa.com/","http://www.honda.com/",
            "https://www.porsche.com/","https://www.mbusa.com/mercedes/index",
            "https://www.toyota.com/","http://www.lexus.com/","http://www.chevrolet.com/",
            "https://www.jaguarusa.com/index.html"
    };

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu_web_page);
        WebView webView = (WebView) findViewById(R.id.web_view); //Using web settings for enabling javascript and expanding image
        WebSettings settings = webView.getSettings();
        settings.setBuiltInZoomControls(true);
        settings.setJavaScriptEnabled(true); //Setting a webview client

        webView.setWebViewClient(new WebViewClient());

        Intent intent = getIntent();
        int pos1 = intent.getIntExtra("position",0);
        webView.loadUrl(urls[pos1]);    //Loading the click to website of the clicked image

    }
}
