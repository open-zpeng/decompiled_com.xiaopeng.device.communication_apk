package a.a.a.b;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
/* compiled from: SafeIterableMap.java */
/* loaded from: classes.dex */
public class a<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: a  reason: collision with root package name */
    private b<K, V> f143a;

    /* renamed from: b  reason: collision with root package name */
    private b<K, V> f144b;

    /* renamed from: c  reason: collision with root package name */
    private WeakHashMap<d<K, V>, Boolean> f145c = new WeakHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private int f146d = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SafeIterableMap.java */
    /* renamed from: a.a.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0001a<K, V> extends c<K, V> {
        C0001a(b<K, V> bVar, b<K, V> bVar2) {
            super(bVar, bVar2);
        }

        @Override // a.a.a.b.a.c
        b<K, V> b(b<K, V> bVar) {
            return bVar.f150d;
        }

        @Override // a.a.a.b.a.c
        b<K, V> c(b<K, V> bVar) {
            return bVar.f149c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SafeIterableMap.java */
    /* loaded from: classes.dex */
    public static class b<K, V> implements Map.Entry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        final K f147a;

        /* renamed from: b  reason: collision with root package name */
        final V f148b;

        /* renamed from: c  reason: collision with root package name */
        b<K, V> f149c;

        /* renamed from: d  reason: collision with root package name */
        b<K, V> f150d;

        b(K k, V v) {
            this.f147a = k;
            this.f148b = v;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof b) {
                b bVar = (b) obj;
                return this.f147a.equals(bVar.f147a) && this.f148b.equals(bVar.f148b);
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f147a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f148b;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f147a + "=" + this.f148b;
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* loaded from: classes.dex */
    private static abstract class c<K, V> implements Iterator<Map.Entry<K, V>>, d<K, V> {

        /* renamed from: a  reason: collision with root package name */
        b<K, V> f151a;

        /* renamed from: b  reason: collision with root package name */
        b<K, V> f152b;

        c(b<K, V> bVar, b<K, V> bVar2) {
            this.f151a = bVar2;
            this.f152b = bVar;
        }

        private b<K, V> e() {
            b<K, V> bVar = this.f152b;
            b<K, V> bVar2 = this.f151a;
            if (bVar == bVar2 || bVar2 == null) {
                return null;
            }
            return c(bVar);
        }

        @Override // a.a.a.b.a.d
        public void a(b<K, V> bVar) {
            if (this.f151a == bVar && bVar == this.f152b) {
                this.f152b = null;
                this.f151a = null;
            }
            b<K, V> bVar2 = this.f151a;
            if (bVar2 == bVar) {
                this.f151a = b(bVar2);
            }
            if (this.f152b == bVar) {
                this.f152b = e();
            }
        }

        abstract b<K, V> b(b<K, V> bVar);

        abstract b<K, V> c(b<K, V> bVar);

        @Override // java.util.Iterator
        /* renamed from: d */
        public Map.Entry<K, V> next() {
            b<K, V> bVar = this.f152b;
            this.f152b = e();
            return bVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f152b != null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SafeIterableMap.java */
    /* loaded from: classes.dex */
    public interface d<K, V> {
        void a(b<K, V> bVar);
    }

    protected b<K, V> a(K k) {
        b<K, V> bVar = this.f143a;
        while (bVar != null && !bVar.f147a.equals(k)) {
            bVar = bVar.f149c;
        }
        return bVar;
    }

    protected b<K, V> b(K k, V v) {
        b<K, V> bVar = new b<>(k, v);
        this.f146d++;
        b<K, V> bVar2 = this.f144b;
        if (bVar2 == null) {
            this.f143a = bVar;
            this.f144b = bVar;
            return bVar;
        }
        bVar2.f149c = bVar;
        bVar.f150d = bVar2;
        this.f144b = bVar;
        return bVar;
    }

    public V c(K k, V v) {
        b<K, V> a2 = a(k);
        if (a2 != null) {
            return a2.f148b;
        }
        b(k, v);
        return null;
    }

    public V d(K k) {
        b<K, V> a2 = a(k);
        if (a2 == null) {
            return null;
        }
        this.f146d--;
        if (!this.f145c.isEmpty()) {
            for (d<K, V> dVar : this.f145c.keySet()) {
                dVar.a(a2);
            }
        }
        b<K, V> bVar = a2.f150d;
        if (bVar != null) {
            bVar.f149c = a2.f149c;
        } else {
            this.f143a = a2.f149c;
        }
        b<K, V> bVar2 = a2.f149c;
        if (bVar2 != null) {
            bVar2.f150d = bVar;
        } else {
            this.f144b = bVar;
        }
        a2.f149c = null;
        a2.f150d = null;
        return a2.f148b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (size() != aVar.size()) {
                return false;
            }
            Iterator<Map.Entry<K, V>> it = iterator();
            Iterator<Map.Entry<K, V>> it2 = aVar.iterator();
            while (it.hasNext() && it2.hasNext()) {
                Map.Entry<K, V> next = it.next();
                Map.Entry<K, V> next2 = it2.next();
                if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                    return false;
                }
            }
            return (it.hasNext() || it2.hasNext()) ? false : true;
        }
        return false;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        C0001a c0001a = new C0001a(this.f143a, this.f144b);
        this.f145c.put(c0001a, Boolean.FALSE);
        return c0001a;
    }

    public int size() {
        return this.f146d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
