package a.b.c.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
/* compiled from: LocalBroadcastManager.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f253a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static b f254b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f255c;

    /* renamed from: d  reason: collision with root package name */
    private final HashMap<BroadcastReceiver, ArrayList<c>> f256d = new HashMap<>();
    private final HashMap<String, ArrayList<c>> e = new HashMap<>();
    private final ArrayList<C0010b> f = new ArrayList<>();
    private final Handler g;

    /* compiled from: LocalBroadcastManager.java */
    /* loaded from: classes.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                b.this.b();
            } else {
                super.handleMessage(message);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LocalBroadcastManager.java */
    /* renamed from: a.b.c.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0010b {

        /* renamed from: a  reason: collision with root package name */
        final Intent f258a;

        /* renamed from: b  reason: collision with root package name */
        final ArrayList<c> f259b;

        C0010b(Intent intent, ArrayList<c> arrayList) {
            this.f258a = intent;
            this.f259b = arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LocalBroadcastManager.java */
    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        final IntentFilter f260a;

        /* renamed from: b  reason: collision with root package name */
        final BroadcastReceiver f261b;

        /* renamed from: c  reason: collision with root package name */
        boolean f262c;

        /* renamed from: d  reason: collision with root package name */
        boolean f263d;

        c(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f260a = intentFilter;
            this.f261b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.f261b);
            sb.append(" filter=");
            sb.append(this.f260a);
            if (this.f263d) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    private b(Context context) {
        this.f255c = context;
        this.g = new a(context.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        int size;
        C0010b[] c0010bArr;
        while (true) {
            synchronized (this.f256d) {
                size = this.f.size();
                if (size <= 0) {
                    return;
                }
                c0010bArr = new C0010b[size];
                this.f.toArray(c0010bArr);
                this.f.clear();
            }
            for (int i = 0; i < size; i++) {
                C0010b c0010b = c0010bArr[i];
                int size2 = c0010b.f259b.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    c cVar = c0010b.f259b.get(i2);
                    if (!cVar.f263d) {
                        cVar.f261b.onReceive(this.f255c, c0010b.f258a);
                    }
                }
            }
        }
    }

    public static b c(Context context) {
        b bVar;
        synchronized (f253a) {
            if (f254b == null) {
                f254b = new b(context.getApplicationContext());
            }
            bVar = f254b;
        }
        return bVar;
    }

    public void d(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.f256d) {
            c cVar = new c(intentFilter, broadcastReceiver);
            ArrayList<c> arrayList = this.f256d.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.f256d.put(broadcastReceiver, arrayList);
            }
            arrayList.add(cVar);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                String action = intentFilter.getAction(i);
                ArrayList<c> arrayList2 = this.e.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.e.put(action, arrayList2);
                }
                arrayList2.add(cVar);
            }
        }
    }

    public boolean e(Intent intent) {
        int i;
        String str;
        ArrayList arrayList;
        ArrayList<c> arrayList2;
        String str2;
        synchronized (this.f256d) {
            String action = intent.getAction();
            String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f255c.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z = (intent.getFlags() & 8) != 0;
            if (z) {
                Log.v("LocalBroadcastManager", "Resolving type " + resolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
            }
            ArrayList<c> arrayList3 = this.e.get(intent.getAction());
            if (arrayList3 != null) {
                if (z) {
                    Log.v("LocalBroadcastManager", "Action list: " + arrayList3);
                }
                ArrayList arrayList4 = null;
                int i2 = 0;
                while (i2 < arrayList3.size()) {
                    c cVar = arrayList3.get(i2);
                    if (z) {
                        Log.v("LocalBroadcastManager", "Matching against filter " + cVar.f260a);
                    }
                    if (cVar.f262c) {
                        if (z) {
                            Log.v("LocalBroadcastManager", "  Filter's target already added");
                        }
                        i = i2;
                        arrayList2 = arrayList3;
                        str = action;
                        str2 = resolveTypeIfNeeded;
                        arrayList = arrayList4;
                    } else {
                        i = i2;
                        str = action;
                        arrayList = arrayList4;
                        arrayList2 = arrayList3;
                        str2 = resolveTypeIfNeeded;
                        int match = cVar.f260a.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                        if (match >= 0) {
                            if (z) {
                                Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(match));
                            }
                            arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                            arrayList4.add(cVar);
                            cVar.f262c = true;
                            i2 = i + 1;
                            action = str;
                            arrayList3 = arrayList2;
                            resolveTypeIfNeeded = str2;
                        } else if (z) {
                            Log.v("LocalBroadcastManager", "  Filter did not match: " + (match != -4 ? match != -3 ? match != -2 ? match != -1 ? "unknown reason" : "type" : "data" : "action" : "category"));
                        }
                    }
                    arrayList4 = arrayList;
                    i2 = i + 1;
                    action = str;
                    arrayList3 = arrayList2;
                    resolveTypeIfNeeded = str2;
                }
                ArrayList arrayList5 = arrayList4;
                if (arrayList5 != null) {
                    for (int i3 = 0; i3 < arrayList5.size(); i3++) {
                        ((c) arrayList5.get(i3)).f262c = false;
                    }
                    this.f.add(new C0010b(intent, arrayList5));
                    if (!this.g.hasMessages(1)) {
                        this.g.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public void f(BroadcastReceiver broadcastReceiver) {
        synchronized (this.f256d) {
            ArrayList<c> remove = this.f256d.remove(broadcastReceiver);
            if (remove == null) {
                return;
            }
            for (int size = remove.size() - 1; size >= 0; size--) {
                c cVar = remove.get(size);
                cVar.f263d = true;
                for (int i = 0; i < cVar.f260a.countActions(); i++) {
                    String action = cVar.f260a.getAction(i);
                    ArrayList<c> arrayList = this.e.get(action);
                    if (arrayList != null) {
                        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                            c cVar2 = arrayList.get(size2);
                            if (cVar2.f261b == broadcastReceiver) {
                                cVar2.f263d = true;
                                arrayList.remove(size2);
                            }
                        }
                        if (arrayList.size() <= 0) {
                            this.e.remove(action);
                        }
                    }
                }
            }
        }
    }
}
