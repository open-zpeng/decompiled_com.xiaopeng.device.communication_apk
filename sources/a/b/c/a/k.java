package a.b.c.a;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.List;
/* compiled from: NotificationCompatKitKat.java */
/* loaded from: classes.dex */
public class k implements c, b {

    /* renamed from: a  reason: collision with root package name */
    private Notification.Builder f247a;

    /* renamed from: b  reason: collision with root package name */
    private Bundle f248b;

    /* renamed from: c  reason: collision with root package name */
    private List<Bundle> f249c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private RemoteViews f250d;
    private RemoteViews e;

    public k(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, ArrayList<String> arrayList, Bundle bundle, String str, boolean z5, String str2, RemoteViews remoteViews2, RemoteViews remoteViews3) {
        PendingIntent pendingIntent3;
        boolean z6 = false;
        Notification.Builder deleteIntent = new Notification.Builder(context).setWhen(notification.when).setShowWhen(z2).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent);
        if ((notification.flags & 128) != 0) {
            pendingIntent3 = pendingIntent2;
            z6 = true;
        } else {
            pendingIntent3 = pendingIntent2;
        }
        this.f247a = deleteIntent.setFullScreenIntent(pendingIntent3, z6).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z);
        Bundle bundle2 = new Bundle();
        this.f248b = bundle2;
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            this.f248b.putStringArray("android.people", (String[]) arrayList.toArray(new String[arrayList.size()]));
        }
        if (z4) {
            this.f248b.putBoolean("android.support.localOnly", true);
        }
        if (str != null) {
            this.f248b.putString("android.support.groupKey", str);
            if (z5) {
                this.f248b.putBoolean("android.support.isGroupSummary", true);
            } else {
                this.f248b.putBoolean("android.support.useSideChannel", true);
            }
        }
        if (str2 != null) {
            this.f248b.putString("android.support.sortKey", str2);
        }
        this.f250d = remoteViews2;
        this.e = remoteViews3;
    }

    @Override // a.b.c.a.b
    public void a(i iVar) {
        this.f249c.add(j.c(this.f247a, iVar));
    }

    @Override // a.b.c.a.c
    public Notification build() {
        SparseArray<Bundle> a2 = j.a(this.f249c);
        if (a2 != null) {
            this.f248b.putSparseParcelableArray("android.support.actionExtras", a2);
        }
        this.f247a.setExtras(this.f248b);
        Notification build = this.f247a.build();
        RemoteViews remoteViews = this.f250d;
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
