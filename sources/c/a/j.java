package c.a;

import java.util.concurrent.TimeUnit;
/* compiled from: Scheduler.java */
/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a  reason: collision with root package name */
    static final long f1599a = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Scheduler.java */
    /* loaded from: classes.dex */
    public static final class a implements c.a.m.b, Runnable {

        /* renamed from: a  reason: collision with root package name */
        final Runnable f1600a;

        /* renamed from: b  reason: collision with root package name */
        final b f1601b;

        /* renamed from: c  reason: collision with root package name */
        Thread f1602c;

        a(Runnable runnable, b bVar) {
            this.f1600a = runnable;
            this.f1601b = bVar;
        }

        @Override // c.a.m.b
        public void dispose() {
            if (this.f1602c == Thread.currentThread()) {
                b bVar = this.f1601b;
                if (bVar instanceof c.a.p.g.e) {
                    ((c.a.p.g.e) bVar).f();
                    return;
                }
            }
            this.f1601b.dispose();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1602c = Thread.currentThread();
            try {
                this.f1600a.run();
            } finally {
                dispose();
                this.f1602c = null;
            }
        }
    }

    /* compiled from: Scheduler.java */
    /* loaded from: classes.dex */
    public static abstract class b implements c.a.m.b {
        public long a(TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        public c.a.m.b b(Runnable runnable) {
            return c(runnable, 0L, TimeUnit.NANOSECONDS);
        }

        public abstract c.a.m.b c(Runnable runnable, long j, TimeUnit timeUnit);
    }

    public abstract b a();

    public c.a.m.b b(Runnable runnable) {
        return c(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public c.a.m.b c(Runnable runnable, long j, TimeUnit timeUnit) {
        b a2 = a();
        a aVar = new a(c.a.s.a.o(runnable), a2);
        a2.c(aVar, j, timeUnit);
        return aVar;
    }
}
