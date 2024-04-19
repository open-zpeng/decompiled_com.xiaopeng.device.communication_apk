package a.b.c.g;

import android.os.Build;
import android.view.WindowInsets;
/* compiled from: WindowInsetsCompat.java */
/* loaded from: classes.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    private final Object f350a;

    private p(Object obj) {
        this.f350a = obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object f(p pVar) {
        if (pVar == null) {
            return null;
        }
        return pVar.f350a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static p g(Object obj) {
        if (obj == null) {
            return null;
        }
        return new p(obj);
    }

    public int a() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f350a).getSystemWindowInsetBottom();
        }
        return 0;
    }

    public int b() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f350a).getSystemWindowInsetLeft();
        }
        return 0;
    }

    public int c() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f350a).getSystemWindowInsetRight();
        }
        return 0;
    }

    public int d() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f350a).getSystemWindowInsetTop();
        }
        return 0;
    }

    public boolean e() {
        if (Build.VERSION.SDK_INT >= 21) {
            return ((WindowInsets) this.f350a).isConsumed();
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || p.class != obj.getClass()) {
            return false;
        }
        Object obj2 = this.f350a;
        Object obj3 = ((p) obj).f350a;
        return obj2 == null ? obj3 == null : obj2.equals(obj3);
    }

    public int hashCode() {
        Object obj = this.f350a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }
}
