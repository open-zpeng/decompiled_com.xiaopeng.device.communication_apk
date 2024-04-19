package b.b.a.a.f;

import android.os.Process;
import android.util.Log;
/* compiled from: Logger.java */
/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private static String f1116a = "UTAnalytics:";

    /* renamed from: b  reason: collision with root package name */
    private static boolean f1117b = false;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f1118c = false;

    public static void a(String str, Object obj) {
        if (g() || f()) {
            Log.w(str + f1116a, obj + "");
        }
    }

    public static void b(String str, Object obj, Throwable th) {
        if (g() || f()) {
            Log.w(str + f1116a, obj + "", th);
        }
    }

    public static void c(String str, Object... objArr) {
        if (f1118c) {
            String str2 = f1116a + str;
            StringBuilder sb = new StringBuilder();
            sb.append("pid:");
            sb.append(Process.myPid());
            sb.append(" ");
            if (objArr != null) {
                for (int i = 0; i < objArr.length; i++) {
                    if (objArr[i] != null) {
                        String obj = objArr[i].toString();
                        if (!obj.endsWith(":") && !obj.endsWith(": ")) {
                            sb.append(obj);
                            sb.append(",");
                        } else {
                            sb.append(obj);
                        }
                    }
                }
            }
            Log.d(str2, sb.toString());
        }
    }

    public static void d(String str, String... strArr) {
        if (f1118c) {
            String str2 = f1116a + str;
            StringBuilder sb = new StringBuilder();
            sb.append("pid:");
            sb.append(Process.myPid());
            sb.append(" ");
            if (strArr != null) {
                for (int i = 0; i < strArr.length; i++) {
                    if (strArr[i] != null) {
                        String str3 = strArr[i];
                        if (!str3.endsWith(":") && !str3.endsWith(": ")) {
                            sb.append(str3);
                            sb.append(",");
                        } else {
                            sb.append(str3);
                        }
                    }
                }
            }
            Log.i(str2, sb.toString());
        }
    }

    public static void e(boolean z) {
        f1118c = z;
    }

    public static boolean f() {
        return f1117b;
    }

    public static boolean g() {
        return f1118c;
    }
}
