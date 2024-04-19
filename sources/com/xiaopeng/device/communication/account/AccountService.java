package com.xiaopeng.device.communication.account;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.Log;
import b.d.b.e.c;
import b.d.b.e.g;
import b.d.b.e.i;
import com.xiaopeng.device.communication.account.bean.MqttAccountBean;
import com.xiaopeng.device.communication.account.c.d;
import com.xiaopeng.device.communication.d.a;
import com.xiaopeng.lib.framework.moduleinterface.ipcmodule.IIpcService;
import com.xiaopeng.lib.framework.netchannelmodule.messaging.events.ConnectionEvent;
import com.xiaopeng.lib.framework.netchannelmodule.messaging.profile.AbstractChannelProfile;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.m;
/* loaded from: classes.dex */
public class AccountService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private com.xiaopeng.device.communication.account.d.b f2184a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f2185b = false;

    /* renamed from: c  reason: collision with root package name */
    private long f2186c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Log.i("AccountService", "collectSystemCode");
            d.d().a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Log.i("AccountService", "collectSystemCode");
            d.d().a();
        }
    }

    private void a() {
        if (!TextUtils.isEmpty(g.d())) {
            i.h(0, new a());
        } else {
            i.k(0, new b(), 5000L);
        }
    }

    public static void b() {
        SystemProperties.set(AbstractChannelProfile.SYSTEM_PROPERTY_MQTT_COMM_URL, (String) null);
        SystemProperties.set(AbstractChannelProfile.SYSTEM_PROPERTY_MQTT_COMM_ID, (String) null);
        SystemProperties.set(AbstractChannelProfile.SYSTEM_PROPERTY_MQTT_COMM_USER, (String) null);
        SystemProperties.set(AbstractChannelProfile.SYSTEM_PROPERTY_MQTT_COMM_PASS, (String) null);
        SystemProperties.set(AbstractChannelProfile.SYSTEM_PROPERTY_MQTT_REPORTING_URL, (String) null);
        SystemProperties.set(AbstractChannelProfile.SYSTEM_PROPERTY_MQTT_ID, (String) null);
        SystemProperties.set(AbstractChannelProfile.SYSTEM_PROPERTY_MQTT_USER, (String) null);
        SystemProperties.set(AbstractChannelProfile.SYSTEM_PROPERTY_MQTT_PASS, (String) null);
    }

    private void c(MqttAccountBean mqttAccountBean) {
        SystemProperties.set(AbstractChannelProfile.SYSTEM_PROPERTY_MQTT_COMM_URL, b.d.b.e.l.a.d(mqttAccountBean.getBizAccount().getServer(), "@!chxpzi#0109$+/"));
        SystemProperties.set(AbstractChannelProfile.SYSTEM_PROPERTY_MQTT_COMM_ID, b.d.b.e.l.a.d(mqttAccountBean.getBizAccount().getClientId(), "@!chxpzi#0109$+/"));
        SystemProperties.set(AbstractChannelProfile.SYSTEM_PROPERTY_MQTT_COMM_USER, b.d.b.e.l.a.d(mqttAccountBean.getBizAccount().getUserName(), "@!chxpzi#0109$+/"));
        SystemProperties.set(AbstractChannelProfile.SYSTEM_PROPERTY_MQTT_COMM_PASS, b.d.b.e.l.a.d(mqttAccountBean.getBizAccount().getPassword(), "@!chxpzi#0109$+/"));
        SystemProperties.set(AbstractChannelProfile.SYSTEM_PROPERTY_MQTT_REPORTING_URL, b.d.b.e.l.a.d(mqttAccountBean.getDataAccount().getServer(), "@!chxpzi#0109$+/"));
        SystemProperties.set(AbstractChannelProfile.SYSTEM_PROPERTY_MQTT_ID, b.d.b.e.l.a.d(mqttAccountBean.getDataAccount().getClientId(), "@!chxpzi#0109$+/"));
        SystemProperties.set(AbstractChannelProfile.SYSTEM_PROPERTY_MQTT_USER, b.d.b.e.l.a.d(mqttAccountBean.getDataAccount().getUserName(), "@!chxpzi#0109$+/"));
        com.xiaopeng.device.communication.account.b.a.a(this).c(mqttAccountBean.getBizAccount().getExpireTime());
        String d2 = b.d.b.e.l.a.d(mqttAccountBean.getDataAccount().getPassword(), "@!chxpzi#0109$+/");
        c.a("RoyTest", "dataPass origin:" + mqttAccountBean.getDataAccount().getPassword() + " encode:" + d2);
        SystemProperties.set(AbstractChannelProfile.SYSTEM_PROPERTY_MQTT_PASS, d2);
    }

    @m(threadMode = ThreadMode.ASYNC)
    public void onAccountInitEvent(com.xiaopeng.device.communication.account.a.a aVar) {
        c.a("AccountService", "onAccountInitEvent: account info out of date, init it");
        b();
        com.xiaopeng.device.communication.account.c.b.b().a();
        com.xiaopeng.device.communication.account.d.b bVar = this.f2184a;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    @m(threadMode = ThreadMode.ASYNC)
    public void onAccountInitSuccessEvent(com.xiaopeng.device.communication.account.a.b bVar) {
        MqttAccountBean a2 = bVar.a();
        c.a("RoyTest", "onAccountInitSuccessEvent! account:" + a2.toString());
        try {
            c(a2);
            c.a("AccountService", "sendBroadcast ACTION_BROADCAST_TOKEN_GOTTEN");
            Intent intent = new Intent();
            intent.setAction("com.xiaopeng.broadcast.ACTION_TOKEN_GOTTEN");
            intent.setFlags(16777216);
            sendBroadcast(intent);
            if (!this.f2185b) {
                a();
            }
            this.f2185b = true;
        } catch (Exception e) {
            c.u("AccountService", "save MqttAccount Error, reset and return!", e);
            b();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        c.a("AccountService", "onBind");
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        c.a("AccountService", "onCreate");
        this.f2184a = new com.xiaopeng.device.communication.account.d.a();
        org.greenrobot.eventbus.c.d().s(this);
        d.d().e();
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        c.a("AccountService", "onDestroy");
        org.greenrobot.eventbus.c.d().u(this);
        d.d().b();
        super.onDestroy();
    }

    @m(threadMode = ThreadMode.ASYNC)
    public void onEvent(IIpcService.IpcMessageEvent ipcMessageEvent) {
        if (ipcMessageEvent.getMsgID() != 130008) {
            return;
        }
        a();
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        c.a("AccountService", "onRebind");
        super.onRebind(intent);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        c.a("AccountService", "onStartCommand");
        this.f2184a.a(this);
        return 1;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        c.a("AccountService", "onUnbind");
        return super.onUnbind(intent);
    }

    @m(threadMode = ThreadMode.ASYNC)
    public void onEvent(a.C0097a c0097a) {
        g.i(-1);
        this.f2184a.a(this);
    }

    @m(threadMode = ThreadMode.ASYNC)
    public void onEvent(ConnectionEvent connectionEvent) {
        if (connectionEvent != null) {
            String str = new String(connectionEvent.messageContent());
            int reasonCode = connectionEvent.reasonCode();
            Log.d("AccountService", "onEvent ConnectionEvent eventUri:" + str + "; reasonCode=" + reasonCode);
            if (1 == reasonCode && "错误的用户名或密码".equals(str)) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f2186c >= 120000) {
                    Log.i("AccountService", "onEvent ConnectionEvent Mqtt 用户名或密码错误，重新获取Mqtt账号信息");
                    this.f2186c = currentTimeMillis;
                    b();
                    com.xiaopeng.device.communication.account.c.b.b().a();
                    this.f2184a.a(this);
                }
            }
        }
    }
}
