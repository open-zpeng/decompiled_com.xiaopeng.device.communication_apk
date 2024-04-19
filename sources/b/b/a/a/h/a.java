package b.b.a.a.h;

import b.b.a.a.f.i;
import b.b.a.a.f.j;
/* compiled from: BaseRequestAuth.java */
/* loaded from: classes.dex */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private String f1147a;

    /* renamed from: b  reason: collision with root package name */
    private String f1148b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f1149c;

    public a(String str, String str2, boolean z) {
        this.f1147a = null;
        this.f1148b = null;
        this.f1149c = false;
        this.f1147a = str;
        this.f1148b = str2;
        this.f1149c = z;
    }

    public boolean a() {
        return this.f1149c;
    }

    @Override // b.b.a.a.h.b
    public String getAppkey() {
        return this.f1147a;
    }

    @Override // b.b.a.a.h.b
    public String getSign(String str) {
        if (this.f1147a == null || this.f1148b == null) {
            i.c("BaseRequestAuth", "There is no appkey,please check it!");
            return null;
        } else if (str == null) {
            return null;
        } else {
            return j.a(j.b((str + this.f1148b).getBytes()));
        }
    }
}
