package a.a.b.a;

import java.io.Closeable;
/* compiled from: SupportSQLiteProgram.java */
/* loaded from: classes.dex */
public interface d extends Closeable {
    void bindBlob(int i, byte[] bArr);

    void bindDouble(int i, double d2);

    void bindLong(int i, long j);

    void bindNull(int i);

    void bindString(int i, String str);
}
