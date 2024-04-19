package a.b.c.e;

import android.os.Build;
import java.util.Locale;
/* compiled from: ICUCompat.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final b f276a;

    /* compiled from: ICUCompat.java */
    /* renamed from: a.b.c.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0012a extends b {
        C0012a() {
        }

        @Override // a.b.c.e.a.b
        public String a(Locale locale) {
            return a.b.c.e.b.a(locale);
        }
    }

    /* compiled from: ICUCompat.java */
    /* loaded from: classes.dex */
    static class b {
        b() {
        }

        public String a(Locale locale) {
            return c.c(locale);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            f276a = new C0012a();
        } else {
            f276a = new b();
        }
    }

    public static String a(Locale locale) {
        return f276a.a(locale);
    }
}
