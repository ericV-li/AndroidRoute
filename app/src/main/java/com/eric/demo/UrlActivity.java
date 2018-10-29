package com.eric.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.eric.route.link.UrlRouter;

/**
 * @author li
 * @Package com.eric.demo
 * @Title: SecondActivity
 * @Description: Copyright (c)
 * Create DateTime: 2018/10/23
 */
public class UrlActivity extends AppCompatActivity {
    private Button btn_to_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_url);

        btn_to_main = findViewById(R.id.btn_to_main);
        btn_to_main.setText(getIntent().getStringExtra("detail"));
        btn_to_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UrlRouter.from(UrlActivity.this).jumpToMain("eric://main/main");

            }
        });
    }


}
