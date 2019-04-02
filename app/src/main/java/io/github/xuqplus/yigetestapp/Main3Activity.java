package io.github.xuqplus.yigetestapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.SyncHttpClient;

import cz.msebera.android.httpclient.Header;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button button0 = findViewById(R.id.button_0);
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclick0("点击了, 0号按钮");
            }
        });

        Button button1 = findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclick1("点击了, 1号按钮");
            }
        });
    }

    private void onclick0(String content) {
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show();

        final SyncHttpClient client = new SyncHttpClient();
        final String url = String.format("http://106.12.80.76:8090/");
        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                final String r = new String(responseBody);
                Log.i("xposed yigetestapp", String.format("onSuccess r=%s", r));
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                final String r = new String(responseBody);
                Log.i("xposed yigetestapp", String.format("onFailure r=%s", r));
            }
        });
    }

    private void onclick1(String content) {
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show();

        final SyncHttpClient client = new SyncHttpClient();
        final String url = String.format("https://www.baidu.com");
        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                final String r = new String(responseBody);
                Log.i("xposed yigetestapp", String.format("onSuccess r=%s", r));
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                final String r = new String(responseBody);
                Log.i("xposed yigetestapp", String.format("onFailure r=%s", r));
            }
        });
    }
}
