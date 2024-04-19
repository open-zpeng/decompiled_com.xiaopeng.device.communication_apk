package c.a.p.g;

import java.util.concurrent.Callable;
/* compiled from: ScheduledDirectTask.java */
/* loaded from: classes.dex */
public final class g extends a implements Callable<Void> {
    private static final long serialVersionUID = 1811839108042568751L;

    public g(Runnable runnable) {
        super(runnable);
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: b */
    public Void call() throws Exception {
        this.f1744d = Thread.currentThread();
        try {
            this.f1743c.run();
            return null;
        } finally {
            lazySet(a.f1741a);
            this.f1744d = null;
        }
    }
}
