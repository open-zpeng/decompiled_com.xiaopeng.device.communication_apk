package com.xiaopeng.device.communication.messagecenter.push;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import b.d.b.e.i;
import com.xiaopeng.device.communication.App;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.Callback;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IHttp;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IResponse;
import com.xiaopeng.lib.framework.netchannelmodule.NetworkChannelsEntry;
import com.xiaopeng.lib.http.CommonUtils;
import com.xiaopeng.lib.http.Security;
import com.xiaopeng.libconfig.ipc.AccountConfig;
import com.xiaopeng.libconfig.ipc.IpcConfig;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: MessageCenterPushHelper.java */
/* loaded from: classes.dex */
public class d implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    private e f2292a = new e();

    /* renamed from: b  reason: collision with root package name */
    private Handler f2293b = new Handler(i.g(0), this);

    /* renamed from: c  reason: collision with root package name */
    private List<com.xiaopeng.device.communication.messagecenter.push.a> f2294c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MessageCenterPushHelper.java */
    /* loaded from: classes.dex */
    public class a implements Callback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f2295a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.xiaopeng.device.communication.messagecenter.push.a f2296b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f2297c;

        a(boolean z, com.xiaopeng.device.communication.messagecenter.push.a aVar, boolean z2) {
            this.f2295a = z;
            this.f2296b = aVar;
            this.f2297c = z2;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.Callback
        public void onFailure(IResponse iResponse) {
            b.d.b.e.c.u("MessageCenterPushHelper", "send error:" + iResponse.body() + " code:" + iResponse.code(), iResponse.getException());
            d.this.h(this.f2296b, this.f2297c, this.f2295a);
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.Callback
        public void onSuccess(IResponse iResponse) {
            b.d.b.e.c.t("MessageCenterPushHelper", "send success:" + iResponse.body() + " code:" + iResponse.code());
            if (this.f2295a) {
                d.this.f2292a.b(this.f2296b);
                d.this.f2293b.sendEmptyMessage(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MessageCenterPushHelper.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.xiaopeng.device.communication.messagecenter.push.a f2299a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f2300b;

        b(com.xiaopeng.device.communication.messagecenter.push.a aVar, boolean z) {
            this.f2299a = aVar;
            this.f2300b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.m(this.f2299a, false, this.f2300b);
        }
    }

    private void e() {
        List<com.xiaopeng.device.communication.messagecenter.push.a> list = this.f2294c;
        if (list != null) {
            list.clear();
        }
        this.f2294c = null;
    }

    private com.xiaopeng.device.communication.messagecenter.push.a f(Bundle bundle) {
        return new com.xiaopeng.device.communication.messagecenter.push.a(bundle.getString(IpcConfig.DeviceCommunicationConfig.KEY_APP_MESSAGE_EVENT_NAME), bundle.getString(IpcConfig.DeviceCommunicationConfig.KEY_APP_MESSAGE_PARAMS), System.currentTimeMillis());
    }

    private com.xiaopeng.device.communication.messagecenter.push.a g(JSONObject jSONObject) {
        String str;
        String str2 = null;
        try {
            str = jSONObject.getString(IpcConfig.DeviceCommunicationConfig.KEY_APP_MESSAGE_EVENT_NAME);
            try {
                str2 = jSONObject.getString(IpcConfig.DeviceCommunicationConfig.KEY_APP_MESSAGE_PARAMS);
            } catch (JSONException e) {
                e = e;
                e.printStackTrace();
                return new com.xiaopeng.device.communication.messagecenter.push.a(str, str2, System.currentTimeMillis());
            }
        } catch (JSONException e2) {
            e = e2;
            str = null;
        }
        return new com.xiaopeng.device.communication.messagecenter.push.a(str, str2, System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(com.xiaopeng.device.communication.messagecenter.push.a aVar, boolean z, boolean z2) {
        b.d.b.e.c.a("MessageCenterPushHelper", "onSendFail message:" + aVar + " retry:" + z + " deleteIfSuccess:" + z2);
        if (z) {
            b.d.b.e.c.a("MessageCenterPushHelper", "retry to send 30s later...");
            this.f2293b.postDelayed(new b(aVar, z2), 30000L);
        } else if (!z2) {
            b.d.b.e.c.a("MessageCenterPushHelper", "mModel.save(message);");
            this.f2292a.e(aVar);
        } else {
            b.d.b.e.c.a("MessageCenterPushHelper", "resend fail, clear list and return");
            e();
        }
    }

    private void l() {
        List<com.xiaopeng.device.communication.messagecenter.push.a> list = this.f2294c;
        if (list != null && !list.isEmpty()) {
            m(this.f2294c.remove(0), true, true);
            return;
        }
        b.d.b.e.c.l("MessageCenterPushHelper", "No more available push message, cleanExpired!");
        this.f2292a.a();
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(com.xiaopeng.device.communication.messagecenter.push.a aVar, boolean z, boolean z2) {
        b.d.b.e.c.a("MessageCenterPushHelper", "send message:" + aVar + " retry:" + z + " deleteIfSuccess:" + z2);
        if (!b.d.b.e.e.d(App.c())) {
            b.d.b.e.c.a("MessageCenterPushHelper", "network not available, return!");
            h(aVar, z, z2);
            return;
        }
        HashMap hashMap = new HashMap();
        long currentTimeMillis = System.currentTimeMillis();
        hashMap.put(AccountConfig.KEY_APP_ID, CommonUtils.CAR_APP_ID);
        hashMap.put(AccountConfig.KEY_TIMESTAMP, String.valueOf(currentTimeMillis));
        hashMap.put("event", aVar.a());
        hashMap.put(IpcConfig.DeviceCommunicationConfig.KEY_APP_MESSAGE_PARAMS, aVar.c());
        hashMap.put("ts", String.valueOf(aVar.d()));
        hashMap.put(AccountConfig.KEY_SIGN, Security.sign(App.c(), hashMap, currentTimeMillis));
        ((IHttp) Module.get(NetworkChannelsEntry.class).get(IHttp.class)).bizHelper().post(com.xiaopeng.device.communication.d.a.f, com.xiaopeng.device.communication.f.a.a().toJson(hashMap)).build().execute(new a(z2, aVar, z));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            l();
        }
        return true;
    }

    public void i(Bundle bundle) {
        com.xiaopeng.device.communication.messagecenter.push.a f = f(bundle);
        b.d.b.e.c.a("MessageCenterPushHelper", "pushMessage:" + f);
        if (TextUtils.isEmpty(f.a())) {
            b.d.b.e.c.f("MessageCenterPushHelper", "eventName can't be empty, return!");
        } else {
            m(f, true, false);
        }
    }

    public void j(JSONObject jSONObject) {
        com.xiaopeng.device.communication.messagecenter.push.a g = g(jSONObject);
        b.d.b.e.c.a("MessageCenterPushHelper", "pushMessage:" + g);
        if (TextUtils.isEmpty(g.a())) {
            b.d.b.e.c.f("MessageCenterPushHelper", "eventName can't be empty, return!");
        } else {
            m(g, true, false);
        }
    }

    public void k() {
        if (b.d.b.e.e.d(App.c()) && this.f2294c == null) {
            this.f2294c = this.f2292a.c();
            b.d.b.e.c.a("MessageCenterPushHelper", "### resend start, mResendList:" + this.f2294c);
            this.f2293b.sendEmptyMessage(1);
            return;
        }
        b.d.b.e.c.a("MessageCenterPushHelper", "### resend stop!");
    }
}
