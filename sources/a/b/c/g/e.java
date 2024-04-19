package a.b.c.g;

import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
/* compiled from: MenuItemCompat.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    static final c f332a;

    /* compiled from: MenuItemCompat.java */
    /* loaded from: classes.dex */
    static class a extends b {
        a() {
        }
    }

    /* compiled from: MenuItemCompat.java */
    /* loaded from: classes.dex */
    static class b implements c {
        b() {
        }
    }

    /* compiled from: MenuItemCompat.java */
    /* loaded from: classes.dex */
    interface c {
    }

    /* compiled from: MenuItemCompat.java */
    @Deprecated
    /* loaded from: classes.dex */
    public interface d {
        boolean c(MenuItem menuItem);

        boolean d(MenuItem menuItem);
    }

    static {
        if (Build.VERSION.SDK_INT >= 26) {
            f332a = new a();
        } else {
            f332a = new b();
        }
    }

    @Deprecated
    public static boolean a(MenuItem menuItem) {
        return menuItem.expandActionView();
    }

    public static MenuItem b(MenuItem menuItem, a.b.c.g.b bVar) {
        if (menuItem instanceof a.b.c.d.a.b) {
            return ((a.b.c.d.a.b) menuItem).b(bVar);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    @Deprecated
    public static MenuItem c(MenuItem menuItem, int i) {
        return menuItem.setActionView(i);
    }

    @Deprecated
    public static MenuItem d(MenuItem menuItem, View view) {
        return menuItem.setActionView(view);
    }

    @Deprecated
    public static void e(MenuItem menuItem, int i) {
        menuItem.setShowAsAction(i);
    }
}
