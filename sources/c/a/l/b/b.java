package c.a.l.b;

import android.os.Handler;
import android.os.Message;
import c.a.j;
import c.a.m.c;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
/* compiled from: HandlerScheduler.java */
/* loaded from: classes.dex */
final class b extends j {

    /* renamed from: b  reason: collision with root package name */
    private final Handler f1607b;

    /* compiled from: HandlerScheduler.java */
    /* loaded from: classes.dex */
    private static final class a extends j.b {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f1608a;

        /* renamed from: b  reason: collision with root package name */
        private volatile boolean f1609b;

        a(Handler handler) {
            this.f1608a = handler;
        }

        @Override // c.a.j.b
        public c.a.m.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            Objects.requireNonNull(runnable, "run == null");
            Objects.requireNonNull(timeUnit, "unit == null");
            if (this.f1609b) {
                return c.a();
            }
            RunnableC0062b runnableC0062b = new RunnableC0062b(this.f1608a, c.a.s.a.o(runnable));
            Message obtain = Message.obtain(this.f1608a, runnableC0062b);
            obtain.obj = this;
            this.f1608a.sendMessageDelayed(obtain, Math.max(0L, timeUnit.toMillis(j)));
            if (this.f1609b) {
                this.f1608a.removeCallbacks(runnableC0062b);
                return c.a();
            }
            return runnableC0062b;
        }

        @Override // c.a.m.b
        public void dispose() {
            this.f1609b = true;
            this.f1608a.removeCallbacksAndMessages(this);
        }
    }

    /* compiled from: HandlerScheduler.java */
    /* renamed from: c.a.l.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static final class RunnableC0062b implements Runnable, c.a.m.b {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f1610a;

        /* renamed from: b  reason: collision with root package name */
        private final Runnable f1611b;

        /* renamed from: c  reason: collision with root package name */
        private volatile boolean f1612c;

        RunnableC0062b(Handler handler, Runnable runnable) {
            this.f1610a = handler;
            this.f1611b = runnable;
        }

        @Override // c.a.m.b
        public void dispose() {
            this.f1612c = true;
            this.f1610a.removeCallbacks(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f1611b.run();
            } catch (Throwable th) {
                IllegalStateException illegalStateException = new IllegalStateException("Fatal Exception thrown on Scheduler.", th);
                c.a.s.a.m(illegalStateException);
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, illegalStateException);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Handler handler) {
        this.f1607b = handler;
    }

    @Override // c.a.j
    public j.b a() {
        return new a(this.f1607b);
    }

    @Override // c.a.j
    public c.a.m.b c(Runnable runnable, long j, TimeUnit timeUnit) {
        Objects.requireNonNull(runnable, "run == null");
        Objects.requireNonNull(timeUnit, "unit == null");
        RunnableC0062b runnableC0062b = new RunnableC0062b(this.f1607b, c.a.s.a.o(runnable));
        this.f1607b.postDelayed(runnableC0062b, Math.max(0L, timeUnit.toMillis(j)));
        return runnableC0062b;
    }
}
