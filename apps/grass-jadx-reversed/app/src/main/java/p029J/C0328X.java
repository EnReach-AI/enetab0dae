package p029J;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p087d0.AbstractC1293l;
import p128p.C1808b;

/* JADX INFO: renamed from: J.X */
/* JADX INFO: loaded from: classes.dex */
public final class C0328X extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f824a = 0;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f825b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f826c;

    public C0328X(InterfaceC0332a0 interfaceC0332a0, View view) {
        this.f825b = interfaceC0332a0;
        this.f826c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.f824a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                ((InterfaceC0332a0) this.f825b).mo342b((View) this.f826c);
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f824a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                ((InterfaceC0332a0) this.f825b).mo341a();
                break;
            default:
                ((C1808b) this.f825b).remove(animator);
                ((AbstractC1293l) this.f826c).f4628q.remove(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.f824a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                ((InterfaceC0332a0) this.f825b).mo343c();
                break;
            default:
                ((AbstractC1293l) this.f826c).f4628q.add(animator);
                break;
        }
    }

    public C0328X(AbstractC1293l abstractC1293l, C1808b c1808b) {
        this.f826c = abstractC1293l;
        this.f825b = c1808b;
    }
}
