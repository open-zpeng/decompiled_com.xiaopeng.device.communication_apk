package c.a.p.g;

import c.a.j;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
/* compiled from: NewThreadWorker.java */
/* loaded from: classes.dex */
public class e extends j.b implements c.a.m.b {

    /* renamed from: a  reason: collision with root package name */
    private final ScheduledExecutorService f1769a;

    /* renamed from: b  reason: collision with root package name */
    volatile boolean f1770b;

    public e(ThreadFactory threadFactory) {
        this.f1769a = i.a(threadFactory);
    }

    @Override // c.a.j.b
    public c.a.m.b b(Runnable runnable) {
        return c(runnable, 0L, null);
    }

    @Override // c.a.j.b
    public c.a.m.b c(Runnable runnable, long j, TimeUnit timeUnit) {
        if (this.f1770b) {
            return c.a.p.a.d.INSTANCE;
        }
        return d(runnable, j, timeUnit, null);
    }

    public h d(Runnable runnable, long j, TimeUnit timeUnit, c.a.p.a.b bVar) {
        Future<?> schedule;
        h hVar = new h(c.a.s.a.o(runnable), bVar);
        if (bVar == null || bVar.c(hVar)) {
            try {
                if (j <= 0) {
                    schedule = this.f1769a.submit((Callable) hVar);
                } else {
                    schedule = this.f1769a.schedule((Callable) hVar, j, timeUnit);
                }
                hVar.a(schedule);
            } catch (RejectedExecutionException e) {
                if (bVar != null) {
                    bVar.b(hVar);
                }
                c.a.s.a.m(e);
            }
            return hVar;
        }
        return hVar;
    }

    @Override // c.a.m.b
    public void dispose() {
        if (this.f1770b) {
            return;
        }
        this.f1770b = true;
        this.f1769a.shutdownNow();
    }

    public c.a.m.b e(Runnable runnable, long j, TimeUnit timeUnit) {
        Future<?> schedule;
        g gVar = new g(c.a.s.a.o(runnable));
        try {
            if (j <= 0) {
                schedule = this.f1769a.submit(gVar);
            } else {
                schedule = this.f1769a.schedule(gVar, j, timeUnit);
            }
            gVar.a(schedule);
            return gVar;
        } catch (RejectedExecutionException e) {
            c.a.s.a.m(e);
            return c.a.p.a.d.INSTANCE;
        }
    }

    public void f() {
        if (this.f1770b) {
            return;
        }
        this.f1770b = true;
        this.f1769a.shutdown();
    }
}
