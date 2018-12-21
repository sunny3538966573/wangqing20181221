package com.bw.wangqing20181221;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.view.FlowLayout;

public class MainActivity extends AppCompatActivity {


    private EditText edit_search;
    private TextView text_search;
    private FlowLayout flow01;
    private FlowLayout flow02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_search = findViewById(R.id.edit_search);
        text_search = findViewById(R.id.text_search);
        flow01 = findViewById(R.id.flow01);
        flow02 = findViewById(R.id.flow02);

        String[] string=new String[]{
                "外套","毛衣","面霜"
        };
        for (int i = 0; i <string.length ; i++) {
            flow02.getData(string[i]);
        }
        text_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = edit_search.getText().toString();
                if (TextUtils.isEmpty(data)){
                    Toast.makeText(MainActivity.this,"请输入内容",Toast.LENGTH_LONG).show();
                }else {
                    flow01.getData(data);
                }
                Intent intent=new Intent(MainActivity.this,GoodsActivity.class);
                startActivity(intent);

            }
        });

    }
}
