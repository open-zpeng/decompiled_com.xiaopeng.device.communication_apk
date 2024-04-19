package b.a.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* compiled from: JsonArray.java */
/* loaded from: classes.dex */
public final class j extends v implements Iterable<v> {

    /* renamed from: a  reason: collision with root package name */
    private final List<v> f1043a = new ArrayList();

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof j) && ((j) obj).f1043a.equals(this.f1043a));
    }

    public void h(v vVar) {
        if (vVar == null) {
            vVar = m.f1044a;
        }
        this.f1043a.add(vVar);
    }

    public int hashCode() {
        return this.f1043a.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator<v> iterator() {
        return this.f1043a.iterator();
    }
}
