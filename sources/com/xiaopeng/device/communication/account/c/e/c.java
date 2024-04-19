package com.xiaopeng.device.communication.account.c.e;

import android.os.SystemProperties;
import android.text.TextUtils;
import com.xiaopeng.device.communication.App;
import com.xiaopeng.device.communication.account.c.e.a;
import com.xiaopeng.lib.framework.netchannelmodule.messaging.profile.AbstractChannelProfile;
/* compiled from: StepCheckMqttAccount.java */
/* loaded from: classes.dex */
public class c implements a {
    private boolean a(String str) {
        return TextUtils.isEmpty(SystemProperties.get(str, (String) null));
    }

    private boolean b() {
        String str = App.c().b().f2259a;
        b.d.b.e.c.a("AccountModel", "current url : " + str);
        String b2 = b.d.b.e.l.a.b(SystemProperties.get(AbstractChannelProfile.SYSTEM_PROPERTY_MQTT_REPORTING_URL), "@!chxpzi#0109$+/");
        b.d.b.e.c.a("AccountModel", "system property url : " + b2);
        if (str.contains("https://xmart.xiaopeng.com") && b2 != null && b2.contains("iot2.xiaopeng.com")) {
            return false;
        }
        if (str.contains("xmart.deploy-test.xiaopeng.com") && b2 != null && b2.contains("pre.emq.xiaopeng.com")) {
            return false;
        }
        return (str.contains("https://10.0.13.28:8553") && b2 != null && b2.contains("10.0.13.28")) ? false : true;
    }

    @Override // com.xiaopeng.device.communication.account.c.e.a
    public a.EnumC0093a execute() {
        if (!a(AbstractChannelProfile.SYSTEM_PROPERTY_MQTT_COMM_URL) && !a(AbstractChannelProfile.SYSTEM_PROPERTY_MQTT_COMM_ID) && !a(AbstractChannelProfile.SYSTEM_PROPERTY_MQTT_COMM_USER) && !a(AbstractChannelProfile.SYSTEM_PROPERTY_MQTT_COMM_PASS) && !a(AbstractChannelProfile.SYSTEM_PROPERTY_MQTT_REPORTING_URL) && !a(AbstractChannelProfile.SYSTEM_PROPERTY_MQTT_ID) && !a(AbstractChannelProfile.SYSTEM_PROPERTY_MQTT_USER) && !a(AbstractChannelProfile.SYSTEM_PROPERTY_MQTT_PASS) && !b()) {
            b.d.b.e.c.l("AccountModel", "######## MQTT account has already inited, return SUCCESS!");
            return a.EnumC0093a.EXECUTE_RESULT_SUCCESS;
        }
        return a.EnumC0093a.EXECUTE_RESULT_NEXT;
    }
}
