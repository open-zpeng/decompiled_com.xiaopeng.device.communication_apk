package a.b.c.b.c;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
/* compiled from: ResourcesCompat.java */
/* loaded from: classes.dex */
public final class a {
    public static Drawable a(Resources resources, int i, Resources.Theme theme) throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 21) {
            return resources.getDrawable(i, theme);
        }
        return resources.getDrawable(i);
    }
}
