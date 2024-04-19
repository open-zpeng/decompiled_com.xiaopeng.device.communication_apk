package b.a.a.b.a;

import b.a.a.d;
import b.a.a.r;
import b.a.a.t;
import b.a.a.u;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/* compiled from: SqlDateTypeAdapter.java */
/* loaded from: classes.dex */
public final class j extends t<Date> {

    /* renamed from: a  reason: collision with root package name */
    public static final u f932a = new a();

    /* renamed from: b  reason: collision with root package name */
    private final DateFormat f933b = new SimpleDateFormat("MMM d, yyyy");

    /* compiled from: SqlDateTypeAdapter.java */
    /* loaded from: classes.dex */
    static class a implements u {
        a() {
        }

        @Override // b.a.a.u
        public <T> t<T> a(b.a.a.h hVar, b.a.a.e.a<T> aVar) {
            if (aVar.a() == Date.class) {
                return new j();
            }
            return null;
        }
    }

    @Override // b.a.a.t
    /* renamed from: d */
    public synchronized Date c(d.f fVar) throws IOException {
        if (fVar.E() == d.g.NULL) {
            fVar.H();
            return null;
        }
        try {
            return new Date(this.f933b.parse(fVar.G()).getTime());
        } catch (ParseException e) {
            throw new r(e);
        }
    }

    @Override // b.a.a.t
    /* renamed from: e */
    public synchronized void a(d.h hVar, Date date) throws IOException {
        hVar.u(date == null ? null : this.f933b.format((java.util.Date) date));
    }
}
