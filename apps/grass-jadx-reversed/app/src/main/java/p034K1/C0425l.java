package p034K1;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import com.google.android.material.textfield.TextInputLayout;
import io.getgrass.www.R;
import java.util.WeakHashMap;
import p028I1.RunnableC0304d;
import p029J.AbstractC0307B;
import p029J.AbstractC0323S;
import p029J.C0327W;
import p032K.C0391i;
import p032K.InterfaceC0386d;
import p125o0.AbstractC1794d;
import p130p1.AbstractC1824a;

/* JADX INFO: renamed from: K1.l */
/* JADX INFO: loaded from: classes.dex */
public final class C0425l extends AbstractC0431r {

    /* JADX INFO: renamed from: e */
    public final int f967e;

    /* JADX INFO: renamed from: f */
    public final int f968f;

    /* JADX INFO: renamed from: g */
    public final TimeInterpolator f969g;

    /* JADX INFO: renamed from: h */
    public AutoCompleteTextView f970h;

    /* JADX INFO: renamed from: i */
    public final ViewOnClickListenerC0414a f971i;

    /* JADX INFO: renamed from: j */
    public final ViewOnFocusChangeListenerC0415b f972j;

    /* JADX INFO: renamed from: k */
    public final C0423j f973k;

    /* JADX INFO: renamed from: l */
    public boolean f974l;

    /* JADX INFO: renamed from: m */
    public boolean f975m;

    /* JADX INFO: renamed from: n */
    public boolean f976n;

    /* JADX INFO: renamed from: o */
    public long f977o;

    /* JADX INFO: renamed from: p */
    public AccessibilityManager f978p;

    /* JADX INFO: renamed from: q */
    public ValueAnimator f979q;

    /* JADX INFO: renamed from: r */
    public ValueAnimator f980r;

    public C0425l(C0430q c0430q) {
        super(c0430q);
        this.f971i = new ViewOnClickListenerC0414a(this, 1);
        this.f972j = new ViewOnFocusChangeListenerC0415b(this, 1);
        this.f973k = new C0423j(this);
        this.f977o = Long.MAX_VALUE;
        this.f968f = AbstractC1794d.m3954l(c0430q.getContext(), R.attr.motionDurationShort3, 67);
        this.f967e = AbstractC1794d.m3954l(c0430q.getContext(), R.attr.motionDurationShort3, 50);
        this.f969g = AbstractC1794d.m3955m(c0430q.getContext(), R.attr.motionEasingLinearInterpolator, AbstractC1824a.f6320a);
    }

    @Override // p034K1.AbstractC0431r
    /* JADX INFO: renamed from: a */
    public final void mo914a() {
        if (this.f978p.isTouchExplorationEnabled() && AbstractC1794d.m3951g(this.f970h) && !this.f1014d.hasFocus()) {
            this.f970h.dismissDropDown();
        }
        this.f970h.post(new RunnableC0304d(2, this));
    }

    @Override // p034K1.AbstractC0431r
    /* JADX INFO: renamed from: c */
    public final int mo915c() {
        return R.string.exposed_dropdown_menu_content_description;
    }

    @Override // p034K1.AbstractC0431r
    /* JADX INFO: renamed from: d */
    public final int mo916d() {
        return R.drawable.mtrl_dropdown_arrow;
    }

    @Override // p034K1.AbstractC0431r
    /* JADX INFO: renamed from: e */
    public final View.OnFocusChangeListener mo917e() {
        return this.f972j;
    }

    @Override // p034K1.AbstractC0431r
    /* JADX INFO: renamed from: f */
    public final View.OnClickListener mo918f() {
        return this.f971i;
    }

    @Override // p034K1.AbstractC0431r
    /* JADX INFO: renamed from: h */
    public final InterfaceC0386d mo927h() {
        return this.f973k;
    }

    @Override // p034K1.AbstractC0431r
    /* JADX INFO: renamed from: i */
    public final boolean mo928i(int i3) {
        return i3 != 0;
    }

    @Override // p034K1.AbstractC0431r
    /* JADX INFO: renamed from: j */
    public final boolean mo929j() {
        return this.f974l;
    }

    @Override // p034K1.AbstractC0431r
    /* JADX INFO: renamed from: l */
    public final boolean mo930l() {
        return this.f976n;
    }

