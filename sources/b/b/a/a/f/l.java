package b.b.a.a.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
/* compiled from: NetworkUtil.java */
/* loaded from: classes.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private static String[] f1123a = {"Unknown", "Unknown"};

    /* renamed from: b  reason: collision with root package name */
    private static c f1124b = new c();

    /* renamed from: c  reason: collision with root package name */
    private static b f1125c = new b();

    /* compiled from: NetworkUtil.java */
    /* loaded from: classes.dex */
    private static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private Context f1126a;

        private b() {
        }

        public b a(Context context) {
            this.f1126a = context;
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context context = this.f1126a;
            if (context == null) {
                return;
            }
            try {
                if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", this.f1126a.getPackageName()) != 0) {
                    l.f1123a[0] = "Unknown";
                    return;
                }
                ConnectivityManager connectivityManager = (ConnectivityManager) this.f1126a.getSystemService("connectivity");
                if (connectivityManager == null) {
                    l.f1123a[0] = "Unknown";
                    return;
                }
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                    return;
                }
                if (1 == activeNetworkInfo.getType()) {
                    l.f1123a[0] = "Wi-Fi";
                } else if (activeNetworkInfo.getType() == 0) {
                    l.f1123a[0] = "2G/3G";
                    l.f1123a[1] = activeNetworkInfo.getSubtypeName();
                }
            } catch (Exception unused) {
            }
        }
    }

    /* compiled from: NetworkUtil.java */
    /* loaded from: classes.dex */
    private static class c extends BroadcastReceiver {
        private c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            s.a().g(l.f1125c.a(context));
        }
    }

    private static String b(int i) {
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return "2G";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return "3G";
            case 13:
                return "4G";
            default:
                return "Unknown";
        }
    }

    public static void d(Context context) {
        if (context == null) {
            return;
        }
        context.registerReceiver(f1124b, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public static void e(Context context) {
        c cVar;
        if (context == null || (cVar = f1124b) == null) {
            return;
        }
        context.unregisterReceiver(cVar);
    }

    public static String[] f(Context context) {
        return f1123a;
    }

    public static boolean g() {
        Context j = b.b.a.a.a.j();
        if (j != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) j.getSystemService("connectivity");
                if (connectivityManager != null) {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo != null) {
                        return activeNetworkInfo.isConnected();
                    }
                    return false;
                }
                return true;
            } catch (Exception unused) {
                return true;
            }
        }
        return true;
    }

    public static String h() {
        NetworkInfo activeNetworkInfo;
        Context j = b.b.a.a.a.j();
        if (j == null) {
            return "Unknown";
        }
        try {
            if (j.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", j.getPackageName()) == 0 && (activeNetworkInfo = ((ConnectivityManager) j.getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
                if (activeNetworkInfo.getType() == 1) {
                    return "wifi";
                }
                if (activeNetworkInfo.getType() == 0) {
                    return b(activeNetworkInfo.getSubtype());
                }
            }
        } catch (Throwable unused) {
        }
        return "Unknown";
    }
}
