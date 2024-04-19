package b.d.b.d.g;

import android.content.Context;
import android.os.Build;
import android.view.Choreographer;
/* compiled from: Caton.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f1366a;

    /* renamed from: b  reason: collision with root package name */
    static d f1367b = d.LOOPER;

    /* compiled from: Caton.java */
    /* renamed from: b.d.b.d.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0059b {

        /* renamed from: c  reason: collision with root package name */
        private Context f1370c;
        private c f;

        /* renamed from: a  reason: collision with root package name */
        private long f1368a = 3000;

        /* renamed from: b  reason: collision with root package name */
        private long f1369b = 1000;

        /* renamed from: d  reason: collision with root package name */
        private d f1371d = b.f1367b;
        private boolean e = true;

        public C0059b(Context context) {
            this.f1370c = context;
        }

        b a() {
            return new b(this.f1370c, this.f1368a, this.f1369b, this.f1371d, this.e, this.f);
        }

        public C0059b b(c cVar) {
            this.f = cVar;
            return this;
        }

        public C0059b c(long j) {
            this.f1369b = j;
            return this;
        }

        public C0059b d(boolean z) {
            this.e = z;
            return this;
        }

        public C0059b e(d dVar) {
            this.f1371d = dVar;
            return this;
        }

        public C0059b f(long j) {
            this.f1368a = j;
            return this;
        }
    }

    /* compiled from: Caton.java */
    /* loaded from: classes.dex */
    public interface c {
        void a(String[] strArr, boolean z, long... jArr);
    }

    /* compiled from: Caton.java */
    /* loaded from: classes.dex */
    public enum d {
        LOOPER(0),
        FRAME(1);
        

        /* renamed from: a  reason: collision with root package name */
        int f1372a;

        d(int i) {
            this.f1372a = i;
        }
    }

    public static void a(C0059b c0059b) {
        if (f1366a == null) {
            synchronized (b.class) {
                if (f1366a == null) {
                    f1366a = c0059b.a();
                }
            }
        }
    }

    private b(Context context, long j, long j2, d dVar, boolean z, c cVar) {
        long min = Math.min(Math.max(j, 200L), 400L);
        long min2 = Math.min(Math.max(j2, 200L), 400L);
        b.d.b.d.g.d.f1374b = z;
        b.d.b.d.g.d.f1373a = min;
        b.d.b.d.g.a aVar = new b.d.b.d.g.a(context, new b.d.b.d.f(min2), cVar);
        if (dVar == d.LOOPER) {
            new f(aVar);
        } else if (dVar == d.FRAME) {
            if (Build.VERSION.SDK_INT >= 16) {
                Choreographer.getInstance().postFrameCallback(new e(context, aVar));
                return;
            }
            new f(aVar);
        }
    }
}
