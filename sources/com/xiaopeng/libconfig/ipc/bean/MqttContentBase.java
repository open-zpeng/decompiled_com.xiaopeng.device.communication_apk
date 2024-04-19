package com.xiaopeng.libconfig.ipc.bean;
/* loaded from: classes.dex */
public class MqttContentBase<T> {
    public static final int CODE_SUCCESS = 200;
    public static final int RESPONSE_TYPE_RECIEVED = 1;
    public static final int RESPONSE_TYPE_SUCCESS = 99;
    private int code;
    private T data;
    private int respType;

    public int getCode() {
        return this.code;
    }

    public T getData() {
        return this.data;
    }

    public int getRespType() {
        return this.respType;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setData(T t) {
        this.data = t;
    }

    public void setRespType(int i) {
        this.respType = i;
    }
}
