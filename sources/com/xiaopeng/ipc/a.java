package com.xiaopeng.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: IPC.java */
/* loaded from: classes.dex */
public interface a extends IInterface {

    /* compiled from: IPC.java */
    /* renamed from: com.xiaopeng.ipc.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC0104a extends Binder implements a {

        /* compiled from: IPC.java */
        /* renamed from: com.xiaopeng.ipc.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0105a implements a {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f2315a;

            C0105a(IBinder iBinder) {
                this.f2315a = iBinder;
            }

            @Override // com.xiaopeng.ipc.a
            public void J(String str, IpcMessage ipcMessage) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.ipc.IPC");
                    obtain.writeString(str);
                    if (ipcMessage != null) {
                        obtain.writeInt(1);
                        ipcMessage.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2315a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.xiaopeng.ipc.a
            public void K(String str, b bVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.ipc.IPC");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.f2315a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f2315a;
            }

            @Override // com.xiaopeng.ipc.a
            public void m(String str, b bVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.ipc.IPC");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.f2315a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static a Y(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaopeng.ipc.IPC");
            if (queryLocalInterface != null && (queryLocalInterface instanceof a)) {
                return (a) queryLocalInterface;
            }
            return new C0105a(iBinder);
        }
    }

    void J(String str, IpcMessage ipcMessage) throws RemoteException;

    void K(String str, b bVar) throws RemoteException;

    void m(String str, b bVar) throws RemoteException;
}
