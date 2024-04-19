package a.a.b.a;
/* compiled from: SimpleSQLiteQuery.java */
/* loaded from: classes.dex */
public final class a implements e {

    /* renamed from: a  reason: collision with root package name */
    private final String f153a;

    /* renamed from: b  reason: collision with root package name */
    private final Object[] f154b;

    public a(String str, Object[] objArr) {
        this.f153a = str;
        this.f154b = objArr;
    }

    private static void a(d dVar, int i, Object obj) {
        if (obj == null) {
            dVar.bindNull(i);
        } else if (obj instanceof byte[]) {
            dVar.bindBlob(i, (byte[]) obj);
        } else if (obj instanceof Float) {
            dVar.bindDouble(i, ((Float) obj).floatValue());
        } else if (obj instanceof Double) {
            dVar.bindDouble(i, ((Double) obj).doubleValue());
        } else if (obj instanceof Long) {
            dVar.bindLong(i, ((Long) obj).longValue());
        } else if (obj instanceof Integer) {
            dVar.bindLong(i, ((Integer) obj).intValue());
        } else if (obj instanceof Short) {
            dVar.bindLong(i, ((Short) obj).shortValue());
        } else if (obj instanceof Byte) {
            dVar.bindLong(i, ((Byte) obj).byteValue());
        } else if (obj instanceof String) {
            dVar.bindString(i, (String) obj);
        } else if (obj instanceof Boolean) {
            dVar.bindLong(i, ((Boolean) obj).booleanValue() ? 1L : 0L);
        } else {
            throw new IllegalArgumentException("Cannot bind " + obj + " at index " + i + " Supported types: null, byte[], float, double, long, int, short, byte, string");
        }
    }

    public static void b(d dVar, Object[] objArr) {
        if (objArr == null) {
            return;
        }
        int length = objArr.length;
        int i = 0;
        while (i < length) {
            Object obj = objArr[i];
            i++;
            a(dVar, i, obj);
        }
    }

    @Override // a.a.b.a.e
    public void bindTo(d dVar) {
        b(dVar, this.f154b);
    }

    @Override // a.a.b.a.e
    public int getArgCount() {
        Object[] objArr = this.f154b;
        if (objArr == null) {
            return 0;
        }
        return objArr.length;
    }

    @Override // a.a.b.a.e
    public String getSql() {
        return this.f153a;
    }

    public a(String str) {
        this(str, null);
    }
}
