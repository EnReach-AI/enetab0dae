package p034K1;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.ViewGroup;
import androidx.appcompat.widget.SearchView;
import com.google.android.material.textfield.TextInputLayout;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* JADX INFO: renamed from: K1.B */
/* JADX INFO: loaded from: classes.dex */
public final class C0408B implements TextWatcher {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f933e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ ViewGroup f934f;

    public /* synthetic */ C0408B(ViewGroup viewGroup, int i3) {
        this.f933e = i3;
        this.f934f = viewGroup;
    }

    /* JADX INFO: renamed from: a */
    private final void m910a(Editable editable) {
    }

    /* JADX INFO: renamed from: b */
    private final void m911b(int i3, int i4, int i5, CharSequence charSequence) {
    }

    /* JADX INFO: renamed from: c */
    private final void m912c(int i3, int i4, int i5, CharSequence charSequence) {
    }

    /* JADX INFO: renamed from: d */
    private final void m913d(int i3, int i4, int i5, CharSequence charSequence) {
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        switch (this.f933e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                TextInputLayout textInputLayout = (TextInputLayout) this.f934f;
                textInputLayout.m3217t(!textInputLayout.f4469B0, false);
                if (textInputLayout.f4515o) {
                    textInputLayout.m3211n(editable);
                }
                if (textInputLayout.f4531w) {
                    textInputLayout.m3218u(editable);
                }
                break;
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        int i6 = this.f933e;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        switch (this.f933e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                break;
            default:
                SearchView searchView = (SearchView) this.f934f;
                Editable text = searchView.f2799t.getText();
                searchView.f2791c0 = text;
                boolean zIsEmpty = TextUtils.isEmpty(text);
                searchView.m2262x(!zIsEmpty);
                int i6 = 8;
                if (searchView.f2790b0 && !searchView.f2783R && zIsEmpty) {
                    searchView.f2804y.setVisibility(8);
                    i6 = 0;
                }
                searchView.f2766A.setVisibility(i6);
                searchView.m2258t();
                searchView.m2261w();
                charSequence.toString();
                searchView.getClass();
                break;
        }
    }
}
