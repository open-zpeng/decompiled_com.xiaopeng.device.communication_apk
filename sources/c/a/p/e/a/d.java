package c.a.p.e.a;
/* compiled from: ObservableDoOnEach.java */
/* loaded from: classes.dex */
public final class d<T> extends c.a.p.e.a.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final c.a.o.e<? super T> f1657b;

    /* renamed from: c  reason: collision with root package name */
    final c.a.o.e<? super Throwable> f1658c;

    /* renamed from: d  reason: collision with root package name */
    final c.a.o.a f1659d;
    final c.a.o.a e;

    /* compiled from: ObservableDoOnEach.java */
    /* loaded from: classes.dex */
    static final class a<T> implements c.a.i<T>, c.a.m.b {

        /* renamed from: a  reason: collision with root package name */
        final c.a.i<? super T> f1660a;

        /* renamed from: b  reason: collision with root package name */
        final c.a.o.e<? super T> f1661b;

        /* renamed from: c  reason: collision with root package name */
        final c.a.o.e<? super Throwable> f1662c;

        /* renamed from: d  reason: collision with root package name */
        final c.a.o.a f1663d;
        final c.a.o.a e;
        c.a.m.b f;
        boolean g;

        a(c.a.i<? super T> iVar, c.a.o.e<? super T> eVar, c.a.o.e<? super Throwable> eVar2, c.a.o.a aVar, c.a.o.a aVar2) {
            this.f1660a = iVar;
            this.f1661b = eVar;
            this.f1662c = eVar2;
            this.f1663d = aVar;
            this.e = aVar2;
        }

        @Override // c.a.m.b
        public void dispose() {
            this.f.dispose();
        }

        @Override // c.a.i
        public void onComplete() {
            if (this.g) {
                return;
            }
            try {
                this.f1663d.run();
                this.g = true;
                this.f1660a.onComplete();
                try {
                    this.e.run();
                } catch (Throwable th) {
                    c.a.n.b.b(th);
                    c.a.s.a.m(th);
                }
            } catch (Throwable th2) {
                c.a.n.b.b(th2);
                onError(th2);
            }
        }

        @Override // c.a.i
        public void onError(Throwable th) {
            if (this.g) {
                c.a.s.a.m(th);
                return;
            }
            this.g = true;
            try {
                this.f1662c.accept(th);
            } catch (Throwable th2) {
                c.a.n.b.b(th2);
                th = new c.a.n.a(th, th2);
            }
            this.f1660a.onError(th);
            try {
                this.e.run();
            } catch (Throwable th3) {
                c.a.n.b.b(th3);
                c.a.s.a.m(th3);
            }
        }

        @Override // c.a.i
        public void onNext(T t) {
            if (this.g) {
                return;
            }
            try {
                this.f1661b.accept(t);
                this.f1660a.onNext(t);
            } catch (Throwable th) {
                c.a.n.b.b(th);
                this.f.dispose();
                onError(th);
            }
        }

        @Override // c.a.i
        public void onSubscribe(c.a.m.b bVar) {
            if (c.a.p.a.c.validate(this.f, bVar)) {
                this.f = bVar;
                this.f1660a.onSubscribe(this);
            }
        }
    }

    public d(c.a.h<T> hVar, c.a.o.e<? super T> eVar, c.a.o.e<? super Throwable> eVar2, c.a.o.a aVar, c.a.o.a aVar2) {
        super(hVar);
        this.f1657b = eVar;
        this.f1658c = eVar2;
        this.f1659d = aVar;
        this.e = aVar2;
    }

    @Override // c.a.e
    public void w(c.a.i<? super T> iVar) {
        this.f1639a.a(new a(iVar, this.f1657b, this.f1658c, this.f1659d, this.e));
    }
}
