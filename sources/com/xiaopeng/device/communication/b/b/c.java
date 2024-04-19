package com.xiaopeng.device.communication.b.b;

import android.car.hardware.mcu.CarMcuManager;
import com.xiaopeng.device.communication.b.a.f;
import com.xiaopeng.device.communication.b.a.h;
import java.util.ArrayList;
/* compiled from: McuStrategy.java */
/* loaded from: classes.dex */
public class c extends com.xiaopeng.device.communication.b.a.b implements h {

    /* renamed from: b  reason: collision with root package name */
    private CarMcuManager f2244b;

    @Override // com.xiaopeng.device.communication.b.a.h
    public void a() {
        try {
            b.d.b.e.c.l("McuStrategy", "McuStrategy register");
            this.f2244b = c("xp_mcu");
            ArrayList arrayList = new ArrayList();
            arrayList.add(557847561);
            this.f2244b.registerPropCallback(arrayList, new f("McuStrategy", this.f2210a));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
