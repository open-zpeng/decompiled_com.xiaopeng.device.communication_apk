package com.xiaopeng.device.communication.trafficstatus;

import android.car.Car;
import android.car.CarNotConnectedException;
import android.car.hardware.tbox.CarTboxManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemProperties;
import android.util.Log;
import b.d.b.e.e;
import com.google.gson.JsonObject;
import com.xiaopeng.device.communication.App;
import com.xiaopeng.device.communication.a;
import com.xiaopeng.device.communication.trafficstatus.b;
import com.xiaopeng.lib.framework.ipcmodule.IpcModuleEntry;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.ipcmodule.IIpcService;
import com.xiaopeng.libconfig.ipc.IpcConfig;
import com.xiaopeng.libconfig.ipc.bean.MessageCenterBean;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.m;
/* compiled from: TrafficStatusPresenter.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private com.xiaopeng.device.communication.trafficstatus.b f2303a;

    /* renamed from: b  reason: collision with root package name */
    private CarTboxManager f2304b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TrafficStatusPresenter.java */
    /* renamed from: com.xiaopeng.device.communication.trafficstatus.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0102a implements b.InterfaceC0103b {
        C0102a() {
        }

        @Override // com.xiaopeng.device.communication.trafficstatus.b.InterfaceC0103b
        public void a() {
            b.d.b.e.c.a("TrafficStatusPresenter", "sync TrafficStatus fail");
        }

        @Override // com.xiaopeng.device.communication.trafficstatus.b.InterfaceC0103b
        public void b(TrafficStatusBean trafficStatusBean) {
            b.d.b.e.c.l("TrafficStatusPresenter", "sync TrafficStatus success, result:" + trafficStatusBean);
            a.this.f(trafficStatusBean);
            a.this.g(trafficStatusBean);
        }
    }

    /* compiled from: TrafficStatusPresenter.java */
    /* loaded from: classes.dex */
    class b implements b.InterfaceC0103b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f2306a;

        b(String str) {
            this.f2306a = str;
        }

        @Override // com.xiaopeng.device.communication.trafficstatus.b.InterfaceC0103b
        public void a() {
            b.d.b.e.c.l("TrafficStatusPresenter", "request TrafficStatus fail");
            a.this.e(null, this.f2306a);
        }

        @Override // com.xiaopeng.device.communication.trafficstatus.b.InterfaceC0103b
        public void b(TrafficStatusBean trafficStatusBean) {
            b.d.b.e.c.l("TrafficStatusPresenter", "request TrafficStatus success, result:" + trafficStatusBean);
            a.this.f(trafficStatusBean);
            a.this.e(trafficStatusBean, this.f2306a);
        }
    }

    /* compiled from: TrafficStatusPresenter.java */
    /* loaded from: classes.dex */
    class c implements b.InterfaceC0103b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f2308a;

        c(String str) {
            this.f2308a = str;
        }

        @Override // com.xiaopeng.device.communication.trafficstatus.b.InterfaceC0103b
        public void a() {
            b.d.b.e.c.l("TrafficStatusPresenter", "request TrafficStatus fail");
            a.this.e(null, this.f2308a);
        }

        @Override // com.xiaopeng.device.communication.trafficstatus.b.InterfaceC0103b
        public void b(TrafficStatusBean trafficStatusBean) {
            b.d.b.e.c.l("TrafficStatusPresenter", "request TrafficStatus success, result:" + trafficStatusBean);
            a.this.f(trafficStatusBean);
            a.this.e(trafficStatusBean, this.f2308a);
        }
    }

    public a(boolean z) {
        this.f2303a = new com.xiaopeng.device.communication.trafficstatus.b();
        if (z) {
            org.greenrobot.eventbus.c.d().s(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(TrafficStatusBean trafficStatusBean, String str) {
        b.d.b.e.c.l("TrafficStatusPresenter", "responseIpc result:" + trafficStatusBean + " to:" + str);
        IIpcService iIpcService = (IIpcService) Module.get(IpcModuleEntry.class).get(IIpcService.class);
        Bundle bundle = new Bundle();
        if (trafficStatusBean != null) {
            bundle.putInt(IpcConfig.IPCKey.INT_VALUE, trafficStatusBean.getType());
        }
        if (com.xiaopeng.device.communication.a.a(IpcConfig.DeviceCommunicationConfig.TRAFFIC_STATUS_RESPONSE, null)) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("senderPackageName", App.c().getPackageName());
            jsonObject.addProperty(IpcConfig.IPCKey.INT_VALUE, Integer.valueOf(trafficStatusBean.getType()));
            com.xiaopeng.device.communication.a.e(IpcConfig.DeviceCommunicationConfig.TRAFFIC_STATUS_RESPONSE, jsonObject.toString(), str);
            return;
        }
        iIpcService.sendData(IpcConfig.DeviceCommunicationConfig.TRAFFIC_STATUS_RESPONSE, bundle, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void f(TrafficStatusBean trafficStatusBean) {
        int i = SystemProperties.getInt("persist.sys.xp.4g.st", 0);
        int type = trafficStatusBean.getType();
        Log.i("TrafficStatusPresenter", "save ..properties\tbean type: " + type + "\tbean time:" + trafficStatusBean.getTime() + "\tlastStatus :" + i);
        if (type != i) {
            SystemProperties.set("persist.sys.xp.4g.st", String.valueOf(type));
            Intent intent = new Intent("com.xiaopeng.action.TRAFFIC_STATUS_CHANGE");
            intent.putExtra("persist.sys.xp.4g.st", String.valueOf(type));
            App.c().sendBroadcast(intent);
            b.d.b.e.c.l("TrafficStatusPresenter", "sendBroadcast value:\t " + type);
        }
    }

    public void c() {
        org.greenrobot.eventbus.c.d().u(this);
    }

    public boolean d() {
        boolean c2 = b.d.b.e.m.c.c();
        String xpCduType = Car.getXpCduType();
        xpCduType.hashCode();
        char c3 = 65535;
        switch (xpCduType.hashCode()) {
            case 2560:
                if (xpCduType.equals("Q1")) {
                    c3 = 0;
                    break;
                }
                break;
            case 2561:
                if (xpCduType.equals("Q2")) {
                    c3 = 1;
                    break;
                }
                break;
            case 2562:
                if (xpCduType.equals("Q3")) {
                    c3 = 2;
                    break;
                }
                break;
            case 2565:
                if (xpCduType.equals("Q6")) {
                    c3 = 3;
                    break;
                }
                break;
            case 2566:
                if (xpCduType.equals("Q7")) {
                    c3 = 4;
                    break;
                }
                break;
            case 2567:
                if (xpCduType.equals("Q8")) {
                    c3 = 5;
                    break;
                }
                break;
            case 2568:
                if (xpCduType.equals("Q9")) {
                    c3 = 6;
                    break;
                }
                break;
        }
        switch (c3) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return c2;
            default:
                return false;
        }
    }

    public void g(TrafficStatusBean trafficStatusBean) {
        if (!d()) {
            b.d.b.e.c.a("TrafficStatusPresenter", "sendApnTrafficInfo2TBox: traffic block is not supported!");
        } else if (trafficStatusBean != null) {
            long j = 1 != trafficStatusBean.getType() ? 0 : 1;
            try {
                if (com.xiaopeng.device.communication.b.a.c.j()) {
                    if (this.f2304b == null) {
                        this.f2304b = (CarTboxManager) com.xiaopeng.device.communication.b.a.c.f().getCarManager("xp_tbox");
                    }
                    try {
                        b.d.b.e.c.a("TrafficStatusPresenter", "sendApnTrafficInfo2TBox: traffic block state = " + j);
                        this.f2304b.sendTboxApnTrafficInfo(-1L, -1L, -1L, j);
                        return;
                    } catch (Exception unused) {
                        b.d.b.e.c.f("TrafficStatusPresenter", "sendApnTrafficInfo2TBox: mCarTboxManager sendTboxApnTrafficInfo failed!");
                        return;
                    }
                }
                b.d.b.e.c.a("TrafficStatusPresenter", "sendApnTrafficInfo2TBox: CarService is not connected!");
            } catch (CarNotConnectedException | ClassCastException e) {
                b.d.b.e.c.f("TrafficStatusPresenter", "sendApnTrafficInfo2TBox: " + e.getMessage());
            }
        }
    }

    public void h() {
        b.d.b.e.c.a("TrafficStatusPresenter", "#### sync status:\t" + e.d(App.c()));
        if (!e.d(App.c())) {
            b.d.b.e.c.l("TrafficStatusPresenter", "Network not available, sync return");
        } else {
            this.f2303a.a(new C0102a());
        }
    }

    @m(threadMode = ThreadMode.ASYNC)
    public void onIpcMessageEvent(IIpcService.IpcMessageEvent ipcMessageEvent) {
        if (ipcMessageEvent.getMsgID() == 1401) {
            String senderPackageName = ipcMessageEvent.getSenderPackageName();
            b.d.b.e.c.l("TrafficStatusPresenter", "onIpcMessageEvent from:" + senderPackageName);
            this.f2303a.a(new b(senderPackageName));
        }
    }

    @m(sticky = MqttConnectOptions.CLEAN_SESSION_DEFAULT, threadMode = ThreadMode.ASYNC)
    public void onMessageCenterEvent(com.xiaopeng.device.communication.messagecenter.a aVar) {
        MessageCenterBean a2 = aVar.a();
        if (a2.getScene() == 10003) {
            TrafficStatusBean trafficStatusBean = (TrafficStatusBean) com.xiaopeng.device.communication.f.a.a().fromJson(a2.getContent(), (Class<Object>) TrafficStatusBean.class);
            b.d.b.e.c.l("TrafficStatusPresenter", "onMessageCenterEvent status:" + trafficStatusBean);
            f(trafficStatusBean);
            g(trafficStatusBean);
        }
    }

    public a() {
        this(true);
    }

    @m(threadMode = ThreadMode.ASYNC)
    public void onIpcMessageEvent(a.C0090a c0090a) {
        if (c0090a.a() == 1401) {
            String c2 = c0090a.c();
            b.d.b.e.c.l("TrafficStatusPresenter", "onIpcMessageEvent from:" + c2);
            this.f2303a.a(new c(c2));
        }
    }
}
