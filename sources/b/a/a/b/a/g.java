package b.a.a.b.a;

import b.a.a.d;
import b.a.a.r;
import b.a.a.t;
import b.a.a.u;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;
/* compiled from: ReflectiveTypeAdapterFactory.java */
/* loaded from: classes.dex */
public final class g implements u {

    /* renamed from: a  reason: collision with root package name */
    private final b.a.a.b.e f918a;

    /* renamed from: b  reason: collision with root package name */
    private final b.a.a.g f919b;

    /* renamed from: c  reason: collision with root package name */
    private final b.a.a.b.d f920c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReflectiveTypeAdapterFactory.java */
    /* loaded from: classes.dex */
    public class a extends c {

        /* renamed from: d  reason: collision with root package name */
        final t<?> f921d;
        final /* synthetic */ b.a.a.h e;
        final /* synthetic */ b.a.a.e.a f;
        final /* synthetic */ Field g;
        final /* synthetic */ boolean h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, boolean z, boolean z2, b.a.a.h hVar, b.a.a.e.a aVar, Field field, boolean z3) {
            super(str, z, z2);
            this.e = hVar;
            this.f = aVar;
            this.g = field;
            this.h = z3;
            this.f921d = hVar.b(aVar);
        }

        @Override // b.a.a.b.a.g.c
        void a(d.f fVar, Object obj) throws IOException, IllegalAccessException {
            Object c2 = this.f921d.c(fVar);
            if (c2 == null && this.h) {
                return;
            }
            this.g.set(obj, c2);
        }

        @Override // b.a.a.b.a.g.c
        void b(d.h hVar, Object obj) throws IOException, IllegalAccessException {
            new k(this.e, this.f921d, this.f.d()).a(hVar, this.g.get(obj));
        }
    }

    /* compiled from: ReflectiveTypeAdapterFactory.java */
    /* loaded from: classes.dex */
    public static final class b<T> extends t<T> {

        /* renamed from: a  reason: collision with root package name */
        private final b.a.a.b.i<T> f922a;

        /* renamed from: b  reason: collision with root package name */
        private final Map<String, c> f923b;

        private b(b.a.a.b.i<T> iVar, Map<String, c> map) {
            this.f922a = iVar;
            this.f923b = map;
        }

        /* synthetic */ b(b.a.a.b.i iVar, Map map, a aVar) {
            this(iVar, map);
        }

        @Override // b.a.a.t
        public void a(d.h hVar, T t) throws IOException {
            if (t == null) {
                hVar.F();
                return;
            }
            hVar.x();
            try {
                for (c cVar : this.f923b.values()) {
                    if (cVar.f925b) {
                        hVar.q(cVar.f924a);
                        cVar.b(hVar, t);
                    }
                }
                hVar.D();
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            }
        }

        @Override // b.a.a.t
        public T c(d.f fVar) throws IOException {
            if (fVar.E() == d.g.NULL) {
                fVar.H();
                return null;
            }
            T O000000o = this.f922a.O000000o();
            try {
                fVar.B();
                while (fVar.D()) {
                    c cVar = this.f923b.get(fVar.F());
                    if (cVar != null && cVar.f926c) {
                        cVar.a(fVar, O000000o);
                    }
                    fVar.M();
                }
                fVar.z();
                return O000000o;
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (IllegalStateException e2) {
                throw new r(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReflectiveTypeAdapterFactory.java */
    /* loaded from: classes.dex */
    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        final String f924a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f925b;

        /* renamed from: c  reason: collision with root package name */
        final boolean f926c;

        protected c(String str, boolean z, boolean z2) {
            this.f924a = str;
            this.f925b = z;
            this.f926c = z2;
        }

        abstract void a(d.f fVar, Object obj) throws IOException, IllegalAccessException;

        abstract void b(d.h hVar, Object obj) throws IOException, IllegalAccessException;
    }

    public g(b.a.a.b.e eVar, b.a.a.g gVar, b.a.a.b.d dVar) {
        this.f918a = eVar;
        this.f919b = gVar;
        this.f920c = dVar;
    }

    private c b(b.a.a.h hVar, Field field, String str, b.a.a.e.a<?> aVar, boolean z, boolean z2) {
        return new a(str, z, z2, hVar, aVar, field, b.a.a.b.l.c(aVar.a()));
    }

    private String c(Field field) {
        b.a.a.a.b bVar = (b.a.a.a.b) field.getAnnotation(b.a.a.a.b.class);
        return bVar == null ? this.f919b.O000000o(field) : bVar.O000000o();
    }

    private Map<String, c> d(b.a.a.h hVar, b.a.a.e.a<?> aVar, Class<?> cls) {
        Field[] declaredFields;
        c cVar;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type d2 = aVar.d();
        b.a.a.e.a<?> aVar2 = aVar;
        Class<?> cls2 = cls;
        while (cls2 != Object.class) {
            for (Field field : cls2.getDeclaredFields()) {
                boolean e = e(field, true);
                boolean e2 = e(field, false);
                if (e || e2) {
                    field.setAccessible(true);
                    c b2 = b(hVar, field, c(field), b.a.a.e.a.c(b.a.a.b.c.h(aVar2.d(), cls2, field.getGenericType())), e, e2);
                    if (((c) linkedHashMap.put(b2.f924a, b2)) != null) {
                        throw new IllegalArgumentException(d2 + " declares multiple JSON fields named " + cVar.f924a);
                    }
                }
            }
            aVar2 = b.a.a.e.a.c(b.a.a.b.c.h(aVar2.d(), cls2, cls2.getGenericSuperclass()));
            cls2 = aVar2.a();
        }
        return linkedHashMap;
    }

    @Override // b.a.a.u
    public <T> t<T> a(b.a.a.h hVar, b.a.a.e.a<T> aVar) {
        Class<? super T> a2 = aVar.a();
        if (Object.class.isAssignableFrom(a2)) {
            return new b(this.f918a.a(aVar), d(hVar, aVar, a2), null);
        }
        return null;
    }

    public boolean e(Field field, boolean z) {
        return (this.f920c.g(field.getType(), z) || this.f920c.h(field, z)) ? false : true;
    }
}
