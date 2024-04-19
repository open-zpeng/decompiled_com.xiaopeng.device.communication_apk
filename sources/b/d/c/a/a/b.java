package b.d.c.a.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import b.d.b.e.c;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.systemdelegate.ISystemDelegate;
/* compiled from: SystemDelegateService.java */
/* loaded from: classes.dex */
public class b implements ISystemDelegate {

    /* renamed from: a  reason: collision with root package name */
    private Context f1432a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context) {
        this.f1432a = context;
        Module.register(a.class, new a(context));
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.systemdelegate.ISystemDelegate
    public String getCertificate() throws RemoteException {
        c.a("SystemDelegateService", "start getCertificate!");
        Cursor query = this.f1432a.getContentResolver().query(Uri.parse("content://com.xiaopeng.system.delegate/cert/ssl"), null, null, null, null);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    String string = query.getString(0);
                    c.t("SystemDelegateService", "query result success");
                    query.close();
                    return string;
                }
            } finally {
                if (query != null) {
                    query.close();
                }
            }
        }
        c.t("SystemDelegateService", "cursor is empty!");
        return null;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.systemdelegate.ISystemDelegate
    public void setSystemProperty(String str, String str2) throws RemoteException {
        c.a("SystemDelegateService", "setSystemProperty " + str + ":" + str2);
        Uri parse = Uri.parse("content://com.xiaopeng.system.delegate/sysprop/set");
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, str2);
        this.f1432a.getContentResolver().update(parse, contentValues, null, null);
    }
}
