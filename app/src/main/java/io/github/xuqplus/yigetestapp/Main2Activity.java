package io.github.xuqplus.yigetestapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

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
    }

    private void onclick1(String content) {
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
    }
}
