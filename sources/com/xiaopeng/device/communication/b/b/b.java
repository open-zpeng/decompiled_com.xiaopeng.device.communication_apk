package com.xiaopeng.device.communication.b.b;

import android.content.Context;
import com.xiaopeng.lib.framework.carcontrollermodule.R;
/* compiled from: McuListener.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private Context f2238a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f2239b;

    /* renamed from: c  reason: collision with root package name */
    private c f2240c;

    /* renamed from: d  reason: collision with root package name */
    private com.xiaopeng.device.communication.trafficstatus.a f2241d;
    private com.xiaopeng.device.communication.b.b.a e;

    /* compiled from: McuListener.java */
    /* loaded from: classes.dex */
    class a extends com.xiaopeng.device.communication.b.b.a {
        a() {
        }

        @Override // com.xiaopeng.device.communication.b.b.a
        protected void b() {
            b.d.b.e.c.l("McuListener", "reInitMQTTAccount");
            org.greenrobot.eventbus.c.d().n(new com.xiaopeng.device.communication.account.a.a());
        }

        @Override // com.xiaopeng.device.communication.b.b.a
        protected void c() {
            if (b.this.f2241d == null) {
                b.this.f2241d = new com.xiaopeng.device.communication.trafficstatus.a();
            }
            if (b.this.f2241d.d()) {
                b.d.b.e.c.a("McuListener", "sync traffic block status!");
                b.this.f2241d.h();
            }
        }
    }

    /* compiled from: McuListener.java */
    /* renamed from: com.xiaopeng.device.communication.b.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0094b {

        /* renamed from: a  reason: collision with root package name */
        private static final b f2243a = new b(null);
    }

    /* synthetic */ b(a aVar) {
        this();
    }

    public static b c() {
        return C0094b.f2243a;
    }

    private void e() {
        b.d.b.e.c.l("McuListener", "initCarAPI");
        c cVar = (c) com.xiaopeng.device.communication.b.a.c.g(R.styleable.AppCompatTheme_toolbarStyle);
        this.f2240c = cVar;
        cVar.b(this.e);
    }

    public b d(Context context) {
        this.f2238a = context;
        return this;
    }

    public void f() {
        if (this.f2239b) {
            return;
        }
        if (this.f2238a != null) {
            try {
                if (this.f2240c == null) {
                    e();
                    this.f2239b = true;
                    return;
                }
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        throw new RuntimeException("Not initialize yet!");
    }

    private b() {
        this.f2239b = false;
        this.e = new a();
    }
}
