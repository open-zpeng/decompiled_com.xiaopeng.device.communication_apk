package c.a.p.e.a;
/* compiled from: ObservableFromArray.java */
/* loaded from: classes.dex */
public final class h<T> extends c.a.e<T> {

    /* renamed from: a  reason: collision with root package name */
    final T[] f1668a;

    /* compiled from: ObservableFromArray.java */
    /* loaded from: classes.dex */
    static final class a<T> extends c.a.p.d.c<T> {

        /* renamed from: a  reason: collision with root package name */
        final c.a.i<? super T> f1669a;

        /* renamed from: b  reason: collision with root package name */
        final T[] f1670b;

        /* renamed from: c  reason: collision with root package name */
        int f1671c;

        /* renamed from: d  reason: collision with root package name */
        boolean f1672d;
        volatile boolean e;

        a(c.a.i<? super T> iVar, T[] tArr) {
            this.f1669a = iVar;
            this.f1670b = tArr;
        }

        public boolean a() {
            return this.e;
        }

        void b() {
            T[] tArr = this.f1670b;
            int length = tArr.length;
            for (int i = 0; i < length && !a(); i++) {
                T t = tArr[i];
                if (t == null) {
                    c.a.i<? super T> iVar = this.f1669a;
                    iVar.onError(new NullPointerException("The " + i + "th element is null"));
                    return;
                }
                this.f1669a.onNext(t);
            }
            if (a()) {
                return;
            }
            this.f1669a.onComplete();
        }

        @Override // c.a.p.c.c
        public void clear() {
            this.f1671c = this.f1670b.length;
        }

        @Override // c.a.m.b
        public void dispose() {
            this.e = true;
        }

        @Override // c.a.p.c.c
        public boolean isEmpty() {
            return this.f1671c == this.f1670b.length;
        }

        @Override // c.a.p.c.c
        public T poll() {
            int i = this.f1671c;
            T[] tArr = this.f1670b;
            if (i != tArr.length) {
                this.f1671c = i + 1;
                return (T) c.a.p.b.b.d(tArr[i], "The array element is null");
            }
            return null;
        }

        @Override // c.a.p.c.b
        public int requestFusion(int i) {
            if ((i & 1) != 0) {
                this.f1672d = true;
                return 1;
            }
            return 0;
        }
    }

    public h(T[] tArr) {
        this.f1668a = tArr;
    }

    @Override // c.a.e
    public void w(c.a.i<? super T> iVar) {
        a aVar = new a(iVar, this.f1668a);
        iVar.onSubscribe(aVar);
        if (aVar.f1672d) {
            return;
        }
        aVar.b();
    }
}
