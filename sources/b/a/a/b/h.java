package b.a.a.b;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
/* compiled from: LinkedTreeMap.java */
/* loaded from: classes.dex */
public final class h<K, V> extends AbstractMap<K, V> implements Serializable {

    /* renamed from: c  reason: collision with root package name */
    Comparator<? super K> f997c;

    /* renamed from: d  reason: collision with root package name */
    e<K, V> f998d;
    int e;
    int f;
    final e<K, V> g;
    private h<K, V>.b h;
    private h<K, V>.c i;

    /* renamed from: b  reason: collision with root package name */
    static final /* synthetic */ boolean f996b = true;

    /* renamed from: a  reason: collision with root package name */
    private static final Comparator<Comparable> f995a = new a();

    /* compiled from: LinkedTreeMap.java */
    /* loaded from: classes.dex */
    static class a implements Comparator<Comparable> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    /* compiled from: LinkedTreeMap.java */
    /* loaded from: classes.dex */
    class b extends AbstractSet<Map.Entry<K, V>> {

        /* compiled from: LinkedTreeMap.java */
        /* loaded from: classes.dex */
        class a extends h<K, V>.d<Map.Entry<K, V>> {
            a() {
                super(h.this, null);
            }

            @Override // java.util.Iterator
            /* renamed from: b */
            public Map.Entry<K, V> next() {
                return a();
            }
        }

