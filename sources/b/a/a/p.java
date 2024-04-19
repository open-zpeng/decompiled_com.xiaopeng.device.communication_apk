package b.a.a;

import b.a.a.b.b;
import java.math.BigInteger;
/* compiled from: JsonPrimitive.java */
/* loaded from: classes.dex */
public final class p extends v {

    /* renamed from: a  reason: collision with root package name */
    private static final Class<?>[] f1046a = {Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};

    /* renamed from: b  reason: collision with root package name */
    private Object f1047b;

    public p(Boolean bool) {
        h(bool);
    }

    public p(Number number) {
        h(number);
    }

    public p(String str) {
        h(str);
    }

    private static boolean i(p pVar) {
        Object obj = pVar.f1047b;
        if (obj instanceof Number) {
            Number number = (Number) obj;
            return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
        }
        return false;
    }

    private static boolean k(Object obj) {
        if (obj instanceof String) {
            return true;
        }
        Class<?> cls = obj.getClass();
        for (Class<?> cls2 : f1046a) {
            if (cls2.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || p.class != obj.getClass()) {
            return false;
        }
        p pVar = (p) obj;
        if (this.f1047b == null) {
            return pVar.f1047b == null;
        } else if (i(this) && i(pVar)) {
            return m().longValue() == pVar.m().longValue();
        } else {
            Object obj2 = this.f1047b;
            if ((obj2 instanceof Number) && (pVar.f1047b instanceof Number)) {
                double doubleValue = m().doubleValue();
                double doubleValue2 = pVar.m().doubleValue();
                if (doubleValue != doubleValue2) {
                    return Double.isNaN(doubleValue) && Double.isNaN(doubleValue2);
                }
                return true;
            }
            return obj2.equals(pVar.f1047b);
        }
    }

    void h(Object obj) {
        if (obj instanceof Character) {
            obj = String.valueOf(((Character) obj).charValue());
        } else {
            b.b((obj instanceof Number) || k(obj));
        }
        this.f1047b = obj;
    }

    public int hashCode() {
        long doubleToLongBits;
        if (this.f1047b == null) {
            return 31;
        }
        if (i(this)) {
            doubleToLongBits = m().longValue();
        } else {
            Object obj = this.f1047b;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            doubleToLongBits = Double.doubleToLongBits(m().doubleValue());
        }
        return (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
    }

    public boolean j() {
        return this.f1047b instanceof Boolean;
    }

    public String l() {
        return s() ? m().toString() : j() ? r().toString() : (String) this.f1047b;
    }

    public Number m() {
        Object obj = this.f1047b;
        return obj instanceof String ? new b.a.a.b.g((String) obj) : (Number) obj;
    }

    public double n() {
        return s() ? m().doubleValue() : Double.parseDouble(l());
    }

    public int o() {
        return s() ? m().intValue() : Integer.parseInt(l());
    }

    public long p() {
        return s() ? m().longValue() : Long.parseLong(l());
    }

    public boolean q() {
        return j() ? r().booleanValue() : Boolean.parseBoolean(l());
    }

    Boolean r() {
        return (Boolean) this.f1047b;
    }

    public boolean s() {
        return this.f1047b instanceof Number;
    }

    public boolean t() {
        return this.f1047b instanceof String;
    }
}
