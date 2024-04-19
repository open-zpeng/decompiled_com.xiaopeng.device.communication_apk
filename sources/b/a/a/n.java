package b.a.a;

import java.util.Map;
import java.util.Set;
/* compiled from: JsonObject.java */
/* loaded from: classes.dex */
public final class n extends v {

    /* renamed from: a  reason: collision with root package name */
    private final b.a.a.b.h<String, v> f1045a = new b.a.a.b.h<>();

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof n) && ((n) obj).f1045a.equals(this.f1045a));
    }

    public void h(String str, v vVar) {
        if (vVar == null) {
            vVar = m.f1044a;
        }
        this.f1045a.put(str, vVar);
    }

    public int hashCode() {
        return this.f1045a.hashCode();
    }

    public Set<Map.Entry<String, v>> i() {
        return this.f1045a.entrySet();
    }
}
