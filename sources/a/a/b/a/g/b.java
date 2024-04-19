package a.a.b.a.g;

import a.a.b.a.c;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/* compiled from: FrameworkSQLiteOpenHelper.java */
/* loaded from: classes.dex */
class b implements a.a.b.a.c {

    /* renamed from: a  reason: collision with root package name */
    private final a f166a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FrameworkSQLiteOpenHelper.java */
    /* loaded from: classes.dex */
    public static class a extends SQLiteOpenHelper {

        /* renamed from: a  reason: collision with root package name */
        final a.a.b.a.g.a[] f167a;

        /* renamed from: b  reason: collision with root package name */
        final c.a f168b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f169c;

        /* compiled from: FrameworkSQLiteOpenHelper.java */
        /* renamed from: a.a.b.a.g.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0004a implements DatabaseErrorHandler {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a.a.b.a.g.a[] f170a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ c.a f171b;

            C0004a(a.a.b.a.g.a[] aVarArr, c.a aVar) {
                this.f170a = aVarArr;
                this.f171b = aVar;
            }

            @Override // android.database.DatabaseErrorHandler
            public void onCorruption(SQLiteDatabase sQLiteDatabase) {
                a.a.b.a.g.a aVar = this.f170a[0];
                if (aVar != null) {
                    this.f171b.onCorruption(aVar);
                }
            }
        }

        a(Context context, String str, a.a.b.a.g.a[] aVarArr, c.a aVar) {
            super(context, str, null, aVar.version, new C0004a(aVarArr, aVar));
            this.f168b = aVar;
            this.f167a = aVarArr;
        }

        a.a.b.a.g.a a(SQLiteDatabase sQLiteDatabase) {
            if (this.f167a[0] == null) {
                this.f167a[0] = new a.a.b.a.g.a(sQLiteDatabase);
            }
            return this.f167a[0];
        }

        synchronized a.a.b.a.b b() {
            this.f169c = false;
            SQLiteDatabase writableDatabase = super.getWritableDatabase();
            if (this.f169c) {
                close();
                return b();
            }
            return a(writableDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public synchronized void close() {
            super.close();
            this.f167a[0] = null;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            this.f168b.onConfigure(a(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            this.f168b.onCreate(a(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            this.f169c = true;
            this.f168b.onDowngrade(a(sQLiteDatabase), i, i2);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (this.f169c) {
                return;
            }
            this.f168b.onOpen(a(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            this.f169c = true;
            this.f168b.onUpgrade(a(sQLiteDatabase), i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, String str, c.a aVar) {
        this.f166a = c(context, str, aVar);
    }

    private a c(Context context, String str, c.a aVar) {
        return new a(context, str, new a.a.b.a.g.a[1], aVar);
    }

    @Override // a.a.b.a.c
    public void a(boolean z) {
        this.f166a.setWriteAheadLoggingEnabled(z);
    }

    @Override // a.a.b.a.c
    public a.a.b.a.b b() {
        return this.f166a.b();
    }

    @Override // a.a.b.a.c
    public void close() {
        this.f166a.close();
    }
}
