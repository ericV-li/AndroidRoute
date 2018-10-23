package com.eric.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.eric.route.link.UrlRouter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txt_app = findViewById(R.id.txt_app);
        final Bundle bundle = new Bundle();
        bundle.putString("detail", "啦啦啦啦啦啦");
        txt_app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UrlRouter.from(MainActivity.this).params(bundle).jump("eric://trade/detail");
            }
        });
    }
}
