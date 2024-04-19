package a.b.c.c.b;

import a.b.c.c.b.c;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
/* compiled from: DrawableWrapperApi19.java */
/* loaded from: classes.dex */
class d extends c {

    /* compiled from: DrawableWrapperApi19.java */
    /* loaded from: classes.dex */
    private static class a extends c.a {
        a(c.a aVar, Resources resources) {
            super(aVar, resources);
        }

        @Override // a.b.c.c.b.c.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new d(this, resources);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Drawable drawable) {
        super(drawable);
    }

    @Override // a.b.c.c.b.c
    c.a c() {
        return new a(this.e, null);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.g.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        this.g.setAutoMirrored(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c.a aVar, Resources resources) {
        super(aVar, resources);
    }
}
