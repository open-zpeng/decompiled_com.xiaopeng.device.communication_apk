package c.a.p.e.a;

import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: ObservableRetryPredicate.java */
/* loaded from: classes.dex */
public final class o<T> extends c.a.p.e.a.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final c.a.o.h<? super Throwable> f1704b;

    /* renamed from: c  reason: collision with root package name */
    final long f1705c;

    /* compiled from: ObservableRetryPredicate.java */
    /* loaded from: classes.dex */
    static final class a<T> extends AtomicInteger implements c.a.i<T> {
        private static final long serialVersionUID = -7098360935104053232L;

        /* renamed from: a  reason: collision with root package name */
        final c.a.i<? super T> f1706a;

        /* renamed from: b  reason: collision with root package name */
        final c.a.p.a.f f1707b;

        /* renamed from: c  reason: collision with root package name */
        final c.a.h<? extends T> f1708c;

        /* renamed from: d  reason: collision with root package name */
        final c.a.o.h<? super Throwable> f1709d;
        long e;

        a(c.a.i<? super T> iVar, long j, c.a.o.h<? super Throwable> hVar, c.a.p.a.f fVar, c.a.h<? extends T> hVar2) {
            this.f1706a = iVar;
            this.f1707b = fVar;
            this.f1708c = hVar2;
            this.f1709d = hVar;
            this.e = j;
        }

        void a() {
            if (getAndIncrement() == 0) {
                int i = 1;
                while (!this.f1707b.a()) {
                    this.f1708c.a(this);
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }

        @Override // c.a.i
        public void onComplete() {
            this.f1706a.onComplete();
        }

        @Override // c.a.i
        public void onError(Throwable th) {
            long j = this.e;
            if (j != Long.MAX_VALUE) {
                this.e = j - 1;
            }
            if (j == 0) {
                this.f1706a.onError(th);
                return;
            }
            try {
                if (!this.f1709d.test(th)) {
                    this.f1706a.onError(th);
                } else {
                    a();
                }
            } catch (Throwable th2) {
                c.a.n.b.b(th2);
                this.f1706a.onError(new c.a.n.a(th, th2));
            }
        }

        @Override // c.a.i
        public void onNext(T t) {
            this.f1706a.onNext(t);
        }

        @Override // c.a.i
        public void onSubscribe(c.a.m.b bVar) {
            this.f1707b.c(bVar);
        }
    }

    public o(c.a.e<T> eVar, long j, c.a.o.h<? super Throwable> hVar) {
        super(eVar);
        this.f1704b = hVar;
        this.f1705c = j;
    }

    @Override // c.a.e
    public void w(c.a.i<? super T> iVar) {
        c.a.p.a.f fVar = new c.a.p.a.f();
        iVar.onSubscribe(fVar);
        new a(iVar, this.f1705c, this.f1704b, fVar, this.f1639a).a();
    }
}
