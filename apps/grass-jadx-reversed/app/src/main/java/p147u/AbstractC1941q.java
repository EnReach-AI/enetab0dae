package p147u;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import p140s.C1867g;

/* JADX INFO: renamed from: u.q */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1941q extends AbstractC1926b {

    /* JADX INFO: renamed from: k */
    public boolean f6933k;

    /* JADX INFO: renamed from: l */
    public boolean f6934l;

    @Override // p147u.AbstractC1926b
    /* JADX INFO: renamed from: e */
    public void mo2289e(AttributeSet attributeSet) {
        super.mo2289e(attributeSet);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, AbstractC1940p.f6925b);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i3);
                if (index == 6) {
                    this.f6933k = true;
                } else if (index == 13) {
                    this.f6934l = true;
                }
            }
        }
    }

    /* JADX INFO: renamed from: h */
    public abstract void mo2291h(C1867g c1867g, int i3, int i4);

    @Override // p147u.AbstractC1926b, android.view.View
    public final void onAttachedToWindow() {
        ViewParent parent;
        super.onAttachedToWindow();
        if ((this.f6933k || this.f6934l) && (parent = getParent()) != null && (parent instanceof ConstraintLayout)) {
            ConstraintLayout constraintLayout = (ConstraintLayout) parent;
            int visibility = getVisibility();
            float elevation = getElevation();
            for (int i3 = 0; i3 < this.f6748f; i3++) {
                View view = (View) constraintLayout.f2872e.get(this.f6747e[i3]);
                if (view != null) {
                    if (this.f6933k) {
                        view.setVisibility(visibility);
                    }
                    if (this.f6934l && elevation > 0.0f) {
                        view.setTranslationZ(view.getTranslationZ() + elevation);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public void setElevation(float f3) {
        super.setElevation(f3);
        m4322c();
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
        m4322c();
    }
}
