package com.xiaopeng.device.communication.account;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import b.d.b.e.c;
import b.d.b.e.e;
import b.d.b.e.g;
import com.xiaopeng.device.communication.App;
import com.xiaopeng.lib.http.CommonUtils;
/* loaded from: classes.dex */
public class AccountBroadcastReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("android.intent.action.BOOT_COMPLETED".equals(action)) {
            c.a("AccountBroadcastReceiver", "boot complete, start accountService");
            App.c().e(context, action);
        } else if (CommonUtils.ACTION_BROADCAST_ISF_SECURE_STORE_RELOAD.equals(action)) {
            c.a("AccountBroadcastReceiver", "receive ACTION_BROADCAST_ISF_SECURE_STORE_RELOAD, set vid -1 and reinit vid!");
            g.i(-1);
            App.c().e(context, action);
        } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            c.a("AccountBroadcastReceiver", "network change, start accountService");
            if (e.d(App.c())) {
                App.c().e(context, action);
            }
        }
    }
}
