package b.d.b.c;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: RemoteOperator.java */
/* loaded from: classes.dex */
class d {

    /* renamed from: a  reason: collision with root package name */
    private static String f1335a = "d";

    /* renamed from: b  reason: collision with root package name */
    private IBinder f1336b;

    /* renamed from: c  reason: collision with root package name */
    private IBinder.DeathRecipient f1337c;

    /* renamed from: d  reason: collision with root package name */
    private Map<String, c> f1338d;
    private String e;
    private String f;
    private AtomicBoolean g = new AtomicBoolean(true);

    /* compiled from: RemoteOperator.java */
    /* loaded from: classes.dex */
    class a implements IBinder.DeathRecipient {
        a() {
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            String str = d.f1335a;
            Log.d(str, "binderDied:desc=" + d.this.e + ", auth=" + d.this.f + ",rec=" + Integer.toHexString(hashCode()) + ",obj=" + Integer.toHexString(d.this.hashCode()));
            d.this.k("binderDied");
        }
    }

    private d(IBinder iBinder, Map<String, c> map, String str, String str2) {
        this.f1336b = iBinder;
        this.f1338d = map;
        this.e = str;
        this.f = str2;
    }

    public static d e(IBinder iBinder, String str) {
        ArrayList arrayList;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("DESCRIPTOR");
            String optString = jSONObject.optString("authority", string);
            JSONArray jSONArray = jSONObject.getJSONArray("TRANSACTION");
            HashMap hashMap = new HashMap();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                JSONArray optJSONArray = jSONObject2.optJSONArray("parameter");
                if (optJSONArray != null) {
                    arrayList = new ArrayList(optJSONArray.length());
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject jSONObject3 = optJSONArray.getJSONObject(i2);
                        arrayList.add(new Pair(jSONObject3.getString("alias"), jSONObject3.getString("name")));
                    }
                } else {
                    arrayList = null;
                }
                String string2 = jSONObject2.getString("METHOD");
                String optString2 = jSONObject2.optString("path", string2);
                c cVar = new c(string2, jSONObject2.getInt("ID"), arrayList);
                hashMap.put(string2, cVar);
                if (!string2.equals(optString2)) {
                    hashMap.put(optString2, cVar);
                }
            }
            return new d(iBinder, hashMap, string, optString);
        } catch (JSONException unused) {
            Log.e(f1335a, "Remote IDL parsed error");
            return null;
        }
    }

    private Object j(Parcel parcel) {
        return parcel.readValue(d.class.getClassLoader());
    }

    public Object d(Uri uri, boolean z, byte[] bArr) throws RemoteException {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() != 0) {
            String str = pathSegments.get(0);
            Map<String, c> map = this.f1338d;
            if (map != null && map.size() != 0) {
                c cVar = this.f1338d.get(str);
                if (cVar != null) {
                    Uri.Builder builder = new Uri.Builder();
                    builder.authority(this.e).path(cVar.b());
                    if (cVar.c() != null) {
                        for (Pair<String, String> pair : cVar.c()) {
                            String queryParameter = uri.getQueryParameter((String) pair.second);
                            if (!TextUtils.isEmpty(queryParameter)) {
                                builder.appendQueryParameter((String) pair.second, queryParameter);
                            } else {
                                String queryParameter2 = uri.getQueryParameter((String) pair.first);
                                if (!TextUtils.isEmpty(queryParameter2)) {
                                    builder.appendQueryParameter((String) pair.second, queryParameter2);
                                }
                            }
                        }
                    } else {
                        for (String str2 : uri.getQueryParameterNames()) {
                            builder.appendQueryParameter(str2, uri.getQueryParameter(str2));
                        }
                    }
                    Uri build = builder.build();
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(this.e);
                        Uri.writeToParcel(obtain, build);
                        if (z) {
                            obtain.writeBlob(bArr);
                        }
                        this.f1336b.transact(cVar.a(), obtain, obtain2, 0);
                        obtain2.readException();
                        return j(obtain2);
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                throw new RemoteException("No matching method");
            }
            throw new RemoteException("Server do not provide any method");
        }
        throw new RemoteException("Can not find uri path segment");
    }

    public String f() {
        return this.f;
    }

    public String g() {
        return this.e;
    }

    public boolean h() {
        IBinder iBinder = this.f1336b;
        return iBinder != null && iBinder.isBinderAlive() && this.g.get();
    }

    public synchronized void i() {
        if (this.f1337c == null) {
            this.f1337c = new a();
            try {
                String str = f1335a;
                Log.d(str, "linkToDeath:desc=" + this.e + ",auth=" + this.f + ",rec=" + Integer.toHexString(this.f1337c.hashCode()) + ",obj=" + Integer.toHexString(hashCode()));
                this.f1336b.linkToDeath(this.f1337c, 0);
            } catch (RemoteException unused) {
                this.g.set(false);
                String str2 = f1335a;
                Log.e(str2, "linkToDeath:" + this.f + "'s process has already died");
            }
        }
    }

    public synchronized void k(String str) {
        this.g.set(false);
        if (this.f1337c != null) {
            String str2 = f1335a;
            Log.d(str2, "unLinkToDeath(" + str + "):desc=" + this.e + ",auth= " + this.f + ",rec=" + Integer.toHexString(this.f1337c.hashCode()) + ",obj=" + Integer.toHexString(hashCode()));
            if (!this.f1336b.unlinkToDeath(this.f1337c, 0)) {
                String str3 = f1335a;
                Log.e(str3, "unLinkToDeath(" + str + "):" + this.f + "'s process has already died");
            }
            this.f1337c = null;
        }
    }
}
