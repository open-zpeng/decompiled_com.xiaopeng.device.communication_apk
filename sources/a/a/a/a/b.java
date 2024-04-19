package a.a.a.a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* compiled from: DefaultTaskExecutor.java */
/* loaded from: classes.dex */
public class b extends c {

    /* renamed from: a  reason: collision with root package name */
    private final Object f140a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private ExecutorService f141b = Executors.newFixedThreadPool(2);

    /* renamed from: c  reason: collision with root package name */
    private volatile Handler f142c;

    @Override // a.a.a.a.c
    public void a(Runnable runnable) {
        this.f141b.execute(runnable);
    }

    @Override // a.a.a.a.c
    public boolean b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    @Override // a.a.a.a.c
    public void c(Runnable runnable) {
        if (this.f142c == null) {
            synchronized (this.f140a) {
                if (this.f142c == null) {
                    this.f142c = new Handler(Looper.getMainLooper());
                }
            }
        }
        this.f142c.post(runnable);
    }
}
