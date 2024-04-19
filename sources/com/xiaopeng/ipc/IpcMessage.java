package com.xiaopeng.ipc;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class IpcMessage implements Parcelable {
    public static final Parcelable.Creator<IpcMessage> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    String f2312a;

    /* renamed from: b  reason: collision with root package name */
    int f2313b;

    /* renamed from: c  reason: collision with root package name */
    Bundle f2314c;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<IpcMessage> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public IpcMessage createFromParcel(Parcel parcel) {
            return new IpcMessage(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public IpcMessage[] newArray(int i) {
            return new IpcMessage[i];
        }
    }

    public IpcMessage() {
    }

    public int a() {
        return this.f2313b;
    }

    public String b() {
        return this.f2312a;
    }

    public Bundle c() {
        return this.f2314c;
    }

    public void d(int i) {
        this.f2313b = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void e(String str) {
        this.f2312a = str;
    }

    public void f(Bundle bundle) {
        this.f2314c = bundle;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2312a);
        parcel.writeInt(this.f2313b);
        parcel.writeBundle(this.f2314c);
    }

    protected IpcMessage(Parcel parcel) {
        this.f2312a = parcel.readString();
        this.f2313b = parcel.readInt();
        this.f2314c = parcel.readBundle();
    }
}
