package b.c.a.c.c;
/* compiled from: NoneCacheRequestPolicy.java */
/* loaded from: classes.dex */
public class f<T> extends b.c.a.c.c.a<T> {

    /* compiled from: NoneCacheRequestPolicy.java */
    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b.c.a.j.d f1199a;

        a(b.c.a.j.d dVar) {
            this.f1199a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.f.onSuccess(this.f1199a);
            f.this.f.onFinish();
        }
    }

    /* compiled from: NoneCacheRequestPolicy.java */
    /* loaded from: classes.dex */
    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b.c.a.j.d f1201a;

        b(b.c.a.j.d dVar) {
            this.f1201a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.f.onError(this.f1201a);
            f.this.f.onFinish();
        }
    }

    /* compiled from: NoneCacheRequestPolicy.java */
    /* loaded from: classes.dex */
    class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b.c.a.c.a f1203a;

        c(b.c.a.c.a aVar) {
            this.f1203a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            f fVar = f.this;
            fVar.f.onStart(fVar.f1174a);
            try {
                f.this.e();
                b.c.a.c.a aVar = this.f1203a;
                if (aVar != null) {
                    f.this.f.onCacheSuccess(b.c.a.j.d.m(true, aVar.c(), f.this.e, null));
                    f.this.f.onFinish();
                    return;
                }
                f.this.f();
            } catch (Throwable th) {
                f.this.f.onError(b.c.a.j.d.c(false, f.this.e, null, th));
            }
        }
    }

    public f(b.c.a.k.d.d<T, ? extends b.c.a.k.d.d> dVar) {
        super(dVar);
    }

    @Override // b.c.a.c.c.b
    public void b(b.c.a.c.a<T> aVar, b.c.a.d.b<T> bVar) {
        this.f = bVar;
        g(new c(aVar));
    }

    @Override // b.c.a.c.c.b
    public void onError(b.c.a.j.d<T> dVar) {
        g(new b(dVar));
    }

    @Override // b.c.a.c.c.b
    public void onSuccess(b.c.a.j.d<T> dVar) {
        g(new a(dVar));
    }
}
