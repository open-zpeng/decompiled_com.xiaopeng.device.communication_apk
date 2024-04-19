package c.a.p.e.a;

import c.a.j;
/* compiled from: ObservableObserveOn.java */
/* loaded from: classes.dex */
public final class l<T> extends c.a.p.e.a.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final c.a.j f1676b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f1677c;

    /* renamed from: d  reason: collision with root package name */
    final int f1678d;

    /* compiled from: ObservableObserveOn.java */
    /* loaded from: classes.dex */
    static final class a<T> extends c.a.p.d.b<T> implements c.a.i<T>, Runnable {
        private static final long serialVersionUID = 6576896619930983584L;

        /* renamed from: a  reason: collision with root package name */
        final c.a.i<? super T> f1679a;

        /* renamed from: b  reason: collision with root package name */
        final j.b f1680b;

        /* renamed from: c  reason: collision with root package name */
        final boolean f1681c;

        /* renamed from: d  reason: collision with root package name */
        final int f1682d;
        c.a.p.c.c<T> e;
        c.a.m.b f;
        Throwable g;
        volatile boolean h;
        volatile boolean i;
        int j;
        boolean k;

        a(c.a.i<? super T> iVar, j.b bVar, boolean z, int i) {
            this.f1679a = iVar;
            this.f1680b = bVar;
            this.f1681c = z;
            this.f1682d = i;
        }

        boolean a(boolean z, boolean z2, c.a.i<? super T> iVar) {
            if (this.i) {
                this.e.clear();
                return true;
            } else if (z) {
                Throwable th = this.g;
                if (this.f1681c) {
                    if (z2) {
                        if (th != null) {
                            iVar.onError(th);
                        } else {
                            iVar.onComplete();
                        }
                        this.f1680b.dispose();
                        return true;
                    }
                    return false;
                } else if (th != null) {
                    this.e.clear();
                    iVar.onError(th);
                    this.f1680b.dispose();
                    return true;
                } else if (z2) {
                    iVar.onComplete();
                    this.f1680b.dispose();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        void b() {
            int i = 1;
            while (!this.i) {
                boolean z = this.h;
                Throwable th = this.g;
                if (!this.f1681c && z && th != null) {
                    this.f1679a.onError(th);
                    this.f1680b.dispose();
                    return;
                }
                this.f1679a.onNext(null);
                if (z) {
                    Throwable th2 = this.g;
                    if (th2 != null) {
                        this.f1679a.onError(th2);
                    } else {
                        this.f1679a.onComplete();
                    }
                    this.f1680b.dispose();
                    return;
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }

        void c() {
            c.a.p.c.c<T> cVar = this.e;
            c.a.i<? super T> iVar = this.f1679a;
            int i = 1;
            while (!a(this.h, cVar.isEmpty(), iVar)) {
                while (true) {
                    boolean z = this.h;
                    try {
                        Object obj = (T) cVar.poll();
                        boolean z2 = obj == null;
                        if (a(z, z2, iVar)) {
                            return;
                        }
                        if (z2) {
                            i = addAndGet(-i);
                            if (i == 0) {
                                return;
                            }
                        } else {
                            iVar.onNext(obj);
                        }
                    } catch (Throwable th) {
                        c.a.n.b.b(th);
                        this.f.dispose();
                        cVar.clear();
                        iVar.onError(th);
                        this.f1680b.dispose();
                        return;
                    }
                }
            }
        }

        @Override // c.a.p.c.c
        public void clear() {
            this.e.clear();
        }

        void d() {
            if (getAndIncrement() == 0) {
                this.f1680b.b(this);
            }
        }

        @Override // c.a.m.b
        public void dispose() {
            if (this.i) {
                return;
            }
            this.i = true;
            this.f.dispose();
            this.f1680b.dispose();
            if (getAndIncrement() == 0) {
                this.e.clear();
            }
        }

        @Override // c.a.p.c.c
        public boolean isEmpty() {
            return this.e.isEmpty();
        }

        @Override // c.a.i
        public void onComplete() {
            if (this.h) {
                return;
            }
            this.h = true;
            d();
        }

        @Override // c.a.i
        public void onError(Throwable th) {
            if (this.h) {
                c.a.s.a.m(th);
                return;
            }
            this.g = th;
            this.h = true;
            d();
        }

        @Override // c.a.i
        public void onNext(T t) {
            if (this.h) {
                return;
            }
            if (this.j != 2) {
                this.e.offer(t);
            }
            d();
        }

        @Override // c.a.i
        public void onSubscribe(c.a.m.b bVar) {
            if (c.a.p.a.c.validate(this.f, bVar)) {
                this.f = bVar;
                if (bVar instanceof c.a.p.c.a) {
                    c.a.p.c.a aVar = (c.a.p.c.a) bVar;
                    int requestFusion = aVar.requestFusion(7);
                    if (requestFusion == 1) {
                        this.j = requestFusion;
                        this.e = aVar;
                        this.h = true;
                        this.f1679a.onSubscribe(this);
                        d();
                        return;
                    } else if (requestFusion == 2) {
                        this.j = requestFusion;
                        this.e = aVar;
                        this.f1679a.onSubscribe(this);
                        return;
                    }
                }
                this.e = new c.a.p.f.a(this.f1682d);
                this.f1679a.onSubscribe(this);
            }
        }

        @Override // c.a.p.c.c
        public T poll() throws Exception {
            return this.e.poll();
        }

        @Override // c.a.p.c.b
        public int requestFusion(int i) {
            if ((i & 2) != 0) {
                this.k = true;
                return 2;
            }
            return 0;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.k) {
                b();
            } else {
                c();
            }
        }
    }

    public l(c.a.h<T> hVar, c.a.j jVar, boolean z, int i) {
        super(hVar);
        this.f1676b = jVar;
        this.f1677c = z;
        this.f1678d = i;
    }

    @Override // c.a.e
    protected void w(c.a.i<? super T> iVar) {
        c.a.j jVar = this.f1676b;
        if (jVar instanceof c.a.p.g.k) {
            this.f1639a.a(iVar);
            return;
        }
        this.f1639a.a(new a(iVar, jVar.a(), this.f1677c, this.f1678d));
    }
}
