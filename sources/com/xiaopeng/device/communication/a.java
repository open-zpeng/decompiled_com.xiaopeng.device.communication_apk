package com.xiaopeng.device.communication;

import android.car.Car;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import b.d.b.c.b;
import b.d.b.e.m.c;
import com.xiaopeng.lib.apirouter.server.IServicePublisher;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: IpcRouterService.java */
/* loaded from: classes.dex */
public class a implements IServicePublisher {

    /* compiled from: IpcRouterService.java */
    /* renamed from: com.xiaopeng.device.communication.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0090a {

        /* renamed from: a  reason: collision with root package name */
        public final int f2182a;

        /* renamed from: b  reason: collision with root package name */
        public final String f2183b;

        public C0090a(int i, String str) {
            this.f2182a = i;
            this.f2183b = str;
        }

        public int a() {
            return this.f2182a;
        }

        public JSONObject b() {
            try {
                return new JSONObject(this.f2183b);
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }

        public String c() {
            return null;
        }
    }

    public static boolean a(int i, String str) {
        String str2;
        try {
            str2 = Car.getXpCduType();
        } catch (Exception e) {
            Log.e("DC_APIROUTER_SERVICE", "onReceiverData onReceiverData exception");
            e.printStackTrace();
            str2 = null;
        }
        if (!TextUtils.isEmpty(str2) && !str2.equals("Q1") && !str2.equals("Q8") && !str2.equals("Q7") && !str2.equals("Q9") && !str2.equals("QB")) {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onReceiverData bundle:\t");
            if (str == null) {
                str = "";
            }
            sb2.append(str);
            sb2.append("unsupport type ");
            sb2.append(str2);
            if (sb2.toString() == null) {
                str2 = "";
            }
            sb.append(str2);
            sb.append("\tMsgId:");
            sb.append(i);
            Log.i("DC_APIROUTER_SERVICE", sb.toString());
            return false;
        } else if (!TextUtils.isEmpty(str2)) {
            return (c.c() && str2.equals("Q1")) ? false : true;
        } else {
            Log.e("DC_APIROUTER_SERVICE", "car type is null apirounter message can not resolve , plz check Car.getXpCduType() :\t" + i);
            return false;
        }
    }

    private static boolean b(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (Exception e) {
            e.printStackTrace();
            packageInfo = null;
        }
        if (packageInfo == null) {
            Log.i("DC_APIROUTER_SERVICE", str + "\tuninstalled");
            return false;
        }
        Log.i("DC_APIROUTER_SERVICE", str + "\tinstalled");
        return true;
    }

    private static boolean c(String str) {
        boolean z = !b(App.c().getApplicationContext(), str) || str.equals("com.xiaopeng.napa");
        Log.i("DC_APIROUTER_SERVICE", "need Send TO Napa :\t" + str + "\t" + z);
        return z;
    }

    public static void e(int i, String str, String str2) {
        Log.i("DC_APIROUTER_SERVICE", "ApiRounter sendData :\tid:" + i + "\tpkgName:\t" + str2 + "\tbound:\t" + str);
        boolean c2 = c(str2);
        if (c2) {
            str2 = "com.xiaopeng.napa";
        }
        String str3 = c2 ? ".AllInIpcRouterService" : ".IpcRouterService";
        Uri.Builder builder = new Uri.Builder();
        Uri build = builder.authority(str2 + str3).path("onReceiverData").appendQueryParameter("id", String.valueOf(i)).appendQueryParameter("bundle", str).build();
        Log.i("DC_APIROUTER_SERVICE", "ApiRounter sendData :\tid:" + i + "\ttargetPackageName:\t" + str2);
        try {
            b.b(build);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void d(int i, String str) {
        if (a(i, str)) {
            C0090a c0090a = new C0090a(i, str);
            if (org.greenrobot.eventbus.c.d().h(C0090a.class)) {
                org.greenrobot.eventbus.c.d().n(c0090a);
            } else {
                org.greenrobot.eventbus.c.d().q(c0090a);
            }
            Log.i("DC_APIROUTER_SERVICE", "Service sub onReceiverData" + i + "\tbundle:\t" + str);
        }
    }
}
