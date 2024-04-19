package b.c.a.j;

import okhttp3.Call;
import okhttp3.Response;
/* compiled from: Response.java */
/* loaded from: classes.dex */
public final class d<T> {

    /* renamed from: a  reason: collision with root package name */
    private T f1251a;

    /* renamed from: b  reason: collision with root package name */
    private Throwable f1252b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f1253c;

    /* renamed from: d  reason: collision with root package name */
    private Call f1254d;
    private Response e;

    public static <T> d<T> c(boolean z, Call call, Response response, Throwable th) {
        d<T> dVar = new d<>();
        dVar.j(z);
        dVar.k(call);
        dVar.l(response);
        dVar.i(th);
        return dVar;
    }

    public static <T> d<T> m(boolean z, T t, Call call, Response response) {
        d<T> dVar = new d<>();
        dVar.j(z);
        dVar.h(t);
        dVar.k(call);
        dVar.l(response);
        return dVar;
    }

    public T a() {
        return this.f1251a;
    }

    public int b() {
        Response response = this.e;
        if (response == null) {
            return -1;
        }
        return response.code();
    }

    public Throwable d() {
        return this.f1252b;
    }

    public Call e() {
        return this.f1254d;
    }

    public Response f() {
        return this.e;
    }

    public String g() {
        Response response = this.e;
        if (response == null) {
            return null;
        }
        return response.message();
    }

    public void h(T t) {
        this.f1251a = t;
    }

    public void i(Throwable th) {
        this.f1252b = th;
    }

    public void j(boolean z) {
        this.f1253c = z;
    }

    public void k(Call call) {
        this.f1254d = call;
    }

    public void l(Response response) {
        this.e = response;
    }
}
