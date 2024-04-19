package c.a.r;

import c.a.i;
import c.a.m.b;
import c.a.p.a.c;
import c.a.p.h.e;
/* compiled from: SerializedObserver.java */
/* loaded from: classes.dex */
public final class a<T> implements i<T>, b {

    /* renamed from: a  reason: collision with root package name */
    final i<? super T> f1816a;

    /* renamed from: b  reason: collision with root package name */
    final boolean f1817b;

    /* renamed from: c  reason: collision with root package name */
    b f1818c;

    /* renamed from: d  reason: collision with root package name */
    boolean f1819d;
    c.a.p.h.a<Object> e;
    volatile boolean f;

    public a(i<? super T> iVar) {
        this(iVar, false);
    }

    void a() {
        c.a.p.h.a<Object> aVar;
        do {
            synchronized (this) {
                aVar = this.e;
                if (aVar == null) {
                    this.f1819d = false;
                    return;
                }
                this.e = null;
            }
        } while (!aVar.a((i<? super T>) this.f1816a));
    }

    @Override // c.a.m.b
    public void dispose() {
        this.f1818c.dispose();
    }

    @Override // c.a.i
    public void onComplete() {
        if (this.f) {
            return;
        }
        synchronized (this) {
            if (this.f) {
                return;
            }
            if (this.f1819d) {
                c.a.p.h.a<Object> aVar = this.e;
                if (aVar == null) {
                    aVar = new c.a.p.h.a<>(4);
                    this.e = aVar;
                }
                aVar.b(e.complete());
                return;
            }
            this.f = true;
            this.f1819d = true;
            this.f1816a.onComplete();
        }
    }

    @Override // c.a.i
    public void onError(Throwable th) {
        if (this.f) {
            c.a.s.a.m(th);
            return;
        }
        synchronized (this) {
            boolean z = true;
            if (!this.f) {
                if (this.f1819d) {
                    this.f = true;
                    c.a.p.h.a<Object> aVar = this.e;
                    if (aVar == null) {
                        aVar = new c.a.p.h.a<>(4);
                        this.e = aVar;
                    }
                    Object error = e.error(th);
                    if (this.f1817b) {
                        aVar.b(error);
                    } else {
                        aVar.c(error);
                    }
                    return;
                }
                this.f = true;
                this.f1819d = true;
                z = false;
            }
            if (z) {
                c.a.s.a.m(th);
            } else {
                this.f1816a.onError(th);
            }
        }
    }

    @Override // c.a.i
    public void onNext(T t) {
        if (this.f) {
            return;
        }
        if (t == null) {
            this.f1818c.dispose();
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        synchronized (this) {
            if (this.f) {
                return;
            }
            if (this.f1819d) {
                c.a.p.h.a<Object> aVar = this.e;
                if (aVar == null) {
                    aVar = new c.a.p.h.a<>(4);
                    this.e = aVar;
                }
                aVar.b(e.next(t));
                return;
            }
            this.f1819d = true;
            this.f1816a.onNext(t);
            a();
        }
    }

    @Override // c.a.i
    public void onSubscribe(b bVar) {
        if (c.validate(this.f1818c, bVar)) {
            this.f1818c = bVar;
            this.f1816a.onSubscribe(this);
        }
    }

    public a(i<? super T> iVar, boolean z) {
        this.f1816a = iVar;
        this.f1817b = z;
    }
}
