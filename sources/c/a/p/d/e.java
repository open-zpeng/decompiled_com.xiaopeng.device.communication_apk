package c.a.p.d;

import c.a.i;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: LambdaObserver.java */
/* loaded from: classes.dex */
public final class e<T> extends AtomicReference<c.a.m.b> implements i<T>, c.a.m.b {
    private static final long serialVersionUID = -7251123623727029452L;

    /* renamed from: a  reason: collision with root package name */
    final c.a.o.e<? super T> f1635a;

    /* renamed from: b  reason: collision with root package name */
    final c.a.o.e<? super Throwable> f1636b;

    /* renamed from: c  reason: collision with root package name */
    final c.a.o.a f1637c;

    /* renamed from: d  reason: collision with root package name */
    final c.a.o.e<? super c.a.m.b> f1638d;

    public e(c.a.o.e<? super T> eVar, c.a.o.e<? super Throwable> eVar2, c.a.o.a aVar, c.a.o.e<? super c.a.m.b> eVar3) {
        this.f1635a = eVar;
        this.f1636b = eVar2;
        this.f1637c = aVar;
        this.f1638d = eVar3;
    }

    public boolean a() {
        return get() == c.a.p.a.c.DISPOSED;
    }

    @Override // c.a.m.b
    public void dispose() {
        c.a.p.a.c.dispose(this);
    }

    @Override // c.a.i
    public void onComplete() {
        if (a()) {
            return;
        }
        lazySet(c.a.p.a.c.DISPOSED);
        try {
            this.f1637c.run();
        } catch (Throwable th) {
            c.a.n.b.b(th);
            c.a.s.a.m(th);
        }
    }

    @Override // c.a.i
    public void onError(Throwable th) {
        if (a()) {
            return;
        }
        lazySet(c.a.p.a.c.DISPOSED);
        try {
            this.f1636b.accept(th);
        } catch (Throwable th2) {
            c.a.n.b.b(th2);
            c.a.s.a.m(new c.a.n.a(th, th2));
        }
    }

    @Override // c.a.i
    public void onNext(T t) {
        if (a()) {
            return;
        }
        try {
            this.f1635a.accept(t);
        } catch (Throwable th) {
            c.a.n.b.b(th);
            get().dispose();
            onError(th);
        }
    }

    @Override // c.a.i
    public void onSubscribe(c.a.m.b bVar) {
        if (c.a.p.a.c.setOnce(this, bVar)) {
            try {
                this.f1638d.accept(this);
            } catch (Throwable th) {
                c.a.n.b.b(th);
                bVar.dispose();
                onError(th);
            }
        }
    }
}
