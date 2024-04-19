package a.a.a.a;

import java.util.concurrent.Executor;
/* compiled from: ArchTaskExecutor.java */
/* loaded from: classes.dex */
public class a extends c {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f136a;

    /* renamed from: b  reason: collision with root package name */
    private static final Executor f137b = new ExecutorC0000a();

    /* renamed from: c  reason: collision with root package name */
    private static final Executor f138c = new b();

    /* renamed from: d  reason: collision with root package name */
    private c f139d;
    private c e;

    /* compiled from: ArchTaskExecutor.java */
    /* renamed from: a.a.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class ExecutorC0000a implements Executor {
        ExecutorC0000a() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.d().c(runnable);
        }
    }

    /* compiled from: ArchTaskExecutor.java */
    /* loaded from: classes.dex */
    static class b implements Executor {
        b() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.d().a(runnable);
        }
    }

    private a() {
        a.a.a.a.b bVar = new a.a.a.a.b();
        this.e = bVar;
        this.f139d = bVar;
    }

    public static a d() {
        if (f136a != null) {
            return f136a;
        }
        synchronized (a.class) {
            if (f136a == null) {
                f136a = new a();
            }
        }
        return f136a;
    }

    @Override // a.a.a.a.c
    public void a(Runnable runnable) {
        this.f139d.a(runnable);
    }

    @Override // a.a.a.a.c
    public boolean b() {
        return this.f139d.b();
    }

    @Override // a.a.a.a.c
    public void c(Runnable runnable) {
        this.f139d.c(runnable);
    }
}
