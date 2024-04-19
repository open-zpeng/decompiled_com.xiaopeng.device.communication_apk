package com.xiaopeng.device.communication.messagecenter.push;

import a.a.b.a.c;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomMasterTable;
import android.arch.persistence.room.RoomOpenHelper;
import android.arch.persistence.room.util.TableInfo;
import com.xiaopeng.libconfig.ipc.IpcConfig;
import java.util.HashMap;
import java.util.HashSet;
/* loaded from: classes.dex */
public class MessageCenterPushDatabase_Impl extends MessageCenterPushDatabase {
    private volatile b _messageCenterPushDao;

    /* loaded from: classes.dex */
    class a extends RoomOpenHelper.Delegate {
        a(int i) {
            super(i);
        }

        @Override // android.arch.persistence.room.RoomOpenHelper.Delegate
        public void createAllTables(a.a.b.a.b bVar) {
            bVar.e("CREATE TABLE IF NOT EXISTS `t_message_push` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `event_name` TEXT, `params` TEXT, `ts` INTEGER NOT NULL)");
            bVar.e(RoomMasterTable.CREATE_QUERY);
            bVar.e("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"af3c2400a4cae57108acfa7e7399ba75\")");
        }

        @Override // android.arch.persistence.room.RoomOpenHelper.Delegate
        public void dropAllTables(a.a.b.a.b bVar) {
            bVar.e("DROP TABLE IF EXISTS `t_message_push`");
        }

        @Override // android.arch.persistence.room.RoomOpenHelper.Delegate
        protected void onCreate(a.a.b.a.b bVar) {
            if (((RoomDatabase) MessageCenterPushDatabase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) MessageCenterPushDatabase_Impl.this).mCallbacks.size();
                for (int i = 0; i < size; i++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) MessageCenterPushDatabase_Impl.this).mCallbacks.get(i)).onCreate(bVar);
                }
            }
        }

        @Override // android.arch.persistence.room.RoomOpenHelper.Delegate
        public void onOpen(a.a.b.a.b bVar) {
            ((RoomDatabase) MessageCenterPushDatabase_Impl.this).mDatabase = bVar;
            MessageCenterPushDatabase_Impl.this.internalInitInvalidationTracker(bVar);
            if (((RoomDatabase) MessageCenterPushDatabase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) MessageCenterPushDatabase_Impl.this).mCallbacks.size();
                for (int i = 0; i < size; i++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) MessageCenterPushDatabase_Impl.this).mCallbacks.get(i)).onOpen(bVar);
                }
            }
        }

        @Override // android.arch.persistence.room.RoomOpenHelper.Delegate
        protected void validateMigration(a.a.b.a.b bVar) {
            HashMap hashMap = new HashMap(4);
            hashMap.put("id", new TableInfo.Column("id", "INTEGER", false, 1));
            hashMap.put("event_name", new TableInfo.Column("event_name", "TEXT", false, 0));
            hashMap.put(IpcConfig.DeviceCommunicationConfig.KEY_APP_MESSAGE_PARAMS, new TableInfo.Column(IpcConfig.DeviceCommunicationConfig.KEY_APP_MESSAGE_PARAMS, "TEXT", false, 0));
            hashMap.put("ts", new TableInfo.Column("ts", "INTEGER", true, 0));
            TableInfo tableInfo = new TableInfo("t_message_push", hashMap, new HashSet(0), new HashSet(0));
            TableInfo read = TableInfo.read(bVar, "t_message_push");
            if (tableInfo.equals(read)) {
                return;
            }
            throw new IllegalStateException("Migration didn't properly handle t_message_push(com.xiaopeng.device.communication.messagecenter.push.MessageCenterPushBean).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
        }
    }

    @Override // android.arch.persistence.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        a.a.b.a.b b2 = super.getOpenHelper().b();
        try {
            super.beginTransaction();
            b2.e("DELETE FROM `t_message_push`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            b2.m("PRAGMA wal_checkpoint(FULL)").close();
            if (!b2.j()) {
                b2.e("VACUUM");
            }
        }
    }

    @Override // android.arch.persistence.room.RoomDatabase
    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, "t_message_push");
    }

    @Override // android.arch.persistence.room.RoomDatabase
    protected a.a.b.a.c createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.a(c.b.a(databaseConfiguration.context).c(databaseConfiguration.name).b(new RoomOpenHelper(databaseConfiguration, new a(1), "af3c2400a4cae57108acfa7e7399ba75", "f1f736a8d63d483b65554bf6669dcc14")).a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.xiaopeng.device.communication.messagecenter.push.MessageCenterPushDatabase
    public b pushDao() {
        b bVar;
        if (this._messageCenterPushDao != null) {
            return this._messageCenterPushDao;
        }
        synchronized (this) {
            if (this._messageCenterPushDao == null) {
                this._messageCenterPushDao = new c(this);
            }
            bVar = this._messageCenterPushDao;
        }
        return bVar;
    }
}
