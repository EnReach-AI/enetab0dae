package p110k;

import android.graphics.Typeface;
import android.widget.TextView;
import androidx.activity.RunnableC0869d;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import p001A.AbstractC0001b;
import p029J.AbstractC0310E;
import p029J.AbstractC0323S;

/* JADX INFO: renamed from: k.P */
/* JADX INFO: loaded from: classes.dex */
public final class C1549P extends AbstractC0001b {

    /* JADX INFO: renamed from: h */
    public final /* synthetic */ int f5532h;

    /* JADX INFO: renamed from: i */
    public final /* synthetic */ int f5533i;

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ WeakReference f5534j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ C1560V f5535k;

    public C1549P(C1560V c1560v, int i3, int i4, WeakReference weakReference) {
        this.f5535k = c1560v;
        this.f5532h = i3;
        this.f5533i = i4;
        this.f5534j = weakReference;
    }

    @Override // p001A.AbstractC0001b
    /* JADX INFO: renamed from: g */
    public final void mo13g(int i3) {
    }

    @Override // p001A.AbstractC0001b
    /* JADX INFO: renamed from: h */
    public final void mo14h(Typeface typeface) {
        int i3 = this.f5532h;
        if (i3 != -1) {
            typeface = AbstractC1558U.m3612a(typeface, i3, (this.f5533i & 2) != 0);
        }
        C1560V c1560v = this.f5535k;
        if (c1560v.f5577m) {
            c1560v.f5576l = typeface;
            TextView textView = (TextView) this.f5534j.get();
            if (textView != null) {
                WeakHashMap weakHashMap = AbstractC0323S.f816a;
                if (AbstractC0310E.m619b(textView)) {
                    textView.post(new RunnableC0869d(textView, typeface, c1560v.f5574j));
                } else {
                    textView.setTypeface(typeface, c1560v.f5574j);
                }
            }
        }
    }
}
