package a.b.c.e;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
/* compiled from: ICUCompatApi21.java */
/* loaded from: classes.dex */
class b {

    /* renamed from: a  reason: collision with root package name */
    private static Method f277a;

    static {
        try {
            f277a = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", Locale.class);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public static String a(Locale locale) {
        try {
            return ((Locale) f277a.invoke(null, locale)).getScript();
        } catch (IllegalAccessException e) {
            Log.w("ICUCompatApi21", e);
            return locale.getScript();
        } catch (InvocationTargetException e2) {
            Log.w("ICUCompatApi21", e2);
            return locale.getScript();
        }
    }
}
