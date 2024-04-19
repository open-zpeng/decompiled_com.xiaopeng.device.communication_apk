package b.a.a;

import com.xiaopeng.lib.framework.carcontrollermodule.R;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.Objects;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: FieldNamingPolicy.java */
/* loaded from: classes.dex */
public abstract class d implements b.a.a.g {
    public static final d O000000o;
    public static final d O00000Oo;
    public static final d O00000o;
    public static final d O00000o0;
    public static final d O00000oO;

    /* renamed from: a  reason: collision with root package name */
    private static final /* synthetic */ d[] f1019a;

    /* compiled from: FieldNamingPolicy.java */
    /* loaded from: classes.dex */
    enum a extends d {
        a(String str, int i) {
            super(str, i, null);
        }

        @Override // b.a.a.d, b.a.a.g
        public String O000000o(Field field) {
            return field.getName();
        }
    }

    /* compiled from: JsonReader.java */
    /* loaded from: classes.dex */
    public class f implements Closeable {

        /* renamed from: a  reason: collision with root package name */
        private static final char[] f1020a = ")]}'\n".toCharArray();

        /* renamed from: b  reason: collision with root package name */
        private final Reader f1021b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f1022c = false;

        /* renamed from: d  reason: collision with root package name */
        private final char[] f1023d = new char[1024];
        private int e = 0;
        private int f = 0;
        private int g = 0;
        private int h = 0;
        private int i = 0;
        private long j;
        private int k;
        private String l;
        private int[] m;
        private int n;

        /* compiled from: JsonReader.java */
        /* loaded from: classes.dex */
        static class a extends b.a.a.b.f {
            a() {
            }

            @Override // b.a.a.b.f
            public void a(f fVar) throws IOException {
                int i;
                if (fVar instanceof b.a.a.b.a.c) {
                    ((b.a.a.b.a.c) fVar).b0();
                    return;
                }
                int i2 = fVar.i;
                if (i2 == 0) {
                    i2 = fVar.O();
                }
                if (i2 == 13) {
                    i = 9;
                } else if (i2 == 12) {
                    i = 8;
                } else if (i2 != 14) {
                    throw new IllegalStateException("Expected a name but was " + fVar.E() + "  at line " + fVar.T() + " column " + fVar.V());
                } else {
                    i = 10;
                }
                fVar.i = i;
            }
        }

        static {
            b.a.a.b.f.f993a = new a();
        }

        public f(Reader reader) {
            int[] iArr = new int[32];
            this.m = iArr;
            this.n = 0;
            this.n = 0 + 1;
            iArr[0] = 6;
            Objects.requireNonNull(reader, "in == null");
            this.f1021b = reader;
        }

        private void C(char c2) throws IOException {
            char[] cArr = this.f1023d;
            while (true) {
                int i = this.e;
                int i2 = this.f;
                while (true) {
                    if (i < i2) {
                        int i3 = i + 1;
                        char c3 = cArr[i];
                        if (c3 == c2) {
                            this.e = i3;
                            return;
                        } else if (c3 == '\\') {
                            this.e = i3;
                            X();
                            break;
                        } else {
                            if (c3 == '\n') {
                                this.g++;
                                this.h = i3;
                            }
                            i = i3;
                        }
                    } else {
                        this.e = i;
                        if (!x(1)) {
                            throw u("Unterminated string");
                        }
                    }
                }
            }
        }

