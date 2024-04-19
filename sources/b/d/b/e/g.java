package b.d.b.e;

import android.os.Build;
import android.os.SystemProperties;
import android.text.TextUtils;
/* compiled from: SystemPropertyUtil.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1395a = "persist.sys.mqtt.comm_url" + b.d.b.e.m.b.a();

    /* renamed from: b  reason: collision with root package name */
    private static final String f1396b = "persist.sys.mqtt.url" + b.d.b.e.m.b.a();

    /* renamed from: c  reason: collision with root package name */
    private static final String f1397c = "persist.sys.mqtt.user" + b.d.b.e.m.b.a();

    /* renamed from: d  reason: collision with root package name */
    private static final String f1398d = "persist.sys.mqtt.pass" + b.d.b.e.m.b.a();
    private static final String e = "persist.sys.mqtt.id" + b.d.b.e.m.b.a();

    public static long a() {
        return SystemProperties.getLong("persist.sys.account_uid", -1L);
    }

    public static String b() {
        return SystemProperties.get("sys.xiaopeng.dbc_ver", "");
    }

    public static String c() {
        if (Build.VERSION.SDK_INT >= 26) {
            return SystemProperties.get("persist.sys.mcu.hardwareId");
        }
        return SystemProperties.get("persist.sys.hardware_id");
    }

    public static String d() {
        if (Build.VERSION.SDK_INT >= 26) {
            return SystemProperties.get("sys.xiaopeng.iccid", "");
        }
        return SystemProperties.get("ril.audio.iccid", "");
    }

    public static String e() {
        return SystemProperties.get("ro.xiaopeng.software");
    }

    public static String f() {
        String str = SystemProperties.get("persist.sys.xiaopeng.vin", "");
        return TextUtils.isEmpty(str) ? SystemProperties.get("sys.xiaopeng.vin", "") : str;
    }

    public static int g() {
        return SystemProperties.getInt("persist.sys.vehicle_id", -1);
    }

    public static void h(String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            SystemProperties.set("persist.sys.mcu.hardwareId", str);
        } else {
            SystemProperties.set("persist.sys.hardware_id", str);
        }
    }

    public static void i(int i) {
        SystemProperties.set("persist.sys.vehicle_id", i + "");
    }
}
