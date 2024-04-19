package com.xiaopeng.device.communication;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.Log;
import b.d.b.e.m.b;
import b.d.b.e.m.c;
import com.xiaopeng.device.communication.account.AccountService;
import com.xiaopeng.device.communication.b.a.j;
import com.xiaopeng.lib.framework.ipcmodule.IpcModuleEntry;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.ipcmodule.IIpcService;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IHttp;
import com.xiaopeng.lib.framework.netchannelmodule.NetworkChannelsEntry;
import com.xiaopeng.lib.framework.netchannelmodule.common.TrafficeStaFlagInterceptor;
import com.xiaopeng.lib.framework.netchannelmodule.http.xmart.bizapi.BizConstants;
import com.xiaopeng.lib.http.HttpsUtils;
/* loaded from: classes.dex */
public class App extends Application {

    /* renamed from: a  reason: collision with root package name */
    private static App f2174a;

    /* renamed from: b  reason: collision with root package name */
    private com.xiaopeng.device.communication.d.b.a f2175b;

    private String a() {
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DeviceCommunicationApp");
        stringBuffer.append(": \t");
        stringBuffer.append("commitID :");
        stringBuffer.append("78a32aed52d97a0c31a8014d27bab90787d1ad73");
        stringBuffer.append("\t");
        stringBuffer.append("RELEASE_TIME :");
        stringBuffer.append("20230725-123923");
        stringBuffer.append("\tCarType :");
        try {
            str = c.a();
        } catch (Exception e) {
            Log.e("DeviceCommunicationApp", "getCarType exception");
            e.printStackTrace();
            str = "null";
        }
        stringBuffer.append(str);
        stringBuffer.append("\t");
        stringBuffer.append("internaltionVer:");
        stringBuffer.append(c.c());
        stringBuffer.append("\tURL:\t");
        stringBuffer.append(com.xiaopeng.device.communication.d.a.f2255a);
        stringBuffer.append("\tBid:\t");
        stringBuffer.append(b.a());
        stringBuffer.append("\tSEC:\t");
        stringBuffer.append(BizConstants.CAR_SECRET);
        return stringBuffer.toString();
    }

    public static App c() {
        return f2174a;
    }

    private void d() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        getApplicationContext().registerReceiver(new AppBroadcastReceiver(), intentFilter);
    }

    public com.xiaopeng.device.communication.d.b.a b() {
        return this.f2175b;
    }

    public void e(Context context, String str) {
        b.d.b.e.c.a("DeviceCommunicationApp", "start AccountService");
        Intent intent = new Intent(context, AccountService.class);
        if (!TextUtils.isEmpty(str)) {
            intent.setAction(str);
        }
        context.startServiceAsUser(intent, UserHandle.CURRENT);
    }

    public void f(Context context) {
        b.d.b.e.c.a("DeviceCommunicationApp", "start DcService");
        context.startServiceAsUser(new Intent(context, DcService.class), UserHandle.CURRENT);
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        b.d.b.e.c.l("DeviceCommunicationApp", a());
        f2174a = this;
        this.f2175b = com.xiaopeng.device.communication.d.b.a.a();
        b.d.b.d.a.l(this);
        com.xiaopeng.device.communication.b.a.c.i(this);
        HttpsUtils.init(this, true);
        Module.register(NetworkChannelsEntry.class, new NetworkChannelsEntry());
        ((IHttp) Module.get(NetworkChannelsEntry.class).get(IHttp.class)).config().applicationContext(this).enableTrafficStats().addInterceptor(new TrafficeStaFlagInterceptor()).apply();
        Module.register(IpcModuleEntry.class, new IpcModuleEntry(this));
        ((IIpcService) Module.get(IpcModuleEntry.class).get(IIpcService.class)).init();
        d();
        e(this, null);
        f(this);
        try {
            j.a().b(this).d();
            com.xiaopeng.device.communication.b.b.b.c().d(this).f();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            org.greenrobot.eventbus.c.b().h(false).f(false).g(false).e();
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override // android.app.Application
    public void onTerminate() {
        super.onTerminate();
        HttpsUtils.destroy();
    }
}
