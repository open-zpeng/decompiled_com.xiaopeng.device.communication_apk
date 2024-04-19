package a.b.c.g;

import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowInsets;
import java.lang.reflect.Field;
import java.util.WeakHashMap;
/* compiled from: ViewCompat.java */
/* loaded from: classes.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    static final j f333a;

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    static class a extends j {
        a() {
        }
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    static class b extends a {
        b() {
        }

        @Override // a.b.c.g.k.j
        public void E(View view, int i) {
            if (i == 4) {
                i = 2;
            }
            view.setImportantForAccessibility(i);
        }

        @Override // a.b.c.g.k.j
        public boolean e(View view) {
            return view.getFitsSystemWindows();
        }

        @Override // a.b.c.g.k.j
        public int g(View view) {
            return view.getImportantForAccessibility();
        }

        @Override // a.b.c.g.k.j
        public int i(View view) {
            return view.getMinimumHeight();
        }

        @Override // a.b.c.g.k.j
        public int j(View view) {
            return view.getMinimumWidth();
        }

        @Override // a.b.c.g.k.j
        public boolean p(View view) {
            return view.hasTransientState();
        }

        @Override // a.b.c.g.k.j
        public void v(View view) {
            view.postInvalidateOnAnimation();
        }

        @Override // a.b.c.g.k.j
        public void w(View view, Runnable runnable) {
            view.postOnAnimation(runnable);
        }

        @Override // a.b.c.g.k.j
        public void x(View view, Runnable runnable, long j) {
            view.postOnAnimationDelayed(runnable, j);
        }

        @Override // a.b.c.g.k.j
        public void y(View view) {
            view.requestFitSystemWindows();
        }
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    static class c extends b {
        c() {
        }

        @Override // a.b.c.g.k.j
        public void G(View view, int i, int i2, int i3, int i4) {
            view.setPaddingRelative(i, i2, i3, i4);
        }

        @Override // a.b.c.g.k.j
        public int h(View view) {
            return view.getLayoutDirection();
        }

        @Override // a.b.c.g.k.j
        public int k(View view) {
            return view.getPaddingEnd();
        }

        @Override // a.b.c.g.k.j
        public int l(View view) {
            return view.getPaddingStart();
        }

        @Override // a.b.c.g.k.j
        public int n(View view) {
            return view.getWindowSystemUiVisibility();
        }

        @Override // a.b.c.g.k.j
        public boolean s(View view) {
            return view.isPaddingRelative();
        }
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    static class d extends c {
        d() {
        }
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    static class e extends d {
        e() {
        }

        @Override // a.b.c.g.k.j
        public void A(View view, int i) {
            view.setAccessibilityLiveRegion(i);
        }

        @Override // a.b.c.g.k.b, a.b.c.g.k.j
        public void E(View view, int i) {
            view.setImportantForAccessibility(i);
        }

        @Override // a.b.c.g.k.j
        public boolean q(View view) {
            return view.isAttachedToWindow();
        }

        @Override // a.b.c.g.k.j
        public boolean r(View view) {
            return view.isLaidOut();
        }
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    static class f extends e {
        private static ThreadLocal<Rect> f;

        /* compiled from: ViewCompat.java */
        /* loaded from: classes.dex */
        class a implements View.OnApplyWindowInsetsListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a.b.c.g.h f334a;

            a(a.b.c.g.h hVar) {
                this.f334a = hVar;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                return (WindowInsets) p.f(this.f334a.a(view, p.g(windowInsets)));
            }
        }

        f() {
        }

        private static Rect I() {
            if (f == null) {
                f = new ThreadLocal<>();
            }
            Rect rect = f.get();
            if (rect == null) {
                rect = new Rect();
                f.set(rect);
            }
            rect.setEmpty();
            return rect;
        }

        @Override // a.b.c.g.k.j
        public void B(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null || view.getBackgroundTintMode() == null) ? false : true;
                if (background == null || !z) {
                    return;
                }
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        }

        @Override // a.b.c.g.k.j
        public void C(View view, PorterDuff.Mode mode) {
            view.setBackgroundTintMode(mode);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null || view.getBackgroundTintMode() == null) ? false : true;
                if (background == null || !z) {
                    return;
                }
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        }

        @Override // a.b.c.g.k.j
        public void D(View view, float f2) {
            view.setElevation(f2);
        }

        @Override // a.b.c.g.k.j
        public void F(View view, a.b.c.g.h hVar) {
            if (hVar == null) {
                view.setOnApplyWindowInsetsListener(null);
            } else {
                view.setOnApplyWindowInsetsListener(new a(hVar));
            }
        }

        @Override // a.b.c.g.k.j
        public ColorStateList b(View view) {
            return view.getBackgroundTintList();
        }

        @Override // a.b.c.g.k.j
        public PorterDuff.Mode c(View view) {
            return view.getBackgroundTintMode();
        }

        @Override // a.b.c.g.k.j
        public float d(View view) {
            return view.getElevation();
        }

        @Override // a.b.c.g.k.j
        public float m(View view) {
            return view.getTranslationZ();
        }

        @Override // a.b.c.g.k.j
        public float o(View view) {
            return view.getZ();
        }

        @Override // a.b.c.g.k.j
        public void t(View view, int i) {
            boolean z;
            Rect I = I();
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                I.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !I.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            } else {
                z = false;
            }
            super.t(view, i);
            if (z && I.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(I);
            }
        }

        @Override // a.b.c.g.k.j
        public void u(View view, int i) {
            boolean z;
            Rect I = I();
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                I.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !I.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            } else {
                z = false;
            }
            super.u(view, i);
            if (z && I.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(I);
            }
        }

        @Override // a.b.c.g.k.b, a.b.c.g.k.j
        public void y(View view) {
            view.requestApplyInsets();
        }
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    static class g extends f {
        g() {
        }

        @Override // a.b.c.g.k.f, a.b.c.g.k.j
        public void t(View view, int i) {
            view.offsetLeftAndRight(i);
        }

        @Override // a.b.c.g.k.f, a.b.c.g.k.j
        public void u(View view, int i) {
            view.offsetTopAndBottom(i);
        }
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    static class h extends g {
        h() {
        }
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    static class i extends h {
        i() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    public static class j {

        /* renamed from: a  reason: collision with root package name */
        private static Field f336a;

        /* renamed from: b  reason: collision with root package name */
        private static boolean f337b;

        /* renamed from: c  reason: collision with root package name */
        private static Field f338c;

        /* renamed from: d  reason: collision with root package name */
        private static boolean f339d;
        WeakHashMap<View, m> e = null;

        j() {
        }

        private static void H(View view) {
            float translationY = view.getTranslationY();
            view.setTranslationY(1.0f + translationY);
            view.setTranslationY(translationY);
        }

        public void A(View view, int i) {
        }

        public void B(View view, ColorStateList colorStateList) {
            if (view instanceof a.b.c.g.i) {
                ((a.b.c.g.i) view).setSupportBackgroundTintList(colorStateList);
            }
        }

        public void C(View view, PorterDuff.Mode mode) {
            if (view instanceof a.b.c.g.i) {
                ((a.b.c.g.i) view).setSupportBackgroundTintMode(mode);
            }
        }

        public void D(View view, float f) {
        }

        public void E(View view, int i) {
        }

        public void F(View view, a.b.c.g.h hVar) {
        }

        public void G(View view, int i, int i2, int i3, int i4) {
            view.setPadding(i, i2, i3, i4);
        }

        public m a(View view) {
            if (this.e == null) {
                this.e = new WeakHashMap<>();
            }
            m mVar = this.e.get(view);
            if (mVar == null) {
                m mVar2 = new m(view);
                this.e.put(view, mVar2);
                return mVar2;
            }
            return mVar;
        }

        public ColorStateList b(View view) {
            if (view instanceof a.b.c.g.i) {
                return ((a.b.c.g.i) view).getSupportBackgroundTintList();
            }
            return null;
        }

        public PorterDuff.Mode c(View view) {
            if (view instanceof a.b.c.g.i) {
                return ((a.b.c.g.i) view).getSupportBackgroundTintMode();
            }
            return null;
        }

        public float d(View view) {
            return 0.0f;
        }

        public boolean e(View view) {
            return false;
        }

        long f() {
            return ValueAnimator.getFrameDelay();
        }

        public int g(View view) {
            return 0;
        }

        public int h(View view) {
            return 0;
        }

        public int i(View view) {
            if (!f339d) {
                try {
                    Field declaredField = View.class.getDeclaredField("mMinHeight");
                    f338c = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException unused) {
                }
                f339d = true;
            }
            Field field = f338c;
            if (field != null) {
                try {
                    return ((Integer) field.get(view)).intValue();
                } catch (Exception unused2) {
                    return 0;
                }
            }
            return 0;
        }

        public int j(View view) {
            if (!f337b) {
                try {
                    Field declaredField = View.class.getDeclaredField("mMinWidth");
                    f336a = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException unused) {
                }
                f337b = true;
            }
            Field field = f336a;
            if (field != null) {
                try {
                    return ((Integer) field.get(view)).intValue();
                } catch (Exception unused2) {
                    return 0;
                }
            }
            return 0;
        }

        public int k(View view) {
            return view.getPaddingRight();
        }

        public int l(View view) {
            return view.getPaddingLeft();
        }

        public float m(View view) {
            return 0.0f;
        }

        public int n(View view) {
            return 0;
        }

        public float o(View view) {
            return m(view) + d(view);
        }

        public boolean p(View view) {
            return false;
        }

        public boolean q(View view) {
            return view.getWindowToken() != null;
        }

        public boolean r(View view) {
            return view.getWidth() > 0 && view.getHeight() > 0;
        }

        public boolean s(View view) {
            return false;
        }

        public void t(View view, int i) {
            view.offsetLeftAndRight(i);
            if (view.getVisibility() == 0) {
                H(view);
                ViewParent parent = view.getParent();
                if (parent instanceof View) {
                    H((View) parent);
                }
            }
        }

        public void u(View view, int i) {
            view.offsetTopAndBottom(i);
            if (view.getVisibility() == 0) {
                H(view);
                ViewParent parent = view.getParent();
                if (parent instanceof View) {
                    H((View) parent);
                }
            }
        }

        public void v(View view) {
            view.postInvalidate();
        }

        public void w(View view, Runnable runnable) {
            view.postDelayed(runnable, f());
        }

        public void x(View view, Runnable runnable, long j) {
            view.postDelayed(runnable, f() + j);
        }

        public void y(View view) {
        }

        public void z(View view, a.b.c.g.a aVar) {
            view.setAccessibilityDelegate(aVar == null ? null : aVar.c());
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            f333a = new i();
        } else if (i2 >= 24) {
            f333a = new h();
        } else if (i2 >= 23) {
            f333a = new g();
        } else if (i2 >= 21) {
            f333a = new f();
        } else if (i2 >= 19) {
            f333a = new e();
        } else if (i2 >= 18) {
            f333a = new d();
        } else if (i2 >= 17) {
            f333a = new c();
        } else if (i2 >= 16) {
            f333a = new b();
        } else if (i2 >= 15) {
            f333a = new a();
        } else {
            f333a = new j();
        }
    }

    public static void A(View view, int i2) {
        f333a.t(view, i2);
    }

    public static void B(View view, int i2) {
        f333a.u(view, i2);
    }

    public static void C(View view) {
        f333a.v(view);
    }

    public static void D(View view, Runnable runnable) {
        f333a.w(view, runnable);
    }

    public static void E(View view, Runnable runnable, long j2) {
        f333a.x(view, runnable, j2);
    }

    public static void F(View view) {
        f333a.y(view);
    }

    @Deprecated
    public static int G(int i2, int i3, int i4) {
        return View.resolveSizeAndState(i2, i3, i4);
    }

    public static void H(View view, a.b.c.g.a aVar) {
        f333a.z(view, aVar);
    }

    public static void I(View view, int i2) {
        f333a.A(view, i2);
    }

    @Deprecated
    public static void J(View view, float f2) {
        view.setAlpha(f2);
    }

    public static void K(View view, ColorStateList colorStateList) {
        f333a.B(view, colorStateList);
    }

    public static void L(View view, PorterDuff.Mode mode) {
        f333a.C(view, mode);
    }

    public static void M(View view, float f2) {
        f333a.D(view, f2);
    }

    @Deprecated
    public static void N(View view, boolean z) {
        view.setFitsSystemWindows(z);
    }

    public static void O(View view, int i2) {
        f333a.E(view, i2);
    }

    public static void P(View view, a.b.c.g.h hVar) {
        f333a.F(view, hVar);
    }

    public static void Q(View view, int i2, int i3, int i4, int i5) {
        f333a.G(view, i2, i3, i4, i5);
    }

    @Deprecated
    public static void R(View view, float f2) {
        view.setTranslationX(f2);
    }

    @Deprecated
    public static void S(View view, float f2) {
        view.setTranslationY(f2);
    }

    public static m a(View view) {
        return f333a.a(view);
    }

    @Deprecated
    public static boolean b(View view, int i2) {
        return view.canScrollHorizontally(i2);
    }

    @Deprecated
    public static boolean c(View view, int i2) {
        return view.canScrollVertically(i2);
    }

    @Deprecated
    public static int d(int i2, int i3) {
        return View.combineMeasuredStates(i2, i3);
    }

    @Deprecated
    public static float e(View view) {
        return view.getAlpha();
    }

    public static ColorStateList f(View view) {
        return f333a.b(view);
    }

    public static PorterDuff.Mode g(View view) {
        return f333a.c(view);
    }

    public static boolean h(View view) {
        return f333a.e(view);
    }

    public static int i(View view) {
        return f333a.g(view);
    }

    public static int j(View view) {
        return f333a.h(view);
    }

    @Deprecated
    public static int k(View view) {
        return view.getMeasuredState();
    }

    @Deprecated
    public static int l(View view) {
        return view.getMeasuredWidthAndState();
    }

    public static int m(View view) {
        return f333a.i(view);
    }

    public static int n(View view) {
        return f333a.j(view);
    }

    @Deprecated
    public static int o(View view) {
        return view.getOverScrollMode();
    }

    public static int p(View view) {
        return f333a.k(view);
    }

    public static int q(View view) {
        return f333a.l(view);
    }

    @Deprecated
    public static float r(View view) {
        return view.getTranslationX();
    }

    @Deprecated
    public static float s(View view) {
        return view.getTranslationY();
    }

    public static int t(View view) {
        return f333a.n(view);
    }

    public static float u(View view) {
        return f333a.o(view);
    }

    public static boolean v(View view) {
        return f333a.p(view);
    }

    public static boolean w(View view) {
        return f333a.q(view);
    }

    public static boolean x(View view) {
        return f333a.r(view);
    }

    public static boolean y(View view) {
        return f333a.s(view);
    }

    @Deprecated
    public static void z(View view) {
        view.jumpDrawablesToCurrentState();
    }
}
