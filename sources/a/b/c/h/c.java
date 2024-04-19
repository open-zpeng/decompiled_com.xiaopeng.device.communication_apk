package a.b.c.h;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
/* compiled from: ScrollerCompat.java */
@Deprecated
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    OverScroller f367a;

    c(Context context, Interpolator interpolator) {
        this.f367a = interpolator != null ? new OverScroller(context, interpolator) : new OverScroller(context);
    }

    @Deprecated
    public static c c(Context context) {
        return d(context, null);
    }

    @Deprecated
    public static c d(Context context, Interpolator interpolator) {
        return new c(context, interpolator);
    }

    @Deprecated
    public void a() {
        this.f367a.abortAnimation();
    }

    @Deprecated
    public boolean b() {
        return this.f367a.computeScrollOffset();
    }

    @Deprecated
    public void e(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.f367a.fling(i, i2, i3, i4, i5, i6, i7, i8);
    }

    @Deprecated
    public float f() {
        return this.f367a.getCurrVelocity();
    }

    @Deprecated
    public int g() {
        return this.f367a.getCurrX();
    }

    @Deprecated
    public int h() {
        return this.f367a.getCurrY();
    }

    @Deprecated
    public int i() {
        return this.f367a.getFinalX();
    }

    @Deprecated
    public int j() {
        return this.f367a.getFinalY();
    }

    @Deprecated
    public boolean k() {
        return this.f367a.isFinished();
    }

    @Deprecated
    public void l(int i, int i2, int i3, int i4, int i5) {
        this.f367a.startScroll(i, i2, i3, i4, i5);
    }
}
