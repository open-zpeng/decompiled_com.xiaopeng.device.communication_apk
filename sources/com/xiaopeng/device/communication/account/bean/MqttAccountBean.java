package com.xiaopeng.device.communication.account.bean;

import com.google.gson.annotations.SerializedName;
/* loaded from: classes.dex */
public class MqttAccountBean {
    @SerializedName("biz")
    private MqttAccount bizAccount;
    @SerializedName("data")
    private MqttAccount dataAccount;

    /* loaded from: classes.dex */
    public static class MqttAccount {
        @SerializedName("clientId")
        private String clientId;
        @SerializedName("expireTime")
        private long expireTime;
        @SerializedName("password")
        private String password;
        @SerializedName("serverSsl")
        private String server;
        @SerializedName("username")
        private String userName;

        public String getClientId() {
            return this.clientId;
        }

        public long getExpireTime() {
            return this.expireTime;
        }

        public String getPassword() {
            return this.password;
        }

        public String getServer() {
            return this.server;
        }

        public String getUserName() {
            return this.userName;
        }

        public void setClientId(String str) {
            this.clientId = str;
        }

        public void setExpireTime(long j) {
            this.expireTime = j;
        }

        public void setPassword(String str) {
            this.password = str;
        }

        public void setServer(String str) {
            this.server = str;
        }

        public void setUserName(String str) {
            this.userName = str;
        }

        public String toString() {
            return "MqttAccount{clientId='" + this.clientId + "', userName='" + this.userName + "', password='" + this.password + "', server='" + this.server + "', expireTime='" + this.expireTime + "'}";
        }
    }

    public MqttAccount getBizAccount() {
        return this.bizAccount;
    }

    public MqttAccount getDataAccount() {
        return this.dataAccount;
    }

    public void setBizAccount(MqttAccount mqttAccount) {
        this.bizAccount = mqttAccount;
    }

    public void setDataAccount(MqttAccount mqttAccount) {
        this.dataAccount = mqttAccount;
    }

    public String toString() {
        return "MqttAccountBean{dataAccount=" + this.dataAccount + ", bizAccount=" + this.bizAccount + '}';
    }
}
