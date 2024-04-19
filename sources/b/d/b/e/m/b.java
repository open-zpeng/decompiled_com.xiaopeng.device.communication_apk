package b.d.b.e.m;

import android.os.Build;
import android.os.SystemProperties;
import android.text.TextUtils;
/* compiled from: BuildInfoUtils.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static String f1429a;

    public static String a() {
        int indexOf;
        String b2 = b();
        return (!TextUtils.isEmpty(b2) && (indexOf = b2.indexOf("_")) > 1) ? b2.substring(indexOf - 1, indexOf) : "4";
    }

    public static String b() {
        String str = f1429a;
        if (str != null) {
            return str;
        }
        String d2 = d("ro.xiaopeng.software");
        f1429a = d2;
        if ("unknown".equals(d2)) {
            f1429a = d("ro.build.display.id");
        }
        return f1429a;
    }

    public static String c() {
        return d("persist.sys.mcu.hardwareId");
    }

    private static String d(String str) {
        return SystemProperties.get(str, "unknown");
    }

    public static String e() {
        String b2;
        int indexOf;
        int i;
        int indexOf2;
        String d2 = d("ro.product.firmware");
        return (!"unknown".equals(d2) || (indexOf = (b2 = b()).indexOf("_")) <= 1 || (indexOf2 = b2.indexOf("_", (i = indexOf + 1))) <= indexOf) ? d2 : b2.substring(i, indexOf2);
    }

    public static boolean f() {
        return g() || i();
    }

    public static boolean g() {
        return "eng".equals(Build.TYPE);
    }

    public static boolean h() {
        return "4".equals(a());
    }

    public static boolean i() {
        return "userdebug".equals(Build.TYPE);
    }

    public static boolean j() {
        return "user".equals(Build.TYPE);
    }
}
