package a.b.b.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: AnimatedVectorDrawableCompat.java */
@TargetApi(21)
/* loaded from: classes.dex */
public class b extends e implements Animatable {

    /* renamed from: b  reason: collision with root package name */
    private C0005b f184b;

    /* renamed from: c  reason: collision with root package name */
    private Context f185c;

    /* renamed from: d  reason: collision with root package name */
    private ArgbEvaluator f186d;
    private final Drawable.Callback e;

    /* compiled from: AnimatedVectorDrawableCompat.java */
    /* loaded from: classes.dex */
    class a implements Drawable.Callback {
        a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            b.this.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            b.this.scheduleSelf(runnable, j);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            b.this.unscheduleSelf(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AnimatedVectorDrawableCompat.java */
    /* renamed from: a.b.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0005b extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        int f188a;

        /* renamed from: b  reason: collision with root package name */
        f f189b;

        /* renamed from: c  reason: collision with root package name */
        ArrayList<Animator> f190c;

        /* renamed from: d  reason: collision with root package name */
        a.b.c.f.a<Animator, String> f191d;

        public C0005b(Context context, C0005b c0005b, Drawable.Callback callback, Resources resources) {
            if (c0005b != null) {
                this.f188a = c0005b.f188a;
                f fVar = c0005b.f189b;
                if (fVar != null) {
                    Drawable.ConstantState constantState = fVar.getConstantState();
                    if (resources != null) {
                        this.f189b = (f) constantState.newDrawable(resources);
                    } else {
                        this.f189b = (f) constantState.newDrawable();
                    }
                    f fVar2 = (f) this.f189b.mutate();
                    this.f189b = fVar2;
                    fVar2.setCallback(callback);
                    this.f189b.setBounds(c0005b.f189b.getBounds());
                    this.f189b.i(false);
                }
                ArrayList<Animator> arrayList = c0005b.f190c;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.f190c = new ArrayList<>(size);
                    this.f191d = new a.b.c.f.a<>(size);
                    for (int i = 0; i < size; i++) {
                        Animator animator = c0005b.f190c.get(i);
                        Animator clone = animator.clone();
                        String str = c0005b.f191d.get(animator);
                        clone.setTarget(this.f189b.e(str));
                        this.f190c.add(clone);
                        this.f191d.put(clone, str);
                    }
                }
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f188a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 21.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 21.");
        }
    }

    /* synthetic */ b(a aVar) {
        this();
    }

    public static b b(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        b bVar = new b(context);
        bVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return bVar;
    }

    private boolean c() {
        ArrayList<Animator> arrayList = this.f184b.f190c;
        if (arrayList == null) {
            return false;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (arrayList.get(i).isRunning()) {
                return true;
            }
        }
        return false;
    }

    private void d(String str, Animator animator) {
        animator.setTarget(this.f184b.f189b.e(str));
        if (Build.VERSION.SDK_INT < 21) {
            e(animator);
        }
        C0005b c0005b = this.f184b;
        if (c0005b.f190c == null) {
            c0005b.f190c = new ArrayList<>();
            this.f184b.f191d = new a.b.c.f.a<>();
        }
        this.f184b.f190c.add(animator);
        this.f184b.f191d.put(animator, str);
    }

    private void e(Animator animator) {
        ArrayList<Animator> childAnimations;
        if ((animator instanceof AnimatorSet) && (childAnimations = ((AnimatorSet) animator).getChildAnimations()) != null) {
            for (int i = 0; i < childAnimations.size(); i++) {
                e(childAnimations.get(i));
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.f186d == null) {
                    this.f186d = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.f186d);
            }
        }
    }

