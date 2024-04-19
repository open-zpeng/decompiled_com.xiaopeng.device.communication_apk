package a.b.c.c.b;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
/* compiled from: DrawableWrapperApi14.java */
/* loaded from: classes.dex */
class c extends Drawable implements Drawable.Callback, a.b.c.c.b.b, f {

    /* renamed from: a  reason: collision with root package name */
    static final PorterDuff.Mode f268a = PorterDuff.Mode.SRC_IN;

    /* renamed from: b  reason: collision with root package name */
    private int f269b;

    /* renamed from: c  reason: collision with root package name */
    private PorterDuff.Mode f270c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f271d;
    a e;
    private boolean f;
    Drawable g;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: DrawableWrapperApi14.java */
    /* loaded from: classes.dex */
    public static abstract class a extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        int f272a;

        /* renamed from: b  reason: collision with root package name */
        Drawable.ConstantState f273b;

        /* renamed from: c  reason: collision with root package name */
        ColorStateList f274c;

        /* renamed from: d  reason: collision with root package name */
        PorterDuff.Mode f275d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(a aVar, Resources resources) {
            this.f274c = null;
            this.f275d = c.f268a;
            if (aVar != null) {
                this.f272a = aVar.f272a;
                this.f273b = aVar.f273b;
                this.f274c = aVar.f274c;
                this.f275d = aVar.f275d;
            }
        }

        boolean a() {
            return this.f273b != null;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            int i = this.f272a;
            Drawable.ConstantState constantState = this.f273b;
            return i | (constantState != null ? constantState.getChangingConfigurations() : 0);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return newDrawable(null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public abstract Drawable newDrawable(Resources resources);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DrawableWrapperApi14.java */
    /* loaded from: classes.dex */
    public static class b extends a {
        b(a aVar, Resources resources) {
            super(aVar, resources);
        }

        @Override // a.b.c.c.b.c.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new c(this, resources);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, Resources resources) {
        this.e = aVar;
        f(resources);
    }

    private void f(Resources resources) {
        Drawable.ConstantState constantState;
        a aVar = this.e;
        if (aVar == null || (constantState = aVar.f273b) == null) {
            return;
        }
        e(d(constantState, resources));
    }

    private boolean g(int[] iArr) {
        if (b()) {
            a aVar = this.e;
            ColorStateList colorStateList = aVar.f274c;
            PorterDuff.Mode mode = aVar.f275d;
            if (colorStateList != null && mode != null) {
                int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
                if (!this.f271d || colorForState != this.f269b || mode != this.f270c) {
                    setColorFilter(colorForState, mode);
                    this.f269b = colorForState;
                    this.f270c = mode;
                    this.f271d = true;
                    return true;
                }
            } else {
                this.f271d = false;
                clearColorFilter();
            }
            return false;
        }
        return false;
    }

    @Override // a.b.c.c.b.b
    public final Drawable a() {
        return this.g;
    }

    protected boolean b() {
        return true;
    }

    a c() {
        return new b(this.e, null);
    }

    protected Drawable d(Drawable.ConstantState constantState, Resources resources) {
        return constantState.newDrawable(resources);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.g.draw(canvas);
    }

    public final void e(Drawable drawable) {
        Drawable drawable2 = this.g;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.g = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            a aVar = this.e;
            if (aVar != null) {
                aVar.f273b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        a aVar = this.e;
        return changingConfigurations | (aVar != null ? aVar.getChangingConfigurations() : 0) | this.g.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        a aVar = this.e;
        if (aVar == null || !aVar.a()) {
            return null;
        }
        this.e.f272a = getChangingConfigurations();
        return this.e;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.g.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.g.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.g.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.g.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.g.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.g.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.g.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        return this.g.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.g.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        a aVar;
        ColorStateList colorStateList = (!b() || (aVar = this.e) == null) ? null : aVar.f274c;
        return (colorStateList != null && colorStateList.isStateful()) || this.g.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.g.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f && super.mutate() == this) {
            this.e = c();
            Drawable drawable = this.g;
            if (drawable != null) {
                drawable.mutate();
            }
            a aVar = this.e;
            if (aVar != null) {
                Drawable drawable2 = this.g;
                aVar.f273b = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.f = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.g;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        return this.g.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.g.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i) {
        this.g.setChangingConfigurations(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.g.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.g.setDither(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.g.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return g(iArr) || this.g.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable, a.b.c.c.b.f
    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable, a.b.c.c.b.f
    public void setTintList(ColorStateList colorStateList) {
        this.e.f274c = colorStateList;
        g(getState());
    }

    @Override // android.graphics.drawable.Drawable, a.b.c.c.b.f
    public void setTintMode(PorterDuff.Mode mode) {
        this.e.f275d = mode;
        g(getState());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.g.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Drawable drawable) {
        this.e = c();
        e(drawable);
    }
}
