package b.b.a.a.f;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IInputController;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: TaskExecutor.java */
/* loaded from: classes.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    private static ThreadPoolExecutor f1131a = null;

    /* renamed from: b  reason: collision with root package name */
    private static int f1132b = 1;

    /* renamed from: c  reason: collision with root package name */
    private static int f1133c = 3;

    /* renamed from: d  reason: collision with root package name */
    private static int f1134d = 10;
    private static int e = 60;
    public static s f;
    private static final AtomicInteger g = new AtomicInteger();
    private HandlerThread h;
    private Handler i;

    /* compiled from: TaskExecutor.java */
    /* loaded from: classes.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            try {
                Object obj = message.obj;
                if (obj == null || !(obj instanceof Runnable)) {
                    return;
                }
                s.f().submit((Runnable) message.obj);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TaskExecutor.java */
    /* loaded from: classes.dex */
    public static class b implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private int f1136a;

        public b(int i) {
            this.f1136a = i;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            int andIncrement = s.g.getAndIncrement();
            Thread thread = new Thread(runnable, "AppMonitor:" + andIncrement);
            thread.setPriority(this.f1136a);
            return thread;
        }
    }

    private s() {
        HandlerThread handlerThread = new HandlerThread("AppMonitor");
        this.h = handlerThread;
        handlerThread.start();
        this.i = new a(this.h.getLooper());
    }

    public static synchronized s a() {
        s sVar;
        synchronized (s.class) {
            if (f == null) {
                f = new s();
            }
            sVar = f;
        }
        return sVar;
    }

    private static synchronized ThreadPoolExecutor b() {
        ThreadPoolExecutor threadPoolExecutor;
        synchronized (s.class) {
            if (f1131a == null) {
                f1131a = c(f1132b, f1133c, f1134d, e, IInputController.KEYCODE_KNOB_WIND_SPD_UP);
            }
            threadPoolExecutor = f1131a;
        }
        return threadPoolExecutor;
    }

    @TargetApi(9)
    private static ThreadPoolExecutor c(int i, int i2, int i3, int i4, int i5) {
        LinkedBlockingQueue linkedBlockingQueue;
        if (i5 > 0) {
            linkedBlockingQueue = new LinkedBlockingQueue(i5);
        } else {
            linkedBlockingQueue = new LinkedBlockingQueue();
        }
        b bVar = new b(i);
        return new ThreadPoolExecutor(i2, i3, i4, TimeUnit.SECONDS, linkedBlockingQueue, bVar, new ThreadPoolExecutor.DiscardOldestPolicy());
    }

    static /* synthetic */ ThreadPoolExecutor f() {
        return b();
    }

    public final void e(int i, Runnable runnable, long j) {
        try {
            Message obtain = Message.obtain(this.i, i);
            obtain.obj = runnable;
            this.i.sendMessageDelayed(obtain, j);
        } catch (Exception e2) {
            com.alibaba.mtl.appmonitor.i.b.d(e2);
        }
    }

    public void g(Runnable runnable) {
        try {
            b().submit(runnable);
        } catch (Throwable unused) {
        }
    }

    public final boolean h(int i) {
        return this.i.hasMessages(i);
    }

    public final void i(int i) {
        this.i.removeMessages(i);
    }
}
