package com.xiaopeng.libconfig.ipc.bean;
/* loaded from: classes.dex */
public class OnlineAccountBean {
    private String accessToken;
    private int grade;
    private String name;
    private boolean onLine;
    private String phone;
    private String pic;
    private String refreshToken;
    private long uid;

    public int getGrade() {
        return this.grade;
    }

    public String getName() {
        return this.name;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getPic() {
        return this.pic;
    }

    public long getUid() {
        return this.uid;
    }

    public boolean isOnLine() {
        return this.onLine;
    }

    public void setGrade(int i) {
        this.grade = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOnLine(boolean z) {
        this.onLine = z;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public void setPic(String str) {
        this.pic = str;
    }

    public void setUid(long j) {
        this.uid = j;
    }

    public String toString() {
        return "OnlineAccountBean{uid='" + this.uid + "', name='" + this.name + "', phone='" + this.phone + "', onLine=" + this.onLine + ", accessToken='" + this.accessToken + "', refreshToken='" + this.refreshToken + "', grade=" + this.grade + ", pic='" + this.pic + "'}";
    }
}
