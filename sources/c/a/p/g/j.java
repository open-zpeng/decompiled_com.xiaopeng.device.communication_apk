package c.a.p.g;

import c.a.j;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: SingleScheduler.java */
/* loaded from: classes.dex */
public final class j extends c.a.j {

    /* renamed from: b  reason: collision with root package name */
    static final f f1784b;

    /* renamed from: c  reason: collision with root package name */
    static final ScheduledExecutorService f1785c;

    /* renamed from: d  reason: collision with root package name */
    final ThreadFactory f1786d;
    final AtomicReference<ScheduledExecutorService> e;

    /* compiled from: SingleScheduler.java */
    /* loaded from: classes.dex */
    static final class a extends j.b {

        /* renamed from: a  reason: collision with root package name */
        final ScheduledExecutorService f1787a;

        /* renamed from: b  reason: collision with root package name */
        final c.a.m.a f1788b = new c.a.m.a();

        /* renamed from: c  reason: collision with root package name */
        volatile boolean f1789c;

        a(ScheduledExecutorService scheduledExecutorService) {
            this.f1787a = scheduledExecutorService;
        }

        @Override // c.a.j.b
        public c.a.m.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            Future<?> schedule;
            if (this.f1789c) {
                return c.a.p.a.d.INSTANCE;
            }
            h hVar = new h(c.a.s.a.o(runnable), this.f1788b);
            this.f1788b.c(hVar);
            try {
                if (j <= 0) {
                    schedule = this.f1787a.submit((Callable) hVar);
                } else {
                    schedule = this.f1787a.schedule((Callable) hVar, j, timeUnit);
                }
                hVar.a(schedule);
                return hVar;
            } catch (RejectedExecutionException e) {
                dispose();
                c.a.s.a.m(e);
                return c.a.p.a.d.INSTANCE;
            }
        }

        @Override // c.a.m.b
        public void dispose() {
            if (this.f1789c) {
                return;
            }
            this.f1789c = true;
            this.f1788b.dispose();
        }
    }

    static {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(0);
        f1785c = newScheduledThreadPool;
        newScheduledThreadPool.shutdown();
        f1784b = new f("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);
    }

    public j() {
        this(f1784b);
    }

    static ScheduledExecutorService d(ThreadFactory threadFactory) {
        return i.a(threadFactory);
    }

    @Override // c.a.j
    public j.b a() {
        return new a(this.e.get());
    }

    @Override // c.a.j
    public c.a.m.b c(Runnable runnable, long j, TimeUnit timeUnit) {
        Future<?> schedule;
        g gVar = new g(c.a.s.a.o(runnable));
        try {
            if (j <= 0) {
                schedule = this.e.get().submit(gVar);
            } else {
                schedule = this.e.get().schedule(gVar, j, timeUnit);
            }
            gVar.a(schedule);
            return gVar;
        } catch (RejectedExecutionException e) {
            c.a.s.a.m(e);
            return c.a.p.a.d.INSTANCE;
        }
    }

    public j(ThreadFactory threadFactory) {
        AtomicReference<ScheduledExecutorService> atomicReference = new AtomicReference<>();
        this.e = atomicReference;
        this.f1786d = threadFactory;
        atomicReference.lazySet(d(threadFactory));
    }
}
