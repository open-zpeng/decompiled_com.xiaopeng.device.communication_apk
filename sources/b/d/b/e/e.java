package b.d.b.e;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.SystemProperties;
import com.xiaopeng.libconfig.ipc.AccountConfig;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/* compiled from: NetUtils.java */
/* loaded from: classes.dex */
public class e {
    public static int a(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context != null && (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) != null) {
            if (activeNetworkInfo.getType() == 0) {
                switch (activeNetworkInfo.getSubtype()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                        return 1;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return 2;
                    case 13:
                        return 3;
                }
            } else if (activeNetworkInfo.getType() == 1) {
                return 10;
            }
        }
        return 0;
    }

    public static int b() {
        return SystemProperties.getInt("persist.sys.xp.4g.st", 3);
    }

    public static boolean c(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 0;
    }

    public static boolean d(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        return connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected();
    }

    public static boolean e() {
        BufferedReader bufferedReader;
        boolean z = true;
        if ("on".equals(SystemProperties.get("persist.sys.ril.gobinet"))) {
            File file = new File("/sys/class/net/xpusb0/operstate");
            if (file.exists()) {
                BufferedReader bufferedReader2 = null;
                try {
                    try {
                        bufferedReader = new BufferedReader(new FileReader(file));
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (IOException e) {
                    e = e;
                }
                try {
                    String readLine = bufferedReader.readLine();
                    if (!AccountConfig.FaceIDRegisterAction.ORIENTATION_UP.equals(readLine)) {
                        if (!"unknown".equals(readLine)) {
                            z = false;
                        }
                    }
                    b.a(bufferedReader);
                    return z;
                } catch (IOException e2) {
                    e = e2;
                    bufferedReader2 = bufferedReader;
                    e.printStackTrace();
                    b.a(bufferedReader2);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader2 = bufferedReader;
                    b.a(bufferedReader2);
                    throw th;
                }
            }
            return true;
        }
        return true;
    }
}
