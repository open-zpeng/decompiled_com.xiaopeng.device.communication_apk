package b.c.a;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import b.c.a.h.a;
import b.c.a.i.a;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import okhttp3.Call;
import okhttp3.OkHttpClient;
/* compiled from: OkGo.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static long f1162a = 300;

    /* renamed from: b  reason: collision with root package name */
    private Application f1163b;

    /* renamed from: c  reason: collision with root package name */
    private Handler f1164c;

    /* renamed from: d  reason: collision with root package name */
    private OkHttpClient f1165d;
    private b.c.a.j.b e;
    private b.c.a.j.a f;
    private int g;
    private b.c.a.c.b h;
    private long i;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: OkGo.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private static a f1166a = new a();
    }

    public static a h() {
        return b.f1166a;
    }

    public void a(Object obj) {
        if (obj == null) {
            return;
        }
        for (Call call : i().dispatcher().queuedCalls()) {
            if (obj.equals(call.request().tag())) {
                call.cancel();
            }
        }
        for (Call call2 : i().dispatcher().runningCalls()) {
            if (obj.equals(call2.request().tag())) {
                call2.cancel();
            }
        }
    }

    public b.c.a.c.b b() {
        return this.h;
    }

    public long c() {
        return this.i;
    }

    public b.c.a.j.a d() {
        return this.f;
    }

    public b.c.a.j.b e() {
        return this.e;
    }

    public Context f() {
        b.c.a.l.b.b(this.f1163b, "please call OkGo.getInstance().init() first in application!");
        return this.f1163b;
    }

    public Handler g() {
        return this.f1164c;
    }

    public OkHttpClient i() {
        b.c.a.l.b.b(this.f1165d, "please call OkGo.getInstance().setOkHttpClient() first in application!");
        return this.f1165d;
    }

    public int j() {
        return this.g;
    }

    public a k(Application application) {
        this.f1163b = application;
        return this;
    }

    public a l(OkHttpClient okHttpClient) {
        b.c.a.l.b.b(okHttpClient, "okHttpClient == null");
        this.f1165d = okHttpClient;
        return this;
    }

    public a m(int i) {
        if (i >= 0) {
            this.g = i;
            return this;
        }
        throw new IllegalArgumentException("retryCount must > 0");
    }

    private a() {
        this.f1164c = new Handler(Looper.getMainLooper());
        this.g = 3;
        this.i = -1L;
        this.h = b.c.a.c.b.NO_CACHE;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        b.c.a.i.a aVar = new b.c.a.i.a("OkGo");
        aVar.h(a.EnumC0047a.BODY);
        aVar.g(Level.INFO);
        builder.addInterceptor(aVar);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        builder.readTimeout(60000L, timeUnit);
        builder.writeTimeout(60000L, timeUnit);
        builder.connectTimeout(60000L, timeUnit);
        a.c b2 = b.c.a.h.a.b();
        builder.sslSocketFactory(b2.f1229a, b2.f1230b);
        builder.hostnameVerifier(b.c.a.h.a.f1228b);
        this.f1165d = builder.build();
    }
}
