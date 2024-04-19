package a.a.b.a.g;

import a.a.b.a.f;
import android.database.sqlite.SQLiteStatement;
/* compiled from: FrameworkSQLiteStatement.java */
/* loaded from: classes.dex */
class e extends d implements f {

    /* renamed from: b  reason: collision with root package name */
    private final SQLiteStatement f173b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        this.f173b = sQLiteStatement;
    }

    @Override // a.a.b.a.f
    public int i() {
        return this.f173b.executeUpdateDelete();
    }

    @Override // a.a.b.a.f
    public long l() {
        return this.f173b.executeInsert();
    }
}
