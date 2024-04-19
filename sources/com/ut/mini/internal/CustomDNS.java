package com.ut.mini.internal;
/* loaded from: classes.dex */
public class CustomDNS {

    /* renamed from: a  reason: collision with root package name */
    private IDnsResolver f2162a;

    /* loaded from: classes.dex */
    public interface IDnsResolver {
        String[] resolveUrl(String str);
    }

    /* loaded from: classes.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final CustomDNS f2163a = new CustomDNS();
    }

    public static CustomDNS instance() {
        return a.f2163a;
    }

    public String[] resolveUrl(String str) {
        IDnsResolver iDnsResolver = this.f2162a;
        if (iDnsResolver != null) {
            return iDnsResolver.resolveUrl(str);
        }
        return null;
    }

    public void setDnsResolver(IDnsResolver iDnsResolver) {
        this.f2162a = iDnsResolver;
    }

    private CustomDNS() {
        this.f2162a = null;
    }
}
