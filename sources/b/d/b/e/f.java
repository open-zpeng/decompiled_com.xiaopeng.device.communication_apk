package b.d.b.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
/* compiled from: SharedPreferencesUtils.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static volatile f f1391a;

    /* renamed from: b  reason: collision with root package name */
    private static int f1392b;

    /* renamed from: c  reason: collision with root package name */
    private SharedPreferences f1393c;

    /* renamed from: d  reason: collision with root package name */
    private SharedPreferences.Editor f1394d;

    private f(Context context, String str, int i) {
        str = TextUtils.isEmpty(str) ? context.getPackageName() : str;
        str = TextUtils.isEmpty(str) ? "shared_pref" : str;
        Log.v("SharedPreferencesUtils", "spName=" + str);
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        this.f1393c = sharedPreferences;
        SharedPreferences.Editor edit = sharedPreferences.edit();
        this.f1394d = edit;
        edit.apply();
    }

    public static f b(Context context) {
        f(context);
        return f1391a;
    }

    private static void f(Context context) {
        g(context, null);
    }

    private static void g(Context context, String str) {
        if (f1391a == null) {
            synchronized (f.class) {
                if (f1391a == null) {
                    f1391a = new f(context.getApplicationContext(), str, 0);
                    f1392b++;
                }
            }
        }
    }

    public float a(String str, float f) {
        return this.f1393c.getFloat(str, f);
    }

    public long c(String str, long j) {
        return this.f1393c.getLong(str, j);
    }

    public String d(String str) {
        return e(str, null);
    }

    public String e(String str, String str2) {
        return this.f1393c.getString(str, str2);
    }

    public void h(String str, float f) {
        this.f1394d.putFloat(str, f).commit();
    }

    public void i(String str, long j) {
        this.f1394d.putLong(str, j).commit();
    }

    public void j(String str, String str2) {
        this.f1394d.putString(str, str2).commit();
    }
}
