package b.d.b.e;

import android.text.TextUtils;
import android.util.Base64;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.eclipse.paho.client.mqttv3.MqttTopic;
/* compiled from: ZipUtils.java */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static byte[] f1420a = {80, 75, 3, 4};

    /* renamed from: b  reason: collision with root package name */
    private static byte[] f1421b = {80, 75, 5, 6};

    /* renamed from: c  reason: collision with root package name */
    private static int f1422c = 4;

    public static String a(byte[] bArr, int i) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        return Base64.encodeToString(bArr, i);
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(str.getBytes());
            gZIPOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            return a(byteArray, 2);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static void c(ZipOutputStream zipOutputStream, File file, String str, boolean z) throws IOException {
        FileInputStream fileInputStream;
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            if (!file.isDirectory()) {
                byte[] bArr = new byte[4096];
                fileInputStream = new FileInputStream(file);
                try {
                    try {
                        bufferedInputStream = new BufferedInputStream(fileInputStream);
                    } catch (Exception e) {
                        e = e;
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    zipOutputStream.putNextEntry(new ZipEntry(str + file.getName()));
                    while (true) {
                        int read = bufferedInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        zipOutputStream.write(bArr, 0, read);
                    }
                    zipOutputStream.flush();
                    zipOutputStream.closeEntry();
                    bufferedInputStream2 = bufferedInputStream;
                } catch (Exception e2) {
                    e = e2;
                    bufferedInputStream2 = bufferedInputStream;
                    e.printStackTrace();
                    b.a(bufferedInputStream2);
                    b.a(fileInputStream);
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream2 = bufferedInputStream;
                    b.a(bufferedInputStream2);
                    b.a(fileInputStream);
                    throw th;
                }
            } else {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length > 0) {
                    for (File file2 : listFiles) {
                        c(zipOutputStream, file2, str + file.getName() + MqttTopic.TOPIC_LEVEL_SEPARATOR, z);
                    }
                } else if (!z) {
                    zipOutputStream.putNextEntry(new ZipEntry(file.getAbsolutePath() + MqttTopic.TOPIC_LEVEL_SEPARATOR));
                    zipOutputStream.closeEntry();
                }
                fileInputStream = null;
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
        b.a(bufferedInputStream2);
        b.a(fileInputStream);
    }

    public static File d(String str, List<String> list) throws IOException {
        return e(str, list, true);
    }

    public static File e(String str, List<String> list, boolean z) throws IOException {
        try {
            return f(str, list, z);
        } catch (Exception e) {
            e.printStackTrace();
            return new File(str);
        }
    }

    public static File f(String str, List<String> list, boolean z) throws IOException {
        FileOutputStream fileOutputStream;
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        ZipOutputStream zipOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(new File(str));
            try {
                ZipOutputStream zipOutputStream2 = new ZipOutputStream(fileOutputStream);
                try {
                    for (String str2 : list) {
                        File file2 = new File(str2);
                        String parent = file2.getParent();
                        if (parent == null) {
                            parent = "";
                        }
                        c(zipOutputStream2, file2, parent + MqttTopic.TOPIC_LEVEL_SEPARATOR, z);
                    }
                    zipOutputStream2.flush();
                    zipOutputStream2.closeEntry();
                    b.a(zipOutputStream2);
                    b.a(fileOutputStream);
                    return new File(str);
                } catch (Throwable th) {
                    th = th;
                    zipOutputStream = zipOutputStream2;
                    b.a(zipOutputStream);
                    b.a(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }
}
