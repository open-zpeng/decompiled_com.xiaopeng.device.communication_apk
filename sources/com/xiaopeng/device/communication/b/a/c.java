package com.xiaopeng.device.communication.b.a;

import android.car.Car;
import android.content.Context;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import java.util.HashSet;
import java.util.Set;
/* compiled from: CarApi.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static m f2211a;

    /* renamed from: b  reason: collision with root package name */
    private static SparseArray<h> f2212b = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    private static Set<h> f2213c = new HashSet();

    /* renamed from: d  reason: collision with root package name */
    private static volatile boolean f2214d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CarApi.java */
    /* loaded from: classes.dex */
    public static class a implements g {
        a() {
        }

        @Override // com.xiaopeng.device.communication.b.a.g
        public void a() {
            boolean unused = c.f2214d = false;
        }

        @Override // com.xiaopeng.device.communication.b.a.g
        public void b() {
            boolean unused = c.f2214d = true;
            for (h hVar : c.f2213c) {
                hVar.a();
            }
            c.f2213c.clear();
        }
    }

    private static void c(int i) {
        if (i != 100 && i != 101 && i != 102 && i != 103 && i != 104 && i != 105 && i != 106 && i != 107 && i != 108 && i != 109 && i != 110 && i != 111 && i != 112) {
            throw new IllegalArgumentException("Error Car API name!");
        }
    }

    private static void d(Context context) {
        Log.i("CarApi", "DeviceCommunication execute connectCar()...");
        m mVar = new m(context);
        f2211a = mVar;
        mVar.h(new a());
        f2211a.c();
    }

    private static synchronized h e(int i) {
        h hVar;
        synchronized (c.class) {
            c(i);
            hVar = null;
            if (i == 101) {
                hVar = new com.xiaopeng.device.communication.b.b.c();
            } else if (i == 103) {
                hVar = new k();
            } else if (i == 108) {
                hVar = new l();
            }
        }
        return hVar;
    }

    public static Car f() {
        return (Car) f2211a.d();
    }

    public static h g(int i) {
        h hVar = f2212b.get(i);
        if (hVar == null) {
            hVar = e(i);
            if (f2211a.e()) {
                hVar.a();
            } else {
                f2213c.add(hVar);
            }
            f2212b.put(i, hVar);
        }
        return hVar;
    }

    public static String h() {
        String str = SystemProperties.get("ro.xiaopeng.software", "");
        return !TextUtils.isEmpty(str) ? str.substring(9, 12) : str;
    }

    public static void i(Context context) {
        d(context);
    }

    public static boolean j() {
        return f2214d;
    }
}
