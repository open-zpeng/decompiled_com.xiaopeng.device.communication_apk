package c.a.p.e.a;
/* compiled from: ObservableDoOnLifecycle.java */
/* loaded from: classes.dex */
public final class e<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    private final c.a.o.e<? super c.a.m.b> f1664b;

    /* renamed from: c  reason: collision with root package name */
    private final c.a.o.a f1665c;

    public e(c.a.e<T> eVar, c.a.o.e<? super c.a.m.b> eVar2, c.a.o.a aVar) {
        super(eVar);
        this.f1664b = eVar2;
        this.f1665c = aVar;
    }

    @Override // c.a.e
    protected void w(c.a.i<? super T> iVar) {
        this.f1639a.a(new c.a.p.d.d(iVar, this.f1664b, this.f1665c));
    }
}
