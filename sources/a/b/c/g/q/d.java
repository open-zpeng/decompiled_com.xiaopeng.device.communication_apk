package a.b.c.g.q;

import android.os.Build;
import android.view.accessibility.AccessibilityRecord;
/* compiled from: AccessibilityRecordCompat.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final c f359a;

    /* renamed from: b  reason: collision with root package name */
    private final AccessibilityRecord f360b;

    /* compiled from: AccessibilityRecordCompat.java */
    /* loaded from: classes.dex */
    static class a extends c {
        a() {
        }
    }

    /* compiled from: AccessibilityRecordCompat.java */
    /* loaded from: classes.dex */
    static class b extends a {
        b() {
        }
    }

    /* compiled from: AccessibilityRecordCompat.java */
    /* loaded from: classes.dex */
    static class c {
        c() {
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 16) {
            f359a = new b();
        } else if (i >= 15) {
            f359a = new a();
        } else {
            f359a = new c();
        }
    }

    @Deprecated
    public d(Object obj) {
        this.f360b = (AccessibilityRecord) obj;
    }

    @Deprecated
    public void a(int i) {
        this.f360b.setFromIndex(i);
    }

    @Deprecated
    public void b(boolean z) {
        this.f360b.setScrollable(z);
    }

    @Deprecated
    public void c(int i) {
        this.f360b.setToIndex(i);
    }

    @Deprecated
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && d.class == obj.getClass()) {
            d dVar = (d) obj;
            AccessibilityRecord accessibilityRecord = this.f360b;
            if (accessibilityRecord == null) {
                if (dVar.f360b != null) {
                    return false;
                }
            } else if (!accessibilityRecord.equals(dVar.f360b)) {
                return false;
            }
            return true;
        }
        return false;
    }

    @Deprecated
    public int hashCode() {
        AccessibilityRecord accessibilityRecord = this.f360b;
        if (accessibilityRecord == null) {
            return 0;
        }
        return accessibilityRecord.hashCode();
    }
}
