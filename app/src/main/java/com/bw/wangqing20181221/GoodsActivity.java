package com.bw.wangqing20181221;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.bw.adapter.MyAdapter;
import com.bw.bean.Goods;
import com.bw.bean.Result;
import com.bw.core.DataCall;
import com.bw.presenter.GoodsPresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

public class GoodsActivity extends AppCompatActivity implements View.OnClickListener, DataCall<List<Goods>> {

    private XRecyclerView xrecy;
    private EditText edit_text;
    private Button btn_back;
    private Button btn_search;
    private Button btn_sou;
    private GoodsPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods);
        presenter = new GoodsPresenter(this);
        btn_back = findViewById(R.id.btn_back);
        btn_sou = findViewById(R.id.btn_sou);
        edit_text = findViewById(R.id.edit_text);
        xrecy = findViewById(R.id.xrecy);
        btn_back.setOnClickListener(this);
        btn_sou.setOnClickListener(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
        xrecy.setLayoutManager(gridLayoutManager);
        MyAdapter myAdapter = new MyAdapter(this);
        xrecy.setAdapter(myAdapter);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.btn_sou://搜索
                int page = 1;
                String sou = edit_text.getText().toString();
                presenter.requestData(true,sou);
                break;
        }
    }

    @Override
    public void loadSuccess(List<Goods> data) {

    }

    @Override
    public void loadError(Result result) {

    }


}
