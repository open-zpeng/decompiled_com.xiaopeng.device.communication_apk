package a.b.c.a;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;
/* compiled from: NotificationCompatApi26.java */
/* loaded from: classes.dex */
public class h implements c, b {

    /* renamed from: a  reason: collision with root package name */
    private Notification.Builder f238a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, String str, ArrayList<String> arrayList, Bundle bundle, int i5, int i6, Notification notification2, String str2, boolean z5, String str3, CharSequence[] charSequenceArr, RemoteViews remoteViews2, RemoteViews remoteViews3, RemoteViews remoteViews4, String str4, int i7, String str5, long j, boolean z6, boolean z7, int i8) {
        PendingIntent pendingIntent3;
        boolean z8 = true;
        Notification.Builder deleteIntent = new Notification.Builder(context, str4).setWhen(notification.when).setShowWhen(z2).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent);
        if ((notification.flags & 128) != 0) {
            pendingIntent3 = pendingIntent2;
        } else {
            pendingIntent3 = pendingIntent2;
            z8 = false;
        }
        Notification.Builder groupAlertBehavior = deleteIntent.setFullScreenIntent(pendingIntent3, z8).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z).setLocalOnly(z4).setExtras(bundle).setGroup(str2).setGroupSummary(z5).setSortKey(str3).setCategory(str).setColor(i5).setVisibility(i6).setPublicVersion(notification2).setRemoteInputHistory(charSequenceArr).setChannelId(str4).setBadgeIconType(i7).setShortcutId(str5).setTimeoutAfter(j).setGroupAlertBehavior(i8);
        this.f238a = groupAlertBehavior;
        if (z7) {
            groupAlertBehavior.setColorized(z6);
        }
        if (remoteViews2 != null) {
            this.f238a.setCustomContentView(remoteViews2);
        }
        if (remoteViews3 != null) {
            this.f238a.setCustomBigContentView(remoteViews3);
        }
        if (remoteViews4 != null) {
            this.f238a.setCustomHeadsUpContentView(remoteViews4);
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            this.f238a.addPerson(it.next());
        }
    }

    @Override // a.b.c.a.b
    public void a(i iVar) {
        g.a(this.f238a, iVar);
    }

    @Override // a.b.c.a.c
    public Notification build() {
        return this.f238a.build();
    }
}
