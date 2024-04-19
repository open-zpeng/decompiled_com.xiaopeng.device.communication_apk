package a.b.c.g;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
/* compiled from: ActionProvider.java */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private final Context f329a;

    /* renamed from: b  reason: collision with root package name */
    private a f330b;

    /* renamed from: c  reason: collision with root package name */
    private InterfaceC0017b f331c;

    /* compiled from: ActionProvider.java */
    /* loaded from: classes.dex */
    public interface a {
    }

    /* compiled from: ActionProvider.java */
    /* renamed from: a.b.c.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0017b {
        void onActionProviderVisibilityChanged(boolean z);
    }

    public b(Context context) {
        this.f329a = context;
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return true;
    }

    public abstract View c();

    public View d(MenuItem menuItem) {
        return c();
    }

    public boolean e() {
        return false;
    }

    public void f(SubMenu subMenu) {
    }

    public boolean g() {
        return false;
    }

    public void h() {
        this.f331c = null;
        this.f330b = null;
    }

    public void i(a aVar) {
        this.f330b = aVar;
    }

    public void j(InterfaceC0017b interfaceC0017b) {
        if (this.f331c != null && interfaceC0017b != null) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f331c = interfaceC0017b;
    }
}
