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
import java.util.Iterator;
/* compiled from: NotificationCompatApi24.java */
/* loaded from: classes.dex */
class g {

    /* compiled from: NotificationCompatApi24.java */
    /* loaded from: classes.dex */
    public static class a implements c, b {

        /* renamed from: a  reason: collision with root package name */
        private Notification.Builder f236a;

        /* renamed from: b  reason: collision with root package name */
        private int f237b;

        public a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, String str, ArrayList<String> arrayList, Bundle bundle, int i5, int i6, Notification notification2, String str2, boolean z5, String str3, CharSequence[] charSequenceArr, RemoteViews remoteViews2, RemoteViews remoteViews3, RemoteViews remoteViews4, int i7) {
            PendingIntent pendingIntent3;
            boolean z6 = true;
            Notification.Builder deleteIntent = new Notification.Builder(context).setWhen(notification.when).setShowWhen(z2).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent);
            if ((notification.flags & 128) != 0) {
                pendingIntent3 = pendingIntent2;
            } else {
                pendingIntent3 = pendingIntent2;
                z6 = false;
            }
            Notification.Builder remoteInputHistory = deleteIntent.setFullScreenIntent(pendingIntent3, z6).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z).setLocalOnly(z4).setExtras(bundle).setGroup(str2).setGroupSummary(z5).setSortKey(str3).setCategory(str).setColor(i5).setVisibility(i6).setPublicVersion(notification2).setRemoteInputHistory(charSequenceArr);
            this.f236a = remoteInputHistory;
            if (remoteViews2 != null) {
                remoteInputHistory.setCustomContentView(remoteViews2);
            }
            if (remoteViews3 != null) {
                this.f236a.setCustomBigContentView(remoteViews3);
            }
            if (remoteViews4 != null) {
                this.f236a.setCustomHeadsUpContentView(remoteViews4);
            }
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                this.f236a.addPerson(it.next());
            }
            this.f237b = i7;
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
            g.a(this.f236a, iVar);
        }

        @Override // a.b.c.a.c
        public Notification build() {
            Notification build = this.f236a.build();
            if (this.f237b != 0) {
                if (build.getGroup() != null && (build.flags & IInputController.KEYCODE_BACK_BUTTON) != 0 && this.f237b == 2) {
                    b(build);
                }
                if (build.getGroup() != null && (build.flags & IInputController.KEYCODE_BACK_BUTTON) == 0 && this.f237b == 1) {
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
        builder2.setAllowGeneratedReplies(iVar.b());
        builder2.addExtras(bundle);
        builder.addAction(builder2.build());
    }
}
