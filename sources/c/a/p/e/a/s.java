package c.a.p.e.a;

import c.a.j;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ObservableTimeoutTimed.java */
/* loaded from: classes.dex */
public final class s<T> extends c.a.p.e.a.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f1722b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f1723c;

    /* renamed from: d  reason: collision with root package name */
    final c.a.j f1724d;
    final c.a.h<? extends T> e;

    /* compiled from: ObservableTimeoutTimed.java */
    /* loaded from: classes.dex */
    static final class a<T> implements c.a.i<T> {

        /* renamed from: a  reason: collision with root package name */
        final c.a.i<? super T> f1725a;

        /* renamed from: b  reason: collision with root package name */
        final AtomicReference<c.a.m.b> f1726b;

        a(c.a.i<? super T> iVar, AtomicReference<c.a.m.b> atomicReference) {
            this.f1725a = iVar;
            this.f1726b = atomicReference;
        }

        @Override // c.a.i
        public void onComplete() {
            this.f1725a.onComplete();
        }

        @Override // c.a.i
        public void onError(Throwable th) {
            this.f1725a.onError(th);
        }

        @Override // c.a.i
        public void onNext(T t) {
            this.f1725a.onNext(t);
        }

        @Override // c.a.i
        public void onSubscribe(c.a.m.b bVar) {
            c.a.p.a.c.replace(this.f1726b, bVar);
        }
    }

    /* compiled from: ObservableTimeoutTimed.java */
    /* loaded from: classes.dex */
    static final class b<T> extends AtomicReference<c.a.m.b> implements c.a.i<T>, c.a.m.b, d {
        private static final long serialVersionUID = 3764492702657003550L;

        /* renamed from: a  reason: collision with root package name */
        final c.a.i<? super T> f1727a;

        /* renamed from: b  reason: collision with root package name */
        final long f1728b;

        /* renamed from: c  reason: collision with root package name */
        final TimeUnit f1729c;

        /* renamed from: d  reason: collision with root package name */
        final j.b f1730d;
        final c.a.p.a.f e = new c.a.p.a.f();
        final AtomicLong f = new AtomicLong();
        final AtomicReference<c.a.m.b> g = new AtomicReference<>();
        c.a.h<? extends T> h;

        b(c.a.i<? super T> iVar, long j, TimeUnit timeUnit, j.b bVar, c.a.h<? extends T> hVar) {
            this.f1727a = iVar;
            this.f1728b = j;
            this.f1729c = timeUnit;
            this.f1730d = bVar;
            this.h = hVar;
        }

        @Override // c.a.p.e.a.s.d
        public void a(long j) {
            if (this.f.compareAndSet(j, Long.MAX_VALUE)) {
                c.a.p.a.c.dispose(this.g);
                c.a.h<? extends T> hVar = this.h;
                this.h = null;
                hVar.a(new a(this.f1727a, this));
                this.f1730d.dispose();
            }
        }

        void b(long j) {
            this.e.b(this.f1730d.c(new e(j, this), this.f1728b, this.f1729c));
        }

        @Override // c.a.m.b
        public void dispose() {
            c.a.p.a.c.dispose(this.g);
            c.a.p.a.c.dispose(this);
            this.f1730d.dispose();
        }

        @Override // c.a.i
        public void onComplete() {
            if (this.f.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.e.dispose();
                this.f1727a.onComplete();
                this.f1730d.dispose();
            }
        }

        @Override // c.a.i
        public void onError(Throwable th) {
            if (this.f.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.e.dispose();
                this.f1727a.onError(th);
                this.f1730d.dispose();
                return;
            }
            c.a.s.a.m(th);
        }

        @Override // c.a.i
        public void onNext(T t) {
            long j = this.f.get();
            if (j != Long.MAX_VALUE) {
                long j2 = 1 + j;
                if (this.f.compareAndSet(j, j2)) {
                    this.e.get().dispose();
                    this.f1727a.onNext(t);
                    b(j2);
                }
            }
        }

        @Override // c.a.i
        public void onSubscribe(c.a.m.b bVar) {
            c.a.p.a.c.setOnce(this.g, bVar);
        }
    }

    /* compiled from: ObservableTimeoutTimed.java */
    /* loaded from: classes.dex */
    static final class c<T> extends AtomicLong implements c.a.i<T>, c.a.m.b, d {
        private static final long serialVersionUID = 3764492702657003550L;

        /* renamed from: a  reason: collision with root package name */
        final c.a.i<? super T> f1731a;

        /* renamed from: b  reason: collision with root package name */
        final long f1732b;

        /* renamed from: c  reason: collision with root package name */
        final TimeUnit f1733c;

        /* renamed from: d  reason: collision with root package name */
        final j.b f1734d;
        final c.a.p.a.f e = new c.a.p.a.f();
        final AtomicReference<c.a.m.b> f = new AtomicReference<>();

        c(c.a.i<? super T> iVar, long j, TimeUnit timeUnit, j.b bVar) {
            this.f1731a = iVar;
            this.f1732b = j;
            this.f1733c = timeUnit;
            this.f1734d = bVar;
        }

        @Override // c.a.p.e.a.s.d
        public void a(long j) {
            if (compareAndSet(j, Long.MAX_VALUE)) {
                c.a.p.a.c.dispose(this.f);
                this.f1731a.onError(new TimeoutException());
                this.f1734d.dispose();
            }
        }

        void b(long j) {
            this.e.b(this.f1734d.c(new e(j, this), this.f1732b, this.f1733c));
        }

        @Override // c.a.m.b
        public void dispose() {
            c.a.p.a.c.dispose(this.f);
            this.f1734d.dispose();
        }

        @Override // c.a.i
        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.e.dispose();
                this.f1731a.onComplete();
                this.f1734d.dispose();
            }
        }

        @Override // c.a.i
        public void onError(Throwable th) {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.e.dispose();
                this.f1731a.onError(th);
                this.f1734d.dispose();
                return;
            }
            c.a.s.a.m(th);
        }

        @Override // c.a.i
        public void onNext(T t) {
            long j = get();
            if (j != Long.MAX_VALUE) {
                long j2 = 1 + j;
                if (compareAndSet(j, j2)) {
                    this.e.get().dispose();
                    this.f1731a.onNext(t);
                    b(j2);
                }
            }
        }

        @Override // c.a.i
        public void onSubscribe(c.a.m.b bVar) {
            c.a.p.a.c.setOnce(this.f, bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableTimeoutTimed.java */
    /* loaded from: classes.dex */
    public interface d {
        void a(long j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableTimeoutTimed.java */
    /* loaded from: classes.dex */
    public static final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final d f1735a;

        /* renamed from: b  reason: collision with root package name */
        final long f1736b;

        e(long j, d dVar) {
            this.f1736b = j;
            this.f1735a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1735a.a(this.f1736b);
        }
    }

    public s(c.a.e<T> eVar, long j, TimeUnit timeUnit, c.a.j jVar, c.a.h<? extends T> hVar) {
        super(eVar);
        this.f1722b = j;
        this.f1723c = timeUnit;
        this.f1724d = jVar;
        this.e = hVar;
    }

    @Override // c.a.e
    protected void w(c.a.i<? super T> iVar) {
        if (this.e == null) {
            c cVar = new c(iVar, this.f1722b, this.f1723c, this.f1724d.a());
            iVar.onSubscribe(cVar);
            cVar.b(0L);
            this.f1639a.a(cVar);
            return;
        }
        b bVar = new b(iVar, this.f1722b, this.f1723c, this.f1724d.a(), this.e);
        iVar.onSubscribe(bVar);
        bVar.b(0L);
        this.f1639a.a(bVar);
    }
}
