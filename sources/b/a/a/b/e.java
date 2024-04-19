package b.a.a.b;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
/* compiled from: ConstructorConstructor.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Type, b.a.a.i<?>> f971a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes.dex */
    public class a<T> implements b.a.a.b.i<T> {
        a() {
        }

        @Override // b.a.a.b.i
        public T O000000o() {
            return (T) new LinkedList();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes.dex */
    public class b<T> implements b.a.a.b.i<T> {
        b() {
        }

        @Override // b.a.a.b.i
        public T O000000o() {
            return (T) new ArrayList();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes.dex */
    public class c<T> implements b.a.a.b.i<T> {
        c() {
        }

        @Override // b.a.a.b.i
        public T O000000o() {
            return (T) new TreeMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes.dex */
    class d<T> implements b.a.a.b.i<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b.a.a.i f975a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Type f976b;

        d(b.a.a.i iVar, Type type) {
            this.f975a = iVar;
            this.f976b = type;
        }

        @Override // b.a.a.b.i
        public T O000000o() {
            return (T) this.f975a.a(this.f976b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* renamed from: b.a.a.b.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0033e<T> implements b.a.a.b.i<T> {
        C0033e() {
        }

        @Override // b.a.a.b.i
        public T O000000o() {
            return (T) new LinkedHashMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes.dex */
    public class f<T> implements b.a.a.b.i<T> {
        f() {
        }

        @Override // b.a.a.b.i
        public T O000000o() {
            return (T) new b.a.a.b.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes.dex */
    public class g<T> implements b.a.a.b.i<T> {

        /* renamed from: a  reason: collision with root package name */
        private final b.a.a.b.j f980a = b.a.a.b.j.a();

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Class f981b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Type f982c;

        g(Class cls, Type type) {
            this.f981b = cls;
            this.f982c = type;
        }

        @Override // b.a.a.b.i
        public T O000000o() {
            try {
                return (T) this.f980a.b(this.f981b);
            } catch (Exception e) {
                throw new RuntimeException("Unable to invoke no-args constructor for " + this.f982c + ". Register an InstanceCreator with Gson for this type may fix this problem.", e);
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes.dex */
    class h<T> implements b.a.a.b.i<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b.a.a.i f984a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Type f985b;

        h(b.a.a.i iVar, Type type) {
            this.f984a = iVar;
            this.f985b = type;
        }

        @Override // b.a.a.b.i
        public T O000000o() {
            return (T) this.f984a.a(this.f985b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes.dex */
    public class i<T> implements b.a.a.b.i<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Constructor f987a;

        i(Constructor constructor) {
            this.f987a = constructor;
        }

        @Override // b.a.a.b.i
        public T O000000o() {
            try {
                return (T) this.f987a.newInstance(null);
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InstantiationException e2) {
                throw new RuntimeException("Failed to invoke " + this.f987a + " with no args", e2);
            } catch (InvocationTargetException e3) {
                throw new RuntimeException("Failed to invoke " + this.f987a + " with no args", e3.getTargetException());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes.dex */
    public class j<T> implements b.a.a.b.i<T> {
        j() {
        }

        @Override // b.a.a.b.i
        public T O000000o() {
            return (T) new TreeSet();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes.dex */
    public class k<T> implements b.a.a.b.i<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Type f990a;

        k(Type type) {
            this.f990a = type;
        }

        @Override // b.a.a.b.i
        public T O000000o() {
            Type type = this.f990a;
            if (!(type instanceof ParameterizedType)) {
                throw new b.a.a.l("Invalid EnumSet type: " + this.f990a.toString());
            }
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof Class) {
                return (T) EnumSet.noneOf((Class) type2);
            }
            throw new b.a.a.l("Invalid EnumSet type: " + this.f990a.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes.dex */
    public class l<T> implements b.a.a.b.i<T> {
        l() {
        }

        @Override // b.a.a.b.i
        public T O000000o() {
            return (T) new LinkedHashSet();
        }
    }

    public e(Map<Type, b.a.a.i<?>> map) {
        this.f971a = map;
    }

    private <T> b.a.a.b.i<T> b(Class<? super T> cls) {
        try {
            Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return new i(declaredConstructor);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private <T> b.a.a.b.i<T> c(Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            return SortedSet.class.isAssignableFrom(cls) ? new j() : EnumSet.class.isAssignableFrom(cls) ? new k(type) : Set.class.isAssignableFrom(cls) ? new l() : Queue.class.isAssignableFrom(cls) ? new a() : new b();
        } else if (Map.class.isAssignableFrom(cls)) {
            return SortedMap.class.isAssignableFrom(cls) ? new c() : (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(b.a.a.e.a.c(((ParameterizedType) type).getActualTypeArguments()[0]).a())) ? new f() : new C0033e();
        } else {
            return null;
        }
    }

    private <T> b.a.a.b.i<T> d(Type type, Class<? super T> cls) {
        return new g(cls, type);
    }

    public <T> b.a.a.b.i<T> a(b.a.a.e.a<T> aVar) {
        Type d2 = aVar.d();
        Class<? super T> a2 = aVar.a();
        b.a.a.i<?> iVar = this.f971a.get(d2);
        if (iVar != null) {
            return new d(iVar, d2);
        }
        b.a.a.i<?> iVar2 = this.f971a.get(a2);
        if (iVar2 != null) {
            return new h(iVar2, d2);
        }
        b.a.a.b.i<T> b2 = b(a2);
        if (b2 != null) {
            return b2;
        }
        b.a.a.b.i<T> c2 = c(d2, a2);
        return c2 != null ? c2 : d(d2, a2);
    }

    public String toString() {
        return this.f971a.toString();
    }
}
