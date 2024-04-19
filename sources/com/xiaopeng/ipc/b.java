package com.xiaopeng.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: IPCCallback.java */
/* loaded from: classes.dex */
public interface b extends IInterface {

    /* compiled from: IPCCallback.java */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements b {
        private static final String DESCRIPTOR = "com.xiaopeng.ipc.IPCCallback";
        static final int TRANSACTION_onReceive = 1;

        /* compiled from: IPCCallback.java */
        /* renamed from: com.xiaopeng.ipc.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0106a implements b {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f2316a;

            C0106a(IBinder iBinder) {
                this.f2316a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f2316a;
            }
        }

        public a() {
            attachInterface(this, DESCRIPTOR);
        }

        public static b asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof b)) {
                return (b) queryLocalInterface;
            }
            return new C0106a(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            onReceive(parcel.readInt() != 0 ? IpcMessage.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }
    }

    void onReceive(IpcMessage ipcMessage) throws RemoteException;
}
