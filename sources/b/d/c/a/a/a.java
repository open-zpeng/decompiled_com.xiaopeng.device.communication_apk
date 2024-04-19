package b.d.c.a.a;

import android.content.Context;
import com.xiaopeng.lib.framework.module.IModuleEntry;
import com.xiaopeng.lib.framework.moduleinterface.systemdelegate.ISystemDelegate;
/* compiled from: SystemDelegateModuleEntry.java */
/* loaded from: classes.dex */
public class a implements IModuleEntry {

    /* renamed from: a  reason: collision with root package name */
    private volatile ISystemDelegate f1430a;

    /* renamed from: b  reason: collision with root package name */
    private Context f1431b;

    public a(Context context) {
        this.f1431b = context;
    }

    @Override // com.xiaopeng.lib.framework.module.IModuleEntry
    public Object get(Class cls) {
        if (cls == ISystemDelegate.class) {
            if (this.f1430a == null) {
                synchronized (this) {
                    if (this.f1430a == null) {
                        this.f1430a = new b(this.f1431b);
                    }
                }
            }
            return this.f1430a;
        }
        return null;
    }
}
