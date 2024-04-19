package c.a.p.g;

import c.a.j;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: TrampolineScheduler.java */
/* loaded from: classes.dex */
public final class k extends c.a.j {

    /* renamed from: b  reason: collision with root package name */
    private static final k f1790b = new k();

    /* compiled from: TrampolineScheduler.java */
    /* loaded from: classes.dex */
    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final Runnable f1791a;

        /* renamed from: b  reason: collision with root package name */
        private final c f1792b;

        /* renamed from: c  reason: collision with root package name */
        private final long f1793c;

        a(Runnable runnable, c cVar, long j) {
            this.f1791a = runnable;
            this.f1792b = cVar;
            this.f1793c = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f1792b.f1801d) {
                return;
            }
            long a2 = this.f1792b.a(TimeUnit.MILLISECONDS);
            long j = this.f1793c;
            if (j > a2) {
                try {
                    Thread.sleep(j - a2);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    c.a.s.a.m(e);
                    return;
                }
            }
            if (this.f1792b.f1801d) {
                return;
            }
            this.f1791a.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TrampolineScheduler.java */
    /* loaded from: classes.dex */
    public static final class b implements Comparable<b> {

        /* renamed from: a  reason: collision with root package name */
        final Runnable f1794a;

        /* renamed from: b  reason: collision with root package name */
        final long f1795b;

        /* renamed from: c  reason: collision with root package name */
        final int f1796c;

        /* renamed from: d  reason: collision with root package name */
        volatile boolean f1797d;

        b(Runnable runnable, Long l, int i) {
            this.f1794a = runnable;
            this.f1795b = l.longValue();
            this.f1796c = i;
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b bVar) {
            int b2 = c.a.p.b.b.b(this.f1795b, bVar.f1795b);
            return b2 == 0 ? c.a.p.b.b.a(this.f1796c, bVar.f1796c) : b2;
        }
    }

    /* compiled from: TrampolineScheduler.java */
    /* loaded from: classes.dex */
    static final class c extends j.b implements c.a.m.b {

        /* renamed from: a  reason: collision with root package name */
        final PriorityBlockingQueue<b> f1798a = new PriorityBlockingQueue<>();

        /* renamed from: b  reason: collision with root package name */
        private final AtomicInteger f1799b = new AtomicInteger();

        /* renamed from: c  reason: collision with root package name */
        final AtomicInteger f1800c = new AtomicInteger();

        /* renamed from: d  reason: collision with root package name */
        volatile boolean f1801d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TrampolineScheduler.java */
        /* loaded from: classes.dex */
        public final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final b f1802a;

            a(b bVar) {
                this.f1802a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f1802a.f1797d = true;
                c.this.f1798a.remove(this.f1802a);
            }
        }

        c() {
        }

        @Override // c.a.j.b
        public c.a.m.b b(Runnable runnable) {
            return d(runnable, a(TimeUnit.MILLISECONDS));
        }

        @Override // c.a.j.b
        public c.a.m.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            long a2 = a(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j);
            return d(new a(runnable, this, a2), a2);
        }

        c.a.m.b d(Runnable runnable, long j) {
            if (this.f1801d) {
                return c.a.p.a.d.INSTANCE;
            }
            b bVar = new b(runnable, Long.valueOf(j), this.f1800c.incrementAndGet());
            this.f1798a.add(bVar);
            if (this.f1799b.getAndIncrement() == 0) {
                int i = 1;
                while (!this.f1801d) {
                    b poll = this.f1798a.poll();
                    if (poll == null) {
                        i = this.f1799b.addAndGet(-i);
                        if (i == 0) {
                            return c.a.p.a.d.INSTANCE;
                        }
                    } else if (!poll.f1797d) {
                        poll.f1794a.run();
                    }
                }
                this.f1798a.clear();
                return c.a.p.a.d.INSTANCE;
            }
            return c.a.m.c.b(new a(bVar));
        }

        @Override // c.a.m.b
        public void dispose() {
            this.f1801d = true;
        }
    }

    k() {
    }

    public static k d() {
        return f1790b;
    }

    @Override // c.a.j
    public j.b a() {
        return new c();
    }

    @Override // c.a.j
    public c.a.m.b b(Runnable runnable) {
        c.a.s.a.o(runnable).run();
        return c.a.p.a.d.INSTANCE;
    }

    @Override // c.a.j
    public c.a.m.b c(Runnable runnable, long j, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j);
            c.a.s.a.o(runnable).run();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            c.a.s.a.m(e);
        }
        return c.a.p.a.d.INSTANCE;
    }
}
