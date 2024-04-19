package com.xiaopeng.device.communication.messagecenter.push;

import a.a.b.a.f;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.SharedSQLiteStatement;
import android.database.Cursor;
import com.xiaopeng.libconfig.ipc.IpcConfig;
import java.util.ArrayList;
import java.util.List;
/* compiled from: MessageCenterPushDao_Impl.java */
/* loaded from: classes.dex */
public class c implements com.xiaopeng.device.communication.messagecenter.push.b {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f2285a;

    /* renamed from: b  reason: collision with root package name */
    private final EntityInsertionAdapter f2286b;

    /* renamed from: c  reason: collision with root package name */
    private final EntityDeletionOrUpdateAdapter f2287c;

    /* renamed from: d  reason: collision with root package name */
    private final SharedSQLiteStatement f2288d;

    /* compiled from: MessageCenterPushDao_Impl.java */
    /* loaded from: classes.dex */
    class a extends EntityInsertionAdapter<com.xiaopeng.device.communication.messagecenter.push.a> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // android.arch.persistence.room.EntityInsertionAdapter
        /* renamed from: a */
        public void bind(f fVar, com.xiaopeng.device.communication.messagecenter.push.a aVar) {
            if (aVar.b() == null) {
                fVar.bindNull(1);
            } else {
                fVar.bindLong(1, aVar.b().intValue());
            }
            if (aVar.a() == null) {
                fVar.bindNull(2);
            } else {
                fVar.bindString(2, aVar.a());
            }
            if (aVar.c() == null) {
                fVar.bindNull(3);
            } else {
                fVar.bindString(3, aVar.c());
            }
            fVar.bindLong(4, aVar.d());
        }

        @Override // android.arch.persistence.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR ABORT INTO `t_message_push`(`id`,`event_name`,`params`,`ts`) VALUES (?,?,?,?)";
        }
    }

    /* compiled from: MessageCenterPushDao_Impl.java */
    /* loaded from: classes.dex */
    class b extends EntityDeletionOrUpdateAdapter<com.xiaopeng.device.communication.messagecenter.push.a> {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // android.arch.persistence.room.EntityDeletionOrUpdateAdapter
        /* renamed from: a */
        public void bind(f fVar, com.xiaopeng.device.communication.messagecenter.push.a aVar) {
            if (aVar.b() == null) {
                fVar.bindNull(1);
            } else {
                fVar.bindLong(1, aVar.b().intValue());
            }
        }

        @Override // android.arch.persistence.room.EntityDeletionOrUpdateAdapter, android.arch.persistence.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM `t_message_push` WHERE `id` = ?";
        }
    }

    /* compiled from: MessageCenterPushDao_Impl.java */
    /* renamed from: com.xiaopeng.device.communication.messagecenter.push.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0101c extends SharedSQLiteStatement {
        C0101c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // android.arch.persistence.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM t_message_push where ts < ?";
        }
    }

    public c(RoomDatabase roomDatabase) {
        this.f2285a = roomDatabase;
        this.f2286b = new a(roomDatabase);
        this.f2287c = new b(roomDatabase);
        this.f2288d = new C0101c(roomDatabase);
    }

    @Override // com.xiaopeng.device.communication.messagecenter.push.b
    public List<com.xiaopeng.device.communication.messagecenter.push.a> a(long j) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM t_message_push where ts > ?", 1);
        acquire.bindLong(1, j);
        Cursor query = this.f2285a.query(acquire);
        try {
            int columnIndexOrThrow = query.getColumnIndexOrThrow("id");
            int columnIndexOrThrow2 = query.getColumnIndexOrThrow("event_name");
            int columnIndexOrThrow3 = query.getColumnIndexOrThrow(IpcConfig.DeviceCommunicationConfig.KEY_APP_MESSAGE_PARAMS);
            int columnIndexOrThrow4 = query.getColumnIndexOrThrow("ts");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                com.xiaopeng.device.communication.messagecenter.push.a aVar = new com.xiaopeng.device.communication.messagecenter.push.a(query.getString(columnIndexOrThrow2), query.getString(columnIndexOrThrow3), query.getLong(columnIndexOrThrow4));
                aVar.e(query.isNull(columnIndexOrThrow) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow)));
                arrayList.add(aVar);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.xiaopeng.device.communication.messagecenter.push.b
    public void b(com.xiaopeng.device.communication.messagecenter.push.a aVar) {
        this.f2285a.beginTransaction();
        try {
            this.f2286b.insert((EntityInsertionAdapter) aVar);
            this.f2285a.setTransactionSuccessful();
        } finally {
            this.f2285a.endTransaction();
        }
    }

    @Override // com.xiaopeng.device.communication.messagecenter.push.b
    public void c(long j) {
        f acquire = this.f2288d.acquire();
        this.f2285a.beginTransaction();
        try {
            acquire.bindLong(1, j);
            acquire.i();
            this.f2285a.setTransactionSuccessful();
        } finally {
            this.f2285a.endTransaction();
            this.f2288d.release(acquire);
        }
    }

    @Override // com.xiaopeng.device.communication.messagecenter.push.b
    public void d(com.xiaopeng.device.communication.messagecenter.push.a aVar) {
        this.f2285a.beginTransaction();
        try {
            this.f2287c.handle(aVar);
            this.f2285a.setTransactionSuccessful();
        } finally {
            this.f2285a.endTransaction();
        }
    }
}
