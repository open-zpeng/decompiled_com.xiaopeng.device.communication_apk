package b.c.a.b;

import b.c.a.c.c.c;
import b.c.a.c.c.e;
import b.c.a.c.c.f;
import b.c.a.c.c.g;
import b.c.a.k.d.d;
/* compiled from: CacheCall.java */
/* loaded from: classes.dex */
public class a<T> implements b<T> {

    /* renamed from: a  reason: collision with root package name */
    private b.c.a.c.c.b<T> f1167a;

    /* renamed from: b  reason: collision with root package name */
    private d<T, ? extends d> f1168b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CacheCall.java */
    /* renamed from: b.c.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0042a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1169a;

        static {
            int[] iArr = new int[b.c.a.c.b.values().length];
            f1169a = iArr;
            try {
                iArr[b.c.a.c.b.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1169a[b.c.a.c.b.NO_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1169a[b.c.a.c.b.IF_NONE_CACHE_REQUEST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1169a[b.c.a.c.b.FIRST_CACHE_THEN_REQUEST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1169a[b.c.a.c.b.REQUEST_FAILED_READ_CACHE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public a(d<T, ? extends d> dVar) {
        this.f1167a = null;
        this.f1168b = dVar;
        this.f1167a = c();
    }

    private b.c.a.c.c.b<T> c() {
        int i = C0042a.f1169a[this.f1168b.j().ordinal()];
        if (i == 1) {
            this.f1167a = new c(this.f1168b);
        } else if (i == 2) {
            this.f1167a = new e(this.f1168b);
        } else if (i == 3) {
            this.f1167a = new f(this.f1168b);
        } else if (i == 4) {
            this.f1167a = new b.c.a.c.c.d(this.f1168b);
        } else if (i == 5) {
            this.f1167a = new g(this.f1168b);
        }
        if (this.f1168b.k() != null) {
            this.f1167a = this.f1168b.k();
        }
        b.c.a.l.b.b(this.f1167a, "policy == null");
        return this.f1167a;
    }

    @Override // b.c.a.b.b
    public void a(b.c.a.d.b<T> bVar) {
        b.c.a.l.b.b(bVar, "callback == null");
        this.f1167a.b(this.f1167a.a(), bVar);
    }

    /* renamed from: b */
    public b<T> clone() {
        return new a(this.f1168b);
    }
}
