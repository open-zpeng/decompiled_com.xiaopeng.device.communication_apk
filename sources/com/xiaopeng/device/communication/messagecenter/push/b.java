package com.xiaopeng.device.communication.messagecenter.push;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import java.util.List;
/* compiled from: MessageCenterPushDao.java */
@Dao
/* loaded from: classes.dex */
public interface b {
    @Query("SELECT * FROM t_message_push where ts > :start")
    List<a> a(long j);

    @Insert
    void b(a aVar);

    @Query("DELETE FROM t_message_push where ts < :deadline")
    void c(long j);

    @Delete
    void d(a aVar);
}
