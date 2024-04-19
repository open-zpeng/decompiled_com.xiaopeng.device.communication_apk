package com.xiaopeng.device.communication.account.c;

import android.os.SystemProperties;
import com.xiaopeng.device.communication.account.bean.ModuleVersionBean;
/* compiled from: ModuleVersionModel.java */
/* loaded from: classes.dex */
public class c {

    /* compiled from: ModuleVersionModel.java */
    /* loaded from: classes.dex */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        private static final c f2198a = new c();
    }

    public static c a() {
        return b.f2198a;
    }

    public ModuleVersionBean b() {
        ModuleVersionBean moduleVersionBean = new ModuleVersionBean();
        moduleVersionBean.setAvmVersion(SystemProperties.get("sys.ECU_AVM.version", "Unknown"));
        moduleVersionBean.setBcmVersion(SystemProperties.get("sys.ECU_BCM.version", "Unknown"));
        moduleVersionBean.setTpmsVersion(SystemProperties.get("sys.ECU_TPMS.version", "Unknown"));
        moduleVersionBean.setScuVersion(SystemProperties.get("sys.ECU_SCU.version", "Unknown"));
        moduleVersionBean.setPepsVersion(SystemProperties.get("sys.ECU_PEPS.version", "Unknown"));
        moduleVersionBean.setOcuVersion(SystemProperties.get("sys.ECU_OCU.version", "Unknown"));
        moduleVersionBean.setMsmVersion(SystemProperties.get("sys.ECU_MSM.version", "Unknown"));
        moduleVersionBean.setOledVersion(SystemProperties.get("sys.ECU_OLED.version", "Unknown"));
        moduleVersionBean.setBmsVersion(SystemProperties.get("sys.ECU_BMS.version", "Unknown"));
        moduleVersionBean.setIpuVersion(SystemProperties.get("sys.ECU_IPU.version", "Unknown"));
        moduleVersionBean.setHvacVersion(SystemProperties.get("sys.ECU_HVAC.version", "Unknown"));
        return moduleVersionBean;
    }

    private c() {
    }
}
