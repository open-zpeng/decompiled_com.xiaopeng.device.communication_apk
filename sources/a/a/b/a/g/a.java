package a.a.b.a.g;

import a.a.b.a.f;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.util.Pair;
import java.io.IOException;
import java.util.List;
/* compiled from: FrameworkSQLiteDatabase.java */
/* loaded from: classes.dex */
class a implements a.a.b.a.b {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f161a = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f162b = new String[0];

    /* renamed from: c  reason: collision with root package name */
    private final SQLiteDatabase f163c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FrameworkSQLiteDatabase.java */
    /* renamed from: a.a.b.a.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0003a implements SQLiteDatabase.CursorFactory {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a.a.b.a.e f164a;

        C0003a(a.a.b.a.e eVar) {
            this.f164a = eVar;
        }

        @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
        public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            this.f164a.bindTo(new d(sQLiteQuery));
            return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(SQLiteDatabase sQLiteDatabase) {
        this.f163c = sQLiteDatabase;
    }

    @Override // a.a.b.a.b
    public void a() {
        this.f163c.endTransaction();
    }

    @Override // a.a.b.a.b
    public void b() {
        this.f163c.beginTransaction();
    }

    @Override // a.a.b.a.b
    public List<Pair<String, String>> c() {
        return this.f163c.getAttachedDbs();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f163c.close();
    }

    @Override // a.a.b.a.b
    public Cursor d(a.a.b.a.e eVar) {
        return this.f163c.rawQueryWithFactory(new C0003a(eVar), eVar.getSql(), f162b, null);
    }

    @Override // a.a.b.a.b
    public void e(String str) throws SQLException {
        this.f163c.execSQL(str);
    }

    @Override // a.a.b.a.b
    public f f(String str) {
        return new e(this.f163c.compileStatement(str));
    }

    @Override // a.a.b.a.b
    public String getPath() {
        return this.f163c.getPath();
    }

    @Override // a.a.b.a.b
    public boolean isOpen() {
        return this.f163c.isOpen();
    }

    @Override // a.a.b.a.b
    public boolean j() {
        return this.f163c.inTransaction();
    }

    @Override // a.a.b.a.b
    public void k() {
        this.f163c.setTransactionSuccessful();
    }

    @Override // a.a.b.a.b
    public Cursor m(String str) {
        return d(new a.a.b.a.a(str));
    }
}
