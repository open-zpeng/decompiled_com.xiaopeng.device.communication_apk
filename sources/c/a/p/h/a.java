package c.a.p.h;
/* compiled from: AppendOnlyLinkedArrayList.java */
/* loaded from: classes.dex */
public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    final int f1804a;

    /* renamed from: b  reason: collision with root package name */
    final Object[] f1805b;

    /* renamed from: c  reason: collision with root package name */
    Object[] f1806c;

    /* renamed from: d  reason: collision with root package name */
    int f1807d;

    public a(int i) {
        this.f1804a = i;
        Object[] objArr = new Object[i + 1];
        this.f1805b = objArr;
        this.f1806c = objArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0019, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <U> boolean a(c.a.i<? super U> r5) {
        /*
            r4 = this;
            java.lang.Object[] r0 = r4.f1805b
            int r1 = r4.f1804a
        L4:
            r2 = 0
            if (r0 == 0) goto L1e
        L7:
            if (r2 >= r1) goto L19
            r3 = r0[r2]
            if (r3 != 0) goto Le
            goto L19
        Le:
            boolean r3 = c.a.p.h.e.acceptFull(r3, r5)
            if (r3 == 0) goto L16
            r5 = 1
            return r5
        L16:
            int r2 = r2 + 1
            goto L7
        L19:
            r0 = r0[r1]
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            goto L4
        L1e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: c.a.p.h.a.a(c.a.i):boolean");
    }

    public void b(T t) {
        int i = this.f1804a;
        int i2 = this.f1807d;
        if (i2 == i) {
            Object[] objArr = new Object[i + 1];
            this.f1806c[i] = objArr;
            this.f1806c = objArr;
            i2 = 0;
        }
        this.f1806c[i2] = t;
        this.f1807d = i2 + 1;
    }

    public void c(T t) {
        this.f1805b[0] = t;
    }
}
