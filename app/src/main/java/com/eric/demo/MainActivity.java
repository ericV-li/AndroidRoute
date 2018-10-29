package com.eric.demo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.eric.route.data.IAction;
import com.eric.route.data.LocalRouter;
import com.eric.route.data.Provider;
import com.eric.route.data.RouteResponse;
import com.eric.route.data.RouteResultListener;
import com.eric.route.link.UrlRouter;

import java.util.HashMap;

/**
 * @author li
 * @Package com.eric.demo
 * @Title: MainActivity
 * @Description: Copyright (c)
 * Create DateTime: 2018/10/25
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener, IAction {
    private TextView txt_app;
    private Button btn_Url, btn_Local;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        register();
        btn_Url = findViewById(R.id.btn_Url);
        btn_Local = findViewById(R.id.btn_Local);
        txt_app = findViewById(R.id.txt_app);

        btn_Url.setOnClickListener(this);
        btn_Local.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_Url:
                Bundle bundle = new Bundle();
                bundle.putString("detail", "我要准备跳转哪里呢，你们猜");
                UrlRouter.from(MainActivity.this).params(bundle).jump("eric://trade/detail");
                break;
            case R.id.btn_Local:
                UrlRouter.from(MainActivity.this).jump("eric://trade/local");
                break;
        }
    }

    @Override
    public RouteResponse invoke(Context context, HashMap<String, Object> requestData) {
        String value = String.valueOf(requestData.get("value"));
        txt_app.setText(value);
        return null;
    }


    @Override
    public void asyncInvoke(Context context, HashMap<String, Object> requestData, RouteResultListener listener) {

    }

    private void register() {
        LocalRouter.getInstance().registerProvider("SecondProvider", new Provider() {
            @Override
            protected void registerActions() {
                registerAction("SecondProviderAction", MainActivity.this);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocalRouter.getInstance().unRegisterProvider("SecondProvider");
    }
}
