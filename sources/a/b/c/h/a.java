package a.b.c.h;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.widget.EdgeEffect;
/* compiled from: EdgeEffectCompat.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final b f361a;

    /* renamed from: b  reason: collision with root package name */
    private EdgeEffect f362b;

    /* compiled from: EdgeEffectCompat.java */
    /* renamed from: a.b.c.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0021a extends b {
        C0021a() {
        }

        @Override // a.b.c.h.a.b
        public void a(EdgeEffect edgeEffect, float f, float f2) {
            edgeEffect.onPull(f, f2);
        }
    }

    /* compiled from: EdgeEffectCompat.java */
    /* loaded from: classes.dex */
    static class b {
        b() {
        }

        public void a(EdgeEffect edgeEffect, float f, float f2) {
            edgeEffect.onPull(f);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            f361a = new C0021a();
        } else {
            f361a = new b();
        }
    }

    @Deprecated
    public a(Context context) {
        this.f362b = new EdgeEffect(context);
    }

    @Deprecated
    public boolean a(Canvas canvas) {
        return this.f362b.draw(canvas);
    }

    @Deprecated
    public boolean b() {
        return this.f362b.isFinished();
    }

    @Deprecated
    public boolean c(int i) {
        this.f362b.onAbsorb(i);
        return true;
    }

    @Deprecated
    public boolean d(float f, float f2) {
        f361a.a(this.f362b, f, f2);
        return true;
    }

    @Deprecated
    public boolean e() {
        this.f362b.onRelease();
        return this.f362b.isFinished();
    }

    @Deprecated
    public void f(int i, int i2) {
        this.f362b.setSize(i, i2);
    }
}
