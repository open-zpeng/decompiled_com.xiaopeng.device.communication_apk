package com.xiaopeng.device.communication.messagecenter;

import com.xiaopeng.libconfig.ipc.bean.MessageCenterBean;
/* compiled from: MessageCenterEvent.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private MessageCenterBean f2266a;

    public a(MessageCenterBean messageCenterBean) {
        this.f2266a = messageCenterBean;
    }

    public MessageCenterBean a() {
        return this.f2266a;
    }

    public String toString() {
        return "MessageCenterEvent{bean=" + this.f2266a + '}';
    }
}
