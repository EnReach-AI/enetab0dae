package p007B1;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.datepicker.C1258j;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.NavigationMenuItemView;
import io.getgrass.www.R;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p029J.C0335c;
import p032K.C0391i;
import p036L0.C0444d;

/* JADX INFO: renamed from: B1.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0041a extends C0335c {

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ int f107d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ Object f108e;

    public /* synthetic */ C0041a(int i3, Object obj) {
        this.f107d = i3;
        this.f108e = obj;
    }

    @Override // p029J.C0335c
    /* JADX INFO: renamed from: c */
    public void mo191c(View view, AccessibilityEvent accessibilityEvent) {
        switch (this.f107d) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                super.mo191c(view, accessibilityEvent);
                accessibilityEvent.setChecked(((CheckableImageButton) this.f108e).f4424h);
                break;
            default:
                super.mo191c(view, accessibilityEvent);
                break;
        }
    }

    @Override // p029J.C0335c
    /* JADX INFO: renamed from: d */
    public final void mo192d(View view, C0391i c0391i) {
        Object obj = this.f108e;
        View.AccessibilityDelegate accessibilityDelegate = this.f830a;
        switch (this.f107d) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                AccessibilityNodeInfo accessibilityNodeInfo = c0391i.f920a;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                CheckableImageButton checkableImageButton = (CheckableImageButton) obj;
                accessibilityNodeInfo.setCheckable(checkableImageButton.f4425i);
                accessibilityNodeInfo.setChecked(checkableImageButton.f4424h);
                break;
            case 1:
                AccessibilityNodeInfo accessibilityNodeInfo2 = c0391i.f920a;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo2);
                accessibilityNodeInfo2.setCheckable(((NavigationMenuItemView) obj).f4429B);
                break;
            case 2:
                AccessibilityNodeInfo accessibilityNodeInfo3 = c0391i.f920a;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo3);
                C1258j c1258j = (C1258j) obj;
                accessibilityNodeInfo3.setHintText(c1258j.f4375h0.getVisibility() == 0 ? c1258j.m2495m().getString(R.string.mtrl_picker_toggle_to_year_selection) : c1258j.m2495m().getString(R.string.mtrl_picker_toggle_to_day_selection));
                break;
            default:
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, c0391i.f920a);
                int i3 = MaterialButtonToggleGroup.f4308o;
                MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) obj;
                materialButtonToggleGroup.getClass();
                int i4 = -1;
                if (view instanceof MaterialButton) {
                    int i5 = 0;
                    int i6 = 0;
                    while (true) {
                        if (i5 < materialButtonToggleGroup.getChildCount()) {
                            if (materialButtonToggleGroup.getChildAt(i5) == view) {
                                i4 = i6;
                            } else {
                                if ((materialButtonToggleGroup.getChildAt(i5) instanceof MaterialButton) && materialButtonToggleGroup.m3165c(i5)) {
                                    i6++;
                                }
                                i5++;
                            }
                        }
                    }
                }
                c0391i.m873f(C0444d.m977w(((MaterialButton) view).f4305r, 0, 1, i4, 1));
                break;
        }
    }
}
