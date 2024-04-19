package b.b.a.a.f;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
/* compiled from: MutiProcessLock.java */
/* loaded from: classes.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    static File f1120a;

    /* renamed from: b  reason: collision with root package name */
    static FileChannel f1121b;

    /* renamed from: c  reason: collision with root package name */
    static FileLock f1122c;

    public static synchronized boolean a(Context context) {
        FileLock fileLock;
        synchronized (k.class) {
            if (f1120a == null) {
                f1120a = new File(context.getFilesDir() + File.separator + "ap.Lock");
            }
            boolean exists = f1120a.exists();
            if (!exists) {
                try {
                    exists = f1120a.createNewFile();
                } catch (IOException unused) {
                }
            }
            if (exists) {
                if (f1121b == null) {
                    try {
                        f1121b = new RandomAccessFile(f1120a, "rw").getChannel();
                    } catch (Exception unused2) {
                        return false;
                    }
                }
                try {
                    fileLock = f1121b.tryLock();
                    if (fileLock != null) {
                        f1122c = fileLock;
                        return true;
                    }
                } catch (Throwable unused3) {
                    fileLock = null;
                }
                Log.d("TAG", "mLock:" + fileLock);
                return false;
            }
            return true;
        }
    }

    public static synchronized void b() {
        synchronized (k.class) {
            FileLock fileLock = f1122c;
            if (fileLock != null) {
                try {
                    fileLock.release();
                } catch (IOException unused) {
                }
                f1122c = null;
            }
            FileChannel fileChannel = f1121b;
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (Exception unused2) {
                }
                f1121b = null;
            }
        }
    }
}
