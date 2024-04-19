package com.xiaopeng.device.communication.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import b.d.b.e.c;
import b.d.b.e.g;
import com.xiaopeng.device.communication.App;
import com.xiaopeng.lib.framework.ipcmodule.IpcModuleEntry;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.ipcmodule.IIpcService;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.messaging.IEvent;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.messaging.IMessaging;
import com.xiaopeng.lib.framework.netchannelmodule.messaging.events.ReceivedMessageEvent;
import com.xiaopeng.libconfig.ipc.IpcConfig;
import java.util.HashMap;
import java.util.Map;
/* compiled from: MessagingDebugReceiver.java */
/* loaded from: classes.dex */
public class b extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f2263a = false;

    /* renamed from: b  reason: collision with root package name */
    private static Map<String, ReceivedMessageEvent> f2264b = new HashMap();

    static {
        IEvent.TYPE type = IEvent.TYPE.RECEIVED_MESSAGE;
        ReceivedMessageEvent receivedMessageEvent = new ReceivedMessageEvent(type);
        IMessaging.CHANNEL channel = IMessaging.CHANNEL.COMMUNICATION;
        f2264b.put("cdu_diagnosis", receivedMessageEvent.channel(channel).topic("Xmart/Msg/Car/" + g.g()).message("{\"msg_id\":\"1343506507657\",\"msg_type\":2,\"service_type\":1106,\"msg_content\":{\"cmd_type\":1,\"cmd_value\":1}}"));
        f2264b.put("remote_can", new ReceivedMessageEvent(type).channel(channel).topic("Xmart/Msg/Car/" + g.g()).message("{\"msg_id\":\"301343506508888\",\"msg_type\":3,\"service_type\":26,\"msg_content\":{\"canLog\":\"{\\\"cduSwitch\\\": \\\"upload\\\",\\\"instructions\\\": {\\\"time\\\": \\\"[20181105,20181105,20181106,20181107,20181108,20181109]\\\",\\\"instruct\\\": \\\"fetchFile\\\"}}\"}}"));
        f2264b.put("control_hvac", new ReceivedMessageEvent(type).channel(channel).topic("Xmart/Msg/Car/" + g.g()).message("{\"msg_content\":{\"cmd_type\":1,\"cmd_value\":1},\"msg_id\":\"1199945154155668115223\",\"msg_type\":2,\"service_type\":3}"));
        f2264b.put("control_camera", new ReceivedMessageEvent(type).channel(channel).topic("Xmart/Msg/Car/" + g.g()).message("{\"msg_content\":{\"cmd_type\":1},\"msg_id\":\"1199945154155782387846\",\"msg_type\":2,\"service_type\":11}"));
        f2264b.put("control_pilot", new ReceivedMessageEvent(type).channel(channel).topic("Xmart/Msg/Car/" + g.g()).message("{\"msg_content\":{\"cmd_type\":1},\"msg_id\":\"1199945154155782387846\",\"msg_type\":2,\"service_type\":10}"));
        f2264b.put("control_info", new ReceivedMessageEvent(type).channel(channel).topic("Xmart/Msg/Car/" + g.g()).message("{\"msg_content\":{\"cmd_type\":2},\"msg_id\":\"1199945154155782387846\",\"msg_type\":2,\"service_type\":19}"));
        f2264b.put("message", new ReceivedMessageEvent(type).channel(channel).topic("Xp/Msg/Push/" + g.c()).message("{\"bizType\":1,\"content\":\"{\\\"content\\\":\\\"{\\\\\\\"permanent\\\\\\\":1,\\\\\\\"buttons\\\\\\\":[{\\\\\\\"content\\\\\\\":\\\\\\\"{\\\\\\\\\\\\\\\"cmd\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"play\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"object\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"{\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\"id\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\":753489283,\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\"trackId\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\":b1qnORw4228a}\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"type\\\\\\\\\\\\\\\":1}\\\\\\\",\\\\\\\"name\\\\\\\":\\\\\\\"马上播放\\\\\\\",\\\\\\\"pack\\\\\\\":\\\\\\\"com.xiaopeng.musicradio\\\\\\\"}],\\\\\\\"pics\\\\\\\":[{\\\\\\\"content\\\\\\\":\\\\\\\"{\\\\\\\\\\\\\\\"cmd\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"open\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"object\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"{\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\"id\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\":753489283,\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\"trackId\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\":b1qnORw4228a}\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"type\\\\\\\\\\\\\\\":1}\\\\\\\",\\\\\\\"pack\\\\\\\":\\\\\\\"com.xiaopeng.musicradio\\\\\\\",\\\\\\\"url\\\\\\\":\\\\\\\"http://pic.xiami.net/images/album/img59/58259/7534892831453489283.jpg\\\\\\\"}],\\\\\\\"titles\\\\\\\":[\\\\\\\"权力的游戏最终季上线，凛冬将至\\\\\\\",\\\\\\\"生与死，爱与恨，光荣与耻辱，尽在冰与火之歌\\\\\\\"],\\\\\\\"type\\\\\\\":2}\\\",\\\"opportunity\\\":0,\\\"position\\\":1,\\\"type\\\":1}\",\"messageId\":567288013382889472,\"messageType\":1,\"priority\":500,\"scene\":1007,\"ts\":1555293602938,\"type\":1,\"validEndTs\":1555390800000,\"validStartTs\":1555293595071}"));
    }

    public static void a() {
        if (f2263a) {
            c.a("MessagingDebugReceiver", "already init, return!");
            return;
        }
        b bVar = new b();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.xiaopeng.device.communication.ACTION_DEBUG_CAR_CONTROL");
        intentFilter.addAction("com.xiaopeng.device.communication.ACTION_DEBUG_IPC");
        intentFilter.addAction("com.xiaopeng.device.communication.ACTION_DEBUG_RESET_ACCOUNT");
        App.c().registerReceiver(bVar, intentFilter);
        f2263a = true;
        c.a("MessagingDebugReceiver", "MessagingDebugReceiver init complete!");
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return;
        }
        String stringExtra = intent.getStringExtra("key");
        ReceivedMessageEvent receivedMessageEvent = f2264b.get(stringExtra);
        c.a("MessagingDebugReceiver", "onReceive action:" + action + " key:" + stringExtra + " eventJson:" + receivedMessageEvent);
        action.hashCode();
        char c2 = 65535;
        switch (action.hashCode()) {
            case -1970228796:
                if (action.equals("com.xiaopeng.device.communication.ACTION_DEBUG_RESET_ACCOUNT")) {
                    c2 = 0;
                    break;
                }
                break;
            case -793573501:
                if (action.equals("com.xiaopeng.device.communication.ACTION_DEBUG_IPC")) {
                    c2 = 1;
                    break;
                }
                break;
            case -30663623:
                if (action.equals("com.xiaopeng.device.communication.ACTION_DEBUG_CAR_CONTROL")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                org.greenrobot.eventbus.c.d().n(new com.xiaopeng.device.communication.account.a.b(null));
                return;
            case 1:
                Bundle bundle = new Bundle();
                bundle.putString(IpcConfig.DeviceCommunicationConfig.KEY_APP_MESSAGE_EVENT_NAME, "FIRST_CHARGE");
                ((IIpcService) Module.get(IpcModuleEntry.class).get(IIpcService.class)).sendData(IpcConfig.DeviceCommunicationConfig.SEND_APP_MESSAGE, bundle, IpcConfig.App.DEVICE_COMMUNICATION);
                return;
            case 2:
                if (receivedMessageEvent != null) {
                    org.greenrobot.eventbus.c.d().n(receivedMessageEvent);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
