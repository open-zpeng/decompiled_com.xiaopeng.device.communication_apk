package b.d.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.Log;
import b.d.b.e.g;
import com.google.gson.reflect.TypeToken;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEvent;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* compiled from: StatEvent.java */
/* loaded from: classes.dex */
public class d implements IStatEvent {

    /* renamed from: a  reason: collision with root package name */
    private static String f1277a;

    /* renamed from: b  reason: collision with root package name */
    private static String f1278b;

    /* renamed from: c  reason: collision with root package name */
    private String f1279c;

    /* renamed from: d  reason: collision with root package name */
    private Map<String, Object> f1280d;

    /* compiled from: StatEvent.java */
    /* loaded from: classes.dex */
    class a extends TypeToken<Map<String, Object>> {
        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Context context) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.f1280d = concurrentHashMap;
        concurrentHashMap.put(IStatEvent.CUSTOM_TIMESTAMP, Long.valueOf(System.currentTimeMillis()));
        this.f1280d.put(IStatEvent.CUSTOM_MODULE_VERSION, d(context));
        this.f1280d.put(IStatEvent.CUSTOM_NETWORK, c(context));
        this.f1280d.put(IStatEvent.CUSTOM_STARTUP, Long.valueOf(SystemClock.uptimeMillis() / 1000));
        this.f1280d.put(IStatEvent.CUSTOM_DEVICE_MCUVER, a());
        this.f1280d.put(IStatEvent.CUSTOM_UID, Long.valueOf(g.a()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a() {
        if (TextUtils.isEmpty(f1277a)) {
            f1277a = SystemProperties.get("persist.sys.mcu.version");
        }
        if (TextUtils.isEmpty(f1277a)) {
            f1277a = SystemProperties.get("sys.mcu.version");
        }
        return f1277a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(String str) {
        String[] split;
        return (TextUtils.isEmpty(str) || (split = str.split("_")) == null || split.length <= 0) ? "" : split[0];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            if (activeNetworkInfo.getType() != 0) {
                return activeNetworkInfo.getType() == 1 ? "WIFI" : "";
            }
            switch (activeNetworkInfo.getSubtype()) {
                case 1:
                case 2:
                case 4:
                case 7:
                    return "2G";
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return "3G";
                case 11:
                default:
                    return "";
                case 13:
                    return "4G";
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String d(Context context) {
        if (TextUtils.isEmpty(f1278b)) {
            try {
                f1278b = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (Exception e) {
                Log.w("StatEvent", "getVersion fail!", e);
                return "Unknown";
            }
        }
        return f1278b;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEvent
    public String getEventName() {
        return this.f1279c;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEvent
    public void put(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.f1280d.put(str, str2);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEvent
    public void setEventName(String str) {
        this.f1279c = str;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEvent
    public String toJson() {
        this.f1280d.put(IStatEvent.CUSTOM_MODULE, b(this.f1279c));
        this.f1280d.put(IStatEvent.CUSTOM_EVENT, this.f1279c);
        return b.d.a.f.b.b().a().toJson(this.f1280d, new a().getType());
    }

    public String toString() {
        return "StatEvent{eventName='" + this.f1279c + "'}";
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEvent
    public void put(String str, Number number) {
        if (str == null || number == null) {
            return;
        }
        this.f1280d.put(str, number);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEvent
    public void put(String str, Boolean bool) {
        if (str == null || bool == null) {
            return;
        }
        this.f1280d.put(str, bool);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEvent
    public void put(String str, Character ch) {
        if (str == null || ch == null) {
            return;
        }
        this.f1280d.put(str, ch);
    }
}
