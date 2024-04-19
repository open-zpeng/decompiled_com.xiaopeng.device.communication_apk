package a.a.b.a;

import android.database.Cursor;
import android.database.SQLException;
import android.util.Pair;
import java.io.Closeable;
import java.util.List;
/* compiled from: SupportSQLiteDatabase.java */
/* loaded from: classes.dex */
public interface b extends Closeable {
    void a();

    void b();

    List<Pair<String, String>> c();

    Cursor d(e eVar);

    void e(String str) throws SQLException;

    f f(String str);

    String getPath();

    boolean isOpen();

    boolean j();

    void k();

    Cursor m(String str);
}
