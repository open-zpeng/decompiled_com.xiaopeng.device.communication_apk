package b.d.b.d;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import b.d.b.d.g.b;
import com.xiaopeng.lib.framework.module.IModuleEntry;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: BugHunter.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f1343a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BugHunter.java */
    /* renamed from: b.d.b.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0054a implements b.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f1344a;

        C0054a(Context context) {
            this.f1344a = context;
        }

        @Override // b.d.b.d.g.b.c
        public void a(String[] strArr, boolean z, long... jArr) {
            String packageName = this.f1344a.getPackageName();
            StringBuilder sb = new StringBuilder();
            int length = strArr.length;
            String g = a.g(strArr[0]);
            int i = length - 1;
            int i2 = 0;
            while (true) {
                if (i < 0) {
                    break;
                }
                i2++;
                if (i2 == length) {
                    sb.append(strArr[i]);
                    break;
                }
                sb.append(strArr[i]);
                sb.append(MqttTopic.MULTI_LEVEL_WILDCARD);
                i--;
            }
            long j = jArr[0];
            String o = b.d.b.d.g.d.f1374b ? a.o(g, this.f1344a, packageName, strArr, j, jArr[1]) : "";
            IDataLog iDataLog = null;
            IModuleEntry iModuleEntry = Module.get(b.d.a.a.class);
            if (iModuleEntry != null) {
                try {
                    iDataLog = (IDataLog) iModuleEntry.get(IDataLog.class);
                } catch (Throwable th) {
                    th.printStackTrace();
                    Log.e("libBugHunter", "<<<< error, get IDataLog module occurred an exception, " + th.getMessage());
                }
            } else {
                Log.e("libBugHunter", "<<<< error, can not get DataLogModuleEntry");
            }
            if (iDataLog != null) {
                if (!b.d.b.e.m.c.c()) {
                    IMoleEventBuilder buildMoleEvent = iDataLog.buildMoleEvent();
                    buildMoleEvent.setEvent("perf_caton").setPageId("P00010").setButtonId("B001").setProperty("appName", packageName).setProperty("appVer", a.k(this.f1344a, packageName)).setProperty("anr", z).setProperty("md5", g).setProperty("elapseTime", Long.valueOf(j)).setProperty("stackInfo", sb.toString()).setProperty("memInfo", o);
                    iDataLog.sendStatData(buildMoleEvent.build());
                }
            } else {
                Log.e("libBugHunter", "<<<< upload caton log fail, can not get IDataLog module!");
            }
            if (a.f1343a) {
                Context context = this.f1344a;
                byte[] bytes = a.i(context, packageName, a.k(context, packageName), j, g, sb.toString()).getBytes();
                if (a.f1343a) {
                    a.h("/sdcard/Log/caton", packageName, bytes);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String g(String str) {
        int indexOf = str.indexOf("\n");
        if (indexOf > 0) {
            str = str.substring(indexOf + 1);
        }
        return d.a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void h(java.lang.String r7, java.lang.String r8, byte[] r9) {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r7)
            boolean r1 = r0.exists()
            if (r1 != 0) goto L4b
            boolean r1 = r0.mkdirs()
            java.lang.String r2 = "libBugHunter"
            if (r1 == 0) goto L46
            r1 = 1
            r3 = 0
            boolean r4 = r0.setReadable(r1, r3)
            boolean r5 = r0.setWritable(r1, r3)
            boolean r0 = r0.setExecutable(r1, r3)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "caton LogDir setReadable: "
            r1.append(r3)
            r1.append(r4)
            java.lang.String r3 = "; setWritable: "
            r1.append(r3)
            r1.append(r5)
            java.lang.String r3 = "; setExecutable: "
            r1.append(r3)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            b.d.b.e.c.a(r2, r0)
            goto L4b
        L46:
            java.lang.String r0 = "make caton LogDir failed"
            b.d.b.e.c.t(r2, r0)
        L4b:
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r7)
            java.lang.String r7 = "/"
            r1.append(r7)
            r1.append(r8)
            java.lang.String r7 = ".log"
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r0.<init>(r7)
            r7 = 0
            java.io.RandomAccessFile r8 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L92
            java.lang.String r1 = "rw"
            r8.<init>(r0, r1)     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L92
            long r0 = r8.length()     // Catch: java.lang.Exception -> L8b java.lang.Throwable -> L9d
            r8.seek(r0)     // Catch: java.lang.Exception -> L8b java.lang.Throwable -> L9d
            r8.write(r9)     // Catch: java.lang.Exception -> L8b java.lang.Throwable -> L9d
            java.lang.String r7 = "\n\n"
            r8.writeBytes(r7)     // Catch: java.lang.Exception -> L8b java.lang.Throwable -> L9d
            java.io.FileDescriptor r7 = r8.getFD()     // Catch: java.lang.Exception -> L8b java.lang.Throwable -> L9d
            r7.sync()     // Catch: java.lang.Exception -> L8b java.lang.Throwable -> L9d
        L87:
            r8.close()     // Catch: java.lang.Exception -> L9c
            goto L9c
        L8b:
            r7 = move-exception
            goto L96
        L8d:
            r8 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
            goto L9e
        L92:
            r8 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
        L96:
            r7.printStackTrace()     // Catch: java.lang.Throwable -> L9d
            if (r8 == 0) goto L9c
            goto L87
        L9c:
            return
        L9d:
            r7 = move-exception
        L9e:
            if (r8 == 0) goto La3
            r8.close()     // Catch: java.lang.Exception -> La3
        La3:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: b.d.b.d.a.h(java.lang.String, java.lang.String, byte[]):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String i(Context context, String str, String str2, long j, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(IStatEvent.CUSTOM_EVENT, "perf_caton");
            jSONObject.putOpt(IStatEvent.CUSTOM_MODULE, "perf");
            jSONObject.putOpt(IStatEvent.CUSTOM_DEVICE_MCUVER, b.d.b.d.h.a.a());
            jSONObject.putOpt(IStatEvent.CUSTOM_MODULE_VERSION, str2);
            jSONObject.putOpt(IStatEvent.CUSTOM_STARTUP, Long.valueOf(SystemClock.uptimeMillis() / 1000));
            jSONObject.putOpt(IStatEvent.CUSTOM_TIMESTAMP, Long.valueOf(System.currentTimeMillis()));
            jSONObject.putOpt(IStatEvent.CUSTOM_NETWORK, b.d.b.d.h.a.b(context));
            jSONObject.putOpt("appName", str);
            jSONObject.putOpt("appVer", str2);
            jSONObject.putOpt("anr", Boolean.FALSE);
            jSONObject.putOpt("elapseTime", Long.valueOf(j));
            jSONObject.putOpt("md5", str3);
            jSONObject.putOpt("stackInfo", str4);
            return jSONObject.toString();
        } catch (Throwable th) {
            Log.e("libBugHunter", "error in function getJsonCatonLog, " + th.getMessage());
            return "";
        }
    }

    private static PackageInfo j(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (str == null) {
                str = context.getPackageName();
            }
            return packageManager.getPackageInfo(str, 16384);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String k(Context context, String str) {
        PackageInfo j = j(context, str);
        return j == null ? "" : j.versionName;
    }

    public static void l(Context context) {
        m(context, false, true, false);
    }

    public static void m(Context context, boolean z, boolean z2, boolean z3) {
        try {
            n(context.getApplicationContext(), z, z2, z3);
            Module.register(b.d.a.a.class, new b.d.a.a(context));
            Module.get(b.d.a.a.class).get(IDataLog.class);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static void n(Context context, boolean z, boolean z2, boolean z3) {
        long j = 400;
        long j2 = 100;
        if (b.d.b.e.m.b.j()) {
            j = 60000;
            j2 = 1000;
        } else if (z || new File("/sdcard/Log/catonflag").exists()) {
            j = 100;
        } else {
            j2 = 400;
        }
        if (z3) {
            f1343a = true;
        } else if (new File("/sdcard/Log/catondumpflag").exists()) {
            f1343a = true;
        }
        b.d.b.d.g.b.a(new b.C0059b(context.getApplicationContext()).e(b.d.LOOPER).d(z2).c(j).f(j2).b(new C0054a(context)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String o(String str, Context context, String str2, String[] strArr, long j, long j2) {
        long j3;
        long j4;
        JSONObject jSONObject = new JSONObject();
        StringBuffer stringBuffer = new StringBuffer("");
        long j5 = 0;
        if (context != null) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
            long j6 = memoryInfo.availMem / 1048576;
            j4 = memoryInfo.totalMem / 1048576;
            j3 = memoryInfo.threshold / 1048576;
            stringBuffer.append("availMem:");
            stringBuffer.append(j6);
            stringBuffer.append("totalMem:");
            stringBuffer.append(j4);
            stringBuffer.append("threshold:");
            stringBuffer.append(j3);
            j5 = j6;
        } else {
            j3 = 0;
            j4 = 0;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\n----------------caton log [ ");
        if (!TextUtils.isEmpty(str2)) {
            sb.append(str2);
        }
        sb.append(" ]");
        for (int length = strArr.length - 1; length >= 0; length--) {
            String str3 = strArr[length];
            sb.append("\n");
            sb.append(str3);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
        try {
            jSONObject.put("md5", str);
            jSONObject.put("pkgName", str2);
            jSONObject.put("time", simpleDateFormat.format(Calendar.getInstance().getTime()));
            jSONObject.put("ElapseTime", j);
            jSONObject.put("threadElapseTime", j2);
            jSONObject.put("availMem", j5);
            jSONObject.put("totalMem", j4);
            jSONObject.put("threshold", j3);
            jSONObject.put("catonLog", sb.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        b.d.b.d.g.d.a("libBugHunter", jSONObject.toString());
        return stringBuffer.toString();
    }
}
