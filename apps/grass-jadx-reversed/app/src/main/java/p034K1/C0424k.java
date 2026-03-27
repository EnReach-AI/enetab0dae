package p034K1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.res.ColorStateList;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import java.util.ArrayList;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p009C.AbstractC0139b;
import p087d0.AbstractC1293l;
import p091e0.C1325f;
import p153v1.C1974a;
import p153v1.C1976c;

/* JADX INFO: renamed from: K1.k */
/* JADX INFO: loaded from: classes.dex */
public final class C0424k extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f965a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f966b;

    public /* synthetic */ C0424k(int i3, Object obj) {
        this.f965a = i3;
        this.f966b = obj;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.f965a) {
            case FromStringDeserializer.Std.STD_URI /* 3 */:
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.f966b;
                actionBarOverlayLayout.f2711A = null;
                actionBarOverlayLayout.f2726o = false;
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f965a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                C0425l c0425l = (C0425l) this.f966b;
                c0425l.m956q();
                c0425l.f980r.start();
                break;
            case 1:
                ((AbstractC1293l) this.f966b).m3270l();
                animator.removeListener(this);
                break;
            case 2:
                C1325f c1325f = (C1325f) this.f966b;
                ArrayList arrayList = new ArrayList(c1325f.f4695i);
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ColorStateList colorStateList = ((C1974a) arrayList.get(i3)).f6995b.f7013s;
                    if (colorStateList != null) {
                        AbstractC0139b.m280h(c1325f, colorStateList);
                    }
                }
                break;
            case FromStringDeserializer.Std.STD_URI /* 3 */:
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.f966b;
                actionBarOverlayLayout.f2711A = null;
                actionBarOverlayLayout.f2726o = false;
                break;
            default:
                ((HideBottomViewOnScrollBehavior) this.f966b).f4228h = null;
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.f965a) {
            case 2:
                C1325f c1325f = (C1325f) this.f966b;
                ArrayList arrayList = new ArrayList(c1325f.f4695i);
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    C1976c c1976c = ((C1974a) arrayList.get(i3)).f6995b;
                    ColorStateList colorStateList = c1976c.f7013s;
                    if (colorStateList != null) {
                        AbstractC0139b.m279g(c1325f, colorStateList.getColorForState(c1976c.f7017w, colorStateList.getDefaultColor()));
                    }
                }
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }
}
