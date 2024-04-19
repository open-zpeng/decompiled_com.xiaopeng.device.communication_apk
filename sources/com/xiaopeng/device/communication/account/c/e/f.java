package com.xiaopeng.device.communication.account.c.e;

import android.os.SystemProperties;
import android.widget.Toast;
import b.d.b.e.g;
import com.google.gson.reflect.TypeToken;
import com.xiaopeng.device.communication.App;
import com.xiaopeng.device.communication.account.bean.MqttAccountBean;
import com.xiaopeng.device.communication.account.bean.ServerE28Bean;
import com.xiaopeng.device.communication.account.c.e.a;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IHttp;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IResponse;
import com.xiaopeng.lib.framework.netchannelmodule.NetworkChannelsEntry;
import com.xiaopeng.lib.framework.netchannelmodule.messaging.profile.AbstractChannelProfile;
import java.io.IOException;
import java.util.HashMap;
/* compiled from: StepRequestMqtt.java */
/* loaded from: classes.dex */
public class f implements com.xiaopeng.device.communication.account.c.e.a {

    /* renamed from: a  reason: collision with root package name */
    private static String f2206a;

    /* renamed from: b  reason: collision with root package name */
    private int f2207b = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StepRequestMqtt.java */
    /* loaded from: classes.dex */
    public class a extends TypeToken<ServerE28Bean<MqttAccountBean>> {
        a() {
        }
    }

    static {
        f2206a = b.d.b.e.m.b.h() ? "ghepbrwmgcispjja" : "dj5pyz4qpamfg9c1";
    }

    private ServerE28Bean<MqttAccountBean> a(String str) {
        try {
            return (ServerE28Bean) com.xiaopeng.device.communication.f.a.a().fromJson(str, new a().getType());
        } catch (Exception e) {
            b.d.b.e.c.b("AccountModel", "Failed to parser the response data. response:" + str, e);
            return null;
        }
    }

    private a.EnumC0093a b(IResponse iResponse) {
        if (iResponse.code() != 200) {
            if (b.d.b.e.m.b.g()) {
                Toast.makeText(App.c(), "【初始化VID】返回码不是200，重试！", 1).show();
            }
            b.d.b.e.c.t("AccountModel", "Response code is not 200!");
            return c();
        }
        String body = iResponse.body();
        b.d.b.e.c.a("AccountModel", "response:" + body);
        ServerE28Bean<MqttAccountBean> a2 = a(body);
        if (a2 == null) {
            b.d.b.e.c.a("AccountModel", "getServerBean return null!");
            return c();
        }
        int code = a2.getCode();
        if (code == 200) {
            b.d.b.e.c.a("AccountModel", "######## Init mqtt account success!");
            org.greenrobot.eventbus.c.d().n(new com.xiaopeng.device.communication.account.a.b(a2.getData()));
            return a.EnumC0093a.EXECUTE_RESULT_SUCCESS;
        } else if (4005002 == code) {
            if (b.d.b.e.m.b.g()) {
                Toast.makeText(App.c(), "【初始化VID】服务器返回证书错误，请检查证书状态！", 1).show();
            }
            b.d.b.e.c.a("AccountModel", "No certificate and no need to retry, return fail!");
            this.f2207b = 0;
            return a.EnumC0093a.EXECUTE_RESULT_FAIL;
        } else {
            b.d.b.e.c.a("AccountModel", "Server bean code not 200!");
            return c();
        }
    }

    private a.EnumC0093a c() {
        int i = this.f2207b + 1;
        this.f2207b = i;
        if (i < 5) {
            b.d.b.e.c.a("AccountModel", "request vid fail, retry=" + this.f2207b + ", return retry!");
            return a.EnumC0093a.EXECUTE_RESULT_RETRY;
        }
        b.d.b.e.c.a("AccountModel", "request vid fail and retry>=5, return fail!");
        this.f2207b = 0;
        return a.EnumC0093a.EXECUTE_RESULT_FAIL;
    }

    @Override // com.xiaopeng.device.communication.account.c.e.a
    public a.EnumC0093a execute() {
        if (!b.d.b.e.e.d(App.c())) {
            b.d.b.e.c.t("AccountModel", "Network not available, return fail!");
            return a.EnumC0093a.EXECUTE_RESULT_FAIL;
        }
        String str = App.c().b().f2259a;
        if (!str.contains("https://xmart.xiaopeng.com") && !str.contains("https://xmart-eu.xiaopeng.com")) {
            f2206a = "ghepbrwmgcispjja";
        } else {
            f2206a = "dj5pyz4qpamfg9c1";
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("cduId", g.c());
            String json = com.xiaopeng.device.communication.f.a.a().toJson(hashMap);
            b.d.b.e.c.a("AccountModel", "mqtturl = " + str + ", secretKey = " + f2206a);
            SystemProperties.set(AbstractChannelProfile.SYSTEM_PROPERTY_MQTT_PASS, "");
            return b(((IHttp) Module.get(NetworkChannelsEntry.class).get(IHttp.class)).bizHelper().post(str, json).buildWithSecretKey(f2206a).execute());
        } catch (IOException e) {
            b.d.b.e.c.u("AccountModel", "request mqtt account fail!", e);
            return a.EnumC0093a.EXECUTE_RESULT_RETRY;
        }
    }
}
