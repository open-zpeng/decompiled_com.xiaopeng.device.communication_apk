package c.a.p.e.a;
/* compiled from: ObservableTake.java */
/* loaded from: classes.dex */
public final class r<T> extends c.a.p.e.a.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f1717b;

    /* compiled from: ObservableTake.java */
    /* loaded from: classes.dex */
    static final class a<T> implements c.a.i<T>, c.a.m.b {

        /* renamed from: a  reason: collision with root package name */
        final c.a.i<? super T> f1718a;

        /* renamed from: b  reason: collision with root package name */
        boolean f1719b;

        /* renamed from: c  reason: collision with root package name */
        c.a.m.b f1720c;

        /* renamed from: d  reason: collision with root package name */
        long f1721d;

        a(c.a.i<? super T> iVar, long j) {
            this.f1718a = iVar;
            this.f1721d = j;
        }

        @Override // c.a.m.b
        public void dispose() {
            this.f1720c.dispose();
        }

        @Override // c.a.i
        public void onComplete() {
            if (this.f1719b) {
                return;
            }
            this.f1719b = true;
            this.f1720c.dispose();
            this.f1718a.onComplete();
        }

        @Override // c.a.i
        public void onError(Throwable th) {
            if (this.f1719b) {
                c.a.s.a.m(th);
                return;
            }
            this.f1719b = true;
            this.f1720c.dispose();
            this.f1718a.onError(th);
        }

        @Override // c.a.i
        public void onNext(T t) {
            if (this.f1719b) {
                return;
            }
            long j = this.f1721d;
            long j2 = j - 1;
            this.f1721d = j2;
            if (j > 0) {
                boolean z = j2 == 0;
                this.f1718a.onNext(t);
                if (z) {
                    onComplete();
                }
            }
        }

        @Override // c.a.i
        public void onSubscribe(c.a.m.b bVar) {
            if (c.a.p.a.c.validate(this.f1720c, bVar)) {
                this.f1720c = bVar;
                if (this.f1721d == 0) {
                    this.f1719b = true;
                    bVar.dispose();
                    c.a.p.a.d.complete(this.f1718a);
                    return;
                }
                this.f1718a.onSubscribe(this);
            }
        }
    }

    public r(c.a.h<T> hVar, long j) {
        super(hVar);
        this.f1717b = j;
    }

    @Override // c.a.e
    protected void w(c.a.i<? super T> iVar) {
        this.f1639a.a(new a(iVar, this.f1717b));
    }
}
