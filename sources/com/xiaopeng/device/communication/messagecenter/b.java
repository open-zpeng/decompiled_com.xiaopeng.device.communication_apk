package com.xiaopeng.device.communication.messagecenter;

import android.text.TextUtils;
import b.d.b.e.i;
import com.google.gson.JsonSyntaxException;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.Callback;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IHttp;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IRequest;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IResponse;
import com.xiaopeng.lib.framework.netchannelmodule.NetworkChannelsEntry;
import com.xiaopeng.lib.framework.netchannelmodule.http.xmart.bizapi.BizConstants;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MessageCenterModel.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static String f2267a = BizConstants.CAR_SECRET;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MessageCenterModel.java */
    /* loaded from: classes.dex */
    public class a implements Callback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f2268a;

        a(boolean z) {
            this.f2268a = z;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.Callback
        public void onFailure(IResponse iResponse) {
            b.d.b.e.c.a("MessageCenterModel", "requestOfflineMessage onError code:" + iResponse.code() + " body:" + iResponse.body());
            b.this.g(this.f2268a);
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.Callback
        public void onSuccess(IResponse iResponse) {
            if (iResponse != null && !TextUtils.isEmpty(iResponse.body())) {
                b.d.b.e.c.l("MessageCenterModel", "requestOfflineMessage onSuccess:" + iResponse.body());
                try {
                    org.greenrobot.eventbus.c.d().n((MessageCenterResponse) com.xiaopeng.device.communication.f.a.a().fromJson(iResponse.body(), (Class<Object>) MessageCenterResponse.class));
                    return;
                } catch (JsonSyntaxException e) {
                    b.d.b.e.c.v("MessageCenterModel", "parse response error:" + iResponse.body(), e.getMessage());
                    b.this.g(this.f2268a);
                    return;
                }
            }
            b.d.b.e.c.t("MessageCenterModel", "TextUtils.isEmpty(response.body()), return!");
            b.this.g(this.f2268a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MessageCenterModel.java */
    /* renamed from: com.xiaopeng.device.communication.messagecenter.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0100b implements Runnable {
        RunnableC0100b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MessageCenterModel.java */
    /* loaded from: classes.dex */
    public class c implements Callback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f2271a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f2272b;

        /* compiled from: MessageCenterModel.java */
        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.d.b.e.c.a("MessageCenterModel", "feedbackMessageArrived onError, retry!");
                c cVar = c.this;
                b.this.d(cVar.f2272b, false);
            }
        }

        c(boolean z, String str) {
            this.f2271a = z;
            this.f2272b = str;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.Callback
        public void onFailure(IResponse iResponse) {
            b.d.b.e.c.m("MessageCenterModel", "feedbackMessageArrived onError code:" + iResponse.code() + " message:" + iResponse.message(), iResponse.getException());
            if (this.f2271a) {
                i.k(2, new a(), 60000L);
            }
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.Callback
        public void onSuccess(IResponse iResponse) {
            b.d.b.e.c.l("MessageCenterModel", "feedbackMessageArrived onSuccess:" + iResponse.body());
        }
    }

    private IRequest b(boolean z, String str, String str2) {
        IHttp iHttp = (IHttp) Module.get(NetworkChannelsEntry.class).get(IHttp.class);
        if (z) {
            return iHttp.bizHelper().get(str).buildWithSecretKey(f2267a);
        }
        return iHttp.bizHelper().post(str, str2).buildWithSecretKey(f2267a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z) {
        if (z) {
            i.k(2, new RunnableC0100b(), 60000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(String str) {
        d(str, true);
    }

    void d(String str, boolean z) {
        b.d.b.e.c.l("MessageCenterModel", "feedbackMessageArrived id:" + str + " retry:" + z);
        StringBuilder sb = new StringBuilder();
        sb.append("{\"messageIds\":\"");
        sb.append(str);
        sb.append("\"}");
        String sb2 = sb.toString();
        b(false, com.xiaopeng.device.communication.d.a.e, sb2).uploadJson(sb2).execute(new c(z, str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        f(true);
    }

    void f(boolean z) {
        b.d.b.e.c.a("MessageCenterModel", "start requestOfflineMessage, retry:" + z);
        b(true, com.xiaopeng.device.communication.d.a.f2258d, null).execute(new a(z));
    }
}
