package b.a.a.b.a;

import b.a.a.d;
import b.a.a.m;
import b.a.a.n;
import b.a.a.p;
import b.a.a.v;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
/* compiled from: JsonTreeWriter.java */
/* loaded from: classes.dex */
public final class e extends d.h {
    private static final Writer l = new a();
    private static final p m = new p("closed");
    private final List<v> n;
    private String o;
    private v p;

    /* compiled from: JsonTreeWriter.java */
    /* loaded from: classes.dex */
    static class a extends Writer {
        a() {
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }
    }

    public e() {
        super(l);
        this.n = new ArrayList();
        this.p = m.f1044a;
    }

    private void N(v vVar) {
        if (this.o != null) {
            if (!vVar.c() || J()) {
                ((n) O()).h(this.o, vVar);
            }
            this.o = null;
        } else if (this.n.isEmpty()) {
            this.p = vVar;
        } else {
            v O = O();
            if (!(O instanceof b.a.a.j)) {
                throw new IllegalStateException();
            }
            ((b.a.a.j) O).h(vVar);
        }
    }

    private v O() {
        List<v> list = this.n;
        return list.get(list.size() - 1);
    }

    @Override // b.a.a.d.h
    public d.h A() throws IOException {
        if (this.n.isEmpty() || this.o != null) {
            throw new IllegalStateException();
        }
        if (O() instanceof b.a.a.j) {
            List<v> list = this.n;
            list.remove(list.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // b.a.a.d.h
    public d.h D() throws IOException {
        if (this.n.isEmpty() || this.o != null) {
            throw new IllegalStateException();
        }
        if (O() instanceof n) {
            List<v> list = this.n;
            list.remove(list.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // b.a.a.d.h
    public d.h F() throws IOException {
        N(m.f1044a);
        return this;
    }

    public v M() {
        if (this.n.isEmpty()) {
            return this.p;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.n);
    }

    @Override // b.a.a.d.h, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.n.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.n.add(m);
    }

    @Override // b.a.a.d.h, java.io.Flushable
    public void flush() throws IOException {
    }

    @Override // b.a.a.d.h
    public d.h o(long j) throws IOException {
        N(new p(Long.valueOf(j)));
        return this;
    }

    @Override // b.a.a.d.h
    public d.h p(Number number) throws IOException {
        if (number == null) {
            return F();
        }
        if (!G()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        N(new p(number));
        return this;
    }

    @Override // b.a.a.d.h
    public d.h q(String str) throws IOException {
        if (this.n.isEmpty() || this.o != null) {
            throw new IllegalStateException();
        }
        if (O() instanceof n) {
            this.o = str;
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // b.a.a.d.h
    public d.h r(boolean z) throws IOException {
        N(new p(Boolean.valueOf(z)));
        return this;
    }

    @Override // b.a.a.d.h
    public d.h t() throws IOException {
        b.a.a.j jVar = new b.a.a.j();
        N(jVar);
        this.n.add(jVar);
        return this;
    }

    @Override // b.a.a.d.h
    public d.h u(String str) throws IOException {
        if (str == null) {
            return F();
        }
        N(new p(str));
        return this;
    }

    @Override // b.a.a.d.h
    public d.h x() throws IOException {
        n nVar = new n();
        N(nVar);
        this.n.add(nVar);
        return this;
    }
}
