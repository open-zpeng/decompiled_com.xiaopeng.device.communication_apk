package a.b.c.g.q;

import android.graphics.Rect;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IInputController;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IRadioController;
/* compiled from: AccessibilityNodeInfoCompat.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    static final i f352a;

    /* renamed from: b  reason: collision with root package name */
    private final AccessibilityNodeInfo f353b;

    /* renamed from: c  reason: collision with root package name */
    public int f354c = -1;

    /* compiled from: AccessibilityNodeInfoCompat.java */
    /* loaded from: classes.dex */
    static class a extends i {
        a() {
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat.java */
    /* renamed from: a.b.c.g.q.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0019b extends a {
        C0019b() {
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat.java */
    /* loaded from: classes.dex */
    static class c extends C0019b {
        c() {
        }

        @Override // a.b.c.g.q.b.i
        public String a(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getViewIdResourceName();
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat.java */
    /* loaded from: classes.dex */
    static class d extends c {
        d() {
        }

        @Override // a.b.c.g.q.b.i
        public Object b(int i, int i2, boolean z, int i3) {
            return AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z);
        }

        @Override // a.b.c.g.q.b.i
        public Object c(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z);
        }

        @Override // a.b.c.g.q.b.i
        public void d(AccessibilityNodeInfo accessibilityNodeInfo, Object obj) {
            accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) obj);
        }

        @Override // a.b.c.g.q.b.i
        public void e(AccessibilityNodeInfo accessibilityNodeInfo, Object obj) {
            accessibilityNodeInfo.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) obj);
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat.java */
    /* loaded from: classes.dex */
    static class e extends d {
        e() {
        }

        @Override // a.b.c.g.q.b.d, a.b.c.g.q.b.i
        public Object b(int i, int i2, boolean z, int i3) {
            return AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z, i3);
        }

        @Override // a.b.c.g.q.b.d, a.b.c.g.q.b.i
        public Object c(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z, z2);
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat.java */
    /* loaded from: classes.dex */
    static class f extends e {
        f() {
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat.java */
    /* loaded from: classes.dex */
    static class g extends f {
        g() {
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat.java */
    /* loaded from: classes.dex */
    static class h extends g {
        h() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AccessibilityNodeInfoCompat.java */
    /* loaded from: classes.dex */
    public static class i {
        i() {
        }

        public String a(AccessibilityNodeInfo accessibilityNodeInfo) {
            return null;
        }

        public Object b(int i, int i2, boolean z, int i3) {
            return null;
        }

        public Object c(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return null;
        }

        public void d(AccessibilityNodeInfo accessibilityNodeInfo, Object obj) {
        }

        public void e(AccessibilityNodeInfo accessibilityNodeInfo, Object obj) {
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat.java */
    /* loaded from: classes.dex */
    public static class j {

        /* renamed from: a  reason: collision with root package name */
        final Object f355a;

        j(Object obj) {
            this.f355a = obj;
        }

        public static j a(int i, int i2, boolean z, int i3) {
            return new j(b.f352a.b(i, i2, z, i3));
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat.java */
    /* loaded from: classes.dex */
    public static class k {

        /* renamed from: a  reason: collision with root package name */
        final Object f356a;

        k(Object obj) {
            this.f356a = obj;
        }

        public static k a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return new k(b.f352a.c(i, i2, i3, i4, z, z2));
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 24) {
            f352a = new h();
        } else if (i2 >= 23) {
            f352a = new g();
        } else if (i2 >= 22) {
            f352a = new f();
        } else if (i2 >= 21) {
            f352a = new e();
        } else if (i2 >= 19) {
            f352a = new d();
        } else if (i2 >= 18) {
            f352a = new c();
        } else if (i2 >= 17) {
            f352a = new C0019b();
        } else if (i2 >= 16) {
            f352a = new a();
        } else {
            f352a = new i();
        }
    }

    private b(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f353b = accessibilityNodeInfo;
    }

    private static String b(int i2) {
        if (i2 != 1) {
            if (i2 != 2) {
                switch (i2) {
                    case 4:
                        return "ACTION_SELECT";
                    case 8:
                        return "ACTION_CLEAR_SELECTION";
                    case 16:
                        return "ACTION_CLICK";
                    case 32:
                        return "ACTION_LONG_CLICK";
                    case 64:
                        return "ACTION_ACCESSIBILITY_FOCUS";
                    case 128:
                        return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
                    case IRadioController.TEF663x_PCHANNEL /* 256 */:
                        return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
                    case IInputController.KEYCODE_BACK_BUTTON /* 512 */:
                        return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
                    case 1024:
                        return "ACTION_NEXT_HTML_ELEMENT";
                    case 2048:
                        return "ACTION_PREVIOUS_HTML_ELEMENT";
                    case 4096:
                        return "ACTION_SCROLL_FORWARD";
                    case 8192:
                        return "ACTION_SCROLL_BACKWARD";
                    case 16384:
                        return "ACTION_COPY";
                    case 32768:
                        return "ACTION_PASTE";
                    case 65536:
                        return "ACTION_CUT";
                    case OSSConstants.DEFAULT_STREAM_BUFFER_SIZE /* 131072 */:
                        return "ACTION_SET_SELECTION";
                    default:
                        return "ACTION_UNKNOWN";
                }
            }
            return "ACTION_CLEAR_FOCUS";
        }
        return "ACTION_FOCUS";
    }

    public static b z(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new b(accessibilityNodeInfo);
    }

    public void a(int i2) {
        this.f353b.addAction(i2);
    }

    public int c() {
        return this.f353b.getActions();
    }

    public void d(Rect rect) {
        this.f353b.getBoundsInParent(rect);
    }

    public void e(Rect rect) {
        this.f353b.getBoundsInScreen(rect);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && b.class == obj.getClass()) {
            b bVar = (b) obj;
            AccessibilityNodeInfo accessibilityNodeInfo = this.f353b;
            if (accessibilityNodeInfo == null) {
                if (bVar.f353b != null) {
                    return false;
                }
            } else if (!accessibilityNodeInfo.equals(bVar.f353b)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public CharSequence f() {
        return this.f353b.getClassName();
    }

    public CharSequence g() {
        return this.f353b.getContentDescription();
    }

    public CharSequence h() {
        return this.f353b.getPackageName();
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f353b;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public CharSequence i() {
        return this.f353b.getText();
    }

    public String j() {
        return f352a.a(this.f353b);
    }

    public boolean k() {
        return this.f353b.isCheckable();
    }

    public boolean l() {
        return this.f353b.isChecked();
    }

    public boolean m() {
        return this.f353b.isClickable();
    }

    public boolean n() {
        return this.f353b.isEnabled();
    }

    public boolean o() {
        return this.f353b.isFocusable();
    }

    public boolean p() {
        return this.f353b.isFocused();
    }

    public boolean q() {
        return this.f353b.isLongClickable();
    }

    public boolean r() {
        return this.f353b.isPassword();
    }

    public boolean s() {
        return this.f353b.isScrollable();
    }

    public boolean t() {
        return this.f353b.isSelected();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        d(rect);
        sb.append("; boundsInParent: " + rect);
        e(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ");
        sb.append(h());
        sb.append("; className: ");
        sb.append(f());
        sb.append("; text: ");
        sb.append(i());
        sb.append("; contentDescription: ");
        sb.append(g());
        sb.append("; viewId: ");
        sb.append(j());
        sb.append("; checkable: ");
        sb.append(k());
        sb.append("; checked: ");
        sb.append(l());
        sb.append("; focusable: ");
        sb.append(o());
        sb.append("; focused: ");
        sb.append(p());
        sb.append("; selected: ");
        sb.append(t());
        sb.append("; clickable: ");
        sb.append(m());
        sb.append("; longClickable: ");
        sb.append(q());
        sb.append("; enabled: ");
        sb.append(n());
        sb.append("; password: ");
        sb.append(r());
        sb.append("; scrollable: " + s());
        sb.append("; [");
        int c2 = c();
        while (c2 != 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(c2);
            c2 &= ~numberOfTrailingZeros;
            sb.append(b(numberOfTrailingZeros));
            if (c2 != 0) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public void u(CharSequence charSequence) {
        this.f353b.setClassName(charSequence);
    }

    public void v(Object obj) {
        f352a.d(this.f353b, ((j) obj).f355a);
    }

    public void w(Object obj) {
        f352a.e(this.f353b, ((k) obj).f356a);
    }

    public void x(boolean z) {
        this.f353b.setScrollable(z);
    }

    public AccessibilityNodeInfo y() {
        return this.f353b;
    }
}
