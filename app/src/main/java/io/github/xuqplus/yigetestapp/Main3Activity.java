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
        try {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    final SyncHttpClient client = new SyncHttpClient();
                    final String url = String.format("http://106.12.80.76:8090/");
                    client.get(url, new AAA());
                }
            }).start();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    private void onclick1(String content) {
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
        try {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    final SyncHttpClient client = new SyncHttpClient();
                    final String url = String.format("https://www.aliyun.com/");
                    client.get(url, new AAA());
                }
            }).start();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public static class AAA extends AsyncHttpResponseHandler {
        @Override
        public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
            try {
                final String r = new String(responseBody);
                Log.i("xposed yigetestapp", String.format("AAA onSuccess url=%s", r));
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }

        @Override
        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
            try {
                final String r = new String(responseBody);
                Log.i("xposed yigetestapp", String.format("AAA onFailure url=%s", r));
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }
}
