package p034K1;

import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;
import p029J.C0335c;
import p032K.C0391i;
import p110k.C1564X;

/* JADX INFO: renamed from: K1.E */
/* JADX INFO: loaded from: classes.dex */
public final class C0411E extends C0335c {

    /* JADX INFO: renamed from: d */
    public final TextInputLayout f939d;

    public C0411E(TextInputLayout textInputLayout) {
        this.f939d = textInputLayout;
    }

    @Override // p029J.C0335c
    /* JADX INFO: renamed from: d */
    public final void mo192d(View view, C0391i c0391i) {
        View.AccessibilityDelegate accessibilityDelegate = this.f830a;
        AccessibilityNodeInfo accessibilityNodeInfo = c0391i.f920a;
        accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        TextInputLayout textInputLayout = this.f939d;
        EditText editText = textInputLayout.getEditText();
        Editable text = editText != null ? editText.getText() : null;
        CharSequence hint = textInputLayout.getHint();
        CharSequence error = textInputLayout.getError();
        CharSequence placeholderText = textInputLayout.getPlaceholderText();
        int counterMaxLength = textInputLayout.getCounterMaxLength();
        CharSequence counterOverflowDescription = textInputLayout.getCounterOverflowDescription();
        boolean zIsEmpty = TextUtils.isEmpty(text);
        boolean z3 = !zIsEmpty;
        boolean z4 = true;
        boolean z5 = !TextUtils.isEmpty(hint);
        boolean z6 = !textInputLayout.f4530v0;
        boolean z7 = !TextUtils.isEmpty(error);
        if (!z7 && TextUtils.isEmpty(counterOverflowDescription)) {
            z4 = false;
        }
        String string = z5 ? hint.toString() : "";
        C0439z c0439z = textInputLayout.f4497f;
        C1564X c1564x = c0439z.f1065f;
        if (c1564x.getVisibility() == 0) {
            accessibilityNodeInfo.setLabelFor(c1564x);
            accessibilityNodeInfo.setTraversalAfter(c1564x);
        } else {
            accessibilityNodeInfo.setTraversalAfter(c0439z.f1067h);
        }
        if (z3) {
            accessibilityNodeInfo.setText(text);
        } else if (!TextUtils.isEmpty(string)) {
            accessibilityNodeInfo.setText(string);
            if (z6 && placeholderText != null) {
                accessibilityNodeInfo.setText(string + ", " + ((Object) placeholderText));
            }
        } else if (placeholderText != null) {
            accessibilityNodeInfo.setText(placeholderText);
        }
        if (!TextUtils.isEmpty(string)) {
            accessibilityNodeInfo.setHintText(string);
            accessibilityNodeInfo.setShowingHintText(zIsEmpty);
        }
        if (text == null || text.length() != counterMaxLength) {
            counterMaxLength = -1;
        }
        accessibilityNodeInfo.setMaxTextLength(counterMaxLength);
        if (z4) {
            if (!z7) {
                error = counterOverflowDescription;
            }
            accessibilityNodeInfo.setError(error);
        }
        C1564X c1564x2 = textInputLayout.f4513n.f1047y;
        if (c1564x2 != null) {
            accessibilityNodeInfo.setLabelFor(c1564x2);
        }
        textInputLayout.f4499g.m942b().mo931n(c0391i);
    }

    @Override // p029J.C0335c
    /* JADX INFO: renamed from: e */
    public final void mo725e(View view, AccessibilityEvent accessibilityEvent) {
        super.mo725e(view, accessibilityEvent);
        this.f939d.f4499g.m942b().mo932o(accessibilityEvent);
    }
}
