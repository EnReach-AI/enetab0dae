package p055S;

import android.text.InputFilter;
import android.widget.TextView;
import androidx.emoji2.text.C0902i;
import p148u0.AbstractC1946e;

/* JADX INFO: renamed from: S.g */
/* JADX INFO: loaded from: classes.dex */
public final class C0629g extends AbstractC1946e {

    /* JADX INFO: renamed from: b */
    public final C0628f f1616b;

    public C0629g(TextView textView) {
        this.f1616b = new C0628f(textView);
    }

    @Override // p148u0.AbstractC1946e
    /* JADX INFO: renamed from: a */
    public final InputFilter[] mo1442a(InputFilter[] inputFilterArr) {
        return (C0902i.f2971j != null) ^ true ? inputFilterArr : this.f1616b.mo1442a(inputFilterArr);
    }

    @Override // p148u0.AbstractC1946e
    /* JADX INFO: renamed from: j */
    public final void mo1443j(boolean z3) {
        if (!(C0902i.f2971j != null)) {
            return;
        }
        this.f1616b.mo1443j(z3);
    }

    @Override // p148u0.AbstractC1946e
    /* JADX INFO: renamed from: k */
    public final void mo1444k(boolean z3) {
        boolean z4 = !(C0902i.f2971j != null);
        C0628f c0628f = this.f1616b;
        if (z4) {
            c0628f.f1615d = z3;
        } else {
            c0628f.mo1444k(z3);
        }
    }
}
