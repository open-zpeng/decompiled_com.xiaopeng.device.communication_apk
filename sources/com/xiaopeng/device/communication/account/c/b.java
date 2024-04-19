package com.xiaopeng.device.communication.account.c;
/* compiled from: AccountState.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private int f2196a;

    /* compiled from: AccountState.java */
    /* renamed from: com.xiaopeng.device.communication.account.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static final class C0092b {

        /* renamed from: a  reason: collision with root package name */
        private static final b f2197a = new b();
    }

    public static b b() {
        return C0092b.f2197a;
    }

    public void a() {
        b.d.b.e.c.l("AccountModel", "############# AccountState fail!");
        this.f2196a = 0;
    }

    public boolean c() {
        return this.f2196a > 0;
    }

    public void d() {
        b.d.b.e.c.l("AccountModel", "############# AccountState start!");
        this.f2196a = 1;
    }

    public void e() {
        b.d.b.e.c.l("AccountModel", "############# AccountState success!");
        this.f2196a = 2;
    }

    private b() {
    }
}
