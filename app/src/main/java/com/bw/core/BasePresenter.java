package com.bw.core;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.bw.bean.Result;

public abstract class BasePresenter {

    DataCall dataCall;

    public BasePresenter(DataCall dataCall){
        this.dataCall = dataCall;
    }


    Handler mHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {

            Result result = (Result) msg.obj;
            if (result.getCode()==0){
                dataCall.loadSuccess(result.getData());
            }else{
                dataCall.loadError(result);
            }
        }
    };



    public void requestData(final Object...args){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Message message = mHandler.obtainMessage();
                message.obj = getDatashuju(args);
                mHandler.sendMessage(message);

            }
        }).start();
    }

    protected abstract Result getDatashuju(Object...args);

    public void unBindCall(){
        this.dataCall = null;
    }

}

