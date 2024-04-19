package b.d.a.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import b.d.b.e.c;
import b.d.b.e.i;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.ICounter;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEvent;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* compiled from: CounterImpl.java */
/* loaded from: classes.dex */
public class b implements ICounter, Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    private final String f1283a;

    /* renamed from: b  reason: collision with root package name */
    private final long f1284b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, AtomicInteger> f1285c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1286d;
    private AtomicLong e;
    private Handler f;
    private final SharedPreferences g;
    private final SharedPreferences.Editor h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CounterImpl.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Map f1287a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f1288b;

        a(Map map, long j) {
            this.f1287a = map;
            this.f1288b = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.l("CounterImpl", "[" + b.this.f1283a + " counter] send count event, name:" + b.this.f1283a + " values:" + this.f1287a);
            IDataLog iDataLog = (IDataLog) Module.get(b.d.a.a.class).get(IDataLog.class);
            IMoleEventBuilder event = iDataLog.buildMoleEvent().setPageId("P00012").setButtonId("B001").setEvent(b.this.f1283a);
            for (String str : this.f1287a.keySet()) {
                event.setProperty(str, (Number) this.f1287a.get(str));
            }
            event.setProperty("time", Long.valueOf(this.f1288b));
            IMoleEvent build = event.build();
            c.a("CounterImpl", "start sendStatData:" + build.toJson());
            iDataLog.sendStatData(build);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            this.f1283a = str;
            this.f1284b = j;
            this.f1285c = new HashMap();
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            this.g = defaultSharedPreferences;
            this.h = defaultSharedPreferences.edit();
            this.e = new AtomicLong(defaultSharedPreferences.getLong(c("time"), System.currentTimeMillis()));
            this.f = new Handler(i.g(0), this);
            d();
            e(false);
            return;
        }
        throw new IllegalArgumentException("name can't be empty!");
    }

    private String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = this.f1283a + "_";
        if (str.startsWith(str2)) {
            return str.substring(str2.length());
        }
        return null;
    }

    private String c(String str) {
        return this.f1283a + "_" + str;
    }

    private void d() {
        Map<String, ?> all = this.g.getAll();
        c.a("CounterImpl", "initValuesFromPref prefMap:" + all);
        for (String str : all.keySet()) {
            String b2 = b(str);
            if (!TextUtils.isEmpty(b2) && !b2.equals("time")) {
                Object obj = all.get(str);
                if (obj instanceof Integer) {
                    c.a("CounterImpl", "initValuesFromPref key:" + b2 + " value:" + obj);
                    this.f1285c.put(b2, new AtomicInteger(((Integer) obj).intValue()));
                }
            }
        }
    }

    private void e(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.e.get();
        long j2 = this.f1284b;
        if (j / j2 < currentTimeMillis / j2 || z) {
            HashMap hashMap = new HashMap();
            for (String str : this.f1285c.keySet()) {
                AtomicInteger atomicInteger = this.f1285c.get(str);
                hashMap.put(str, Integer.valueOf(atomicInteger.get()));
                atomicInteger.set(0);
                this.h.putInt(c(str), 0);
            }
            i.h(2, new a(hashMap, j));
            if (!this.f.hasMessages(1)) {
                this.f.sendEmptyMessageDelayed(1, 10000L);
            }
        }
        this.e.set(currentTimeMillis);
        this.h.putLong(c("time"), currentTimeMillis);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.ICounter
    public synchronized int count(String str) {
        return count(str, 1);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.ICounter
    public void debug(boolean z) {
        this.f1286d = z;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            if (this.f1286d) {
                c.a("CounterImpl", "mEditor.apply()");
            }
            this.h.apply();
        }
        return true;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.ICounter
    public synchronized int count(String str, int i) {
        int i2;
        int i3;
        AtomicInteger atomicInteger = this.f1285c.get(str);
        String c2 = c(str);
        if (atomicInteger == null) {
            try {
                i2 = this.g.getInt(c2, 0);
            } catch (ClassCastException e) {
                c.u("CounterImpl", "mPreferences.getInt(" + c2 + ") error!", e);
                i2 = 0;
            }
            if (this.f1286d) {
                c.s("CounterImpl", "count " + this.f1283a + ", load key:" + c2 + " from pref, value is " + i2);
            }
            AtomicInteger atomicInteger2 = new AtomicInteger(i2);
            this.f1285c.put(str, atomicInteger2);
            atomicInteger = atomicInteger2;
        }
        i3 = atomicInteger.get() + i;
        atomicInteger.set(i3);
        this.h.putInt(c2, i3);
        if (this.f1286d) {
            c.s("CounterImpl", "count " + this.f1283a + " " + str + ":" + i3 + ", cache is:" + this.f1285c);
        }
        if (!this.f.hasMessages(1)) {
            this.f.sendEmptyMessageDelayed(1, 10000L);
        }
        e(i3 == Integer.MAX_VALUE);
        return i3;
    }
}
