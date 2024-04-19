package com.xiaopeng.lib.http;

import android.os.Build;
import b.d.b.e.k.a;
import b.d.b.e.m.b;
/* loaded from: classes.dex */
public class CommonUtils {
    public static final String ACTION_BROADCAST_ISF_SECURE_STORE_RELOAD;
    public static final String ACTION_BROADCAST_SECURE_STORE_RELOAD = "com.xiaopeng.action.SECURE_STORE_RELOAD";
    public static final String CAR_APP_ID = "xmart:appid:002";
    public static final String CAR_APP_SEC = "B638C588DCAD7C1A43E6FB";
    public static final String KEY_CLIENT = "Client";
    private static final String TAG = "CommonUtils";
    public static String HTTP_HOST = a.f1424b;
    public static final String CAR_CLIENT_DEFAULT = "car.xmart.com/" + b.e();

    static {
        if (Build.VERSION.SDK_INT == 19) {
            ACTION_BROADCAST_ISF_SECURE_STORE_RELOAD = "com.xiaopeng.action.ISF_SECURE_STORE_RELOAD";
        } else {
            ACTION_BROADCAST_ISF_SECURE_STORE_RELOAD = ACTION_BROADCAST_SECURE_STORE_RELOAD;
        }
    }

    public static boolean isPreEnv() {
        return b.d.b.e.k.b.e();
    }
}
