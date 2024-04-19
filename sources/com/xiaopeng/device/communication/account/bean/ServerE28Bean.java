package com.xiaopeng.device.communication.account.bean;

import com.google.gson.annotations.SerializedName;
/* loaded from: classes.dex */
public class ServerE28Bean<T> {
    @SerializedName("code")
    private int mCode;
    @SerializedName("data")
    private T mData;
    @SerializedName("msg")
    private String mMsg;

    public int getCode() {
        return this.mCode;
    }

    public T getData() {
        return this.mData;
    }

    public String getMsg() {
        return this.mMsg;
    }

    public void setCode(int i) {
        this.mCode = i;
    }

    public void setData(T t) {
        this.mData = t;
    }

    public void setMsg(String str) {
        this.mMsg = str;
    }
}
