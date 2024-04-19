package b.a.a.b.a;

import b.a.a.d;
import b.a.a.t;
import b.a.a.u;
import java.io.IOException;
import java.util.ArrayList;
/* compiled from: ObjectTypeAdapter.java */
/* loaded from: classes.dex */
public final class h extends t<Object> {

    /* renamed from: a  reason: collision with root package name */
    public static final u f927a = new a();

    /* renamed from: b  reason: collision with root package name */
    private final b.a.a.h f928b;

    /* compiled from: ObjectTypeAdapter.java */
    /* loaded from: classes.dex */
    static class a implements u {
        a() {
        }

        @Override // b.a.a.u
        public <T> t<T> a(b.a.a.h hVar, b.a.a.e.a<T> aVar) {
            if (aVar.a() == Object.class) {
                return new h(hVar, null);
            }
            return null;
        }
    }

    /* compiled from: ObjectTypeAdapter.java */
    /* loaded from: classes.dex */
    static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f929a;

        static {
            int[] iArr = new int[d.g.values().length];
            f929a = iArr;
            try {
                iArr[d.g.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f929a[d.g.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f929a[d.g.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f929a[d.g.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f929a[d.g.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f929a[d.g.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private h(b.a.a.h hVar) {
        this.f928b = hVar;
    }

    /* synthetic */ h(b.a.a.h hVar, a aVar) {
        this(hVar);
    }

    @Override // b.a.a.t
    public void a(d.h hVar, Object obj) throws IOException {
        if (obj == null) {
            hVar.F();
            return;
        }
        t e = this.f928b.e(obj.getClass());
        if (!(e instanceof h)) {
            e.a(hVar, obj);
            return;
        }
        hVar.x();
        hVar.D();
    }

    @Override // b.a.a.t
    public Object c(d.f fVar) throws IOException {
        switch (b.f929a[fVar.E().ordinal()]) {
            case 1:
                ArrayList arrayList = new ArrayList();
                fVar.n();
                while (fVar.D()) {
                    arrayList.add(c(fVar));
                }
                fVar.w();
                return arrayList;
            case 2:
                b.a.a.b.h hVar = new b.a.a.b.h();
                fVar.B();
                while (fVar.D()) {
                    hVar.put(fVar.F(), c(fVar));
                }
                fVar.z();
                return hVar;
            case 3:
                return fVar.G();
            case 4:
                return Double.valueOf(fVar.J());
            case 5:
                return Boolean.valueOf(fVar.I());
            case 6:
                fVar.H();
                return null;
            default:
                throw new IllegalStateException();
        }
    }
}
