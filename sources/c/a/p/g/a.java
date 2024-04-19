package c.a.p.g;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: AbstractDirectTask.java */
/* loaded from: classes.dex */
abstract class a extends AtomicReference<Future<?>> implements c.a.m.b {

    /* renamed from: a  reason: collision with root package name */
    protected static final FutureTask<Void> f1741a;

    /* renamed from: b  reason: collision with root package name */
    protected static final FutureTask<Void> f1742b;
    private static final long serialVersionUID = 1811839108042568751L;

    /* renamed from: c  reason: collision with root package name */
    protected final Runnable f1743c;

    /* renamed from: d  reason: collision with root package name */
    protected Thread f1744d;

    static {
        Runnable runnable = c.a.p.b.a.f1623b;
        f1741a = new FutureTask<>(runnable, null);
        f1742b = new FutureTask<>(runnable, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Runnable runnable) {
        this.f1743c = runnable;
    }

    public final void a(Future<?> future) {
        Future<?> future2;
        do {
            future2 = get();
            if (future2 == f1741a) {
                return;
            }
            if (future2 == f1742b) {
                future.cancel(this.f1744d != Thread.currentThread());
                return;
            }
        } while (!compareAndSet(future2, future));
    }

    @Override // c.a.m.b
    public final void dispose() {
        FutureTask<Void> futureTask;
        Future<?> future = get();
        if (future == f1741a || future == (futureTask = f1742b) || !compareAndSet(future, futureTask) || future == null) {
            return;
        }
        future.cancel(this.f1744d != Thread.currentThread());
    }
}
