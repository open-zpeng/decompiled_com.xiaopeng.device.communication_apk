package com.xiaopeng.device.communication.account.c.e;

import android.os.SystemProperties;
import android.text.TextUtils;
import b.d.b.e.g;
import com.xiaopeng.device.communication.account.c.e.a;
/* compiled from: StepCheckHardwareId.java */
/* loaded from: classes.dex */
public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private int f2204a = 0;

    private a.EnumC0093a a() {
        int i = this.f2204a + 1;
        this.f2204a = i;
        if (i < 5) {
            b.d.b.e.c.a("AccountModel", "check hardwareId fail, retry=" + this.f2204a + ", return retry!");
            return a.EnumC0093a.EXECUTE_RESULT_RETRY;
        }
        b.d.b.e.c.a("AccountModel", "check hardwareId and retry>=5, return fail!");
        this.f2204a = 0;
        return a.EnumC0093a.EXECUTE_RESULT_FAIL;
    }

    private boolean b() {
        try {
            String str = SystemProperties.get("persist.sys.mcu.hardwareId");
            b.d.b.e.c.a("AccountModel", "try2GetHardwareId hardwareId-->" + str);
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            g.h(str);
            return true;
        } catch (Exception e) {
            b.d.b.e.c.u("AccountModel", "getMcuHardwareId error!", e);
            return false;
        }
    }

    @Override // com.xiaopeng.device.communication.account.c.e.a
    public a.EnumC0093a execute() {
        if (TextUtils.isEmpty(g.c())) {
            if (b()) {
                b.d.b.e.c.a("AccountModel", "get hardwareId success, return next!");
                return a.EnumC0093a.EXECUTE_RESULT_NEXT;
            }
            b.d.b.e.c.a("AccountModel", "TextUtils.isEmpty(hardwareId), return delay!");
            return a();
        }
        b.d.b.e.c.a("AccountModel", "getHardwareId success, return next!");
        return a.EnumC0093a.EXECUTE_RESULT_NEXT;
    }
}
