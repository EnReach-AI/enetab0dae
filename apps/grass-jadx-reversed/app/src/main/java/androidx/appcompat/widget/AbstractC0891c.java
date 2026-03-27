package androidx.appcompat.widget;

import android.widget.AutoCompleteTextView;
import androidx.appcompat.widget.SearchView;

/* JADX INFO: renamed from: androidx.appcompat.widget.c */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0891c {
    /* JADX INFO: renamed from: a */
    public static void m2286a(AutoCompleteTextView autoCompleteTextView) {
        autoCompleteTextView.refreshAutoCompleteResults();
    }

    /* JADX INFO: renamed from: b */
    public static void m2287b(SearchView.SearchAutoComplete searchAutoComplete, int i3) {
        searchAutoComplete.setInputMethodMode(i3);
    }
}
