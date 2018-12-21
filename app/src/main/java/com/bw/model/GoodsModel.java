package com.bw.model;

import com.bw.bean.Goods;
import com.bw.bean.Result;
import com.bw.util.HttpUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class GoodsModel {
//http://www.zhaoapi.cn/product/searchProducts?keywords=" + keywords + "&page=" + page
    public static Result getDataFromNet(String keywords,int page){
        String json = HttpUtils.get("http://www.zhaoapi.cn/product/searchProducts?keywords=" + keywords + "&page=" + page);
        Gson gson = new Gson();
        Type type = new TypeToken<Result<List<Goods>>>() {
        }.getType();
        Result result=gson.fromJson(json,type);
        return result;

    }
}
