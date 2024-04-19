package a.b.c.f;

import java.util.ConcurrentModificationException;
import java.util.Map;
/* compiled from: SimpleArrayMap.java */
/* loaded from: classes.dex */
public class i<K, V> {

    /* renamed from: a  reason: collision with root package name */
    static Object[] f314a;

    /* renamed from: b  reason: collision with root package name */
    static int f315b;

    /* renamed from: c  reason: collision with root package name */
    static Object[] f316c;

    /* renamed from: d  reason: collision with root package name */
    static int f317d;
    int[] e;
    Object[] f;
    int g;

    public i() {
        this.e = c.f287a;
        this.f = c.f289c;
        this.g = 0;
    }

    private void a(int i) {
        if (i == 8) {
            synchronized (a.class) {
                Object[] objArr = f316c;
                if (objArr != null) {
                    this.f = objArr;
                    f316c = (Object[]) objArr[0];
                    this.e = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f317d--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (a.class) {
                Object[] objArr2 = f314a;
                if (objArr2 != null) {
                    this.f = objArr2;
                    f314a = (Object[]) objArr2[0];
                    this.e = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f315b--;
                    return;
                }
            }
        }
        this.e = new int[i];
        this.f = new Object[i << 1];
    }

    private static int b(int[] iArr, int i, int i2) {
        try {
            return c.a(iArr, i, i2);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    private static void d(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (a.class) {
                if (f317d < 10) {
                    objArr[0] = f316c;
                    objArr[1] = iArr;
                    for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f316c = objArr;
                    f317d++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (a.class) {
                if (f315b < 10) {
                    objArr[0] = f314a;
                    objArr[1] = iArr;
                    for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f314a = objArr;
                    f315b++;
                }
            }
        }
    }

    public void c(int i) {
        int i2 = this.g;
        int[] iArr = this.e;
        if (iArr.length < i) {
            Object[] objArr = this.f;
            a(i);
            if (this.g > 0) {
                System.arraycopy(iArr, 0, this.e, 0, i2);
                System.arraycopy(objArr, 0, this.f, 0, i2 << 1);
            }
            d(iArr, objArr, i2);
        }
        if (this.g != i2) {
            throw new ConcurrentModificationException();
        }
    }

    public void clear() {
        int i = this.g;
        if (i > 0) {
            int[] iArr = this.e;
            Object[] objArr = this.f;
            this.e = c.f287a;
            this.f = c.f289c;
            this.g = 0;
            d(iArr, objArr, i);
        }
        if (this.g > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return f(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return h(obj) >= 0;
    }

    int e(Object obj, int i) {
        int i2 = this.g;
        if (i2 == 0) {
            return -1;
        }
        int b2 = b(this.e, i2, i);
        if (b2 >= 0 && !obj.equals(this.f[b2 << 1])) {
            int i3 = b2 + 1;
            while (i3 < i2 && this.e[i3] == i) {
                if (obj.equals(this.f[i3 << 1])) {
                    return i3;
                }
                i3++;
            }
            for (int i4 = b2 - 1; i4 >= 0 && this.e[i4] == i; i4--) {
                if (obj.equals(this.f[i4 << 1])) {
                    return i4;
                }
            }
            return ~i3;
        }
        return b2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            if (size() != iVar.size()) {
                return false;
            }
            for (int i = 0; i < this.g; i++) {
                try {
                    K i2 = i(i);
                    V l = l(i);
                    Object obj2 = iVar.get(i2);
                    if (l == null) {
                        if (obj2 != null || !iVar.containsKey(i2)) {
                            return false;
                        }
                    } else if (!l.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            for (int i3 = 0; i3 < this.g; i3++) {
                try {
                    K i4 = i(i3);
                    V l2 = l(i3);
                    Object obj3 = map.get(i4);
                    if (l2 == null) {
                        if (obj3 != null || !map.containsKey(i4)) {
                            return false;
                        }
                    } else if (!l2.equals(obj3)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public int f(Object obj) {
        return obj == null ? g() : e(obj, obj.hashCode());
    }

    int g() {
        int i = this.g;
        if (i == 0) {
            return -1;
        }
        int b2 = b(this.e, i, 0);
        if (b2 >= 0 && this.f[b2 << 1] != null) {
            int i2 = b2 + 1;
            while (i2 < i && this.e[i2] == 0) {
                if (this.f[i2 << 1] == null) {
                    return i2;
                }
                i2++;
            }
            for (int i3 = b2 - 1; i3 >= 0 && this.e[i3] == 0; i3--) {
                if (this.f[i3 << 1] == null) {
                    return i3;
                }
            }
            return ~i2;
        }
        return b2;
    }

    public V get(Object obj) {
        int f = f(obj);
        if (f >= 0) {
            return (V) this.f[(f << 1) + 1];
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h(Object obj) {
        int i = this.g * 2;
        Object[] objArr = this.f;
        if (obj == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
            return -1;
        }
        for (int i3 = 1; i3 < i; i3 += 2) {
            if (obj.equals(objArr[i3])) {
                return i3 >> 1;
            }
        }
        return -1;
    }

    public int hashCode() {
        int[] iArr = this.e;
        Object[] objArr = this.f;
        int i = this.g;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return i4;
    }

    public K i(int i) {
        return (K) this.f[i << 1];
    }

    public boolean isEmpty() {
        return this.g <= 0;
    }

    public V j(int i) {
        Object[] objArr = this.f;
        int i2 = i << 1;
        V v = (V) objArr[i2 + 1];
        int i3 = this.g;
        int i4 = 0;
        if (i3 <= 1) {
            d(this.e, objArr, i3);
            this.e = c.f287a;
            this.f = c.f289c;
        } else {
            int i5 = i3 - 1;
            int[] iArr = this.e;
            if (iArr.length > 8 && i3 < iArr.length / 3) {
                a(i3 > 8 ? i3 + (i3 >> 1) : 8);
                if (i3 != this.g) {
                    throw new ConcurrentModificationException();
                }
                if (i > 0) {
                    System.arraycopy(iArr, 0, this.e, 0, i);
                    System.arraycopy(objArr, 0, this.f, 0, i2);
                }
                if (i < i5) {
                    int i6 = i + 1;
                    int i7 = i5 - i;
                    System.arraycopy(iArr, i6, this.e, i, i7);
                    System.arraycopy(objArr, i6 << 1, this.f, i2, i7 << 1);
                }
            } else {
                if (i < i5) {
                    int i8 = i + 1;
                    int i9 = i5 - i;
                    System.arraycopy(iArr, i8, iArr, i, i9);
                    Object[] objArr2 = this.f;
                    System.arraycopy(objArr2, i8 << 1, objArr2, i2, i9 << 1);
                }
                Object[] objArr3 = this.f;
                int i10 = i5 << 1;
                objArr3[i10] = null;
                objArr3[i10 + 1] = null;
            }
            i4 = i5;
        }
        if (i3 == this.g) {
            this.g = i4;
            return v;
        }
        throw new ConcurrentModificationException();
    }

    public V k(int i, V v) {
        int i2 = (i << 1) + 1;
        Object[] objArr = this.f;
        V v2 = (V) objArr[i2];
        objArr[i2] = v;
        return v2;
    }

    public V l(int i) {
        return (V) this.f[(i << 1) + 1];
    }

    public V put(K k, V v) {
        int i;
        int e;
        int i2 = this.g;
        if (k == null) {
            e = g();
            i = 0;
        } else {
            int hashCode = k.hashCode();
            i = hashCode;
            e = e(k, hashCode);
        }
        if (e >= 0) {
            int i3 = (e << 1) + 1;
            Object[] objArr = this.f;
            V v2 = (V) objArr[i3];
            objArr[i3] = v;
            return v2;
        }
        int i4 = ~e;
        int[] iArr = this.e;
        if (i2 >= iArr.length) {
            int i5 = 4;
            if (i2 >= 8) {
                i5 = (i2 >> 1) + i2;
            } else if (i2 >= 4) {
                i5 = 8;
            }
            Object[] objArr2 = this.f;
            a(i5);
            if (i2 == this.g) {
                int[] iArr2 = this.e;
                if (iArr2.length > 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                    System.arraycopy(objArr2, 0, this.f, 0, objArr2.length);
                }
                d(iArr, objArr2, i2);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i4 < i2) {
            int[] iArr3 = this.e;
            int i6 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i6, i2 - i4);
            Object[] objArr3 = this.f;
            System.arraycopy(objArr3, i4 << 1, objArr3, i6 << 1, (this.g - i4) << 1);
        }
        int i7 = this.g;
        if (i2 == i7) {
            int[] iArr4 = this.e;
            if (i4 < iArr4.length) {
                iArr4[i4] = i;
                Object[] objArr4 = this.f;
                int i8 = i4 << 1;
                objArr4[i8] = k;
                objArr4[i8 + 1] = v;
                this.g = i7 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public V remove(Object obj) {
        int f = f(obj);
        if (f >= 0) {
            return j(f);
        }
        return null;
    }

    public int size() {
        return this.g;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.g * 28);
        sb.append('{');
        for (int i = 0; i < this.g; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            K i2 = i(i);
            if (i2 != this) {
                sb.append(i2);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V l = l(i);
            if (l != this) {
                sb.append(l);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public i(int i) {
        if (i == 0) {
            this.e = c.f287a;
            this.f = c.f289c;
        } else {
            a(i);
        }
        this.g = 0;
    }
}
