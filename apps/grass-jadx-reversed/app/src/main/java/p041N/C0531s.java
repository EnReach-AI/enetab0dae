package p041N;

import android.content.ClipData;
import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import p029J.C0343g;
import p029J.InterfaceC0341f;
import p029J.InterfaceC0369t;

/* JADX INFO: renamed from: N.s */
/* JADX INFO: loaded from: classes.dex */
public final class C0531s implements InterfaceC0369t {
    /* JADX INFO: renamed from: a */
    public final C0343g m1070a(View view, C0343g c0343g) {
        CharSequence charSequenceCoerceToStyledText;
        if (Log.isLoggable("ReceiveContent", 3)) {
            Log.d("ReceiveContent", "onReceive: " + c0343g);
        }
        if (c0343g.f849a.mo453n() == 2) {
            return c0343g;
        }
        InterfaceC0341f interfaceC0341f = c0343g.f849a;
        ClipData clipDataMo443b = interfaceC0341f.mo443b();
        int iMo446f = interfaceC0341f.mo446f();
        TextView textView = (TextView) view;
        Editable editable = (Editable) textView.getText();
        Context context = textView.getContext();
        boolean z3 = false;
        for (int i3 = 0; i3 < clipDataMo443b.getItemCount(); i3++) {
            ClipData.Item itemAt = clipDataMo443b.getItemAt(i3);
            if ((iMo446f & 1) != 0) {
                charSequenceCoerceToStyledText = itemAt.coerceToText(context);
                if (charSequenceCoerceToStyledText instanceof Spanned) {
                    charSequenceCoerceToStyledText = charSequenceCoerceToStyledText.toString();
                }
            } else {
                charSequenceCoerceToStyledText = itemAt.coerceToStyledText(context);
            }
            if (charSequenceCoerceToStyledText != null) {
                if (z3) {
                    editable.insert(Selection.getSelectionEnd(editable), "\n");
                    editable.insert(Selection.getSelectionEnd(editable), charSequenceCoerceToStyledText);
                } else {
                    int selectionStart = Selection.getSelectionStart(editable);
                    int selectionEnd = Selection.getSelectionEnd(editable);
                    int iMax = Math.max(0, Math.min(selectionStart, selectionEnd));
                    int iMax2 = Math.max(0, Math.max(selectionStart, selectionEnd));
                    Selection.setSelection(editable, iMax2);
                    editable.replace(iMax, iMax2, charSequenceCoerceToStyledText);
                    z3 = true;
                }
            }
        }
        return null;
    }
}
