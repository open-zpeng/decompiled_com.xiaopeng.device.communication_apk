package b.d.b.d;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: IRemoteLogInterface.java */
/* loaded from: classes.dex */
public interface c extends IInterface {

    /* compiled from: IRemoteLogInterface.java */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements c {

        /* compiled from: IRemoteLogInterface.java */
        /* renamed from: b.d.b.d.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0056a implements c {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f1346a;

            C0056a(IBinder iBinder) {
                this.f1346a = iBinder;
            }

            @Override // b.d.b.d.c
            public void S(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.lib.bughunter.IRemoteLogInterface");
                    obtain.writeString(str);
                    this.f1346a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1346a;
            }
        }

        public static c Y(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaopeng.lib.bughunter.IRemoteLogInterface");
            if (queryLocalInterface != null && (queryLocalInterface instanceof c)) {
                return (c) queryLocalInterface;
            }
            return new C0056a(iBinder);
        }
    }

    void S(String str) throws RemoteException;
}
