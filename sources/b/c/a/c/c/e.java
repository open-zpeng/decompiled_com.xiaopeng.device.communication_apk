package b.c.a.c.c;
/* compiled from: NoCachePolicy.java */
/* loaded from: classes.dex */
public class e<T> extends b.c.a.c.c.a<T> {

    /* compiled from: NoCachePolicy.java */
    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b.c.a.j.d f1194a;

        a(b.c.a.j.d dVar) {
            this.f1194a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f.onSuccess(this.f1194a);
            e.this.f.onFinish();
        }
    }

    /* compiled from: NoCachePolicy.java */
    /* loaded from: classes.dex */
    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b.c.a.j.d f1196a;

        b(b.c.a.j.d dVar) {
            this.f1196a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f.onError(this.f1196a);
            e.this.f.onFinish();
        }
    }

    /* compiled from: NoCachePolicy.java */
    /* loaded from: classes.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar = e.this;
            eVar.f.onStart(eVar.f1174a);
            try {
                e.this.e();
                e.this.f();
            } catch (Throwable th) {
                e.this.f.onError(b.c.a.j.d.c(false, e.this.e, null, th));
            }
        }
    }

    public e(b.c.a.k.d.d<T, ? extends b.c.a.k.d.d> dVar) {
        super(dVar);
    }

    @Override // b.c.a.c.c.b
    public void b(b.c.a.c.a<T> aVar, b.c.a.d.b<T> bVar) {
        this.f = bVar;
        g(new c());
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
