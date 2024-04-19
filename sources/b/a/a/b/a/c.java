package b.a.a.b.a;

import b.a.a.d;
import b.a.a.m;
import b.a.a.n;
import b.a.a.p;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* compiled from: JsonTreeReader.java */
/* loaded from: classes.dex */
public final class c extends d.f {
    private static final Reader o = new a();
    private static final Object p = new Object();
    private final List<Object> q;

    /* compiled from: JsonTreeReader.java */
    /* loaded from: classes.dex */
    static class a extends Reader {
        a() {
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }
    }

    private void Z(d.g gVar) throws IOException {
        if (E() == gVar) {
            return;
        }
        throw new IllegalStateException("Expected " + gVar + " but was " + E());
    }

    private Object a0() {
        List<Object> list = this.q;
        return list.get(list.size() - 1);
    }

    private Object c0() {
        List<Object> list = this.q;
        return list.remove(list.size() - 1);
    }

    @Override // b.a.a.d.f
    public void B() throws IOException {
        Z(d.g.BEGIN_OBJECT);
        this.q.add(((n) a0()).i().iterator());
    }

    @Override // b.a.a.d.f
    public boolean D() throws IOException {
        d.g E = E();
        return (E == d.g.END_OBJECT || E == d.g.END_ARRAY) ? false : true;
    }

    @Override // b.a.a.d.f
    public d.g E() throws IOException {
        if (this.q.isEmpty()) {
            return d.g.END_DOCUMENT;
        }
        Object a0 = a0();
        if (a0 instanceof Iterator) {
            List<Object> list = this.q;
            boolean z = list.get(list.size() - 2) instanceof n;
            Iterator it = (Iterator) a0;
            if (!it.hasNext()) {
                return z ? d.g.END_OBJECT : d.g.END_ARRAY;
            } else if (z) {
                return d.g.NAME;
            } else {
                this.q.add(it.next());
                return E();
            }
        } else if (a0 instanceof n) {
            return d.g.BEGIN_OBJECT;
        } else {
            if (a0 instanceof b.a.a.j) {
                return d.g.BEGIN_ARRAY;
            }
            if (!(a0 instanceof p)) {
                if (a0 instanceof m) {
                    return d.g.NULL;
                }
                if (a0 == p) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
            p pVar = (p) a0;
            if (pVar.t()) {
                return d.g.STRING;
            }
            if (pVar.j()) {
                return d.g.BOOLEAN;
            }
            if (pVar.s()) {
                return d.g.NUMBER;
            }
            throw new AssertionError();
        }
    }

    @Override // b.a.a.d.f
    public String F() throws IOException {
        Z(d.g.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) a0()).next();
        this.q.add(entry.getValue());
        return (String) entry.getKey();
    }

    @Override // b.a.a.d.f
    public String G() throws IOException {
        d.g E = E();
        d.g gVar = d.g.STRING;
        if (E == gVar || E == d.g.NUMBER) {
            return ((p) c0()).l();
        }
        throw new IllegalStateException("Expected " + gVar + " but was " + E);
    }

    @Override // b.a.a.d.f
    public void H() throws IOException {
        Z(d.g.NULL);
        c0();
    }

    @Override // b.a.a.d.f
    public boolean I() throws IOException {
        Z(d.g.BOOLEAN);
        return ((p) c0()).q();
    }

    @Override // b.a.a.d.f
    public double J() throws IOException {
        d.g E = E();
        d.g gVar = d.g.NUMBER;
        if (E != gVar && E != d.g.STRING) {
            throw new IllegalStateException("Expected " + gVar + " but was " + E);
        }
        double n = ((p) a0()).n();
        if (P() || !(Double.isNaN(n) || Double.isInfinite(n))) {
            c0();
            return n;
        }
        throw new NumberFormatException("JSON forbids NaN and infinities: " + n);
    }

    @Override // b.a.a.d.f
    public long K() throws IOException {
        d.g E = E();
        d.g gVar = d.g.NUMBER;
        if (E == gVar || E == d.g.STRING) {
            long p2 = ((p) a0()).p();
            c0();
            return p2;
        }
        throw new IllegalStateException("Expected " + gVar + " but was " + E);
    }

    @Override // b.a.a.d.f
    public void M() throws IOException {
        if (E() == d.g.NAME) {
            F();
        } else {
            c0();
        }
    }

    @Override // b.a.a.d.f
    public int N() throws IOException {
        d.g E = E();
        d.g gVar = d.g.NUMBER;
        if (E == gVar || E == d.g.STRING) {
            int o2 = ((p) a0()).o();
            c0();
            return o2;
        }
        throw new IllegalStateException("Expected " + gVar + " but was " + E);
    }

    public void b0() throws IOException {
        Z(d.g.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) a0()).next();
        this.q.add(entry.getValue());
        this.q.add(new p((String) entry.getKey()));
    }

    @Override // b.a.a.d.f, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.q.clear();
        this.q.add(p);
    }

    @Override // b.a.a.d.f
    public void n() throws IOException {
        Z(d.g.BEGIN_ARRAY);
        this.q.add(((b.a.a.j) a0()).iterator());
    }

    @Override // b.a.a.d.f
    public String toString() {
        return c.class.getSimpleName();
    }

    @Override // b.a.a.d.f
    public void w() throws IOException {
        Z(d.g.END_ARRAY);
        c0();
        c0();
    }

    @Override // b.a.a.d.f
    public void z() throws IOException {
        Z(d.g.END_OBJECT);
        c0();
        c0();
    }
}
