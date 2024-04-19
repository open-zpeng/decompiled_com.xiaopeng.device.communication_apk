package com.xiaopeng.device.communication.c;

import android.car.Car;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import b.d.b.d.e;
import b.d.b.e.c;
import b.d.b.e.i;
import com.google.gson.JsonObject;
import com.xiaopeng.device.communication.App;
import com.xiaopeng.lib.framework.carcontrollermodule.R;
import com.xiaopeng.lib.framework.ipcmodule.IpcModuleEntry;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.ipcmodule.IIpcService;
import com.xiaopeng.libconfig.ipc.IpcConfig;
import com.xiaopeng.libconfig.ipc.bean.MqttMsgBase;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: CarControlHelper.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f2245a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CarControlHelper.java */
    /* renamed from: com.xiaopeng.device.communication.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0095a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f2246a;

        RunnableC0095a(String str) {
            this.f2246a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!e.f().h()) {
                e.f().g(App.c());
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            e.f().i(this.f2246a);
            c.a("CarControlHelper", "upload RemoteLog!");
        }
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a a() {
        if (f2245a == null) {
            synchronized (a.class) {
                if (f2245a == null) {
                    f2245a = new a();
                }
            }
        }
        return f2245a;
    }

    private boolean i() {
        String xpCduType = Car.getXpCduType();
        xpCduType.hashCode();
        char c2 = 65535;
        switch (xpCduType.hashCode()) {
            case 2566:
                if (xpCduType.equals("Q7")) {
                    c2 = 0;
                    break;
                }
                break;
            case 2567:
                if (xpCduType.equals("Q8")) {
                    c2 = 1;
                    break;
                }
                break;
            case 2568:
                if (xpCduType.equals("Q9")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
            case 2:
                return true;
            default:
                return false;
        }
    }

    void b(int i, String str) {
        c.a("CarControlHelper", "handleCarDiagnosis:" + str);
        if (com.xiaopeng.device.communication.a.a(IpcConfig.AfterSalesConfig.IPC_DIAG_REQUEST, null)) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("senderPackageName", App.c().getPackageName());
            jsonObject.addProperty("receiverPackageName", IpcConfig.App.APP_CAR_DIAGNOSIS);
            jsonObject.addProperty(IpcConfig.IPCKey.STRING_MSG, str);
            com.xiaopeng.device.communication.a.e(IpcConfig.AfterSalesConfig.IPC_DIAG_REQUEST, jsonObject.toString(), IpcConfig.App.APP_CAR_DIAGNOSIS);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(IpcConfig.IPCKey.STRING_MSG, str);
        ((IIpcService) Module.get(IpcModuleEntry.class).get(IIpcService.class)).sendData(IpcConfig.AfterSalesConfig.IPC_DIAG_REQUEST, bundle, IpcConfig.App.APP_CAR_DIAGNOSIS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(int i, String str) {
        c.a("CarControlHelper", "handleControlMsg:" + str + "\tserviceType:\t" + i);
        if (i >= 2000 && i <= 2199) {
            b(i, str);
        } else if (i >= 3000 && i <= 3199) {
            h(i, str);
        } else if (b.d.b.e.m.c.c()) {
            Log.i("CarControlHelper", "InternationalVer do dot handleControlMsg except CAARDIAGNOSIS");
        } else if (com.xiaopeng.device.communication.a.a(IpcConfig.CarRemoteControlConfig.TYPE_CONTROL_COMMAND, null)) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("senderPackageName", App.c().getPackageName());
            jsonObject.addProperty("receiverPackageName", IpcConfig.App.CAR_REMOTE_CONTROL);
            jsonObject.addProperty(IpcConfig.IPCKey.STRING_MSG, str);
            com.xiaopeng.device.communication.a.e(IpcConfig.CarRemoteControlConfig.TYPE_CONTROL_COMMAND, jsonObject.toString(), IpcConfig.App.CAR_REMOTE_CONTROL);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString(IpcConfig.IPCKey.STRING_MSG, str);
            ((IIpcService) Module.get(IpcModuleEntry.class).get(IIpcService.class)).sendData(IpcConfig.CarRemoteControlConfig.TYPE_CONTROL_COMMAND, bundle, IpcConfig.App.CAR_REMOTE_CONTROL);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(MqttMsgBase mqttMsgBase) {
        int serviceType = mqttMsgBase.getServiceType();
        c.a("CarControlHelper", "start handleHeartbeat serviceType = " + serviceType);
        IIpcService iIpcService = (IIpcService) Module.get(IpcModuleEntry.class).get(IIpcService.class);
        if (serviceType == 1) {
            iIpcService.sendData(IpcConfig.CameraConfig.REMOTE_COMMAND_LIVE_CLIENT_IS_LIVING, null, IpcConfig.App.CAR_CAMERA);
            iIpcService.sendData(IpcConfig.CarRemoteControlConfig.TYPE_KEEP_IG_ON_WHEN_LIVE, null, IpcConfig.App.CAR_REMOTE_CONTROL);
        } else if (serviceType == 19) {
            iIpcService.sendData(100003, null, IpcConfig.App.UPLOAD_CAR_INFO);
        } else if (serviceType == 11) {
            iIpcService.sendData(IpcConfig.CameraConfig.REMOTE_COMMAND_LIVE_CLIENT_IS_LIVING, null, IpcConfig.App.CAR_CAMERA);
        }
    }

    void e(int i, String str) {
        Log.i("CarControlHelper", "handleMapRemoteGaoDeLog\t" + str);
        try {
            if (new JSONObject(str).getJSONObject("msg_content").get("naviLog") != null) {
                if (com.xiaopeng.device.communication.a.a(IpcConfig.AfterSalesConfig.IPC_DIAG_MAP_GAODE_LOG, null)) {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("senderPackageName", App.c().getPackageName());
                    jsonObject.addProperty("receiverPackageName", IpcConfig.App.MAP_NAVI);
                    jsonObject.addProperty(IpcConfig.IPCKey.STRING_MSG, str);
                    com.xiaopeng.device.communication.a.e(IpcConfig.AfterSalesConfig.IPC_DIAG_MAP_GAODE_LOG, jsonObject.toString(), IpcConfig.App.MAP_NAVI);
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putString(IpcConfig.IPCKey.STRING_MSG, str);
                    ((IIpcService) Module.get(IpcModuleEntry.class).get(IIpcService.class)).sendData(IpcConfig.AfterSalesConfig.IPC_DIAG_MAP_GAODE_LOG, bundle, IpcConfig.App.MAP_NAVI);
                }
                c.a("CarControlHelper", "handleMapRemoteGaoDeLog: send ipcMsg" + str);
            }
        } catch (JSONException e) {
            c.u("CarControlHelper", "SERVICE_TYPE_UPLOAD_CODE, parse msg fail!", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str) {
        c.a("CarControlHelper", "handleOperationFeedback msg=" + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i = jSONObject.getInt("service_type");
            String string = jSONObject.getString("msg_content");
            IIpcService iIpcService = (IIpcService) Module.get(IpcModuleEntry.class).get(IIpcService.class);
            if (i != 20) {
                if (i != 21) {
                    switch (i) {
                        case 14:
                            if (com.xiaopeng.device.communication.a.a(IpcConfig.DeviceCommunicationConfig.SEND_CAR_CONTROL_TOPIC, null)) {
                                JsonObject jsonObject = new JsonObject();
                                jsonObject.addProperty("senderPackageName", App.c().getPackageName());
                                jsonObject.addProperty("receiverPackageName", IpcConfig.App.CAR_ACCOUNT);
                                jsonObject.addProperty(IpcConfig.IPCKey.STRING_MSG, string);
                                com.xiaopeng.device.communication.a.e(IpcConfig.AccountConfig.IPC_MSG_ID_ACCOUNT_QR_LOGIN, jsonObject.toString(), IpcConfig.App.CAR_ACCOUNT);
                                break;
                            } else {
                                Bundle bundle = new Bundle();
                                bundle.putString(IpcConfig.IPCKey.STRING_MSG, string);
                                iIpcService.sendData(IpcConfig.AccountConfig.IPC_MSG_ID_ACCOUNT_QR_LOGIN, bundle, IpcConfig.App.CAR_ACCOUNT);
                                break;
                            }
                        case 15:
                            if (com.xiaopeng.device.communication.a.a(IpcConfig.AccountConfig.IPC_MSG_ID_ACCOUNT_FACE_BIND, null)) {
                                JsonObject jsonObject2 = new JsonObject();
                                jsonObject2.addProperty("senderPackageName", App.c().getPackageName());
                                jsonObject2.addProperty("receiverPackageName", IpcConfig.App.CAR_ACCOUNT);
                                jsonObject2.addProperty(IpcConfig.IPCKey.STRING_MSG, string);
                                com.xiaopeng.device.communication.a.e(IpcConfig.AccountConfig.IPC_MSG_ID_ACCOUNT_FACE_BIND, jsonObject2.toString(), IpcConfig.App.CAR_ACCOUNT);
                                break;
                            } else {
                                Bundle bundle2 = new Bundle();
                                bundle2.putString(IpcConfig.IPCKey.STRING_MSG, string);
                                iIpcService.sendData(IpcConfig.AccountConfig.IPC_MSG_ID_ACCOUNT_FACE_BIND, bundle2, IpcConfig.App.CAR_ACCOUNT);
                                break;
                            }
                        case 16:
                            if (com.xiaopeng.device.communication.a.a(IpcConfig.AccountConfig.IPC_MSG_ID_ACCOUNT_USER_SWITCH, null)) {
                                JsonObject jsonObject3 = new JsonObject();
                                jsonObject3.addProperty("senderPackageName", App.c().getPackageName());
                                jsonObject3.addProperty("receiverPackageName", IpcConfig.App.CAR_ACCOUNT);
                                jsonObject3.addProperty(IpcConfig.IPCKey.STRING_MSG, string);
                                com.xiaopeng.device.communication.a.e(IpcConfig.AccountConfig.IPC_MSG_ID_ACCOUNT_USER_SWITCH, jsonObject3.toString(), IpcConfig.App.CAR_ACCOUNT);
                                break;
                            } else {
                                Bundle bundle3 = new Bundle();
                                bundle3.putString(IpcConfig.IPCKey.STRING_MSG, string);
                                iIpcService.sendData(IpcConfig.AccountConfig.IPC_MSG_ID_ACCOUNT_USER_SWITCH, bundle3, IpcConfig.App.CAR_ACCOUNT);
                                break;
                            }
                    }
                } else if (com.xiaopeng.device.communication.a.a(IpcConfig.AccountConfig.IPC_MSG_ID_ACCOUNT_UPDATE_INFO, null)) {
                    JsonObject jsonObject4 = new JsonObject();
                    jsonObject4.addProperty("senderPackageName", App.c().getPackageName());
                    jsonObject4.addProperty("receiverPackageName", IpcConfig.App.CAR_ACCOUNT);
                    jsonObject4.addProperty(IpcConfig.IPCKey.STRING_MSG, string);
                    com.xiaopeng.device.communication.a.e(IpcConfig.AccountConfig.IPC_MSG_ID_ACCOUNT_UPDATE_INFO, jsonObject4.toString(), IpcConfig.App.CAR_ACCOUNT);
                } else {
                    Bundle bundle4 = new Bundle();
                    bundle4.putString(IpcConfig.IPCKey.STRING_MSG, string);
                    iIpcService.sendData(IpcConfig.AccountConfig.IPC_MSG_ID_ACCOUNT_UPDATE_INFO, bundle4, IpcConfig.App.CAR_ACCOUNT);
                }
            } else if (com.xiaopeng.device.communication.a.a(IpcConfig.AccountConfig.IPC_MSG_ID_ACCOUNT_UPDATE_PERMISSION, null)) {
                JsonObject jsonObject5 = new JsonObject();
                jsonObject5.addProperty("senderPackageName", App.c().getPackageName());
                jsonObject5.addProperty("receiverPackageName", IpcConfig.App.CAR_ACCOUNT);
                jsonObject5.addProperty(IpcConfig.IPCKey.STRING_MSG, string);
                com.xiaopeng.device.communication.a.e(IpcConfig.AccountConfig.IPC_MSG_ID_ACCOUNT_UPDATE_PERMISSION, jsonObject5.toString(), IpcConfig.App.CAR_ACCOUNT);
            } else {
                Bundle bundle5 = new Bundle();
                bundle5.putString(IpcConfig.IPCKey.STRING_MSG, string);
                iIpcService.sendData(IpcConfig.AccountConfig.IPC_MSG_ID_ACCOUNT_UPDATE_PERMISSION, bundle5, IpcConfig.App.CAR_ACCOUNT);
            }
        } catch (Exception e) {
            c.a("CarControlHelper", "parse data Exception-->" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(int i, String str) {
        c.a("CarControlHelper", "handleServerMsg serviceType:" + i + " msg:" + str);
        switch (i) {
            case 25:
                try {
                    if (new JSONObject(str).getJSONObject("msg_content").getInt("cmd_type") == 1) {
                        if (!com.xiaopeng.device.communication.a.a(IpcConfig.AccountConfig.IPC_MSG_ID_ACCOUNT_COLLECT_CODE, null)) {
                            ((IIpcService) Module.get(IpcModuleEntry.class).get(IIpcService.class)).sendData(IpcConfig.AccountConfig.IPC_MSG_ID_ACCOUNT_COLLECT_CODE, null, IpcConfig.App.DEVICE_COMMUNICATION);
                        } else {
                            com.xiaopeng.device.communication.a.e(IpcConfig.AccountConfig.IPC_MSG_ID_ACCOUNT_COLLECT_CODE, null, IpcConfig.App.DEVICE_COMMUNICATION);
                        }
                    }
                    return;
                } catch (JSONException e) {
                    c.u("CarControlHelper", "SERVICE_TYPE_UPLOAD_CODE, parse msg fail!", e);
                    return;
                }
            case 26:
                e(i, str);
                c.a("CarControlHelper", "enter CarControlHelper to collect log");
                i.h(0, new RunnableC0095a(str));
                return;
            case R.styleable.AppCompatTheme_actionModeSplitBackground /* 27 */:
                if (com.xiaopeng.device.communication.a.a(IpcConfig.ChargeConfig.CHARGE_CONNECTOR_LOCK_STATUS, null)) {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("senderPackageName", App.c().getPackageName());
                    jsonObject.addProperty("receiverPackageName", IpcConfig.App.CAR_CHARGE_CONTROL);
                    jsonObject.addProperty(IpcConfig.IPCKey.STRING_MSG, str);
                    com.xiaopeng.device.communication.a.e(IpcConfig.ChargeConfig.CHARGE_CONNECTOR_LOCK_STATUS, jsonObject.toString(), IpcConfig.App.CAR_CHARGE_CONTROL);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putString(IpcConfig.IPCKey.STRING_MSG, str);
                ((IIpcService) Module.get(IpcModuleEntry.class).get(IIpcService.class)).sendData(IpcConfig.ChargeConfig.CHARGE_CONNECTOR_LOCK_STATUS, bundle, IpcConfig.App.CAR_CHARGE_CONTROL);
                return;
            default:
                return;
        }
    }

    void h(int i, String str) {
        if (!i()) {
            c.a("CarControlHelper", "handleTransportMode: the carType is not supported!");
            return;
        }
        c.a("CarControlHelper", "handleTransportMode:" + str);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("senderPackageName", App.c().getPackageName());
        jsonObject.addProperty("receiverPackageName", IpcConfig.App.AUTO_SHOW);
        jsonObject.addProperty(IpcConfig.IPCKey.STRING_MSG, str);
        com.xiaopeng.device.communication.a.e(1004, jsonObject.toString(), IpcConfig.App.AUTO_SHOW);
    }
}
