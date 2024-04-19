package b.c.a.j;

import android.os.SystemClock;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* compiled from: Progress.java */
/* loaded from: classes.dex */
public class c implements Serializable {
    private static final long serialVersionUID = 6353658567594109891L;

    /* renamed from: a  reason: collision with root package name */
    public String f1247a;

    /* renamed from: b  reason: collision with root package name */
    public String f1248b;

    /* renamed from: c  reason: collision with root package name */
    public String f1249c;

    /* renamed from: d  reason: collision with root package name */
    public String f1250d;
    public String e;
    public float f;
    public long h;
    public transient long i;
    public int j;
    private transient long m;
    private transient long n = SystemClock.elapsedRealtime();
    public long g = -1;
    public int k = 0;
    public long l = System.currentTimeMillis();
    private transient List<Long> o = new ArrayList();

    /* compiled from: Progress.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(c cVar);
    }

    private long a(long j) {
        this.o.add(Long.valueOf(j));
        if (this.o.size() > 10) {
            this.o.remove(0);
        }
        long j2 = 0;
        for (Long l : this.o) {
            j2 = ((float) j2) + ((float) l.longValue());
        }
        return j2 / this.o.size();
    }

    public static c b(c cVar, long j, long j2, a aVar) {
        cVar.g = j2;
        cVar.h += j;
        cVar.m += j;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j3 = cVar.n;
        if ((elapsedRealtime - j3 >= b.c.a.a.f1162a) || cVar.h == j2) {
            long j4 = elapsedRealtime - j3;
            if (j4 == 0) {
                j4 = 1;
            }
            cVar.f = (((float) cVar.h) * 1.0f) / ((float) j2);
            cVar.i = cVar.a((cVar.m * 1000) / j4);
            cVar.n = elapsedRealtime;
            cVar.m = 0L;
            if (aVar != null) {
                aVar.a(cVar);
            }
        }
        return cVar;
    }

    public static c c(c cVar, long j, a aVar) {
        return b(cVar, j, cVar.g, aVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        String str = this.f1247a;
        String str2 = ((c) obj).f1247a;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int hashCode() {
        String str = this.f1247a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "Progress{fraction=" + this.f + ", totalSize=" + this.g + ", currentSize=" + this.h + ", speed=" + this.i + ", status=" + this.j + ", priority=" + this.k + ", folder=" + this.f1249c + ", filePath=" + this.f1250d + ", fileName=" + this.e + ", tag=" + this.f1247a + ", url=" + this.f1248b + '}';
    }
}
