package b.d.b;
/* compiled from: InitEventHolder.java */
/* loaded from: classes.dex */
public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f1328a = new b();

    /* renamed from: b  reason: collision with root package name */
    private a f1329b;

    public static a b() {
        return f1328a;
    }

    public static void c(a aVar) {
        f1328a.f1329b = aVar;
    }

    @Override // b.d.b.a
    public void a(int i, String str) {
        a aVar = this.f1329b;
        if (aVar != null) {
            aVar.a(i, str);
        }
    }
}
