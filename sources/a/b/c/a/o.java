package a.b.c.a;

import android.os.Bundle;
/* compiled from: RemoteInputCompatJellybean.java */
/* loaded from: classes.dex */
class o {
    static Bundle a(n nVar) {
        new Bundle();
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Bundle[] b(n[] nVarArr) {
        if (nVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[nVarArr.length];
        for (int i = 0; i < nVarArr.length; i++) {
            bundleArr[i] = a(nVarArr[i]);
        }
        return bundleArr;
    }
}
