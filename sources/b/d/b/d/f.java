package b.d.b.d;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
/* compiled from: StackTraceCollector.java */
/* loaded from: classes.dex */
public class f implements b.d.b.d.g.c {

    /* renamed from: a  reason: collision with root package name */
    private long f1353a;

    /* renamed from: b  reason: collision with root package name */
    private volatile a f1354b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<StackTraceElement[]> f1355c;

    /* renamed from: d  reason: collision with root package name */
    private int[] f1356d;
    private StackTraceElement[] e;
    private Thread f;
    private int g;
    private volatile boolean h;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: StackTraceCollector.java */
    /* loaded from: classes.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 54 || i == 55) {
                if (i == 54) {
                    f.this.n();
                }
                StackTraceElement[] j = f.this.j();
                if (f.l(j, f.this.e)) {
                    f.this.k();
                } else {
                    f.this.i(j);
                }
                if (f.this.m()) {
                    f.this.o(55);
                }
            }
        }
    }

    public f(long j) {
        this.f1353a = j;
        HandlerThread handlerThread = new HandlerThread("StackTraceCollector");
        handlerThread.setPriority(10);
        handlerThread.start();
        this.f1354b = new a(handlerThread.getLooper());
        this.g = 3;
        this.f1355c = new ArrayList<>(3);
        this.f1356d = new int[this.g];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public StackTraceElement[] j() {
        if (this.f == null) {
            this.f = Looper.getMainLooper().getThread();
        }
        return this.f.getStackTrace();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        synchronized (this.f1355c) {
            int size = this.f1355c.size() - 1;
            int[] iArr = this.f1356d;
            iArr[size] = iArr[size] + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean l(StackTraceElement[] stackTraceElementArr, StackTraceElement[] stackTraceElementArr2) {
        int length;
        if (stackTraceElementArr == null || stackTraceElementArr2 == null || (length = stackTraceElementArr.length) != stackTraceElementArr2.length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (!stackTraceElementArr[i].equals(stackTraceElementArr2[i])) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        synchronized (this.f1355c) {
            if (!this.f1355c.isEmpty()) {
                this.e = null;
                this.f1355c.clear();
                Arrays.fill(this.f1356d, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(int i) {
        Message obtainMessage = this.f1354b.obtainMessage();
        obtainMessage.obj = this;
        obtainMessage.what = i;
        this.f1354b.sendMessageDelayed(obtainMessage, this.f1353a);
    }

    @Override // b.d.b.d.g.c
    public StackTraceElement[][] a() {
        StackTraceElement[][] stackTraceElementArr;
        synchronized (this.f1355c) {
            stackTraceElementArr = (StackTraceElement[][]) this.f1355c.toArray((StackTraceElement[][]) Array.newInstance(StackTraceElement.class, 0, 0));
        }
        return stackTraceElementArr;
    }

    @Override // b.d.b.d.g.c
    public int[] b() {
        int[] copyOf;
        synchronized (this.f1355c) {
            int[] iArr = this.f1356d;
            copyOf = Arrays.copyOf(iArr, iArr.length);
        }
        return copyOf;
    }

    public void i(StackTraceElement[] stackTraceElementArr) {
        synchronized (this.f1355c) {
            this.e = stackTraceElementArr;
            int size = this.f1355c.size();
            int i = this.g;
            if (size >= i) {
                int i2 = i - 1;
                int i3 = this.f1356d[i2];
                int i4 = i2;
                for (int i5 = i2 - 1; i5 >= 1; i5--) {
                    int[] iArr = this.f1356d;
                    if (i3 > iArr[i5]) {
                        i3 = iArr[i5];
                        i4 = i5;
                    }
                }
                this.f1355c.remove(i4);
                while (i4 < i2) {
                    int[] iArr2 = this.f1356d;
                    int i6 = i4 + 1;
                    iArr2[i4] = iArr2[i6];
                    i4 = i6;
                }
                this.f1356d[i2] = 0;
            }
            this.f1355c.add(stackTraceElementArr);
            this.f1356d[this.f1355c.size() - 1] = 1;
        }
    }

    public boolean m() {
        return this.h;
    }

    @Override // b.d.b.d.g.c
    public void start() {
        this.h = true;
        o(54);
    }

    @Override // b.d.b.d.g.c
    public void stop() {
        this.h = false;
        this.f1354b.removeMessages(54);
        this.f1354b.removeMessages(55);
    }
}
