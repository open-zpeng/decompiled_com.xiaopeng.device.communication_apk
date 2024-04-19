package com.xiaopeng.device.communication.b.a;

import android.car.hardware.input.CarInputManager;
import java.util.ArrayList;
/* compiled from: InputStrategy.java */
/* loaded from: classes.dex */
public class l extends b implements h {

    /* renamed from: b  reason: collision with root package name */
    private CarInputManager f2232b;

    @Override // com.xiaopeng.device.communication.b.a.h
    public void a() {
        try {
            b.d.b.e.c.l("InputStrategy", "InputStrategy register");
            this.f2232b = c("xp_input");
            ArrayList arrayList = new ArrayList();
            arrayList.add(557851176);
            this.f2232b.registerPropCallback(arrayList, new f("InputStrategy", this.f2210a));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
