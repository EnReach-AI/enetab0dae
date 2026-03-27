package p157w1;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.material.chip.Chip;
import io.getgrass.www.R;
import java.util.ArrayList;
import p032K.C0390h;
import p032K.C0391i;
import p049Q.AbstractC0584b;

/* JADX INFO: renamed from: w1.c */
/* JADX INFO: loaded from: classes.dex */
public final class C1994c extends AbstractC0584b {

    /* JADX INFO: renamed from: q */
    public final /* synthetic */ Chip f7069q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1994c(Chip chip, Chip chip2) {
        super(chip2);
        this.f7069q = chip;
    }

    @Override // p049Q.AbstractC0584b
    /* JADX INFO: renamed from: l */
    public final void mo1311l(ArrayList arrayList) {
        boolean z3 = false;
        arrayList.add(0);
        Rect rect = Chip.f4319A;
        Chip chip = this.f7069q;
        if (chip.m3170c()) {
            C1996e c1996e = chip.f4322i;
            if (c1996e != null && c1996e.f7095O) {
                z3 = true;
            }
            if (!z3 || chip.f4325l == null) {
                return;
            }
            arrayList.add(1);
        }
    }

    @Override // p049Q.AbstractC0584b
    /* JADX INFO: renamed from: o */
    public final void mo1314o(int i3, C0391i c0391i) {
        AccessibilityNodeInfo accessibilityNodeInfo = c0391i.f920a;
        if (i3 != 1) {
            accessibilityNodeInfo.setContentDescription("");
            accessibilityNodeInfo.setBoundsInParent(Chip.f4319A);
            return;
        }
        Chip chip = this.f7069q;
        CharSequence closeIconContentDescription = chip.getCloseIconContentDescription();
        if (closeIconContentDescription != null) {
            accessibilityNodeInfo.setContentDescription(closeIconContentDescription);
        } else {
            CharSequence text = chip.getText();
            accessibilityNodeInfo.setContentDescription(chip.getContext().getString(R.string.mtrl_chip_close_icon_content_description, TextUtils.isEmpty(text) ? "" : text).trim());
        }
        accessibilityNodeInfo.setBoundsInParent(chip.getCloseIconTouchBoundsInt());
        c0391i.m869b(C0390h.f908e);
        accessibilityNodeInfo.setEnabled(chip.isEnabled());
    }
}
