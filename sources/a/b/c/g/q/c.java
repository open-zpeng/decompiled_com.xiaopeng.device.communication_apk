package a.b.c.g.q;

import android.os.Build;
/* compiled from: AccessibilityNodeProviderCompat.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final a f357a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f358b;

    /* compiled from: AccessibilityNodeProviderCompat.java */
    /* loaded from: classes.dex */
    interface a {
    }

    /* compiled from: AccessibilityNodeProviderCompat.java */
    /* loaded from: classes.dex */
    private static class b extends d {
        b() {
        }
    }

    /* compiled from: AccessibilityNodeProviderCompat.java */
    /* renamed from: a.b.c.g.q.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0020c extends d {
        C0020c() {
        }
    }

    /* compiled from: AccessibilityNodeProviderCompat.java */
    /* loaded from: classes.dex */
    static class d implements a {
        d() {
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            f357a = new C0020c();
        } else if (i >= 16) {
            f357a = new b();
        } else {
            f357a = new d();
        }
    }

    public c(Object obj) {
        this.f358b = obj;
    }

    public Object a() {
        return this.f358b;
    }
}
