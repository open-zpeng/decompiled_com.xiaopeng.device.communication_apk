package c.a.p.h;

import c.a.i;
import java.io.Serializable;
/* compiled from: NotificationLite.java */
/* loaded from: classes.dex */
public enum e {
    COMPLETE;

    /* compiled from: NotificationLite.java */
    /* loaded from: classes.dex */
    static final class a implements Serializable {
        private static final long serialVersionUID = -7482590109178395495L;

        /* renamed from: a  reason: collision with root package name */
        final c.a.m.b f1809a;

        a(c.a.m.b bVar) {
            this.f1809a = bVar;
        }

        public String toString() {
            return "NotificationLite.Disposable[" + this.f1809a + "]";
        }
    }

    /* compiled from: NotificationLite.java */
    /* loaded from: classes.dex */
    static final class b implements Serializable {
        private static final long serialVersionUID = -8759979445933046293L;

        /* renamed from: a  reason: collision with root package name */
        final Throwable f1810a;

        b(Throwable th) {
            this.f1810a = th;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return c.a.p.b.b.c(this.f1810a, ((b) obj).f1810a);
            }
            return false;
        }

        public int hashCode() {
            return this.f1810a.hashCode();
        }

        public String toString() {
            return "NotificationLite.Error[" + this.f1810a + "]";
        }
    }

    /* compiled from: NotificationLite.java */
    /* loaded from: classes.dex */
    static final class c implements Serializable {
        private static final long serialVersionUID = -1322257508628817540L;

        /* renamed from: a  reason: collision with root package name */
        final d.a.b f1811a;

        c(d.a.b bVar) {
            this.f1811a = bVar;
        }

        public String toString() {
            return "NotificationLite.Subscription[" + this.f1811a + "]";
        }
    }

    public static <T> boolean accept(Object obj, d.a.a<? super T> aVar) {
        if (obj == COMPLETE) {
            aVar.onComplete();
            return true;
        } else if (obj instanceof b) {
            aVar.onError(((b) obj).f1810a);
            return true;
        } else {
            aVar.onNext(obj);
            return false;
        }
    }

    public static <T> boolean acceptFull(Object obj, d.a.a<? super T> aVar) {
        if (obj == COMPLETE) {
            aVar.onComplete();
            return true;
        } else if (obj instanceof b) {
            aVar.onError(((b) obj).f1810a);
            return true;
        } else if (obj instanceof c) {
            aVar.a(((c) obj).f1811a);
            return false;
        } else {
            aVar.onNext(obj);
            return false;
        }
    }

    public static Object complete() {
        return COMPLETE;
    }

    public static Object disposable(c.a.m.b bVar) {
        return new a(bVar);
    }

    public static Object error(Throwable th) {
        return new b(th);
    }

    public static c.a.m.b getDisposable(Object obj) {
        return ((a) obj).f1809a;
    }

    public static Throwable getError(Object obj) {
        return ((b) obj).f1810a;
    }

    public static d.a.b getSubscription(Object obj) {
        return ((c) obj).f1811a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T getValue(Object obj) {
        return obj;
    }

    public static boolean isComplete(Object obj) {
        return obj == COMPLETE;
    }

    public static boolean isDisposable(Object obj) {
        return obj instanceof a;
    }

    public static boolean isError(Object obj) {
        return obj instanceof b;
    }

    public static boolean isSubscription(Object obj) {
        return obj instanceof c;
    }

    public static <T> Object next(T t) {
        return t;
    }

    public static Object subscription(d.a.b bVar) {
        return new c(bVar);
    }

    @Override // java.lang.Enum
    public String toString() {
        return "NotificationLite.Complete";
    }

    public static <T> boolean accept(Object obj, i<? super T> iVar) {
        if (obj == COMPLETE) {
            iVar.onComplete();
            return true;
        } else if (obj instanceof b) {
            iVar.onError(((b) obj).f1810a);
            return true;
        } else {
            iVar.onNext(obj);
            return false;
        }
    }

    public static <T> boolean acceptFull(Object obj, i<? super T> iVar) {
        if (obj == COMPLETE) {
            iVar.onComplete();
            return true;
        } else if (obj instanceof b) {
            iVar.onError(((b) obj).f1810a);
            return true;
        } else if (obj instanceof a) {
            iVar.onSubscribe(((a) obj).f1809a);
            return false;
        } else {
            iVar.onNext(obj);
            return false;
        }
    }
}
