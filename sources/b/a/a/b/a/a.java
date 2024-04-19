package b.a.a.b.a;

import b.a.a.d;
import b.a.a.t;
import b.a.a.u;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
/* compiled from: ArrayTypeAdapter.java */
/* loaded from: classes.dex */
public final class a<E> extends t<Object> {

    /* renamed from: a  reason: collision with root package name */
    public static final u f902a = new C0030a();

    /* renamed from: b  reason: collision with root package name */
    private final Class<E> f903b;

    /* renamed from: c  reason: collision with root package name */
    private final t<E> f904c;

    /* compiled from: ArrayTypeAdapter.java */
    /* renamed from: b.a.a.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0030a implements u {
        C0030a() {
        }

        @Override // b.a.a.u
        public <T> t<T> a(b.a.a.h hVar, b.a.a.e.a<T> aVar) {
            Type d2 = aVar.d();
            if ((d2 instanceof GenericArrayType) || ((d2 instanceof Class) && ((Class) d2).isArray())) {
                Type t = b.a.a.b.c.t(d2);
                return new a(hVar, hVar.b(b.a.a.e.a.c(t)), b.a.a.b.c.r(t));
            }
            return null;
        }
    }

    public a(b.a.a.h hVar, t<E> tVar, Class<E> cls) {
        this.f904c = new k(hVar, tVar, cls);
        this.f903b = cls;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.a.a.t
    public void a(d.h hVar, Object obj) throws IOException {
        if (obj == null) {
            hVar.F();
            return;
        }
        hVar.t();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.f904c.a(hVar, Array.get(obj, i));
        }
        hVar.A();
    }

    @Override // b.a.a.t
    public Object c(d.f fVar) throws IOException {
        if (fVar.E() == d.g.NULL) {
            fVar.H();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        fVar.n();
        while (fVar.D()) {
            arrayList.add(this.f904c.c(fVar));
        }
        fVar.w();
        Object newInstance = Array.newInstance((Class<?>) this.f903b, arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            Array.set(newInstance, i, arrayList.get(i));
        }
        return newInstance;
    }
}
