package b.d.b.c;

import android.content.ContentProviderClient;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.xiaopeng.lib.apirouter.server.ApiPublisherProvider;
import java.util.List;
/* compiled from: ApiRouter.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static a f1331a = new a();

    private static d a(e eVar, IBinder iBinder, String str) {
        d e = d.e(iBinder, str);
        f1331a.c(eVar, e);
        return e;
    }

    public static <T> T b(Uri uri) throws RemoteException {
        return (T) c(uri, false, null);
    }

    private static <T> T c(Uri uri, boolean z, byte[] bArr) throws RemoteException {
        e d2 = d(uri);
        d b2 = f1331a.b(d2);
        if (b2 == null) {
            b2 = e(d2);
        } else if (!b2.h()) {
            f1331a.f(d2);
            b2 = e(d2);
        }
        return (T) b2.d(uri, z, bArr);
    }

    private static e d(Uri uri) throws RemoteException {
        String authority = uri.getAuthority();
        if (!TextUtils.isEmpty(authority)) {
            int lastIndexOf = authority.lastIndexOf(".");
            if (lastIndexOf != -1) {
                String substring = authority.substring(0, lastIndexOf);
                String substring2 = authority.substring(lastIndexOf + 1);
                e eVar = new e();
                eVar.f1340a = substring;
                eVar.f1341b = substring2;
                List<String> pathSegments = uri.getPathSegments();
                if (pathSegments != null && pathSegments.size() > 1) {
                    eVar.f1342c = pathSegments.get(1);
                }
                return eVar;
            }
            throw new RemoteException("Illegal uri authority");
        }
        throw new RemoteException("Can not find authority in uri");
    }

    private static d e(e eVar) throws RemoteException {
        if (ApiPublisherProvider.f2317a != null) {
            Uri.Builder builder = new Uri.Builder();
            if (TextUtils.isEmpty(eVar.f1342c)) {
                Uri.Builder scheme = builder.scheme("content");
                scheme.authority(eVar.f1340a + ".api.publisher");
            } else {
                Uri.Builder scheme2 = builder.scheme("content");
                scheme2.authority(eVar.f1340a + "." + eVar.f1342c + ".api.publisher");
            }
            ContentProviderClient acquireContentProviderClient = ApiPublisherProvider.f2317a.getContentResolver().acquireContentProviderClient(builder.build());
            if (acquireContentProviderClient != null) {
                try {
                    Bundle call = acquireContentProviderClient.call(eVar.f1341b, null, null);
                    if (call != null) {
                        IBinder binder = call.getBinder("binder");
                        String string = call.getString("manifest");
                        if (binder != null && !TextUtils.isEmpty(string)) {
                            return a(eVar, binder, string);
                        }
                        throw new RemoteException("No matching method");
                    }
                    throw new RemoteException("Server does not implement call");
                } finally {
                    acquireContentProviderClient.release();
                }
            }
            throw new RemoteException("Unknown service " + eVar);
        }
        throw new RemoteException("ApiRouter can not route. If it is an asynchronous thread, please check your Context first!");
    }
}
