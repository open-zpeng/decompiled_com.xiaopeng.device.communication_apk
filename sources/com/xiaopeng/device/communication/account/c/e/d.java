package com.xiaopeng.device.communication.account.c.e;

import com.xiaopeng.device.communication.App;
import com.xiaopeng.device.communication.account.c.e.a;
/* compiled from: StepCheckNetwork.java */
/* loaded from: classes.dex */
public class d implements a {
    @Override // com.xiaopeng.device.communication.account.c.e.a
    public a.EnumC0093a execute() {
        if (!b.d.b.e.e.d(App.c())) {
            b.d.b.e.c.a("AccountModel", "Network not available, return fail!");
            return a.EnumC0093a.EXECUTE_RESULT_FAIL;
        }
        b.d.b.e.c.a("AccountModel", "Network available, return next!");
        return a.EnumC0093a.EXECUTE_RESULT_NEXT;
    }
}
