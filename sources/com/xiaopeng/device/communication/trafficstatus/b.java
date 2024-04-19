package com.xiaopeng.device.communication.trafficstatus;

import android.util.Log;
import b.d.b.e.c;
import b.d.b.e.g;
import com.irdeto.securesdk.core.SSUtils;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.Callback;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IHttp;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IResponse;
import com.xiaopeng.lib.framework.netchannelmodule.NetworkChannelsEntry;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: TrafficStatusSender.java */
/* loaded from: classes.dex */
public class b {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TrafficStatusSender.java */
    /* loaded from: classes.dex */
    public class a implements Callback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ InterfaceC0103b f2310a;

        a(InterfaceC0103b interfaceC0103b) {
            this.f2310a = interfaceC0103b;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.Callback
        public void onFailure(IResponse iResponse) {
            c.u("TrafficStatusSender", "request fail, code:" + iResponse.code() + " body:" + iResponse.body(), iResponse.getException());
            this.f2310a.a();
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.Callback
        public void onSuccess(IResponse iResponse) {
            String body = iResponse.body();
            c.a("TrafficStatusSender", "onSuccess body:" + body);
            try {
                JSONObject jSONObject = new JSONObject(body);
                if (jSONObject.getInt("code") != 200) {
                    this.f2310a.a();
                    return;
                }
                TrafficStatusBean trafficStatusBean = new TrafficStatusBean();
                trafficStatusBean.setTime(jSONObject.getJSONObject("data").getLong("time"));
                trafficStatusBean.setType(jSONObject.getJSONObject("data").getInt("type"));
                this.f2310a.b(trafficStatusBean);
            } catch (JSONException e) {
                c.u("TrafficStatusSender", "parse json error!", e);
                this.f2310a.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TrafficStatusSender.java */
    /* renamed from: com.xiaopeng.device.communication.trafficstatus.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0103b {
        void a();

        void b(TrafficStatusBean trafficStatusBean);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(InterfaceC0103b interfaceC0103b) {
        StringBuilder sb = new StringBuilder();
        sb.append("traffic status sender request:\t");
        String str = com.xiaopeng.device.communication.d.a.f2256b;
        sb.append(str);
        Log.i("TrafficStatusSender", sb.toString());
        if (interfaceC0103b == null) {
            c.t("TrafficStatusSender", "callback can't be null!");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(SSUtils.O0000Ooo, g.f());
        hashMap.put("iccid", g.d());
        ((IHttp) Module.get(NetworkChannelsEntry.class).get(IHttp.class)).bizHelper().post(str, com.xiaopeng.device.communication.f.a.a().toJson(hashMap)).enableSecurityEncoding().needAuthorizationInfo().build().execute(new a(interfaceC0103b));
    }
}
