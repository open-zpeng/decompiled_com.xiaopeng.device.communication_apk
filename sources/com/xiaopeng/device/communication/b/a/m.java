package com.xiaopeng.device.communication.b.a;

import android.car.Car;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
/* compiled from: XPCar.java */
/* loaded from: classes.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private Context f2233a;

    /* renamed from: b  reason: collision with root package name */
    private Car f2234b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2235c;

    /* renamed from: d  reason: collision with root package name */
    private g f2236d;

    /* compiled from: XPCar.java */
    /* loaded from: classes.dex */
    class a implements ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            m.this.f();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            m.this.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Context context) {
        this.f2233a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Log.i("XPCar", "CarVersion :" + c.h() + " Car connected!");
        this.f2235c = true;
        g gVar = this.f2236d;
        if (gVar != null) {
            gVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        Log.e("XPCar", "Car disConnected!");
        this.f2235c = false;
        g gVar = this.f2236d;
        if (gVar != null) {
            gVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        String xpCduType = Car.getXpCduType();
        xpCduType.hashCode();
        char c2 = 65535;
        switch (xpCduType.hashCode()) {
            case 2064:
                if (xpCduType.equals("A1")) {
                    c2 = 0;
                    break;
                }
                break;
            case 2065:
                if (xpCduType.equals("A2")) {
                    c2 = 1;
                    break;
                }
                break;
            case 2066:
                if (xpCduType.equals("A3")) {
                    c2 = 2;
                    break;
                }
                break;
            case 2561:
                if (xpCduType.equals("Q2")) {
                    c2 = 3;
                    break;
                }
                break;
            case 2564:
                if (xpCduType.equals("Q5")) {
                    c2 = 4;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
                return;
            default:
                Car createCar = Car.createCar(this.f2233a, new a());
                this.f2234b = createCar;
                createCar.connect();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object d() {
        String xpCduType = Car.getXpCduType();
        xpCduType.hashCode();
        char c2 = 65535;
        switch (xpCduType.hashCode()) {
            case 2064:
                if (xpCduType.equals("A1")) {
                    c2 = 0;
                    break;
                }
                break;
            case 2065:
                if (xpCduType.equals("A2")) {
                    c2 = 1;
                    break;
                }
                break;
            case 2066:
                if (xpCduType.equals("A3")) {
                    c2 = 2;
                    break;
                }
                break;
            case 2561:
                if (xpCduType.equals("Q2")) {
                    c2 = 3;
                    break;
                }
                break;
            case 2564:
                if (xpCduType.equals("Q5")) {
                    c2 = 4;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
                return null;
            default:
                return this.f2234b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return this.f2235c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(g gVar) {
        this.f2236d = gVar;
    }
}
