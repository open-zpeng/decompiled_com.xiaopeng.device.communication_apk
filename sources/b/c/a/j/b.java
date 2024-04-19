package b.c.a.j;

import com.alibaba.sdk.android.oss.common.OSSConstants;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okhttp3.MediaType;
/* compiled from: HttpParams.java */
/* loaded from: classes.dex */
public class b implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public static final MediaType f1239a = MediaType.parse("text/plain;charset=utf-8");

    /* renamed from: b  reason: collision with root package name */
    public static final MediaType f1240b = MediaType.parse("application/json;charset=utf-8");

    /* renamed from: c  reason: collision with root package name */
    public static final MediaType f1241c = MediaType.parse(OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
    private static final long serialVersionUID = 7369819159227055048L;

    /* renamed from: d  reason: collision with root package name */
    public LinkedHashMap<String, List<String>> f1242d;
    public LinkedHashMap<String, List<a>> e;

    /* compiled from: HttpParams.java */
    /* loaded from: classes.dex */
    public static class a implements Serializable {
        private static final long serialVersionUID = -2356139899636767776L;

        /* renamed from: a  reason: collision with root package name */
        public File f1243a;

        /* renamed from: b  reason: collision with root package name */
        public String f1244b;

        /* renamed from: c  reason: collision with root package name */
        public transient MediaType f1245c;

        /* renamed from: d  reason: collision with root package name */
        public long f1246d;

        public a(File file, String str, MediaType mediaType) {
            this.f1243a = file;
            this.f1244b = str;
            this.f1245c = mediaType;
            this.f1246d = file.length();
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.f1245c = MediaType.parse((String) objectInputStream.readObject());
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.f1245c.toString());
        }

        public String toString() {
            return "FileWrapper{file=" + this.f1243a + ", fileName=" + this.f1244b + ", contentType=" + this.f1245c + ", fileSize=" + this.f1246d + "}";
        }
    }

    public b() {
        b();
    }

    private void b() {
        this.f1242d = new LinkedHashMap<>();
        this.e = new LinkedHashMap<>();
    }

    private void i(String str, String str2, boolean z) {
        if (str == null || str2 == null) {
            return;
        }
        List<String> list = this.f1242d.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.f1242d.put(str, list);
        }
        if (z) {
            list.clear();
        }
        list.add(str2);
    }

    public void a() {
        this.f1242d.clear();
        this.e.clear();
    }

    public void c(b bVar) {
        if (bVar != null) {
            LinkedHashMap<String, List<String>> linkedHashMap = bVar.f1242d;
            if (linkedHashMap != null && !linkedHashMap.isEmpty()) {
                this.f1242d.putAll(bVar.f1242d);
            }
            LinkedHashMap<String, List<a>> linkedHashMap2 = bVar.e;
            if (linkedHashMap2 == null || linkedHashMap2.isEmpty()) {
                return;
            }
            this.e.putAll(bVar.e);
        }
    }

    public void d(String str, float f, boolean... zArr) {
        if (zArr != null && zArr.length > 0) {
            i(str, String.valueOf(f), zArr[0]);
        } else {
            i(str, String.valueOf(f), true);
        }
    }

    public void e(String str, int i, boolean... zArr) {
        if (zArr != null && zArr.length > 0) {
            i(str, String.valueOf(i), zArr[0]);
        } else {
            i(str, String.valueOf(i), true);
        }
    }

    public void f(String str, File file) {
        g(str, file, file.getName());
    }

    public void g(String str, File file, String str2) {
        h(str, file, str2, b.c.a.l.b.e(str2));
    }

    public void h(String str, File file, String str2, MediaType mediaType) {
        if (str != null) {
            List<a> list = this.e.get(str);
            if (list == null) {
                list = new ArrayList<>();
                this.e.put(str, list);
            }
            list.add(new a(file, str2, mediaType));
        }
    }

    public void j(String str, String str2, boolean... zArr) {
        if (zArr != null && zArr.length > 0) {
            i(str, str2, zArr[0]);
        } else {
            i(str, str2, true);
        }
    }

    public void k(String str, boolean z, boolean... zArr) {
        if (zArr != null && zArr.length > 0) {
            i(str, String.valueOf(z), zArr[0]);
        } else {
            i(str, String.valueOf(z), true);
        }
    }

    public void l(Map<String, String> map, boolean... zArr) {
        if (map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            j(entry.getKey(), entry.getValue(), zArr);
        }
    }

    public void m(String str) {
        o(str);
        n(str);
    }

    public void n(String str) {
        this.e.remove(str);
    }

    public void o(String str) {
        this.f1242d.remove(str);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, List<String>> entry : this.f1242d.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
        }
        for (Map.Entry<String, List<a>> entry2 : this.e.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(entry2.getKey());
            sb.append("=");
            sb.append(entry2.getValue());
        }
        return sb.toString();
    }
}
