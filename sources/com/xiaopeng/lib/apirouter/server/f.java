package com.xiaopeng.lib.apirouter.server;

import android.os.IBinder;
import android.util.Log;
import android.util.Pair;
import java.lang.reflect.Field;
import java.util.HashMap;
/* compiled from: ManifestHelperMapping.java */
/* loaded from: classes.dex */
class f {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static HashMap<String, Pair<IBinder, String>> a() {
        try {
            Class<?> cls = Class.forName("com.xiaopeng.lib.apirouter.server.ManifestHelper");
            Field field = cls.getField("mapping");
            if (field != null) {
                return (HashMap) field.get(cls);
            }
            return null;
        } catch (Exception e) {
            Log.e("AutoCodeMatcher", "reflectMapping", e);
            return null;
        }
    }
}
