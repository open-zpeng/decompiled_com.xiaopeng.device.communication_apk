package b.a.a.b.a;

import b.a.a.d;
import b.a.a.r;
import b.a.a.t;
import b.a.a.u;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
/* compiled from: DateTypeAdapter.java */
/* loaded from: classes.dex */
public final class d extends t<Date> {

    /* renamed from: a  reason: collision with root package name */
    public static final u f908a = new a();

    /* renamed from: b  reason: collision with root package name */
    private final DateFormat f909b = DateFormat.getDateTimeInstance(2, 2, Locale.US);

    /* renamed from: c  reason: collision with root package name */
    private final DateFormat f910c = DateFormat.getDateTimeInstance(2, 2);

    /* renamed from: d  reason: collision with root package name */
    private final DateFormat f911d = f();

    /* compiled from: DateTypeAdapter.java */
    /* loaded from: classes.dex */
    static class a implements u {
        a() {
        }

        @Override // b.a.a.u
        public <T> t<T> a(b.a.a.h hVar, b.a.a.e.a<T> aVar) {
            if (aVar.a() == Date.class) {
                return new d();
            }
            return null;
        }
    }

    private static DateFormat f() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat;
    }

    private synchronized Date g(String str) {
        try {
            try {
                try {
                } catch (ParseException unused) {
                    return this.f911d.parse(str);
                }
            } catch (ParseException e) {
                throw new r(str, e);
            }
        } catch (ParseException unused2) {
            return this.f909b.parse(str);
        }
        return this.f910c.parse(str);
    }

    @Override // b.a.a.t
    /* renamed from: d */
    public Date c(d.f fVar) throws IOException {
        if (fVar.E() == d.g.NULL) {
            fVar.H();
            return null;
        }
        return g(fVar.G());
    }

    @Override // b.a.a.t
    /* renamed from: e */
    public synchronized void a(d.h hVar, Date date) throws IOException {
        if (date == null) {
            hVar.F();
        } else {
            hVar.u(this.f909b.format(date));
        }
    }
}
