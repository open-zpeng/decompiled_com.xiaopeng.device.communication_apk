package com.xiaopeng.device.communication.b.a;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* compiled from: CarApiThreadPool.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static ExecutorService f2215a = Executors.newCachedThreadPool();

    public static void a(Runnable runnable) {
        f2215a.execute(runnable);
    }
}
