package com.xiaopeng.device.communication.b.a;

import android.car.hardware.CarPropertyValue;
import android.util.Log;
/* compiled from: BaseCallbackAdapter.java */
/* loaded from: classes.dex */
public abstract class a implements e {
    protected abstract void a(int i, Object obj);

    @Override // com.xiaopeng.device.communication.b.a.e
    public final void onChangeEvent(CarPropertyValue carPropertyValue) {
        if (carPropertyValue == null) {
            return;
        }
        Object value = carPropertyValue.getValue();
        if (value == null) {
            Log.e("BaseCallbackAdapter", "onChangeEvent error, value is null.");
        } else {
            a(carPropertyValue.getPropertyId(), value);
        }
    }

    @Override // com.xiaopeng.device.communication.b.a.e
    public void onErrorEvent(int i, int i2) {
    }
}
