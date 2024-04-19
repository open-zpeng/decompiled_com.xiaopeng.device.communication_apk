package com.xiaopeng.device.communication.account.b;

import android.os.Bundle;
import b.d.b.e.c;
import com.google.gson.JsonObject;
import com.xiaopeng.device.communication.App;
import com.xiaopeng.lib.framework.ipcmodule.IpcModuleEntry;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.ipcmodule.IIpcService;
import com.xiaopeng.libconfig.ipc.IpcConfig;
/* compiled from: XMartIPCHelper.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static b f2192a = new b();

    private b() {
    }

    public static b a() {
        return f2192a;
    }

    public void b(String str) {
        c.a("XMartIPCHelper", "sendMqttMessage:" + str);
        if (com.xiaopeng.device.communication.a.a(IpcConfig.DeviceCommunicationConfig.SEND_CAR_CONTROL_TOPIC, null)) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("senderPackageName", App.c().getPackageName());
            jsonObject.addProperty(IpcConfig.IPCKey.STRING_MSG, str);
            com.xiaopeng.device.communication.a.e(IpcConfig.DeviceCommunicationConfig.SEND_CAR_CONTROL_TOPIC, jsonObject.toString(), IpcConfig.App.DEVICE_COMMUNICATION);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(IpcConfig.IPCKey.STRING_MSG, str);
        ((IIpcService) Module.get(IpcModuleEntry.class).get(IIpcService.class)).sendData(IpcConfig.DeviceCommunicationConfig.SEND_CAR_CONTROL_TOPIC, bundle, IpcConfig.App.DEVICE_COMMUNICATION);
    }
}
