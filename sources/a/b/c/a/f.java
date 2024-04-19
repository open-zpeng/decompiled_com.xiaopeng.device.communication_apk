package a.b.c.a;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.RemoteViews;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IInputController;
import java.util.ArrayList;
import java.util.Iterator;
/* compiled from: NotificationCompatApi21.java */
/* loaded from: classes.dex */
public class f implements c, b {

    /* renamed from: a  reason: collision with root package name */
    private Notification.Builder f232a;

    /* renamed from: b  reason: collision with root package name */
    private Bundle f233b;

    /* renamed from: c  reason: collision with root package name */
    private RemoteViews f234c;

    /* renamed from: d  reason: collision with root package name */
    private RemoteViews f235d;
    private RemoteViews e;
    private int f;

    public f(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, String str, ArrayList<String> arrayList, Bundle bundle, int i5, int i6, Notification notification2, String str2, boolean z5, String str3, RemoteViews remoteViews2, RemoteViews remoteViews3, RemoteViews remoteViews4, int i7) {
        PendingIntent pendingIntent3;
        boolean z6 = true;
        Notification.Builder deleteIntent = new Notification.Builder(context).setWhen(notification.when).setShowWhen(z2).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent);
        if ((notification.flags & 128) != 0) {
            pendingIntent3 = pendingIntent2;
        } else {
            pendingIntent3 = pendingIntent2;
            z6 = false;
        }
        this.f232a = deleteIntent.setFullScreenIntent(pendingIntent3, z6).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z).setLocalOnly(z4).setGroup(str2).setGroupSummary(z5).setSortKey(str3).setCategory(str).setColor(i5).setVisibility(i6).setPublicVersion(notification2);
        Bundle bundle2 = new Bundle();
        this.f233b = bundle2;
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            this.f232a.addPerson(it.next());
        }
        this.f234c = remoteViews2;
        this.f235d = remoteViews3;
        this.e = remoteViews4;
        this.f = i7;
    }

    private void b(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        int i = notification.defaults & (-2);
        notification.defaults = i;
        notification.defaults = i & (-3);
    }

    @Override // a.b.c.a.b
    public void a(i iVar) {
        e.a(this.f232a, iVar);
    }

    @Override // a.b.c.a.c
    public Notification build() {
        this.f232a.setExtras(this.f233b);
        Notification build = this.f232a.build();
        RemoteViews remoteViews = this.f234c;
        if (remoteViews != null) {
            build.contentView = remoteViews;
        }
        RemoteViews remoteViews2 = this.f235d;
        if (remoteViews2 != null) {
            build.bigContentView = remoteViews2;
        }
        RemoteViews remoteViews3 = this.e;
        if (remoteViews3 != null) {
            build.headsUpContentView = remoteViews3;
        }
        if (this.f != 0) {
            if (build.getGroup() != null && (build.flags & IInputController.KEYCODE_BACK_BUTTON) != 0 && this.f == 2) {
                b(build);
            }
            if (build.getGroup() != null && (build.flags & IInputController.KEYCODE_BACK_BUTTON) == 0 && this.f == 1) {
                b(build);
            }
        }
        return build;
    }
}
