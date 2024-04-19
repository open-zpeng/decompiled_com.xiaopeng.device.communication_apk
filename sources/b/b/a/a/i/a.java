package b.b.a.a.i;

import b.b.a.a.a;
import b.b.a.a.f.i;
import b.b.a.a.f.s;
import java.util.Random;
/* compiled from: UploadEngine.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    static a f1154a = new a();

    /* renamed from: b  reason: collision with root package name */
    protected long f1155b = a.b.a();

    /* renamed from: c  reason: collision with root package name */
    private boolean f1156c = false;

    /* renamed from: d  reason: collision with root package name */
    private int f1157d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UploadEngine.java */
    /* renamed from: b.b.a.a.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0040a extends b {
        C0040a() {
        }

        @Override // b.b.a.a.i.b
        public void a() {
            if (a.this.f1156c) {
                b.b.a.a.b.a.c();
                a.this.c();
                i.c("UploadTask", "mPeriod:", Long.valueOf(a.this.f1155b));
                if (s.a().h(2)) {
                    s.a().i(2);
                }
                if (b.k()) {
                    return;
                }
                s.a().e(2, this, a.this.f1155b);
            }
        }

        @Override // b.b.a.a.i.b
        public void b() {
            a.this.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long c() {
        long a2;
        int i;
        i.c("UploadEngine", "UTDC.bBackground:", Boolean.valueOf(b.b.a.a.a.f1051c), "AppInfoUtil.isForeground(UTDC.getContext()) ", Boolean.valueOf(b.b.a.a.f.b.b(b.b.a.a.a.j())));
        boolean z = !b.b.a.a.f.b.b(b.b.a.a.a.j());
        b.b.a.a.a.f1051c = z;
        a.b.a();
        if (z) {
            a2 = a.b.f();
            i = this.f1157d;
        } else {
            a2 = a.b.a();
            i = this.f1157d;
        }
        this.f1155b = a2 + i;
        if (a.b.g()) {
            this.f1155b = 3000L;
        }
        return this.f1155b;
    }

    public static a d() {
        return f1154a;
    }

    public void e() {
        if (this.f1157d == 0) {
            this.f1157d = 7000;
        } else {
            this.f1157d = 0;
        }
    }

    public synchronized void f() {
        this.f1156c = true;
        if (s.a().h(2)) {
            s.a().i(2);
        }
        c();
        Random random = new Random();
        if (!b.k()) {
            s.a().e(2, new C0040a(), random.nextInt((int) this.f1155b));
        }
    }

    public synchronized void g() {
        this.f1156c = false;
        s.a().i(2);
    }
}
