package b.d.b.d;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;
/* compiled from: IDataUploadInterface.java */
/* loaded from: classes.dex */
public interface b extends IInterface {

    /* compiled from: IDataUploadInterface.java */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements b {

        /* compiled from: IDataUploadInterface.java */
        /* renamed from: b.d.b.d.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0055a implements b {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f1345a;

            C0055a(IBinder iBinder) {
                this.f1345a = iBinder;
            }

            @Override // b.d.b.d.b
            public void P(List<String> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.lib.bughunter.IDataUploadInterface");
                    obtain.writeStringList(list);
                    this.f1345a.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // b.d.b.d.b
            public void R(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.lib.bughunter.IDataUploadInterface");
                    obtain.writeString(str);
                    this.f1345a.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1345a;
            }

            @Override // b.d.b.d.b
            public void f(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.lib.bughunter.IDataUploadInterface");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f1345a.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // b.d.b.d.b
            public void h(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.lib.bughunter.IDataUploadInterface");
                    obtain.writeString(str);
                    this.f1345a.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // b.d.b.d.b
            public void k(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.lib.bughunter.IDataUploadInterface");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f1345a.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // b.d.b.d.b
            public void s(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.lib.bughunter.IDataUploadInterface");
                    obtain.writeString(str);
                    this.f1345a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static b Y(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaopeng.lib.bughunter.IDataUploadInterface");
            if (queryLocalInterface != null && (queryLocalInterface instanceof b)) {
                return (b) queryLocalInterface;
            }
            return new C0055a(iBinder);
        }
    }

    void P(List<String> list) throws RemoteException;

    void R(String str) throws RemoteException;

    void f(String str, String str2) throws RemoteException;

    void h(String str) throws RemoteException;

    void k(String str, String str2) throws RemoteException;

    void s(String str) throws RemoteException;
}
