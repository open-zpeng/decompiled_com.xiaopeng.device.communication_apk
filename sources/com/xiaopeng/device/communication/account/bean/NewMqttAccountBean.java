package com.xiaopeng.device.communication.account.bean;

import com.google.gson.annotations.SerializedName;
/* loaded from: classes.dex */
public class NewMqttAccountBean {
    @SerializedName("mqttAccount")
    public MqttAccountBean mqttAccount;
    @SerializedName("vehicleId")
    public int vehicleId;

    /* loaded from: classes.dex */
    public static class MqttAccountBean {
        @SerializedName("clientId")
        public String clientId;
        @SerializedName("mcuClientId")
        public String mcuClientId;
        @SerializedName("mcuPassword")
        public String mcuPassword;
        @SerializedName("mcuUsername")
        public String mcuUsername;
        @SerializedName("password")
        public String password;
        @SerializedName("serverSsl")
        public String serverSsl;
        @SerializedName("serverSslUpload")
        public String serverSslUpload;
        @SerializedName("username")
        public String username;
    }
}