    static TypedArray obtainAttributes(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    @Override // a.b.b.a.e, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f197a;
        if (drawable != null) {
            a.b.c.c.b.a.a(drawable, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f197a;
        if (drawable != null) {
            return a.b.c.c.b.a.b(drawable);
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
        this.f184b.f189b.draw(canvas);
        if (c()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f197a;
        if (drawable != null) {
            return a.b.c.c.b.a.c(drawable);
        }
        return this.f184b.f189b.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f197a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f184b.f188a;
    }

    @Override // a.b.b.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        Drawable drawable = this.f197a;
        if (drawable != null) {
            return new c(drawable.getConstantState());
        }
        return null;
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
        return this.f184b.f189b.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f197a;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return this.f184b.f189b.getIntrinsicWidth();
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
        return this.f184b.f189b.getOpacity();
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

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f197a;
        if (drawable != null) {
            a.b.c.c.b.a.f(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray obtainAttributes = obtainAttributes(resources, theme, attributeSet, a.b.b.a.a.e);
                    int resourceId = obtainAttributes.getResourceId(0, 0);
                    if (resourceId != 0) {
                        f c2 = f.c(resources, resourceId, theme);
                        c2.i(false);
                        c2.setCallback(this.e);
                        f fVar = this.f184b.f189b;
                        if (fVar != null) {
                            fVar.setCallback(null);
                        }
                        this.f184b.f189b = c2;
                    }
                    obtainAttributes.recycle();
                } else if ("target".equals(name)) {
                    TypedArray obtainAttributes2 = resources.obtainAttributes(attributeSet, a.b.b.a.a.f);
                    String string = obtainAttributes2.getString(0);
                    int resourceId2 = obtainAttributes2.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.f185c;
                        if (context != null) {
                            d(string, AnimatorInflater.loadAnimator(context, resourceId2));
                        } else {
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    obtainAttributes2.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // a.b.b.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Drawable drawable = this.f197a;
        if (drawable != null) {
            return ((AnimatedVectorDrawable) drawable).isRunning();
        }
        ArrayList<Animator> arrayList = this.f184b.f190c;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (arrayList.get(i).isRunning()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.f197a;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return this.f184b.f189b.isStateful();
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
        throw new IllegalStateException("Mutate() is not supported for older platform");
    }

    @Override // a.b.b.a.e, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f197a;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f184b.f189b.setBounds(rect);
        }
    }

    @Override // a.b.b.a.e, android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        Drawable drawable = this.f197a;
        if (drawable != null) {
            return drawable.setLevel(i);
        }
        return this.f184b.f189b.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f197a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        return this.f184b.f189b.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Drawable drawable = this.f197a;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else {
            this.f184b.f189b.setAlpha(i);
        }
    }

    @Override // a.b.b.a.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
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
            this.f184b.f189b.setTint(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f197a;
        if (drawable != null) {
            a.b.c.c.b.a.m(drawable, colorStateList);
        } else {
            this.f184b.f189b.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f197a;
        if (drawable != null) {
            a.b.c.c.b.a.n(drawable, mode);
        } else {
            this.f184b.f189b.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f197a;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        this.f184b.f189b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable drawable = this.f197a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else if (!c()) {
            ArrayList<Animator> arrayList = this.f184b.f190c;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                arrayList.get(i).start();
            }
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Drawable drawable = this.f197a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
            return;
        }
        ArrayList<Animator> arrayList = this.f184b.f190c;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList.get(i).end();
        }
    }

    private b() {
        this(null, null, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f197a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f184b.f189b.setColorFilter(colorFilter);
        }
    }

    /* compiled from: AnimatedVectorDrawableCompat.java */
    /* loaded from: classes.dex */
    private static class c extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        private final Drawable.ConstantState f192a;

        public c(Drawable.ConstantState constantState) {
            this.f192a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f192a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f192a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            b bVar = new b((a) null);
            Drawable newDrawable = this.f192a.newDrawable();
            bVar.f197a = newDrawable;
            newDrawable.setCallback(bVar.e);
            return bVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            b bVar = new b((a) null);
            Drawable newDrawable = this.f192a.newDrawable(resources);
            bVar.f197a = newDrawable;
            newDrawable.setCallback(bVar.e);
            return bVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            b bVar = new b((a) null);
            Drawable newDrawable = this.f192a.newDrawable(resources, theme);
            bVar.f197a = newDrawable;
            newDrawable.setCallback(bVar.e);
            return bVar;
        }
    }

    private b(Context context) {
        this(context, null, null);
    }

    private b(Context context, C0005b c0005b, Resources resources) {
        this.f186d = null;
        a aVar = new a();
        this.e = aVar;
        this.f185c = context;
        if (c0005b != null) {
            this.f184b = c0005b;
        } else {
            this.f184b = new C0005b(context, c0005b, aVar, resources);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }
}
