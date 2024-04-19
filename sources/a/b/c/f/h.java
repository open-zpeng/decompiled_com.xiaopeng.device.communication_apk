package a.b.c.f;
/* compiled from: Pools.java */
/* loaded from: classes.dex */
public class h<T> implements g<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Object[] f312a;

    /* renamed from: b  reason: collision with root package name */
    private int f313b;

    public h(int i) {
        if (i > 0) {
            this.f312a = new Object[i];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    private boolean c(T t) {
        for (int i = 0; i < this.f313b; i++) {
            if (this.f312a[i] == t) {
                return true;
            }
        }
        return false;
    }

    @Override // a.b.c.f.g
    public boolean a(T t) {
        if (!c(t)) {
            int i = this.f313b;
            Object[] objArr = this.f312a;
            if (i < objArr.length) {
                objArr[i] = t;
                this.f313b = i + 1;
                return true;
            }
            return false;
        }
        throw new IllegalStateException("Already in the pool!");
    }

    @Override // a.b.c.f.g
    public T b() {
        int i = this.f313b;
        if (i > 0) {
            int i2 = i - 1;
            Object[] objArr = this.f312a;
            T t = (T) objArr[i2];
            objArr[i2] = null;
            this.f313b = i - 1;
            return t;
        }
        return null;
    }
}
