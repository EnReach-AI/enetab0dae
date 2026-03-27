package p034K1;

import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: renamed from: K1.n */
/* JADX INFO: loaded from: classes.dex */
public final class C0427n {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C0430q f982a;

    public C0427n(C0430q c0430q) {
        this.f982a = c0430q;
    }

    /* JADX INFO: renamed from: a */
    public final void m935a(TextInputLayout textInputLayout) {
        C0430q c0430q = this.f982a;
        if (c0430q.f1007w == textInputLayout.getEditText()) {
            return;
        }
        EditText editText = c0430q.f1007w;
        C0426m c0426m = c0430q.f1010z;
        if (editText != null) {
            editText.removeTextChangedListener(c0426m);
            if (c0430q.f1007w.getOnFocusChangeListener() == c0430q.m942b().mo917e()) {
                c0430q.f1007w.setOnFocusChangeListener(null);
            }
        }
        EditText editText2 = textInputLayout.getEditText();
        c0430q.f1007w = editText2;
        if (editText2 != null) {
            editText2.addTextChangedListener(c0426m);
        }
        c0430q.m942b().mo920m(c0430q.f1007w);
        c0430q.m949i(c0430q.m942b());
    }
}
