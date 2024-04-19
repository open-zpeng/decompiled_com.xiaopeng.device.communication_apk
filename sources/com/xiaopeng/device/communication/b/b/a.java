package com.xiaopeng.device.communication.b.b;

import com.xiaopeng.device.communication.App;
/* compiled from: McuCallbackAdapter.java */
/* loaded from: classes.dex */
public class a extends com.xiaopeng.device.communication.b.a.a {
    @Override // com.xiaopeng.device.communication.b.a.a
    protected void a(int i, Object obj) {
        b.d.b.e.c.a("McuCallbackAdapter", "onChangeEvent: id = " + i + ",data = " + obj);
        if (557847561 == i) {
            try {
                int intValue = ((Integer) obj).intValue();
                if (1 == intValue || 2 == intValue) {
                    long b2 = com.xiaopeng.device.communication.account.b.a.a(App.c()).b();
                    b.d.b.e.c.l("McuCallbackAdapter", "onChangeEvent: localExpireTime = " + b2);
                    if (System.currentTimeMillis() > b2) {
                        b();
                    }
                    c();
                }
            } catch (Exception e) {
                b.d.b.e.c.t("McuCallbackAdapter", "onChangeEvent: type convert fail");
                e.printStackTrace();
            }
        }
    }

    protected void b() {
        throw null;
    }

    protected void c() {
        throw null;
    }
}
