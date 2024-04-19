package b.a.a.b.a;

import b.a.a.d;
import b.a.a.p;
import b.a.a.r;
import b.a.a.t;
import b.a.a.u;
import b.a.a.v;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
/* compiled from: MapTypeAdapterFactory.java */
/* loaded from: classes.dex */
public final class f implements u {

    /* renamed from: a  reason: collision with root package name */
    private final b.a.a.b.e f912a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f913b;

    /* compiled from: MapTypeAdapterFactory.java */
    /* loaded from: classes.dex */
    private final class a<K, V> extends t<Map<K, V>> {

        /* renamed from: a  reason: collision with root package name */
        private final t<K> f914a;

        /* renamed from: b  reason: collision with root package name */
        private final t<V> f915b;

        /* renamed from: c  reason: collision with root package name */
        private final b.a.a.b.i<? extends Map<K, V>> f916c;

        public a(b.a.a.h hVar, Type type, t<K> tVar, Type type2, t<V> tVar2, b.a.a.b.i<? extends Map<K, V>> iVar) {
            this.f914a = new k(hVar, tVar, type);
            this.f915b = new k(hVar, tVar2, type2);
            this.f916c = iVar;
        }

        private String f(v vVar) {
            if (!vVar.d()) {
                if (vVar.c()) {
                    return "null";
                }
                throw new AssertionError();
            }
            p g = vVar.g();
            if (g.s()) {
                return String.valueOf(g.m());
            }
            if (g.j()) {
                return Boolean.toString(g.q());
            }
            if (g.t()) {
                return g.l();
            }
            throw new AssertionError();
        }

        @Override // b.a.a.t
        /* renamed from: d */
        public Map<K, V> c(d.f fVar) throws IOException {
            d.g E = fVar.E();
            if (E == d.g.NULL) {
                fVar.H();
                return null;
            }
            Map<K, V> O000000o = this.f916c.O000000o();
            if (E == d.g.BEGIN_ARRAY) {
                fVar.n();
                while (fVar.D()) {
                    fVar.n();
                    K c2 = this.f914a.c(fVar);
                    if (O000000o.put(c2, this.f915b.c(fVar)) != null) {
                        throw new r("duplicate key: " + c2);
                    }
                    fVar.w();
                }
                fVar.w();
            } else {
                fVar.B();
                while (fVar.D()) {
                    b.a.a.b.f.f993a.a(fVar);
                    K c3 = this.f914a.c(fVar);
                    if (O000000o.put(c3, this.f915b.c(fVar)) != null) {
                        throw new r("duplicate key: " + c3);
                    }
                }
                fVar.z();
            }
            return O000000o;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // b.a.a.t
        /* renamed from: e */
        public void a(d.h hVar, Map<K, V> map) throws IOException {
            if (map == null) {
                hVar.F();
            } else if (!f.this.f913b) {
                hVar.x();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    hVar.q(String.valueOf(entry.getKey()));
                    this.f915b.a(hVar, entry.getValue());
                }
                hVar.D();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                int i = 0;
                boolean z = false;
                for (Map.Entry<K, V> entry2 : map.entrySet()) {
                    v b2 = this.f914a.b(entry2.getKey());
                    arrayList.add(b2);
                    arrayList2.add(entry2.getValue());
                    z |= b2.b() || b2.a();
                }
                if (!z) {
                    hVar.x();
                    while (i < arrayList.size()) {
                        hVar.q(f((v) arrayList.get(i)));
                        this.f915b.a(hVar, arrayList2.get(i));
                        i++;
                    }
                    hVar.D();
                    return;
                }
                hVar.t();
                while (i < arrayList.size()) {
                    hVar.t();
                    b.a.a.b.k.b((v) arrayList.get(i), hVar);
                    this.f915b.a(hVar, arrayList2.get(i));
                    hVar.A();
                    i++;
                }
                hVar.A();
            }
        }
    }

    public f(b.a.a.b.e eVar, boolean z) {
        this.f912a = eVar;
        this.f913b = z;
    }

    private t<?> b(b.a.a.h hVar, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? l.f : hVar.b(b.a.a.e.a.c(type));
    }

    @Override // b.a.a.u
    public <T> t<T> a(b.a.a.h hVar, b.a.a.e.a<T> aVar) {
        Type d2 = aVar.d();
        if (Map.class.isAssignableFrom(aVar.a())) {
            Type[] o = b.a.a.b.c.o(d2, b.a.a.b.c.r(d2));
            return new a(hVar, o[0], b(hVar, o[0]), o[1], hVar.b(b.a.a.e.a.c(o[1])), this.f912a.a(aVar));
        }
        return null;
    }
}
