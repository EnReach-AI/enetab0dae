package p110k;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.appcompat.widget.SearchView;
import com.google.android.material.bottomappbar.BottomAppBar$Behavior;
import io.getgrass.www.R;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* JADX INFO: renamed from: k.M0 */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnLayoutChangeListenerC1544M0 implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5520a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f5521b;

    public /* synthetic */ ViewOnLayoutChangeListenerC1544M0(int i3, Object obj) {
        this.f5520a = i3;
        this.f5521b = obj;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        switch (this.f5520a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                SearchView searchView = (SearchView) this.f5521b;
                View view2 = searchView.f2767B;
                if (view2.getWidth() > 1) {
                    Resources resources = searchView.getContext().getResources();
                    int paddingLeft = searchView.f2801v.getPaddingLeft();
                    Rect rect = new Rect();
                    boolean zM3658a = AbstractC1596i1.m3658a(searchView);
                    int dimensionPixelSize = searchView.f2782Q ? resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_text_padding_left) + resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_icon_width) : 0;
                    SearchView.SearchAutoComplete searchAutoComplete = searchView.f2799t;
                    searchAutoComplete.getDropDownBackground().getPadding(rect);
                    searchAutoComplete.setDropDownHorizontalOffset(zM3658a ? -rect.left : paddingLeft - (rect.left + dimensionPixelSize));
                    searchAutoComplete.setDropDownWidth((((view2.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
                    return;
                }
                return;
            default:
                ((BottomAppBar$Behavior) this.f5521b).getClass();
                throw null;
        }
    }
}
