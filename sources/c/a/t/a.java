package c.a.t;

import c.a.j;
import c.a.p.g.k;
import java.util.concurrent.Callable;
/* compiled from: Schedulers.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    static final j f1824a = c.a.s.a.h(new h());

    /* renamed from: b  reason: collision with root package name */
    static final j f1825b = c.a.s.a.e(new b());

    /* renamed from: c  reason: collision with root package name */
    static final j f1826c = c.a.s.a.f(new c());

    /* renamed from: d  reason: collision with root package name */
    static final j f1827d = k.d();
    static final j e = c.a.s.a.g(new f());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Schedulers.java */
    /* renamed from: c.a.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0069a {

        /* renamed from: a  reason: collision with root package name */
        static final j f1828a = new c.a.p.g.b();
    }

    /* compiled from: Schedulers.java */
    /* loaded from: classes.dex */
    static final class b implements Callable<j> {
        b() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public j call() throws Exception {
            return C0069a.f1828a;
        }
    }

    /* compiled from: Schedulers.java */
    /* loaded from: classes.dex */
    static final class c implements Callable<j> {
        c() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public j call() throws Exception {
            return d.f1829a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Schedulers.java */
    /* loaded from: classes.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        static final j f1829a = new c.a.p.g.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Schedulers.java */
    /* loaded from: classes.dex */
    public static final class e {

        /* renamed from: a  reason: collision with root package name */
        static final j f1830a = new c.a.p.g.d();
    }

    /* compiled from: Schedulers.java */
    /* loaded from: classes.dex */
    static final class f implements Callable<j> {
        f() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public j call() throws Exception {
            return e.f1830a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Schedulers.java */
    /* loaded from: classes.dex */
    public static final class g {

        /* renamed from: a  reason: collision with root package name */
        static final j f1831a = new c.a.p.g.j();
    }

    /* compiled from: Schedulers.java */
    /* loaded from: classes.dex */
    static final class h implements Callable<j> {
        h() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public j call() throws Exception {
            return g.f1831a;
        }
    }

    public static j a() {
        return c.a.s.a.l(f1825b);
    }

    public static j b() {
        return c.a.s.a.n(f1826c);
    }

    public static j c() {
        return f1827d;
    }
}
