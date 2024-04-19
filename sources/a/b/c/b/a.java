package a.b.c.b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
/* compiled from: ContextCompat.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f251a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static TypedValue f252b;

    public static final Drawable a(Context context, int i) {
        int i2;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 21) {
            return context.getDrawable(i);
        }
        if (i3 >= 16) {
            return context.getResources().getDrawable(i);
        }
        synchronized (f251a) {
            if (f252b == null) {
                f252b = new TypedValue();
            }
            context.getResources().getValue(i, f252b, true);
            i2 = f252b.resourceId;
        }
        return context.getResources().getDrawable(i2);
    }
}
