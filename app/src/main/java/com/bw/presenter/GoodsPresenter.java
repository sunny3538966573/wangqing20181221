package com.bw.presenter;

import android.os.Handler;
import android.os.Message;

import com.bw.bean.Result;
import com.bw.core.BasePresenter;
import com.bw.core.DataCall;
import com.bw.model.GoodsModel;

public class GoodsPresenter extends BasePresenter {

    //定义页数和是否刷新
    private int page=1;
    private boolean isRefresh=true;
    public GoodsPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Result getDatashuju(Object... args) {
        isRefresh= (boolean) args[0];//设置args[0]为刷新

        if (isRefresh){//刷新
            page=1;
        }else {
            page++;
        }
        Result result = GoodsModel.getDataFromNet((String) args[1], page);
        return result;
    }



    public boolean isRefresh(){
        return isRefresh;
    }


}
