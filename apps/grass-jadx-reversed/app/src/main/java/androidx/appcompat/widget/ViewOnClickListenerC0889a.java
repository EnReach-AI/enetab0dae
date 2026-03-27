package androidx.appcompat.widget;

import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.SearchView;

/* JADX INFO: renamed from: androidx.appcompat.widget.a */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnClickListenerC0889a implements View.OnClickListener {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ SearchView f2856e;

    public ViewOnClickListenerC0889a(SearchView searchView) {
        this.f2856e = searchView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        SearchView searchView = this.f2856e;
        ImageView imageView = searchView.f2803x;
        SearchView.SearchAutoComplete searchAutoComplete = searchView.f2799t;
        if (view == imageView) {
            searchView.m2263y(false);
            searchAutoComplete.requestFocus();
            searchAutoComplete.setImeVisibility(true);
            View.OnClickListener onClickListener = searchView.f2781P;
            if (onClickListener != null) {
                onClickListener.onClick(searchView);
                return;
            }
            return;
        }
        if (view == searchView.f2805z) {
            searchView.m2253o();
            return;
        }
        if (view == searchView.f2804y) {
            searchView.m2257s();
            return;
        }
        if (view != searchView.f2766A) {
            if (view == searchAutoComplete) {
                searchView.m2252n();
                return;
            }
            return;
        }
        SearchableInfo searchableInfo = searchView.f2794f0;
        if (searchableInfo == null) {
            return;
        }
        try {
            if (!searchableInfo.getVoiceSearchLaunchWebSearch()) {
                if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                    searchView.getContext().startActivity(searchView.m2251m(searchView.f2778M, searchableInfo));
                }
            } else {
                Intent intent = new Intent(searchView.f2777L);
                ComponentName searchActivity = searchableInfo.getSearchActivity();
                intent.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
                searchView.getContext().startActivity(intent);
            }
        } catch (ActivityNotFoundException unused) {
            Log.w("SearchView", "Could not find voice search activity");
        }
    }
}
