package com.ta.utdid2.b.a;

import java.lang.reflect.Method;
/* compiled from: DebugUtils.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static Class<?> f2126a;

    /* renamed from: a  reason: collision with other field name */
    private static Method f111a;

    /* renamed from: b  reason: collision with root package name */
    private static Method f2127b;
    public static boolean e;

    static {
        e = getInt("alidebug", 0) == 1;
        f2126a = null;
        f111a = null;
        f2127b = null;
    }

    private static void a() {
        try {
            if (f2126a == null) {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                f2126a = cls;
                f111a = cls.getDeclaredMethod("get", String.class);
                f2127b = f2126a.getDeclaredMethod("getInt", String.class, Integer.TYPE);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static int getInt(String str, int i) {
        a();
        try {
            return ((Integer) f2127b.invoke(f2126a, str, Integer.valueOf(i))).intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return i;
        }
    }
}
