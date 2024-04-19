package com.xiaopeng.device.communication.b.a;

import android.car.hardware.CarPropertyValue;
import android.car.hardware.avas.CarAvasManager;
import android.car.hardware.bcm.CarBcmManager;
import android.car.hardware.ciu.CarCiuManager;
import android.car.hardware.eps.CarEpsManager;
import android.car.hardware.esp.CarEspManager;
import android.car.hardware.hvac.CarHvacManager;
import android.car.hardware.icm.CarIcmManager;
import android.car.hardware.mcu.CarMcuManager;
import android.car.hardware.msm.CarMsmManager;
import android.car.hardware.scu.CarScuManager;
import android.car.hardware.tpms.CarTpmsManager;
import android.car.hardware.vcu.CarVcuManager;
import android.util.Log;
import java.util.List;
/* compiled from: CarServiceEventAdapter.java */
/* loaded from: classes.dex */
public class f implements CarBcmManager.CarBcmEventCallback, CarMcuManager.CarMcuEventCallback, CarVcuManager.CarVcuEventCallback, CarIcmManager.CarIcmEventCallback, CarTpmsManager.CarTpmsEventCallback, CarEpsManager.CarEpsEventCallback, CarAvasManager.CarAvasEventCallback, CarScuManager.CarScuEventCallback, CarEspManager.CarEspEventCallback, CarMsmManager.CarMsmEventCallback, CarCiuManager.CarCiuEventCallback, CarHvacManager.CarHvacEventCallback {

    /* renamed from: a  reason: collision with root package name */
    private String f2216a;

    /* renamed from: b  reason: collision with root package name */
    private List<e> f2217b;

    /* renamed from: c  reason: collision with root package name */
    private List<Integer> f2218c;

    /* compiled from: CarServiceEventAdapter.java */
    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CarPropertyValue f2219a;

        a(CarPropertyValue carPropertyValue) {
            this.f2219a = carPropertyValue;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (e eVar : f.this.f2217b) {
                eVar.onChangeEvent(this.f2219a);
            }
        }
    }

    /* compiled from: CarServiceEventAdapter.java */
    /* loaded from: classes.dex */
    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f2221a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f2222b;

        b(int i, int i2) {
            this.f2221a = i;
            this.f2222b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (e eVar : f.this.f2217b) {
                eVar.onErrorEvent(this.f2221a, this.f2222b);
            }
        }
    }

    public f(String str, List<e> list) {
        this.f2216a = str;
        this.f2217b = list;
    }

    private boolean b(int i) {
        List<Integer> list = this.f2218c;
        if (list == null) {
            return true;
        }
        return list.contains(Integer.valueOf(i));
    }

    public void onChangeEvent(CarPropertyValue carPropertyValue) {
        if (b(carPropertyValue.getPropertyId())) {
            Log.d("CarServiceEventAdapter", "ServiceName:" + this.f2216a + " onChangeEvent value = " + carPropertyValue.toString());
            d.a(new a(carPropertyValue));
        }
    }

    public void onErrorEvent(int i, int i2) {
        if (b(i)) {
            return;
        }
        Log.e("CarServiceEventAdapter", "ServiceName:" + this.f2216a + " onErrorEvent error, propertyId = " + i + " zone = " + i2);
        d.a(new b(i, i2));
    }
}
