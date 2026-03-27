package p087d0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import p039M0.AbstractC0493h0;

/* JADX INFO: renamed from: d0.v */
/* JADX INFO: loaded from: classes.dex */
public final class C1303v extends AnimatorListenerAdapter implements InterfaceC1292k {

    /* JADX INFO: renamed from: a */
    public final View f4655a;

    /* JADX INFO: renamed from: b */
    public final int f4656b;

    /* JADX INFO: renamed from: c */
    public final ViewGroup f4657c;

    /* JADX INFO: renamed from: e */
    public boolean f4659e;

    /* JADX INFO: renamed from: f */
    public boolean f4660f = false;

    /* JADX INFO: renamed from: d */
    public final boolean f4658d = true;

    public C1303v(View view, int i3) {
        this.f4655a = view;
        this.f4656b = i3;
        this.f4657c = (ViewGroup) view.getParent();
        m3281f(true);
    }

    @Override // p087d0.InterfaceC1292k
    /* JADX INFO: renamed from: a */
    public final void mo3250a() {
    }

    @Override // p087d0.InterfaceC1292k
    /* JADX INFO: renamed from: b */
    public final void mo3257b() {
    }

    @Override // p087d0.InterfaceC1292k
    /* JADX INFO: renamed from: c */
    public final void mo3251c() {
        m3281f(false);
    }

    @Override // p087d0.InterfaceC1292k
    /* JADX INFO: renamed from: d */
    public final void mo3252d(AbstractC1293l abstractC1293l) {
        if (!this.f4660f) {
            AbstractC1299r.f4645a.mo1941i(this.f4655a, this.f4656b);
            ViewGroup viewGroup = this.f4657c;
            if (viewGroup != null) {
                viewGroup.invalidate();
            }
        }
        m3281f(false);
        abstractC1293l.m3274u(this);
    }

    @Override // p087d0.InterfaceC1292k
    /* JADX INFO: renamed from: e */
    public final void mo3253e() {
        m3281f(true);
    }

    /* JADX INFO: renamed from: f */
    public final void m3281f(boolean z3) {
        ViewGroup viewGroup;
        if (!this.f4658d || this.f4659e == z3 || (viewGroup = this.f4657c) == null) {
            return;
        }
        this.f4659e = z3;
        AbstractC0493h0.m1012e(viewGroup, z3);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.f4660f = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        if (!this.f4660f) {
            AbstractC1299r.f4645a.mo1941i(this.f4655a, this.f4656b);
            ViewGroup viewGroup = this.f4657c;
            if (viewGroup != null) {
                viewGroup.invalidate();
            }
        }
        m3281f(false);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public final void onAnimationPause(Animator animator) {
        if (this.f4660f) {
            return;
        }
        AbstractC1299r.f4645a.mo1941i(this.f4655a, this.f4656b);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public final void onAnimationResume(Animator animator) {
        if (this.f4660f) {
            return;
        }
        AbstractC1299r.f4645a.mo1941i(this.f4655a, 0);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
    }
}
