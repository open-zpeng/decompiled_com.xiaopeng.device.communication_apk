package a.b.c.a;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
/* compiled from: NotificationCompatJellybean.java */
/* loaded from: classes.dex */
class j {

    /* renamed from: b  reason: collision with root package name */
    private static Field f240b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f241c;

    /* renamed from: a  reason: collision with root package name */
    private static final Object f239a = new Object();

    /* renamed from: d  reason: collision with root package name */
    private static final Object f242d = new Object();

    /* compiled from: NotificationCompatJellybean.java */
    /* loaded from: classes.dex */
    public static class a implements c, b {

        /* renamed from: a  reason: collision with root package name */
        private Notification.Builder f243a;

        /* renamed from: b  reason: collision with root package name */
        private final Bundle f244b;

        /* renamed from: c  reason: collision with root package name */
        private List<Bundle> f245c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        private RemoteViews f246d;
        private RemoteViews e;

        public a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, int i4, CharSequence charSequence4, boolean z3, Bundle bundle, String str, boolean z4, String str2, RemoteViews remoteViews2, RemoteViews remoteViews3) {
            PendingIntent pendingIntent3;
            boolean z5 = false;
            Notification.Builder deleteIntent = new Notification.Builder(context).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent);
            if ((notification.flags & 128) != 0) {
                pendingIntent3 = pendingIntent2;
                z5 = true;
            } else {
                pendingIntent3 = pendingIntent2;
            }
            this.f243a = deleteIntent.setFullScreenIntent(pendingIntent3, z5).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z2).setPriority(i4).setProgress(i2, i3, z);
            Bundle bundle2 = new Bundle();
            this.f244b = bundle2;
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            if (z3) {
                bundle2.putBoolean("android.support.localOnly", true);
            }
            if (str != null) {
                bundle2.putString("android.support.groupKey", str);
                if (z4) {
                    bundle2.putBoolean("android.support.isGroupSummary", true);
                } else {
                    bundle2.putBoolean("android.support.useSideChannel", true);
                }
            }
            if (str2 != null) {
                bundle2.putString("android.support.sortKey", str2);
            }
            this.f246d = remoteViews2;
            this.e = remoteViews3;
        }

        @Override // a.b.c.a.b
        public void a(i iVar) {
            this.f245c.add(j.c(this.f243a, iVar));
        }

        @Override // a.b.c.a.c
        public Notification build() {
            Notification build = this.f243a.build();
            Bundle b2 = j.b(build);
            Bundle bundle = new Bundle(this.f244b);
            for (String str : this.f244b.keySet()) {
                if (b2.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            b2.putAll(bundle);
            SparseArray<Bundle> a2 = j.a(this.f245c);
            if (a2 != null) {
                j.b(build).putSparseParcelableArray("android.support.actionExtras", a2);
            }
            RemoteViews remoteViews = this.f246d;
            if (remoteViews != null) {
                build.contentView = remoteViews;
            }
            RemoteViews remoteViews2 = this.e;
            if (remoteViews2 != null) {
                build.bigContentView = remoteViews2;
            }
            return build;
        }
    }

    public static SparseArray<Bundle> a(List<Bundle> list) {
        int size = list.size();
        SparseArray<Bundle> sparseArray = null;
        for (int i = 0; i < size; i++) {
            Bundle bundle = list.get(i);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                sparseArray.put(i, bundle);
            }
        }
        return sparseArray;
    }

    public static Bundle b(Notification notification) {
        synchronized (f239a) {
            if (f241c) {
                return null;
            }
            try {
                if (f240b == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        f241c = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    f240b = declaredField;
                }
                Bundle bundle = (Bundle) f240b.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    f240b.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException e) {
                Log.e("NotificationCompat", "Unable to access notification extras", e);
                f241c = true;
                return null;
            } catch (NoSuchFieldException e2) {
                Log.e("NotificationCompat", "Unable to access notification extras", e2);
                f241c = true;
                return null;
            }
        }
    }

    public static Bundle c(Notification.Builder builder, i iVar) {
        builder.addAction(iVar.e(), iVar.g(), iVar.a());
        Bundle bundle = new Bundle(iVar.d());
        if (iVar.f() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", o.b(iVar.f()));
        }
        if (iVar.c() != null) {
            bundle.putParcelableArray("android.support.dataRemoteInputs", o.b(iVar.c()));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", iVar.b());
        return bundle;
    }
}
