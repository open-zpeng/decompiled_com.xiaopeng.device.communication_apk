package c.a.p.g;

import c.a.j;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ComputationScheduler.java */
/* loaded from: classes.dex */
public final class b extends c.a.j {

    /* renamed from: b  reason: collision with root package name */
    static final C0067b f1745b;

    /* renamed from: c  reason: collision with root package name */
    static final f f1746c;

    /* renamed from: d  reason: collision with root package name */
    static final int f1747d = d(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());
    static final c e;
    final ThreadFactory f;
    final AtomicReference<C0067b> g;

    /* compiled from: ComputationScheduler.java */
    /* loaded from: classes.dex */
    static final class a extends j.b {

        /* renamed from: a  reason: collision with root package name */
        private final c.a.p.a.e f1748a;

        /* renamed from: b  reason: collision with root package name */
        private final c.a.m.a f1749b;

        /* renamed from: c  reason: collision with root package name */
        private final c.a.p.a.e f1750c;

        /* renamed from: d  reason: collision with root package name */
        private final c f1751d;
        volatile boolean e;

        a(c cVar) {
            this.f1751d = cVar;
            c.a.p.a.e eVar = new c.a.p.a.e();
            this.f1748a = eVar;
            c.a.m.a aVar = new c.a.m.a();
            this.f1749b = aVar;
            c.a.p.a.e eVar2 = new c.a.p.a.e();
            this.f1750c = eVar2;
            eVar2.c(eVar);
            eVar2.c(aVar);
        }

        @Override // c.a.j.b
        public c.a.m.b b(Runnable runnable) {
            if (this.e) {
                return c.a.p.a.d.INSTANCE;
            }
            return this.f1751d.d(runnable, 0L, TimeUnit.MILLISECONDS, this.f1748a);
        }

        @Override // c.a.j.b
        public c.a.m.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.e) {
                return c.a.p.a.d.INSTANCE;
            }
            return this.f1751d.d(runnable, j, timeUnit, this.f1749b);
        }

        @Override // c.a.m.b
        public void dispose() {
            if (this.e) {
                return;
            }
            this.e = true;
            this.f1750c.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ComputationScheduler.java */
    /* renamed from: c.a.p.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0067b {

        /* renamed from: a  reason: collision with root package name */
        final int f1752a;

        /* renamed from: b  reason: collision with root package name */
        final c[] f1753b;

        /* renamed from: c  reason: collision with root package name */
        long f1754c;

        C0067b(int i, ThreadFactory threadFactory) {
            this.f1752a = i;
            this.f1753b = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.f1753b[i2] = new c(threadFactory);
            }
        }

        public c a() {
            int i = this.f1752a;
            if (i == 0) {
                return b.e;
            }
            c[] cVarArr = this.f1753b;
            long j = this.f1754c;
            this.f1754c = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void b() {
            for (c cVar : this.f1753b) {
                cVar.dispose();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ComputationScheduler.java */
    /* loaded from: classes.dex */
    public static final class c extends e {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        c cVar = new c(new f("RxComputationShutdown"));
        e = cVar;
        cVar.dispose();
        f fVar = new f("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        f1746c = fVar;
        C0067b c0067b = new C0067b(0, fVar);
        f1745b = c0067b;
        c0067b.b();
    }

    public b() {
        this(f1746c);
    }

    static int d(int i, int i2) {
        return (i2 <= 0 || i2 > i) ? i : i2;
    }

    @Override // c.a.j
    public j.b a() {
        return new a(this.g.get().a());
    }

    @Override // c.a.j
    public c.a.m.b c(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.g.get().a().e(runnable, j, timeUnit);
    }

    public void e() {
        C0067b c0067b = new C0067b(f1747d, this.f);
        if (this.g.compareAndSet(f1745b, c0067b)) {
            return;
        }
        c0067b.b();
    }

    public b(ThreadFactory threadFactory) {
        this.f = threadFactory;
        this.g = new AtomicReference<>(f1745b);
        e();
    }
}
