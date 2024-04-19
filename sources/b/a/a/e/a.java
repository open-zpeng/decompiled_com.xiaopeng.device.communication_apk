package b.a.a.e;

import b.a.a.b.b;
import b.a.a.b.c;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* compiled from: TypeToken.java */
/* loaded from: classes.dex */
public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    final Class<? super T> f1029a;

    /* renamed from: b  reason: collision with root package name */
    final Type f1030b;

    /* renamed from: c  reason: collision with root package name */
    final int f1031c;

    protected a() {
        Type b2 = b(a.class);
        this.f1030b = b2;
        this.f1029a = (Class<? super T>) c.r(b2);
        this.f1031c = b2.hashCode();
    }

    a(Type type) {
        Type p = c.p((Type) b.a(type));
        this.f1030b = p;
        this.f1029a = (Class<? super T>) c.r(p);
        this.f1031c = p.hashCode();
    }

    static Type b(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        return c.p(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
    }

    public static a<?> c(Type type) {
        return new a<>(type);
    }

    public static <T> a<T> e(Class<T> cls) {
        return new a<>(cls);
    }

    public final Class<? super T> a() {
        return this.f1029a;
    }

    public final Type d() {
        return this.f1030b;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && c.k(this.f1030b, ((a) obj).f1030b);
    }

    public final int hashCode() {
        return this.f1031c;
    }

    public final String toString() {
        return c.s(this.f1030b);
    }
}
