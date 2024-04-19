package com.xiaopeng.device.communication.account.b;

import android.content.Context;
import b.d.b.e.f;
/* compiled from: SharedPreferenceHelper.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f2190a;

    /* renamed from: b  reason: collision with root package name */
    private Context f2191b;

    private a(Context context) {
        this.f2191b = context.getApplicationContext();
    }

    public static a a(Context context) {
        if (f2190a == null) {
            synchronized (a.class) {
                if (f2190a == null) {
                    f2190a = new a(context);
                }
            }
        }
        return f2190a;
    }

    public long b() {
        return f.b(f2190a.f2191b).c("mqtt_account_expire_time", 0L);
    }

    public void c(long j) {
        f.b(this.f2191b).i("mqtt_account_expire_time", j);
    }
}
