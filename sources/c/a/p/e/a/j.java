package c.a.p.e.a;

import c.a.p.e.a.p;
import java.util.concurrent.Callable;
/* compiled from: ObservableJust.java */
/* loaded from: classes.dex */
public final class j<T> extends c.a.e<T> implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private final T f1674a;

    public j(T t) {
        this.f1674a = t;
    }

    @Override // java.util.concurrent.Callable
    public T call() {
        return this.f1674a;
    }

    @Override // c.a.e
    protected void w(c.a.i<? super T> iVar) {
        p.a aVar = new p.a(iVar, this.f1674a);
        iVar.onSubscribe(aVar);
        aVar.run();
    }
}
