package com.eric.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.eric.route.data.LocalRouter;
import com.eric.route.data.RouteRequest;

import java.util.HashMap;

/**
 * @author li
 * @Package com.eric.demo
 * @Title: LocalActivity
 * @Description: Copyright (c)
 * Create DateTime: 2018/10/29
 */
public class LocalActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local);
        findViewById(R.id.btn_Local_data).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, Object> map = new HashMap<>();
                map.put("value", "路由回调成功");
                LocalRouter.getInstance().route(LocalActivity.this, new RouteRequest.Builder().provider
                        ("SecondProvider").data(map).action("SecondProviderAction").build());
                finish();
            }
        });
    }
}
