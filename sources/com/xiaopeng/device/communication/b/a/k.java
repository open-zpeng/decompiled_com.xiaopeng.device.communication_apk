package com.xiaopeng.device.communication.b.a;

import android.car.hardware.icm.CarIcmManager;
import java.util.ArrayList;
/* compiled from: IcmStrategy.java */
/* loaded from: classes.dex */
public class k extends b implements h {

    /* renamed from: b  reason: collision with root package name */
    private CarIcmManager f2231b;

    @Override // com.xiaopeng.device.communication.b.a.h
    public void a() {
        try {
            b.d.b.e.c.l("IcmStrategy", "IcmStrategy register");
            this.f2231b = c("xp_icm");
            ArrayList arrayList = new ArrayList();
            arrayList.add(554702429);
            this.f2231b.registerPropCallback(arrayList, new f("IcmStrategy", this.f2210a));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
