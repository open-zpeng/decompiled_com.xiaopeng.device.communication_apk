package a.b.b.a;

import a.b.b.a.c;
import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: VectorDrawableCompat.java */
@TargetApi(21)
/* loaded from: classes.dex */
public class f extends a.b.b.a.e {

    /* renamed from: b  reason: collision with root package name */
    static final PorterDuff.Mode f198b = PorterDuff.Mode.SRC_IN;

    /* renamed from: c  reason: collision with root package name */
    private g f199c;

    /* renamed from: d  reason: collision with root package name */
    private PorterDuffColorFilter f200d;
    private ColorFilter e;
    private boolean f;
    private boolean g;
    private Drawable.ConstantState h;
    private final float[] i;
    private final Matrix j;
    private final Rect k;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class b extends e {
        public b() {
        }

        private void e(TypedArray typedArray) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f207b = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f206a = a.b.b.a.c.d(string2);
            }
        }

        @Override // a.b.b.a.f.e
        public boolean b() {
            return true;
        }

        public void d(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (a.b.b.a.d.e(xmlPullParser, "pathData")) {
                TypedArray obtainAttributes = a.b.b.a.e.obtainAttributes(resources, theme, attributeSet, a.b.b.a.a.f183d);
                e(obtainAttributes);
                obtainAttributes.recycle();
            }
        }

        public b(b bVar) {
            super(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class g extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        int f213a;

        /* renamed from: b  reason: collision with root package name */
        C0007f f214b;

        /* renamed from: c  reason: collision with root package name */
        ColorStateList f215c;

        /* renamed from: d  reason: collision with root package name */
        PorterDuff.Mode f216d;
        boolean e;
        Bitmap f;
        ColorStateList g;
        PorterDuff.Mode h;
        int i;
        boolean j;
        boolean k;
        Paint l;

        public g(g gVar) {
            this.f215c = null;
            this.f216d = f.f198b;
            if (gVar != null) {
                this.f213a = gVar.f213a;
                this.f214b = new C0007f(gVar.f214b);
                if (gVar.f214b.f != null) {
                    this.f214b.f = new Paint(gVar.f214b.f);
                }
                if (gVar.f214b.e != null) {
                    this.f214b.e = new Paint(gVar.f214b.e);
                }
                this.f215c = gVar.f215c;
                this.f216d = gVar.f216d;
                this.e = gVar.e;
            }
        }

        public boolean a(int i, int i2) {
            return i == this.f.getWidth() && i2 == this.f.getHeight();
        }

        public boolean b() {
            return !this.k && this.g == this.f215c && this.h == this.f216d && this.j == this.e && this.i == this.f214b.l();
        }

        public void c(int i, int i2) {
            if (this.f == null || !a(i, i2)) {
                this.f = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                this.k = true;
            }
        }

        public void d(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f, (Rect) null, rect, e(colorFilter));
        }

        public Paint e(ColorFilter colorFilter) {
            if (f() || colorFilter != null) {
                if (this.l == null) {
                    Paint paint = new Paint();
                    this.l = paint;
                    paint.setFilterBitmap(true);
                }
                this.l.setAlpha(this.f214b.l());
                this.l.setColorFilter(colorFilter);
                return this.l;
            }
            return null;
        }

        public boolean f() {
            return this.f214b.l() < 255;
        }

        public void g() {
            this.g = this.f215c;
            this.h = this.f216d;
            this.i = this.f214b.l();
            this.j = this.e;
            this.k = false;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f213a;
        }

        public void h(int i, int i2) {
            this.f.eraseColor(0);
            this.f214b.g(new Canvas(this.f), i, i2, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new f(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new f(this);
        }

        public g() {
            this.f215c = null;
            this.f216d = f.f198b;
            this.f214b = new C0007f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(int i, float f) {
        return (i & 16777215) | (((int) (Color.alpha(i) * f)) << 24);
    }

    public static f c(Resources resources, int i, Resources.Theme theme) {
        int next;
        if (Build.VERSION.SDK_INT >= 21) {
            f fVar = new f();
            Drawable a2 = a.b.c.b.c.a.a(resources, i, theme);
            fVar.f197a = a2;
            fVar.h = new h(a2.getConstantState());
            return fVar;
        }
        try {
            XmlResourceParser xml = resources.getXml(i);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            while (true) {
                next = xml.next();
                if (next == 2 || next == 1) {
                    break;
                }
            }
            if (next == 2) {
                return d(resources, xml, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException e2) {
            Log.e("VectorDrawableCompat", "parser error", e2);
            return null;
        } catch (XmlPullParserException e3) {
            Log.e("VectorDrawableCompat", "parser error", e3);
            return null;
        }
    }

    public static f d(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        f fVar = new f();
        fVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return fVar;
    }

    private void f(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        g gVar = this.f199c;
        C0007f c0007f = gVar.f214b;
        Stack stack = new Stack();
        stack.push(c0007f.i);
        int eventType = xmlPullParser.getEventType();
        boolean z = true;
        while (eventType != 1) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                d dVar = (d) stack.peek();
                if ("path".equals(name)) {
                    c cVar = new c();
                    cVar.f(resources, attributeSet, theme, xmlPullParser);
                    dVar.f203b.add(cVar);
                    if (cVar.a() != null) {
                        c0007f.p.put(cVar.a(), cVar);
                    }
                    z = false;
                    gVar.f213a = cVar.f208c | gVar.f213a;
                } else if ("clip-path".equals(name)) {
                    b bVar = new b();
                    bVar.d(resources, attributeSet, theme, xmlPullParser);
                    dVar.f203b.add(bVar);
                    if (bVar.a() != null) {
                        c0007f.p.put(bVar.a(), bVar);
                    }
                    gVar.f213a = bVar.f208c | gVar.f213a;
                } else if ("group".equals(name)) {
                    d dVar2 = new d();
                    dVar2.e(resources, attributeSet, theme, xmlPullParser);
                    dVar.f203b.add(dVar2);
                    stack.push(dVar2);
                    if (dVar2.d() != null) {
                        c0007f.p.put(dVar2.d(), dVar2);
                    }
                    gVar.f213a = dVar2.k | gVar.f213a;
                }
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                stack.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z) {
            StringBuffer stringBuffer = new StringBuffer();
            if (stringBuffer.length() > 0) {
                stringBuffer.append(" or ");
            }
            stringBuffer.append("path");
            throw new XmlPullParserException("no " + ((Object) stringBuffer) + " defined");
        }
    }

    private boolean g() {
        return false;
    }

    private static PorterDuff.Mode h(int i, PorterDuff.Mode mode) {
        if (i != 3) {
            if (i != 5) {
                if (i != 9) {
                    switch (i) {
                        case 14:
                            return PorterDuff.Mode.MULTIPLY;
                        case 15:
                            return PorterDuff.Mode.SCREEN;
                        case 16:
                            return PorterDuff.Mode.ADD;
                        default:
                            return mode;
                    }
                }
                return PorterDuff.Mode.SRC_ATOP;
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    private void j(TypedArray typedArray, XmlPullParser xmlPullParser) throws XmlPullParserException {
        g gVar = this.f199c;
        C0007f c0007f = gVar.f214b;
        gVar.f216d = h(a.b.b.a.d.d(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList colorStateList = typedArray.getColorStateList(1);
        if (colorStateList != null) {
            gVar.f215c = colorStateList;
        }
        gVar.e = a.b.b.a.d.a(typedArray, xmlPullParser, "autoMirrored", 5, gVar.e);
        c0007f.l = a.b.b.a.d.c(typedArray, xmlPullParser, "viewportWidth", 7, c0007f.l);
        float c2 = a.b.b.a.d.c(typedArray, xmlPullParser, "viewportHeight", 8, c0007f.m);
        c0007f.m = c2;
        if (c0007f.l <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (c2 > 0.0f) {
            c0007f.j = typedArray.getDimension(3, c0007f.j);
            float dimension = typedArray.getDimension(2, c0007f.k);
            c0007f.k = dimension;
            if (c0007f.j <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (dimension > 0.0f) {
                c0007f.m(a.b.b.a.d.c(typedArray, xmlPullParser, "alpha", 4, c0007f.j()));
                String string = typedArray.getString(0);
                if (string != null) {
                    c0007f.o = string;
                    c0007f.p.put(string, c0007f);
                }
            } else {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
            }
        } else {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
    }

    @Override // a.b.b.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f197a;
        if (drawable != null) {
            a.b.c.c.b.a.b(drawable);
            return false;
        }
        return false;
    }

    @Override // a.b.b.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f197a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.k);
        if (this.k.width() <= 0 || this.k.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.e;
        if (colorFilter == null) {
            colorFilter = this.f200d;
        }
        canvas.getMatrix(this.j);
        this.j.getValues(this.i);
        float abs = Math.abs(this.i[0]);
        float abs2 = Math.abs(this.i[4]);
        float abs3 = Math.abs(this.i[1]);
        float abs4 = Math.abs(this.i[3]);
        if (abs3 != 0.0f || abs4 != 0.0f) {
            abs = 1.0f;
            abs2 = 1.0f;
        }
        int min = Math.min(2048, (int) (this.k.width() * abs));
        int min2 = Math.min(2048, (int) (this.k.height() * abs2));
        if (min <= 0 || min2 <= 0) {
            return;
        }
        int save = canvas.save();
        Rect rect = this.k;
        canvas.translate(rect.left, rect.top);
        if (g()) {
            canvas.translate(this.k.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        this.k.offsetTo(0, 0);
        this.f199c.c(min, min2);
        if (!this.g) {
            this.f199c.h(min, min2);
        } else if (!this.f199c.b()) {
            this.f199c.h(min, min2);
            this.f199c.g();
        }
        this.f199c.d(canvas, colorFilter, this.k);
        canvas.restoreToCount(save);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object e(String str) {
        return this.f199c.f214b.p.get(str);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f197a;
        if (drawable != null) {
            return a.b.c.c.b.a.c(drawable);
        }
        return this.f199c.f214b.l();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f197a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f199c.getChangingConfigurations();
    }

    @Override // a.b.b.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        Drawable drawable = this.f197a;
        if (drawable != null) {
            return new h(drawable.getConstantState());
        }
        this.f199c.f213a = getChangingConfigurations();
        return this.f199c;
    }

    @Override // a.b.b.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f197a;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return (int) this.f199c.f214b.k;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f197a;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return (int) this.f199c.f214b.j;
    }

    @Override // a.b.b.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getLayoutDirection() {
        return super.getLayoutDirection();
    }

    @Override // a.b.b.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // a.b.b.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f197a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // a.b.b.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // a.b.b.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // a.b.b.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(boolean z) {
        this.g = z;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.f197a;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable drawable = this.f197a;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // a.b.b.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        g gVar;
        ColorStateList colorStateList;
        Drawable drawable = this.f197a;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return super.isStateful() || !((gVar = this.f199c) == null || (colorStateList = gVar.f215c) == null || !colorStateList.isStateful());
    }

    @Override // a.b.b.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f197a;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f && super.mutate() == this) {
            this.f199c = new g(this.f199c);
            this.f = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        Drawable drawable = this.f197a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        g gVar = this.f199c;
        ColorStateList colorStateList = gVar.f215c;
        if (colorStateList == null || (mode = gVar.f216d) == null) {
            return false;
        }
        this.f200d = updateTintFilter(this.f200d, colorStateList, mode);
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j) {
        Drawable drawable = this.f197a;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Drawable drawable = this.f197a;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else if (this.f199c.f214b.l() != i) {
            this.f199c.f214b.n(i);
            invalidateSelf();
        }
    }

    @Override // a.b.b.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        Drawable drawable = this.f197a;
        if (drawable != null) {
            drawable.setBounds(i, i2, i3, i4);
        } else {
            super.setBounds(i, i2, i3, i4);
        }
    }

    @Override // a.b.b.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    @Override // a.b.b.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i, PorterDuff.Mode mode) {
        super.setColorFilter(i, mode);
    }

    @Override // a.b.b.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    @Override // a.b.b.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    @Override // a.b.b.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // a.b.b.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i) {
        Drawable drawable = this.f197a;
        if (drawable != null) {
            a.b.c.c.b.a.l(drawable, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f197a;
        if (drawable != null) {
            a.b.c.c.b.a.m(drawable, colorStateList);
            return;
        }
        g gVar = this.f199c;
        if (gVar.f215c != colorStateList) {
            gVar.f215c = colorStateList;
            this.f200d = updateTintFilter(this.f200d, colorStateList, gVar.f216d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f197a;
        if (drawable != null) {
            a.b.c.c.b.a.n(drawable, mode);
            return;
        }
        g gVar = this.f199c;
        if (gVar.f216d != mode) {
            gVar.f216d = mode;
            this.f200d = updateTintFilter(this.f200d, gVar.f215c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f197a;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f197a;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    PorterDuffColorFilter updateTintFilter(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        protected c.C0006c[] f206a;

        /* renamed from: b  reason: collision with root package name */
        String f207b;

        /* renamed from: c  reason: collision with root package name */
        int f208c;

        public e() {
            this.f206a = null;
        }

        public String a() {
            return this.f207b;
        }

        public boolean b() {
            return false;
        }

        public void c(Path path) {
            path.reset();
            c.C0006c[] c0006cArr = this.f206a;
            if (c0006cArr != null) {
                c.C0006c.d(c0006cArr, path);
            }
        }

        public e(e eVar) {
            this.f206a = null;
            this.f207b = eVar.f207b;
            this.f208c = eVar.f208c;
            this.f206a = a.b.b.a.c.e(eVar.f206a);
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    private static class h extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        private final Drawable.ConstantState f217a;

        public h(Drawable.ConstantState constantState) {
            this.f217a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f217a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f217a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            f fVar = new f();
            fVar.f197a = (VectorDrawable) this.f217a.newDrawable();
            return fVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            f fVar = new f();
            fVar.f197a = (VectorDrawable) this.f217a.newDrawable(resources);
            return fVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            f fVar = new f();
            fVar.f197a = (VectorDrawable) this.f217a.newDrawable(resources, theme);
            return fVar;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f197a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        this.e = colorFilter;
        invalidateSelf();
    }

    private f() {
        this.g = true;
        this.i = new float[9];
        this.j = new Matrix();
        this.k = new Rect();
        this.f199c = new g();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f197a;
        if (drawable != null) {
            a.b.c.c.b.a.f(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        g gVar = this.f199c;
        gVar.f214b = new C0007f();
        TypedArray obtainAttributes = a.b.b.a.e.obtainAttributes(resources, theme, attributeSet, a.b.b.a.a.f180a);
        j(obtainAttributes, xmlPullParser);
        obtainAttributes.recycle();
        gVar.f213a = getChangingConfigurations();
        gVar.k = true;
        f(resources, xmlPullParser, attributeSet, theme);
        this.f200d = updateTintFilter(this.f200d, gVar.f215c, gVar.f216d);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        Drawable drawable = this.f197a;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            super.setBounds(rect);
        }
    }

    private f(g gVar) {
        this.g = true;
        this.i = new float[9];
        this.j = new Matrix();
        this.k = new Rect();
        this.f199c = gVar;
        this.f200d = updateTintFilter(this.f200d, gVar.f215c, gVar.f216d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class c extends e {

        /* renamed from: d  reason: collision with root package name */
        private int[] f201d;
        int e;
        float f;
        int g;
        float h;
        int i;
        float j;
        float k;
        float l;
        float m;
        Paint.Cap n;
        Paint.Join o;
        float p;

        public c() {
            this.e = 0;
            this.f = 0.0f;
            this.g = 0;
            this.h = 1.0f;
            this.j = 1.0f;
            this.k = 0.0f;
            this.l = 1.0f;
            this.m = 0.0f;
            this.n = Paint.Cap.BUTT;
            this.o = Paint.Join.MITER;
            this.p = 4.0f;
        }

        private Paint.Cap d(int i, Paint.Cap cap) {
            if (i != 0) {
                if (i != 1) {
                    return i != 2 ? cap : Paint.Cap.SQUARE;
                }
                return Paint.Cap.ROUND;
            }
            return Paint.Cap.BUTT;
        }

        private Paint.Join e(int i, Paint.Join join) {
            if (i != 0) {
                if (i != 1) {
                    return i != 2 ? join : Paint.Join.BEVEL;
                }
                return Paint.Join.ROUND;
            }
            return Paint.Join.MITER;
        }

        private void g(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f201d = null;
            if (a.b.b.a.d.e(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f207b = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.f206a = a.b.b.a.c.d(string2);
                }
                this.g = a.b.b.a.d.b(typedArray, xmlPullParser, "fillColor", 1, this.g);
                this.j = a.b.b.a.d.c(typedArray, xmlPullParser, "fillAlpha", 12, this.j);
                this.n = d(a.b.b.a.d.d(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.n);
                this.o = e(a.b.b.a.d.d(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.o);
                this.p = a.b.b.a.d.c(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.p);
                this.e = a.b.b.a.d.b(typedArray, xmlPullParser, "strokeColor", 3, this.e);
                this.h = a.b.b.a.d.c(typedArray, xmlPullParser, "strokeAlpha", 11, this.h);
                this.f = a.b.b.a.d.c(typedArray, xmlPullParser, "strokeWidth", 4, this.f);
                this.l = a.b.b.a.d.c(typedArray, xmlPullParser, "trimPathEnd", 6, this.l);
                this.m = a.b.b.a.d.c(typedArray, xmlPullParser, "trimPathOffset", 7, this.m);
                this.k = a.b.b.a.d.c(typedArray, xmlPullParser, "trimPathStart", 5, this.k);
            }
        }

        public void f(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray obtainAttributes = a.b.b.a.e.obtainAttributes(resources, theme, attributeSet, a.b.b.a.a.f182c);
            g(obtainAttributes, xmlPullParser);
            obtainAttributes.recycle();
        }

        public c(c cVar) {
            super(cVar);
            this.e = 0;
            this.f = 0.0f;
            this.g = 0;
            this.h = 1.0f;
            this.j = 1.0f;
            this.k = 0.0f;
            this.l = 1.0f;
            this.m = 0.0f;
            this.n = Paint.Cap.BUTT;
            this.o = Paint.Join.MITER;
            this.p = 4.0f;
            this.f201d = cVar.f201d;
            this.e = cVar.e;
            this.f = cVar.f;
            this.h = cVar.h;
            this.g = cVar.g;
            this.i = cVar.i;
            this.j = cVar.j;
            this.k = cVar.k;
            this.l = cVar.l;
            this.m = cVar.m;
            this.n = cVar.n;
            this.o = cVar.o;
            this.p = cVar.p;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: a.b.b.a.f$f  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0007f {

        /* renamed from: a  reason: collision with root package name */
        private static final Matrix f209a = new Matrix();

        /* renamed from: b  reason: collision with root package name */
        private final Path f210b;

        /* renamed from: c  reason: collision with root package name */
        private final Path f211c;

        /* renamed from: d  reason: collision with root package name */
        private final Matrix f212d;
        private Paint e;
        private Paint f;
        private PathMeasure g;
        private int h;
        private final d i;
        float j;
        float k;
        float l;
        float m;
        int n;
        String o;
        final a.b.c.f.a<String, Object> p;

        public C0007f() {
            this.f212d = new Matrix();
            this.j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 0.0f;
            this.n = 255;
            this.o = null;
            this.p = new a.b.c.f.a<>();
            this.i = new d();
            this.f210b = new Path();
            this.f211c = new Path();
        }

        private static float f(float f, float f2, float f3, float f4) {
            return (f * f4) - (f2 * f3);
        }

        private void h(d dVar, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            dVar.f202a.set(matrix);
            dVar.f202a.preConcat(dVar.j);
            for (int i3 = 0; i3 < dVar.f203b.size(); i3++) {
                Object obj = dVar.f203b.get(i3);
                if (obj instanceof d) {
                    h((d) obj, dVar.f202a, canvas, i, i2, colorFilter);
                } else if (obj instanceof e) {
                    i(dVar, (e) obj, canvas, i, i2, colorFilter);
                }
            }
        }

        private void i(d dVar, e eVar, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            float f = i / this.l;
            float f2 = i2 / this.m;
            float min = Math.min(f, f2);
            Matrix matrix = dVar.f202a;
            this.f212d.set(matrix);
            this.f212d.postScale(f, f2);
            float k = k(matrix);
            if (k == 0.0f) {
                return;
            }
            eVar.c(this.f210b);
            Path path = this.f210b;
            this.f211c.reset();
            if (eVar.b()) {
                this.f211c.addPath(path, this.f212d);
                canvas.clipPath(this.f211c, Region.Op.REPLACE);
                return;
            }
            c cVar = (c) eVar;
            float f3 = cVar.k;
            if (f3 != 0.0f || cVar.l != 1.0f) {
                float f4 = cVar.m;
                float f5 = (f3 + f4) % 1.0f;
                float f6 = (cVar.l + f4) % 1.0f;
                if (this.g == null) {
                    this.g = new PathMeasure();
                }
                this.g.setPath(this.f210b, false);
                float length = this.g.getLength();
                float f7 = f5 * length;
                float f8 = f6 * length;
                path.reset();
                if (f7 > f8) {
                    this.g.getSegment(f7, length, path, true);
                    this.g.getSegment(0.0f, f8, path, true);
                } else {
                    this.g.getSegment(f7, f8, path, true);
                }
                path.rLineTo(0.0f, 0.0f);
            }
            this.f211c.addPath(path, this.f212d);
            if (cVar.g != 0) {
                if (this.f == null) {
                    Paint paint = new Paint();
                    this.f = paint;
                    paint.setStyle(Paint.Style.FILL);
                    this.f.setAntiAlias(true);
                }
                Paint paint2 = this.f;
                paint2.setColor(f.b(cVar.g, cVar.j));
                paint2.setColorFilter(colorFilter);
                canvas.drawPath(this.f211c, paint2);
            }
            if (cVar.e != 0) {
                if (this.e == null) {
                    Paint paint3 = new Paint();
                    this.e = paint3;
                    paint3.setStyle(Paint.Style.STROKE);
                    this.e.setAntiAlias(true);
                }
                Paint paint4 = this.e;
                Paint.Join join = cVar.o;
                if (join != null) {
                    paint4.setStrokeJoin(join);
                }
                Paint.Cap cap = cVar.n;
                if (cap != null) {
                    paint4.setStrokeCap(cap);
                }
                paint4.setStrokeMiter(cVar.p);
                paint4.setColor(f.b(cVar.e, cVar.h));
                paint4.setColorFilter(colorFilter);
                paint4.setStrokeWidth(cVar.f * min * k);
                canvas.drawPath(this.f211c, paint4);
            }
        }

        private float k(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float f = f(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max((float) Math.hypot(fArr[0], fArr[1]), (float) Math.hypot(fArr[2], fArr[3]));
            if (max > 0.0f) {
                return Math.abs(f) / max;
            }
            return 0.0f;
        }

        public void g(Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            h(this.i, f209a, canvas, i, i2, colorFilter);
        }

        public float j() {
            return l() / 255.0f;
        }

        public int l() {
            return this.n;
        }

        public void m(float f) {
            n((int) (f * 255.0f));
        }

        public void n(int i) {
            this.n = i;
        }

        public C0007f(C0007f c0007f) {
            this.f212d = new Matrix();
            this.j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 0.0f;
            this.n = 255;
            this.o = null;
            a.b.c.f.a<String, Object> aVar = new a.b.c.f.a<>();
            this.p = aVar;
            this.i = new d(c0007f.i, aVar);
            this.f210b = new Path(c0007f.f210b);
            this.f211c = new Path(c0007f.f211c);
            this.j = c0007f.j;
            this.k = c0007f.k;
            this.l = c0007f.l;
            this.m = c0007f.m;
            this.h = c0007f.h;
            this.n = c0007f.n;
            this.o = c0007f.o;
            String str = c0007f.o;
            if (str != null) {
                aVar.put(str, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        private final Matrix f202a;

        /* renamed from: b  reason: collision with root package name */
        final ArrayList<Object> f203b;

        /* renamed from: c  reason: collision with root package name */
        private float f204c;

        /* renamed from: d  reason: collision with root package name */
        private float f205d;
        private float e;
        private float f;
        private float g;
        private float h;
        private float i;
        private final Matrix j;
        private int k;
        private int[] l;
        private String m;

        public d(d dVar, a.b.c.f.a<String, Object> aVar) {
            e bVar;
            this.f202a = new Matrix();
            this.f203b = new ArrayList<>();
            this.f204c = 0.0f;
            this.f205d = 0.0f;
            this.e = 0.0f;
            this.f = 1.0f;
            this.g = 1.0f;
            this.h = 0.0f;
            this.i = 0.0f;
            Matrix matrix = new Matrix();
            this.j = matrix;
            this.m = null;
            this.f204c = dVar.f204c;
            this.f205d = dVar.f205d;
            this.e = dVar.e;
            this.f = dVar.f;
            this.g = dVar.g;
            this.h = dVar.h;
            this.i = dVar.i;
            this.l = dVar.l;
            String str = dVar.m;
            this.m = str;
            this.k = dVar.k;
            if (str != null) {
                aVar.put(str, this);
            }
            matrix.set(dVar.j);
            ArrayList<Object> arrayList = dVar.f203b;
            for (int i = 0; i < arrayList.size(); i++) {
                Object obj = arrayList.get(i);
                if (obj instanceof d) {
                    this.f203b.add(new d((d) obj, aVar));
                } else {
                    if (obj instanceof c) {
                        bVar = new c((c) obj);
                    } else if (obj instanceof b) {
                        bVar = new b((b) obj);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f203b.add(bVar);
                    String str2 = bVar.f207b;
                    if (str2 != null) {
                        aVar.put(str2, bVar);
                    }
                }
            }
        }

        private void f() {
            this.j.reset();
            this.j.postTranslate(-this.f205d, -this.e);
            this.j.postScale(this.f, this.g);
            this.j.postRotate(this.f204c, 0.0f, 0.0f);
            this.j.postTranslate(this.h + this.f205d, this.i + this.e);
        }

        private void g(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.l = null;
            this.f204c = a.b.b.a.d.c(typedArray, xmlPullParser, "rotation", 5, this.f204c);
            this.f205d = typedArray.getFloat(1, this.f205d);
            this.e = typedArray.getFloat(2, this.e);
            this.f = a.b.b.a.d.c(typedArray, xmlPullParser, "scaleX", 3, this.f);
            this.g = a.b.b.a.d.c(typedArray, xmlPullParser, "scaleY", 4, this.g);
            this.h = a.b.b.a.d.c(typedArray, xmlPullParser, "translateX", 6, this.h);
            this.i = a.b.b.a.d.c(typedArray, xmlPullParser, "translateY", 7, this.i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.m = string;
            }
            f();
        }

        public String d() {
            return this.m;
        }

        public void e(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray obtainAttributes = a.b.b.a.e.obtainAttributes(resources, theme, attributeSet, a.b.b.a.a.f181b);
            g(obtainAttributes, xmlPullParser);
            obtainAttributes.recycle();
        }

        public d() {
            this.f202a = new Matrix();
            this.f203b = new ArrayList<>();
            this.f204c = 0.0f;
            this.f205d = 0.0f;
            this.e = 0.0f;
            this.f = 1.0f;
            this.g = 1.0f;
            this.h = 0.0f;
            this.i = 0.0f;
            this.j = new Matrix();
            this.m = null;
        }
    }
}