    @Override // p034K1.AbstractC0431r
    /* JADX INFO: renamed from: m */
    public final void mo920m(EditText editText) {
        if (!(editText instanceof AutoCompleteTextView)) {
            throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
        }
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
        this.f970h = autoCompleteTextView;
        autoCompleteTextView.setOnTouchListener(new View.OnTouchListener() { // from class: K1.h
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                C0425l c0425l = this.f962e;
                c0425l.getClass();
                if (motionEvent.getAction() == 1) {
                    long jCurrentTimeMillis = System.currentTimeMillis() - c0425l.f977o;
                    if (jCurrentTimeMillis < 0 || jCurrentTimeMillis > 300) {
                        c0425l.f975m = false;
                    }
                    c0425l.m934u();
                    c0425l.f975m = true;
                    c0425l.f977o = System.currentTimeMillis();
                }
                return false;
            }
        });
        this.f970h.setOnDismissListener(new AutoCompleteTextView.OnDismissListener() { // from class: K1.i
            @Override // android.widget.AutoCompleteTextView.OnDismissListener
            public final void onDismiss() {
                C0425l c0425l = this.f963a;
                c0425l.f975m = true;
                c0425l.f977o = System.currentTimeMillis();
                c0425l.m933t(false);
            }
        });
        this.f970h.setThreshold(0);
        TextInputLayout textInputLayout = this.f1011a;
        textInputLayout.setErrorIconDrawable((Drawable) null);
        if (!AbstractC1794d.m3951g(editText) && this.f978p.isTouchExplorationEnabled()) {
            WeakHashMap weakHashMap = AbstractC0323S.f816a;
            AbstractC0307B.m603s(this.f1014d, 2);
        }
        textInputLayout.setEndIconVisible(true);
    }

    @Override // p034K1.AbstractC0431r
    /* JADX INFO: renamed from: n */
    public final void mo931n(C0391i c0391i) {
        boolean zM3951g = AbstractC1794d.m3951g(this.f970h);
        AccessibilityNodeInfo accessibilityNodeInfo = c0391i.f920a;
        if (!zM3951g) {
            accessibilityNodeInfo.setClassName(Spinner.class.getName());
        }
        if (accessibilityNodeInfo.isShowingHintText()) {
            accessibilityNodeInfo.setHintText(null);
        }
    }

    @Override // p034K1.AbstractC0431r
    /* JADX INFO: renamed from: o */
    public final void mo932o(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 1 && this.f978p.isEnabled() && !AbstractC1794d.m3951g(this.f970h)) {
            m934u();
            this.f975m = true;
            this.f977o = System.currentTimeMillis();
        }
    }

    @Override // p034K1.AbstractC0431r
    /* JADX INFO: renamed from: r */
    public final void mo922r() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = this.f969g;
        valueAnimatorOfFloat.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat.setDuration(this.f968f);
        valueAnimatorOfFloat.addUpdateListener(new C0327W(this));
        this.f980r = valueAnimatorOfFloat;
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat2.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat2.setDuration(this.f967e);
        valueAnimatorOfFloat2.addUpdateListener(new C0327W(this));
        this.f979q = valueAnimatorOfFloat2;
        valueAnimatorOfFloat2.addListener(new C0424k(0, this));
        this.f978p = (AccessibilityManager) this.f1013c.getSystemService("accessibility");
    }

    @Override // p034K1.AbstractC0431r
    /* JADX INFO: renamed from: s */
    public final void mo923s() {
        AutoCompleteTextView autoCompleteTextView = this.f970h;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setOnTouchListener(null);
            this.f970h.setOnDismissListener(null);
        }
    }

    /* JADX INFO: renamed from: t */
    public final void m933t(boolean z3) {
        if (this.f976n != z3) {
            this.f976n = z3;
            this.f980r.cancel();
            this.f979q.start();
        }
    }

    /* JADX INFO: renamed from: u */
    public final void m934u() {
        if (this.f970h == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f977o;
        if (jCurrentTimeMillis < 0 || jCurrentTimeMillis > 300) {
            this.f975m = false;
        }
        if (this.f975m) {
            this.f975m = false;
            return;
        }
        m933t(!this.f976n);
        if (!this.f976n) {
            this.f970h.dismissDropDown();
        } else {
            this.f970h.requestFocus();
            this.f970h.showDropDown();
        }
    }
}
