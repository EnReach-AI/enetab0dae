package p034K1;

import android.text.Editable;
import p007B1.AbstractC0053m;

/* JADX INFO: renamed from: K1.m */
/* JADX INFO: loaded from: classes.dex */
public final class C0426m extends AbstractC0053m {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ C0430q f981e;

    public C0426m(C0430q c0430q) {
        this.f981e = c0430q;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        this.f981e.m942b().mo914a();
    }

    @Override // p007B1.AbstractC0053m, android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        this.f981e.m942b().mo954b();
    }
}
