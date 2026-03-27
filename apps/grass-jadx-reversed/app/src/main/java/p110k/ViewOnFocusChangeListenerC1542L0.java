package p110k;

import android.view.View;
import androidx.appcompat.widget.SearchView;

/* JADX INFO: renamed from: k.L0 */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnFocusChangeListenerC1542L0 implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ SearchView f5518a;

    public ViewOnFocusChangeListenerC1542L0(SearchView searchView) {
        this.f5518a = searchView;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z3) {
        SearchView searchView = this.f5518a;
        View.OnFocusChangeListener onFocusChangeListener = searchView.f2780O;
        if (onFocusChangeListener != null) {
            onFocusChangeListener.onFocusChange(searchView, z3);
        }
    }
}
