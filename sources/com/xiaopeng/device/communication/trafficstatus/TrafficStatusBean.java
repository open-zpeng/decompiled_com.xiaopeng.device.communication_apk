package com.xiaopeng.device.communication.trafficstatus;

import android.support.annotation.Keep;
@Keep
/* loaded from: classes.dex */
public class TrafficStatusBean {
    private long time;
    private int type;

    public long getTime() {
        return this.time;
    }

    public int getType() {
        return this.type;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String toString() {
        return "TrafficStatusBean{type=" + this.type + ", time=" + this.time + '}';
    }
}
