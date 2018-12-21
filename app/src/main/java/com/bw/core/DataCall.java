package com.bw.core;

import com.bw.bean.Result;

public interface DataCall<T> {
    void loadSuccess(T data);
    void loadError(Result result);
}
