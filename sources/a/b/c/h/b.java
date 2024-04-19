package a.b.c.h;

import a.b.c.g.k;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* compiled from: PopupWindowCompat.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    static final d f363a;

    /* compiled from: PopupWindowCompat.java */
    /* loaded from: classes.dex */
    static class a extends d {
        a() {
        }

        @Override // a.b.c.h.b.d
        public void c(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            popupWindow.showAsDropDown(view, i, i2, i3);
        }
    }

    /* compiled from: PopupWindowCompat.java */
    /* renamed from: a.b.c.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0022b extends a {

        /* renamed from: c  reason: collision with root package name */
        private static Field f364c;

        static {
            try {
                Field declaredField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                f364c = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e);
            }
        }

        C0022b() {
        }

        @Override // a.b.c.h.b.d
        public void a(PopupWindow popupWindow, boolean z) {
            Field field = f364c;
            if (field != null) {
                try {
                    field.set(popupWindow, Boolean.valueOf(z));
                } catch (IllegalAccessException e) {
                    Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", e);
                }
            }
        }
    }

    /* compiled from: PopupWindowCompat.java */
    /* loaded from: classes.dex */
    static class c extends C0022b {
        c() {
        }

        @Override // a.b.c.h.b.C0022b, a.b.c.h.b.d
        public void a(PopupWindow popupWindow, boolean z) {
            popupWindow.setOverlapAnchor(z);
        }

        @Override // a.b.c.h.b.d
        public void b(PopupWindow popupWindow, int i) {
            popupWindow.setWindowLayoutType(i);
        }
    }

    /* compiled from: PopupWindowCompat.java */
    /* loaded from: classes.dex */
    static class d {

        /* renamed from: a  reason: collision with root package name */
        private static Method f365a;

        /* renamed from: b  reason: collision with root package name */
        private static boolean f366b;

        d() {
        }

        public void a(PopupWindow popupWindow, boolean z) {
        }

        public void b(PopupWindow popupWindow, int i) {
            if (!f366b) {
                try {
                    Method declaredMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", Integer.TYPE);
                    f365a = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (Exception unused) {
                }
                f366b = true;
            }
            Method method = f365a;
            if (method != null) {
                try {
                    method.invoke(popupWindow, Integer.valueOf(i));
                } catch (Exception unused2) {
                }
            }
        }

        public void c(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            if ((a.b.c.g.c.b(i3, k.j(view)) & 7) == 5) {
                i -= popupWindow.getWidth() - view.getWidth();
            }
            popupWindow.showAsDropDown(view, i, i2);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            f363a = new c();
        } else if (i >= 21) {
            f363a = new C0022b();
        } else if (i >= 19) {
            f363a = new a();
        } else {
            f363a = new d();
        }
    }

    public static void a(PopupWindow popupWindow, boolean z) {
        f363a.a(popupWindow, z);
    }

    public static void b(PopupWindow popupWindow, int i) {
        f363a.b(popupWindow, i);
    }

    public static void c(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        f363a.c(popupWindow, view, i, i2, i3);
    }
}
