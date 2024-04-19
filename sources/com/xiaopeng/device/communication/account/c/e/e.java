package com.xiaopeng.device.communication.account.c.e;

import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.Log;
import com.xiaopeng.device.communication.account.AccountService;
import com.xiaopeng.device.communication.account.c.e.a;
import com.xiaopeng.lib.framework.netchannelmodule.messaging.profile.AbstractChannelProfile;
/* compiled from: StepCheckURLValidate.java */
/* loaded from: classes.dex */
public class e implements a {

    /* renamed from: a  reason: collision with root package name */
    private int f2205a = 0;

    private boolean a() {
        boolean z;
        String str = SystemProperties.get(AbstractChannelProfile.SYSTEM_PROPERTY_MQTT_COMM_URL, (String) null);
        if (TextUtils.isEmpty(str) || !TextUtils.isEmpty(b.d.b.e.l.a.b(str, "@!chxpzi#0109$+/"))) {
            z = true;
        } else {
            AccountService.b();
            z = false;
        }
        Log.i("AccountModel", "checkURLValidate  result:\t" + z);
        return z;
    }

    @Override // com.xiaopeng.device.communication.account.c.e.a
    public a.EnumC0093a execute() {
        Log.i("AccountModel", "StepCheckURLValidate execute");
        if (!a()) {
            int i = this.f2205a + 1;
            this.f2205a = i;
            if (i > 2) {
                Log.e("AccountModule", "StepCheckURLValidate error please check com_URL!");
                return a.EnumC0093a.EXECUTE_RESULT_FAIL;
            }
            return a.EnumC0093a.EXECUTE_RESULT_RESET;
        }
        this.f2205a = 0;
        return a.EnumC0093a.EXECUTE_RESULT_NEXT;
    }
}
