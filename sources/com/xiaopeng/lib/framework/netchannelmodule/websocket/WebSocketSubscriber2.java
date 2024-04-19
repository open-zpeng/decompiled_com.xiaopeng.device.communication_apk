package com.xiaopeng.lib.framework.netchannelmodule.websocket;

import android.annotation.SuppressLint;
import c.a.e;
import c.a.o.f;
import c.a.t.a;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.websocket.WebSocketSubscriber;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public abstract class WebSocketSubscriber2<T> extends WebSocketSubscriber {
    private static final Gson GSON = new Gson();
    protected Type type;

    public WebSocketSubscriber2() {
        analysisType();
    }

    private void analysisType() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (!(genericSuperclass instanceof Class)) {
            this.type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
            return;
        }
        throw new RuntimeException("No generics found!");
    }

    public abstract void onMessage(T t);

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.websocket.WebSocketSubscriber
    @SuppressLint({"CheckResult"})
    public void onMessage(String str) {
        e.l(str).m(new f<String, T>() { // from class: com.xiaopeng.lib.framework.netchannelmodule.websocket.WebSocketSubscriber2.2
            @Override // c.a.o.f
            public T apply(String str2) throws Exception {
                try {
                    return (T) WebSocketSubscriber2.GSON.fromJson(str2, WebSocketSubscriber2.this.type);
                } catch (JsonSyntaxException unused) {
                    return (T) WebSocketSubscriber2.GSON.fromJson((String) WebSocketSubscriber2.GSON.fromJson(str2, (Class<Object>) String.class), WebSocketSubscriber2.this.type);
                }
            }
        }).x(a.b()).n(c.a.l.b.a.a()).u((c.a.o.e<T>) new c.a.o.e<T>() { // from class: com.xiaopeng.lib.framework.netchannelmodule.websocket.WebSocketSubscriber2.1
            @Override // c.a.o.e
            public void accept(T t) throws Exception {
                WebSocketSubscriber2.this.onMessage((WebSocketSubscriber2) t);
            }
        });
    }
}
