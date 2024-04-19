package com.xiaopeng.device.communication.b.a;
/* compiled from: IcmCrashCallbackAdapter.java */
/* loaded from: classes.dex */
public class i extends a {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f2224a = {554702429};

    @Override // com.xiaopeng.device.communication.b.a.a
    @Deprecated
    protected final void a(int i, Object obj) {
        b.d.b.e.c.l("IcmCrashCallbackAdapter", "BugHunter IcmCrashCallbackAdapter propertyId = " + i);
        if (i == 554702429 && (obj instanceof String)) {
            b((String) obj);
        }
    }

    protected void b(String str) {
        throw null;
    }
}
