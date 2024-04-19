package a.b.c.h;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.TextView;
/* compiled from: TextViewCompat.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    static final f f368a;

    /* compiled from: TextViewCompat.java */
    /* loaded from: classes.dex */
    static class a extends f {
        a() {
        }
    }

    /* compiled from: TextViewCompat.java */
    /* loaded from: classes.dex */
    static class b extends a {
        b() {
        }

        @Override // a.b.c.h.d.f
        public void a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            boolean z = textView.getLayoutDirection() == 1;
            Drawable drawable5 = z ? drawable3 : drawable;
            if (!z) {
                drawable = drawable3;
            }
            textView.setCompoundDrawables(drawable5, drawable2, drawable, drawable4);
        }
    }

    /* compiled from: TextViewCompat.java */
    /* loaded from: classes.dex */
    static class c extends b {
        c() {
        }

        @Override // a.b.c.h.d.b, a.b.c.h.d.f
        public void a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        }
    }

    /* compiled from: TextViewCompat.java */
    /* renamed from: a.b.c.h.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0023d extends c {
        C0023d() {
        }
    }

    /* compiled from: TextViewCompat.java */
    /* loaded from: classes.dex */
    static class e extends C0023d {
        e() {
        }
    }

    /* compiled from: TextViewCompat.java */
    /* loaded from: classes.dex */
    static class f {
        f() {
        }

        public void a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            f368a = new e();
        } else if (i >= 23) {
            f368a = new C0023d();
        } else if (i >= 18) {
            f368a = new c();
        } else if (i >= 17) {
            f368a = new b();
        } else if (i >= 16) {
            f368a = new a();
        } else {
            f368a = new f();
        }
    }

    public static void a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        f368a.a(textView, drawable, drawable2, drawable3, drawable4);
    }
}
