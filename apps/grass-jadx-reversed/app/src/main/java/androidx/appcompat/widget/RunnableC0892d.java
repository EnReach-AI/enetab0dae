package androidx.appcompat.widget;

import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.widget.SearchView;

/* JADX INFO: renamed from: androidx.appcompat.widget.d */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0892d implements Runnable {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ SearchView.SearchAutoComplete f2858e;

    public RunnableC0892d(SearchView.SearchAutoComplete searchAutoComplete) {
        this.f2858e = searchAutoComplete;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SearchView.SearchAutoComplete searchAutoComplete = this.f2858e;
        if (searchAutoComplete.f2808k) {
            ((InputMethodManager) searchAutoComplete.getContext().getSystemService("input_method")).showSoftInput(searchAutoComplete, 0);
            searchAutoComplete.f2808k = false;
        }
    }
}
