package p055S;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.widget.TextView;
import androidx.emoji2.text.AbstractC0900g;
import androidx.emoji2.text.C0902i;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: S.c */
/* JADX INFO: loaded from: classes.dex */
public final class C0625c extends AbstractC0900g {

    /* JADX INFO: renamed from: a */
    public final WeakReference f1607a;

    /* JADX INFO: renamed from: b */
    public final WeakReference f1608b;

    public C0625c(TextView textView, C0626d c0626d) {
        this.f1607a = new WeakReference(textView);
        this.f1608b = new WeakReference(c0626d);
    }

    @Override // androidx.emoji2.text.AbstractC0900g
    /* JADX INFO: renamed from: a */
    public final void mo1441a() {
        InputFilter[] filters;
        int length;
        TextView textView = (TextView) this.f1607a.get();
        InputFilter inputFilter = (InputFilter) this.f1608b.get();
        if (inputFilter == null || textView == null || (filters = textView.getFilters()) == null) {
            return;
        }
        for (InputFilter inputFilter2 : filters) {
            if (inputFilter2 == inputFilter) {
                if (textView.isAttachedToWindow()) {
                    CharSequence text = textView.getText();
                    C0902i c0902iM2341a = C0902i.m2341a();
                    if (text == null) {
                        length = 0;
                    } else {
                        c0902iM2341a.getClass();
                        length = text.length();
                    }
                    CharSequence charSequenceM2346f = c0902iM2341a.m2346f(text, 0, length);
                    if (text == charSequenceM2346f) {
                        return;
                    }
                    int selectionStart = Selection.getSelectionStart(charSequenceM2346f);
                    int selectionEnd = Selection.getSelectionEnd(charSequenceM2346f);
                    textView.setText(charSequenceM2346f);
                    if (charSequenceM2346f instanceof Spannable) {
                        Spannable spannable = (Spannable) charSequenceM2346f;
                        if (selectionStart >= 0 && selectionEnd >= 0) {
                            Selection.setSelection(spannable, selectionStart, selectionEnd);
                            return;
                        } else if (selectionStart >= 0) {
                            Selection.setSelection(spannable, selectionStart);
                            return;
                        } else {
                            if (selectionEnd >= 0) {
                                Selection.setSelection(spannable, selectionEnd);
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
                return;
            }
        }
    }
}
