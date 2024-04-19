package c.a.p.e.a;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ObservableSubscribeOn.java */
/* loaded from: classes.dex */
public final class q<T> extends c.a.p.e.a.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final c.a.j f1712b;

    /* compiled from: ObservableSubscribeOn.java */
    /* loaded from: classes.dex */
    static final class a<T> extends AtomicReference<c.a.m.b> implements c.a.i<T>, c.a.m.b {
        private static final long serialVersionUID = 8094547886072529208L;

        /* renamed from: a  reason: collision with root package name */
        final c.a.i<? super T> f1713a;

        /* renamed from: b  reason: collision with root package name */
        final AtomicReference<c.a.m.b> f1714b = new AtomicReference<>();

        a(c.a.i<? super T> iVar) {
            this.f1713a = iVar;
        }

        void a(c.a.m.b bVar) {
            c.a.p.a.c.setOnce(this, bVar);
        }

        @Override // c.a.m.b
        public void dispose() {
            c.a.p.a.c.dispose(this.f1714b);
            c.a.p.a.c.dispose(this);
        }

        @Override // c.a.i
        public void onComplete() {
            this.f1713a.onComplete();
        }

        @Override // c.a.i
        public void onError(Throwable th) {
            this.f1713a.onError(th);
        }

        @Override // c.a.i
        public void onNext(T t) {
            this.f1713a.onNext(t);
        }

        @Override // c.a.i
        public void onSubscribe(c.a.m.b bVar) {
            c.a.p.a.c.setOnce(this.f1714b, bVar);
        }
    }

    /* compiled from: ObservableSubscribeOn.java */
    /* loaded from: classes.dex */
    final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final a<T> f1715a;

        b(a<T> aVar) {
            this.f1715a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            q.this.f1639a.a(this.f1715a);
        }
    }

    public q(c.a.h<T> hVar, c.a.j jVar) {
        super(hVar);
        this.f1712b = jVar;
    }

    @Override // c.a.e
    public void w(c.a.i<? super T> iVar) {
        a aVar = new a(iVar);
        iVar.onSubscribe(aVar);
        aVar.a(this.f1712b.b(new b(aVar)));
    }
}
