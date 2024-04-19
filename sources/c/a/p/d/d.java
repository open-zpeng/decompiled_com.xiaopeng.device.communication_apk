package c.a.p.d;

import c.a.i;
/* compiled from: DisposableLambdaObserver.java */
/* loaded from: classes.dex */
public final class d<T> implements i<T>, c.a.m.b {

    /* renamed from: a  reason: collision with root package name */
    final i<? super T> f1631a;

    /* renamed from: b  reason: collision with root package name */
    final c.a.o.e<? super c.a.m.b> f1632b;

    /* renamed from: c  reason: collision with root package name */
    final c.a.o.a f1633c;

    /* renamed from: d  reason: collision with root package name */
    c.a.m.b f1634d;

    public d(i<? super T> iVar, c.a.o.e<? super c.a.m.b> eVar, c.a.o.a aVar) {
        this.f1631a = iVar;
        this.f1632b = eVar;
        this.f1633c = aVar;
    }

    @Override // c.a.m.b
    public void dispose() {
        try {
            this.f1633c.run();
        } catch (Throwable th) {
            c.a.n.b.b(th);
            c.a.s.a.m(th);
        }
        this.f1634d.dispose();
    }

    @Override // c.a.i
    public void onComplete() {
        if (this.f1634d != c.a.p.a.c.DISPOSED) {
            this.f1631a.onComplete();
        }
    }

    @Override // c.a.i
    public void onError(Throwable th) {
        if (this.f1634d != c.a.p.a.c.DISPOSED) {
            this.f1631a.onError(th);
        } else {
            c.a.s.a.m(th);
        }
    }

    @Override // c.a.i
    public void onNext(T t) {
        this.f1631a.onNext(t);
    }

    @Override // c.a.i
    public void onSubscribe(c.a.m.b bVar) {
        try {
            this.f1632b.accept(bVar);
            if (c.a.p.a.c.validate(this.f1634d, bVar)) {
                this.f1634d = bVar;
                this.f1631a.onSubscribe(this);
            }
        } catch (Throwable th) {
            c.a.n.b.b(th);
            bVar.dispose();
            this.f1634d = c.a.p.a.c.DISPOSED;
            c.a.p.a.d.error(th, this.f1631a);
        }
    }
}
