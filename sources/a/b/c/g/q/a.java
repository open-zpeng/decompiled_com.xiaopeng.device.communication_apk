package a.b.c.g.q;

import android.os.Build;
import android.view.accessibility.AccessibilityEvent;
/* compiled from: AccessibilityEventCompat.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final c f351a;

    /* compiled from: AccessibilityEventCompat.java */
    /* renamed from: a.b.c.g.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0018a extends c {
        C0018a() {
        }
    }

    /* compiled from: AccessibilityEventCompat.java */
    /* loaded from: classes.dex */
    static class b extends C0018a {
        b() {
        }

        @Override // a.b.c.g.q.a.c
        public int a(AccessibilityEvent accessibilityEvent) {
            return accessibilityEvent.getContentChangeTypes();
        }

        @Override // a.b.c.g.q.a.c
        public void b(AccessibilityEvent accessibilityEvent, int i) {
            accessibilityEvent.setContentChangeTypes(i);
        }
    }

    /* compiled from: AccessibilityEventCompat.java */
    /* loaded from: classes.dex */
    static class c {
        c() {
        }

        public int a(AccessibilityEvent accessibilityEvent) {
            return 0;
        }

        public void b(AccessibilityEvent accessibilityEvent, int i) {
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            f351a = new b();
        } else if (i >= 16) {
            f351a = new C0018a();
        } else {
            f351a = new c();
        }
    }

    @Deprecated
    public static d a(AccessibilityEvent accessibilityEvent) {
        return new d(accessibilityEvent);
    }

    public static int b(AccessibilityEvent accessibilityEvent) {
        return f351a.a(accessibilityEvent);
    }

    public static void c(AccessibilityEvent accessibilityEvent, int i) {
        f351a.b(accessibilityEvent, i);
    }
}
