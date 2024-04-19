package com.xiaopeng.device.communication.account.c;

import android.telephony.TelephonyManager;
import android.text.TextUtils;
import b.d.b.e.g;
import com.xiaopeng.device.communication.App;
import com.xiaopeng.device.communication.account.bean.SystemCodeBean;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.messaging.IEvent;
import com.xiaopeng.libconfig.ipc.bean.MqttMsgBase;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.m;
/* compiled from: SystemCodeModel.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private String f2199a;

    /* renamed from: b  reason: collision with root package name */
    private TelephonyManager f2200b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2201c;

    /* compiled from: SystemCodeModel.java */
    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2202a;

        static {
            int[] iArr = new int[IEvent.TYPE.values().length];
            f2202a = iArr;
            try {
                iArr[IEvent.TYPE.CONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* compiled from: SystemCodeModel.java */
    /* loaded from: classes.dex */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        private static final d f2203a = new d(null);
    }

    /* synthetic */ d(a aVar) {
        this();
    }

    private String c() {
        String deviceId = this.f2200b.getDeviceId();
        if (TextUtils.isEmpty(deviceId)) {
            return "Unknown";
        }
        if (deviceId.contains(":")) {
            String[] split = deviceId.split(":");
            if (split.length > 1) {
                return split[1].trim();
            }
            return split[0].trim();
        }
        return deviceId.trim();
    }

    public static d d() {
        return b.f2203a;
    }

    public synchronized void a() {
        MqttMsgBase mqttMsgBase = new MqttMsgBase(g.g());
        SystemCodeBean systemCodeBean = new SystemCodeBean();
        systemCodeBean.setHardwareId(g.c());
        systemCodeBean.setVid(g.g());
        systemCodeBean.setVinCode(g.f());
        systemCodeBean.setIccid(g.d());
        systemCodeBean.setImei(c());
        systemCodeBean.setModuleVersion(c.a().b());
        mqttMsgBase.setMsgContent(systemCodeBean);
        mqttMsgBase.setServiceType(25);
        mqttMsgBase.setMsgType(1);
        this.f2199a = com.xiaopeng.device.communication.f.a.a().toJson(mqttMsgBase);
        synchronized (this) {
            if (com.xiaopeng.device.communication.e.a.a().d()) {
                f();
                this.f2201c = false;
            } else {
                this.f2201c = true;
            }
        }
    }

    public void b() {
        org.greenrobot.eventbus.c.d().u(this);
    }

    public void e() {
        org.greenrobot.eventbus.c.d().s(this);
    }

    public synchronized void f() {
        if (!TextUtils.isEmpty(this.f2199a)) {
            com.xiaopeng.device.communication.account.b.b.a().b(this.f2199a);
            b.d.b.e.c.a("SystemCodeModel", "mJsonCode = " + this.f2199a);
            this.f2199a = null;
        }
    }

    @m(threadMode = ThreadMode.POSTING)
    public void onMessageEventPosting(IEvent iEvent) {
        if (a.f2202a[iEvent.type().ordinal()] != 1) {
            return;
        }
        synchronized (this) {
            if (this.f2201c) {
                f();
                this.f2201c = false;
            }
        }
    }

    private d() {
        this.f2200b = (TelephonyManager) App.c().getSystemService("phone");
        this.f2201c = false;
    }
}
