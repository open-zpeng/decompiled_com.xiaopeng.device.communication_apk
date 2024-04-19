package com.xiaopeng.device.communication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.UserHandle;
import b.d.b.e.c;
import b.d.b.e.i;
/* loaded from: classes.dex */
public class AppBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private com.xiaopeng.device.communication.trafficstatus.a f2176a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AppBroadcastReceiver.this.f2176a == null) {
                AppBroadcastReceiver.this.f2176a = new com.xiaopeng.device.communication.trafficstatus.a(false);
            }
            AppBroadcastReceiver.this.f2176a.h();
        }
    }

    private void c() {
        i.h(0, new a());
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        c.a("AppBroadcastReceiver", "Action-->" + action);
        if (!"com.xiaopeng.action.CLIENT_SSL_UPDATE".equals(action) && !"com.xiaopeng.broadcast.ACTION_TOKEN_GOTTEN".equals(action)) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                Intent intent2 = new Intent(context, DcService.class);
                intent2.setAction("android.net.conn.CONNECTIVITY_CHANGE");
                context.startServiceAsUser(intent2, UserHandle.CURRENT);
                return;
            }
            return;
        }
        com.xiaopeng.device.communication.e.a.a().f();
        c();
    }
}
