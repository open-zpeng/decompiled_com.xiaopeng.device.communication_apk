package b.d.b.e;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
/* compiled from: ThreadUtils.java */
/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private static final ExecutorService f1399a = Executors.newFixedThreadPool(4, new d(null).f("order-%d").e(false).d());

    /* renamed from: b  reason: collision with root package name */
    private static ConcurrentHashMap<Object, c> f1400b = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private static Handler f1401c;

    /* renamed from: d  reason: collision with root package name */
    private static volatile HandlerThread f1402d;
    private static Handler e;
    private static volatile HandlerThread f;
    private static Handler g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ThreadUtils.java */
    /* loaded from: classes.dex */
    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Runnable f1403a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Runnable f1404b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f1405c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Looper f1406d;

        a(Runnable runnable, Runnable runnable2, boolean z, Looper looper) {
            this.f1403a = runnable;
            this.f1404b = runnable2;
            this.f1405c = z;
            this.f1406d = looper;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f1403a.run();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (this.f1404b != null) {
                if (this.f1405c || this.f1406d == i.f1401c.getLooper()) {
                    i.f1401c.post(this.f1404b);
                } else {
                    new Handler(this.f1406d).post(this.f1404b);
                }
            }
            b.d.b.e.c.a("ThreadUtils", "remove task: " + this.f1403a);
            i.f1400b.remove(this.f1403a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ThreadUtils.java */
    /* loaded from: classes.dex */
    public static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Runnable f1407a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f1408b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Looper f1409c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Handler f1410d;
        final /* synthetic */ Runnable e;

        /* compiled from: ThreadUtils.java */
        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f1407a.run();
                b bVar = b.this;
                bVar.f1410d.post(bVar.e);
            }
        }

        /* compiled from: ThreadUtils.java */
        /* renamed from: b.d.b.e.i$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0060b implements Runnable {
            RunnableC0060b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f1407a.run();
                b bVar = b.this;
                bVar.f1410d.post(bVar.e);
            }
        }

        b(Runnable runnable, boolean z, Looper looper, Handler handler, Runnable runnable2) {
            this.f1407a = runnable;
            this.f1408b = z;
            this.f1409c = looper;
            this.f1410d = handler;
            this.e = runnable2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f1407a != null) {
                if (this.f1408b || this.f1409c == i.f1401c.getLooper()) {
                    i.f1401c.post(new a());
                    return;
                } else {
                    new Handler(this.f1409c).post(new RunnableC0060b());
                    return;
                }
            }
            this.e.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ThreadUtils.java */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        private Runnable f1413a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f1414b;

        public c(Runnable runnable, Integer num) {
            this.f1413a = runnable;
            this.f1414b = num;
        }
    }

    private static synchronized void c() {
        synchronized (i.class) {
            if (f1402d == null) {
                f1402d = new HandlerThread("BackgroundHandler", 10);
                f1402d.start();
                e = new Handler(f1402d.getLooper());
            }
        }
    }

    private static synchronized void d() {
        synchronized (i.class) {
            if (f1401c == null) {
                f1401c = new Handler(Looper.getMainLooper());
            }
        }
    }

    private static synchronized void e() {
        synchronized (i.class) {
            if (f == null) {
                f = new HandlerThread("NormalHandler", 0);
                f.start();
                g = new Handler(f.getLooper());
            }
        }
    }

    private static void f(int i, Runnable runnable, Runnable runnable2, Runnable runnable3, boolean z, long j) {
        Handler handler;
        if (runnable2 == null) {
            return;
        }
        if (f1401c == null) {
            d();
        }
        if (i == 0) {
            if (f1402d == null) {
                c();
            }
            handler = e;
        } else if (i == 1) {
            handler = f1401c;
        } else if (i != 2) {
            handler = f1401c;
        } else {
            if (f == null) {
                e();
            }
            handler = g;
        }
        if (handler == null) {
            handler = f1401c;
        }
        Looper looper = null;
        if (!z && (looper = Looper.myLooper()) == null) {
            looper = f1401c.getLooper();
        }
        Looper looper2 = looper;
        a aVar = new a(runnable2, runnable3, z, looper2);
        b bVar = new b(runnable, z, looper2, handler, aVar);
        if (runnable == null) {
            f1400b.put(runnable2, new c(bVar, Integer.valueOf(i)));
        } else {
            f1400b.put(runnable2, new c(aVar, Integer.valueOf(i)));
        }
        b.d.b.e.c.a("ThreadUtils", "put task: " + runnable2);
        handler.postDelayed(bVar, j);
    }

    public static Looper g(int i) {
        if (i == 0) {
            c();
            return f1402d.getLooper();
        } else if (i == 1) {
            d();
            return f1401c.getLooper();
        } else if (i == 2) {
            e();
            return g.getLooper();
        } else {
            throw new IllegalArgumentException("invalid threadType:" + i);
        }
    }

    public static void h(int i, Runnable runnable) {
        f(i, null, runnable, null, false, 0L);
    }

    public static void i(Runnable runnable) {
        f(0, null, runnable, null, false, 0L);
    }

    public static void j(Runnable runnable, long j) {
        f(0, null, runnable, null, false, j);
    }

    public static void k(int i, Runnable runnable, long j) {
        f(i, null, runnable, null, false, j);
    }

    /* compiled from: ThreadUtils.java */
    /* loaded from: classes.dex */
    private static class d {

        /* renamed from: a  reason: collision with root package name */
        private String f1415a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f1416b;

        /* renamed from: c  reason: collision with root package name */
        private ThreadFactory f1417c;

        /* renamed from: d  reason: collision with root package name */
        private String f1418d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ThreadUtils.java */
        /* loaded from: classes.dex */
        public class a implements ThreadFactory {
            a() {
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread newThread = (d.this.f1417c != null ? d.this.f1417c : Executors.defaultThreadFactory()).newThread(runnable);
                AtomicLong atomicLong = d.this.f1418d != null ? new AtomicLong(0L) : null;
                if (d.this.f1418d != null) {
                    newThread.setName(String.format(Locale.ROOT, d.this.f1418d, Long.valueOf(atomicLong.getAndIncrement())));
                }
                newThread.setDaemon(d.this.f1416b);
                return newThread;
            }
        }

        private d() {
            this.f1415a = "newFixedThreadPool";
            this.f1416b = false;
        }

        ThreadFactory d() {
            return new a();
        }

        d e(boolean z) {
            this.f1416b = z;
            return this;
        }

        d f(String str) {
            this.f1418d = str;
            return this;
        }

        /* synthetic */ d(h hVar) {
            this();
        }
    }
}
