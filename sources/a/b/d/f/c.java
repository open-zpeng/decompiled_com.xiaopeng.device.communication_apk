package a.b.d.f;

import a.b.d.a.i;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.view.LayoutInflater;
/* compiled from: ContextThemeWrapper.java */
/* loaded from: classes.dex */
public class c extends ContextWrapper {

    /* renamed from: a  reason: collision with root package name */
    private int f407a;

    /* renamed from: b  reason: collision with root package name */
    private Resources.Theme f408b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f409c;

    public c(Context context, int i) {
        super(context);
        this.f407a = i;
    }

    private void a() {
        boolean z = this.f408b == null;
        if (z) {
            this.f408b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f408b.setTo(theme);
            }
        }
        b(this.f408b, this.f407a, z);
    }

    protected void b(Resources.Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            if (this.f409c == null) {
                this.f409c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
            }
            return this.f409c;
        }
        return getBaseContext().getSystemService(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f408b;
        if (theme != null) {
            return theme;
        }
        if (this.f407a == 0) {
            this.f407a = i.f395a;
        }
        a();
        return this.f408b;
    }

    public int getThemeResId() {
        return this.f407a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        if (this.f407a != i) {
            this.f407a = i;
            a();
        }
    }

    public c(Context context, Resources.Theme theme) {
        super(context);
        this.f408b = theme;
    }
}
