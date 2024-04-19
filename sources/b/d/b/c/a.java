package b.d.b.c;

import android.text.TextUtils;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
/* compiled from: ApiMatcher.java */
/* loaded from: classes.dex */
class a {

    /* renamed from: a  reason: collision with root package name */
    private ConcurrentHashMap<String, d> f1330a = new ConcurrentHashMap<>();

    private d a(e eVar) {
        Set<Map.Entry<String, d>> entrySet = this.f1330a.entrySet();
        String str = eVar.f1342c;
        String str2 = !TextUtils.isEmpty(str) ? str + "@" + eVar.f1340a + "." : eVar.f1340a + ".";
        String str3 = "." + eVar.f1341b;
        for (Map.Entry<String, d> entry : entrySet) {
            String key = entry.getKey();
            if (key.startsWith(str2) && key.endsWith(str3)) {
                return entry.getValue();
            }
        }
        return null;
    }

    private d d(String str, String str2, d dVar) {
        if (!TextUtils.isEmpty(str)) {
            str2 = str + "@" + str2;
        }
        return this.f1330a.put(str2, dVar);
    }

    private void e(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            str2 = str + "@" + str2;
        }
        this.f1330a.remove(str2);
    }

    public synchronized d b(e eVar) {
        return a(eVar);
    }

    public synchronized void c(e eVar, d dVar) {
        d d2;
        String str = eVar.f1342c;
        d d3 = d(str, dVar.f(), dVar);
        if (d3 != null) {
            d3.k("getAuthority");
        }
        if (!dVar.f().equals(dVar.g()) && (d2 = d(str, dVar.g(), dVar)) != null) {
            d2.k("getDescription");
        }
        dVar.i();
    }

    public synchronized void f(e eVar) {
        d a2 = a(eVar);
        if (a2 != null) {
            String str = eVar.f1342c;
            e(str, a2.f());
            if (!a2.f().equals(a2.g())) {
                e(str, a2.g());
            }
            a2.k("unpublishUri");
        }
    }
}
