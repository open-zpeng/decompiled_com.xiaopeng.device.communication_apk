package c.a.p.e.a;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ObservableConcatMap.java */
/* loaded from: classes.dex */
public final class b<T, U> extends c.a.p.e.a.a<T, U> {

    /* renamed from: b  reason: collision with root package name */
    final c.a.o.f<? super T, ? extends c.a.h<? extends U>> f1640b;

    /* renamed from: c  reason: collision with root package name */
    final int f1641c;

    /* renamed from: d  reason: collision with root package name */
    final c.a.p.h.c f1642d;

    /* compiled from: ObservableConcatMap.java */
    /* loaded from: classes.dex */
    static final class a<T, R> extends AtomicInteger implements c.a.i<T>, c.a.m.b {
        private static final long serialVersionUID = -6951100001833242599L;

        /* renamed from: a  reason: collision with root package name */
        final c.a.i<? super R> f1643a;

        /* renamed from: b  reason: collision with root package name */
        final c.a.o.f<? super T, ? extends c.a.h<? extends R>> f1644b;

        /* renamed from: c  reason: collision with root package name */
        final int f1645c;

        /* renamed from: d  reason: collision with root package name */
        final c.a.p.h.b f1646d = new c.a.p.h.b();
        final C0065a<R> e;
        final boolean f;
        c.a.p.c.c<T> g;
        c.a.m.b h;
        volatile boolean i;
        volatile boolean j;
        volatile boolean k;
        int l;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ObservableConcatMap.java */
        /* renamed from: c.a.p.e.a.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0065a<R> extends AtomicReference<c.a.m.b> implements c.a.i<R> {
            private static final long serialVersionUID = 2620149119579502636L;

            /* renamed from: a  reason: collision with root package name */
            final c.a.i<? super R> f1647a;

            /* renamed from: b  reason: collision with root package name */
            final a<?, R> f1648b;

            C0065a(c.a.i<? super R> iVar, a<?, R> aVar) {
                this.f1647a = iVar;
                this.f1648b = aVar;
            }

            void a() {
                c.a.p.a.c.dispose(this);
            }

            @Override // c.a.i
            public void onComplete() {
                a<?, R> aVar = this.f1648b;
                aVar.i = false;
                aVar.a();
            }

            @Override // c.a.i
            public void onError(Throwable th) {
                a<?, R> aVar = this.f1648b;
                if (aVar.f1646d.a(th)) {
                    if (!aVar.f) {
                        aVar.h.dispose();
                    }
                    aVar.i = false;
                    aVar.a();
                    return;
                }
                c.a.s.a.m(th);
            }

            @Override // c.a.i
            public void onNext(R r) {
                this.f1647a.onNext(r);
            }

            @Override // c.a.i
            public void onSubscribe(c.a.m.b bVar) {
                c.a.p.a.c.replace(this, bVar);
            }
        }

        a(c.a.i<? super R> iVar, c.a.o.f<? super T, ? extends c.a.h<? extends R>> fVar, int i, boolean z) {
            this.f1643a = iVar;
            this.f1644b = fVar;
            this.f1645c = i;
            this.f = z;
            this.e = new C0065a<>(iVar, this);
        }

