package c.a.p.g;

import c.a.j;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: IoScheduler.java */
/* loaded from: classes.dex */
public final class c extends c.a.j {

    /* renamed from: b  reason: collision with root package name */
    static final f f1755b;

    /* renamed from: c  reason: collision with root package name */
    static final f f1756c;

    /* renamed from: d  reason: collision with root package name */
    private static final TimeUnit f1757d = TimeUnit.SECONDS;
    static final C0068c e;
    static final a f;
    final ThreadFactory g;
    final AtomicReference<a> h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IoScheduler.java */
    /* loaded from: classes.dex */
    public static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final long f1758a;

        /* renamed from: b  reason: collision with root package name */
        private final ConcurrentLinkedQueue<C0068c> f1759b;

        /* renamed from: c  reason: collision with root package name */
        final c.a.m.a f1760c;

        /* renamed from: d  reason: collision with root package name */
        private final ScheduledExecutorService f1761d;
        private final Future<?> e;
        private final ThreadFactory f;

        a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            long nanos = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.f1758a = nanos;
            this.f1759b = new ConcurrentLinkedQueue<>();
            this.f1760c = new c.a.m.a();
            this.f = threadFactory;
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, c.f1756c);
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(this, nanos, nanos, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.f1761d = scheduledExecutorService;
            this.e = scheduledFuture;
        }

        void a() {
            if (this.f1759b.isEmpty()) {
                return;
            }
            long c2 = c();
            Iterator<C0068c> it = this.f1759b.iterator();
            while (it.hasNext()) {
                C0068c next = it.next();
                if (next.g() > c2) {
                    return;
                }
                if (this.f1759b.remove(next)) {
                    this.f1760c.b(next);
                }
            }
        }

        C0068c b() {
            if (this.f1760c.e()) {
                return c.e;
            }
            while (!this.f1759b.isEmpty()) {
                C0068c poll = this.f1759b.poll();
                if (poll != null) {
                    return poll;
                }
            }
            C0068c c0068c = new C0068c(this.f);
            this.f1760c.c(c0068c);
            return c0068c;
        }

        long c() {
            return System.nanoTime();
        }

        void d(C0068c c0068c) {
            c0068c.h(c() + this.f1758a);
            this.f1759b.offer(c0068c);
        }

        void e() {
            this.f1760c.dispose();
            Future<?> future = this.e;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.f1761d;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
        }
    }

    /* compiled from: IoScheduler.java */
    /* loaded from: classes.dex */
    static final class b extends j.b {

        /* renamed from: b  reason: collision with root package name */
        private final a f1763b;

        /* renamed from: c  reason: collision with root package name */
        private final C0068c f1764c;

        /* renamed from: d  reason: collision with root package name */
        final AtomicBoolean f1765d = new AtomicBoolean();

        /* renamed from: a  reason: collision with root package name */
        private final c.a.m.a f1762a = new c.a.m.a();

        b(a aVar) {
            this.f1763b = aVar;
            this.f1764c = aVar.b();
        }

        @Override // c.a.j.b
        public c.a.m.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.f1762a.e()) {
                return c.a.p.a.d.INSTANCE;
            }
            return this.f1764c.d(runnable, j, timeUnit, this.f1762a);
        }

        @Override // c.a.m.b
        public void dispose() {
            if (this.f1765d.compareAndSet(false, true)) {
                this.f1762a.dispose();
                this.f1763b.d(this.f1764c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IoScheduler.java */
    /* renamed from: c.a.p.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0068c extends e {

        /* renamed from: c  reason: collision with root package name */
        private long f1766c;

        C0068c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.f1766c = 0L;
        }

        public long g() {
            return this.f1766c;
        }

        public void h(long j) {
            this.f1766c = j;
        }
    }

    static {
        C0068c c0068c = new C0068c(new f("RxCachedThreadSchedulerShutdown"));
        e = c0068c;
        c0068c.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        f fVar = new f("RxCachedThreadScheduler", max);
        f1755b = fVar;
        f1756c = new f("RxCachedWorkerPoolEvictor", max);
        a aVar = new a(0L, null, fVar);
        f = aVar;
        aVar.e();
    }

    public c() {
        this(f1755b);
    }

    @Override // c.a.j
    public j.b a() {
        return new b(this.h.get());
    }

    public void d() {
        a aVar = new a(60L, f1757d, this.g);
        if (this.h.compareAndSet(f, aVar)) {
            return;
        }
        aVar.e();
    }

    public c(ThreadFactory threadFactory) {
        this.g = threadFactory;
        this.h = new AtomicReference<>(f);
        d();
    }
}
