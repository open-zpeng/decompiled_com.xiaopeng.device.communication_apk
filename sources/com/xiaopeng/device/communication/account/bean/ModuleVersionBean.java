package com.xiaopeng.device.communication.account.bean;

import com.google.gson.annotations.SerializedName;
/* loaded from: classes.dex */
public class ModuleVersionBean {
    @SerializedName("avm_version")
    private String avmVersion;
    @SerializedName("bcm_version")
    private String bcmVersion;
    @SerializedName("bms_version")
    private String bmsVersion;
    @SerializedName("hvac_version")
    private String hvacVersion;
    @SerializedName("ipu_version")
    private String ipuVersion;
    @SerializedName("msm_version")
    private String msmVersion;
    @SerializedName("ocu_version")
    private String ocuVersion;
    @SerializedName("oled_version")
    private String oledVersion;
    @SerializedName("peps_version")
    private String pepsVersion;
    @SerializedName("scu_version")
    private String scuVersion;
    @SerializedName("tpms_version")
    private String tpmsVersion;

    public String getAvmVersion() {
        return this.avmVersion;
    }

    public String getBcmVersion() {
        return this.bcmVersion;
    }

    public String getBmsVersion() {
        return this.bmsVersion;
    }

    public String getHvacVersion() {
        return this.hvacVersion;
    }

    public String getIpuVersion() {
        return this.ipuVersion;
    }

    public String getMsmVersion() {
        return this.msmVersion;
    }

    public String getOcuVersion() {
        return this.ocuVersion;
    }

    public String getOledVersion() {
        return this.oledVersion;
    }

    public String getPepsVersion() {
        return this.pepsVersion;
    }

    public String getScuVersion() {
        return this.scuVersion;
    }

    public String getTpmsVersion() {
        return this.tpmsVersion;
    }

    public void setAvmVersion(String str) {
        this.avmVersion = str;
    }

    public void setBcmVersion(String str) {
        this.bcmVersion = str;
    }

    public void setBmsVersion(String str) {
        this.bmsVersion = str;
    }

    public void setHvacVersion(String str) {
        this.hvacVersion = str;
    }

    public void setIpuVersion(String str) {
        this.ipuVersion = str;
    }

    public void setMsmVersion(String str) {
        this.msmVersion = str;
    }

    public void setOcuVersion(String str) {
        this.ocuVersion = str;
    }

    public void setOledVersion(String str) {
        this.oledVersion = str;
    }

    public void setPepsVersion(String str) {
        this.pepsVersion = str;
    }

    public void setScuVersion(String str) {
        this.scuVersion = str;
    }

    public void setTpmsVersion(String str) {
        this.tpmsVersion = str;
    }

    public String toString() {
        return "ModuleVersionBean{bcmVersion='" + this.bcmVersion + "', tpmsVersion='" + this.tpmsVersion + "', scuVersion='" + this.scuVersion + "', pepsVersion='" + this.pepsVersion + "', ocuVersion='" + this.ocuVersion + "', avmVersion='" + this.avmVersion + "', msmVersion='" + this.msmVersion + "', oledVersion='" + this.oledVersion + "', bmsVersion='" + this.bmsVersion + "', ipuVersion='" + this.ipuVersion + "', hvacVersion='" + this.hvacVersion + "'}";
    }
}
