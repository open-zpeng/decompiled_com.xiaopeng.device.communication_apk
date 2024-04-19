package b.d.b.e.k;

import b.d.b.e.m.c;
/* compiled from: CommonConfig.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1423a = "car.xmart.com/" + b.d.b.e.m.b.e();

    /* renamed from: b  reason: collision with root package name */
    public static String f1424b = b.b("https://10.0.13.28:8553", "https://xmart.xiaopeng.com");

    /* renamed from: c  reason: collision with root package name */
    public static String f1425c = b.b("https://10.0.13.28:8556", "https://xmart-eu.xiaopeng.com");

    /* renamed from: d  reason: collision with root package name */
    public static final String f1426d;

    static {
        if (c.c()) {
            f1426d = f1425c + "/biz";
            return;
        }
        f1426d = f1424b + "/biz";
    }
}
