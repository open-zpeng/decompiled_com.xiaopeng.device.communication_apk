package b.d.a;

import android.content.Context;
import com.xiaopeng.lib.framework.module.IModuleEntry;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog;
/* compiled from: DataLogModuleEntry.java */
/* loaded from: classes.dex */
public class a implements IModuleEntry {

    /* renamed from: a  reason: collision with root package name */
    private volatile IDataLog f1268a;

    /* renamed from: b  reason: collision with root package name */
    private Context f1269b;

    public a(Context context) {
        this.f1269b = context;
    }

    @Override // com.xiaopeng.lib.framework.module.IModuleEntry
    public Object get(Class cls) {
        if (cls == IDataLog.class) {
            if (this.f1268a == null) {
                synchronized (this) {
                    if (this.f1268a == null) {
                        this.f1268a = new b(this.f1269b);
                    }
                }
            }
            return this.f1268a;
        }
        return null;
    }
}
