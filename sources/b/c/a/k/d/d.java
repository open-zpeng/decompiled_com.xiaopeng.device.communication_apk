package b.c.a.k.d;

import android.text.TextUtils;
import b.c.a.k.d.c;
import b.c.a.k.d.d;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
/* compiled from: Request.java */
/* loaded from: classes.dex */
public abstract class d<T, R extends d> implements Serializable {
    private static final long serialVersionUID = -7174118653689916252L;

    /* renamed from: a  reason: collision with root package name */
    protected String f1263a;

    /* renamed from: b  reason: collision with root package name */
    protected String f1264b;

    /* renamed from: c  reason: collision with root package name */
    protected transient OkHttpClient f1265c;

    /* renamed from: d  reason: collision with root package name */
    protected transient Object f1266d;
    protected int e;
    protected b.c.a.c.b f;
    protected String g;
    protected long h;
    protected b.c.a.j.b i = new b.c.a.j.b();
    protected b.c.a.j.a j = new b.c.a.j.a();
    protected transient Request k;
    protected transient b.c.a.b.b<T> l;
    protected transient b.c.a.d.b<T> m;
    protected transient b.c.a.e.a<T> n;
    protected transient b.c.a.c.c.b<T> o;
    protected transient c.InterfaceC0048c p;

    public d(String str) {
        this.f1263a = str;
        this.f1264b = str;
        b.c.a.a h = b.c.a.a.h();
        String d2 = b.c.a.j.a.d();
        if (!TextUtils.isEmpty(d2)) {
            u("Accept-Language", d2);
        }
        String i = b.c.a.j.a.i();
        if (!TextUtils.isEmpty(i)) {
            u(HttpHeaders.USER_AGENT, i);
        }
        if (h.e() != null) {
            v(h.e());
        }
        if (h.d() != null) {
            t(h.d());
        }
        this.e = h.j();
        this.f = h.b();
        this.h = h.c();
    }

    public R A(Map<String, String> map, boolean... zArr) {
        this.i.l(map, zArr);
        return this;
    }

    public R B() {
        this.j.a();
        return this;
    }

    public R C() {
        this.i.a();
        return this;
    }

    public R D(String str) {
        this.j.n(str);
        return this;
    }

    public R E(String str) {
        this.i.m(str);
        return this;
    }

    public R F(Object obj) {
        this.f1266d = obj;
        return this;
    }

    public b.c.a.b.b<T> a() {
        b.c.a.b.b<T> bVar = this.l;
        return bVar == null ? new b.c.a.b.a(this) : bVar;
    }

    public R b(String str) {
        b.c.a.l.b.b(str, "cacheKey == null");
        this.g = str;
        return this;
    }

    public R c(b.c.a.c.b bVar) {
        this.f = bVar;
        return this;
    }

    public Response d() throws IOException {
        return p().execute();
    }

    public void e(b.c.a.d.b<T> bVar) {
        b.c.a.l.b.b(bVar, "callback == null");
        this.m = bVar;
        a().a(bVar);
    }

    public abstract Request f(RequestBody requestBody);

    protected abstract RequestBody g();

    public String h() {
        return this.f1264b;
    }

    public String i() {
        return this.g;
    }

    public b.c.a.c.b j() {
        return this.f;
    }

    public b.c.a.c.c.b<T> k() {
        return this.o;
    }

    public long l() {
        return this.h;
    }

    public b.c.a.e.a<T> m() {
        if (this.n == null) {
            this.n = this.m;
        }
        b.c.a.l.b.b(this.n, "converter == null, do you forget to call Request#converter(Converter<T>) ?");
        return this.n;
    }

    public b.c.a.j.a n() {
        return this.j;
    }

    public b.c.a.j.b o() {
        return this.i;
    }

    public Call p() {
        RequestBody g = g();
        if (g != null) {
            c cVar = new c(g, this.m);
            cVar.e(this.p);
            this.k = f(cVar);
        } else {
            this.k = f(null);
        }
        if (this.f1265c == null) {
            this.f1265c = b.c.a.a.h().i();
        }
        return this.f1265c.newCall(this.k);
    }

    public Request q() {
        return this.k;
    }

    public int r() {
        return this.e;
    }

    public String s() {
        return this.f1263a;
    }

    public R t(b.c.a.j.a aVar) {
        this.j.l(aVar);
        return this;
    }

    public R u(String str, String str2) {
        this.j.m(str, str2);
        return this;
    }

    public R v(b.c.a.j.b bVar) {
        this.i.c(bVar);
        return this;
    }

    public R w(String str, float f, boolean... zArr) {
        this.i.d(str, f, zArr);
        return this;
    }

    public R x(String str, int i, boolean... zArr) {
        this.i.e(str, i, zArr);
        return this;
    }

    public R y(String str, String str2, boolean... zArr) {
        this.i.j(str, str2, zArr);
        return this;
    }

    public R z(String str, boolean z, boolean... zArr) {
        this.i.k(str, z, zArr);
        return this;
    }
}
