package com.xiaopeng.device.communication.messagecenter.push;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
/* compiled from: MessageCenterPushBean.java */
@Entity(tableName = "t_message_push")
/* loaded from: classes.dex */
public class a {
    @PrimaryKey(autoGenerate = MqttConnectOptions.CLEAN_SESSION_DEFAULT)

    /* renamed from: a  reason: collision with root package name */
    private Integer f2281a;
    @ColumnInfo(name = "event_name")

    /* renamed from: b  reason: collision with root package name */
    private String f2282b;
    @ColumnInfo

    /* renamed from: c  reason: collision with root package name */
    private String f2283c;
    @ColumnInfo

    /* renamed from: d  reason: collision with root package name */
    private long f2284d;

    public a(String str, String str2, long j) {
        this.f2282b = str;
        this.f2283c = str2;
        this.f2284d = j;
    }

    public String a() {
        return this.f2282b;
    }

    public Integer b() {
        return this.f2281a;
    }

    public String c() {
        return this.f2283c;
    }

    public long d() {
        return this.f2284d;
    }

    public void e(Integer num) {
        this.f2281a = num;
    }

    public String toString() {
        return "MessageCenterPushBean{eventName='" + this.f2282b + "', ts=" + this.f2284d + ", id=" + this.f2281a + '}';
    }
}
