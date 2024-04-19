package b.d.b.d.g;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import android.text.TextUtils;
import b.d.b.d.g.b;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* compiled from: BlockHandler.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static ExecutorService f1358a = Executors.newFixedThreadPool(1);

    /* renamed from: b  reason: collision with root package name */
    private Context f1359b;

    /* renamed from: c  reason: collision with root package name */
    private c f1360c;

    /* renamed from: d  reason: collision with root package name */
    private b.c f1361d;
    private StringBuilder e = new StringBuilder(4096);
    private List<String> f = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BlockHandler.java */
    /* renamed from: b.d.b.d.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0058a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f1362a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ StackTraceElement[][] f1363b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int[] f1364c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ long[] f1365d;

        RunnableC0058a(boolean z, StackTraceElement[][] stackTraceElementArr, int[] iArr, long[] jArr) {
            this.f1362a = z;
            this.f1363b = stackTraceElementArr;
            this.f1364c = iArr;
            this.f1365d = jArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z = !TextUtils.isEmpty(this.f1362a ? a.this.e() : "");
            a.this.f.clear();
            StackTraceElement[][] stackTraceElementArr = this.f1363b;
            if (stackTraceElementArr != null && stackTraceElementArr.length > 0) {
                int i = 0;
                for (StackTraceElement[] stackTraceElementArr2 : stackTraceElementArr) {
                    if (stackTraceElementArr2 != null && stackTraceElementArr2.length > 0) {
                        if (a.this.e.length() > 0) {
                            a.this.e.delete(0, a.this.e.length());
                        }
                        StringBuilder sb = a.this.e;
                        sb.append("-----");
                        sb.append("main");
                        sb.append(" repeat ");
                        sb.append(this.f1364c[i]);
                        sb.append("\n");
                        for (StackTraceElement stackTraceElement : stackTraceElementArr2) {
                            StringBuilder sb2 = a.this.e;
                            sb2.append("\tat ");
                            sb2.append(stackTraceElement.toString());
                            sb2.append("\n");
                        }
                    }
                    a.this.f.add(a.this.e.toString());
                    i++;
                }
            }
            String[] strArr = (String[]) a.this.f.toArray(new String[0]);
            if (strArr.length == 0) {
                return;
            }
            a.this.f1361d.a(strArr, z, this.f1365d);
        }
    }

    public a(Context context, c cVar, b.c cVar2) {
        this.f1359b = context;
        this.f1360c = cVar;
        this.f1361d = cVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String e() {
        List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = ((ActivityManager) this.f1359b.getSystemService("activity")).getProcessesInErrorState();
        if (processesInErrorState != null) {
            for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                if (processErrorStateInfo.condition == 2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(processErrorStateInfo.processName);
                    sb.append("\n");
                    sb.append(processErrorStateInfo.shortMsg);
                    sb.append("\n");
                    sb.append(processErrorStateInfo.longMsg);
                    d.a("BlockHandler", sb.toString());
                    return sb.toString();
                }
            }
            return "";
        }
        return "";
    }

    private Runnable f(StackTraceElement[][] stackTraceElementArr, int[] iArr, boolean z, long... jArr) {
        return new RunnableC0058a(z, stackTraceElementArr, iArr, jArr);
    }

    public void g(boolean z, long... jArr) {
        if (this.f1361d == null || Debug.isDebuggerConnected()) {
            return;
        }
        f1358a.execute(f(this.f1360c.a(), this.f1360c.b(), z, jArr));
    }

    public void h() {
        this.f1360c.start();
    }

    public void i() {
        this.f1360c.stop();
    }
}
