package com.xiaopeng.lib.apirouter.server;

import android.os.IBinder;
import android.support.annotation.Keep;
import android.util.Pair;
import java.util.HashMap;
@Keep
/* loaded from: classes.dex */
public class ManifestHelper {
    public static HashMap<String, Pair<IBinder, String>> mapping = new HashMap<>();

    static {
        Pair<IBinder, String> pair = new Pair<>(new e(), d.b());
        for (String str : d.a()) {
            mapping.put(str, pair);
        }
    }
}
