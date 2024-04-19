package b.d.b.d;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.UserHandle;
import b.d.b.d.c;
import com.xiaopeng.libconfig.ipc.IpcConfig;
/* compiled from: RemoteLogHelp.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static volatile e f1347a;

    /* renamed from: b  reason: collision with root package name */
    private c f1348b;

    /* renamed from: c  reason: collision with root package name */
    private Context f1349c;

    /* renamed from: d  reason: collision with root package name */
    private ServiceConnection f1350d = new a();

    /* compiled from: RemoteLogHelp.java */
    /* loaded from: classes.dex */
    class a implements ServiceConnection {

        /* compiled from: RemoteLogHelp.java */
        /* renamed from: b.d.b.d.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0057a implements IBinder.DeathRecipient {
            C0057a() {
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                if (e.this.f1348b == null) {
                    return;
                }
                e.this.f1348b.asBinder().unlinkToDeath(this, 0);
                e.this.f1348b = null;
                e eVar = e.this;
                eVar.e(eVar.f1349c);
            }
        }

        a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            e.this.f1348b = c.a.Y(iBinder);
            C0057a c0057a = new C0057a();
            try {
                if (e.this.f1348b == null) {
                    return;
                }
                e.this.f1348b.asBinder().linkToDeath(c0057a, 0);
            } catch (RemoteException e) {
                b.d.b.e.c.u("RemoteLogHelp", "RemoteException occurs when reLink to Service, exception:", e);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            e.this.f1348b = null;
        }
    }

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Context context) {
        Intent intent = new Intent();
        intent.setPackage(IpcConfig.App.DATA_COLLECTOR);
        intent.setAction("com.xiaopeng.service.DATA_SERVICE");
        if (19 <= Build.VERSION.SDK_INT) {
            context.startService(intent);
            context.bindService(intent, this.f1350d, 1);
            return;
        }
        context.startServiceAsUser(intent, UserHandle.CURRENT);
        context.bindServiceAsUser(intent, this.f1350d, 1, UserHandle.CURRENT);
    }

    public static e f() {
        if (f1347a == null) {
            synchronized (e.class) {
                if (f1347a == null) {
                    f1347a = new e();
                }
            }
        }
        return f1347a;
    }

    public void g(Context context) {
        this.f1349c = context.getApplicationContext();
        e(context);
    }

    public boolean h() {
        return this.f1348b != null;
    }

    public void i(String str) {
        c cVar = this.f1348b;
        if (cVar != null) {
            try {
                cVar.S(str);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
