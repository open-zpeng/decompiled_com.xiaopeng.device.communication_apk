package a.b.c.f;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
/* compiled from: ArrayMap.java */
/* loaded from: classes.dex */
public class a<K, V> extends i<K, V> implements Map<K, V> {
    f<K, V> h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ArrayMap.java */
    /* renamed from: a.b.c.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0013a extends f<K, V> {
        C0013a() {
        }

        @Override // a.b.c.f.f
        protected void a() {
            a.this.clear();
        }

        @Override // a.b.c.f.f
        protected Object b(int i, int i2) {
            return a.this.f[(i << 1) + i2];
        }

        @Override // a.b.c.f.f
        protected Map<K, V> c() {
            return a.this;
        }

        @Override // a.b.c.f.f
        protected int d() {
            return a.this.g;
        }

        @Override // a.b.c.f.f
        protected int e(Object obj) {
            return a.this.f(obj);
        }

        @Override // a.b.c.f.f
        protected int f(Object obj) {
            return a.this.h(obj);
        }

        @Override // a.b.c.f.f
        protected void g(K k, V v) {
            a.this.put(k, v);
        }

        @Override // a.b.c.f.f
        protected void h(int i) {
            a.this.j(i);
        }

        @Override // a.b.c.f.f
        protected V i(int i, V v) {
            return a.this.k(i, v);
        }
    }

    public a() {
    }

    private f<K, V> m() {
        if (this.h == null) {
            this.h = new C0013a();
        }
        return this.h;
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return m().l();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return m().m();
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        c(this.g + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return m().n();
    }

    public a(int i) {
        super(i);
    }
}
