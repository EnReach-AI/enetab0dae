package p055S;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.emoji2.text.C0902i;

/* JADX INFO: renamed from: S.i */
/* JADX INFO: loaded from: classes.dex */
public final class C0631i implements TextWatcher {

    /* JADX INFO: renamed from: e */
    public final EditText f1618e;

    /* JADX INFO: renamed from: g */
    public C0630h f1620g;

    /* JADX INFO: renamed from: f */
    public final boolean f1619f = false;

    /* JADX INFO: renamed from: h */
    public boolean f1621h = true;

    public C0631i(EditText editText) {
        this.f1618e = editText;
    }

    /* JADX INFO: renamed from: a */
    public static void m1446a(EditText editText, int i3) {
        int length;
        if (i3 == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            C0902i c0902iM2341a = C0902i.m2341a();
            if (editableText == null) {
                length = 0;
            } else {
                c0902iM2341a.getClass();
                length = editableText.length();
            }
            c0902iM2341a.m2346f(editableText, 0, length);
            if (selectionStart >= 0 && selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionStart, selectionEnd);
            } else if (selectionStart >= 0) {
                Selection.setSelection(editableText, selectionStart);
            } else if (selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionEnd);
            }
        }
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        EditText editText = this.f1618e;
        if (editText.isInEditMode() || !this.f1621h) {
            return;
        }
        if ((this.f1619f || C0902i.f2971j != null) && i4 <= i5 && (charSequence instanceof Spannable)) {
            int iM2342b = C0902i.m2341a().m2342b();
            if (iM2342b != 0) {
                if (iM2342b == 1) {
                    C0902i.m2341a().m2346f((Spannable) charSequence, i3, i5 + i3);
                    return;
                } else if (iM2342b != 3) {
                    return;
                }
            }
            C0902i c0902iM2341a = C0902i.m2341a();
            if (this.f1620g == null) {
                this.f1620g = new C0630h(editText);
            }
            c0902iM2341a.m2347g(this.f1620g);
        }
    }
}
