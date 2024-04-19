package a.b.c.a;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.RemoteViews;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IInputController;
import java.util.ArrayList;
/* compiled from: NotificationCompatApi20.java */
/* loaded from: classes.dex */
class e {

    /* compiled from: NotificationCompatApi20.java */
    /* loaded from: classes.dex */
    public static class a implements c, b {

        /* renamed from: a  reason: collision with root package name */
        private Notification.Builder f228a;

        /* renamed from: b  reason: collision with root package name */
        private Bundle f229b;

        /* renamed from: c  reason: collision with root package name */
        private RemoteViews f230c;

        /* renamed from: d  reason: collision with root package name */
        private RemoteViews f231d;
        private int e;

        public a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, ArrayList<String> arrayList, Bundle bundle, String str, boolean z5, String str2, RemoteViews remoteViews2, RemoteViews remoteViews3, int i5) {
            PendingIntent pendingIntent3;
            boolean z6 = true;
            Notification.Builder deleteIntent = new Notification.Builder(context).setWhen(notification.when).setShowWhen(z2).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent);
            if ((notification.flags & 128) != 0) {
                pendingIntent3 = pendingIntent2;
            } else {
                pendingIntent3 = pendingIntent2;
                z6 = false;
            }
            this.f228a = deleteIntent.setFullScreenIntent(pendingIntent3, z6).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z).setLocalOnly(z4).setGroup(str).setGroupSummary(z5).setSortKey(str2);
            Bundle bundle2 = new Bundle();
            this.f229b = bundle2;
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            if (arrayList != null && !arrayList.isEmpty()) {
                this.f229b.putStringArray("android.people", (String[]) arrayList.toArray(new String[arrayList.size()]));
            }
            this.f230c = remoteViews2;
            this.f231d = remoteViews3;
            this.e = i5;
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
            e.a(this.f228a, iVar);
        }

        @Override // a.b.c.a.c
        public Notification build() {
            this.f228a.setExtras(this.f229b);
            Notification build = this.f228a.build();
            RemoteViews remoteViews = this.f230c;
            if (remoteViews != null) {
                build.contentView = remoteViews;
            }
            RemoteViews remoteViews2 = this.f231d;
            if (remoteViews2 != null) {
                build.bigContentView = remoteViews2;
            }
            if (this.e != 0) {
                if (build.getGroup() != null && (build.flags & IInputController.KEYCODE_BACK_BUTTON) != 0 && this.e == 2) {
                    b(build);
                }
                if (build.getGroup() != null && (build.flags & IInputController.KEYCODE_BACK_BUTTON) == 0 && this.e == 1) {
                    b(build);
                }
            }
            return build;
        }
    }

    public static void a(Notification.Builder builder, i iVar) {
        Bundle bundle;
        Notification.Action.Builder builder2 = new Notification.Action.Builder(iVar.e(), iVar.g(), iVar.a());
        if (iVar.f() != null) {
            for (RemoteInput remoteInput : m.a(iVar.f())) {
                builder2.addRemoteInput(remoteInput);
            }
        }
        if (iVar.d() != null) {
            bundle = new Bundle(iVar.d());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", iVar.b());
        builder2.addExtras(bundle);
        builder.addAction(builder2.build());
    }
}
