package b.d.b.e.m;

import android.os.SystemProperties;
import android.util.Log;
/* compiled from: DeviceInfoUtils.java */
/* loaded from: classes.dex */
public class c {
    public static String a() {
        return SystemProperties.get("ro.product.model", "");
    }

    public static String b() {
        String str = SystemProperties.get("ro.xiaopeng.software", "");
        return ("".equals(str) || str == null) ? str : str.substring(7, 9);
    }

    public static boolean c() {
        boolean z = true;
        try {
            z = true ^ b().contains("ZH");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.i("netChannel", "isInternationVersion :\t" + z);
        return z;
    }
}
