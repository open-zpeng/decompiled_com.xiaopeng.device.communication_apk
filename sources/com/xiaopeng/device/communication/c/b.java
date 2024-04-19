package com.xiaopeng.device.communication.c;

import android.text.TextUtils;
import android.util.Log;
import b.d.b.e.g;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.xiaopeng.device.communication.a;
import com.xiaopeng.device.communication.d.a;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog;
import com.xiaopeng.lib.framework.moduleinterface.ipcmodule.IIpcService;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.Callback;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IHttp;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IResponse;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.messaging.IEvent;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.messaging.IMessaging;
import com.xiaopeng.lib.framework.netchannelmodule.NetworkChannelsEntry;
import com.xiaopeng.libconfig.ipc.IpcConfig;
import com.xiaopeng.libconfig.ipc.bean.MqttMsgBase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.m;
import org.json.JSONException;
/* compiled from: CarControlPresenter.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private String f2248a;

    /* renamed from: b  reason: collision with root package name */
    private String f2249b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<IIpcService.IpcMessageEvent> f2250c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<a.C0090a> f2251d;
    private IEvent e = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CarControlPresenter.java */
    /* loaded from: classes.dex */
    public class a implements Callback {
        a() {
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.Callback
        public void onFailure(IResponse iResponse) {
            if (iResponse.getException() != null) {
                b.d.b.e.c.l("CarControlPresenter", "执行失败--->" + iResponse.getException().getMessage());
                return;
            }
            b.d.b.e.c.l("CarControlPresenter", "执行失败! onFailure");
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.Callback
        public void onSuccess(IResponse iResponse) {
            try {
                if (new JsonParser().parse(iResponse.body()).getAsJsonObject().get("code").getAsInt() == 200) {
                    b.d.b.e.c.l("CarControlPresenter", "执行成功--->" + iResponse.body());
                } else {
                    b.d.b.e.c.l("CarControlPresenter", "执行失败--->" + iResponse.body());
                }
            } catch (Exception e) {
                b.d.b.e.c.f("CarControlPresenter", "error: " + e.getStackTrace());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CarControlPresenter.java */
    /* renamed from: com.xiaopeng.device.communication.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0096b extends TypeToken<MqttMsgBase> {
        C0096b() {
        }
    }

    /* compiled from: CarControlPresenter.java */
    /* loaded from: classes.dex */
    static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2254a;

        static {
            int[] iArr = new int[IEvent.TYPE.values().length];
            f2254a = iArr;
            try {
                iArr[IEvent.TYPE.RECEIVED_MESSAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2254a[IEvent.TYPE.CONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2254a[IEvent.TYPE.DISCONNECTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public b() {
        b.d.b.e.c.l("CarControlPresenter", "CarControlPresenter construct : " + this);
        if (org.greenrobot.eventbus.c.d().l(this)) {
            return;
        }
        org.greenrobot.eventbus.c.d().s(this);
    }

    private byte[] b(byte[] bArr) {
        if (bArr[bArr.length - 1] == 0) {
            byte[] bArr2 = new byte[bArr.length - 1];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length - 1);
            return bArr2;
        }
        return bArr;
    }

    private void c(String str, byte[] bArr) {
        b.d.b.e.c.a("CarControlPresenter", "messageArrived topic=" + str + " message=" + bArr);
        if (str == null || !str.equals(this.f2248a)) {
            return;
        }
        g(bArr);
    }

    private void d() {
        b.d.b.e.c.l("CarControlPresenter", "notifyCacheOtherClinet");
        if (com.xiaopeng.device.communication.a.a(0, null)) {
            if (this.f2251d != null) {
                b.d.b.e.c.l("CarControlPresenter", "notifyCacheOtherClinet mIpcApiRounterEventCache.size() =" + this.f2251d.size());
                Iterator<a.C0090a> it = this.f2251d.iterator();
                while (it.hasNext()) {
                    e(it.next());
                }
                this.f2251d = null;
            }
        } else if (this.f2250c != null) {
            b.d.b.e.c.l("CarControlPresenter", "notifyCacheOtherClinet mIpcEventCache.size() =" + this.f2251d.size());
            Iterator<IIpcService.IpcMessageEvent> it2 = this.f2250c.iterator();
            while (it2.hasNext()) {
                f(it2.next());
            }
            this.f2250c = null;
        }
    }

    private void e(a.C0090a c0090a) {
        String str;
        String c2 = c0090a.c();
        try {
            str = c0090a.b().getString(IpcConfig.IPCKey.STRING_MSG);
        } catch (JSONException e) {
            e.printStackTrace();
            str = null;
        }
        b.d.b.e.c.a("CarControlPresenter", "notifyOtherClient json:" + str);
        if (!((IMessaging) Module.get(NetworkChannelsEntry.class).get(IMessaging.class)).available()) {
            if (this.f2251d == null) {
                this.f2251d = new ArrayList<>();
            }
            this.f2251d.add(c0090a);
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            com.xiaopeng.device.communication.e.a.a().e(this.f2249b, str);
        }
        if (IpcConfig.App.UPLOAD_CAR_INFO.equals(c2) || IpcConfig.App.CAR_REMOTE_CONTROL.equals(c2)) {
            if (b.d.b.e.m.c.c()) {
                b.d.b.e.c.l("CarControlPresenter", "INTERNATION will not upload carInfo !");
                return;
            }
            IDataLog iDataLog = (IDataLog) Module.get(b.d.a.a.class).get(IDataLog.class);
            iDataLog.sendStatData(iDataLog.buildStat().setEventName("mqtt_cdu_feedback").setProperty("data", str).build());
        }
    }

    private void f(IIpcService.IpcMessageEvent ipcMessageEvent) {
        String senderPackageName = ipcMessageEvent.getSenderPackageName();
        String string = ipcMessageEvent.getPayloadData().getString(IpcConfig.IPCKey.STRING_MSG);
        b.d.b.e.c.a("CarControlPresenter", "notifyOtherClient json:" + string);
        if (!((IMessaging) Module.get(NetworkChannelsEntry.class).get(IMessaging.class)).available()) {
            if (this.f2250c == null) {
                this.f2250c = new ArrayList<>();
            }
            this.f2250c.add(ipcMessageEvent);
            return;
        }
        if (!TextUtils.isEmpty(string)) {
            com.xiaopeng.device.communication.e.a.a().e(this.f2249b, string);
        }
        if (IpcConfig.App.UPLOAD_CAR_INFO.equals(senderPackageName) || IpcConfig.App.CAR_REMOTE_CONTROL.equals(senderPackageName)) {
            if (b.d.b.e.m.c.c()) {
                b.d.b.e.c.l("CarControlPresenter", "INTERNATION will not upload carInfo !");
                return;
            }
            IDataLog iDataLog = (IDataLog) Module.get(b.d.a.a.class).get(IDataLog.class);
            iDataLog.sendStatData(iDataLog.buildStat().setEventName("mqtt_cdu_feedback").setProperty("data", string).build());
        }
    }

    private void g(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return;
        }
        b.d.b.e.c.a("CarControlPresenter", Arrays.toString(bArr));
        String str = new String(b(bArr));
        b.d.b.e.c.a("CarControlPresenter", "sendActionCommand msgStr=" + str);
        try {
            MqttMsgBase mqttMsgBase = (MqttMsgBase) com.xiaopeng.device.communication.f.a.a().fromJson(str, new C0096b().getType());
            b.d.b.e.c.a("CarControlPresenter", "sendActionCommand msgStr=" + str);
            int msgType = mqttMsgBase.getMsgType();
            if (msgType == 1) {
                com.xiaopeng.device.communication.c.a.a().f(str);
            } else if (msgType == 2) {
                if (!b.d.b.e.m.c.c()) {
                    IDataLog iDataLog = (IDataLog) Module.get(b.d.a.a.class).get(IDataLog.class);
                    iDataLog.sendStatData(iDataLog.buildStat().setEventName("mqtt_cdu_control").setProperty("data", str).build());
                } else {
                    Log.i("CarControlPresenter", "internaltionnal version do not upload data");
                }
                com.xiaopeng.device.communication.c.a.a().c(mqttMsgBase.getServiceType(), str);
            } else if (msgType == 3) {
                com.xiaopeng.device.communication.c.a.a().g(mqttMsgBase.getServiceType(), str);
            } else if (msgType != 4) {
            } else {
                if (!b.d.b.e.m.c.c()) {
                    IDataLog iDataLog2 = (IDataLog) Module.get(b.d.a.a.class).get(IDataLog.class);
                    iDataLog2.sendStatData(iDataLog2.buildStat().setEventName("mqtt_cdu_control").setProperty("data", str).build());
                    com.xiaopeng.device.communication.c.a.a().d(mqttMsgBase);
                    return;
                }
                Log.i("CarControlPresenter", "InternationalVer ver do dot upload data!");
            }
        } catch (JsonParseException e) {
            b.d.b.e.c.u("CarControlPresenter", "parse action command fail! msgStr:" + str, e);
        }
    }

    private void h() {
        String c2 = g.c();
        b.d.b.e.c.a("CarControlPresenter", "subscribeToTopic hardwareId:" + c2);
        if (!TextUtils.isEmpty(c2)) {
            b.d.b.e.c.l("CarControlPresenter", "checkVid available, init topic and hardwareId:" + c2);
            this.f2248a = String.format("Xmart/Msg/Cdu/%s", c2);
            this.f2249b = String.format("Xmart/Send/Cdu/%s", c2);
            b.d.b.e.c.a("CarControlPresenter", "订阅主题 msgTopic=" + this.f2248a);
            com.xiaopeng.device.communication.e.a.a().g(this.f2248a);
            return;
        }
        b.d.b.e.c.s("CarControlPresenter", "checkHardwareId not available!");
    }

    public void a() {
        org.greenrobot.eventbus.c.d().u(this);
    }

    protected synchronized void i(String str) {
        String str2 = b.d.b.e.k.a.f1426d + "/v5/cdu/callback";
        b.d.b.e.c.l("CarControlPresenter", "回调地址callbackUrl-->" + str2);
        try {
            ((IHttp) Module.get(NetworkChannelsEntry.class).get(IHttp.class)).bizHelper().post(str2, str).build().execute(new a());
        } catch (Exception e) {
            b.d.b.e.c.t("CarControlPresenter", "exception occurred and details: " + e.getMessage());
        }
    }

    @m(threadMode = ThreadMode.ASYNC)
    public void onEvent(IIpcService.IpcMessageEvent ipcMessageEvent) {
        b.d.b.e.c.a("CarControlPresenter", "IpcMessageEvent MsgID" + ipcMessageEvent.getMsgID());
        int msgID = ipcMessageEvent.getMsgID();
        if (msgID != 1400 && msgID != 6005) {
            if (msgID == 6006) {
                try {
                    i(ipcMessageEvent.getPayloadData().getString(IpcConfig.IPCKey.STRING_MSG));
                    return;
                } catch (Exception e) {
                    b.d.b.e.c.f("CarControlPresenter", "IpcMessageEvent MsgID: " + ipcMessageEvent.getMsgID() + " error: " + e.getStackTrace());
                    return;
                }
            }
            switch (msgID) {
                case 500001:
                case 500002:
                    break;
                default:
                    return;
            }
        }
        f(ipcMessageEvent);
    }

    @m(threadMode = ThreadMode.POSTING)
    public void onMessageEventPosting(IEvent iEvent) {
        int i = c.f2254a[iEvent.type().ordinal()];
        if (i == 1) {
            if (this.e != iEvent) {
                c(iEvent.messageTopic(), iEvent.messageContent());
            } else {
                b.d.b.e.c.a("CarControlPresenter", "same event object, will not handle event = " + iEvent);
            }
            this.e = iEvent;
        } else if (i != 2) {
            if (i == 3 && iEvent.reasonCode() == 1 && iEvent.protocolReasonCode() == 4) {
                b.d.b.e.c.a("CarControlPresenter", "Login failed and reInit mqtt account!");
                org.greenrobot.eventbus.c.d().n(new a.C0097a());
            }
        } else {
            h();
            d();
        }
    }

    @m(threadMode = ThreadMode.ASYNC)
    public void onEvent(a.C0090a c0090a) {
        b.d.b.e.c.a("CarControlPresenter", "IpcMessageEvent MsgID" + c0090a.a());
        int a2 = c0090a.a();
        if (a2 != 1004 && a2 != 1400 && a2 != 6005) {
            if (a2 == 6006) {
                try {
                    i(c0090a.b().getString(IpcConfig.IPCKey.STRING_MSG));
                    return;
                } catch (Exception e) {
                    b.d.b.e.c.f("CarControlPresenter", "IpcMessageEvent MsgID: " + c0090a.a() + " error: " + e.getStackTrace());
                    return;
                }
            }
            switch (a2) {
                case 500001:
                case 500002:
                    break;
                default:
                    return;
            }
        }
        e(c0090a);
    }
}
