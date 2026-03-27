package p034K1;

import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.internal.CheckableImageButton;
import io.getgrass.www.R;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p028I1.RunnableC0304d;
import p125o0.AbstractC1794d;
import p130p1.AbstractC1824a;

/* JADX INFO: renamed from: K1.e */
/* JADX INFO: loaded from: classes.dex */
public final class C0418e extends AbstractC0431r {

    /* JADX INFO: renamed from: e */
    public final int f950e;

    /* JADX INFO: renamed from: f */
    public final int f951f;

    /* JADX INFO: renamed from: g */
    public final TimeInterpolator f952g;

    /* JADX INFO: renamed from: h */
    public final TimeInterpolator f953h;

    /* JADX INFO: renamed from: i */
    public EditText f954i;

    /* JADX INFO: renamed from: j */
    public final ViewOnClickListenerC0414a f955j;

    /* JADX INFO: renamed from: k */
    public final ViewOnFocusChangeListenerC0415b f956k;

    /* JADX INFO: renamed from: l */
    public AnimatorSet f957l;

    /* JADX INFO: renamed from: m */
    public ValueAnimator f958m;

    public C0418e(C0430q c0430q) {
        super(c0430q);
        this.f955j = new ViewOnClickListenerC0414a(this, 0);
        this.f956k = new ViewOnFocusChangeListenerC0415b(this, 0);
        this.f950e = AbstractC1794d.m3954l(c0430q.getContext(), R.attr.motionDurationShort3, 100);
        this.f951f = AbstractC1794d.m3954l(c0430q.getContext(), R.attr.motionDurationShort3, 150);
        this.f952g = AbstractC1794d.m3955m(c0430q.getContext(), R.attr.motionEasingLinearInterpolator, AbstractC1824a.f6320a);
        this.f953h = AbstractC1794d.m3955m(c0430q.getContext(), R.attr.motionEasingEmphasizedInterpolator, AbstractC1824a.f6323d);
    }

    @Override // p034K1.AbstractC0431r
    /* JADX INFO: renamed from: a */
    public final void mo914a() {
        if (this.f1012b.f1004t != null) {
            return;
        }
        m924t(m925u());
    }

    @Override // p034K1.AbstractC0431r
    /* JADX INFO: renamed from: c */
    public final int mo915c() {
        return R.string.clear_text_end_icon_content_description;
    }

    @Override // p034K1.AbstractC0431r
    /* JADX INFO: renamed from: d */
    public final int mo916d() {
        return R.drawable.mtrl_ic_cancel;
    }

    @Override // p034K1.AbstractC0431r
    /* JADX INFO: renamed from: e */
    public final View.OnFocusChangeListener mo917e() {
        return this.f956k;
    }

    @Override // p034K1.AbstractC0431r
    /* JADX INFO: renamed from: f */
    public final View.OnClickListener mo918f() {
        return this.f955j;
    }

    @Override // p034K1.AbstractC0431r
    /* JADX INFO: renamed from: g */
    public final View.OnFocusChangeListener mo919g() {
        return this.f956k;
    }

    @Override // p034K1.AbstractC0431r
    /* JADX INFO: renamed from: m */
    public final void mo920m(EditText editText) {
        this.f954i = editText;
        this.f1011a.setEndIconVisible(m925u());
    }

    @Override // p034K1.AbstractC0431r
    /* JADX INFO: renamed from: p */
    public final void mo921p(boolean z3) {
        if (this.f1012b.f1004t == null) {
            return;
        }
        m924t(z3);
    }

    @Override // p034K1.AbstractC0431r
    /* JADX INFO: renamed from: r */
    public final void mo922r() {
        final int i3 = 1;
        final int i4 = 0;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(this.f953h);
        valueAnimatorOfFloat.setDuration(this.f951f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: K1.c

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ C0418e f947b;

            {
                this.f947b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i3) {
                    case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                        C0418e c0418e = this.f947b;
                        c0418e.getClass();
                        c0418e.f1014d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        C0418e c0418e2 = this.f947b;
                        c0418e2.getClass();
                        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        CheckableImageButton checkableImageButton = c0418e2.f1014d;
                        checkableImageButton.setScaleX(fFloatValue);
                        checkableImageButton.setScaleY(fFloatValue);
                        break;
                }
            }
        });
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = this.f952g;
        valueAnimatorOfFloat2.setInterpolator(timeInterpolator);
        int i5 = this.f950e;
        valueAnimatorOfFloat2.setDuration(i5);
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: K1.c

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ C0418e f947b;

            {
                this.f947b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i4) {
                    case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                        C0418e c0418e = this.f947b;
                        c0418e.getClass();
                        c0418e.f1014d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        C0418e c0418e2 = this.f947b;
                        c0418e2.getClass();
                        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        CheckableImageButton checkableImageButton = c0418e2.f1014d;
                        checkableImageButton.setScaleX(fFloatValue);
                        checkableImageButton.setScaleY(fFloatValue);
                        break;
                }
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        this.f957l = animatorSet;
        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2);
        this.f957l.addListener(new C0417d(this, i4));
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat3.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat3.setDuration(i5);
        valueAnimatorOfFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: K1.c

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ C0418e f947b;

            {
                this.f947b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i4) {
                    case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                        C0418e c0418e = this.f947b;
                        c0418e.getClass();
                        c0418e.f1014d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        C0418e c0418e2 = this.f947b;
                        c0418e2.getClass();
                        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        CheckableImageButton checkableImageButton = c0418e2.f1014d;
                        checkableImageButton.setScaleX(fFloatValue);
                        checkableImageButton.setScaleY(fFloatValue);
                        break;
                }
            }
        });
        this.f958m = valueAnimatorOfFloat3;
        valueAnimatorOfFloat3.addListener(new C0417d(this, i3));
    }

    @Override // p034K1.AbstractC0431r
    /* JADX INFO: renamed from: s */
    public final void mo923s() {
        EditText editText = this.f954i;
        if (editText != null) {
            editText.post(new RunnableC0304d(1, this));
        }
    }

    /* JADX INFO: renamed from: t */
    public final void m924t(boolean z3) {
        boolean z4 = this.f1012b.m943c() == z3;
        if (z3 && !this.f957l.isRunning()) {
            this.f958m.cancel();
            this.f957l.start();
            if (z4) {
                this.f957l.end();
                return;
            }
            return;
        }
        if (z3) {
            return;
        }
        this.f957l.cancel();
        this.f958m.start();
        if (z4) {
            this.f958m.end();
        }
    }

    /* JADX INFO: renamed from: u */
    public final boolean m925u() {
        EditText editText = this.f954i;
        return editText != null && (editText.hasFocus() || this.f1014d.hasFocus()) && this.f954i.getText().length() > 0;
    }
}
