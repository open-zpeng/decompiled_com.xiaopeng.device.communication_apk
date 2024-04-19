package com.ut.mini.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import b.b.a.a.a;
import b.b.a.a.c;
import b.b.a.a.e;
import b.b.a.a.f.p;
import com.ut.device.UTDevice;
import com.ut.mini.base.UTMIVariables;
import java.util.Map;
/* loaded from: classes.dex */
public class UTTeamWork {

    /* renamed from: a  reason: collision with root package name */
    private static UTTeamWork f2164a;

    public static synchronized UTTeamWork getInstance() {
        UTTeamWork uTTeamWork;
        synchronized (UTTeamWork.class) {
            if (f2164a == null) {
                f2164a = new UTTeamWork();
            }
            uTTeamWork = f2164a;
        }
        return uTTeamWork;
    }

    public void clearHost4Https(Context context) {
        if (context == null) {
            Log.w("UTTeamWork", "context is null");
            return;
        }
        a.b.h("");
        p.a(context, "utanalytics_https_host", null);
    }

    public void closeAuto1010Track() {
        e.a().f();
    }

    public void disableNetworkStatusChecker() {
    }

    public void dispatchLocalHits() {
    }

    public void enableUpload(boolean z) {
        a.i = z;
    }

    public String getUtsid() {
        try {
            String appkey = a.a() != null ? a.a().getAppkey() : null;
            String utdid = UTDevice.getUtdid(c.b().f());
            long longValue = Long.valueOf(a.e).longValue();
            if (!TextUtils.isEmpty(appkey) && !TextUtils.isEmpty(utdid)) {
                return utdid + "_" + appkey + "_" + longValue;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void initialized() {
    }

    public void saveCacheDataToLocal() {
        b.b.a.a.d.c.e().a();
    }

    public void setHost4Https(Context context, String str) {
        if (context == null) {
            Log.w("UTTeamWork", "context is null");
        } else if (TextUtils.isEmpty(str)) {
            Log.w("UTTeamWork", "host or port is empty");
        } else {
            a.b.h(str);
            p.a(context, "utanalytics_https_host", str);
        }
    }

    public void setToAliyunOsPlatform() {
        UTMIVariables.getInstance().setToAliyunOSPlatform();
    }

    public void turnOffRealTimeDebug() {
        com.alibaba.mtl.appmonitor.a.t();
    }

    public void turnOnRealTimeDebug(Map<String, String> map) {
        com.alibaba.mtl.appmonitor.a.u(map);
    }
}
