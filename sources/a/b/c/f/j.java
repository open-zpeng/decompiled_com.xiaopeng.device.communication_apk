package a.b.c.f;
/* compiled from: SparseArrayCompat.java */
/* loaded from: classes.dex */
public class j<E> implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f318a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private boolean f319b;

    /* renamed from: c  reason: collision with root package name */
    private int[] f320c;

    /* renamed from: d  reason: collision with root package name */
    private Object[] f321d;
    private int e;

    public j() {
        this(10);
    }

    private void c() {
        int i = this.e;
        int[] iArr = this.f320c;
        Object[] objArr = this.f321d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f318a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f319b = false;
        this.e = i2;
    }

    public void a(int i, E e) {
        int i2 = this.e;
        if (i2 != 0 && i <= this.f320c[i2 - 1]) {
            g(i, e);
            return;
        }
        if (this.f319b && i2 >= this.f320c.length) {
            c();
        }
        int i3 = this.e;
        if (i3 >= this.f320c.length) {
            int e2 = c.e(i3 + 1);
            int[] iArr = new int[e2];
            Object[] objArr = new Object[e2];
            int[] iArr2 = this.f320c;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.f321d;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f320c = iArr;
            this.f321d = objArr;
        }
        this.f320c[i3] = i;
        this.f321d[i3] = e;
        this.e = i3 + 1;
    }

    /* renamed from: b */
    public j<E> clone() {
        j<E> jVar = null;
        try {
            j<E> jVar2 = (j) super.clone();
            try {
                jVar2.f320c = (int[]) this.f320c.clone();
                jVar2.f321d = (Object[]) this.f321d.clone();
                return jVar2;
            } catch (CloneNotSupportedException unused) {
                jVar = jVar2;
                return jVar;
            }
        } catch (CloneNotSupportedException unused2) {
        }
    }

    public E d(int i) {
        return e(i, null);
    }

    public E e(int i, E e) {
        int a2 = c.a(this.f320c, this.e, i);
        if (a2 >= 0) {
            Object[] objArr = this.f321d;
            if (objArr[a2] != f318a) {
                return (E) objArr[a2];
            }
        }
        return e;
    }

    public int f(int i) {
        if (this.f319b) {
            c();
        }
        return this.f320c[i];
    }

    public void g(int i, E e) {
        int a2 = c.a(this.f320c, this.e, i);
        if (a2 >= 0) {
            this.f321d[a2] = e;
            return;
        }
        int i2 = ~a2;
        int i3 = this.e;
        if (i2 < i3) {
            Object[] objArr = this.f321d;
            if (objArr[i2] == f318a) {
                this.f320c[i2] = i;
                objArr[i2] = e;
                return;
            }
        }
        if (this.f319b && i3 >= this.f320c.length) {
            c();
            i2 = ~c.a(this.f320c, this.e, i);
        }
        int i4 = this.e;
        if (i4 >= this.f320c.length) {
            int e2 = c.e(i4 + 1);
            int[] iArr = new int[e2];
            Object[] objArr2 = new Object[e2];
            int[] iArr2 = this.f320c;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f321d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f320c = iArr;
            this.f321d = objArr2;
        }
        int i5 = this.e;
        if (i5 - i2 != 0) {
            int[] iArr3 = this.f320c;
            int i6 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i6, i5 - i2);
            Object[] objArr4 = this.f321d;
            System.arraycopy(objArr4, i2, objArr4, i6, this.e - i2);
        }
        this.f320c[i2] = i;
        this.f321d[i2] = e;
        this.e++;
    }

    public int h() {
        if (this.f319b) {
            c();
        }
        return this.e;
    }

    public E i(int i) {
        if (this.f319b) {
            c();
        }
        return (E) this.f321d[i];
    }

    public String toString() {
        if (h() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.e * 28);
        sb.append('{');
        for (int i = 0; i < this.e; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(f(i));
            sb.append('=');
            E i2 = i(i);
            if (i2 != this) {
                sb.append(i2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public j(int i) {
        this.f319b = false;
        if (i == 0) {
            this.f320c = c.f287a;
            this.f321d = c.f289c;
        } else {
            int e = c.e(i);
            this.f320c = new int[e];
            this.f321d = new Object[e];
        }
        this.e = 0;
    }
}
