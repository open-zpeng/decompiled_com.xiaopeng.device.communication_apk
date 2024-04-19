package com.xiaopeng.device.communication.messagecenter.push;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
@Database(entities = {a.class}, exportSchema = false, version = 1)
/* loaded from: classes.dex */
abstract class MessageCenterPushDatabase extends RoomDatabase {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract b pushDao();
}
