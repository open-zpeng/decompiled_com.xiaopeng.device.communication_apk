package a.b.b.a;

import android.graphics.Path;
import android.util.Log;
import com.xiaopeng.lib.framework.carcontrollermodule.R;
import java.util.ArrayList;
/* compiled from: PathParser.java */
/* loaded from: classes.dex */
class c {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PathParser.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        int f193a;

        /* renamed from: b  reason: collision with root package name */
        boolean f194b;

        private b() {
        }
    }

    private static void b(ArrayList<C0006c> arrayList, char c2, float[] fArr) {
        arrayList.add(new C0006c(c2, fArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float[] c(float[] fArr, int i, int i2) {
        if (i <= i2) {
            int length = fArr.length;
            if (i >= 0 && i <= length) {
                int i3 = i2 - i;
                int min = Math.min(i3, length - i);
                float[] fArr2 = new float[i3];
                System.arraycopy(fArr, i, fArr2, 0, min);
                return fArr2;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
        throw new IllegalArgumentException();
    }

    public static C0006c[] d(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i2 = 0;
        while (i < str.length()) {
            int h = h(str, i);
            String trim = str.substring(i2, h).trim();
            if (trim.length() > 0) {
                b(arrayList, trim.charAt(0), g(trim));
            }
            i2 = h;
            i = h + 1;
        }
        if (i - i2 == 1 && i2 < str.length()) {
            b(arrayList, str.charAt(i2), new float[0]);
        }
        return (C0006c[]) arrayList.toArray(new C0006c[arrayList.size()]);
    }

    public static C0006c[] e(C0006c[] c0006cArr) {
        if (c0006cArr == null) {
            return null;
        }
        C0006c[] c0006cArr2 = new C0006c[c0006cArr.length];
        for (int i = 0; i < c0006cArr.length; i++) {
            c0006cArr2[i] = new C0006c(c0006cArr[i]);
        }
        return c0006cArr2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003a A[LOOP:0: B:3:0x0007->B:24:0x003a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void f(java.lang.String r8, int r9, a.b.b.a.c.b r10) {
        /*
            r0 = 0
            r10.f194b = r0
            r1 = r9
            r2 = r0
            r3 = r2
            r4 = r3
        L7:
            int r5 = r8.length()
            if (r1 >= r5) goto L3d
            char r5 = r8.charAt(r1)
            r6 = 32
            r7 = 1
            if (r5 == r6) goto L35
            r6 = 69
            if (r5 == r6) goto L33
            r6 = 101(0x65, float:1.42E-43)
            if (r5 == r6) goto L33
            switch(r5) {
                case 44: goto L35;
                case 45: goto L2a;
                case 46: goto L22;
                default: goto L21;
            }
        L21:
            goto L31
        L22:
            if (r3 != 0) goto L27
            r2 = r0
            r3 = r7
            goto L37
        L27:
            r10.f194b = r7
            goto L35
        L2a:
            if (r1 == r9) goto L31
            if (r2 != 0) goto L31
            r10.f194b = r7
            goto L35
        L31:
            r2 = r0
            goto L37
        L33:
            r2 = r7
            goto L37
        L35:
            r2 = r0
            r4 = r7
        L37:
            if (r4 == 0) goto L3a
            goto L3d
        L3a:
            int r1 = r1 + 1
            goto L7
        L3d:
            r10.f193a = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.b.a.c.f(java.lang.String, int, a.b.b.a.c$b):void");
    }

    private static float[] g(String str) {
        int i = 1;
        if ((str.charAt(0) == 'z') || (str.charAt(0) == 'Z')) {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            b bVar = new b();
            int length = str.length();
            int i2 = 0;
            while (i < length) {
                f(str, i, bVar);
                int i3 = bVar.f193a;
                if (i < i3) {
                    fArr[i2] = Float.parseFloat(str.substring(i, i3));
                    i2++;
                }
                i = bVar.f194b ? i3 : i3 + 1;
            }
            return c(fArr, 0, i2);
        } catch (NumberFormatException e) {
            throw new RuntimeException("error in parsing \"" + str + "\"", e);
        }
    }

    private static int h(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (((charAt - 'A') * (charAt - 'Z') <= 0 || (charAt - 'a') * (charAt - 'z') <= 0) && charAt != 'e' && charAt != 'E') {
                return i;
            }
            i++;
        }
        return i;
    }

    /* compiled from: PathParser.java */
    /* renamed from: a.b.b.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0006c {

        /* renamed from: a  reason: collision with root package name */
        char f195a;

        /* renamed from: b  reason: collision with root package name */
        float[] f196b;

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        private static void a(Path path, float[] fArr, char c2, char c3, float[] fArr2) {
            int i;
            int i2;
            int i3;
            float f;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            char c4 = c3;
            char c5 = 0;
            float f9 = fArr[0];
            float f10 = fArr[1];
            float f11 = fArr[2];
            float f12 = fArr[3];
            float f13 = fArr[4];
            float f14 = fArr[5];
            switch (c4) {
                case R.styleable.AppCompatTheme_editTextStyle /* 65 */:
                case R.styleable.AppCompatTheme_textAppearanceSmallPopupMenu /* 97 */:
                    i = 7;
                    i2 = i;
                    break;
                case R.styleable.AppCompatTheme_imageButtonStyle /* 67 */:
                case 'c':
                    i = 6;
                    i2 = i;
                    break;
                case R.styleable.AppCompatTheme_listPreferredItemHeightLarge /* 72 */:
                case R.styleable.AppCompatTheme_seekBarStyle /* 86 */:
                case R.styleable.AppCompatTheme_windowActionModeOverlay /* 104 */:
                case 'v':
                    i2 = 1;
                    break;
                case R.styleable.AppCompatTheme_panelBackground /* 76 */:
                case R.styleable.AppCompatTheme_panelMenuListTheme /* 77 */:
                case R.styleable.AppCompatTheme_ratingBarStyleSmall /* 84 */:
                case R.styleable.AppCompatTheme_windowFixedWidthMinor /* 108 */:
                case R.styleable.AppCompatTheme_windowMinWidthMajor /* 109 */:
                case 't':
                default:
                    i2 = 2;
                    break;
                case R.styleable.AppCompatTheme_radioButtonStyle /* 81 */:
                case R.styleable.AppCompatTheme_ratingBarStyleIndicator /* 83 */:
                case 'q':
                case 's':
                    i2 = 4;
                    break;
                case R.styleable.AppCompatTheme_spinnerStyle /* 90 */:
                case 'z':
                    path.close();
                    path.moveTo(f13, f14);
                    f9 = f13;
                    f11 = f9;
                    f10 = f14;
                    f12 = f10;
                    i2 = 2;
                    break;
            }
            float f15 = f9;
            float f16 = f10;
            float f17 = f13;
            float f18 = f14;
            int i4 = 0;
            char c6 = c2;
            while (i4 < fArr2.length) {
                if (c4 != 'A') {
                    if (c4 == 'C') {
                        i3 = i4;
                        int i5 = i3 + 2;
                        int i6 = i3 + 3;
                        int i7 = i3 + 4;
                        int i8 = i3 + 5;
                        path.cubicTo(fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i5], fArr2[i6], fArr2[i7], fArr2[i8]);
                        f15 = fArr2[i7];
                        float f19 = fArr2[i8];
                        float f20 = fArr2[i5];
                        float f21 = fArr2[i6];
                        f16 = f19;
                        f12 = f21;
                        f11 = f20;
                    } else if (c4 == 'H') {
                        i3 = i4;
                        int i9 = i3 + 0;
                        path.lineTo(fArr2[i9], f16);
                        f15 = fArr2[i9];
                    } else if (c4 == 'Q') {
                        i3 = i4;
                        int i10 = i3 + 0;
                        int i11 = i3 + 1;
                        int i12 = i3 + 2;
                        int i13 = i3 + 3;
                        path.quadTo(fArr2[i10], fArr2[i11], fArr2[i12], fArr2[i13]);
                        float f22 = fArr2[i10];
                        float f23 = fArr2[i11];
                        f15 = fArr2[i12];
                        f16 = fArr2[i13];
                        f11 = f22;
                        f12 = f23;
                    } else if (c4 == 'V') {
                        i3 = i4;
                        int i14 = i3 + 0;
                        path.lineTo(f15, fArr2[i14]);
                        f16 = fArr2[i14];
                    } else if (c4 != 'a') {
                        if (c4 != 'c') {
                            if (c4 == 'h') {
                                int i15 = i4 + 0;
                                path.rLineTo(fArr2[i15], 0.0f);
                                f15 += fArr2[i15];
                            } else if (c4 != 'q') {
                                if (c4 == 'v') {
                                    int i16 = i4 + 0;
                                    path.rLineTo(0.0f, fArr2[i16]);
                                    f4 = fArr2[i16];
                                } else if (c4 == 'L') {
                                    int i17 = i4 + 0;
                                    int i18 = i4 + 1;
                                    path.lineTo(fArr2[i17], fArr2[i18]);
                                    f15 = fArr2[i17];
                                    f16 = fArr2[i18];
                                } else if (c4 == 'M') {
                                    int i19 = i4 + 0;
                                    f15 = fArr2[i19];
                                    int i20 = i4 + 1;
                                    f16 = fArr2[i20];
                                    if (i4 > 0) {
                                        path.lineTo(fArr2[i19], fArr2[i20]);
                                    } else {
                                        path.moveTo(fArr2[i19], fArr2[i20]);
                                        i3 = i4;
                                        f18 = f16;
                                        f17 = f15;
                                    }
                                } else if (c4 == 'S') {
                                    if (c6 == 'c' || c6 == 's' || c6 == 'C' || c6 == 'S') {
                                        f15 = (f15 * 2.0f) - f11;
                                        f16 = (f16 * 2.0f) - f12;
                                    }
                                    float f24 = f16;
                                    int i21 = i4 + 0;
                                    int i22 = i4 + 1;
                                    int i23 = i4 + 2;
                                    int i24 = i4 + 3;
                                    path.cubicTo(f15, f24, fArr2[i21], fArr2[i22], fArr2[i23], fArr2[i24]);
                                    f = fArr2[i21];
                                    f2 = fArr2[i22];
                                    f15 = fArr2[i23];
                                    f16 = fArr2[i24];
                                    f11 = f;
                                    f12 = f2;
                                } else if (c4 == 'T') {
                                    if (c6 == 'q' || c6 == 't' || c6 == 'Q' || c6 == 'T') {
                                        f15 = (f15 * 2.0f) - f11;
                                        f16 = (f16 * 2.0f) - f12;
                                    }
                                    int i25 = i4 + 0;
                                    int i26 = i4 + 1;
                                    path.quadTo(f15, f16, fArr2[i25], fArr2[i26]);
                                    float f25 = fArr2[i25];
                                    float f26 = fArr2[i26];
                                    i3 = i4;
                                    f12 = f16;
                                    f11 = f15;
                                    f15 = f25;
                                    f16 = f26;
                                } else if (c4 == 'l') {
                                    int i27 = i4 + 0;
                                    int i28 = i4 + 1;
                                    path.rLineTo(fArr2[i27], fArr2[i28]);
                                    f15 += fArr2[i27];
                                    f4 = fArr2[i28];
                                } else if (c4 == 'm') {
                                    int i29 = i4 + 0;
                                    f15 += fArr2[i29];
                                    int i30 = i4 + 1;
                                    f16 += fArr2[i30];
                                    if (i4 > 0) {
                                        path.rLineTo(fArr2[i29], fArr2[i30]);
                                    } else {
                                        path.rMoveTo(fArr2[i29], fArr2[i30]);
                                        i3 = i4;
                                        f18 = f16;
                                        f17 = f15;
                                    }
                                } else if (c4 == 's') {
                                    if (c6 == 'c' || c6 == 's' || c6 == 'C' || c6 == 'S') {
                                        float f27 = f15 - f11;
                                        f5 = f16 - f12;
                                        f6 = f27;
                                    } else {
                                        f6 = 0.0f;
                                        f5 = 0.0f;
                                    }
                                    int i31 = i4 + 0;
                                    int i32 = i4 + 1;
                                    int i33 = i4 + 2;
                                    int i34 = i4 + 3;
                                    path.rCubicTo(f6, f5, fArr2[i31], fArr2[i32], fArr2[i33], fArr2[i34]);
                                    f = fArr2[i31] + f15;
                                    f2 = fArr2[i32] + f16;
                                    f15 += fArr2[i33];
                                    f3 = fArr2[i34];
                                } else if (c4 == 't') {
                                    if (c6 == 'q' || c6 == 't' || c6 == 'Q' || c6 == 'T') {
                                        f7 = f15 - f11;
                                        f8 = f16 - f12;
                                    } else {
                                        f8 = 0.0f;
                                        f7 = 0.0f;
                                    }
                                    int i35 = i4 + 0;
                                    int i36 = i4 + 1;
                                    path.rQuadTo(f7, f8, fArr2[i35], fArr2[i36]);
                                    float f28 = f7 + f15;
                                    float f29 = f8 + f16;
                                    f15 += fArr2[i35];
                                    f16 += fArr2[i36];
                                    f12 = f29;
                                    f11 = f28;
                                }
                                f16 += f4;
                            } else {
                                int i37 = i4 + 0;
                                int i38 = i4 + 1;
                                int i39 = i4 + 2;
                                int i40 = i4 + 3;
                                path.rQuadTo(fArr2[i37], fArr2[i38], fArr2[i39], fArr2[i40]);
                                f = fArr2[i37] + f15;
                                f2 = fArr2[i38] + f16;
                                f15 += fArr2[i39];
                                f3 = fArr2[i40];
                            }
                            i3 = i4;
                        } else {
                            int i41 = i4 + 2;
                            int i42 = i4 + 3;
                            int i43 = i4 + 4;
                            int i44 = i4 + 5;
                            path.rCubicTo(fArr2[i4 + 0], fArr2[i4 + 1], fArr2[i41], fArr2[i42], fArr2[i43], fArr2[i44]);
                            f = fArr2[i41] + f15;
                            f2 = fArr2[i42] + f16;
                            f15 += fArr2[i43];
                            f3 = fArr2[i44];
                        }
                        f16 += f3;
                        f11 = f;
                        f12 = f2;
                        i3 = i4;
                    } else {
                        int i45 = i4 + 5;
                        int i46 = i4 + 6;
                        i3 = i4;
                        c(path, f15, f16, fArr2[i45] + f15, fArr2[i46] + f16, fArr2[i4 + 0], fArr2[i4 + 1], fArr2[i4 + 2], fArr2[i4 + 3] != 0.0f, fArr2[i4 + 4] != 0.0f);
                        f15 += fArr2[i45];
                        f16 += fArr2[i46];
                    }
                    i4 = i3 + i2;
                    c6 = c3;
                    c4 = c6;
                    c5 = 0;
                } else {
                    i3 = i4;
                    int i47 = i3 + 5;
                    int i48 = i3 + 6;
                    c(path, f15, f16, fArr2[i47], fArr2[i48], fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i3 + 2], fArr2[i3 + 3] != 0.0f, fArr2[i3 + 4] != 0.0f);
                    f15 = fArr2[i47];
                    f16 = fArr2[i48];
                }
                f12 = f16;
                f11 = f15;
                i4 = i3 + i2;
                c6 = c3;
                c4 = c6;
                c5 = 0;
            }
            fArr[c5] = f15;
            fArr[1] = f16;
            fArr[2] = f11;
            fArr[3] = f12;
            fArr[4] = f17;
            fArr[5] = f18;
        }

        private static void b(Path path, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
            double d11 = d4;
            int ceil = (int) Math.ceil(Math.abs((d10 * 4.0d) / 3.141592653589793d));
            double cos = Math.cos(d8);
            double sin = Math.sin(d8);
            double cos2 = Math.cos(d9);
            double sin2 = Math.sin(d9);
            double d12 = -d11;
            double d13 = d12 * cos;
            double d14 = d5 * sin;
            double d15 = (d13 * sin2) - (d14 * cos2);
            double d16 = d12 * sin;
            double d17 = d5 * cos;
            double d18 = (sin2 * d16) + (cos2 * d17);
            double d19 = d10 / ceil;
            double d20 = d18;
            double d21 = d15;
            int i = 0;
            double d22 = d6;
            double d23 = d7;
            double d24 = d9;
            while (i < ceil) {
                double d25 = d24 + d19;
                double sin3 = Math.sin(d25);
                double cos3 = Math.cos(d25);
                double d26 = (d2 + ((d11 * cos) * cos3)) - (d14 * sin3);
                double d27 = d3 + (d11 * sin * cos3) + (d17 * sin3);
                double d28 = (d13 * sin3) - (d14 * cos3);
                double d29 = (sin3 * d16) + (cos3 * d17);
                double d30 = d25 - d24;
                double tan = Math.tan(d30 / 2.0d);
                double sin4 = (Math.sin(d30) * (Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d)) / 3.0d;
                double d31 = d22 + (d21 * sin4);
                path.cubicTo((float) d31, (float) (d23 + (d20 * sin4)), (float) (d26 - (sin4 * d28)), (float) (d27 - (sin4 * d29)), (float) d26, (float) d27);
                i++;
                d19 = d19;
                sin = sin;
                d23 = d27;
                d22 = d26;
                cos = cos;
                d24 = d25;
                d20 = d29;
                d21 = d28;
                ceil = ceil;
                d11 = d4;
            }
        }

        private static void c(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2) {
            double d2;
            double d3;
            double radians = Math.toRadians(f7);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d4 = f;
            double d5 = d4 * cos;
            double d6 = f2;
            double d7 = f5;
            double d8 = (d5 + (d6 * sin)) / d7;
            double d9 = f6;
            double d10 = (((-f) * sin) + (d6 * cos)) / d9;
            double d11 = f4;
            double d12 = ((f3 * cos) + (d11 * sin)) / d7;
            double d13 = (((-f3) * sin) + (d11 * cos)) / d9;
            double d14 = d8 - d12;
            double d15 = d10 - d13;
            double d16 = (d8 + d12) / 2.0d;
            double d17 = (d10 + d13) / 2.0d;
            double d18 = (d14 * d14) + (d15 * d15);
            if (d18 == 0.0d) {
                Log.w("PathParser", " Points are coincident");
                return;
            }
            double d19 = (1.0d / d18) - 0.25d;
            if (d19 < 0.0d) {
                Log.w("PathParser", "Points are too far apart " + d18);
                float sqrt = (float) (Math.sqrt(d18) / 1.99999d);
                c(path, f, f2, f3, f4, f5 * sqrt, f6 * sqrt, f7, z, z2);
                return;
            }
            double sqrt2 = Math.sqrt(d19);
            double d20 = d14 * sqrt2;
            double d21 = sqrt2 * d15;
            if (z == z2) {
                d2 = d16 - d21;
                d3 = d17 + d20;
            } else {
                d2 = d16 + d21;
                d3 = d17 - d20;
            }
            double atan2 = Math.atan2(d10 - d3, d8 - d2);
            double atan22 = Math.atan2(d13 - d3, d12 - d2) - atan2;
            int i = (atan22 > 0.0d ? 1 : (atan22 == 0.0d ? 0 : -1));
            if (z2 != (i >= 0)) {
                atan22 = i > 0 ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
            }
            double d22 = d2 * d7;
            double d23 = d3 * d9;
            b(path, (d22 * cos) - (d23 * sin), (d22 * sin) + (d23 * cos), d7, d9, d4, d6, radians, atan2, atan22);
        }

        public static void d(C0006c[] c0006cArr, Path path) {
            float[] fArr = new float[6];
            char c2 = 'm';
            for (int i = 0; i < c0006cArr.length; i++) {
                a(path, fArr, c2, c0006cArr[i].f195a, c0006cArr[i].f196b);
                c2 = c0006cArr[i].f195a;
            }
        }

        private C0006c(char c2, float[] fArr) {
            this.f195a = c2;
            this.f196b = fArr;
        }

        private C0006c(C0006c c0006c) {
            this.f195a = c0006c.f195a;
            float[] fArr = c0006c.f196b;
            this.f196b = c.c(fArr, 0, fArr.length);
        }
    }
}
