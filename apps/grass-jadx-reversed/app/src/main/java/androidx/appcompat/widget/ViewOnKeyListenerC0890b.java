package androidx.appcompat.widget;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import androidx.appcompat.widget.SearchView;

/* JADX INFO: renamed from: androidx.appcompat.widget.b */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnKeyListenerC0890b implements View.OnKeyListener {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ SearchView f2857e;

    public ViewOnKeyListenerC0890b(SearchView searchView) {
        this.f2857e = searchView;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i3, KeyEvent keyEvent) {
        SearchView searchView = this.f2857e;
        if (searchView.f2794f0 == null) {
            return false;
        }
        SearchView.SearchAutoComplete searchAutoComplete = searchView.f2799t;
        if (!searchAutoComplete.isPopupShowing() || searchAutoComplete.getListSelection() == -1) {
            if (TextUtils.getTrimmedLength(searchAutoComplete.getText()) == 0 || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i3 != 66) {
                return false;
            }
            view.cancelLongPress();
            searchView.getContext().startActivity(searchView.m2250l("android.intent.action.SEARCH", null, null, searchAutoComplete.getText().toString()));
            return true;
        }
        if (searchView.f2794f0 == null || searchView.f2784S == null || keyEvent.getAction() != 0 || !keyEvent.hasNoModifiers()) {
            return false;
        }
        if (i3 == 66 || i3 == 84 || i3 == 61) {
            searchView.m2254p(searchAutoComplete.getListSelection());
        } else {
            if (i3 != 21 && i3 != 22) {
                if (i3 != 19) {
                    return false;
                }
                searchAutoComplete.getListSelection();
                return false;
            }
            searchAutoComplete.setSelection(i3 == 21 ? 0 : searchAutoComplete.length());
            searchAutoComplete.setListSelection(0);
            searchAutoComplete.clearListSelection();
            searchAutoComplete.m2264a();
        }
        return true;
    }
}
