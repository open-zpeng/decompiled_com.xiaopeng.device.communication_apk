package a.b.c.g;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
/* compiled from: AccessibilityDelegateCompat.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final b f322a;

    /* renamed from: b  reason: collision with root package name */
    private static final View.AccessibilityDelegate f323b;

    /* renamed from: c  reason: collision with root package name */
    final View.AccessibilityDelegate f324c = f322a.b(this);

    /* compiled from: AccessibilityDelegateCompat.java */
    /* renamed from: a.b.c.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0014a extends b {

        /* compiled from: AccessibilityDelegateCompat.java */
        /* renamed from: a.b.c.g.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0015a extends View.AccessibilityDelegate {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f325a;

            C0015a(a aVar) {
                this.f325a = aVar;
            }

            @Override // android.view.View.AccessibilityDelegate
            public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                return this.f325a.a(view, accessibilityEvent);
            }

            @Override // android.view.View.AccessibilityDelegate
            public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
                a.b.c.g.q.c b2 = this.f325a.b(view);
                if (b2 != null) {
                    return (AccessibilityNodeProvider) b2.a();
                }
                return null;
            }

            @Override // android.view.View.AccessibilityDelegate
            public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                this.f325a.d(view, accessibilityEvent);
            }

            @Override // android.view.View.AccessibilityDelegate
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                this.f325a.e(view, a.b.c.g.q.b.z(accessibilityNodeInfo));
            }

            @Override // android.view.View.AccessibilityDelegate
            public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                this.f325a.f(view, accessibilityEvent);
            }

            @Override // android.view.View.AccessibilityDelegate
            public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                return this.f325a.g(viewGroup, view, accessibilityEvent);
            }

            @Override // android.view.View.AccessibilityDelegate
            public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
                return this.f325a.h(view, i, bundle);
            }

            @Override // android.view.View.AccessibilityDelegate
            public void sendAccessibilityEvent(View view, int i) {
                this.f325a.i(view, i);
            }

            @Override // android.view.View.AccessibilityDelegate
            public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
                this.f325a.j(view, accessibilityEvent);
            }
        }

        C0014a() {
        }

        @Override // a.b.c.g.a.b
        public a.b.c.g.q.c a(View.AccessibilityDelegate accessibilityDelegate, View view) {
            AccessibilityNodeProvider accessibilityNodeProvider = accessibilityDelegate.getAccessibilityNodeProvider(view);
            if (accessibilityNodeProvider != null) {
                return new a.b.c.g.q.c(accessibilityNodeProvider);
            }
            return null;
        }

        @Override // a.b.c.g.a.b
        public View.AccessibilityDelegate b(a aVar) {
            return new C0015a(aVar);
        }

        @Override // a.b.c.g.a.b
        public boolean c(View.AccessibilityDelegate accessibilityDelegate, View view, int i, Bundle bundle) {
            return accessibilityDelegate.performAccessibilityAction(view, i, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AccessibilityDelegateCompat.java */
    /* loaded from: classes.dex */
    public static class b {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AccessibilityDelegateCompat.java */
        /* renamed from: a.b.c.g.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0016a extends View.AccessibilityDelegate {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f327a;

            C0016a(a aVar) {
                this.f327a = aVar;
            }

            @Override // android.view.View.AccessibilityDelegate
            public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                return this.f327a.a(view, accessibilityEvent);
            }

            @Override // android.view.View.AccessibilityDelegate
            public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                this.f327a.d(view, accessibilityEvent);
            }

            @Override // android.view.View.AccessibilityDelegate
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                this.f327a.e(view, a.b.c.g.q.b.z(accessibilityNodeInfo));
            }

            @Override // android.view.View.AccessibilityDelegate
            public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                this.f327a.f(view, accessibilityEvent);
            }

            @Override // android.view.View.AccessibilityDelegate
            public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                return this.f327a.g(viewGroup, view, accessibilityEvent);
            }

            @Override // android.view.View.AccessibilityDelegate
            public void sendAccessibilityEvent(View view, int i) {
                this.f327a.i(view, i);
            }

            @Override // android.view.View.AccessibilityDelegate
            public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
                this.f327a.j(view, accessibilityEvent);
            }
        }

        b() {
        }

        public a.b.c.g.q.c a(View.AccessibilityDelegate accessibilityDelegate, View view) {
            return null;
        }

        public View.AccessibilityDelegate b(a aVar) {
            return new C0016a(aVar);
        }

        public boolean c(View.AccessibilityDelegate accessibilityDelegate, View view, int i, Bundle bundle) {
            return false;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 16) {
            f322a = new C0014a();
        } else {
            f322a = new b();
        }
        f323b = new View.AccessibilityDelegate();
    }

    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return f323b.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public a.b.c.g.q.c b(View view) {
        return f322a.a(f323b, view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View.AccessibilityDelegate c() {
        return this.f324c;
    }

    public void d(View view, AccessibilityEvent accessibilityEvent) {
        f323b.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void e(View view, a.b.c.g.q.b bVar) {
        f323b.onInitializeAccessibilityNodeInfo(view, bVar.y());
    }

    public void f(View view, AccessibilityEvent accessibilityEvent) {
        f323b.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean g(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return f323b.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean h(View view, int i, Bundle bundle) {
        return f322a.c(f323b, view, i, bundle);
    }

    public void i(View view, int i) {
        f323b.sendAccessibilityEvent(view, i);
    }

    public void j(View view, AccessibilityEvent accessibilityEvent) {
        f323b.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }
}
