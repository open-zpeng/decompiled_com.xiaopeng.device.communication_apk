package com.xiaopeng.lib.apirouter.server;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: IpcRouterService_Stub.java */
/* loaded from: classes.dex */
public class e extends Binder implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    public com.xiaopeng.device.communication.a f2322a = new com.xiaopeng.device.communication.a();

    /* renamed from: b  reason: collision with root package name */
    public d f2323b = new d();

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 0) {
            if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeString("com.xiaopeng.device.communication.IpcRouterService");
            return true;
        }
        parcel.enforceInterface("com.xiaopeng.device.communication.IpcRouterService");
        Uri uri = (Uri) Uri.CREATOR.createFromParcel(parcel);
        try {
            this.f2322a.d(((Integer) TransactTranslator.read(uri.getQueryParameter("id"), "int")).intValue(), (String) TransactTranslator.read(uri.getQueryParameter("bundle"), "java.lang.String"));
            parcel2.writeNoException();
            TransactTranslator.reply(parcel2, null);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            parcel2.writeException(new IllegalStateException(e.getMessage()));
            return true;
        }
    }
}
