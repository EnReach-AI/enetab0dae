package p110k;

import android.view.KeyEvent;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;

/* JADX INFO: renamed from: k.N0 */
/* JADX INFO: loaded from: classes.dex */
public final class C1546N0 implements TextView.OnEditorActionListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ SearchView f5522a;

    public C1546N0(SearchView searchView) {
        this.f5522a = searchView;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
        this.f5522a.m2257s();
        return true;
    }
}