        void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            c.a.i<? super R> iVar = this.f1643a;
            c.a.p.c.c<T> cVar = this.g;
            c.a.p.h.b bVar = this.f1646d;
            while (true) {
                if (!this.i) {
                    if (this.k) {
                        cVar.clear();
                        return;
                    } else if (!this.f && bVar.get() != null) {
                        cVar.clear();
                        this.k = true;
                        iVar.onError(bVar.b());
                        return;
                    } else {
                        boolean z = this.j;
                        try {
                            T poll = cVar.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                this.k = true;
                                Throwable b2 = bVar.b();
                                if (b2 != null) {
                                    iVar.onError(b2);
                                    return;
                                } else {
                                    iVar.onComplete();
                                    return;
                                }
                            } else if (!z2) {
                                try {
                                    c.a.h hVar = (c.a.h) c.a.p.b.b.d(this.f1644b.apply(poll), "The mapper returned a null ObservableSource");
                                    if (hVar instanceof Callable) {
                                        try {
                                            Object obj = (Object) ((Callable) hVar).call();
                                            if (obj != 0 && !this.k) {
                                                iVar.onNext(obj);
                                            }
                                        } catch (Throwable th) {
                                            c.a.n.b.b(th);
                                            bVar.a(th);
                                        }
                                    } else {
                                        this.i = true;
                                        hVar.a(this.e);
                                    }
                                } catch (Throwable th2) {
                                    c.a.n.b.b(th2);
                                    this.k = true;
                                    this.h.dispose();
                                    cVar.clear();
                                    bVar.a(th2);
                                    iVar.onError(bVar.b());
                                    return;
                                }
                            }
                        } catch (Throwable th3) {
                            c.a.n.b.b(th3);
                            this.k = true;
                            this.h.dispose();
                            bVar.a(th3);
                            iVar.onError(bVar.b());
                            return;
                        }
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }

        @Override // c.a.m.b
        public void dispose() {
            this.k = true;
            this.h.dispose();
            this.e.a();
        }

        @Override // c.a.i
        public void onComplete() {
            this.j = true;
            a();
        }

        @Override // c.a.i
        public void onError(Throwable th) {
            if (this.f1646d.a(th)) {
                this.j = true;
                a();
                return;
            }
            c.a.s.a.m(th);
        }

        @Override // c.a.i
        public void onNext(T t) {
            if (this.l == 0) {
                this.g.offer(t);
            }
            a();
        }

        @Override // c.a.i
        public void onSubscribe(c.a.m.b bVar) {
            if (c.a.p.a.c.validate(this.h, bVar)) {
                this.h = bVar;
                if (bVar instanceof c.a.p.c.a) {
                    c.a.p.c.a aVar = (c.a.p.c.a) bVar;
                    int requestFusion = aVar.requestFusion(3);
                    if (requestFusion == 1) {
                        this.l = requestFusion;
                        this.g = aVar;
                        this.j = true;
                        this.f1643a.onSubscribe(this);
                        a();
                        return;
                    } else if (requestFusion == 2) {
                        this.l = requestFusion;
                        this.g = aVar;
                        this.f1643a.onSubscribe(this);
                        return;
                    }
                }
                this.g = new c.a.p.f.a(this.f1645c);
                this.f1643a.onSubscribe(this);
            }
        }
    }

    /* compiled from: ObservableConcatMap.java */
    /* renamed from: c.a.p.e.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static final class C0066b<T, U> extends AtomicInteger implements c.a.i<T>, c.a.m.b {
        private static final long serialVersionUID = 8828587559905699186L;

        /* renamed from: a  reason: collision with root package name */
        final c.a.i<? super U> f1649a;

        /* renamed from: b  reason: collision with root package name */
        final c.a.o.f<? super T, ? extends c.a.h<? extends U>> f1650b;

        /* renamed from: c  reason: collision with root package name */
        final a<U> f1651c;

        /* renamed from: d  reason: collision with root package name */
        final int f1652d;
        c.a.p.c.c<T> e;
        c.a.m.b f;
        volatile boolean g;
        volatile boolean h;
        volatile boolean i;
        int j;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ObservableConcatMap.java */
        /* renamed from: c.a.p.e.a.b$b$a */
        /* loaded from: classes.dex */
        public static final class a<U> extends AtomicReference<c.a.m.b> implements c.a.i<U> {
            private static final long serialVersionUID = -7449079488798789337L;

            /* renamed from: a  reason: collision with root package name */
            final c.a.i<? super U> f1653a;

            /* renamed from: b  reason: collision with root package name */
            final C0066b<?, ?> f1654b;

            a(c.a.i<? super U> iVar, C0066b<?, ?> c0066b) {
                this.f1653a = iVar;
                this.f1654b = c0066b;
            }

            void a() {
                c.a.p.a.c.dispose(this);
            }

            @Override // c.a.i
            public void onComplete() {
                this.f1654b.b();
            }

