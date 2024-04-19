package b.d.a.f;

import android.content.Context;
import b.d.b.e.d;
import b.d.b.e.g;
import b.d.b.e.i;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog;
import java.io.File;
import java.io.FilenameFilter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.eclipse.paho.client.mqttv3.MqttTopic;
/* compiled from: DataBackupHelper.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f1290a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DataBackupHelper.java */
    /* renamed from: b.d.a.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0051a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f1291a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f1292b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f1293c;

        RunnableC0051a(String str, String str2, Context context) {
            this.f1291a = str;
            this.f1292b = str2;
            this.f1293c = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("vehicleId", String.valueOf(g.g()));
            jsonObject.addProperty("message", this.f1291a);
            jsonObject.addProperty("md5", d.a(this.f1291a));
            byte[] bytes = new Gson().toJson((JsonElement) jsonObject).getBytes();
            a.this.k(this.f1292b, this.f1293c);
            a.this.e(this.f1292b, this.f1293c);
            a.this.o(this.f1292b, bytes, this.f1293c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DataBackupHelper.java */
    /* loaded from: classes.dex */
    public class b implements FilenameFilter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f1295a;

        b(String str) {
            this.f1295a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.contains(this.f1295a) && str.endsWith(".log");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DataBackupHelper.java */
    /* loaded from: classes.dex */
    public class c implements FilenameFilter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f1297a;

        c(String str) {
            this.f1297a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.contains(this.f1297a) && str.contains(".log");
        }
    }

    private a() {
    }

    private File d(String str, Context context) {
        String b2 = b.d.b.e.a.b(System.currentTimeMillis());
        return new File("/sdcard/Log/" + str + MqttTopic.TOPIC_LEVEL_SEPARATOR + context.getPackageName() + MqttTopic.TOPIC_LEVEL_SEPARATOR + str + "_" + b2 + ".log");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, Context context) {
        File file = new File("/sdcard/Log/" + str + MqttTopic.TOPIC_LEVEL_SEPARATOR + context.getPackageName());
        if (!file.exists()) {
            file.mkdirs();
        }
        String[] list = file.list(new b(str));
        if (list == null) {
            return;
        }
        Arrays.sort(list);
        ArrayList arrayList = new ArrayList();
        for (String str2 : list) {
            if (l(str2)) {
                arrayList.add(str2);
                boolean delete = new File("/sdcard/Log/" + str + MqttTopic.TOPIC_LEVEL_SEPARATOR + context.getPackageName() + MqttTopic.TOPIC_LEVEL_SEPARATOR + str2).delete();
                StringBuilder sb = new StringBuilder();
                sb.append("file: ");
                sb.append(str2);
                sb.append(" is expired, deleted ");
                sb.append(delete);
                b.d.b.e.c.a("DataBackupHelper", sb.toString());
            }
        }
        if (arrayList.size() > 0) {
            m(arrayList, list);
        }
    }

    private String f(String str) {
        return str.replace(".log", ".zip");
    }

    private File g(String str, Context context) {
        File[] listFiles = new File("/sdcard/Log/" + str + MqttTopic.TOPIC_LEVEL_SEPARATOR + context.getPackageName()).listFiles(new c(str));
        if (listFiles != null && listFiles.length != 0) {
            Arrays.sort(listFiles);
            File file = listFiles[listFiles.length - 1];
            return (!j(file) || file.length() >= 10485760) ? d(str, context) : file;
        }
        b.d.b.e.c.a("DataBackupHelper", "create a new File");
        return d(str, context);
    }

    public static a h() {
        if (f1290a == null) {
            synchronized (a.class) {
                if (f1290a == null) {
                    f1290a = new a();
                }
            }
        }
        return f1290a;
    }

    private String i(String str) {
        return str.substring(str.lastIndexOf("_") - 8, str.lastIndexOf("."));
    }

    private boolean j(File file) {
        String name = file.getName();
        String b2 = b.d.b.e.a.b(System.currentTimeMillis());
        return name.contains(b2.substring(0, b2.indexOf("_")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, Context context) {
        File file = new File("/sdcard/Log/" + str + MqttTopic.TOPIC_LEVEL_SEPARATOR + context.getPackageName());
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    private boolean l(String str) {
        int lastIndexOf = str.lastIndexOf("_");
        String str2 = str.substring(lastIndexOf - 8, lastIndexOf) + "_000000";
        String b2 = b.d.b.e.a.b(System.currentTimeMillis());
        if (b.d.b.e.a.a(b2.substring(0, 8) + "_000000") - b.d.b.e.a.a(str2) > 604800000) {
            b.d.b.e.c.a("DataBackupHelper", str + " EXPIRED!");
            return true;
        }
        return false;
    }

    private void m(List<String> list, String[] strArr) {
        String i;
        int size = list.size();
        String i2 = i(list.get(0));
        if (strArr.length > size) {
            i = i(strArr[size]);
        } else {
            i = i(list.get(size - 1));
        }
        IDataLog iDataLog = (IDataLog) Module.get(b.d.a.a.class).get(IDataLog.class);
        iDataLog.sendStatData(iDataLog.buildStat().setEventName("data_expire").setProperty("startTime", i2).setProperty("endTime", i).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void o(String str, byte[] bArr, Context context) {
        RandomAccessFile randomAccessFile;
        File g = g(str, context);
        File file = new File(f(g.getPath()));
        if (file.exists()) {
            b.d.b.e.c.l("DataBackupHelper", "zipFile exists, delete .zip and write .log");
            file.delete();
        }
        RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                try {
                    randomAccessFile = new RandomAccessFile(g, "rw");
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e) {
                e = e;
            }
            try {
                randomAccessFile.seek(randomAccessFile.length());
                randomAccessFile.write(bArr);
                randomAccessFile.writeBytes("\n");
                randomAccessFile.getFD().sync();
                StringBuilder sb = new StringBuilder();
                sb.append("write ");
                sb.append(g);
                sb.append(" success, data.length:");
                sb.append(bArr.length);
                b.d.b.e.c.l("DataBackupHelper", sb.toString());
                randomAccessFile.close();
                randomAccessFile2 = sb;
            } catch (Exception e2) {
                e = e2;
                randomAccessFile2 = randomAccessFile;
                b.d.b.e.c.u("DataBackupHelper", "write file fail!", e);
                randomAccessFile2 = randomAccessFile2;
                if (randomAccessFile2 != null) {
                    randomAccessFile2.close();
                    randomAccessFile2 = randomAccessFile2;
                }
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile2 = randomAccessFile;
                if (randomAccessFile2 != null) {
                    try {
                        randomAccessFile2.close();
                    } catch (Exception unused) {
                    }
                }
                throw th;
            }
        } catch (Exception unused2) {
        }
    }

    public void n(String str, String str2, Context context) {
        i.h(0, new RunnableC0051a(str2, str, context));
    }
}
