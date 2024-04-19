package b.c.a.c;

import android.content.ContentValues;
import android.database.Cursor;
import b.c.a.l.c;
import java.io.Serializable;
/* compiled from: CacheEntity.java */
/* loaded from: classes.dex */
public class a<T> implements Serializable {
    private static final long serialVersionUID = -4337711009801627866L;

    /* renamed from: a  reason: collision with root package name */
    private String f1170a;

    /* renamed from: b  reason: collision with root package name */
    private long f1171b;

    /* renamed from: c  reason: collision with root package name */
    private b.c.a.j.a f1172c;

    /* renamed from: d  reason: collision with root package name */
    private T f1173d;
    private boolean e;

    public static <T> ContentValues b(a<T> aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("key", aVar.d());
        contentValues.put("localExpire", Long.valueOf(aVar.e()));
        contentValues.put("head", c.c(aVar.f()));
        contentValues.put("data", c.c(aVar.c()));
        return contentValues;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> a<T> h(Cursor cursor) {
        a<T> aVar = (a<T>) new a();
        aVar.k(cursor.getString(cursor.getColumnIndex("key")));
        aVar.l(cursor.getLong(cursor.getColumnIndex("localExpire")));
        aVar.m((b.c.a.j.a) c.d(cursor.getBlob(cursor.getColumnIndex("head"))));
        aVar.i(c.d(cursor.getBlob(cursor.getColumnIndex("data"))));
        return aVar;
    }

    public boolean a(b bVar, long j, long j2) {
        return bVar == b.DEFAULT ? e() < j2 : j != -1 && e() + j < j2;
    }

    public T c() {
        return this.f1173d;
    }

    public String d() {
        return this.f1170a;
    }

    public long e() {
        return this.f1171b;
    }

    public b.c.a.j.a f() {
        return this.f1172c;
    }

    public boolean g() {
        return this.e;
    }

    public void i(T t) {
        this.f1173d = t;
    }

    public void j(boolean z) {
        this.e = z;
    }

    public void k(String str) {
        this.f1170a = str;
    }

    public void l(long j) {
        this.f1171b = j;
    }

    public void m(b.c.a.j.a aVar) {
        this.f1172c = aVar;
    }

    public String toString() {
        return "CacheEntity{key='" + this.f1170a + "', responseHeaders=" + this.f1172c + ", data=" + this.f1173d + ", localExpire=" + this.f1171b + '}';
    }
}