        b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            h.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && h.this.c((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            e<K, V> c2;
            if ((obj instanceof Map.Entry) && (c2 = h.this.c((Map.Entry) obj)) != null) {
                h.this.f(c2, true);
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h.this.e;
        }
    }

    /* compiled from: LinkedTreeMap.java */
    /* loaded from: classes.dex */
    class c extends AbstractSet<K> {

        /* compiled from: LinkedTreeMap.java */
        /* loaded from: classes.dex */
        class a extends h<K, V>.d<K> {
            a() {
                super(h.this, null);
            }

            @Override // java.util.Iterator
            public K next() {
                return a().f;
            }
        }

        c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            h.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return h.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return h.this.h(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h.this.e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LinkedTreeMap.java */
    /* loaded from: classes.dex */
    public abstract class d<T> implements Iterator<T> {

        /* renamed from: a  reason: collision with root package name */
        e<K, V> f1001a;

        /* renamed from: b  reason: collision with root package name */
        e<K, V> f1002b;

        /* renamed from: c  reason: collision with root package name */
        int f1003c;

        private d() {
            this.f1001a = h.this.g.f1008d;
            this.f1002b = null;
            this.f1003c = h.this.f;
        }

        /* synthetic */ d(h hVar, a aVar) {
            this();
        }

        final e<K, V> a() {
            e<K, V> eVar = this.f1001a;
            h hVar = h.this;
            if (eVar != hVar.g) {
                if (hVar.f == this.f1003c) {
                    this.f1001a = eVar.f1008d;
                    this.f1002b = eVar;
                    return eVar;
                }
                throw new ConcurrentModificationException();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f1001a != h.this.g;
        }

        @Override // java.util.Iterator
        public final void remove() {
            e<K, V> eVar = this.f1002b;
            if (eVar == null) {
                throw new IllegalStateException();
            }
            h.this.f(eVar, true);
            this.f1002b = null;
            this.f1003c = h.this.f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LinkedTreeMap.java */
    /* loaded from: classes.dex */
    public static final class e<K, V> implements Map.Entry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        e<K, V> f1005a;

        /* renamed from: b  reason: collision with root package name */
        e<K, V> f1006b;

        /* renamed from: c  reason: collision with root package name */
        e<K, V> f1007c;

        /* renamed from: d  reason: collision with root package name */
        e<K, V> f1008d;
        e<K, V> e;
        final K f;
        V g;
        int h;

        e() {
            this.f = null;
            this.e = this;
            this.f1008d = this;
        }

        e(e<K, V> eVar, K k, e<K, V> eVar2, e<K, V> eVar3) {
            this.f1005a = eVar;
            this.f = k;
            this.h = 1;
            this.f1008d = eVar2;
            this.e = eVar3;
            eVar3.f1008d = this;
            eVar2.e = this;
        }

        public e<K, V> a() {
            e<K, V> eVar = this;
            for (e<K, V> eVar2 = this.f1006b; eVar2 != null; eVar2 = eVar2.f1006b) {
                eVar = eVar2;
            }
            return eVar;
        }

        public e<K, V> b() {
            e<K, V> eVar = this;
            for (e<K, V> eVar2 = this.f1007c; eVar2 != null; eVar2 = eVar2.f1007c) {
                eVar = eVar2;
            }
            return eVar;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                K k = this.f;
                if (k == null) {
                    if (entry.getKey() != null) {
                        return false;
                    }
                } else if (!k.equals(entry.getKey())) {
                    return false;
                }
                V v = this.g;
                Object value = entry.getValue();
                if (v == null) {
                    if (value != null) {
                        return false;
                    }
                } else if (!v.equals(value)) {
                    return false;
                }
                return true;
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.g;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k = this.f;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.g;
            return hashCode ^ (v != null ? v.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.g;
            this.g = v;
            return v2;
        }

        public String toString() {
            return this.f + "=" + this.g;
        }
    }

    public h() {
        this(f995a);
    }

    public h(Comparator<? super K> comparator) {
        this.e = 0;
        this.f = 0;
        this.g = new e<>();
        this.f997c = comparator == null ? f995a : comparator;
    }

    private void d(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.f1006b;
        e<K, V> eVar3 = eVar.f1007c;
        e<K, V> eVar4 = eVar3.f1006b;
        e<K, V> eVar5 = eVar3.f1007c;
        eVar.f1007c = eVar4;
        if (eVar4 != null) {
            eVar4.f1005a = eVar;
        }
        e(eVar, eVar3);
        eVar3.f1006b = eVar;
        eVar.f1005a = eVar3;
        int max = Math.max(eVar2 != null ? eVar2.h : 0, eVar4 != null ? eVar4.h : 0) + 1;
        eVar.h = max;
        eVar3.h = Math.max(max, eVar5 != null ? eVar5.h : 0) + 1;
    }

    private void e(e<K, V> eVar, e<K, V> eVar2) {
        e<K, V> eVar3 = eVar.f1005a;
        eVar.f1005a = null;
        if (eVar2 != null) {
            eVar2.f1005a = eVar3;
        }
        if (eVar3 == null) {
            this.f998d = eVar2;
        } else if (eVar3.f1006b == eVar) {
            eVar3.f1006b = eVar2;
        } else if (!f996b && eVar3.f1007c != eVar) {
            throw new AssertionError();
        } else {
            eVar3.f1007c = eVar2;
        }
    }

    private boolean g(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void i(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.f1006b;
        e<K, V> eVar3 = eVar.f1007c;
        e<K, V> eVar4 = eVar2.f1006b;
        e<K, V> eVar5 = eVar2.f1007c;
        eVar.f1006b = eVar5;
        if (eVar5 != null) {
            eVar5.f1005a = eVar;
        }
        e(eVar, eVar2);
        eVar2.f1007c = eVar;
        eVar.f1005a = eVar2;
        int max = Math.max(eVar3 != null ? eVar3.h : 0, eVar5 != null ? eVar5.h : 0) + 1;
        eVar.h = max;
        eVar2.h = Math.max(max, eVar4 != null ? eVar4.h : 0) + 1;
    }

    private void j(e<K, V> eVar, boolean z) {
        while (eVar != null) {
            e<K, V> eVar2 = eVar.f1006b;
            e<K, V> eVar3 = eVar.f1007c;
            int i = eVar2 != null ? eVar2.h : 0;
            int i2 = eVar3 != null ? eVar3.h : 0;
            int i3 = i - i2;
            if (i3 == -2) {
                e<K, V> eVar4 = eVar3.f1006b;
                e<K, V> eVar5 = eVar3.f1007c;
                int i4 = (eVar4 != null ? eVar4.h : 0) - (eVar5 != null ? eVar5.h : 0);
                if (i4 != -1 && (i4 != 0 || z)) {
                    if (!f996b && i4 != 1) {
                        throw new AssertionError();
                    }
                    i(eVar3);
                }
                d(eVar);
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                e<K, V> eVar6 = eVar2.f1006b;
                e<K, V> eVar7 = eVar2.f1007c;
                int i5 = (eVar6 != null ? eVar6.h : 0) - (eVar7 != null ? eVar7.h : 0);
                if (i5 != 1 && (i5 != 0 || z)) {
                    if (!f996b && i5 != -1) {
                        throw new AssertionError();
                    }
                    d(eVar2);
                }
                i(eVar);
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                eVar.h = i + 1;
                if (z) {
                    return;
                }
            } else if (!f996b && i3 != -1 && i3 != 1) {
                throw new AssertionError();
            } else {
                eVar.h = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            }
            eVar = eVar.f1005a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    e<K, V> a(Object obj) {
        if (obj != 0) {
            try {
                return b(obj, false);
            } catch (ClassCastException unused) {
                return null;
            }
        }
        return null;
    }

    e<K, V> b(K k, boolean z) {
        int i;
        e<K, V> eVar;
        Comparator<? super K> comparator = this.f997c;
        e<K, V> eVar2 = this.f998d;
        if (eVar2 != null) {
            Comparable comparable = comparator == f995a ? (Comparable) k : null;
            while (true) {
                Object obj = (K) eVar2.f;
                i = comparable != null ? comparable.compareTo(obj) : comparator.compare(k, obj);
                if (i == 0) {
                    return eVar2;
                }
                e<K, V> eVar3 = i < 0 ? eVar2.f1006b : eVar2.f1007c;
                if (eVar3 == null) {
                    break;
                }
                eVar2 = eVar3;
            }
        } else {
            i = 0;
        }
        if (z) {
            e<K, V> eVar4 = this.g;
            if (eVar2 != null) {
                eVar = new e<>(eVar2, k, eVar4, eVar4.e);
                if (i < 0) {
                    eVar2.f1006b = eVar;
                } else {
                    eVar2.f1007c = eVar;
                }
                j(eVar2, true);
            } else if (comparator == f995a && !(k instanceof Comparable)) {
                throw new ClassCastException(k.getClass().getName() + " is not Comparable");
            } else {
                eVar = new e<>(eVar2, k, eVar4, eVar4.e);
                this.f998d = eVar;
            }
            this.e++;
            this.f++;
            return eVar;
        }
        return null;
    }

    e<K, V> c(Map.Entry<?, ?> entry) {
        e<K, V> a2 = a(entry.getKey());
        if (a2 != null && g(a2.g, entry.getValue())) {
            return a2;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.f998d = null;
        this.e = 0;
        this.f++;
        e<K, V> eVar = this.g;
        eVar.e = eVar;
        eVar.f1008d = eVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return a(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        h<K, V>.b bVar = this.h;
        if (bVar != null) {
            return bVar;
        }
        h<K, V>.b bVar2 = new b();
        this.h = bVar2;
        return bVar2;
    }

    void f(e<K, V> eVar, boolean z) {
        int i;
        if (z) {
            e<K, V> eVar2 = eVar.e;
            eVar2.f1008d = eVar.f1008d;
            eVar.f1008d.e = eVar2;
        }
        e<K, V> eVar3 = eVar.f1006b;
        e<K, V> eVar4 = eVar.f1007c;
        e<K, V> eVar5 = eVar.f1005a;
        int i2 = 0;
        if (eVar3 == null || eVar4 == null) {
            if (eVar3 != null) {
                e(eVar, eVar3);
                eVar.f1006b = null;
            } else if (eVar4 != null) {
                e(eVar, eVar4);
                eVar.f1007c = null;
            } else {
                e(eVar, null);
            }
            j(eVar5, false);
            this.e--;
            this.f++;
            return;
        }
        e<K, V> b2 = eVar3.h > eVar4.h ? eVar3.b() : eVar4.a();
        f(b2, false);
        e<K, V> eVar6 = eVar.f1006b;
        if (eVar6 != null) {
            i = eVar6.h;
            b2.f1006b = eVar6;
            eVar6.f1005a = b2;
            eVar.f1006b = null;
        } else {
            i = 0;
        }
        e<K, V> eVar7 = eVar.f1007c;
        if (eVar7 != null) {
            i2 = eVar7.h;
            b2.f1007c = eVar7;
            eVar7.f1005a = b2;
            eVar.f1007c = null;
        }
        b2.h = Math.max(i, i2) + 1;
        e(eVar, b2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        e<K, V> a2 = a(obj);
        if (a2 != null) {
            return a2.g;
        }
        return null;
    }

    e<K, V> h(Object obj) {
        e<K, V> a2 = a(obj);
        if (a2 != null) {
            f(a2, true);
        }
        return a2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        h<K, V>.c cVar = this.i;
        if (cVar != null) {
            return cVar;
        }
        h<K, V>.c cVar2 = new c();
        this.i = cVar2;
        return cVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        Objects.requireNonNull(k, "key == null");
        e<K, V> b2 = b(k, true);
        V v2 = b2.g;
        b2.g = v;
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        e<K, V> h = h(obj);
        if (h != null) {
            return h.g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.e;
    }
}
