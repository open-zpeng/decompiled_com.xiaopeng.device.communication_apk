package b.c.a.c.c;
/* compiled from: FirstCacheRequestPolicy.java */
/* loaded from: classes.dex */
public class d<T> extends b.c.a.c.c.a<T> {

    /* compiled from: FirstCacheRequestPolicy.java */
    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b.c.a.j.d f1188a;

        a(b.c.a.j.d dVar) {
            this.f1188a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f.onSuccess(this.f1188a);
            d.this.f.onFinish();
        }
    }

    /* compiled from: FirstCacheRequestPolicy.java */
    /* loaded from: classes.dex */
    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b.c.a.j.d f1190a;

        b(b.c.a.j.d dVar) {
            this.f1190a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f.onError(this.f1190a);
            d.this.f.onFinish();
        }
    }

    /* compiled from: FirstCacheRequestPolicy.java */
    /* loaded from: classes.dex */
    class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b.c.a.c.a f1192a;

        c(b.c.a.c.a aVar) {
            this.f1192a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = d.this;
            dVar.f.onStart(dVar.f1174a);
            try {
                d.this.e();
                b.c.a.c.a aVar = this.f1192a;
                if (aVar != null) {
                    d.this.f.onCacheSuccess(b.c.a.j.d.m(true, aVar.c(), d.this.e, null));
                }
                d.this.f();
            } catch (Throwable th) {
                d.this.f.onError(b.c.a.j.d.c(false, d.this.e, null, th));
            }
        }
    }

    public d(b.c.a.k.d.d<T, ? extends b.c.a.k.d.d> dVar) {
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
