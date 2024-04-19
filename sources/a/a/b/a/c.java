package a.a.b.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.util.Log;
import android.util.Pair;
import java.io.File;
import java.io.IOException;
import java.util.List;
/* compiled from: SupportSQLiteOpenHelper.java */
/* loaded from: classes.dex */
public interface c {

    /* compiled from: SupportSQLiteOpenHelper.java */
    /* loaded from: classes.dex */
    public static abstract class a {
        private static final String TAG = "SupportSQLite";
        public final int version;

        public a(int i) {
            this.version = i;
        }

        private void deleteDatabaseFile(String str) {
            if (str.equalsIgnoreCase(":memory:") || str.trim().length() == 0) {
                return;
            }
            Log.w(TAG, "deleting the database file: " + str);
            try {
                if (Build.VERSION.SDK_INT >= 16) {
                    SQLiteDatabase.deleteDatabase(new File(str));
                } else {
                    try {
                        if (!new File(str).delete()) {
                            Log.e(TAG, "Could not delete the database file " + str);
                        }
                    } catch (Exception e) {
                        Log.e(TAG, "error while deleting corrupted database file", e);
                    }
                }
            } catch (Exception e2) {
                Log.w(TAG, "delete failed: ", e2);
            }
        }

        public void onConfigure(a.a.b.a.b bVar) {
        }

        public void onCorruption(a.a.b.a.b bVar) {
            Log.e(TAG, "Corruption reported by sqlite on database: " + bVar.getPath());
            if (!bVar.isOpen()) {
                deleteDatabaseFile(bVar.getPath());
                return;
            }
            List<Pair<String, String>> list = null;
            try {
                try {
                    list = bVar.c();
                } catch (SQLiteException unused) {
                }
                try {
                    bVar.close();
                } catch (IOException unused2) {
                }
            } finally {
                if (list != null) {
                    for (Pair<String, String> next : list) {
                        deleteDatabaseFile((String) next.second);
                    }
                } else {
                    deleteDatabaseFile(bVar.getPath());
                }
            }
        }

        public abstract void onCreate(a.a.b.a.b bVar);

        public abstract void onDowngrade(a.a.b.a.b bVar, int i, int i2);

        public void onOpen(a.a.b.a.b bVar) {
        }

        public abstract void onUpgrade(a.a.b.a.b bVar, int i, int i2);
    }

    /* compiled from: SupportSQLiteOpenHelper.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final Context f155a;

        /* renamed from: b  reason: collision with root package name */
        public final String f156b;

        /* renamed from: c  reason: collision with root package name */
        public final a f157c;

        /* compiled from: SupportSQLiteOpenHelper.java */
        /* loaded from: classes.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            Context f158a;

            /* renamed from: b  reason: collision with root package name */
            String f159b;

            /* renamed from: c  reason: collision with root package name */
            a f160c;

            a(Context context) {
                this.f158a = context;
            }

            public b a() {
                a aVar = this.f160c;
                if (aVar != null) {
                    Context context = this.f158a;
                    if (context != null) {
                        return new b(context, this.f159b, aVar);
                    }
                    throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
                }
                throw new IllegalArgumentException("Must set a callback to create the configuration.");
            }

            public a b(a aVar) {
                this.f160c = aVar;
                return this;
            }

            public a c(String str) {
                this.f159b = str;
                return this;
            }
        }

        b(Context context, String str, a aVar) {
            this.f155a = context;
            this.f156b = str;
            this.f157c = aVar;
        }

        public static a a(Context context) {
            return new a(context);
        }
    }

    /* compiled from: SupportSQLiteOpenHelper.java */
    /* renamed from: a.a.b.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0002c {
        c a(b bVar);
    }

    void a(boolean z);

    a.a.b.a.b b();

    void close();
}
