package a.b.c.f;
/* compiled from: LongSparseArray.java */
/* loaded from: classes.dex */
public class d<E> implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f290a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private boolean f291b;

    /* renamed from: c  reason: collision with root package name */
    private long[] f292c;

    /* renamed from: d  reason: collision with root package name */
    private Object[] f293d;
    private int e;

    public d() {
        this(10);
    }

    private void d() {
        int i = this.e;
        long[] jArr = this.f292c;
        Object[] objArr = this.f293d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f290a) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f291b = false;
        this.e = i2;
    }

    public void a() {
        int i = this.e;
        Object[] objArr = this.f293d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.e = 0;
        this.f291b = false;
    }

    /* renamed from: b */
    public d<E> clone() {
        d<E> dVar = null;
        try {
            d<E> dVar2 = (d) super.clone();
            try {
                dVar2.f292c = (long[]) this.f292c.clone();
                dVar2.f293d = (Object[]) this.f293d.clone();
                return dVar2;
            } catch (CloneNotSupportedException unused) {
                dVar = dVar2;
                return dVar;
            }
        } catch (CloneNotSupportedException unused2) {
        }
    }

    public void c(long j) {
        int b2 = c.b(this.f292c, this.e, j);
        if (b2 >= 0) {
            Object[] objArr = this.f293d;
            Object obj = objArr[b2];
            Object obj2 = f290a;
            if (obj != obj2) {
                objArr[b2] = obj2;
                this.f291b = true;
            }
        }
    }

    public E e(long j) {
        return f(j, null);
    }

    public E f(long j, E e) {
        int b2 = c.b(this.f292c, this.e, j);
        if (b2 >= 0) {
            Object[] objArr = this.f293d;
            if (objArr[b2] != f290a) {
                return (E) objArr[b2];
            }
        }
        return e;
    }

    public long g(int i) {
        if (this.f291b) {
            d();
        }
        return this.f292c[i];
    }

    public void h(long j, E e) {
        int b2 = c.b(this.f292c, this.e, j);
        if (b2 >= 0) {
            this.f293d[b2] = e;
            return;
        }
        int i = ~b2;
        int i2 = this.e;
        if (i < i2) {
            Object[] objArr = this.f293d;
            if (objArr[i] == f290a) {
                this.f292c[i] = j;
                objArr[i] = e;
                return;
            }
        }
        if (this.f291b && i2 >= this.f292c.length) {
            d();
            i = ~c.b(this.f292c, this.e, j);
        }
        int i3 = this.e;
        if (i3 >= this.f292c.length) {
            int f = c.f(i3 + 1);
            long[] jArr = new long[f];
            Object[] objArr2 = new Object[f];
            long[] jArr2 = this.f292c;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f293d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f292c = jArr;
            this.f293d = objArr2;
        }
        int i4 = this.e;
        if (i4 - i != 0) {
            long[] jArr3 = this.f292c;
            int i5 = i + 1;
            System.arraycopy(jArr3, i, jArr3, i5, i4 - i);
            Object[] objArr4 = this.f293d;
            System.arraycopy(objArr4, i, objArr4, i5, this.e - i);
        }
        this.f292c[i] = j;
        this.f293d[i] = e;
        this.e++;
    }

    public void i(int i) {
        Object[] objArr = this.f293d;
        Object obj = objArr[i];
        Object obj2 = f290a;
        if (obj != obj2) {
            objArr[i] = obj2;
            this.f291b = true;
        }
    }

    public int j() {
        if (this.f291b) {
            d();
        }
        return this.e;
    }

    public E k(int i) {
        if (this.f291b) {
            d();
        }
        return (E) this.f293d[i];
    }

    public String toString() {
        if (j() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.e * 28);
        sb.append('{');
        for (int i = 0; i < this.e; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(g(i));
            sb.append('=');
            E k = k(i);
            if (k != this) {
                sb.append(k);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public d(int i) {
        this.f291b = false;
        if (i == 0) {
            this.f292c = c.f288b;
            this.f293d = c.f289c;
        } else {
            int f = c.f(i);
            this.f292c = new long[f];
            this.f293d = new Object[f];
        }
        this.e = 0;
    }
}
