package b.a.a.b.a;

import b.a.a.d;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import org.eclipse.paho.client.mqttv3.MqttTopic;
/* compiled from: TypeAdapters.java */
/* loaded from: classes.dex */
public final class l {
    public static final b.a.a.t<StringBuffer> A;
    public static final b.a.a.u B;
    public static final b.a.a.t<URL> C;
    public static final b.a.a.u D;
    public static final b.a.a.t<URI> E;
    public static final b.a.a.u F;
    public static final b.a.a.t<InetAddress> G;
    public static final b.a.a.u H;
    public static final b.a.a.t<UUID> I;
    public static final b.a.a.u J;
    public static final b.a.a.u K;
    public static final b.a.a.t<Calendar> L;
    public static final b.a.a.u M;
    public static final b.a.a.t<Locale> N;
    public static final b.a.a.u O;
    public static final b.a.a.t<b.a.a.v> P;
    public static final b.a.a.u Q;
    public static final b.a.a.u R;

    /* renamed from: a  reason: collision with root package name */
    public static final b.a.a.t<Class> f937a;

    /* renamed from: b  reason: collision with root package name */
    public static final b.a.a.u f938b;

    /* renamed from: c  reason: collision with root package name */
    public static final b.a.a.t<BitSet> f939c;

    /* renamed from: d  reason: collision with root package name */
    public static final b.a.a.u f940d;
    public static final b.a.a.t<Boolean> e;
    public static final b.a.a.t<Boolean> f;
    public static final b.a.a.u g;
    public static final b.a.a.t<Number> h;
    public static final b.a.a.u i;
    public static final b.a.a.t<Number> j;
    public static final b.a.a.u k;
    public static final b.a.a.t<Number> l;
    public static final b.a.a.u m;
    public static final b.a.a.t<Number> n;
    public static final b.a.a.t<Number> o;
    public static final b.a.a.t<Number> p;
    public static final b.a.a.t<Number> q;
    public static final b.a.a.u r;
    public static final b.a.a.t<Character> s;
    public static final b.a.a.u t;
    public static final b.a.a.t<String> u;
    public static final b.a.a.t<BigDecimal> v;
    public static final b.a.a.t<BigInteger> w;
    public static final b.a.a.u x;
    public static final b.a.a.t<StringBuilder> y;
    public static final b.a.a.u z;

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class a extends b.a.a.t<URL> {
        a() {
        }

        @Override // b.a.a.t
        /* renamed from: d */
        public URL c(d.f fVar) throws IOException {
            if (fVar.E() == d.g.NULL) {
                fVar.H();
                return null;
            }
            String G = fVar.G();
            if ("null".equals(G)) {
                return null;
            }
            return new URL(G);
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public void a(d.h hVar, URL url) throws IOException {
            hVar.u(url == null ? null : url.toExternalForm());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class a0 extends b.a.a.t<String> {
        a0() {
        }

        @Override // b.a.a.t
        /* renamed from: d */
        public String c(d.f fVar) throws IOException {
            d.g E = fVar.E();
            if (E != d.g.NULL) {
                return E == d.g.BOOLEAN ? Boolean.toString(fVar.I()) : fVar.G();
            }
            fVar.H();
            return null;
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public void a(d.h hVar, String str) throws IOException {
            hVar.u(str);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class b extends b.a.a.t<URI> {
        b() {
        }

        @Override // b.a.a.t
        /* renamed from: d */
        public URI c(d.f fVar) throws IOException {
            if (fVar.E() == d.g.NULL) {
                fVar.H();
                return null;
            }
            try {
                String G = fVar.G();
                if ("null".equals(G)) {
                    return null;
                }
                return new URI(G);
            } catch (URISyntaxException e) {
                throw new b.a.a.l(e);
            }
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public void a(d.h hVar, URI uri) throws IOException {
            hVar.u(uri == null ? null : uri.toASCIIString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class b0 extends b.a.a.t<BigDecimal> {
        b0() {
        }

        @Override // b.a.a.t
        /* renamed from: d */
        public BigDecimal c(d.f fVar) throws IOException {
            if (fVar.E() == d.g.NULL) {
                fVar.H();
                return null;
            }
            try {
                return new BigDecimal(fVar.G());
            } catch (NumberFormatException e) {
                throw new b.a.a.r(e);
            }
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public void a(d.h hVar, BigDecimal bigDecimal) throws IOException {
            hVar.p(bigDecimal);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class c extends b.a.a.t<BitSet> {
        c() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0038, code lost:
            if (java.lang.Integer.parseInt(r1) != 0) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x003b, code lost:
            r5 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0074, code lost:
            if (r8.N() != 0) goto L20;
         */
        @Override // b.a.a.t
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.util.BitSet c(b.a.a.d.f r8) throws java.io.IOException {
            /*
                r7 = this;
                b.a.a.d$g r0 = r8.E()
                b.a.a.d$g r1 = b.a.a.d.g.NULL
                if (r0 != r1) goto Ld
                r8.H()
                r8 = 0
                return r8
            Ld:
                java.util.BitSet r0 = new java.util.BitSet
                r0.<init>()
                r8.n()
                b.a.a.d$g r1 = r8.E()
                r2 = 0
                r3 = r2
            L1b:
                b.a.a.d$g r4 = b.a.a.d.g.END_ARRAY
                if (r1 == r4) goto L82
                int[] r4 = b.a.a.b.a.l.q.f955a
                int r5 = r1.ordinal()
                r4 = r4[r5]
                r5 = 1
                if (r4 == r5) goto L70
                r6 = 2
                if (r4 == r6) goto L6b
                r6 = 3
                if (r4 != r6) goto L54
                java.lang.String r1 = r8.G()
                int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.NumberFormatException -> L3d
                if (r1 == 0) goto L3b
                goto L76
            L3b:
                r5 = r2
                goto L76
            L3d:
                b.a.a.r r8 = new b.a.a.r
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r2 = "Error: Expecting: bitset number value (1, 0), Found: "
                r0.append(r2)
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r8.<init>(r0)
                throw r8
            L54:
                b.a.a.r r8 = new b.a.a.r
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r2 = "Invalid bitset value type: "
                r0.append(r2)
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r8.<init>(r0)
                throw r8
            L6b:
                boolean r5 = r8.I()
                goto L76
            L70:
                int r1 = r8.N()
                if (r1 == 0) goto L3b
            L76:
                if (r5 == 0) goto L7b
                r0.set(r3)
            L7b:
                int r3 = r3 + 1
                b.a.a.d$g r1 = r8.E()
                goto L1b
            L82:
                r8.w()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: b.a.a.b.a.l.c.c(b.a.a.d$f):java.util.BitSet");
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public void a(d.h hVar, BitSet bitSet) throws IOException {
            if (bitSet == null) {
                hVar.F();
                return;
            }
            hVar.t();
            for (int i = 0; i < bitSet.length(); i++) {
                hVar.o(bitSet.get(i) ? 1L : 0L);
            }
            hVar.A();
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class c0 extends b.a.a.t<BigInteger> {
        c0() {
        }

        @Override // b.a.a.t
        /* renamed from: d */
        public BigInteger c(d.f fVar) throws IOException {
            if (fVar.E() == d.g.NULL) {
                fVar.H();
                return null;
            }
            try {
                return new BigInteger(fVar.G());
            } catch (NumberFormatException e) {
                throw new b.a.a.r(e);
            }
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public void a(d.h hVar, BigInteger bigInteger) throws IOException {
            hVar.p(bigInteger);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class d extends b.a.a.t<InetAddress> {
        d() {
        }

        @Override // b.a.a.t
        /* renamed from: d */
        public InetAddress c(d.f fVar) throws IOException {
            if (fVar.E() == d.g.NULL) {
                fVar.H();
                return null;
            }
            return InetAddress.getByName(fVar.G());
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public void a(d.h hVar, InetAddress inetAddress) throws IOException {
            hVar.u(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class d0 extends b.a.a.t<StringBuilder> {
        d0() {
        }

        @Override // b.a.a.t
        /* renamed from: d */
        public StringBuilder c(d.f fVar) throws IOException {
            if (fVar.E() == d.g.NULL) {
                fVar.H();
                return null;
            }
            return new StringBuilder(fVar.G());
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public void a(d.h hVar, StringBuilder sb) throws IOException {
            hVar.u(sb == null ? null : sb.toString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class e extends b.a.a.t<UUID> {
        e() {
        }

        @Override // b.a.a.t
        /* renamed from: d */
        public UUID c(d.f fVar) throws IOException {
            if (fVar.E() == d.g.NULL) {
                fVar.H();
                return null;
            }
            return UUID.fromString(fVar.G());
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public void a(d.h hVar, UUID uuid) throws IOException {
            hVar.u(uuid == null ? null : uuid.toString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class e0 extends b.a.a.t<StringBuffer> {
        e0() {
        }

        @Override // b.a.a.t
        /* renamed from: d */
        public StringBuffer c(d.f fVar) throws IOException {
            if (fVar.E() == d.g.NULL) {
                fVar.H();
                return null;
            }
            return new StringBuffer(fVar.G());
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public void a(d.h hVar, StringBuffer stringBuffer) throws IOException {
            hVar.u(stringBuffer == null ? null : stringBuffer.toString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class f implements b.a.a.u {

        /* compiled from: TypeAdapters.java */
        /* loaded from: classes.dex */
        class a extends b.a.a.t<Timestamp> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b.a.a.t f941a;

            a(b.a.a.t tVar) {
                this.f941a = tVar;
            }

            @Override // b.a.a.t
            /* renamed from: d */
            public Timestamp c(d.f fVar) throws IOException {
                Date date = (Date) this.f941a.c(fVar);
                if (date != null) {
                    return new Timestamp(date.getTime());
                }
                return null;
            }

            @Override // b.a.a.t
            /* renamed from: e */
            public void a(d.h hVar, Timestamp timestamp) throws IOException {
                this.f941a.a(hVar, timestamp);
            }
        }

        f() {
        }

        @Override // b.a.a.u
        public <T> b.a.a.t<T> a(b.a.a.h hVar, b.a.a.e.a<T> aVar) {
            if (aVar.a() != Timestamp.class) {
                return null;
            }
            return new a(hVar.e(Date.class));
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    private static final class f0<T extends Enum<T>> extends b.a.a.t<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Map<String, T> f943a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        private final Map<T, String> f944b = new HashMap();

        public f0(Class<T> cls) {
            T[] enumConstants;
            try {
                for (T t : cls.getEnumConstants()) {
                    String name = t.name();
                    b.a.a.a.b bVar = (b.a.a.a.b) cls.getField(name).getAnnotation(b.a.a.a.b.class);
                    name = bVar != null ? bVar.O000000o() : name;
                    this.f943a.put(name, t);
                    this.f944b.put(t, name);
                }
            } catch (NoSuchFieldException unused) {
                throw new AssertionError();
            }
        }

        @Override // b.a.a.t
        /* renamed from: d */
        public T c(d.f fVar) throws IOException {
            if (fVar.E() == d.g.NULL) {
                fVar.H();
                return null;
            }
            return this.f943a.get(fVar.G());
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public void a(d.h hVar, T t) throws IOException {
            hVar.u(t == null ? null : this.f944b.get(t));
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class g extends b.a.a.t<Calendar> {
        g() {
        }

        @Override // b.a.a.t
        /* renamed from: d */
        public Calendar c(d.f fVar) throws IOException {
            if (fVar.E() == d.g.NULL) {
                fVar.H();
                return null;
            }
            fVar.B();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (fVar.E() != d.g.END_OBJECT) {
                String F = fVar.F();
                int N = fVar.N();
                if ("year".equals(F)) {
                    i = N;
                } else if ("month".equals(F)) {
                    i2 = N;
                } else if ("dayOfMonth".equals(F)) {
                    i3 = N;
                } else if ("hourOfDay".equals(F)) {
                    i4 = N;
                } else if ("minute".equals(F)) {
                    i5 = N;
                } else if ("second".equals(F)) {
                    i6 = N;
                }
            }
            fVar.z();
            return new GregorianCalendar(i, i2, i3, i4, i5, i6);
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public void a(d.h hVar, Calendar calendar) throws IOException {
            if (calendar == null) {
                hVar.F();
                return;
            }
            hVar.x();
            hVar.q("year");
            hVar.o(calendar.get(1));
            hVar.q("month");
            hVar.o(calendar.get(2));
            hVar.q("dayOfMonth");
            hVar.o(calendar.get(5));
            hVar.q("hourOfDay");
            hVar.o(calendar.get(11));
            hVar.q("minute");
            hVar.o(calendar.get(12));
            hVar.q("second");
            hVar.o(calendar.get(13));
            hVar.D();
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class h extends b.a.a.t<Locale> {
        h() {
        }

        @Override // b.a.a.t
        /* renamed from: d */
        public Locale c(d.f fVar) throws IOException {
            if (fVar.E() == d.g.NULL) {
                fVar.H();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(fVar.G(), "_");
            String nextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            return (nextToken2 == null && nextToken3 == null) ? new Locale(nextToken) : nextToken3 == null ? new Locale(nextToken, nextToken2) : new Locale(nextToken, nextToken2, nextToken3);
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public void a(d.h hVar, Locale locale) throws IOException {
            hVar.u(locale == null ? null : locale.toString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class i extends b.a.a.t<b.a.a.v> {
        i() {
        }

        @Override // b.a.a.t
        /* renamed from: d */
        public b.a.a.v c(d.f fVar) throws IOException {
            switch (q.f955a[fVar.E().ordinal()]) {
                case 1:
                    return new b.a.a.p(new b.a.a.b.g(fVar.G()));
                case 2:
                    return new b.a.a.p(Boolean.valueOf(fVar.I()));
                case 3:
                    return new b.a.a.p(fVar.G());
                case 4:
                    fVar.H();
                    return b.a.a.m.f1044a;
                case 5:
                    b.a.a.j jVar = new b.a.a.j();
                    fVar.n();
                    while (fVar.D()) {
                        jVar.h(c(fVar));
                    }
                    fVar.w();
                    return jVar;
                case 6:
                    b.a.a.n nVar = new b.a.a.n();
                    fVar.B();
                    while (fVar.D()) {
                        nVar.h(fVar.F(), c(fVar));
                    }
                    fVar.z();
                    return nVar;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public void a(d.h hVar, b.a.a.v vVar) throws IOException {
            if (vVar == null || vVar.c()) {
                hVar.F();
            } else if (vVar.d()) {
                b.a.a.p g = vVar.g();
                if (g.s()) {
                    hVar.p(g.m());
                } else if (g.j()) {
                    hVar.r(g.q());
                } else {
                    hVar.u(g.l());
                }
            } else if (vVar.b()) {
                hVar.t();
                Iterator<b.a.a.v> it = vVar.f().iterator();
                while (it.hasNext()) {
                    a(hVar, it.next());
                }
                hVar.A();
            } else if (!vVar.a()) {
                throw new IllegalArgumentException("Couldn't write " + vVar.getClass());
            } else {
                hVar.x();
                for (Map.Entry<String, b.a.a.v> entry : vVar.e().i()) {
                    hVar.q(entry.getKey());
                    a(hVar, entry.getValue());
                }
                hVar.D();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    public static class j implements b.a.a.u {
        j() {
        }

        @Override // b.a.a.u
        public <T> b.a.a.t<T> a(b.a.a.h hVar, b.a.a.e.a<T> aVar) {
            Class a2 = aVar.a();
            if (!Enum.class.isAssignableFrom(a2) || a2 == Enum.class) {
                return null;
            }
            if (!a2.isEnum()) {
                a2 = (Class<? super Object>) a2.getSuperclass();
            }
            return new f0(a2);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class k extends b.a.a.t<Class> {
        k() {
        }

        @Override // b.a.a.t
        /* renamed from: d */
        public Class c(d.f fVar) throws IOException {
            if (fVar.E() == d.g.NULL) {
                fVar.H();
                return null;
            }
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public void a(d.h hVar, Class cls) throws IOException {
            if (cls == null) {
                hVar.F();
                return;
            }
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeAdapters.java */
    /* renamed from: b.a.a.b.a.l$l  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0031l implements b.a.a.u {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Class f945a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b.a.a.t f946b;

        C0031l(Class cls, b.a.a.t tVar) {
            this.f945a = cls;
            this.f946b = tVar;
        }

        @Override // b.a.a.u
        public <T> b.a.a.t<T> a(b.a.a.h hVar, b.a.a.e.a<T> aVar) {
            if (aVar.a() == this.f945a) {
                return this.f946b;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f945a.getName() + ",adapter=" + this.f946b + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    public static class m implements b.a.a.u {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Class f947a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Class f948b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ b.a.a.t f949c;

        m(Class cls, Class cls2, b.a.a.t tVar) {
            this.f947a = cls;
            this.f948b = cls2;
            this.f949c = tVar;
        }

        @Override // b.a.a.u
        public <T> b.a.a.t<T> a(b.a.a.h hVar, b.a.a.e.a<T> aVar) {
            Class<? super T> a2 = aVar.a();
            if (a2 == this.f947a || a2 == this.f948b) {
                return this.f949c;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f948b.getName() + MqttTopic.SINGLE_LEVEL_WILDCARD + this.f947a.getName() + ",adapter=" + this.f949c + "]";
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class n extends b.a.a.t<Boolean> {
        n() {
        }

        @Override // b.a.a.t
        /* renamed from: d */
        public Boolean c(d.f fVar) throws IOException {
            if (fVar.E() != d.g.NULL) {
                return fVar.E() == d.g.STRING ? Boolean.valueOf(Boolean.parseBoolean(fVar.G())) : Boolean.valueOf(fVar.I());
            }
            fVar.H();
            return null;
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public void a(d.h hVar, Boolean bool) throws IOException {
            if (bool == null) {
                hVar.F();
            } else {
                hVar.r(bool.booleanValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    public static class o implements b.a.a.u {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Class f950a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Class f951b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ b.a.a.t f952c;

        o(Class cls, Class cls2, b.a.a.t tVar) {
            this.f950a = cls;
            this.f951b = cls2;
            this.f952c = tVar;
        }

        @Override // b.a.a.u
        public <T> b.a.a.t<T> a(b.a.a.h hVar, b.a.a.e.a<T> aVar) {
            Class<? super T> a2 = aVar.a();
            if (a2 == this.f950a || a2 == this.f951b) {
                return this.f952c;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f950a.getName() + MqttTopic.SINGLE_LEVEL_WILDCARD + this.f951b.getName() + ",adapter=" + this.f952c + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    public static class p implements b.a.a.u {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Class f953a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b.a.a.t f954b;

        p(Class cls, b.a.a.t tVar) {
            this.f953a = cls;
            this.f954b = tVar;
        }

        @Override // b.a.a.u
        public <T> b.a.a.t<T> a(b.a.a.h hVar, b.a.a.e.a<T> aVar) {
            if (this.f953a.isAssignableFrom(aVar.a())) {
                return this.f954b;
            }
            return null;
        }

        public String toString() {
            return "Factory[typeHierarchy=" + this.f953a.getName() + ",adapter=" + this.f954b + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class q {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f955a;

        static {
            int[] iArr = new int[d.g.values().length];
            f955a = iArr;
            try {
                iArr[d.g.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f955a[d.g.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f955a[d.g.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f955a[d.g.NULL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f955a[d.g.BEGIN_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f955a[d.g.BEGIN_OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f955a[d.g.END_DOCUMENT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f955a[d.g.NAME.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f955a[d.g.END_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f955a[d.g.END_ARRAY.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class r extends b.a.a.t<Boolean> {
        r() {
        }

        @Override // b.a.a.t
        /* renamed from: d */
        public Boolean c(d.f fVar) throws IOException {
            if (fVar.E() == d.g.NULL) {
                fVar.H();
                return null;
            }
            return Boolean.valueOf(fVar.G());
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public void a(d.h hVar, Boolean bool) throws IOException {
            hVar.u(bool == null ? "null" : bool.toString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class s extends b.a.a.t<Number> {
        s() {
        }

        @Override // b.a.a.t
        /* renamed from: d */
        public Number c(d.f fVar) throws IOException {
            if (fVar.E() == d.g.NULL) {
                fVar.H();
                return null;
            }
            try {
                return Byte.valueOf((byte) fVar.N());
            } catch (NumberFormatException e) {
                throw new b.a.a.r(e);
            }
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public void a(d.h hVar, Number number) throws IOException {
            hVar.p(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class t extends b.a.a.t<Number> {
        t() {
        }

        @Override // b.a.a.t
        /* renamed from: d */
        public Number c(d.f fVar) throws IOException {
            if (fVar.E() == d.g.NULL) {
                fVar.H();
                return null;
            }
            try {
                return Short.valueOf((short) fVar.N());
            } catch (NumberFormatException e) {
                throw new b.a.a.r(e);
            }
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public void a(d.h hVar, Number number) throws IOException {
            hVar.p(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class u extends b.a.a.t<Number> {
        u() {
        }

        @Override // b.a.a.t
        /* renamed from: d */
        public Number c(d.f fVar) throws IOException {
            if (fVar.E() == d.g.NULL) {
                fVar.H();
                return null;
            }
            return Double.valueOf(fVar.J());
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public void a(d.h hVar, Number number) throws IOException {
            hVar.p(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class v extends b.a.a.t<Number> {
        v() {
        }

        @Override // b.a.a.t
        /* renamed from: d */
        public Number c(d.f fVar) throws IOException {
            if (fVar.E() == d.g.NULL) {
                fVar.H();
                return null;
            }
            try {
                return Integer.valueOf(fVar.N());
            } catch (NumberFormatException e) {
                throw new b.a.a.r(e);
            }
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public void a(d.h hVar, Number number) throws IOException {
            hVar.p(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class w extends b.a.a.t<Number> {
        w() {
        }

        @Override // b.a.a.t
        /* renamed from: d */
        public Number c(d.f fVar) throws IOException {
            if (fVar.E() == d.g.NULL) {
                fVar.H();
                return null;
            }
            try {
                return Long.valueOf(fVar.K());
            } catch (NumberFormatException e) {
                throw new b.a.a.r(e);
            }
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public void a(d.h hVar, Number number) throws IOException {
            hVar.p(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class x extends b.a.a.t<Number> {
        x() {
        }

        @Override // b.a.a.t
        /* renamed from: d */
        public Number c(d.f fVar) throws IOException {
            if (fVar.E() == d.g.NULL) {
                fVar.H();
                return null;
            }
            return Float.valueOf((float) fVar.J());
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public void a(d.h hVar, Number number) throws IOException {
            hVar.p(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class y extends b.a.a.t<Number> {
        y() {
        }

        @Override // b.a.a.t
        /* renamed from: d */
        public Number c(d.f fVar) throws IOException {
            d.g E = fVar.E();
            int i = q.f955a[E.ordinal()];
            if (i != 1) {
                if (i == 4) {
                    fVar.H();
                    return null;
                }
                throw new b.a.a.r("Expecting number, got: " + E);
            }
            return new b.a.a.b.g(fVar.G());
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public void a(d.h hVar, Number number) throws IOException {
            hVar.p(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class z extends b.a.a.t<Character> {
        z() {
        }

        @Override // b.a.a.t
        /* renamed from: d */
        public Character c(d.f fVar) throws IOException {
            if (fVar.E() == d.g.NULL) {
                fVar.H();
                return null;
            }
            String G = fVar.G();
            if (G.length() == 1) {
                return Character.valueOf(G.charAt(0));
            }
            throw new b.a.a.r("Expecting character, got: " + G);
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public void a(d.h hVar, Character ch) throws IOException {
            hVar.u(ch == null ? null : String.valueOf(ch));
        }
    }

    static {
        k kVar = new k();
        f937a = kVar;
        f938b = b(Class.class, kVar);
        c cVar = new c();
        f939c = cVar;
        f940d = b(BitSet.class, cVar);
        n nVar = new n();
        e = nVar;
        f = new r();
        g = c(Boolean.TYPE, Boolean.class, nVar);
        s sVar = new s();
        h = sVar;
        i = c(Byte.TYPE, Byte.class, sVar);
        t tVar = new t();
        j = tVar;
        k = c(Short.TYPE, Short.class, tVar);
        v vVar = new v();
        l = vVar;
        m = c(Integer.TYPE, Integer.class, vVar);
        n = new w();
        o = new x();
        p = new u();
        y yVar = new y();
        q = yVar;
        r = b(Number.class, yVar);
        z zVar = new z();
        s = zVar;
        t = c(Character.TYPE, Character.class, zVar);
        a0 a0Var = new a0();
        u = a0Var;
        v = new b0();
        w = new c0();
        x = b(String.class, a0Var);
        d0 d0Var = new d0();
        y = d0Var;
        z = b(StringBuilder.class, d0Var);
        e0 e0Var = new e0();
        A = e0Var;
        B = b(StringBuffer.class, e0Var);
        a aVar = new a();
        C = aVar;
        D = b(URL.class, aVar);
        b bVar = new b();
        E = bVar;
        F = b(URI.class, bVar);
        d dVar = new d();
        G = dVar;
        H = d(InetAddress.class, dVar);
        e eVar = new e();
        I = eVar;
        J = b(UUID.class, eVar);
        K = new f();
        g gVar = new g();
        L = gVar;
        M = e(Calendar.class, GregorianCalendar.class, gVar);
        h hVar = new h();
        N = hVar;
        O = b(Locale.class, hVar);
        i iVar = new i();
        P = iVar;
        Q = d(b.a.a.v.class, iVar);
        R = a();
    }

    public static b.a.a.u a() {
        return new j();
    }

    public static <TT> b.a.a.u b(Class<TT> cls, b.a.a.t<TT> tVar) {
        return new C0031l(cls, tVar);
    }

    public static <TT> b.a.a.u c(Class<TT> cls, Class<TT> cls2, b.a.a.t<? super TT> tVar) {
        return new m(cls, cls2, tVar);
    }

    public static <TT> b.a.a.u d(Class<TT> cls, b.a.a.t<TT> tVar) {
        return new p(cls, tVar);
    }

    public static <TT> b.a.a.u e(Class<TT> cls, Class<? extends TT> cls2, b.a.a.t<? super TT> tVar) {
        return new o(cls, cls2, tVar);
    }
}
