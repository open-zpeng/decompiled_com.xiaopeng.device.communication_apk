package com.xiaopeng.device.communication.messagecenter;

import android.arch.persistence.room.RoomDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import b.d.b.e.e;
import b.d.b.e.g;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.xiaopeng.device.communication.App;
import com.xiaopeng.device.communication.a;
import com.xiaopeng.device.communication.messagecenter.push.d;
import com.xiaopeng.lib.framework.ipcmodule.IpcModuleEntry;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.ipcmodule.IIpcService;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.messaging.IEvent;
import com.xiaopeng.libconfig.ipc.IpcConfig;
import com.xiaopeng.libconfig.ipc.bean.MessageCenterBean;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.m;
/* compiled from: MessageCenterPresenter.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private String f2275a;

    /* renamed from: b  reason: collision with root package name */
    private b f2276b;

    /* renamed from: c  reason: collision with root package name */
    private d f2277c;

    /* renamed from: d  reason: collision with root package name */
    private long f2278d;

    /* compiled from: MessageCenterPresenter.java */
    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2279a;

        static {
            int[] iArr = new int[IEvent.TYPE.values().length];
            f2279a = iArr;
            try {
                iArr[IEvent.TYPE.RECEIVED_MESSAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2279a[IEvent.TYPE.CONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public c() {
        b bVar = new b();
        this.f2276b = bVar;
        bVar.e();
        this.f2277c = new d();
        org.greenrobot.eventbus.c.d().s(this);
    }

    private String b(MessageCenterBean messageCenterBean) {
        int messageType = messageCenterBean.getMessageType();
        if (messageType == 1) {
            return com.xiaopeng.device.communication.a.a(RoomDatabase.MAX_BIND_PARAMETER_CNT, null) ? IpcConfig.App.AI : IpcConfig.App.MESSAGE_CENTER;
        } else if (messageType != 2) {
            if (messageType != 3) {
                if (messageType != 5) {
                    if (messageType != 9) {
                        if (messageType != 49) {
                            if (messageType != 51) {
                                if (messageType != 54) {
                                    if (messageType != 56) {
                                        if (messageType != 11) {
                                            if (messageType != 12) {
                                                switch (messageType) {
                                                    case 14:
                                                        return IpcConfig.App.DEVICE_COMMUNICATION;
                                                    case 15:
                                                        return IpcConfig.App.APP_ENGINE;
                                                    case 16:
                                                        return IpcConfig.App.CAR_MUSIC;
                                                    case 17:
                                                        return IpcConfig.App.APP_PRIVACY_SERVICE;
                                                    case 18:
                                                        return IpcConfig.App.CAR_CONTROL;
                                                    case 19:
                                                        return IpcConfig.App.APP_ROUTE_SRHDPKMAP;
                                                    case 20:
                                                        return IpcConfig.App.APP_DIAGNOSTIC;
                                                    default:
                                                        b.d.b.e.c.a("MessageCenterPresenter", "Unsupport messageType:" + messageCenterBean.getMessageType() + ", return!");
                                                        return null;
                                                }
                                            }
                                            return IpcConfig.App.CONFIGURATION_CENTER;
                                        }
                                        return IpcConfig.App.CAR_OTA;
                                    }
                                    return IpcConfig.App.APP_XUI_SERVICE;
                                }
                                return IpcConfig.App.APP_AIOT_SERVICE;
                            }
                            return IpcConfig.App.CAR_SETTINGS;
                        }
                        return IpcConfig.App.APP_APPSTORE;
                    }
                    return IpcConfig.App.CAR_ACCOUNT;
                }
                return IpcConfig.App.CAR_CHARGE_CONTROL;
            }
            return IpcConfig.App.AUTO_CAR_WASH;
        } else {
            return IpcConfig.App.MAP_NAVI;
        }
    }

    private void c(String str, byte[] bArr) {
        String str2 = this.f2275a;
        if (str2 == null || !str2.equals(str)) {
            return;
        }
        String str3 = new String(bArr);
        b.d.b.e.c.l("MessageCenterPresenter", "handleMessageArrived topic:" + str + " msg:" + str3);
        try {
            MessageCenterBean messageCenterBean = (MessageCenterBean) com.xiaopeng.device.communication.f.a.a().fromJson(str3, (Class<Object>) MessageCenterBean.class);
            f(messageCenterBean);
            this.f2276b.c(messageCenterBean.getMessageId());
        } catch (JsonSyntaxException e) {
            b.d.b.e.c.b("MessageCenterPresenter", "handleMessageArrived parse json fail!", e);
        }
    }

    private boolean d() {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = currentTimeMillis - this.f2278d > 60000;
        if (z) {
            this.f2278d = currentTimeMillis;
        }
        return z;
    }

    private void f(MessageCenterBean messageCenterBean) {
        String b2 = b(messageCenterBean);
        if (TextUtils.isEmpty(b2)) {
            b.d.b.e.c.t("MessageCenterPresenter", "ipcTarget is empty, return!");
        } else if (IpcConfig.App.DEVICE_COMMUNICATION.equals(b2)) {
            org.greenrobot.eventbus.c.d().q(new com.xiaopeng.device.communication.messagecenter.a(messageCenterBean));
        } else {
            if (10003 == messageCenterBean.getScene() && b.d.b.e.m.c.c() && IpcConfig.App.CAR_ACCOUNT.equals(b2)) {
                org.greenrobot.eventbus.c.d().q(new com.xiaopeng.device.communication.messagecenter.a(messageCenterBean));
            }
            String json = com.xiaopeng.device.communication.f.a.a().toJson(messageCenterBean);
            if (com.xiaopeng.device.communication.a.a(IpcConfig.MessageCenterConfig.IPC_ID_MESSAGE_CHANNEL_PUSH_MESSAGE, null)) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("senderPackageName", App.c().getPackageName());
                jsonObject.addProperty("receiverPackageName", b2);
                jsonObject.addProperty(IpcConfig.IPCKey.STRING_MSG, json);
                com.xiaopeng.device.communication.a.e(IpcConfig.MessageCenterConfig.IPC_ID_MESSAGE_CHANNEL_PUSH_MESSAGE, jsonObject.toString(), b2);
            } else {
                Bundle bundle = new Bundle();
                bundle.putString(IpcConfig.IPCKey.STRING_MSG, json);
                ((IIpcService) Module.get(IpcModuleEntry.class).get(IIpcService.class)).sendData(IpcConfig.MessageCenterConfig.IPC_ID_MESSAGE_CHANNEL_PUSH_MESSAGE, bundle, b2);
            }
            b.d.b.e.c.a("MessageCenterPresenter", "sendMessageBeans:" + json + " to:" + b2);
        }
    }

    private void g() {
        String c2 = g.c();
        b.d.b.e.c.a("MessageCenterPresenter", "subscribeToTopic hardwareId:" + c2);
        if (!TextUtils.isEmpty(c2)) {
            this.f2275a = String.format("Xp/Msg/Push/%s", c2);
            boolean g = com.xiaopeng.device.communication.e.a.a().g(this.f2275a);
            b.d.b.e.c.a("MessageCenterPresenter", "subscribe msgTopic=" + this.f2275a + " result:" + g);
            return;
        }
        b.d.b.e.c.s("MessageCenterPresenter", "checkVid not available!");
    }

    public void a() {
        org.greenrobot.eventbus.c.d().u(this);
    }

    public void e() {
        boolean d2 = e.d(App.c());
        b.d.b.e.c.a("MessageCenterPresenter", "onNetworkChange available:" + d2);
        if (d2) {
            if (!d()) {
                b.d.b.e.c.l("MessageCenterPresenter", "Request offline message too frequently, return!");
                return;
            }
            this.f2276b.e();
            this.f2277c.k();
        }
    }

    @m(threadMode = ThreadMode.ASYNC)
    public void onEvent(IIpcService.IpcMessageEvent ipcMessageEvent) {
        if (ipcMessageEvent.getMsgID() != 1403) {
            return;
        }
        this.f2277c.i(ipcMessageEvent.getPayloadData());
    }

    @m(threadMode = ThreadMode.POSTING)
    public void onMessageEventPosting(IEvent iEvent) {
        int i = a.f2279a[iEvent.type().ordinal()];
        if (i == 1) {
            c(iEvent.messageTopic(), iEvent.messageContent());
        } else if (i != 2) {
        } else {
            g();
        }
    }

    @m(threadMode = ThreadMode.POSTING)
    public void onMessageResponse(MessageCenterResponse messageCenterResponse) {
        b.d.b.e.c.a("MessageCenterPresenter", "onMessageResponse:" + messageCenterResponse);
        if (messageCenterResponse != null && messageCenterResponse.getData() != null && messageCenterResponse.getData().getList() != null && !messageCenterResponse.getData().getList().isEmpty()) {
            for (MessageCenterBean messageCenterBean : messageCenterResponse.getData().getList()) {
                f(messageCenterBean);
            }
            return;
        }
        b.d.b.e.c.l("MessageCenterPresenter", "Empty data list, return!");
    }

    @m(threadMode = ThreadMode.ASYNC)
    public void onEvent(a.C0090a c0090a) {
        if (c0090a.a() != 1403) {
            return;
        }
        this.f2277c.j(c0090a.b());
    }
}
