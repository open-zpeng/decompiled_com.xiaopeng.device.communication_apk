package com.xiaopeng.device.communication.account.c;

import android.os.Handler;
import android.os.Message;
import b.d.b.e.i;
import com.xiaopeng.device.communication.account.c.e.a;
import com.xiaopeng.device.communication.account.c.e.e;
import com.xiaopeng.device.communication.account.c.e.f;
import java.util.ArrayList;
import java.util.List;
/* compiled from: AccountModel.java */
/* loaded from: classes.dex */
public class a implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    private Handler f2193a = new Handler(i.g(2), this);

    /* renamed from: b  reason: collision with root package name */
    private List<com.xiaopeng.device.communication.account.c.e.a> f2194b;

    /* compiled from: AccountModel.java */
    /* renamed from: com.xiaopeng.device.communication.account.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class C0091a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2195a;

        static {
            int[] iArr = new int[a.EnumC0093a.values().length];
            f2195a = iArr;
            try {
                iArr[a.EnumC0093a.EXECUTE_RESULT_RESET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2195a[a.EnumC0093a.EXECUTE_RESULT_FAIL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2195a[a.EnumC0093a.EXECUTE_RESULT_RETRY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2195a[a.EnumC0093a.EXECUTE_RESULT_NEXT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2195a[a.EnumC0093a.EXECUTE_RESULT_SUCCESS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public a() {
        ArrayList arrayList = new ArrayList();
        this.f2194b = arrayList;
        arrayList.add(new e());
        this.f2194b.add(new com.xiaopeng.device.communication.account.c.e.c());
        this.f2194b.add(new com.xiaopeng.device.communication.account.c.e.b());
        this.f2194b.add(new com.xiaopeng.device.communication.account.c.e.d());
        this.f2194b.add(new f());
    }

    public void a() {
        if (b.b().c()) {
            b.d.b.e.c.a("AccountModel", "carLogin already started, return!");
            return;
        }
        b.d.b.e.c.a("AccountModel", "###### carLogin start ######");
        b.b().d();
        Handler handler = this.f2193a;
        handler.sendMessage(Message.obtain(handler, 0));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i = message.what;
        if (i >= 0 && i < this.f2194b.size()) {
            com.xiaopeng.device.communication.account.c.e.a aVar = this.f2194b.get(i);
            a.EnumC0093a execute = aVar.execute();
            b.d.b.e.c.a("AccountModel", "Step " + aVar.getClass().getSimpleName() + " execute complete, result:" + execute);
            int i2 = C0091a.f2195a[execute.ordinal()];
            if (i2 == 1) {
                Handler handler = this.f2193a;
                handler.sendMessageDelayed(Message.obtain(handler, 0), 5000L);
            } else if (i2 == 2) {
                b.b().a();
            } else if (i2 == 3) {
                Handler handler2 = this.f2193a;
                handler2.sendMessageDelayed(Message.obtain(handler2, i), 10000L);
            } else if (i2 == 4) {
                Handler handler3 = this.f2193a;
                handler3.sendMessage(Message.obtain(handler3, i + 1));
            } else if (i2 == 5) {
                b.b().e();
            }
            return true;
        }
        throw new IllegalArgumentException("Illegal message.what:" + i);
    }
}
