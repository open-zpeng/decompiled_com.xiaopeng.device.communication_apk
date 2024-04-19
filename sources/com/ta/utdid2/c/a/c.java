package com.ta.utdid2.c.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import com.ta.utdid2.b.a.i;
import com.ta.utdid2.c.a.b;
import java.io.File;
import java.util.Map;
/* compiled from: PersistentConfiguration.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with other field name */
    private SharedPreferences f117a;

    /* renamed from: a  reason: collision with other field name */
    private b f119a;

    /* renamed from: a  reason: collision with other field name */
    private d f120a;
    private String e;
    private String f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private Context mContext;

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences.Editor f2131a = null;

    /* renamed from: a  reason: collision with other field name */
    private b.a f118a = null;

    /* JADX WARN: Removed duplicated region for block: B:62:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0158 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0174 A[Catch: Exception -> 0x017e, TRY_LEAVE, TryCatch #1 {Exception -> 0x017e, blocks: (B:76:0x0170, B:78:0x0174), top: B:85:0x0170 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public c(android.content.Context r10, java.lang.String r11, java.lang.String r12, boolean r13, boolean r14) {
        /*
            Method dump skipped, instructions count: 383
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.c.a.c.<init>(android.content.Context, java.lang.String, java.lang.String, boolean, boolean):void");
    }

    private d a(String str) {
        File m60a = m60a(str);
        if (m60a != null) {
            d dVar = new d(m60a.getAbsolutePath());
            this.f120a = dVar;
            return dVar;
        }
        return null;
    }

    private boolean b() {
        b bVar = this.f119a;
        if (bVar != null) {
            boolean mo59a = bVar.mo59a();
            if (!mo59a) {
                commit();
            }
            return mo59a;
        }
        return false;
    }

    private void c() {
        b bVar;
        SharedPreferences sharedPreferences;
        if (this.f2131a == null && (sharedPreferences = this.f117a) != null) {
            this.f2131a = sharedPreferences.edit();
        }
        if (this.i && this.f118a == null && (bVar = this.f119a) != null) {
            this.f118a = bVar.a();
        }
        b();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(4:3|(1:7)|8|(9:10|11|(1:15)|16|17|18|19|(4:21|(2:23|(2:25|(3:27|(1:29)(1:31)|30))(2:32|(1:36)))|37|(3:43|44|(1:46)))|49))|54|11|(2:13|15)|16|17|18|19|(0)|49) */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0037, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0038, code lost:
        r2.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean commit() {
        /*
            r6 = this;
            long r0 = java.lang.System.currentTimeMillis()
            android.content.SharedPreferences$Editor r2 = r6.f2131a
            r3 = 0
            if (r2 == 0) goto L20
            boolean r4 = r6.j
            if (r4 != 0) goto L16
            android.content.SharedPreferences r4 = r6.f117a
            if (r4 == 0) goto L16
            java.lang.String r4 = "t"
            r2.putLong(r4, r0)
        L16:
            android.content.SharedPreferences$Editor r0 = r6.f2131a
            boolean r0 = r0.commit()
            if (r0 != 0) goto L20
            r0 = r3
            goto L21
        L20:
            r0 = 1
        L21:
            android.content.SharedPreferences r1 = r6.f117a
            if (r1 == 0) goto L31
            android.content.Context r1 = r6.mContext
            if (r1 == 0) goto L31
            java.lang.String r2 = r6.e
            android.content.SharedPreferences r1 = r1.getSharedPreferences(r2, r3)
            r6.f117a = r1
        L31:
            r1 = 0
            java.lang.String r1 = android.os.Environment.getExternalStorageState()     // Catch: java.lang.Exception -> L37
            goto L3b
        L37:
            r2 = move-exception
            r2.printStackTrace()
        L3b:
            boolean r2 = com.ta.utdid2.b.a.i.m58a(r1)
            if (r2 != 0) goto L9e
            java.lang.String r2 = "mounted"
            boolean r4 = r1.equals(r2)
            if (r4 == 0) goto L80
            com.ta.utdid2.c.a.b r4 = r6.f119a
            if (r4 != 0) goto L75
            java.lang.String r4 = r6.f
            com.ta.utdid2.c.a.d r4 = r6.a(r4)
            if (r4 == 0) goto L80
            java.lang.String r5 = r6.e
            com.ta.utdid2.c.a.b r4 = r4.a(r5, r3)
            r6.f119a = r4
            boolean r5 = r6.j
            if (r5 != 0) goto L67
            android.content.SharedPreferences r5 = r6.f117a
            r6.a(r5, r4)
            goto L6c
        L67:
            android.content.SharedPreferences r5 = r6.f117a
            r6.a(r4, r5)
        L6c:
            com.ta.utdid2.c.a.b r4 = r6.f119a
            com.ta.utdid2.c.a.b$a r4 = r4.a()
            r6.f118a = r4
            goto L80
        L75:
            com.ta.utdid2.c.a.b$a r4 = r6.f118a
            if (r4 == 0) goto L80
            boolean r4 = r4.commit()
            if (r4 != 0) goto L80
            r0 = r3
        L80:
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L92
            java.lang.String r2 = "mounted_ro"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L9e
            com.ta.utdid2.c.a.b r1 = r6.f119a
            if (r1 == 0) goto L9e
        L92:
            com.ta.utdid2.c.a.d r1 = r6.f120a     // Catch: java.lang.Exception -> L9e
            if (r1 == 0) goto L9e
            java.lang.String r2 = r6.e     // Catch: java.lang.Exception -> L9e
            com.ta.utdid2.c.a.b r1 = r1.a(r2, r3)     // Catch: java.lang.Exception -> L9e
            r6.f119a = r1     // Catch: java.lang.Exception -> L9e
        L9e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.c.a.c.commit():boolean");
    }

    public String getString(String str) {
        b();
        SharedPreferences sharedPreferences = this.f117a;
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString(str, "");
            if (!i.m58a(string)) {
                return string;
            }
        }
        b bVar = this.f119a;
        return bVar != null ? bVar.getString(str, "") : "";
    }

    public void putString(String str, String str2) {
        if (i.m58a(str) || str.equals("t")) {
            return;
        }
        c();
        SharedPreferences.Editor editor = this.f2131a;
        if (editor != null) {
            editor.putString(str, str2);
        }
        b.a aVar = this.f118a;
        if (aVar != null) {
            aVar.a(str, str2);
        }
    }

    public void remove(String str) {
        if (i.m58a(str) || str.equals("t")) {
            return;
        }
        c();
        SharedPreferences.Editor editor = this.f2131a;
        if (editor != null) {
            editor.remove(str);
        }
        b.a aVar = this.f118a;
        if (aVar != null) {
            aVar.a(str);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private File m60a(String str) {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory != null) {
            File file = new File(String.format("%s%s%s", externalStorageDirectory.getAbsolutePath(), File.separator, str));
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
        return null;
    }

    private void a(SharedPreferences sharedPreferences, b bVar) {
        b.a a2;
        if (sharedPreferences == null || bVar == null || (a2 = bVar.a()) == null) {
            return;
        }
        a2.b();
        for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                a2.a(key, (String) value);
            } else if (value instanceof Integer) {
                a2.a(key, ((Integer) value).intValue());
            } else if (value instanceof Long) {
                a2.a(key, ((Long) value).longValue());
            } else if (value instanceof Float) {
                a2.a(key, ((Float) value).floatValue());
            } else if (value instanceof Boolean) {
                a2.a(key, ((Boolean) value).booleanValue());
            }
        }
        a2.commit();
    }

    private void a(b bVar, SharedPreferences sharedPreferences) {
        SharedPreferences.Editor edit;
        if (bVar == null || sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
            return;
        }
        edit.clear();
        for (Map.Entry<String, ?> entry : bVar.getAll().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                edit.putString(key, (String) value);
            } else if (value instanceof Integer) {
                edit.putInt(key, ((Integer) value).intValue());
            } else if (value instanceof Long) {
                edit.putLong(key, ((Long) value).longValue());
            } else if (value instanceof Float) {
                edit.putFloat(key, ((Float) value).floatValue());
            } else if (value instanceof Boolean) {
                edit.putBoolean(key, ((Boolean) value).booleanValue());
            }
        }
        edit.commit();
    }
}
