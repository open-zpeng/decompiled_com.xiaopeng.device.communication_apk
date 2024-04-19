package com.xiaopeng.device.communication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import b.d.b.e.i;
import com.xiaopeng.device.communication.c.b;
import com.xiaopeng.device.communication.messagecenter.c;
/* loaded from: classes.dex */
public class DcService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private b f2178a;

    /* renamed from: b  reason: collision with root package name */
    private c f2179b;

    /* renamed from: c  reason: collision with root package name */
    private com.xiaopeng.device.communication.trafficstatus.a f2180c;

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (DcService.this.f2179b != null) {
                DcService.this.f2179b.e();
            }
            if (DcService.this.f2180c != null) {
                DcService.this.f2180c.h();
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        b.d.b.e.c.a("DcService", "onCreate");
        super.onCreate();
        com.xiaopeng.device.communication.e.a.a().b(App.c());
        if (this.f2178a == null) {
            this.f2178a = new b();
        }
        if (this.f2179b == null) {
            this.f2179b = new c();
        }
        if (this.f2180c == null) {
            this.f2180c = new com.xiaopeng.device.communication.trafficstatus.a();
        }
        if (b.d.b.e.m.b.g()) {
            com.xiaopeng.device.communication.e.b.a();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        b bVar = this.f2178a;
        if (bVar != null) {
            bVar.a();
            this.f2178a = null;
        }
        c cVar = this.f2179b;
        if (cVar != null) {
            cVar.a();
            this.f2179b = null;
        }
        com.xiaopeng.device.communication.trafficstatus.a aVar = this.f2180c;
        if (aVar != null) {
            aVar.c();
            this.f2180c = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            b.d.b.e.c.a("DcService", "onStartCommand ： intent is null");
            return 1;
        }
        b.d.b.e.c.a("DcService", "onStartCommand ： " + intent.getAction());
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            i.h(0, new a());
        }
        return 1;
    }
}
