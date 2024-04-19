package com.xiaopeng.device.communication.account.a;

import com.xiaopeng.device.communication.account.bean.MqttAccountBean;
/* compiled from: AccountInitSuccessEvent.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private MqttAccountBean f2189a;

    public b(MqttAccountBean mqttAccountBean) {
        this.f2189a = mqttAccountBean;
    }

    public MqttAccountBean a() {
        return this.f2189a;
    }

    public String toString() {
        return "AccountInitSuccessEvent{content='" + this.f2189a + "'}";
    }
}
