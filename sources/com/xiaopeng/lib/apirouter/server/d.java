package com.xiaopeng.lib.apirouter.server;

import java.util.HashSet;
import java.util.Set;
/* compiled from: IpcRouterService_Manifest.java */
/* loaded from: classes.dex */
public class d {
    public static Set<String> a() {
        HashSet hashSet = new HashSet(2);
        hashSet.add("IpcRouterService");
        return hashSet;
    }

    public static String b() {
        return "{\"authority\":\"com.xiaopeng.device.communication.IpcRouterService\",\"DESCRIPTOR\":\"com.xiaopeng.device.communication.IpcRouterService\",\"TRANSACTION\":[{\"path\":\"onReceiverData\",\"METHOD\":\"onReceiverData\",\"ID\":0,\"parameter\":[{\"alias\":\"id\",\"name\":\"id\"},{\"alias\":\"bundle\",\"name\":\"bundle\"}]}]}";
    }
}
