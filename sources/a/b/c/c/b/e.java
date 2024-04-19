package a.b.c.c.b;

import a.b.c.c.b.c;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.Method;
/* compiled from: DrawableWrapperApi21.java */
/* loaded from: classes.dex */
class e extends d {
    private static Method h;

    /* compiled from: DrawableWrapperApi21.java */
    /* loaded from: classes.dex */
    private static class a extends c.a {
        a(c.a aVar, Resources resources) {
            super(aVar, resources);
        }

        @Override // a.b.c.c.b.c.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new e(this, resources);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Drawable drawable) {
        super(drawable);
        h();
    }

    private void h() {
        if (h == null) {
            try {
                h = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
            } catch (Exception e) {
                Log.w("DrawableWrapperApi21", "Failed to retrieve Drawable#isProjected() method", e);
            }
        }
    }

    @Override // a.b.c.c.b.c
    protected boolean b() {
        if (Build.VERSION.SDK_INT == 21) {
            Drawable drawable = this.g;
            return (drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable) || (drawable instanceof RippleDrawable);
        }
        return false;
    }

    @Override // a.b.c.c.b.d, a.b.c.c.b.c
    c.a c() {
        return new a(this.e, null);
    }

    @Override // android.graphics.drawable.Drawable
    public Rect getDirtyBounds() {
        return this.g.getDirtyBounds();
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        this.g.getOutline(outline);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isProjected() {
        Method method;
        Drawable drawable = this.g;
        if (drawable != null && (method = h) != null) {
            try {
                return ((Boolean) method.invoke(drawable, new Object[0])).booleanValue();
            } catch (Exception e) {
                Log.w("DrawableWrapperApi21", "Error calling Drawable#isProjected() method", e);
            }
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f, float f2) {
        this.g.setHotspot(f, f2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        this.g.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // a.b.c.c.b.c, android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        if (super.setState(iArr)) {
            invalidateSelf();
            return true;
        }
        return false;
    }

    @Override // a.b.c.c.b.c, android.graphics.drawable.Drawable, a.b.c.c.b.f
    public void setTint(int i) {
        if (b()) {
            super.setTint(i);
        } else {
            this.g.setTint(i);
        }
    }

    @Override // a.b.c.c.b.c, android.graphics.drawable.Drawable, a.b.c.c.b.f
    public void setTintList(ColorStateList colorStateList) {
        if (b()) {
            super.setTintList(colorStateList);
        } else {
            this.g.setTintList(colorStateList);
        }
    }

    @Override // a.b.c.c.b.c, android.graphics.drawable.Drawable, a.b.c.c.b.f
    public void setTintMode(PorterDuff.Mode mode) {
        if (b()) {
            super.setTintMode(mode);
        } else {
            this.g.setTintMode(mode);
        }
    }

    e(c.a aVar, Resources resources) {
        super(aVar, resources);
        h();
    }
}
