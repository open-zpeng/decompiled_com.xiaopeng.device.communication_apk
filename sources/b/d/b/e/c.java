package b.d.b.e;

import android.app.ActivityThread;
import android.util.Log;
/* compiled from: LogUtils.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static int f1387a = 2;

    /* renamed from: b  reason: collision with root package name */
    public static String f1388b = k();

    /* renamed from: c  reason: collision with root package name */
    public static b f1389c = new a();

    /* renamed from: d  reason: collision with root package name */
    public static boolean f1390d = true;
    public static boolean e = false;

    /* compiled from: LogUtils.java */
    /* loaded from: classes.dex */
    public static class a implements b {
        @Override // b.d.b.e.c.b
        public void a(int i, String str, String str2, String str3) {
            if (i == 2) {
                Log.v(str2, str);
            } else if (i == 3) {
                Log.d(str2, str);
                String str4 = "DEBUG: " + str;
            } else if (i == 4) {
                Log.i(str2, str);
                String str5 = "INFO: " + str;
            } else if (i == 5) {
                Log.w(str2, str);
                String str6 = "WARN: " + str;
            } else if (i != 6) {
            } else {
                Log.e(str2, str);
                String str7 = "ERROR: " + str;
            }
        }
    }

    /* compiled from: LogUtils.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(int i, String str, String str2, String str3);
    }

    public static void a(Object obj, String str) {
        if (o(3)) {
            e(3, obj, str, null, e);
        }
    }

    public static void b(Object obj, String str, Throwable th) {
        if (o(3)) {
            e(3, obj, str, th, e);
        }
    }

    public static void c(Object obj, Throwable th) {
        if (o(3)) {
            e(3, obj, "Exception occurs at", th, e);
        }
    }

    public static void d(String str) {
        if (o(3)) {
            e(3, null, str, null, e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void e(int r4, java.lang.Object r5, java.lang.String r6, java.lang.Throwable r7, boolean r8) {
        /*
            r0 = 0
            if (r8 == 0) goto L20
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            java.lang.StackTraceElement[] r1 = r1.getStackTrace()
            if (r1 == 0) goto L14
            int r2 = r1.length
            r3 = 4
            if (r2 <= r3) goto L14
            r1 = r1[r3]
            goto L15
        L14:
            r1 = r0
        L15:
            if (r1 == 0) goto L20
            java.lang.String r0 = r1.getFileName()
            int r1 = r1.getLineNumber()
            goto L21
        L20:
            r1 = 0
        L21:
            if (r8 != 0) goto L25
            if (r7 == 0) goto L29
        L25:
            java.lang.String r6 = q(r0, r1, r6, r7, r8)
        L29:
            java.lang.String r5 = r(r5)
            if (r5 != 0) goto L38
            boolean r5 = android.text.TextUtils.isEmpty(r0)
            if (r5 == 0) goto L39
            java.lang.String r0 = b.d.b.e.c.f1388b
            goto L39
        L38:
            r0 = r5
        L39:
            p(r4, r0, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b.d.b.e.c.e(int, java.lang.Object, java.lang.String, java.lang.Throwable, boolean):void");
    }

    public static void f(Object obj, String str) {
        if (o(6)) {
            e(6, obj, str, null, e);
        }
    }

    public static void g(Object obj, String str, Throwable th) {
        if (o(6)) {
            e(6, obj, str, th, e);
        }
    }

    public static void h(Object obj, String str, Object... objArr) {
        if (o(6)) {
            e(6, obj, String.format(str, objArr), null, e);
        }
    }

    public static void i(Object obj, Throwable th) {
        if (o(6)) {
            e(6, obj, "Exception occurs at", th, e);
        }
    }

    public static void j(String str) {
        if (o(6)) {
            e(6, null, str, null, e);
        }
    }

    private static String k() {
        String[] split = ActivityThread.currentApplication().getPackageName().split("\\.");
        return split[split.length - 1];
    }

    public static void l(Object obj, String str) {
        if (o(4)) {
            e(4, obj, str, null, e);
        }
    }

    public static void m(Object obj, String str, Throwable th) {
        if (o(4)) {
            e(4, obj, str, th, e);
        }
    }

    public static boolean n() {
        return f1390d;
    }

    public static boolean o(int i) {
        return f1387a <= i && n();
    }

    private static void p(int i, String str, String str2) {
        f1389c.a(i, str2, str, null);
    }

    private static String q(String str, int i, String str2, Throwable th, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        if (z) {
            sb.append(" (T:");
            sb.append(Thread.currentThread().getId());
            sb.append(")");
            if (f1388b != null) {
                sb.append("(C:");
                sb.append(f1388b);
                sb.append(")");
            }
            sb.append("at (");
            if (str == null) {
                str = "";
            }
            sb.append(str);
            sb.append(":");
            sb.append(i);
            sb.append(")");
        }
        if (th != null) {
            sb.append('\n');
            sb.append(Log.getStackTraceString(th));
        }
        return sb.toString();
    }

    private static String r(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof Class) {
            return ((Class) obj).getSimpleName();
        }
        return obj.getClass().getSimpleName();
    }

    public static void s(Object obj, String str) {
        if (o(2)) {
            e(2, obj, str, null, e);
        }
    }

    public static void t(Object obj, String str) {
        if (o(5)) {
            e(5, obj, str, null, e);
        }
    }

    public static void u(Object obj, String str, Throwable th) {
        if (o(5)) {
            e(5, obj, str, th, e);
        }
    }

    public static void v(Object obj, String str, Object... objArr) {
        if (o(5)) {
            e(5, obj, String.format(str, objArr), null, e);
        }
    }

    public static void w(String str) {
        if (o(5)) {
            e(5, null, str, null, e);
        }
    }
}
