package p055S;

import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import androidx.emoji2.text.C0902i;

/* JADX INFO: renamed from: S.j */
/* JADX INFO: loaded from: classes.dex */
public final class C0632j implements TransformationMethod {

    /* JADX INFO: renamed from: a */
    public final TransformationMethod f1622a;

    public C0632j(TransformationMethod transformationMethod) {
        this.f1622a = transformationMethod;
    }

    @Override // android.text.method.TransformationMethod
    public final CharSequence getTransformation(CharSequence charSequence, View view) {
        if (view.isInEditMode()) {
            return charSequence;
        }
        TransformationMethod transformationMethod = this.f1622a;
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, view);
        }
        if (charSequence == null || C0902i.m2341a().m2342b() != 1) {
            return charSequence;
        }
        C0902i c0902iM2341a = C0902i.m2341a();
        c0902iM2341a.getClass();
        return c0902iM2341a.m2346f(charSequence, 0, charSequence.length());
    }

    @Override // android.text.method.TransformationMethod
    public final void onFocusChanged(View view, CharSequence charSequence, boolean z3, int i3, Rect rect) {
        TransformationMethod transformationMethod = this.f1622a;
        if (transformationMethod != null) {
            transformationMethod.onFocusChanged(view, charSequence, z3, i3, rect);
        }
    }
}
