package p055S;

import android.widget.EditText;
import androidx.emoji2.text.AbstractC0900g;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: S.h */
/* JADX INFO: loaded from: classes.dex */
public final class C0630h extends AbstractC0900g {

    /* JADX INFO: renamed from: a */
    public final WeakReference f1617a;

    public C0630h(EditText editText) {
        this.f1617a = new WeakReference(editText);
    }

    @Override // androidx.emoji2.text.AbstractC0900g
    /* JADX INFO: renamed from: a */
    public final void mo1441a() {
        C0631i.m1446a((EditText) this.f1617a.get(), 1);
    }
}