        private int L() throws IOException {
            int i;
            String str;
            String str2;
            char c2 = this.f1023d[this.e];
            if (c2 == 't' || c2 == 'T') {
                i = 5;
                str = "true";
                str2 = "TRUE";
            } else if (c2 == 'f' || c2 == 'F') {
                i = 6;
                str = "false";
                str2 = "FALSE";
            } else if (c2 != 'n' && c2 != 'N') {
                return 0;
            } else {
                i = 7;
                str = "null";
                str2 = "NULL";
            }
            int length = str.length();
            for (int i2 = 1; i2 < length; i2++) {
                if (this.e + i2 >= this.f && !x(i2 + 1)) {
                    return 0;
                }
                char c3 = this.f1023d[this.e + i2];
                if (c3 != str.charAt(i2) && c3 != str2.charAt(i2)) {
                    return 0;
                }
            }
            if ((this.e + length < this.f || x(length + 1)) && q(this.f1023d[this.e + length])) {
                return 0;
            }
            this.e += length;
            this.i = i;
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int O() throws IOException {
            int i;
            int t;
            int[] iArr = this.m;
            int i2 = this.n;
            int i3 = iArr[i2 - 1];
            if (i3 == 1) {
                iArr[i2 - 1] = 2;
            } else if (i3 != 2) {
                if (i3 == 3 || i3 == 5) {
                    iArr[i2 - 1] = 4;
                    if (i3 == 5 && (t = t(true)) != 44) {
                        if (t != 59) {
                            if (t == 125) {
                                this.i = 2;
                                return 2;
                            }
                            throw u("Unterminated object");
                        }
                        U();
                    }
                    int t2 = t(true);
                    if (t2 == 34) {
                        i = 13;
                    } else if (t2 == 39) {
                        U();
                        i = 12;
                    } else if (t2 == 125) {
                        if (i3 != 5) {
                            this.i = 2;
                            return 2;
                        }
                        throw u("Expected name");
                    } else {
                        U();
                        this.e--;
                        if (!q((char) t2)) {
                            throw u("Expected name");
                        }
                        i = 14;
                    }
                } else if (i3 == 4) {
                    iArr[i2 - 1] = 5;
                    int t3 = t(true);
                    if (t3 != 58) {
                        if (t3 != 61) {
                            throw u("Expected ':'");
                        }
                        U();
                        if (this.e < this.f || x(1)) {
                            char[] cArr = this.f1023d;
                            int i4 = this.e;
                            if (cArr[i4] == '>') {
                                this.e = i4 + 1;
                            }
                        }
                    }
                } else if (i3 == 6) {
                    if (this.f1022c) {
                        Y();
                    }
                    this.m[this.n - 1] = 7;
                } else if (i3 == 7) {
                    if (t(false) == -1) {
                        i = 17;
                    } else {
                        U();
                        this.e--;
                    }
                } else if (i3 == 8) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                this.i = i;
                return i;
            } else {
                int t4 = t(true);
                if (t4 != 44) {
                    if (t4 != 59) {
                        if (t4 == 93) {
                            this.i = 4;
                            return 4;
                        }
                        throw u("Unterminated array");
                    }
                    U();
                }
            }
            int t5 = t(true);
            if (t5 != 34) {
                if (t5 == 39) {
                    U();
                    this.i = 8;
                    return 8;
                }
                if (t5 != 44 && t5 != 59) {
                    if (t5 == 91) {
                        this.i = 3;
                        return 3;
                    } else if (t5 != 93) {
                        if (t5 == 123) {
                            this.i = 1;
                            return 1;
                        }
                        this.e--;
                        if (this.n == 1) {
                            U();
                        }
                        int L = L();
                        if (L != 0) {
                            return L;
                        }
                        int R = R();
                        if (R != 0) {
                            return R;
                        }
                        if (!q(this.f1023d[this.e])) {
                            throw u("Expected value");
                        }
                        U();
                        i = 10;
                    } else if (i3 == 1) {
                        this.i = 4;
                        return 4;
                    }
                }
                if (i3 == 1 || i3 == 2) {
                    U();
                    this.e--;
                    this.i = 7;
                    return 7;
                }
                throw u("Unexpected value");
            }
            if (this.n == 1) {
                U();
            }
            i = 9;
            this.i = i;
            return i;
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x004a, code lost:
            U();
         */
        /* JADX WARN: Removed duplicated region for block: B:46:0x007a  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private java.lang.String Q() throws java.io.IOException {
            /*
                r6 = this;
                r0 = 0
                r1 = 0
            L2:
                r2 = r0
            L3:
                int r3 = r6.e
                int r4 = r3 + r2
                int r5 = r6.f
                if (r4 >= r5) goto L4e
                char[] r4 = r6.f1023d
                int r3 = r3 + r2
                char r3 = r4[r3]
                r4 = 9
                if (r3 == r4) goto L5c
                r4 = 10
                if (r3 == r4) goto L5c
                r4 = 12
                if (r3 == r4) goto L5c
                r4 = 13
                if (r3 == r4) goto L5c
                r4 = 32
                if (r3 == r4) goto L5c
                r4 = 35
                if (r3 == r4) goto L4a
                r4 = 44
                if (r3 == r4) goto L5c
                r4 = 47
                if (r3 == r4) goto L4a
                r4 = 61
                if (r3 == r4) goto L4a
                r4 = 123(0x7b, float:1.72E-43)
                if (r3 == r4) goto L5c
                r4 = 125(0x7d, float:1.75E-43)
                if (r3 == r4) goto L5c
                r4 = 58
                if (r3 == r4) goto L5c
                r4 = 59
                if (r3 == r4) goto L4a
                switch(r3) {
                    case 91: goto L5c;
                    case 92: goto L4a;
                    case 93: goto L5c;
                    default: goto L47;
                }
            L47:
                int r2 = r2 + 1
                goto L3
            L4a:
                r6.U()
                goto L5c
            L4e:
                char[] r3 = r6.f1023d
                int r3 = r3.length
                if (r2 >= r3) goto L5e
                int r3 = r2 + 1
                boolean r3 = r6.x(r3)
                if (r3 == 0) goto L5c
                goto L3
            L5c:
                r0 = r2
                goto L78
            L5e:
                if (r1 != 0) goto L65
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
            L65:
                char[] r3 = r6.f1023d
                int r4 = r6.e
                r1.append(r3, r4, r2)
                int r3 = r6.e
                int r3 = r3 + r2
                r6.e = r3
                r2 = 1
                boolean r2 = r6.x(r2)
                if (r2 != 0) goto L2
            L78:
                if (r1 != 0) goto L84
                java.lang.String r1 = new java.lang.String
                char[] r2 = r6.f1023d
                int r3 = r6.e
                r1.<init>(r2, r3, r0)
                goto L8f
            L84:
                char[] r2 = r6.f1023d
                int r3 = r6.e
                r1.append(r2, r3, r0)
                java.lang.String r1 = r1.toString()
            L8f:
                int r2 = r6.e
                int r2 = r2 + r0
                r6.e = r2
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: b.a.a.d.f.Q():java.lang.String");
        }

        /* JADX WARN: Code restructure failed: missing block: B:54:0x0093, code lost:
            if (q(r14) != false) goto L75;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x0095, code lost:
            if (r9 != 2) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x0097, code lost:
            if (r10 == false) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x009d, code lost:
            if (r11 != Long.MIN_VALUE) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x009f, code lost:
            if (r13 == false) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00a1, code lost:
            if (r13 == false) goto L16;
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x00a4, code lost:
            r11 = -r11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x00a5, code lost:
            r18.j = r11;
            r18.e += r8;
            r1 = 15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x00ae, code lost:
            r18.i = r1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x00b0, code lost:
            return r1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x00b1, code lost:
            if (r9 == 2) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x00b4, code lost:
            if (r9 == 4) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x00b7, code lost:
            if (r9 != 7) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:72:0x00ba, code lost:
            return 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:74:0x00bc, code lost:
            r18.k = r8;
            r1 = 16;
         */
        /* JADX WARN: Code restructure failed: missing block: B:75:0x00c1, code lost:
            return 0;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private int R() throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 239
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: b.a.a.d.f.R():int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x0048, code lost:
            U();
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void S() throws java.io.IOException {
            /*
                r4 = this;
            L0:
                r0 = 0
            L1:
                int r1 = r4.e
                int r2 = r1 + r0
                int r3 = r4.f
                if (r2 >= r3) goto L51
                char[] r2 = r4.f1023d
                int r1 = r1 + r0
                char r1 = r2[r1]
                r2 = 9
                if (r1 == r2) goto L4b
                r2 = 10
                if (r1 == r2) goto L4b
                r2 = 12
                if (r1 == r2) goto L4b
                r2 = 13
                if (r1 == r2) goto L4b
                r2 = 32
                if (r1 == r2) goto L4b
                r2 = 35
                if (r1 == r2) goto L48
                r2 = 44
                if (r1 == r2) goto L4b
                r2 = 47
                if (r1 == r2) goto L48
                r2 = 61
                if (r1 == r2) goto L48
                r2 = 123(0x7b, float:1.72E-43)
                if (r1 == r2) goto L4b
                r2 = 125(0x7d, float:1.75E-43)
                if (r1 == r2) goto L4b
                r2 = 58
                if (r1 == r2) goto L4b
                r2 = 59
                if (r1 == r2) goto L48
                switch(r1) {
                    case 91: goto L4b;
                    case 92: goto L48;
                    case 93: goto L4b;
                    default: goto L45;
                }
            L45:
                int r0 = r0 + 1
                goto L1
            L48:
                r4.U()
            L4b:
                int r1 = r4.e
                int r1 = r1 + r0
                r4.e = r1
                return
            L51:
                int r1 = r1 + r0
                r4.e = r1
                r0 = 1
                boolean r0 = r4.x(r0)
                if (r0 != 0) goto L0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: b.a.a.d.f.S():void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int T() {
            return this.g + 1;
        }

        private void U() throws IOException {
            if (!this.f1022c) {
                throw u("Use JsonReader.setLenient(true) to accept malformed JSON");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int V() {
            return (this.e - this.h) + 1;
        }

        private void W() throws IOException {
            char c2;
            do {
                if (this.e >= this.f && !x(1)) {
                    return;
                }
                char[] cArr = this.f1023d;
                int i = this.e;
                int i2 = i + 1;
                this.e = i2;
                c2 = cArr[i];
                if (c2 == '\n') {
                    this.g++;
                    this.h = i2;
                    return;
                }
            } while (c2 != '\r');
        }

        private char X() throws IOException {
            int i;
            int i2;
            if (this.e != this.f || x(1)) {
                char[] cArr = this.f1023d;
                int i3 = this.e;
                int i4 = i3 + 1;
                this.e = i4;
                char c2 = cArr[i3];
                if (c2 == '\n') {
                    this.g++;
                    this.h = i4;
                } else if (c2 == 'b') {
                    return '\b';
                } else {
                    if (c2 == 'f') {
                        return '\f';
                    }
                    if (c2 == 'n') {
                        return '\n';
                    }
                    if (c2 == 'r') {
                        return '\r';
                    }
                    if (c2 == 't') {
                        return '\t';
                    }
                    if (c2 == 'u') {
                        if (i4 + 4 <= this.f || x(4)) {
                            char c3 = 0;
                            int i5 = this.e;
                            int i6 = i5 + 4;
                            while (i5 < i6) {
                                char c4 = this.f1023d[i5];
                                char c5 = (char) (c3 << 4);
                                if (c4 < '0' || c4 > '9') {
                                    if (c4 >= 'a' && c4 <= 'f') {
                                        i = c4 - 'a';
                                    } else if (c4 < 'A' || c4 > 'F') {
                                        throw new NumberFormatException("\\u" + new String(this.f1023d, this.e, 4));
                                    } else {
                                        i = c4 - 'A';
                                    }
                                    i2 = i + 10;
                                } else {
                                    i2 = c4 - '0';
                                }
                                c3 = (char) (c5 + i2);
                                i5++;
                            }
                            this.e += 4;
                            return c3;
                        }
                        throw u("Unterminated escape sequence");
                    }
                }
                return c2;
            }
            throw u("Unterminated escape sequence");
        }

        private void Y() throws IOException {
            t(true);
            int i = this.e - 1;
            this.e = i;
            char[] cArr = f1020a;
            if (i + cArr.length > this.f && !x(cArr.length)) {
                return;
            }
            int i2 = 0;
            while (true) {
                char[] cArr2 = f1020a;
                if (i2 >= cArr2.length) {
                    this.e += cArr2.length;
                    return;
                } else if (this.f1023d[this.e + i2] != cArr2[i2]) {
                    return;
                } else {
                    i2++;
                }
            }
        }

        private void o(int i) {
            int i2 = this.n;
            int[] iArr = this.m;
            if (i2 == iArr.length) {
                int[] iArr2 = new int[i2 * 2];
                System.arraycopy(iArr, 0, iArr2, 0, i2);
                this.m = iArr2;
            }
            int[] iArr3 = this.m;
            int i3 = this.n;
            this.n = i3 + 1;
            iArr3[i3] = i;
        }

        private boolean q(char c2) throws IOException {
            if (c2 == '\t' || c2 == '\n' || c2 == '\f' || c2 == '\r' || c2 == ' ') {
                return false;
            }
            if (c2 != '#') {
                if (c2 == ',') {
                    return false;
                }
                if (c2 != '/' && c2 != '=') {
                    if (c2 == '{' || c2 == '}' || c2 == ':') {
                        return false;
                    }
                    if (c2 != ';') {
                        switch (c2) {
                            case R.styleable.AppCompatTheme_switchStyle /* 91 */:
                            case R.styleable.AppCompatTheme_textAppearanceListItem /* 93 */:
                                return false;
                            case R.styleable.AppCompatTheme_textAppearanceLargePopupMenu /* 92 */:
                                break;
                            default:
                                return true;
                        }
                    }
                }
            }
            U();
            return false;
        }

        private boolean r(String str) throws IOException {
            while (true) {
                if (this.e + str.length() > this.f && !x(str.length())) {
                    return false;
                }
                char[] cArr = this.f1023d;
                int i = this.e;
                if (cArr[i] != '\n') {
                    for (int i2 = 0; i2 < str.length(); i2++) {
                        if (this.f1023d[this.e + i2] != str.charAt(i2)) {
                            break;
                        }
                    }
                    return true;
                }
                this.g++;
                this.h = i + 1;
                this.e++;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x005f, code lost:
            if (r1 != '/') goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0061, code lost:
            r7.e = r4;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0064, code lost:
            if (r4 != r2) goto L35;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0066, code lost:
            r7.e = r4 - 1;
            r2 = x(2);
            r7.e++;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0073, code lost:
            if (r2 != false) goto L35;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0075, code lost:
            return r1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0076, code lost:
            U();
            r2 = r7.e;
            r3 = r0[r2];
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x007f, code lost:
            if (r3 == '*') goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0081, code lost:
            if (r3 == '/') goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0083, code lost:
            return r1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0084, code lost:
            r7.e = r2 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x008d, code lost:
            r7.e = r2 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0097, code lost:
            if (r("*\/") == false) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00a4, code lost:
            throw u("Unterminated comment");
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x00a5, code lost:
            r7.e = r4;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x00a9, code lost:
            if (r1 != '#') goto L55;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x00ab, code lost:
            U();
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00af, code lost:
            return r1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private int t(boolean r8) throws java.io.IOException {
            /*
                r7 = this;
                char[] r0 = r7.f1023d
            L2:
                int r1 = r7.e
            L4:
                int r2 = r7.f
            L6:
                r3 = 1
                if (r1 != r2) goto L40
                r7.e = r1
                boolean r1 = r7.x(r3)
                if (r1 != 0) goto L3c
                if (r8 != 0) goto L15
                r8 = -1
                return r8
            L15:
                java.io.EOFException r8 = new java.io.EOFException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "End of input at line "
                r0.append(r1)
                int r1 = r7.T()
                r0.append(r1)
                java.lang.String r1 = " column "
                r0.append(r1)
                int r1 = r7.V()
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r8.<init>(r0)
                throw r8
            L3c:
                int r1 = r7.e
                int r2 = r7.f
            L40:
                int r4 = r1 + 1
                char r1 = r0[r1]
                r5 = 10
                if (r1 != r5) goto L50
                int r1 = r7.g
                int r1 = r1 + r3
                r7.g = r1
                r7.h = r4
                goto Lb0
            L50:
                r5 = 32
                if (r1 == r5) goto Lb0
                r5 = 13
                if (r1 == r5) goto Lb0
                r5 = 9
                if (r1 != r5) goto L5d
                goto Lb0
            L5d:
                r5 = 47
                if (r1 != r5) goto La5
                r7.e = r4
                r6 = 2
                if (r4 != r2) goto L76
                int r4 = r4 + (-1)
                r7.e = r4
                boolean r2 = r7.x(r6)
                int r4 = r7.e
                int r4 = r4 + r3
                r7.e = r4
                if (r2 != 0) goto L76
                return r1
            L76:
                r7.U()
                int r2 = r7.e
                char r3 = r0[r2]
                r4 = 42
                if (r3 == r4) goto L8d
                if (r3 == r5) goto L84
                return r1
            L84:
                int r2 = r2 + 1
                r7.e = r2
            L88:
                r7.W()
                goto L2
            L8d:
                int r2 = r2 + 1
                r7.e = r2
            */
            //  java.lang.String r1 = "*/"
            /*
                boolean r1 = r7.r(r1)
                if (r1 == 0) goto L9e
                int r1 = r7.e
                int r1 = r1 + r6
                goto L4
            L9e:
                java.lang.String r8 = "Unterminated comment"
                java.io.IOException r8 = r7.u(r8)
                throw r8
            La5:
                r2 = 35
                r7.e = r4
                if (r1 != r2) goto Laf
                r7.U()
                goto L88
            Laf:
                return r1
            Lb0:
                r1 = r4
                goto L6
            */
            throw new UnsupportedOperationException("Method not decompiled: b.a.a.d.f.t(boolean):int");
        }

        private IOException u(String str) throws IOException {
            throw new i(str + " at line " + T() + " column " + V());
        }

        private String v(char c2) throws IOException {
            char[] cArr = this.f1023d;
            StringBuilder sb = new StringBuilder();
            while (true) {
                int i = this.e;
                int i2 = this.f;
                while (true) {
                    if (i < i2) {
                        int i3 = i + 1;
                        char c3 = cArr[i];
                        if (c3 == c2) {
                            this.e = i3;
                            sb.append(cArr, i, (i3 - i) - 1);
                            return sb.toString();
                        } else if (c3 == '\\') {
                            this.e = i3;
                            sb.append(cArr, i, (i3 - i) - 1);
                            sb.append(X());
                            break;
                        } else {
                            if (c3 == '\n') {
                                this.g++;
                                this.h = i3;
                            }
                            i = i3;
                        }
                    } else {
                        sb.append(cArr, i, i - i);
                        this.e = i;
                        if (!x(1)) {
                            throw u("Unterminated string");
                        }
                    }
                }
            }
        }

        private boolean x(int i) throws IOException {
            int i2;
            int i3;
            char[] cArr = this.f1023d;
            int i4 = this.h;
            int i5 = this.e;
            this.h = i4 - i5;
            int i6 = this.f;
            if (i6 != i5) {
                int i7 = i6 - i5;
                this.f = i7;
                System.arraycopy(cArr, i5, cArr, 0, i7);
            } else {
                this.f = 0;
            }
            this.e = 0;
            do {
                Reader reader = this.f1021b;
                int i8 = this.f;
                int read = reader.read(cArr, i8, cArr.length - i8);
                if (read == -1) {
                    return false;
                }
                i2 = this.f + read;
                this.f = i2;
                if (this.g == 0 && (i3 = this.h) == 0 && i2 > 0 && cArr[0] == 65279) {
                    this.e++;
                    this.h = i3 + 1;
                    i++;
                    continue;
                }
            } while (i2 < i);
            return true;
        }

        public void B() throws IOException {
            int i = this.i;
            if (i == 0) {
                i = O();
            }
            if (i == 1) {
                o(3);
                this.i = 0;
                return;
            }
            throw new IllegalStateException("Expected BEGIN_OBJECT but was " + E() + " at line " + T() + " column " + V());
        }

        public boolean D() throws IOException {
            int i = this.i;
            if (i == 0) {
                i = O();
            }
            return (i == 2 || i == 4) ? false : true;
        }

        public g E() throws IOException {
            int i = this.i;
            if (i == 0) {
                i = O();
            }
            switch (i) {
                case 1:
                    return g.BEGIN_OBJECT;
                case 2:
                    return g.END_OBJECT;
                case 3:
                    return g.BEGIN_ARRAY;
                case 4:
                    return g.END_ARRAY;
                case 5:
                case 6:
                    return g.BOOLEAN;
                case 7:
                    return g.NULL;
                case 8:
                case 9:
                case 10:
                case 11:
                    return g.STRING;
                case 12:
                case 13:
                case 14:
                    return g.NAME;
                case 15:
                case 16:
                    return g.NUMBER;
                case 17:
                    return g.END_DOCUMENT;
                default:
                    throw new AssertionError();
            }
        }

        public String F() throws IOException {
            char c2;
            String v;
            int i = this.i;
            if (i == 0) {
                i = O();
            }
            if (i == 14) {
                v = Q();
            } else {
                if (i == 12) {
                    c2 = '\'';
                } else if (i != 13) {
                    throw new IllegalStateException("Expected a name but was " + E() + " at line " + T() + " column " + V());
                } else {
                    c2 = '\"';
                }
                v = v(c2);
            }
            this.i = 0;
            return v;
        }

        public String G() throws IOException {
            String str;
            char c2;
            int i = this.i;
            if (i == 0) {
                i = O();
            }
            if (i == 10) {
                str = Q();
            } else {
                if (i == 8) {
                    c2 = '\'';
                } else if (i == 9) {
                    c2 = '\"';
                } else if (i == 11) {
                    str = this.l;
                    this.l = null;
                } else if (i == 15) {
                    str = Long.toString(this.j);
                } else if (i != 16) {
                    throw new IllegalStateException("Expected a string but was " + E() + " at line " + T() + " column " + V());
                } else {
                    str = new String(this.f1023d, this.e, this.k);
                    this.e += this.k;
                }
                str = v(c2);
            }
            this.i = 0;
            return str;
        }

        public void H() throws IOException {
            int i = this.i;
            if (i == 0) {
                i = O();
            }
            if (i == 7) {
                this.i = 0;
                return;
            }
            throw new IllegalStateException("Expected null but was " + E() + " at line " + T() + " column " + V());
        }

        public boolean I() throws IOException {
            int i = this.i;
            if (i == 0) {
                i = O();
            }
            if (i == 5) {
                this.i = 0;
                return true;
            } else if (i == 6) {
                this.i = 0;
                return false;
            } else {
                throw new IllegalStateException("Expected a boolean but was " + E() + " at line " + T() + " column " + V());
            }
        }

        public double J() throws IOException {
            String v;
            int i = this.i;
            if (i == 0) {
                i = O();
            }
            if (i == 15) {
                this.i = 0;
                return this.j;
            }
            if (i == 16) {
                this.l = new String(this.f1023d, this.e, this.k);
                this.e += this.k;
            } else {
                if (i == 8 || i == 9) {
                    v = v(i == 8 ? '\'' : '\"');
                } else if (i == 10) {
                    v = Q();
                } else if (i != 11) {
                    throw new IllegalStateException("Expected a double but was " + E() + " at line " + T() + " column " + V());
                }
                this.l = v;
            }
            this.i = 11;
            double parseDouble = Double.parseDouble(this.l);
            if (this.f1022c || !(Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
                this.l = null;
                this.i = 0;
                return parseDouble;
            }
            throw new i("JSON forbids NaN and infinities: " + parseDouble + " at line " + T() + " column " + V());
        }

        public long K() throws IOException {
            int i = this.i;
            if (i == 0) {
                i = O();
            }
            if (i == 15) {
                this.i = 0;
                return this.j;
            }
            if (i == 16) {
                this.l = new String(this.f1023d, this.e, this.k);
                this.e += this.k;
            } else if (i != 8 && i != 9) {
                throw new IllegalStateException("Expected a long but was " + E() + " at line " + T() + " column " + V());
            } else {
                String v = v(i == 8 ? '\'' : '\"');
                this.l = v;
                try {
                    long parseLong = Long.parseLong(v);
                    this.i = 0;
                    return parseLong;
                } catch (NumberFormatException unused) {
                }
            }
            this.i = 11;
            double parseDouble = Double.parseDouble(this.l);
            long j = (long) parseDouble;
            if (j == parseDouble) {
                this.l = null;
                this.i = 0;
                return j;
            }
            throw new NumberFormatException("Expected a long but was " + this.l + " at line " + T() + " column " + V());
        }

        public void M() throws IOException {
            char c2;
            int i = 0;
            do {
                int i2 = this.i;
                if (i2 == 0) {
                    i2 = O();
                }
                if (i2 == 3) {
                    o(1);
                } else if (i2 == 1) {
                    o(3);
                } else {
                    if (i2 == 4 || i2 == 2) {
                        this.n--;
                        i--;
                    } else if (i2 == 14 || i2 == 10) {
                        S();
                    } else {
                        if (i2 == 8 || i2 == 12) {
                            c2 = '\'';
                        } else if (i2 == 9 || i2 == 13) {
                            c2 = '\"';
                        } else if (i2 == 16) {
                            this.e += this.k;
                        }
                        C(c2);
                    }
                    this.i = 0;
                }
                i++;
                this.i = 0;
            } while (i != 0);
        }

        public int N() throws IOException {
            int i = this.i;
            if (i == 0) {
                i = O();
            }
            if (i == 15) {
                long j = this.j;
                int i2 = (int) j;
                if (j == i2) {
                    this.i = 0;
                    return i2;
                }
                throw new NumberFormatException("Expected an int but was " + this.j + " at line " + T() + " column " + V());
            }
            if (i == 16) {
                this.l = new String(this.f1023d, this.e, this.k);
                this.e += this.k;
            } else if (i != 8 && i != 9) {
                throw new IllegalStateException("Expected an int but was " + E() + " at line " + T() + " column " + V());
            } else {
                String v = v(i == 8 ? '\'' : '\"');
                this.l = v;
                try {
                    int parseInt = Integer.parseInt(v);
                    this.i = 0;
                    return parseInt;
                } catch (NumberFormatException unused) {
                }
            }
            this.i = 11;
            double parseDouble = Double.parseDouble(this.l);
            int i3 = (int) parseDouble;
            if (i3 == parseDouble) {
                this.l = null;
                this.i = 0;
                return i3;
            }
            throw new NumberFormatException("Expected an int but was " + this.l + " at line " + T() + " column " + V());
        }

        public final boolean P() {
            return this.f1022c;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.i = 0;
            this.m[0] = 8;
            this.n = 1;
            this.f1021b.close();
        }

        public void n() throws IOException {
            int i = this.i;
            if (i == 0) {
                i = O();
            }
            if (i == 3) {
                o(1);
                this.i = 0;
                return;
            }
            throw new IllegalStateException("Expected BEGIN_ARRAY but was " + E() + " at line " + T() + " column " + V());
        }

        public final void p(boolean z) {
            this.f1022c = z;
        }

        public String toString() {
            return getClass().getSimpleName() + " at line " + T() + " column " + V();
        }

        public void w() throws IOException {
            int i = this.i;
            if (i == 0) {
                i = O();
            }
            if (i == 4) {
                this.n--;
                this.i = 0;
                return;
            }
            throw new IllegalStateException("Expected END_ARRAY but was " + E() + " at line " + T() + " column " + V());
        }

        public void z() throws IOException {
            int i = this.i;
            if (i == 0) {
                i = O();
            }
            if (i == 2) {
                this.n--;
                this.i = 0;
                return;
            }
            throw new IllegalStateException("Expected END_OBJECT but was " + E() + " at line " + T() + " column " + V());
        }
    }

    /* compiled from: JsonToken.java */
    /* loaded from: classes.dex */
    public enum g {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

    /* compiled from: JsonWriter.java */
    /* loaded from: classes.dex */
    public class h implements Closeable, Flushable {

        /* renamed from: a  reason: collision with root package name */
        private static final String[] f1025a = new String[128];

        /* renamed from: b  reason: collision with root package name */
        private static final String[] f1026b;

        /* renamed from: c  reason: collision with root package name */
        private final Writer f1027c;

        /* renamed from: d  reason: collision with root package name */
        private int[] f1028d = new int[32];
        private int e = 0;
        private String f;
        private String g;
        private boolean h;
        private boolean i;
        private String j;
        private boolean k;

        static {
            for (int i = 0; i <= 31; i++) {
                f1025a[i] = String.format("\\u%04x", Integer.valueOf(i));
            }
            String[] strArr = f1025a;
            strArr[34] = "\\\"";
            strArr[92] = "\\\\";
            strArr[9] = "\\t";
            strArr[8] = "\\b";
            strArr[10] = "\\n";
            strArr[13] = "\\r";
            strArr[12] = "\\f";
            String[] strArr2 = (String[]) strArr.clone();
            f1026b = strArr2;
            strArr2[60] = "\\u003c";
            strArr2[62] = "\\u003e";
            strArr2[38] = "\\u0026";
            strArr2[61] = "\\u003d";
            strArr2[39] = "\\u0027";
        }

        public h(Writer writer) {
            s(6);
            this.g = ":";
            this.k = true;
            Objects.requireNonNull(writer, "out == null");
            this.f1027c = writer;
        }

        private void E(boolean z) throws IOException {
            int g = g();
            if (g == 1) {
                v(2);
            } else if (g != 2) {
                if (g == 4) {
                    this.f1027c.append((CharSequence) this.g);
                    v(5);
                    return;
                }
                if (g != 6) {
                    if (g != 7) {
                        throw new IllegalStateException("Nesting problem.");
                    }
                    if (!this.h) {
                        throw new IllegalStateException("JSON must have only one top-level value.");
                    }
                }
                if (!this.h && !z) {
                    throw new IllegalStateException("JSON must start with an array or an object.");
                }
                v(7);
                return;
            } else {
                this.f1027c.append(',');
            }
            K();
        }

        private void I() throws IOException {
            if (this.j != null) {
                L();
                y(this.j);
                this.j = null;
            }
        }

        private void K() throws IOException {
            if (this.f == null) {
                return;
            }
            this.f1027c.write("\n");
            int i = this.e;
            for (int i2 = 1; i2 < i; i2++) {
                this.f1027c.write(this.f);
            }
        }

        private void L() throws IOException {
            int g = g();
            if (g == 5) {
                this.f1027c.write(44);
            } else if (g != 3) {
                throw new IllegalStateException("Nesting problem.");
            }
            K();
            v(4);
        }

        private int g() {
            int i = this.e;
            if (i != 0) {
                return this.f1028d[i - 1];
            }
            throw new IllegalStateException("JsonWriter is closed.");
        }

        private h h(int i, int i2, String str) throws IOException {
            int g = g();
            if (g == i2 || g == i) {
                if (this.j != null) {
                    throw new IllegalStateException("Dangling name: " + this.j);
                }
                this.e--;
                if (g == i2) {
                    K();
                }
                this.f1027c.write(str);
                return this;
            }
            throw new IllegalStateException("Nesting problem.");
        }

        private h n(int i, String str) throws IOException {
            E(true);
            s(i);
            this.f1027c.write(str);
            return this;
        }

        private void s(int i) {
            int i2 = this.e;
            int[] iArr = this.f1028d;
            if (i2 == iArr.length) {
                int[] iArr2 = new int[i2 * 2];
                System.arraycopy(iArr, 0, iArr2, 0, i2);
                this.f1028d = iArr2;
            }
            int[] iArr3 = this.f1028d;
            int i3 = this.e;
            this.e = i3 + 1;
            iArr3[i3] = i;
        }

        private void v(int i) {
            this.f1028d[this.e - 1] = i;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0034  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void y(java.lang.String r9) throws java.io.IOException {
            /*
                r8 = this;
                boolean r0 = r8.i
                if (r0 == 0) goto L7
                java.lang.String[] r0 = b.a.a.d.h.f1026b
                goto L9
            L7:
                java.lang.String[] r0 = b.a.a.d.h.f1025a
            L9:
                java.io.Writer r1 = r8.f1027c
                java.lang.String r2 = "\""
                r1.write(r2)
                int r1 = r9.length()
                r3 = 0
                r4 = r3
            L16:
                if (r3 >= r1) goto L45
                char r5 = r9.charAt(r3)
                r6 = 128(0x80, float:1.794E-43)
                if (r5 >= r6) goto L25
                r5 = r0[r5]
                if (r5 != 0) goto L32
                goto L42
            L25:
                r6 = 8232(0x2028, float:1.1535E-41)
                if (r5 != r6) goto L2c
                java.lang.String r5 = "\\u2028"
                goto L32
            L2c:
                r6 = 8233(0x2029, float:1.1537E-41)
                if (r5 != r6) goto L42
                java.lang.String r5 = "\\u2029"
            L32:
                if (r4 >= r3) goto L3b
                java.io.Writer r6 = r8.f1027c
                int r7 = r3 - r4
                r6.write(r9, r4, r7)
            L3b:
                java.io.Writer r4 = r8.f1027c
                r4.write(r5)
                int r4 = r3 + 1
            L42:
                int r3 = r3 + 1
                goto L16
            L45:
                if (r4 >= r1) goto L4d
                java.io.Writer r0 = r8.f1027c
                int r1 = r1 - r4
                r0.write(r9, r4, r1)
            L4d:
                java.io.Writer r9 = r8.f1027c
                r9.write(r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: b.a.a.d.h.y(java.lang.String):void");
        }

        public h A() throws IOException {
            return h(1, 2, "]");
        }

        public final void B(String str) {
            String str2;
            if (str.length() == 0) {
                this.f = null;
                str2 = ":";
            } else {
                this.f = str;
                str2 = ": ";
            }
            this.g = str2;
        }

        public final void C(boolean z) {
            this.i = z;
        }

        public h D() throws IOException {
            return h(3, 5, "}");
        }

        public h F() throws IOException {
            if (this.j != null) {
                if (!this.k) {
                    this.j = null;
                    return this;
                }
                I();
            }
            E(false);
            this.f1027c.write("null");
            return this;
        }

        public boolean G() {
            return this.h;
        }

        public final boolean H() {
            return this.i;
        }

        public final boolean J() {
            return this.k;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f1027c.close();
            int i = this.e;
            if (i > 1 || (i == 1 && this.f1028d[i - 1] != 7)) {
                throw new IOException("Incomplete document");
            }
            this.e = 0;
        }

        public void flush() throws IOException {
            if (this.e == 0) {
                throw new IllegalStateException("JsonWriter is closed.");
            }
            this.f1027c.flush();
        }

        public h o(long j) throws IOException {
            I();
            E(false);
            this.f1027c.write(Long.toString(j));
            return this;
        }

        public h p(Number number) throws IOException {
            if (number == null) {
                return F();
            }
            I();
            String obj = number.toString();
            if (this.h || !(obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
                E(false);
                this.f1027c.append((CharSequence) obj);
                return this;
            }
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }

        public h q(String str) throws IOException {
            Objects.requireNonNull(str, "name == null");
            if (this.j == null) {
                if (this.e != 0) {
                    this.j = str;
                    return this;
                }
                throw new IllegalStateException("JsonWriter is closed.");
            }
            throw new IllegalStateException();
        }

        public h r(boolean z) throws IOException {
            I();
            E(false);
            this.f1027c.write(z ? "true" : "false");
            return this;
        }

        public h t() throws IOException {
            I();
            return n(1, "[");
        }

        public h u(String str) throws IOException {
            if (str == null) {
                return F();
            }
            I();
            E(false);
            y(str);
            return this;
        }

        public final void w(boolean z) {
            this.h = z;
        }

        public h x() throws IOException {
            I();
            return n(3, "{");
        }

        public final void z(boolean z) {
            this.k = z;
        }
    }

    /* compiled from: MalformedJsonException.java */
    /* loaded from: classes.dex */
    public final class i extends IOException {
        public i(String str) {
            super(str);
        }
    }

    static {
        a aVar = new a("IDENTITY", 0);
        O000000o = aVar;
        d dVar = new d("UPPER_CAMEL_CASE", 1) { // from class: b.a.a.d.b
            @Override // b.a.a.d, b.a.a.g
            public String O000000o(Field field) {
                return d.d(field.getName());
            }
        };
        O00000Oo = dVar;
        d dVar2 = new d("UPPER_CAMEL_CASE_WITH_SPACES", 2) { // from class: b.a.a.d.c
            @Override // b.a.a.d, b.a.a.g
            public String O000000o(Field field) {
                return d.d(d.e(field.getName(), " "));
            }
        };
        O00000o0 = dVar2;
        d dVar3 = new d("LOWER_CASE_WITH_UNDERSCORES", 3) { // from class: b.a.a.d.d
            @Override // b.a.a.d, b.a.a.g
            public String O000000o(Field field) {
                return d.e(field.getName(), "_").toLowerCase();
            }
        };
        O00000o = dVar3;
        d dVar4 = new d("LOWER_CASE_WITH_DASHES", 4) { // from class: b.a.a.d.e
            @Override // b.a.a.d, b.a.a.g
            public String O000000o(Field field) {
                return d.e(field.getName(), "-").toLowerCase();
            }
        };
        O00000oO = dVar4;
        f1019a = new d[]{aVar, dVar, dVar2, dVar3, dVar4};
    }

    private d(String str, int i2) {
    }

    /* synthetic */ d(String str, int i2, a aVar) {
        this(str, i2);
    }

    private static String a(char c2, String str, int i2) {
        if (i2 < str.length()) {
            return c2 + str.substring(i2);
        }
        return String.valueOf(c2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(String str) {
        char charAt;
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (true) {
            charAt = str.charAt(i2);
            if (i2 >= str.length() - 1 || Character.isLetter(charAt)) {
                break;
            }
            sb.append(charAt);
            i2++;
        }
        if (i2 == str.length()) {
            return sb.toString();
        }
        if (Character.isUpperCase(charAt)) {
            return str;
        }
        sb.append(a(Character.toUpperCase(charAt), str, i2 + 1));
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String e(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (Character.isUpperCase(charAt) && sb.length() != 0) {
                sb.append(str2);
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) f1019a.clone();
    }

    @Override // b.a.a.g
    public abstract /* synthetic */ String O000000o(Field field);
}
