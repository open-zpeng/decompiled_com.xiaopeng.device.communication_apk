package com.ut.mini.core.sign;

import b.b.a.a.f.i;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
/* loaded from: classes.dex */
public class UTSecuritySDKRequestAuthentication implements IUTRequestAuthentication {
    private String ad;
    private String g;

    /* renamed from: b  reason: collision with root package name */
    private Object f2160b = null;

    /* renamed from: c  reason: collision with root package name */
    private Object f2161c = null;

    /* renamed from: a  reason: collision with root package name */
    private Class f2159a = null;

    /* renamed from: a  reason: collision with other field name */
    private Field f132a = null;

    /* renamed from: b  reason: collision with other field name */
    private Field f134b = null;

    /* renamed from: c  reason: collision with other field name */
    private Field f135c = null;

    /* renamed from: a  reason: collision with other field name */
    private Method f133a = null;
    private int z = 1;
    private boolean F = false;

    public UTSecuritySDKRequestAuthentication(String str, String str2) {
        this.g = null;
        this.g = str;
        this.ad = str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0050 A[Catch: all -> 0x00d1, TRY_ENTER, TRY_LEAVE, TryCatch #5 {, blocks: (B:3:0x0001, B:39:0x00db, B:15:0x0045, B:17:0x0050, B:23:0x008a, B:35:0x00b5, B:25:0x0099, B:18:0x0074), top: B:47:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private synchronized void D() {
        /*
            Method dump skipped, instructions count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ut.mini.core.sign.UTSecuritySDKRequestAuthentication.D():void");
    }

    @Override // com.ut.mini.core.sign.IUTRequestAuthentication
    public String getAppkey() {
        return this.g;
    }

    public String getAuthCode() {
        return this.ad;
    }

    @Override // com.ut.mini.core.sign.IUTRequestAuthentication
    public String getSign(String str) {
        Class cls;
        if (!this.F) {
            D();
        }
        if (this.g == null) {
            i.a("UTSecuritySDKRequestAuthentication:getSign", "There is no appkey,please check it!");
            return null;
        } else if (str == null || this.f2160b == null || (cls = this.f2159a) == null || this.f132a == null || this.f134b == null || this.f135c == null || this.f133a == null || this.f2161c == null) {
            return null;
        } else {
            try {
                Object newInstance = cls.newInstance();
                this.f132a.set(newInstance, this.g);
                ((Map) this.f134b.get(newInstance)).put("INPUT", str);
                this.f135c.set(newInstance, Integer.valueOf(this.z));
                return (String) this.f133a.invoke(this.f2161c, newInstance, this.ad);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
                return null;
            } catch (InstantiationException e3) {
                e3.printStackTrace();
                return null;
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
                return null;
            }
        }
    }
}
