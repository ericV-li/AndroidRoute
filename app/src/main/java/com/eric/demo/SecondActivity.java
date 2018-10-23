package com.eric.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.eric.route.link.UrlRouter;

/**
 * @author shangfu.li
 * @Package com.eric.demo
 * @Title: SecondActivity
 * @Description: Copyright (c)
 * Create DateTime: 2018/10/23
 */
public class SecondActivity extends AppCompatActivity {
    private TextView txt_app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_app =findViewById(R.id.txt_app);
        txt_app.setText(getIntent().getStringExtra("detail"));
        txt_app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UrlRouter.from(SecondActivity.this).jumpToMain("eric://main/main");
            }
        });
    }
}
