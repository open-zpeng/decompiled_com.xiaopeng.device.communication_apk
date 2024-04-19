package com.xiaopeng.lib.apirouter.server;

import android.os.IBinder;
import android.util.Log;
import android.util.Pair;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* compiled from: AutoCodeMatcher.java */
/* loaded from: classes.dex */
class a {

    /* renamed from: a  reason: collision with root package name */
    private static HashMap<String, Pair<IBinder, String>> f2319a;

    /* renamed from: b  reason: collision with root package name */
    private static List<b> f2320b = new LinkedList();

    /* renamed from: c  reason: collision with root package name */
    private static Object f2321c = new Object();

    private void a() {
        synchronized (f2321c) {
            if (!f2320b.isEmpty()) {
                for (b bVar : f2320b) {
                    b(bVar);
                }
            }
        }
    }

    private void b(b bVar) {
        c[] a2;
        if (bVar == null || (a2 = bVar.a()) == null || a2.length == 0) {
            return;
        }
        if (f2319a == null) {
            f2319a = new HashMap<>();
        }
        HashMap<String, Pair<IBinder, String>> hashMap = f2319a;
        for (c cVar : a2) {
            try {
                HashMap<String, Pair<IBinder, String>> a3 = cVar.a();
                if (a3 != null && !a3.isEmpty()) {
                    hashMap.putAll(a3);
                }
            } catch (Exception e) {
                Log.e("AutoCodeMatcher", "initManifestHandler:" + cVar.getClass(), e);
            }
        }
    }

    public Pair<IBinder, String> c(String str) {
        if (f2319a == null) {
            f2319a = f.a();
            a();
        }
        HashMap<String, Pair<IBinder, String>> hashMap = f2319a;
        Pair<IBinder, String> pair = hashMap == null ? null : hashMap.get(str);
        return pair == null ? new Pair<>(null, null) : pair;
    }
}
