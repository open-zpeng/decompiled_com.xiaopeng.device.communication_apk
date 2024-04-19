package c.a.p.d;

import c.a.i;
/* compiled from: BasicFuseableObserver.java */
/* loaded from: classes.dex */
public abstract class a<T, R> implements i<T>, c.a.p.c.a<R> {

    /* renamed from: a  reason: collision with root package name */
    protected final i<? super R> f1627a;

    /* renamed from: b  reason: collision with root package name */
    protected c.a.m.b f1628b;

    /* renamed from: c  reason: collision with root package name */
    protected c.a.p.c.a<T> f1629c;

    /* renamed from: d  reason: collision with root package name */
    protected boolean f1630d;
    protected int e;

    public a(i<? super R> iVar) {
        this.f1627a = iVar;
    }

    protected void a() {
    }

    protected boolean b() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(Throwable th) {
        c.a.n.b.b(th);
        this.f1628b.dispose();
        onError(th);
    }

    @Override // c.a.p.c.c
    public void clear() {
        this.f1629c.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int d(int i) {
        c.a.p.c.a<T> aVar = this.f1629c;
        if (aVar == null || (i & 4) != 0) {
            return 0;
        }
        int requestFusion = aVar.requestFusion(i);
        if (requestFusion != 0) {
            this.e = requestFusion;
        }
        return requestFusion;
    }

    @Override // c.a.m.b
    public void dispose() {
        this.f1628b.dispose();
    }

    @Override // c.a.p.c.c
    public boolean isEmpty() {
        return this.f1629c.isEmpty();
    }

    @Override // c.a.p.c.c
    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // c.a.i
    public void onComplete() {
        if (this.f1630d) {
            return;
        }
        this.f1630d = true;
        this.f1627a.onComplete();
    }

    @Override // c.a.i
    public void onError(Throwable th) {
        if (this.f1630d) {
            c.a.s.a.m(th);
            return;
        }
        this.f1630d = true;
        this.f1627a.onError(th);
    }

    @Override // c.a.i
    public final void onSubscribe(c.a.m.b bVar) {
        if (c.a.p.a.c.validate(this.f1628b, bVar)) {
            this.f1628b = bVar;
            if (bVar instanceof c.a.p.c.a) {
                this.f1629c = (c.a.p.c.a) bVar;
            }
            if (b()) {
                this.f1627a.onSubscribe(this);
                a();
            }
        }
    }
}
