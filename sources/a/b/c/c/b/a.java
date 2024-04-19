package a.b.c.c.b;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: DrawableCompat.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    static final e f265a;

    /* compiled from: DrawableCompat.java */
    /* renamed from: a.b.c.c.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0011a extends e {

        /* renamed from: a  reason: collision with root package name */
        private static Method f266a;

        /* renamed from: b  reason: collision with root package name */
        private static boolean f267b;

        C0011a() {
        }

        @Override // a.b.c.c.b.a.e
        public int e(Drawable drawable) {
            if (!f267b) {
                try {
                    Method declaredMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                    f266a = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    Log.i("DrawableCompatApi17", "Failed to retrieve getLayoutDirection() method", e);
                }
                f267b = true;
            }
            Method method = f266a;
            if (method != null) {
                try {
                    return ((Integer) method.invoke(drawable, new Object[0])).intValue();
                } catch (Exception e2) {
                    Log.i("DrawableCompatApi17", "Failed to invoke getLayoutDirection() via reflection", e2);
                    f266a = null;
                }
            }
            return 0;
        }
    }

    /* compiled from: DrawableCompat.java */
    /* loaded from: classes.dex */
    static class b extends C0011a {
        b() {
        }

        @Override // a.b.c.c.b.a.e
        public int c(Drawable drawable) {
            return drawable.getAlpha();
        }

        @Override // a.b.c.c.b.a.e
        public boolean g(Drawable drawable) {
            return drawable.isAutoMirrored();
        }

        @Override // a.b.c.c.b.a.e
        public void i(Drawable drawable, boolean z) {
            drawable.setAutoMirrored(z);
        }

        @Override // a.b.c.c.b.a.e
        public Drawable o(Drawable drawable) {
            return !(drawable instanceof f) ? new a.b.c.c.b.d(drawable) : drawable;
        }
    }

    /* compiled from: DrawableCompat.java */
    /* loaded from: classes.dex */
    static class c extends b {
        c() {
        }

        @Override // a.b.c.c.b.a.e
        public void a(Drawable drawable, Resources.Theme theme) {
            drawable.applyTheme(theme);
        }

        @Override // a.b.c.c.b.a.e
        public boolean b(Drawable drawable) {
            return drawable.canApplyTheme();
        }

        @Override // a.b.c.c.b.a.e
        public ColorFilter d(Drawable drawable) {
            return drawable.getColorFilter();
        }

        @Override // a.b.c.c.b.a.e
        public void f(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws IOException, XmlPullParserException {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        }

        @Override // a.b.c.c.b.a.e
        public void j(Drawable drawable, float f, float f2) {
            drawable.setHotspot(f, f2);
        }

        @Override // a.b.c.c.b.a.e
        public void k(Drawable drawable, int i, int i2, int i3, int i4) {
            drawable.setHotspotBounds(i, i2, i3, i4);
        }

        @Override // a.b.c.c.b.a.e
        public void l(Drawable drawable, int i) {
            drawable.setTint(i);
        }

        @Override // a.b.c.c.b.a.e
        public void m(Drawable drawable, ColorStateList colorStateList) {
            drawable.setTintList(colorStateList);
        }

        @Override // a.b.c.c.b.a.e
        public void n(Drawable drawable, PorterDuff.Mode mode) {
            drawable.setTintMode(mode);
        }

        @Override // a.b.c.c.b.a.b, a.b.c.c.b.a.e
        public Drawable o(Drawable drawable) {
            return !(drawable instanceof f) ? new a.b.c.c.b.e(drawable) : drawable;
        }
    }

    /* compiled from: DrawableCompat.java */
    /* loaded from: classes.dex */
    static class d extends c {
        d() {
        }

        @Override // a.b.c.c.b.a.C0011a, a.b.c.c.b.a.e
        public int e(Drawable drawable) {
            return drawable.getLayoutDirection();
        }

        @Override // a.b.c.c.b.a.c, a.b.c.c.b.a.b, a.b.c.c.b.a.e
        public Drawable o(Drawable drawable) {
            return drawable;
        }
    }

    /* compiled from: DrawableCompat.java */
    /* loaded from: classes.dex */
    static class e {
        e() {
        }

        public void a(Drawable drawable, Resources.Theme theme) {
        }

        public boolean b(Drawable drawable) {
            return false;
        }

        public int c(Drawable drawable) {
            return 0;
        }

        public ColorFilter d(Drawable drawable) {
            return null;
        }

        public int e(Drawable drawable) {
            return 0;
        }

        public void f(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws IOException, XmlPullParserException {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        }

        public boolean g(Drawable drawable) {
            return false;
        }

        public void h(Drawable drawable) {
            drawable.jumpToCurrentState();
        }

        public void i(Drawable drawable, boolean z) {
        }

        public void j(Drawable drawable, float f, float f2) {
        }

        public void k(Drawable drawable, int i, int i2, int i3, int i4) {
        }

        public void l(Drawable drawable, int i) {
            if (drawable instanceof f) {
                ((f) drawable).setTint(i);
            }
        }

        public void m(Drawable drawable, ColorStateList colorStateList) {
            if (drawable instanceof f) {
                ((f) drawable).setTintList(colorStateList);
            }
        }

        public void n(Drawable drawable, PorterDuff.Mode mode) {
            if (drawable instanceof f) {
                ((f) drawable).setTintMode(mode);
            }
        }

        public Drawable o(Drawable drawable) {
            return !(drawable instanceof f) ? new a.b.c.c.b.c(drawable) : drawable;
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            f265a = new d();
        } else if (i >= 21) {
            f265a = new c();
        } else if (i >= 19) {
            f265a = new b();
        } else if (i >= 17) {
            f265a = new C0011a();
        } else {
            f265a = new e();
        }
    }

    public static void a(Drawable drawable, Resources.Theme theme) {
        f265a.a(drawable, theme);
    }

    public static boolean b(Drawable drawable) {
        return f265a.b(drawable);
    }

    public static int c(Drawable drawable) {
        return f265a.c(drawable);
    }

    public static ColorFilter d(Drawable drawable) {
        return f265a.d(drawable);
    }

    public static int e(Drawable drawable) {
        return f265a.e(drawable);
    }

    public static void f(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        f265a.f(drawable, resources, xmlPullParser, attributeSet, theme);
    }

    public static boolean g(Drawable drawable) {
        return f265a.g(drawable);
    }

    public static void h(Drawable drawable) {
        f265a.h(drawable);
    }

    public static void i(Drawable drawable, boolean z) {
        f265a.i(drawable, z);
    }

    public static void j(Drawable drawable, float f, float f2) {
        f265a.j(drawable, f, f2);
    }

    public static void k(Drawable drawable, int i, int i2, int i3, int i4) {
        f265a.k(drawable, i, i2, i3, i4);
    }

    public static void l(Drawable drawable, int i) {
        f265a.l(drawable, i);
    }

    public static void m(Drawable drawable, ColorStateList colorStateList) {
        f265a.m(drawable, colorStateList);
    }

    public static void n(Drawable drawable, PorterDuff.Mode mode) {
        f265a.n(drawable, mode);
    }

    public static Drawable o(Drawable drawable) {
        return f265a.o(drawable);
    }
}
