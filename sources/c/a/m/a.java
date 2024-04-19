package c.a.m;

import c.a.p.h.f;
import java.util.ArrayList;
/* compiled from: CompositeDisposable.java */
/* loaded from: classes.dex */
public final class a implements b, c.a.p.a.b {

    /* renamed from: a  reason: collision with root package name */
    f<b> f1613a;

    /* renamed from: b  reason: collision with root package name */
    volatile boolean f1614b;

    @Override // c.a.p.a.b
    public boolean a(b bVar) {
        c.a.p.b.b.d(bVar, "Disposable item is null");
        if (this.f1614b) {
            return false;
        }
        synchronized (this) {
            if (this.f1614b) {
                return false;
            }
            f<b> fVar = this.f1613a;
            if (fVar != null && fVar.e(bVar)) {
                return true;
            }
            return false;
        }
    }

    @Override // c.a.p.a.b
    public boolean b(b bVar) {
        if (a(bVar)) {
            bVar.dispose();
            return true;
        }
        return false;
    }

    @Override // c.a.p.a.b
    public boolean c(b bVar) {
        c.a.p.b.b.d(bVar, "d is null");
        if (!this.f1614b) {
            synchronized (this) {
                if (!this.f1614b) {
                    f<b> fVar = this.f1613a;
                    if (fVar == null) {
                        fVar = new f<>();
                        this.f1613a = fVar;
                    }
                    fVar.a(bVar);
                    return true;
                }
            }
        }
        bVar.dispose();
        return false;
    }

    void d(f<b> fVar) {
        Object[] b2;
        if (fVar == null) {
            return;
        }
        ArrayList arrayList = null;
        for (Object obj : fVar.b()) {
            if (obj instanceof b) {
                try {
                    ((b) obj).dispose();
                } catch (Throwable th) {
                    c.a.n.b.b(th);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th);
                }
            }
        }
        if (arrayList != null) {
            if (arrayList.size() == 1) {
                throw c.a.p.h.d.c((Throwable) arrayList.get(0));
            }
            throw new c.a.n.a(arrayList);
        }
    }

    @Override // c.a.m.b
    public void dispose() {
        if (this.f1614b) {
            return;
        }
        synchronized (this) {
            if (this.f1614b) {
                return;
            }
            this.f1614b = true;
            f<b> fVar = this.f1613a;
            this.f1613a = null;
            d(fVar);
        }
    }

    public boolean e() {
        return this.f1614b;
    }
}
