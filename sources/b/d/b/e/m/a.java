package b.d.b.e.m;

import android.os.Process;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
/* compiled from: AppInfoUtils.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f1428a;

    public static String a() {
        BufferedReader bufferedReader;
        Throwable th;
        Exception e;
        String str = f1428a;
        if (str != null) {
            return str;
        }
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader(new File("/proc/" + Process.myPid() + "/cmdline")));
                try {
                    f1428a = bufferedReader.readLine().trim();
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    f1428a = "";
                    b.d.b.e.b.a(bufferedReader);
                    return f1428a;
                }
            } catch (Throwable th2) {
                th = th2;
                b.d.b.e.b.a(bufferedReader);
                throw th;
            }
        } catch (Exception e3) {
            bufferedReader = null;
            e = e3;
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
            b.d.b.e.b.a(bufferedReader);
            throw th;
        }
        b.d.b.e.b.a(bufferedReader);
        return f1428a;
    }
}
