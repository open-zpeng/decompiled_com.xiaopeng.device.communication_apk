package b.a.a.b.a;

import b.a.a.b.a.g;
import b.a.a.d;
import b.a.a.t;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TypeAdapterRuntimeTypeWrapper.java */
/* loaded from: classes.dex */
public final class k<T> extends t<T> {

    /* renamed from: a  reason: collision with root package name */
    private final b.a.a.h f934a;

    /* renamed from: b  reason: collision with root package name */
    private final t<T> f935b;

    /* renamed from: c  reason: collision with root package name */
    private final Type f936c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(b.a.a.h hVar, t<T> tVar, Type type) {
        this.f934a = hVar;
        this.f935b = tVar;
        this.f936c = type;
    }

    private Type d(Type type, Object obj) {
        return obj != null ? (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) ? obj.getClass() : type : type;
    }

    @Override // b.a.a.t
    public void a(d.h hVar, T t) throws IOException {
        t<T> tVar = this.f935b;
        Type d2 = d(this.f936c, t);
        if (d2 != this.f936c) {
            tVar = this.f934a.b(b.a.a.e.a.c(d2));
            if (tVar instanceof g.b) {
                t<T> tVar2 = this.f935b;
                if (!(tVar2 instanceof g.b)) {
                    tVar = tVar2;
                }
            }
        }
        tVar.a(hVar, t);
    }

    @Override // b.a.a.t
    public T c(d.f fVar) throws IOException {
        return this.f935b.c(fVar);
    }
}
