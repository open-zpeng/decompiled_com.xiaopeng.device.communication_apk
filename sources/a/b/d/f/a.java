package a.b.d.f;

import a.b.c.g.l;
import a.b.d.a.f;
import a.b.d.a.j;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.view.ViewConfiguration;
/* compiled from: ActionBarPolicy.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private Context f406a;

    private a(Context context) {
        this.f406a = context;
    }

    public static a a(Context context) {
        return new a(context);
    }

    public int b() {
        return this.f406a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public int c() {
        return this.f406a.getResources().getInteger(f.f389a);
    }

    public int d() {
        return this.f406a.getResources().getDimensionPixelSize(a.b.d.a.c.f378b);
    }

    public int e() {
        TypedArray obtainStyledAttributes = this.f406a.obtainStyledAttributes(null, j.f396a, a.b.d.a.a.f371c, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(j.i, 0);
        Resources resources = this.f406a.getResources();
        if (!f()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(a.b.d.a.c.f377a));
        }
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public boolean f() {
        if (this.f406a.getApplicationInfo().targetSdkVersion >= 16) {
            return this.f406a.getResources().getBoolean(a.b.d.a.b.f373a);
        }
        return this.f406a.getResources().getBoolean(a.b.d.a.b.f374b);
    }

    public boolean g() {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return !l.b(ViewConfiguration.get(this.f406a));
    }
}
