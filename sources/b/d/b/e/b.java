package b.d.b.e;

import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
/* compiled from: FileUtils.java */
/* loaded from: classes.dex */
public class b {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length; i++) {
                    b(listFiles[i].getAbsolutePath());
                    if (listFiles[i].isDirectory()) {
                        listFiles[i].delete();
                    }
                }
            }
            new File(str).delete();
        }
    }
}
