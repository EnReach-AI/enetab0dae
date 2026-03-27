package p055S;

import android.text.InputFilter;
import android.text.Spanned;
import android.widget.TextView;
import androidx.emoji2.text.C0902i;

/* JADX INFO: renamed from: S.d */
/* JADX INFO: loaded from: classes.dex */
public final class C0626d implements InputFilter {

    /* JADX INFO: renamed from: a */
    public final TextView f1609a;

    /* JADX INFO: renamed from: b */
    public C0625c f1610b;

    public C0626d(TextView textView) {
        this.f1609a = textView;
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence charSequence, int i3, int i4, Spanned spanned, int i5, int i6) {
        TextView textView = this.f1609a;
        if (textView.isInEditMode()) {
            return charSequence;
        }
        int iM2342b = C0902i.m2341a().m2342b();
        if (iM2342b != 0) {
            if (iM2342b == 1) {
                if ((i6 == 0 && i5 == 0 && spanned.length() == 0 && charSequence == textView.getText()) || charSequence == null) {
                    return charSequence;
                }
                if (i3 != 0 || i4 != charSequence.length()) {
                    charSequence = charSequence.subSequence(i3, i4);
                }
                return C0902i.m2341a().m2346f(charSequence, 0, charSequence.length());
            }
            if (iM2342b != 3) {
                return charSequence;
            }
        }
        C0902i c0902iM2341a = C0902i.m2341a();
        if (this.f1610b == null) {
            this.f1610b = new C0625c(textView, this);
        }
        c0902iM2341a.m2347g(this.f1610b);
        return charSequence;
    }
}
