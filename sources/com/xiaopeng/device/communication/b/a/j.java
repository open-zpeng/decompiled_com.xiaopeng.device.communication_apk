package com.xiaopeng.device.communication.b.a;

import android.car.Car;
import android.content.Context;
import android.util.Log;
import com.google.gson.JsonObject;
import com.xiaopeng.device.communication.App;
import com.xiaopeng.lib.framework.carcontrollermodule.R;
import com.xiaopeng.libconfig.ipc.BughunterConfig;
import com.xiaopeng.libconfig.ipc.IpcConfig;
/* compiled from: IcmCrashListener.java */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private Context f2225a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f2226b;

    /* renamed from: c  reason: collision with root package name */
    private k f2227c;

    /* renamed from: d  reason: collision with root package name */
    private i f2228d;

    /* compiled from: IcmCrashListener.java */
    /* loaded from: classes.dex */
    class a extends i {
        a() {
        }

        @Override // com.xiaopeng.device.communication.b.a.i
        protected void b(String str) {
            Log.i("IcmCrashListener", "IcmCrashCallbackAdapter.onIcmCrash");
            if ("Q1".equals(Car.getXpCduType())) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("senderPackageName", App.c().getPackageName());
                jsonObject.addProperty(BughunterConfig.APIROUTER_ICM_CRASH_KEY, str);
                com.xiaopeng.device.communication.a.e(IpcConfig.BughunterConfig.IPC_COMMAND_ID_ICM_CRASH, jsonObject.toString(), IpcConfig.App.APP_BUGHUNTER);
            }
        }
    }

    /* compiled from: IcmCrashListener.java */
    /* loaded from: classes.dex */
    private static final class b {

        /* renamed from: a  reason: collision with root package name */
        private static final j f2230a = new j(null);
    }

    /* synthetic */ j(a aVar) {
        this();
    }

    public static j a() {
        return b.f2230a;
    }

    private void c() {
        b.d.b.e.c.l("IcmCrashListener", "initCaiAPI");
        k kVar = (k) c.g(R.styleable.AppCompatTheme_windowActionBarOverlay);
        this.f2227c = kVar;
        kVar.b(this.f2228d);
    }

    public j b(Context context) {
        this.f2225a = context;
        return this;
    }

    public void d() {
        if (this.f2226b) {
            return;
        }
        if (this.f2225a != null) {
            try {
                if (this.f2227c == null) {
                    c();
                    this.f2226b = true;
                    return;
                }
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        throw new RuntimeException("Not initialize yet!!");
    }

    private j() {
        this.f2226b = false;
        this.f2228d = new a();
    }
}
