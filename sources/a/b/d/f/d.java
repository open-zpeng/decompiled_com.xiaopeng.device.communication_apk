package a.b.d.f;

import a.b.c.g.e;
import a.b.d.a.j;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.support.v7.view.menu.f;
import android.support.v7.view.menu.g;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: SupportMenuInflater.java */
/* loaded from: classes.dex */
public class d extends MenuInflater {

    /* renamed from: a  reason: collision with root package name */
    private static final Class<?>[] f410a;

    /* renamed from: b  reason: collision with root package name */
    private static final Class<?>[] f411b;

    /* renamed from: c  reason: collision with root package name */
    private final Object[] f412c;

    /* renamed from: d  reason: collision with root package name */
    private final Object[] f413d;
    private Context e;
    private Object f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SupportMenuInflater.java */
    /* loaded from: classes.dex */
    public static class a implements MenuItem.OnMenuItemClickListener {

        /* renamed from: a  reason: collision with root package name */
        private static final Class<?>[] f414a = {MenuItem.class};

        /* renamed from: b  reason: collision with root package name */
        private Object f415b;

        /* renamed from: c  reason: collision with root package name */
        private Method f416c;

        public a(Object obj, String str) {
            this.f415b = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f416c = cls.getMethod(str, f414a);
            } catch (Exception e) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f416c.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f416c.invoke(this.f415b, menuItem)).booleanValue();
                }
                this.f416c.invoke(this.f415b, menuItem);
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SupportMenuInflater.java */
    /* loaded from: classes.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        private Menu f417a;

        /* renamed from: b  reason: collision with root package name */
        private int f418b;

        /* renamed from: c  reason: collision with root package name */
        private int f419c;

        /* renamed from: d  reason: collision with root package name */
        private int f420d;
        private int e;
        private boolean f;
        private boolean g;
        private boolean h;
        private int i;
        private int j;
        private CharSequence k;
        private CharSequence l;
        private int m;
        private char n;
        private char o;
        private int p;
        private boolean q;
        private boolean r;
        private boolean s;
        private int t;
        private int u;
        private String v;
        private String w;
        private String x;
        private a.b.c.g.b y;

        public b(Menu menu) {
            this.f417a = menu;
            i();
        }

        private char d(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        private <T> T f(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = d.this.e.getClassLoader().loadClass(str).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
                return null;
            }
        }

        private void j(MenuItem menuItem) {
            boolean z = false;
            menuItem.setChecked(this.q).setVisible(this.r).setEnabled(this.s).setCheckable(this.p >= 1).setTitleCondensed(this.l).setIcon(this.m).setAlphabeticShortcut(this.n).setNumericShortcut(this.o);
            int i = this.t;
            if (i >= 0) {
                e.e(menuItem, i);
            }
            if (this.x != null) {
                if (!d.this.e.isRestricted()) {
                    menuItem.setOnMenuItemClickListener(new a(d.this.getRealOwner(), this.x));
                } else {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
            }
            boolean z2 = menuItem instanceof f;
            if (z2) {
                f fVar = (f) menuItem;
            }
            if (this.p >= 2) {
                if (z2) {
                    ((f) menuItem).r(true);
                } else if (menuItem instanceof g) {
                    ((g) menuItem).k(true);
                }
            }
            String str = this.v;
            if (str != null) {
                e.d(menuItem, (View) f(str, d.f410a, d.this.f412c));
                z = true;
            }
            int i2 = this.u;
            if (i2 > 0) {
                if (!z) {
                    e.c(menuItem, i2);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            a.b.c.g.b bVar = this.y;
            if (bVar != null) {
                e.b(menuItem, bVar);
            }
        }

        public void b() {
            this.h = true;
            j(this.f417a.add(this.f418b, this.i, this.j, this.k));
        }

        public SubMenu c() {
            this.h = true;
            SubMenu addSubMenu = this.f417a.addSubMenu(this.f418b, this.i, this.j, this.k);
            j(addSubMenu.getItem());
            return addSubMenu;
        }

        public boolean e() {
            return this.h;
        }

        public void g(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = d.this.e.obtainStyledAttributes(attributeSet, j.d0);
            this.f418b = obtainStyledAttributes.getResourceId(j.f0, 0);
            this.f419c = obtainStyledAttributes.getInt(j.h0, 0);
            this.f420d = obtainStyledAttributes.getInt(j.i0, 0);
            this.e = obtainStyledAttributes.getInt(j.j0, 0);
            this.f = obtainStyledAttributes.getBoolean(j.g0, true);
            this.g = obtainStyledAttributes.getBoolean(j.e0, true);
            obtainStyledAttributes.recycle();
        }

        public void h(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = d.this.e.obtainStyledAttributes(attributeSet, j.k0);
            this.i = obtainStyledAttributes.getResourceId(j.n0, 0);
            this.j = (obtainStyledAttributes.getInt(j.q0, this.f419c) & (-65536)) | (obtainStyledAttributes.getInt(j.r0, this.f420d) & 65535);
            this.k = obtainStyledAttributes.getText(j.s0);
            this.l = obtainStyledAttributes.getText(j.t0);
            this.m = obtainStyledAttributes.getResourceId(j.l0, 0);
            this.n = d(obtainStyledAttributes.getString(j.u0));
            this.o = d(obtainStyledAttributes.getString(j.v0));
            int i = j.w0;
            if (obtainStyledAttributes.hasValue(i)) {
                this.p = obtainStyledAttributes.getBoolean(i, false) ? 1 : 0;
            } else {
                this.p = this.e;
            }
            this.q = obtainStyledAttributes.getBoolean(j.o0, false);
            this.r = obtainStyledAttributes.getBoolean(j.p0, this.f);
            this.s = obtainStyledAttributes.getBoolean(j.m0, this.g);
            this.t = obtainStyledAttributes.getInt(j.B0, -1);
            this.x = obtainStyledAttributes.getString(j.x0);
            this.u = obtainStyledAttributes.getResourceId(j.y0, 0);
            this.v = obtainStyledAttributes.getString(j.A0);
            String string = obtainStyledAttributes.getString(j.z0);
            this.w = string;
            boolean z = string != null;
            if (z && this.u == 0 && this.v == null) {
                this.y = (a.b.c.g.b) f(string, d.f411b, d.this.f413d);
            } else {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.y = null;
            }
            obtainStyledAttributes.recycle();
            this.h = false;
        }

        public void i() {
            this.f418b = 0;
            this.f419c = 0;
            this.f420d = 0;
            this.e = 0;
            this.f = true;
            this.g = true;
        }
    }

    static {
        Class<?>[] clsArr = {Context.class};
        f410a = clsArr;
        f411b = clsArr;
    }

    public d(Context context) {
        super(context);
        this.e = context;
        Object[] objArr = {context};
        this.f412c = objArr;
        this.f413d = objArr;
    }

    private Object findRealOwner(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? findRealOwner(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object getRealOwner() {
        if (this.f == null) {
            this.f = findRealOwner(this.e);
        }
        return this.f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003b, code lost:
        r8 = null;
        r6 = false;
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0040, code lost:
        if (r6 != false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0042, code lost:
        if (r15 == 1) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0048, code lost:
        if (r15 == 2) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004b, code lost:
        if (r15 == 3) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004f, code lost:
        r15 = r13.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0053, code lost:
        if (r7 == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0059, code lost:
        if (r15.equals(r8) == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005b, code lost:
        r8 = null;
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0063, code lost:
        if (r15.equals("group") == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0065, code lost:
        r0.i();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006d, code lost:
        if (r15.equals("item") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0073, code lost:
        if (r0.e() != false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0079, code lost:
        if (r0.y == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0083, code lost:
        if (r0.y.a() == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0085, code lost:
        r0.c();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0089, code lost:
        r0.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0091, code lost:
        if (r15.equals("menu") == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0093, code lost:
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0095, code lost:
        if (r7 == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0098, code lost:
        r15 = r13.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00a0, code lost:
        if (r15.equals("group") == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00a2, code lost:
        r0.g(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00aa, code lost:
        if (r15.equals("item") == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00ac, code lost:
        r0.h(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00b4, code lost:
        if (r15.equals("menu") == false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b6, code lost:
        parseMenu(r13, r14, r0.c());
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00be, code lost:
        r8 = r15;
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00c0, code lost:
        r15 = r13.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00cd, code lost:
        throw new java.lang.RuntimeException("Unexpected end of document");
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00ce, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void parseMenu(org.xmlpull.v1.XmlPullParser r13, android.util.AttributeSet r14, android.view.Menu r15) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r12 = this;
            a.b.d.f.d$b r0 = new a.b.d.f.d$b
            r0.<init>(r15)
            int r15 = r13.getEventType()
        L9:
            r1 = 2
            java.lang.String r2 = "menu"
            r3 = 1
            if (r15 != r1) goto L35
            java.lang.String r15 = r13.getName()
            boolean r4 = r15.equals(r2)
            if (r4 == 0) goto L1e
            int r15 = r13.next()
            goto L3b
        L1e:
            java.lang.RuntimeException r13 = new java.lang.RuntimeException
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r0 = "Expecting menu, got "
            r14.append(r0)
            r14.append(r15)
            java.lang.String r14 = r14.toString()
            r13.<init>(r14)
            throw r13
        L35:
            int r15 = r13.next()
            if (r15 != r3) goto L9
        L3b:
            r4 = 0
            r5 = 0
            r8 = r4
            r6 = r5
            r7 = r6
        L40:
            if (r6 != 0) goto Lce
            if (r15 == r3) goto Lc6
            java.lang.String r9 = "item"
            java.lang.String r10 = "group"
            if (r15 == r1) goto L95
            r11 = 3
            if (r15 == r11) goto L4f
            goto Lc0
        L4f:
            java.lang.String r15 = r13.getName()
            if (r7 == 0) goto L5f
            boolean r11 = r15.equals(r8)
            if (r11 == 0) goto L5f
            r8 = r4
            r7 = r5
            goto Lc0
        L5f:
            boolean r10 = r15.equals(r10)
            if (r10 == 0) goto L69
            r0.i()
            goto Lc0
        L69:
            boolean r9 = r15.equals(r9)
            if (r9 == 0) goto L8d
            boolean r15 = r0.e()
            if (r15 != 0) goto Lc0
            a.b.c.g.b r15 = a.b.d.f.d.b.a(r0)
            if (r15 == 0) goto L89
            a.b.c.g.b r15 = a.b.d.f.d.b.a(r0)
            boolean r15 = r15.a()
            if (r15 == 0) goto L89
            r0.c()
            goto Lc0
        L89:
            r0.b()
            goto Lc0
        L8d:
            boolean r15 = r15.equals(r2)
            if (r15 == 0) goto Lc0
            r6 = r3
            goto Lc0
        L95:
            if (r7 == 0) goto L98
            goto Lc0
        L98:
            java.lang.String r15 = r13.getName()
            boolean r10 = r15.equals(r10)
            if (r10 == 0) goto La6
            r0.g(r14)
            goto Lc0
        La6:
            boolean r9 = r15.equals(r9)
            if (r9 == 0) goto Lb0
            r0.h(r14)
            goto Lc0
        Lb0:
            boolean r9 = r15.equals(r2)
            if (r9 == 0) goto Lbe
            android.view.SubMenu r15 = r0.c()
            r12.parseMenu(r13, r14, r15)
            goto Lc0
        Lbe:
            r8 = r15
            r7 = r3
        Lc0:
            int r15 = r13.next()
            goto L40
        Lc6:
            java.lang.RuntimeException r13 = new java.lang.RuntimeException
            java.lang.String r14 = "Unexpected end of document"
            r13.<init>(r14)
            throw r13
        Lce:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.d.f.d.parseMenu(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.Menu):void");
    }

    @Override // android.view.MenuInflater
    public void inflate(int i, Menu menu) {
        if (!(menu instanceof a.b.c.d.a.a)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                try {
                    xmlResourceParser = this.e.getResources().getLayout(i);
                    parseMenu(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                } catch (XmlPullParserException e) {
                    throw new InflateException("Error inflating menu XML", e);
                }
            } catch (IOException e2) {
                throw new InflateException("Error inflating menu XML", e2);
            }
        } finally {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }
}
