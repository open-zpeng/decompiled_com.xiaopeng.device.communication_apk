package a.b.c.g;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build;
import android.view.View;
import java.lang.ref.WeakReference;
/* compiled from: ViewPropertyAnimatorCompat.java */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<View> f341a;

    /* renamed from: b  reason: collision with root package name */
    Runnable f342b = null;

    /* renamed from: c  reason: collision with root package name */
    Runnable f343c = null;

    /* renamed from: d  reason: collision with root package name */
    int f344d = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewPropertyAnimatorCompat.java */
    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f345a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f346b;

        a(n nVar, View view) {
            this.f345a = nVar;
            this.f346b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f345a.a(this.f346b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f345a.b(this.f346b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f345a.c(this.f346b);
        }
    }

    /* compiled from: ViewPropertyAnimatorCompat.java */
    /* loaded from: classes.dex */
    static class b implements n {

        /* renamed from: a  reason: collision with root package name */
        m f348a;

        /* renamed from: b  reason: collision with root package name */
        boolean f349b;

        b(m mVar) {
            this.f348a = mVar;
        }

        @Override // a.b.c.g.n
        public void a(View view) {
            Object tag = view.getTag(2113929216);
            n nVar = tag instanceof n ? (n) tag : null;
            if (nVar != null) {
                nVar.a(view);
            }
        }

        @Override // a.b.c.g.n
        public void b(View view) {
            int i = this.f348a.f344d;
            if (i > -1) {
                view.setLayerType(i, null);
                this.f348a.f344d = -1;
            }
            if (Build.VERSION.SDK_INT >= 16 || !this.f349b) {
                m mVar = this.f348a;
                Runnable runnable = mVar.f343c;
                if (runnable != null) {
                    mVar.f343c = null;
                    runnable.run();
                }
                Object tag = view.getTag(2113929216);
                n nVar = tag instanceof n ? (n) tag : null;
                if (nVar != null) {
                    nVar.b(view);
                }
                this.f349b = true;
            }
        }

        @Override // a.b.c.g.n
        public void c(View view) {
            this.f349b = false;
            if (this.f348a.f344d > -1) {
                view.setLayerType(2, null);
            }
            m mVar = this.f348a;
            Runnable runnable = mVar.f342b;
            if (runnable != null) {
                mVar.f342b = null;
                runnable.run();
            }
            Object tag = view.getTag(2113929216);
            n nVar = tag instanceof n ? (n) tag : null;
            if (nVar != null) {
                nVar.c(view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(View view) {
        this.f341a = new WeakReference<>(view);
    }

    private void e(View view, n nVar) {
        if (nVar != null) {
            view.animate().setListener(new a(nVar, view));
        } else {
            view.animate().setListener(null);
        }
    }

    public m a(float f) {
        View view = this.f341a.get();
        if (view != null) {
            view.animate().alpha(f);
        }
        return this;
    }

    public void b() {
        View view = this.f341a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public m c(long j) {
        View view = this.f341a.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    public m d(n nVar) {
        View view = this.f341a.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                e(view, nVar);
            } else {
                view.setTag(2113929216, nVar);
                e(view, new b(this));
            }
        }
        return this;
    }

    public void f() {
        View view = this.f341a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public m g(float f) {
        View view = this.f341a.get();
        if (view != null) {
            view.animate().translationX(f);
        }
        return this;
    }

    public m h(float f) {
        View view = this.f341a.get();
        if (view != null) {
            view.animate().translationY(f);
        }
        return this;
    }
}
