package com.xiaopeng.device.communication.messagecenter.push;

import android.arch.persistence.room.Room;
import com.xiaopeng.device.communication.App;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MessageCenterPushModel.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private MessageCenterPushDatabase f2302a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e() {
        d();
    }

    private void d() {
        this.f2302a = (MessageCenterPushDatabase) Room.databaseBuilder(App.c(), MessageCenterPushDatabase.class, "push.db").allowMainThreadQueries().build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f2302a.pushDao().c(System.currentTimeMillis() - 86400000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(a aVar) {
        this.f2302a.pushDao().d(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<a> c() {
        return this.f2302a.pushDao().a(System.currentTimeMillis() - 86400000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(a aVar) {
        this.f2302a.pushDao().b(aVar);
    }
}
