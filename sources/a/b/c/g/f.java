package a.b.c.g;

import android.view.MotionEvent;
/* compiled from: MotionEventCompat.java */
/* loaded from: classes.dex */
public final class f {
    @Deprecated
    public static int a(MotionEvent motionEvent, int i) {
        return motionEvent.findPointerIndex(i);
    }

    @Deprecated
    public static int b(MotionEvent motionEvent) {
        return motionEvent.getActionIndex();
    }

    @Deprecated
    public static int c(MotionEvent motionEvent) {
        return motionEvent.getActionMasked();
    }

    @Deprecated
    public static float d(MotionEvent motionEvent, int i) {
        return motionEvent.getAxisValue(i);
    }

    @Deprecated
    public static int e(MotionEvent motionEvent, int i) {
        return motionEvent.getPointerId(i);
    }

    @Deprecated
    public static int f(MotionEvent motionEvent) {
        return motionEvent.getSource();
    }

    @Deprecated
    public static float g(MotionEvent motionEvent, int i) {
        return motionEvent.getX(i);
    }

    @Deprecated
    public static float h(MotionEvent motionEvent, int i) {
        return motionEvent.getY(i);
    }
}
