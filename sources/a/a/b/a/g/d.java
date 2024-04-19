package a.a.b.a.g;

import android.database.sqlite.SQLiteProgram;
/* compiled from: FrameworkSQLiteProgram.java */
/* loaded from: classes.dex */
class d implements a.a.b.a.d {

    /* renamed from: a  reason: collision with root package name */
    private final SQLiteProgram f172a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(SQLiteProgram sQLiteProgram) {
        this.f172a = sQLiteProgram;
    }

    @Override // a.a.b.a.d
    public void bindBlob(int i, byte[] bArr) {
        this.f172a.bindBlob(i, bArr);
    }

    @Override // a.a.b.a.d
    public void bindDouble(int i, double d2) {
        this.f172a.bindDouble(i, d2);
    }

    @Override // a.a.b.a.d
    public void bindLong(int i, long j) {
        this.f172a.bindLong(i, j);
    }

    @Override // a.a.b.a.d
    public void bindNull(int i) {
        this.f172a.bindNull(i);
    }

    @Override // a.a.b.a.d
    public void bindString(int i, String str) {
        this.f172a.bindString(i, str);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f172a.close();
    }
}
