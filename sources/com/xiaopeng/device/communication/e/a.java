package com.xiaopeng.device.communication.e;

import android.content.Context;
import b.d.b.e.c;
import com.xiaopeng.device.communication.App;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.messaging.IMessaging;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.messaging.MessagingException;
import com.xiaopeng.lib.framework.netchannelmodule.NetworkChannelsEntry;
/* compiled from: MessagingChannel.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private Context f2260a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MessagingChannel.java */
    /* renamed from: com.xiaopeng.device.communication.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0098a implements Runnable {
        RunnableC0098a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ((IMessaging) Module.get(NetworkChannelsEntry.class).get(IMessaging.class)).initChannelWithContext(IMessaging.CHANNEL.COMMUNICATION, App.c());
            } catch (MessagingException e) {
                c.a("MessagingChannel", "Failed to initialize communication channel. Exception:" + e);
            } catch (Exception e2) {
                c.a("MessagingChannel", "Failed to initialize communication channel. Exception:" + e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MessagingChannel.java */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private static final a f2262a = new a(null);
    }

    /* synthetic */ a(RunnableC0098a runnableC0098a) {
        this();
    }

    public static a a() {
        return b.f2262a;
    }

    private void c() {
        new Thread(new RunnableC0098a()).start();
    }

    public void b(Context context) {
        if (this.f2260a == null) {
            this.f2260a = context;
            c();
        }
    }

    public boolean d() {
        if (this.f2260a == null) {
            return false;
        }
        return ((IMessaging) Module.get(NetworkChannelsEntry.class).get(IMessaging.class)).available();
    }

    public void e(String str, String str2) {
        if (this.f2260a == null) {
            return;
        }
        IMessaging iMessaging = (IMessaging) Module.get(NetworkChannelsEntry.class).get(IMessaging.class);
        if (!iMessaging.available()) {
            c.t("MessagingChannel", "messaging available is false!");
            return;
        }
        try {
            iMessaging.publish(str, str2);
        } catch (MessagingException e) {
            if (e.getReasonCode() != 32) {
                if (e.getReasonCode() == 17) {
                    throw new RuntimeException("Make sure the init() was called already.");
                }
                return;
            }
            throw new RuntimeException("Not allowed publish, check the assigned channel.");
        } catch (Exception unused) {
            throw new RuntimeException("Initialize the channel first!");
        }
    }

    public void f() {
        c();
    }

    public boolean g(String str) {
        if (this.f2260a == null) {
            return false;
        }
        IMessaging iMessaging = (IMessaging) Module.get(NetworkChannelsEntry.class).get(IMessaging.class);
        if (iMessaging.available()) {
            try {
                iMessaging.subscribe(str);
                return true;
            } catch (MessagingException e) {
                if (e.getReasonCode() != 33) {
                    if (e.getReasonCode() != 17) {
                        return false;
                    }
                    throw new RuntimeException("Make sure the init() was called already.");
                }
                throw new RuntimeException("Not allowed subscribe, check the assigned channel.");
            } catch (Exception unused) {
                throw new RuntimeException("Initialize the channel first!");
            }
        }
        return false;
    }

    private a() {
    }
}
