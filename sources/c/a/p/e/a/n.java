package c.a.p.e.a;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ObservableRefCount.java */
/* loaded from: classes.dex */
public final class n<T> extends c.a.e<T> {

    /* renamed from: a  reason: collision with root package name */
    final c.a.q.a<T> f1692a;

    /* renamed from: b  reason: collision with root package name */
    final int f1693b;

    /* renamed from: c  reason: collision with root package name */
    final long f1694c;

    /* renamed from: d  reason: collision with root package name */
    final TimeUnit f1695d;
    final c.a.j e;
    a f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableRefCount.java */
    /* loaded from: classes.dex */
    public static final class a extends AtomicReference<c.a.m.b> implements Runnable, c.a.o.e<c.a.m.b> {
        private static final long serialVersionUID = -4552101107598366241L;

        /* renamed from: a  reason: collision with root package name */
        final n<?> f1696a;

        /* renamed from: b  reason: collision with root package name */
        c.a.m.b f1697b;

        /* renamed from: c  reason: collision with root package name */
        long f1698c;

        /* renamed from: d  reason: collision with root package name */
        boolean f1699d;

        a(n<?> nVar) {
            this.f1696a = nVar;
        }

        @Override // c.a.o.e
        /* renamed from: a */
        public void accept(c.a.m.b bVar) throws Exception {
            c.a.p.a.c.replace(this, bVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1696a.E(this);
        }
    }

    /* compiled from: ObservableRefCount.java */
    /* loaded from: classes.dex */
    static final class b<T> extends AtomicBoolean implements c.a.i<T>, c.a.m.b {
        private static final long serialVersionUID = -7419642935409022375L;

        /* renamed from: a  reason: collision with root package name */
        final c.a.i<? super T> f1700a;

        /* renamed from: b  reason: collision with root package name */
        final n<T> f1701b;

        /* renamed from: c  reason: collision with root package name */
        final a f1702c;

        /* renamed from: d  reason: collision with root package name */
        c.a.m.b f1703d;

        b(c.a.i<? super T> iVar, n<T> nVar, a aVar) {
            this.f1700a = iVar;
            this.f1701b = nVar;
            this.f1702c = aVar;
        }

        @Override // c.a.m.b
        public void dispose() {
            this.f1703d.dispose();
            if (compareAndSet(false, true)) {
                this.f1701b.C(this.f1702c);
            }
        }

        @Override // c.a.i
        public void onComplete() {
            if (compareAndSet(false, true)) {
                this.f1701b.D(this.f1702c);
                this.f1700a.onComplete();
            }
        }

        @Override // c.a.i
        public void onError(Throwable th) {
            if (compareAndSet(false, true)) {
                this.f1701b.D(this.f1702c);
                this.f1700a.onError(th);
                return;
            }
            c.a.s.a.m(th);
        }

        @Override // c.a.i
        public void onNext(T t) {
            this.f1700a.onNext(t);
        }

        @Override // c.a.i
        public void onSubscribe(c.a.m.b bVar) {
            if (c.a.p.a.c.validate(this.f1703d, bVar)) {
                this.f1703d = bVar;
                this.f1700a.onSubscribe(this);
            }
        }
    }

    public n(c.a.q.a<T> aVar) {
        this(aVar, 1, 0L, TimeUnit.NANOSECONDS, c.a.t.a.c());
    }

    void C(a aVar) {
        synchronized (this) {
            if (this.f == null) {
                return;
            }
            long j = aVar.f1698c - 1;
            aVar.f1698c = j;
            if (j == 0 && aVar.f1699d) {
                if (this.f1694c == 0) {
                    E(aVar);
                    return;
                }
                c.a.p.a.f fVar = new c.a.p.a.f();
                aVar.f1697b = fVar;
                fVar.b(this.e.c(aVar, this.f1694c, this.f1695d));
            }
        }
    }

    void D(a aVar) {
        synchronized (this) {
            if (this.f != null) {
                this.f = null;
                c.a.m.b bVar = aVar.f1697b;
                if (bVar != null) {
                    bVar.dispose();
                }
                c.a.q.a<T> aVar2 = this.f1692a;
                if (aVar2 instanceof c.a.m.b) {
                    ((c.a.m.b) aVar2).dispose();
                }
            }
        }
    }

    void E(a aVar) {
        synchronized (this) {
            if (aVar.f1698c == 0 && aVar == this.f) {
                this.f = null;
                c.a.p.a.c.dispose(aVar);
                c.a.q.a<T> aVar2 = this.f1692a;
                if (aVar2 instanceof c.a.m.b) {
                    ((c.a.m.b) aVar2).dispose();
                }
            }
        }
    }

    @Override // c.a.e
    protected void w(c.a.i<? super T> iVar) {
        a aVar;
        boolean z;
        c.a.m.b bVar;
        synchronized (this) {
            aVar = this.f;
            if (aVar == null) {
                aVar = new a(this);
                this.f = aVar;
            }
            long j = aVar.f1698c;
            if (j == 0 && (bVar = aVar.f1697b) != null) {
                bVar.dispose();
            }
            long j2 = j + 1;
            aVar.f1698c = j2;
            z = true;
            if (aVar.f1699d || j2 != this.f1693b) {
                z = false;
            } else {
                aVar.f1699d = true;
            }
        }
        this.f1692a.a(new b(iVar, this, aVar));
        if (z) {
            this.f1692a.C(aVar);
        }
    }

    public n(c.a.q.a<T> aVar, int i, long j, TimeUnit timeUnit, c.a.j jVar) {
        this.f1692a = aVar;
        this.f1693b = i;
        this.f1694c = j;
        this.f1695d = timeUnit;
        this.e = jVar;
    }
}
