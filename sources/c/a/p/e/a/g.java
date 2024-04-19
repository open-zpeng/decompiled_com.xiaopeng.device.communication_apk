package c.a.p.e.a;
/* compiled from: ObservableFilter.java */
/* loaded from: classes.dex */
public final class g<T> extends c.a.p.e.a.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final c.a.o.h<? super T> f1667b;

    /* compiled from: ObservableFilter.java */
    /* loaded from: classes.dex */
    static final class a<T> extends c.a.p.d.a<T, T> {
        final c.a.o.h<? super T> f;

        a(c.a.i<? super T> iVar, c.a.o.h<? super T> hVar) {
            super(iVar);
            this.f = hVar;
        }

        @Override // c.a.i
        public void onNext(T t) {
            if (this.e == 0) {
                try {
                    if (this.f.test(t)) {
                        this.f1627a.onNext(t);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    c(th);
                    return;
                }
            }
            this.f1627a.onNext(null);
        }

        @Override // c.a.p.c.c
        public T poll() throws Exception {
            T poll;
            do {
                poll = this.f1629c.poll();
                if (poll == null) {
                    break;
                }
            } while (!this.f.test(poll));
            return poll;
        }

        @Override // c.a.p.c.b
        public int requestFusion(int i) {
            return d(i);
        }
    }

    public g(c.a.h<T> hVar, c.a.o.h<? super T> hVar2) {
        super(hVar);
        this.f1667b = hVar2;
    }

    @Override // c.a.e
    public void w(c.a.i<? super T> iVar) {
        this.f1639a.a(new a(iVar, this.f1667b));
    }
}
