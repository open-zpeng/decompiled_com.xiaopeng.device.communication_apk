package b.b.a.a.f;

import android.text.TextUtils;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
/* compiled from: UtHostnameVerifier.java */
/* loaded from: classes.dex */
class w implements HostnameVerifier {

    /* renamed from: a  reason: collision with root package name */
    public String f1138a;

    public w(String str) {
        this.f1138a = str;
    }

    public String a() {
        return this.f1138a;
    }

    public boolean equals(Object obj) {
        if (TextUtils.isEmpty(this.f1138a) || !(obj instanceof w)) {
            return false;
        }
        String str = ((w) obj).f1138a;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f1138a.equals(str);
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        return HttpsURLConnection.getDefaultHostnameVerifier().verify(this.f1138a, sSLSession);
    }
}
