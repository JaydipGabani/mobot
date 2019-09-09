package com.example.hit.stream;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.HttpAuthHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.google.android.gms.common.api.GoogleApiClient;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    Button t;
  //  Bitmap bitmap;
    View view;
    ByteArrayOutputStream bytearrayoutputstream;
    File file;
    FileOutputStream fileoutputstream;
    final Activity activity = this;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView mWebView = (WebView) findViewById(R.id.webView);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        mWebView.getSettings().setDomStorageEnabled(true);
        mWebView.getSettings().setLoadWithOverviewMode(true);
        mWebView.getSettings().setUseWideViewPort(true);
        mWebView.getSettings().setBuiltInZoomControls(true);
        mWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        mWebView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        mWebView.getSettings().setPluginState(WebSettings.PluginState.ON);
        mWebView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                activity.setProgress(progress * 1000);
            }
        });
        // String s = getIntent().getStringExtra("name");
//        TextView t=(TextView)findViewById(R.id.textView);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setFocusable(true);
        mWebView.loadUrl("http://192.168.43.176:8080/stream/getvideo");
        mWebView.setWebViewClient(new WebViewClient() {

            @Override
            public void onReceivedHttpAuthRequest(WebView view,
                                                  HttpAuthHandler handler, String host, String realm) {
                handler.proceed("admin", "YWJjMTIzNDU2Nzg5");
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

//        t = (Button)findViewById(R.id.button);
//
//        bytearrayoutputstream = new ByteArrayOutputStream();
//        // ATTENTION: This was auto-generated to implement the App Indexing API.
//        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
//    }
//
//    t.setOnClickListener(new View.OnClickListener()
//    {
//        //@Override
//        public void onClick(View OnclickView){
//            view = OnclickView.getRootView();
//
//            view.setDrawingCacheEnabled(true);
//
//            bitmap = view.getDrawingCache();
//
////                ScreenShotHold.setImageBitmap(bitmap);
//
//            Date now = new Date();
//            DateFormat.format("yyyy-MM-dd_hh:mm:ss", now);
//
//            bitmap.compress(Bitmap.CompressFormat.PNG, 60, bytearrayoutputstream);
//            file = new File(Environment.getExternalStorageDirectory() + "/Mobot/" + now + ".png");
//        try
//        {
//            file.createNewFile();
//            fileoutputstream = new FileOutputStream(file);
//            fileoutputstream.write(bytearrayoutputstream.toByteArray());
//            fileoutputstream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    //}
    }
//        mWebView.setWebViewClient(new WebViewClient() {
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                return false;
//            }
//        });
//        String x="192.168.0.106:8080/stream/getvideo";
//        mWebView.loadUrl(x);

}



