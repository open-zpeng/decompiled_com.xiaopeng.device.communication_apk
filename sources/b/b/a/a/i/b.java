package b.b.a.a.i;

import b.b.a.a.a;
import b.b.a.a.f.a;
import b.b.a.a.f.e;
import b.b.a.a.f.i;
import b.b.a.a.f.l;
import com.xiaopeng.lib.security.xmartv1.XmartV1Constants;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: UploadTask.java */
/* loaded from: classes.dex */
public abstract class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private static volatile boolean f1158a = false;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f1159b = false;

    /* renamed from: c  reason: collision with root package name */
    static int f1160c;

    /* renamed from: d  reason: collision with root package name */
    int f1161d = -1;
    float e = 200.0f;
    int f = 0;

    /* JADX WARN: Code restructure failed: missing block: B:70:0x016b, code lost:
        b.b.a.a.f.k.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01e2, code lost:
        b.b.a.a.i.b.f1158a = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void c() {
        /*
            Method dump skipped, instructions count: 493
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.b.a.a.i.b.c():void");
    }

    private int d(Boolean bool, long j) {
        if (j < 0) {
            return this.f1161d;
        }
        float f = this.f / ((float) j);
        if (!bool.booleanValue()) {
            this.f1161d /= 2;
            f1160c++;
        } else if (j > 45000) {
            return this.f1161d;
        } else {
            this.f1161d = (int) (((f * 45000.0f) / this.e) - f1160c);
        }
        int i = this.f1161d;
        if (i < 1) {
            this.f1161d = 1;
            f1160c = 0;
        } else if (i > 350) {
            this.f1161d = 350;
        }
        i.c("UploadTask", "winsize:", Integer.valueOf(this.f1161d));
        return this.f1161d;
    }

    private a.C0038a e(String str, Map<String, Object> map) {
        if (str != null) {
            byte[] bArr = e.a(2, str, map, false).f1110b;
            i.c("UploadTask", "url:", str);
            if (bArr != null) {
                String str2 = null;
                try {
                    str2 = new String(bArr, XmartV1Constants.UTF8_ENCODING);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                if (str2 != null) {
                    i.c("UploadTask", "result:", str2);
                    return b.b.a.a.f.a.a(str2);
                }
            }
        }
        return a.C0038a.f1094a;
    }

    private List<String> f(b.b.a.a.g.b bVar) {
        return a.b.c(bVar.f1144b);
    }

    private Map<String, Object> g(List<b.b.a.a.g.b> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < list.size(); i++) {
            List<String> f = f(list.get(i));
            if (f != null) {
                for (int i2 = 0; i2 < f.size(); i2++) {
                    StringBuilder sb = (StringBuilder) hashMap.get(f.get(i2));
                    if (sb == null) {
                        sb = new StringBuilder();
                        hashMap.put(f.get(i2), sb);
                    } else {
                        sb.append("\n");
                    }
                    sb.append(list.get(i).a());
                }
            }
        }
        HashMap hashMap2 = new HashMap();
        this.f = 0;
        for (String str : hashMap.keySet()) {
            byte[] h = h(((StringBuilder) hashMap.get(str)).toString());
            hashMap2.put(str, h);
            this.f += h.length;
        }
        float size = this.f / list.size();
        this.e = size;
        i.c("UploadTask", "averagePackageSize:", Float.valueOf(size));
        return hashMap2;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:1|2|3|4|(3:6|7|8)|9|11|12|13|14|15|(1:(0))) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private byte[] h(java.lang.String r4) {
        /*
            r3 = this;
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 0
            java.util.zip.GZIPOutputStream r2 = new java.util.zip.GZIPOutputStream     // Catch: java.lang.Throwable -> L21 java.io.IOException -> L23
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L21 java.io.IOException -> L23
            java.lang.String r1 = "UTF-8"
            byte[] r4 = r4.getBytes(r1)     // Catch: java.lang.Throwable -> L1b java.io.IOException -> L1e
            r2.write(r4)     // Catch: java.lang.Throwable -> L1b java.io.IOException -> L1e
            r2.flush()     // Catch: java.lang.Throwable -> L1b java.io.IOException -> L1e
            r2.close()     // Catch: java.lang.Exception -> L2c
            goto L2c
        L1b:
            r4 = move-exception
            r1 = r2
            goto L3a
        L1e:
            r4 = move-exception
            r1 = r2
            goto L24
        L21:
            r4 = move-exception
            goto L3a
        L23:
            r4 = move-exception
        L24:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L21
            if (r1 == 0) goto L2c
            r1.close()     // Catch: java.lang.Exception -> L2c
        L2c:
            byte[] r4 = r0.toByteArray()
            java.lang.String r1 = "QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn3j5JELI8H6wtACbUnZ5cc3aYTsTRbmkAkRJeYbtx92LPBWm7nBO9UIl7y5i5MQNmUZNf5QENurR5tGyo7yJ2G0MBjWvy6iAtlAbacKP0SwOUeUWx5dsBdyhxa7Id1APtybSdDgicBDuNjI0mlZFUzZSS9dmN8lBD0WTVOMz0pRZbR3cysomRXOO1ghqjJdTcyDIxzpNAEszN8RMGjrzyU7Hjbmwi6YNK"
            byte[] r4 = b.b.a.a.f.n.c(r4, r1)
            r0.close()     // Catch: java.lang.Exception -> L39
        L39:
            return r4
        L3a:
            if (r1 == 0) goto L3f
            r1.close()     // Catch: java.lang.Exception -> L3f
        L3f:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: b.b.a.a.i.b.h(java.lang.String):byte[]");
    }

    private int i(List<b.b.a.a.g.b> list) {
        if (list == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            String str = list.get(i2).f1144b;
            if (str != null && "6005".equalsIgnoreCase(str)) {
                i++;
            }
        }
        return i;
    }

    private int j() {
        if (this.f1161d == -1) {
            String h = l.h();
            if ("wifi".equalsIgnoreCase(h)) {
                this.f1161d = 20;
            } else if ("4G".equalsIgnoreCase(h)) {
                this.f1161d = 16;
            } else if ("3G".equalsIgnoreCase(h)) {
                this.f1161d = 12;
            } else {
                this.f1161d = 8;
            }
        }
        return this.f1161d;
    }

    public static boolean k() {
        return f1158a;
    }

    public abstract void a();

    public abstract void b();

    @Override // java.lang.Runnable
    public void run() {
        try {
            c();
            a();
        } catch (Throwable unused) {
        }
    }
}
