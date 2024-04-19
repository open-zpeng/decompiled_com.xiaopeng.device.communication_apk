package a.b.c.a;

import android.app.ActivityManager;
import android.os.Build;
/* compiled from: ActivityManagerCompat.java */
/* loaded from: classes.dex */
public final class a {
    public static boolean a(ActivityManager activityManager) {
        if (Build.VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        return false;
    }
}
