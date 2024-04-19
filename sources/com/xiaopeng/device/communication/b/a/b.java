package com.xiaopeng.device.communication.b.a;

import android.car.CarManagerBase;
import android.car.CarNotConnectedException;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
/* compiled from: BaseStrategy.java */
/* loaded from: classes.dex */
public abstract class b implements h {

    /* renamed from: a  reason: collision with root package name */
    protected List<e> f2210a = new ArrayList();

    public final void b(e eVar) {
        if (eVar != null) {
            if (this.f2210a.contains(eVar)) {
                return;
            }
            this.f2210a.add(eVar);
            return;
        }
        throw new RuntimeException("CarService call back can not be null.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final CarManagerBase c(String str) {
        try {
            Object carManager = c.f().getCarManager(str);
            if (carManager instanceof CarManagerBase) {
                return (CarManagerBase) carManager;
            }
            return null;
        } catch (CarNotConnectedException e) {
            Log.e("BaseStrategy", "getCarManagerService error, CarNotConnectedException");
            e.printStackTrace();
            return null;
        }
    }
}
