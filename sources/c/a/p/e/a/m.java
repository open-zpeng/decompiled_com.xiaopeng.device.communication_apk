package c.a.p.e.a;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ObservablePublish.java */
/* loaded from: classes.dex */
public final class m<T> extends c.a.q.a<T> {

    /* renamed from: a  reason: collision with root package name */
    final c.a.h<T> f1683a;

    /* renamed from: b  reason: collision with root package name */
    final AtomicReference<b<T>> f1684b;

    /* renamed from: c  reason: collision with root package name */
    final c.a.h<T> f1685c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservablePublish.java */
    /* loaded from: classes.dex */
    public static final class a<T> extends AtomicReference<Object> implements c.a.m.b {
        private static final long serialVersionUID = -1100270633763673112L;

        /* renamed from: a  reason: collision with root package name */
        final c.a.i<? super T> f1686a;

        a(c.a.i<? super T> iVar) {
            this.f1686a = iVar;
        }

        void a(b<T> bVar) {
            if (compareAndSet(null, bVar)) {
                return;
            }
            bVar.c(this);
        }

        @Override // c.a.m.b
        public void dispose() {
            Object andSet = getAndSet(this);
            if (andSet == null || andSet == this) {
                return;
            }
            ((b) andSet).c(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservablePublish.java */
    /* loaded from: classes.dex */
    public static final class b<T> implements c.a.i<T>, c.a.m.b {

        /* renamed from: a  reason: collision with root package name */
        static final a[] f1687a = new a[0];

        /* renamed from: b  reason: collision with root package name */
        static final a[] f1688b = new a[0];

        /* renamed from: c  reason: collision with root package name */
        final AtomicReference<b<T>> f1689c;
        final AtomicReference<c.a.m.b> f = new AtomicReference<>();

        /* renamed from: d  reason: collision with root package name */
        final AtomicReference<a<T>[]> f1690d = new AtomicReference<>(f1687a);
        final AtomicBoolean e = new AtomicBoolean();

        b(AtomicReference<b<T>> atomicReference) {
            this.f1689c = atomicReference;
        }

        boolean a(a<T> aVar) {
            a<T>[] aVarArr;
            a<T>[] aVarArr2;
            do {
                aVarArr = this.f1690d.get();
                if (aVarArr == f1688b) {
                    return false;
                }
                int length = aVarArr.length;
                aVarArr2 = new a[length + 1];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
            } while (!this.f1690d.compareAndSet(aVarArr, aVarArr2));
            return true;
        }

        public boolean b() {
            return this.f1690d.get() == f1688b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        void c(a<T> aVar) {
            a<T>[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = this.f1690d.get();
                int length = aVarArr.length;
                if (length == 0) {
                    return;
                }
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (aVarArr[i2].equals(aVar)) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    aVarArr2 = f1687a;
                } else {
                    a[] aVarArr3 = new a[length - 1];
                    System.arraycopy(aVarArr, 0, aVarArr3, 0, i);
                    System.arraycopy(aVarArr, i + 1, aVarArr3, i, (length - i) - 1);
                    aVarArr2 = aVarArr3;
                }
            } while (!this.f1690d.compareAndSet(aVarArr, aVarArr2));
        }

        @Override // c.a.m.b
        public void dispose() {
            AtomicReference<a<T>[]> atomicReference = this.f1690d;
            a<T>[] aVarArr = f1688b;
            if (atomicReference.getAndSet(aVarArr) != aVarArr) {
                this.f1689c.compareAndSet(this, null);
                c.a.p.a.c.dispose(this.f);
            }
        }

        @Override // c.a.i
        public void onComplete() {
            this.f1689c.compareAndSet(this, null);
            for (a<T> aVar : this.f1690d.getAndSet(f1688b)) {
                aVar.f1686a.onComplete();
            }
        }

        @Override // c.a.i
        public void onError(Throwable th) {
            this.f1689c.compareAndSet(this, null);
            a<T>[] andSet = this.f1690d.getAndSet(f1688b);
            if (andSet.length != 0) {
                for (a<T> aVar : andSet) {
                    aVar.f1686a.onError(th);
                }
                return;
            }
            c.a.s.a.m(th);
        }

        @Override // c.a.i
        public void onNext(T t) {
            for (a<T> aVar : this.f1690d.get()) {
                aVar.f1686a.onNext(t);
            }
        }

        @Override // c.a.i
        public void onSubscribe(c.a.m.b bVar) {
            c.a.p.a.c.setOnce(this.f, bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservablePublish.java */
    /* loaded from: classes.dex */
    public static final class c<T> implements c.a.h<T> {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicReference<b<T>> f1691a;

        c(AtomicReference<b<T>> atomicReference) {
            this.f1691a = atomicReference;
        }

        @Override // c.a.h
        public void a(c.a.i<? super T> iVar) {
            a aVar = new a(iVar);
            iVar.onSubscribe(aVar);
            while (true) {
                b<T> bVar = this.f1691a.get();
                if (bVar == null || bVar.b()) {
                    b<T> bVar2 = new b<>(this.f1691a);
                    if (this.f1691a.compareAndSet(bVar, bVar2)) {
                        bVar = bVar2;
                    } else {
                        continue;
                    }
                }
                if (bVar.a(aVar)) {
                    aVar.a(bVar);
                    return;
                }
            }
        }
    }

    private m(c.a.h<T> hVar, c.a.h<T> hVar2, AtomicReference<b<T>> atomicReference) {
        this.f1685c = hVar;
        this.f1683a = hVar2;
        this.f1684b = atomicReference;
    }

    public static <T> c.a.q.a<T> E(c.a.h<T> hVar) {
        AtomicReference atomicReference = new AtomicReference();
        return c.a.s.a.k(new m(new c(atomicReference), hVar, atomicReference));
    }

    @Override // c.a.q.a
    public void C(c.a.o.e<? super c.a.m.b> eVar) {
        b<T> bVar;
        while (true) {
            bVar = this.f1684b.get();
            if (bVar != null && !bVar.b()) {
                break;
            }
            b<T> bVar2 = new b<>(this.f1684b);
            if (this.f1684b.compareAndSet(bVar, bVar2)) {
                bVar = bVar2;
                break;
            }
        }
        boolean z = true;
        if (bVar.e.get() || !bVar.e.compareAndSet(false, true)) {
            z = false;
        }
        try {
            eVar.accept(bVar);
            if (z) {
                this.f1683a.a(bVar);
            }
        } catch (Throwable th) {
            c.a.n.b.b(th);
            throw c.a.p.h.d.c(th);
        }
    }

    @Override // c.a.e
    protected void w(c.a.i<? super T> iVar) {
        this.f1685c.a(iVar);
    }
}
