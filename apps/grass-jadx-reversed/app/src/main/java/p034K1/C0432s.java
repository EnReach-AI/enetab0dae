package p034K1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;
import p110k.C1564X;

/* JADX INFO: renamed from: K1.s */
/* JADX INFO: loaded from: classes.dex */
public final class C0432s extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1015a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ TextView f1016b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ int f1017c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ TextView f1018d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ C0434u f1019e;

    public C0432s(C0434u c0434u, int i3, TextView textView, int i4, TextView textView2) {
        this.f1019e = c0434u;
        this.f1015a = i3;
        this.f1016b = textView;
        this.f1017c = i4;
        this.f1018d = textView2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        C1564X c1564x;
        int i3 = this.f1015a;
        C0434u c0434u = this.f1019e;
        c0434u.f1036n = i3;
        c0434u.f1034l = null;
        TextView textView = this.f1016b;
        if (textView != null) {
            textView.setVisibility(4);
            if (this.f1017c == 1 && (c1564x = c0434u.f1040r) != null) {
                c1564x.setText((CharSequence) null);
            }
        }
        TextView textView2 = this.f1018d;
        if (textView2 != null) {
            textView2.setTranslationY(0.0f);
            textView2.setAlpha(1.0f);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        TextView textView = this.f1018d;
        if (textView != null) {
            textView.setVisibility(0);
            textView.setAlpha(0.0f);
        }
    }
}
