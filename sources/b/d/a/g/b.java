package b.d.a.g;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.os.UserHandle;
import b.d.b.d.b;
import b.d.b.e.g;
import b.d.b.e.i;
import b.d.b.e.j;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.xiaopeng.datalog.bean.LogEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.eclipse.paho.client.mqttv3.MqttTopic;
/* compiled from: DataCollectorHelper.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f1302a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f1303b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f1304c;

    /* renamed from: d  reason: collision with root package name */
    private b.d.b.d.b f1305d;
    private Context e;
    private final List<String> f = new CopyOnWriteArrayList();
    private final List<Map<String, Object>> g = new CopyOnWriteArrayList();
    private Gson h = new Gson();
    private Handler i = new Handler(i.g(0), new a());
    private ServiceConnection j = new ServiceConnectionC0053b();

    /* compiled from: DataCollectorHelper.java */
    /* loaded from: classes.dex */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                b.d.b.e.c.s("DataCollectorHelper", "handleMessage MESSAGE_DUMP_CAN");
                b.this.k();
            } else if (i == 2) {
                b.d.b.e.c.a("DataCollectorHelper", "handleMessage MESSAGE_DUMP_CDU");
                b.this.l();
            } else if (i == 3) {
                b.d.b.e.c.a("DataCollectorHelper", "handleMessage MESSAGE_CHECK_CONNECTION");
                if (b.this.f1305d == null) {
                    b.this.g();
                }
            }
            return true;
        }
    }

    /* compiled from: DataCollectorHelper.java */
    /* renamed from: b.d.a.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class ServiceConnectionC0053b implements ServiceConnection {

        /* compiled from: DataCollectorHelper.java */
        /* renamed from: b.d.a.g.b$b$a */
        /* loaded from: classes.dex */
        class a implements IBinder.DeathRecipient {
            a() {
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                if (b.this.f1305d == null) {
                    return;
                }
                b.this.f1305d.asBinder().unlinkToDeath(this, 0);
                b.this.f1305d = null;
                b.this.g();
            }
        }

        ServiceConnectionC0053b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            b.d.b.e.c.a("DataCollectorHelper", "onServiceConnected");
            b.this.f1305d = b.a.Y(iBinder);
            a aVar = new a();
            try {
                if (b.this.f1305d == null) {
                    return;
                }
                b.this.f1305d.asBinder().linkToDeath(aVar, 0);
            } catch (RemoteException e) {
                b.d.b.e.c.u("DataCollectorHelper", "RemoteException occurs when reLink to Service, exception:", e);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            b.d.b.e.c.a("DataCollectorHelper", "onServiceDisconnected");
            b.this.f1305d = null;
            b.this.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DataCollectorHelper.java */
    /* loaded from: classes.dex */
    public class c extends TypeToken<Map<String, Object>> {
        c() {
        }
    }

    /* compiled from: DataCollectorHelper.java */
    /* loaded from: classes.dex */
    class d extends TypeToken<Map<String, Object>> {
        d() {
        }
    }

    /* compiled from: DataCollectorHelper.java */
    /* loaded from: classes.dex */
    class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String[] f1311a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f1312b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ b.d.a.d f1313c;

        e(String[] strArr, List list, b.d.a.d dVar) {
            this.f1311a = strArr;
            this.f1312b = list;
            this.f1313c = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.B(this.f1311a[1], this.f1312b);
            this.f1313c.put("address", this.f1311a[0]);
            String json = this.f1313c.toJson();
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f1311a[1].replace(".zip", "_en.zip"));
            b.this.u(json);
            b.this.x(arrayList);
        }
    }

    /* compiled from: DataCollectorHelper.java */
    /* loaded from: classes.dex */
    class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f1315a;

        /* compiled from: DataCollectorHelper.java */
        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = f.this;
                b.this.r(fVar.f1315a);
            }
        }

        f(String str) {
            this.f1315a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.s()) {
                b.this.r(this.f1315a);
            } else {
                i.j(new a(), 1000L);
            }
        }
    }

    static {
        String str = b.d.b.e.m.b.h() ? "xp-log-local" : "xp-log";
        f1303b = str;
        f1304c = "http://" + str + ".oss-cn-hangzhou.aliyuncs.com/";
    }

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(String str, List<String> list) {
        File file;
        try {
            file = j.d(str, list);
        } catch (IOException e2) {
            e2.printStackTrace();
            file = null;
        }
        j(file, b.d.b.e.l.a.c(file, new File(str.replace(".zip", "_en.zip")), "@!chxpzi#0109$+/"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        Intent intent = new Intent("com.xiaopeng.service.DATA_SERVICE");
        intent.setPackage("com.xiaopeng.data.uploader");
        this.e.startServiceAsUser(intent, UserHandle.CURRENT);
        this.e.bindServiceAsUser(intent, this.j, 1, UserHandle.CURRENT);
        if (this.i.hasMessages(3)) {
            return;
        }
        this.i.sendEmptyMessageDelayed(3, 10000L);
    }

    private String h() {
        LogEvent create = LogEvent.create(LogEvent.a.CAN);
        try {
            create.setV(Integer.valueOf(g.b()).intValue());
        } catch (Exception e2) {
            b.d.b.e.c.u("DataCollectorHelper", "parse dbcVersion error!", e2);
            create.setV(0);
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("data", this.h.toJson(this.f));
        this.f.clear();
        ArrayList arrayList = new ArrayList();
        arrayList.add(jsonObject);
        create.setMsg(arrayList);
        String json = this.h.toJson(create);
        arrayList.clear();
        return json;
    }

    private String i() {
        LogEvent create = LogEvent.create(LogEvent.a.CDU);
        try {
            create.setV(Integer.valueOf(g.b()).intValue());
        } catch (Exception e2) {
            b.d.b.e.c.u("DataCollectorHelper", "parse dbcVersion error!", e2);
            create.setV(0);
        }
        ArrayList arrayList = new ArrayList(this.g);
        this.g.clear();
        create.setMsg(arrayList);
        return this.h.toJson(create);
    }

    private void j(File file, boolean z) {
        if (z) {
            try {
                file.delete();
                System.gc();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.f.isEmpty()) {
            b.d.b.e.c.a("DataCollectorHelper", "mCanDataCache.isEmpty(), return!");
            return;
        }
        b.d.a.f.a.h().n("candata", j.b(h()), this.e);
        this.i.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.g.isEmpty()) {
            b.d.b.e.c.a("DataCollectorHelper", "mCduDataCache.isEmpty(), return!");
        }
        b.d.a.f.a.h().n("cdudata", j.b(i()), this.e);
        this.i.removeMessages(2);
    }

    private String m(long j, String str) {
        String str2 = "/sdcard/Log/upload-zip/" + str;
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str2 + MqttTopic.TOPIC_LEVEL_SEPARATOR + j + ".zip";
    }

    private String n(long j, String str) {
        return f1304c + (str.substring(str.indexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR) + 1) + MqttTopic.TOPIC_LEVEL_SEPARATOR + j + "_en.zip");
    }

    private String[] o() {
        long currentTimeMillis = System.currentTimeMillis();
        String str = f1303b + "/log/" + b.d.b.e.m.b.e() + MqttTopic.TOPIC_LEVEL_SEPARATOR + b.d.b.e.a.c(currentTimeMillis) + MqttTopic.TOPIC_LEVEL_SEPARATOR + g.g();
        return new String[]{n(currentTimeMillis, str), m(currentTimeMillis, str)};
    }

    public static b p() {
        if (f1302a == null) {
            synchronized (b.class) {
                if (f1302a == null) {
                    f1302a = new b();
                }
            }
        }
        return f1302a;
    }

    private void v(Map<String, Object> map) {
        this.g.add(map);
        if (this.g.size() >= 20) {
            l();
        } else if (this.i.hasMessages(2)) {
        } else {
            this.i.sendEmptyMessageDelayed(2, 60000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String A() {
        String str = o()[0];
        i.i(new f(str));
        return str;
    }

    public void q(Context context) {
        this.e = context;
        g();
    }

    void r(String str) {
        b.d.b.d.b bVar = this.f1305d;
        if (bVar != null) {
            try {
                bVar.R(str);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean s() {
        return this.f1305d != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void t(java.lang.String r5) {
        /*
            r4 = this;
            b.d.b.d.b r0 = r4.f1305d
            r1 = 1
            if (r0 == 0) goto L19
            r0.h(r5)     // Catch: android.os.RemoteException -> L15
            java.util.List<java.lang.String> r0 = r4.f     // Catch: android.os.RemoteException -> L15
            int r0 = r0.size()     // Catch: android.os.RemoteException -> L15
            if (r0 <= 0) goto L13
            r4.k()     // Catch: android.os.RemoteException -> L15
        L13:
            r0 = r1
            goto L1a
        L15:
            r0 = move-exception
            r0.printStackTrace()
        L19:
            r0 = 0
        L1a:
            if (r0 != 0) goto L3f
            java.util.List<java.lang.String> r0 = r4.f
            r0.add(r5)
            java.util.List<java.lang.String> r5 = r4.f
            int r5 = r5.size()
            r0 = 20
            if (r5 < r0) goto L2f
            r4.k()
            goto L3f
        L2f:
            android.os.Handler r5 = r4.i
            boolean r5 = r5.hasMessages(r1)
            if (r5 != 0) goto L3f
            android.os.Handler r5 = r4.i
            r2 = 60000(0xea60, double:2.9644E-319)
            r5.sendEmptyMessageDelayed(r1, r2)
        L3f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b.d.a.g.b.t(java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void u(java.lang.String r4) {
        /*
            r3 = this;
            b.d.b.d.b r0 = r3.f1305d
            if (r0 == 0) goto L1c
            r0.s(r4)     // Catch: android.os.RemoteException -> L14
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> r0 = r3.g     // Catch: android.os.RemoteException -> L14
            int r0 = r0.size()     // Catch: android.os.RemoteException -> L14
            if (r0 <= 0) goto L12
            r3.l()     // Catch: android.os.RemoteException -> L14
        L12:
            r0 = 1
            goto L1d
        L14:
            r0 = move-exception
            java.lang.String r1 = "DataCollectorHelper"
            java.lang.String r2 = "uploadCdu error!"
            b.d.b.e.c.u(r1, r2, r0)
        L1c:
            r0 = 0
        L1d:
            if (r0 != 0) goto L33
            com.google.gson.Gson r0 = r3.h
            b.d.a.g.b$c r1 = new b.d.a.g.b$c
            r1.<init>()
            java.lang.reflect.Type r1 = r1.getType()
            java.lang.Object r4 = r0.fromJson(r4, r1)
            java.util.Map r4 = (java.util.Map) r4
            r3.v(r4)
        L33:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b.d.a.g.b.u(java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(b.d.a.d dVar, List<String> list) {
        i.i(new e(o(), list, dVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(List<String> list) {
        b.d.b.d.b bVar = this.f1305d;
        if (bVar != null) {
            try {
                bVar.P(list);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0014  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void y(java.lang.String r3, java.lang.String r4) {
        /*
            r2 = this;
            b.d.b.d.b r0 = r2.f1305d
            java.lang.String r1 = "DataCollectorHelper"
            if (r0 == 0) goto L11
            r0.k(r3, r4)     // Catch: android.os.RemoteException -> Lb
            r3 = 1
            goto L12
        Lb:
            r3 = move-exception
            java.lang.String r4 = "uploadLogImmediately error!"
            b.d.b.e.c.u(r1, r4, r3)
        L11:
            r3 = 0
        L12:
            if (r3 != 0) goto L19
            java.lang.String r3 = "uploadLogImmediately fail and ignore!"
            b.d.b.e.c.t(r1, r3)
        L19:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b.d.a.g.b.y(java.lang.String, java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void z(java.lang.String r3, java.lang.String r4) {
        /*
            r2 = this;
            b.d.b.d.b r0 = r2.f1305d
            if (r0 == 0) goto L18
            r0.f(r3, r4)     // Catch: android.os.RemoteException -> L14
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> r0 = r2.g     // Catch: android.os.RemoteException -> L14
            int r0 = r0.size()     // Catch: android.os.RemoteException -> L14
            if (r0 <= 0) goto L12
            r2.l()     // Catch: android.os.RemoteException -> L14
        L12:
            r0 = 1
            goto L19
        L14:
            r0 = move-exception
            r0.printStackTrace()
        L18:
            r0 = 0
        L19:
            if (r0 != 0) goto L53
            java.lang.Class<b.d.a.a> r0 = b.d.a.a.class
            com.xiaopeng.lib.framework.module.IModuleEntry r0 = com.xiaopeng.lib.framework.module.Module.get(r0)
            java.lang.Class<com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog> r1 = com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog.class
            java.lang.Object r0 = r0.get(r1)
            com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog r0 = (com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog) r0
            com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEventBuilder r0 = r0.buildStat()
            com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEventBuilder r3 = r0.setEventName(r3)
            java.lang.String r0 = "data"
            com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEventBuilder r3 = r3.setProperty(r0, r4)
            com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEvent r3 = r3.build()
            java.lang.String r3 = r3.toJson()
            com.google.gson.Gson r4 = r2.h
            b.d.a.g.b$d r0 = new b.d.a.g.b$d
            r0.<init>()
            java.lang.reflect.Type r0 = r0.getType()
            java.lang.Object r3 = r4.fromJson(r3, r0)
            java.util.Map r3 = (java.util.Map) r3
            r2.v(r3)
        L53:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b.d.a.g.b.z(java.lang.String, java.lang.String):void");
    }
}
