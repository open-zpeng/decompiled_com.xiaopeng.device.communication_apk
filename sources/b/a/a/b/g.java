package b.a.a.b;

import java.math.BigDecimal;
/* compiled from: LazilyParsedNumber.java */
/* loaded from: classes.dex */
public final class g extends Number {

    /* renamed from: a  reason: collision with root package name */
    private final String f994a;

    public g(String str) {
        this.f994a = str;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.f994a);
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.f994a);
    }

    @Override // java.lang.Number
    public int intValue() {
        try {
            try {
                return Integer.parseInt(this.f994a);
            } catch (NumberFormatException unused) {
                return (int) Long.parseLong(this.f994a);
            }
        } catch (NumberFormatException unused2) {
            return new BigDecimal(this.f994a).intValue();
        }
    }

    @Override // java.lang.Number
    public long longValue() {
        try {
            return Long.parseLong(this.f994a);
        } catch (NumberFormatException unused) {
            return new BigDecimal(this.f994a).longValue();
        }
    }

    public String toString() {
        return this.f994a;
    }
}
