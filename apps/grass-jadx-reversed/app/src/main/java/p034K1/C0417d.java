package p034K1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* JADX INFO: renamed from: K1.d */
/* JADX INFO: loaded from: classes.dex */
public final class C0417d extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f948a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ C0418e f949b;

    public /* synthetic */ C0417d(C0418e c0418e, int i3) {
        this.f948a = i3;
        this.f949b = c0418e;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        switch (this.f948a) {
            case 1:
                this.f949b.f1012b.m947g(false);
                break;
            default:
                super.onAnimationEnd(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.f948a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                this.f949b.f1012b.m947g(true);
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }
}
