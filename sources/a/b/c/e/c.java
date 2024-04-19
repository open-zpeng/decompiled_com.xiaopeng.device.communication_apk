package a.b.c.e;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
/* compiled from: ICUCompatIcs.java */
/* loaded from: classes.dex */
class c {

    /* renamed from: a  reason: collision with root package name */
    private static Method f278a;

    /* renamed from: b  reason: collision with root package name */
    private static Method f279b;

    static {
        try {
            Class<?> cls = Class.forName("libcore.icu.ICU");
            f278a = cls.getMethod("getScript", String.class);
            f279b = cls.getMethod("addLikelySubtags", String.class);
        } catch (Exception e) {
            f278a = null;
            f279b = null;
            Log.w("ICUCompatIcs", e);
        }
    }

    private static String a(Locale locale) {
        String locale2 = locale.toString();
        try {
            Method method = f279b;
            if (method != null) {
                return (String) method.invoke(null, locale2);
            }
        } catch (IllegalAccessException e) {
            Log.w("ICUCompatIcs", e);
        } catch (InvocationTargetException e2) {
            Log.w("ICUCompatIcs", e2);
        }
        return locale2;
    }

    private static String b(String str) {
        try {
            Method method = f278a;
            if (method != null) {
                return (String) method.invoke(null, str);
            }
        } catch (IllegalAccessException e) {
            Log.w("ICUCompatIcs", e);
        } catch (InvocationTargetException e2) {
            Log.w("ICUCompatIcs", e2);
        }
        return null;
    }

    public static String c(Locale locale) {
        String a2 = a(locale);
        if (a2 != null) {
            return b(a2);
        }
        return null;
    }
}