            @Override // c.a.i
            public void onError(Throwable th) {
                this.f1654b.dispose();
                this.f1653a.onError(th);
            }

            @Override // c.a.i
            public void onNext(U u) {
                this.f1653a.onNext(u);
            }

            @Override // c.a.i
            public void onSubscribe(c.a.m.b bVar) {
                c.a.p.a.c.set(this, bVar);
            }
        }

        C0066b(c.a.i<? super U> iVar, c.a.o.f<? super T, ? extends c.a.h<? extends U>> fVar, int i) {
            this.f1649a = iVar;
            this.f1650b = fVar;
            this.f1652d = i;
            this.f1651c = new a<>(iVar, this);
        }

        void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            while (!this.h) {
                if (!this.g) {
                    boolean z = this.i;
                    try {
                        T poll = this.e.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            this.h = true;
                            this.f1649a.onComplete();
                            return;
                        } else if (!z2) {
                            try {
                                c.a.h hVar = (c.a.h) c.a.p.b.b.d(this.f1650b.apply(poll), "The mapper returned a null ObservableSource");
                                this.g = true;
                                hVar.a(this.f1651c);
                            } catch (Throwable th) {
                                c.a.n.b.b(th);
                                dispose();
                                this.e.clear();
                                this.f1649a.onError(th);
                                return;
                            }
                        }
                    } catch (Throwable th2) {
                        c.a.n.b.b(th2);
                        dispose();
                        this.e.clear();
                        this.f1649a.onError(th2);
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            this.e.clear();
        }

        void b() {
            this.g = false;
            a();
        }

        @Override // c.a.m.b
        public void dispose() {
            this.h = true;
            this.f1651c.a();
            this.f.dispose();
            if (getAndIncrement() == 0) {
                this.e.clear();
            }
        }

        @Override // c.a.i
        public void onComplete() {
            if (this.i) {
                return;
            }
            this.i = true;
            a();
        }

        @Override // c.a.i
        public void onError(Throwable th) {
            if (this.i) {
                c.a.s.a.m(th);
                return;
            }
            this.i = true;
            dispose();
            this.f1649a.onError(th);
        }

        @Override // c.a.i
        public void onNext(T t) {
            if (this.i) {
                return;
            }
            if (this.j == 0) {
                this.e.offer(t);
            }
            a();
        }

        @Override // c.a.i
        public void onSubscribe(c.a.m.b bVar) {
            if (c.a.p.a.c.validate(this.f, bVar)) {
                this.f = bVar;
                if (bVar instanceof c.a.p.c.a) {
                    c.a.p.c.a aVar = (c.a.p.c.a) bVar;
                    int requestFusion = aVar.requestFusion(3);
                    if (requestFusion == 1) {
                        this.j = requestFusion;
                        this.e = aVar;
                        this.i = true;
                        this.f1649a.onSubscribe(this);
                        a();
                        return;
                    } else if (requestFusion == 2) {
                        this.j = requestFusion;
                        this.e = aVar;
                        this.f1649a.onSubscribe(this);
                        return;
                    }
                }
                this.e = new c.a.p.f.a(this.f1652d);
                this.f1649a.onSubscribe(this);
            }
        }
    }

    public b(c.a.h<T> hVar, c.a.o.f<? super T, ? extends c.a.h<? extends U>> fVar, int i, c.a.p.h.c cVar) {
        super(hVar);
        this.f1640b = fVar;
        this.f1642d = cVar;
        this.f1641c = Math.max(8, i);
    }

    @Override // c.a.e
    public void w(c.a.i<? super U> iVar) {
        if (p.a(this.f1639a, iVar, this.f1640b)) {
            return;
        }
        c.a.p.h.c cVar = this.f1642d;
        if (cVar == c.a.p.h.c.IMMEDIATE) {
            this.f1639a.a(new C0066b(new c.a.r.a(iVar), this.f1640b, this.f1641c));
        } else {
            this.f1639a.a(new a(iVar, this.f1640b, this.f1641c, cVar == c.a.p.h.c.END));
        }
    }
}
