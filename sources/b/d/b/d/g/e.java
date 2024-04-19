package b.d.b.d.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.Choreographer;
import android.view.WindowManager;
/* compiled from: FPSFrameCallBack.java */
@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class e implements Choreographer.FrameCallback {

    /* renamed from: a  reason: collision with root package name */
    private static long f1375a;

    /* renamed from: b  reason: collision with root package name */
    private static long f1376b;

    /* renamed from: c  reason: collision with root package name */
    private long f1377c;

    /* renamed from: d  reason: collision with root package name */
    private long f1378d;
    private a e;

    public e(Context context, a aVar) {
        long a2 = 1.0E9f / a(context);
        this.f1378d = a2;
        f1376b = ((d.f1373a * 1000) * 1000) / a2;
        f1375a = 5000000000L / a2;
        d.a("FPSFrameCallBack", "SKIPPED_FRAME_WARNING_LIMIT : " + f1376b + " ,SKIPPED_FRAME_ANR_TRIGGER : " + f1375a);
        this.e = aVar;
    }

    private float a(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRefreshRate();
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        long j2 = this.f1377c;
        if (j2 == 0) {
            this.f1377c = j;
            Choreographer.getInstance().postFrameCallback(this);
            return;
        }
        long j3 = j - j2;
        long j4 = this.f1378d;
        if (j3 >= j4) {
            long j5 = j3 / j4;
            if (j5 >= f1376b) {
                d.a("FPSFrameCallBack", "Skipped " + j5 + " frames!  The application may be doing too much work on its main thread.");
                this.e.g(j5 >= f1375a, j5);
            }
        }
        this.f1377c = j;
        Choreographer.getInstance().postFrameCallback(this);
    }
}
