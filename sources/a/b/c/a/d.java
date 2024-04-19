package a.b.c.a;

import a.b.c.a.e;
import a.b.c.a.g;
import a.b.c.a.i;
import a.b.c.a.j;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;
/* compiled from: NotificationCompat.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    static final k f218a;

    /* compiled from: NotificationCompat.java */
    /* loaded from: classes.dex */
    public static class a extends a.b.c.a.i {

        /* renamed from: a  reason: collision with root package name */
        public static final i.a f219a = new C0008a();

        /* renamed from: b  reason: collision with root package name */
        final Bundle f220b;

        /* renamed from: c  reason: collision with root package name */
        private final a.b.c.a.l[] f221c;

        /* renamed from: d  reason: collision with root package name */
        private final a.b.c.a.l[] f222d;
        private boolean e;
        public int f;
        public CharSequence g;
        public PendingIntent h;

        /* compiled from: NotificationCompat.java */
        /* renamed from: a.b.c.a.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static class C0008a implements i.a {
            C0008a() {
            }
        }

        @Override // a.b.c.a.i
        public PendingIntent a() {
            return this.h;
        }

        @Override // a.b.c.a.i
        public boolean b() {
            return this.e;
        }

        @Override // a.b.c.a.i
        public Bundle d() {
            return this.f220b;
        }

        @Override // a.b.c.a.i
        public int e() {
            return this.f;
        }

        @Override // a.b.c.a.i
        public CharSequence g() {
            return this.g;
        }

        @Override // a.b.c.a.i
        /* renamed from: h */
        public a.b.c.a.l[] c() {
            return this.f222d;
        }

        @Override // a.b.c.a.i
        /* renamed from: i */
        public a.b.c.a.l[] f() {
            return this.f221c;
        }
    }

    /* compiled from: NotificationCompat.java */
    /* loaded from: classes.dex */
    public static class b {
        Bundle A;
        Notification D;
        RemoteViews E;
        RemoteViews F;
        RemoteViews G;
        String H;
        String J;
        long K;
        public Notification M;
        public ArrayList<String> N;

        /* renamed from: a  reason: collision with root package name */
        public Context f223a;

        /* renamed from: b  reason: collision with root package name */
        public CharSequence f224b;

        /* renamed from: c  reason: collision with root package name */
        public CharSequence f225c;

        /* renamed from: d  reason: collision with root package name */
        PendingIntent f226d;
        PendingIntent e;
        RemoteViews f;
        public Bitmap g;
        public CharSequence h;
        public int i;
        int j;
        public boolean l;
        public l m;
        public CharSequence n;
        public CharSequence[] o;
        int p;
        int q;
        boolean r;
        String s;
        boolean t;
        String u;
        boolean x;
        boolean y;
        String z;
        boolean k = true;
        public ArrayList<a> v = new ArrayList<>();
        boolean w = false;
        int B = 0;
        int C = 0;
        int I = 0;
        private int L = 0;

        public b(Context context, String str) {
            Notification notification = new Notification();
            this.M = notification;
            this.f223a = context;
            this.H = str;
            notification.when = System.currentTimeMillis();
            this.M.audioStreamType = -1;
            this.j = 0;
            this.N = new ArrayList<>();
        }

        protected static CharSequence d(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        public Notification b() {
            return d.f218a.a(this, c());
        }

        protected c c() {
            return new c();
        }

        public b e(String str) {
            this.z = str;
            return this;
        }

        public b f(CharSequence charSequence) {
            this.f225c = d(charSequence);
            return this;
        }

        public b g(CharSequence charSequence) {
            this.f224b = d(charSequence);
            return this;
        }

        public b h(int i) {
            this.j = i;
            return this;
        }

        public b i(int i) {
            this.M.icon = i;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: NotificationCompat.java */
    /* loaded from: classes.dex */
    public static class c {
        protected c() {
        }

        public Notification a(b bVar, a.b.c.a.c cVar) {
            if (bVar.m == null) {
                Notification build = cVar.build();
                RemoteViews remoteViews = bVar.E;
                if (remoteViews != null) {
                    build.contentView = remoteViews;
                }
                int i = Build.VERSION.SDK_INT;
                if (i >= 16 && bVar.m != null) {
                    throw null;
                }
                if (i < 21 || bVar.m == null) {
                    return build;
                }
                throw null;
            }
            throw null;
        }
    }

    /* compiled from: NotificationCompat.java */
    /* renamed from: a.b.c.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0009d extends j {
        C0009d() {
        }

        @Override // a.b.c.a.d.j, a.b.c.a.d.k
        public Notification a(b bVar, c cVar) {
            j.a aVar = new j.a(bVar.f223a, bVar.M, bVar.f224b, bVar.f225c, bVar.h, bVar.f, bVar.i, bVar.f226d, bVar.e, bVar.g, bVar.p, bVar.q, bVar.r, bVar.l, bVar.j, bVar.n, bVar.w, bVar.A, bVar.s, bVar.t, bVar.u, bVar.E, bVar.F);
            d.a(aVar, bVar.v);
            if (bVar.m == null) {
                Notification a2 = cVar.a(bVar, aVar);
                if (bVar.m == null || d.b(a2) == null) {
                    return a2;
                }
                throw null;
            }
            throw null;
        }
    }

    /* compiled from: NotificationCompat.java */
    /* loaded from: classes.dex */
    static class e extends C0009d {
        e() {
        }

        @Override // a.b.c.a.d.C0009d, a.b.c.a.d.j, a.b.c.a.d.k
        public Notification a(b bVar, c cVar) {
            a.b.c.a.k kVar = new a.b.c.a.k(bVar.f223a, bVar.M, bVar.f224b, bVar.f225c, bVar.h, bVar.f, bVar.i, bVar.f226d, bVar.e, bVar.g, bVar.p, bVar.q, bVar.r, bVar.k, bVar.l, bVar.j, bVar.n, bVar.w, bVar.N, bVar.A, bVar.s, bVar.t, bVar.u, bVar.E, bVar.F);
            d.a(kVar, bVar.v);
            if (bVar.m == null) {
                return cVar.a(bVar, kVar);
            }
            throw null;
        }
    }

    /* compiled from: NotificationCompat.java */
    /* loaded from: classes.dex */
    static class f extends e {
        f() {
        }

        @Override // a.b.c.a.d.e, a.b.c.a.d.C0009d, a.b.c.a.d.j, a.b.c.a.d.k
        public Notification a(b bVar, c cVar) {
            e.a aVar = new e.a(bVar.f223a, bVar.M, bVar.f224b, bVar.f225c, bVar.h, bVar.f, bVar.i, bVar.f226d, bVar.e, bVar.g, bVar.p, bVar.q, bVar.r, bVar.k, bVar.l, bVar.j, bVar.n, bVar.w, bVar.N, bVar.A, bVar.s, bVar.t, bVar.u, bVar.E, bVar.F, bVar.L);
            d.a(aVar, bVar.v);
            if (bVar.m == null) {
                Notification a2 = cVar.a(bVar, aVar);
                if (bVar.m == null) {
                    return a2;
                }
                d.b(a2);
                throw null;
            }
            throw null;
        }
    }

    /* compiled from: NotificationCompat.java */
    /* loaded from: classes.dex */
    static class g extends f {
        g() {
        }

        @Override // a.b.c.a.d.f, a.b.c.a.d.e, a.b.c.a.d.C0009d, a.b.c.a.d.j, a.b.c.a.d.k
        public Notification a(b bVar, c cVar) {
            a.b.c.a.f fVar = new a.b.c.a.f(bVar.f223a, bVar.M, bVar.f224b, bVar.f225c, bVar.h, bVar.f, bVar.i, bVar.f226d, bVar.e, bVar.g, bVar.p, bVar.q, bVar.r, bVar.k, bVar.l, bVar.j, bVar.n, bVar.w, bVar.z, bVar.N, bVar.A, bVar.B, bVar.C, bVar.D, bVar.s, bVar.t, bVar.u, bVar.E, bVar.F, bVar.G, bVar.L);
            d.a(fVar, bVar.v);
            if (bVar.m == null) {
                Notification a2 = cVar.a(bVar, fVar);
                if (bVar.m == null) {
                    return a2;
                }
                d.b(a2);
                throw null;
            }
            throw null;
        }
    }

    /* compiled from: NotificationCompat.java */
    /* loaded from: classes.dex */
    static class h extends g {
        h() {
        }

        @Override // a.b.c.a.d.g, a.b.c.a.d.f, a.b.c.a.d.e, a.b.c.a.d.C0009d, a.b.c.a.d.j, a.b.c.a.d.k
        public Notification a(b bVar, c cVar) {
            g.a aVar = new g.a(bVar.f223a, bVar.M, bVar.f224b, bVar.f225c, bVar.h, bVar.f, bVar.i, bVar.f226d, bVar.e, bVar.g, bVar.p, bVar.q, bVar.r, bVar.k, bVar.l, bVar.j, bVar.n, bVar.w, bVar.z, bVar.N, bVar.A, bVar.B, bVar.C, bVar.D, bVar.s, bVar.t, bVar.u, bVar.o, bVar.E, bVar.F, bVar.G, bVar.L);
            d.a(aVar, bVar.v);
            if (bVar.m == null) {
                Notification a2 = cVar.a(bVar, aVar);
                if (bVar.m == null) {
                    return a2;
                }
                d.b(a2);
                throw null;
            }
            throw null;
        }
    }

    /* compiled from: NotificationCompat.java */
    /* loaded from: classes.dex */
    static class i extends h {
        i() {
        }

        @Override // a.b.c.a.d.h, a.b.c.a.d.g, a.b.c.a.d.f, a.b.c.a.d.e, a.b.c.a.d.C0009d, a.b.c.a.d.j, a.b.c.a.d.k
        public Notification a(b bVar, c cVar) {
            a.b.c.a.h hVar = new a.b.c.a.h(bVar.f223a, bVar.M, bVar.f224b, bVar.f225c, bVar.h, bVar.f, bVar.i, bVar.f226d, bVar.e, bVar.g, bVar.p, bVar.q, bVar.r, bVar.k, bVar.l, bVar.j, bVar.n, bVar.w, bVar.z, bVar.N, bVar.A, bVar.B, bVar.C, bVar.D, bVar.s, bVar.t, bVar.u, bVar.o, bVar.E, bVar.F, bVar.G, bVar.H, bVar.I, bVar.J, bVar.K, bVar.x, bVar.y, bVar.L);
            d.a(hVar, bVar.v);
            if (bVar.m == null) {
                Notification a2 = cVar.a(bVar, hVar);
                if (bVar.m == null) {
                    return a2;
                }
                d.b(a2);
                throw null;
            }
            throw null;
        }
    }

    /* compiled from: NotificationCompat.java */
    /* loaded from: classes.dex */
    static class j implements k {

        /* compiled from: NotificationCompat.java */
        /* loaded from: classes.dex */
        public static class a implements a.b.c.a.c {

            /* renamed from: a  reason: collision with root package name */
            private Notification.Builder f227a;

            a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z) {
                boolean z2 = true;
                Notification.Builder deleteIntent = new Notification.Builder(context).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent);
                if ((notification.flags & 128) == 0) {
                    z2 = false;
                }
                this.f227a = deleteIntent.setFullScreenIntent(pendingIntent2, z2).setLargeIcon(bitmap).setNumber(i).setProgress(i2, i3, z);
            }

            @Override // a.b.c.a.c
            public Notification build() {
                return this.f227a.getNotification();
            }
        }

        j() {
        }

        @Override // a.b.c.a.d.k
        public Notification a(b bVar, c cVar) {
            return cVar.a(bVar, new a(bVar.f223a, bVar.M, bVar.f224b, bVar.f225c, bVar.h, bVar.f, bVar.i, bVar.f226d, bVar.e, bVar.g, bVar.p, bVar.q, bVar.r));
        }
    }

    /* compiled from: NotificationCompat.java */
    /* loaded from: classes.dex */
    interface k {
        Notification a(b bVar, c cVar);
    }

    /* compiled from: NotificationCompat.java */
    /* loaded from: classes.dex */
    public static abstract class l {
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            f218a = new i();
        } else if (i2 >= 24) {
            f218a = new h();
        } else if (i2 >= 21) {
            f218a = new g();
        } else if (i2 >= 20) {
            f218a = new f();
        } else if (i2 >= 19) {
            f218a = new e();
        } else if (i2 >= 16) {
            f218a = new C0009d();
        } else {
            f218a = new j();
        }
    }

    static void a(a.b.c.a.b bVar, ArrayList<a> arrayList) {
        Iterator<a> it = arrayList.iterator();
        while (it.hasNext()) {
            bVar.a(it.next());
        }
    }

    public static Bundle b(Notification notification) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 19) {
            return notification.extras;
        }
        if (i2 >= 16) {
            return a.b.c.a.j.b(notification);
        }
        return null;
    }
}
