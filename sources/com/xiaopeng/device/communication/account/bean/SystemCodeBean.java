package com.xiaopeng.device.communication.account.bean;

import com.google.gson.annotations.SerializedName;
import com.irdeto.securesdk.core.SSUtils;
/* loaded from: classes.dex */
public class SystemCodeBean<T> {
    @SerializedName("hardware_id")
    private String hardwareId;
    @SerializedName("iccid")
    private String iccid;
    @SerializedName("imei")
    private String imei;
    @SerializedName("module_version")
    private T moduleVersion;
    @SerializedName("vid")
    private int vid;
    @SerializedName(SSUtils.O0000Ooo)
    private String vinCode;

    public String getHardwareId() {
        return this.hardwareId;
    }

    public String getIccid() {
        return this.iccid;
    }

    public String getImei() {
        return this.imei;
    }

    public T getModuleVersion() {
        return this.moduleVersion;
    }

    public int getVid() {
        return this.vid;
    }

    public String getVinCode() {
        return this.vinCode;
    }

    public void setHardwareId(String str) {
        this.hardwareId = str;
    }

    public void setIccid(String str) {
        this.iccid = str;
    }

    public void setImei(String str) {
        this.imei = str;
    }

    public void setModuleVersion(T t) {
        this.moduleVersion = t;
    }

    public void setVid(int i) {
        this.vid = i;
    }

    public void setVinCode(String str) {
        this.vinCode = str;
    }

    public String toString() {
        return "SystemCodeBean{vinCode='" + this.vinCode + "', iccid='" + this.iccid + "', hardwareId='" + this.hardwareId + "', vid=" + this.vid + ", imei='" + this.imei + "', moduleVersion='" + this.moduleVersion + "'}";
    }
}
