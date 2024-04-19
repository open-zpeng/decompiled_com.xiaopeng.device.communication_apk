package b.d.a;

import android.content.Context;
import android.text.TextUtils;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.ICounterFactory;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEvent;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEvent;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEventBuilder;
import java.util.List;
/* compiled from: DataLogService.java */
/* loaded from: classes.dex */
public class b implements IDataLog {

    /* renamed from: a  reason: collision with root package name */
    private Context f1270a;

    /* compiled from: DataLogService.java */
    /* renamed from: b.d.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0049b implements IMoleEventBuilder {

        /* renamed from: a  reason: collision with root package name */
        b.d.a.c f1271a;

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder
        public IMoleEvent build() {
            this.f1271a.a();
            return this.f1271a;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder
        public IMoleEventBuilder setButtonId(String str) {
            this.f1271a.e("button_id", str);
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder
        public IMoleEventBuilder setEvent(String str) {
            this.f1271a.e(IStatEvent.CUSTOM_MODULE, d.b(str));
            this.f1271a.e(IStatEvent.CUSTOM_EVENT, str);
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder
        public IMoleEventBuilder setModule(String str) {
            this.f1271a.e(IStatEvent.CUSTOM_MODULE, str);
            b.d.a.c cVar = this.f1271a;
            cVar.e(IStatEvent.CUSTOM_EVENT, str + "_page_button");
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder
        public IMoleEventBuilder setPageId(String str) {
            this.f1271a.e("page_id", str);
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder
        public IMoleEventBuilder setProperty(String str, String str2) {
            this.f1271a.e(str, str2);
            return this;
        }

        private C0049b(Context context) {
            this.f1271a = new b.d.a.c(context);
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder
        public IMoleEventBuilder setProperty(String str, Number number) {
            this.f1271a.d(str, number);
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder
        public IMoleEventBuilder setProperty(String str, boolean z) {
            this.f1271a.b(str, Boolean.valueOf(z));
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder
        public IMoleEventBuilder setProperty(String str, char c2) {
            this.f1271a.c(str, Character.valueOf(c2));
            return this;
        }
    }

    /* compiled from: DataLogService.java */
    /* loaded from: classes.dex */
    private class c implements IStatEventBuilder {

        /* renamed from: a  reason: collision with root package name */
        private IStatEvent f1273a;

        c(Context context) {
            this.f1273a = new d(context);
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEventBuilder
        public IStatEvent build() {
            if (!TextUtils.isEmpty(this.f1273a.getEventName())) {
                return this.f1273a;
            }
            throw new IllegalStateException("Please call setEventName first!");
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEventBuilder
        public IStatEventBuilder setEventName(String str) {
            this.f1273a.setEventName(str);
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEventBuilder
        public IStatEventBuilder setProperty(String str, String str2) {
            this.f1273a.put(str, str2);
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEventBuilder
        public IStatEventBuilder setProperty(String str, Number number) {
            this.f1273a.put(str, number);
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEventBuilder
        public IStatEventBuilder setProperty(String str, boolean z) {
            this.f1273a.put(str, Boolean.valueOf(z));
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEventBuilder
        public IStatEventBuilder setProperty(String str, char c2) {
            this.f1273a.put(str, Character.valueOf(c2));
            return this;
        }
    }

    public b(Context context) {
        b.d.a.g.c.b(context);
        this.f1270a = context;
        Module.register(b.d.a.a.class, new b.d.a.a(context));
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog
    public IMoleEventBuilder buildMoleEvent() {
        return new C0049b(this.f1270a);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog
    public IStatEventBuilder buildStat() {
        return new c(this.f1270a);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog
    public ICounterFactory counterFactory() {
        return b.d.a.e.a.a();
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog
    public void sendCanData(String str) {
        b.d.a.g.c.a().c(str);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog
    public void sendFiles(List<String> list) {
        b.d.a.g.c.a().g(list);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog
    public String sendRecentSystemLog() {
        return b.d.a.g.c.a().j();
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog
    public void sendStatData(String str, String str2) {
        b.d.a.g.c.a().h(str, str2);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog
    public void sendStatOriginData(String str, String str2) {
        b.d.a.g.c.a().i(str, str2);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog
    public void sendStatData(IStatEvent iStatEvent) {
        b.d.a.g.c.a().e(iStatEvent);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog
    public void sendStatData(IMoleEvent iMoleEvent) {
        b.d.a.g.c.a().d(iMoleEvent);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog
    public void sendStatData(IStatEvent iStatEvent, List<String> list) {
        b.d.a.g.c.a().f(iStatEvent, list);
    }
}
