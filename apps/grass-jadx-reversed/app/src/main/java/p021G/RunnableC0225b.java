package p021G;

import android.util.Log;
import androidx.emoji2.text.AbstractC0900g;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.datepicker.C1258j;
import java.util.ArrayList;
import java.util.List;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p001A.AbstractC0001b;
import p019F0.C0221e;
import p039M0.AbstractC0493h0;
import p073Z.AbstractC0763I;

/* JADX INFO: renamed from: G.b */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0225b implements Runnable {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f541e;

    /* JADX INFO: renamed from: f */
    public final int f542f;

    /* JADX INFO: renamed from: g */
    public final Object f543g;

    public /* synthetic */ RunnableC0225b(Object obj, int i3, int i4) {
        this.f541e = i4;
        this.f543g = obj;
        this.f542f = i3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f541e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                AbstractC0001b abstractC0001b = (AbstractC0001b) ((C0221e) this.f543g).f534f;
                if (abstractC0001b != null) {
                    abstractC0001b.mo13g(this.f542f);
                }
                break;
            case 1:
                ArrayList arrayList = (ArrayList) this.f543g;
                int size = arrayList.size();
                int i3 = 0;
                if (this.f542f == 1) {
                    while (i3 < size) {
                        ((AbstractC0900g) arrayList.get(i3)).mo1441a();
                        i3++;
                    }
                } else {
                    while (i3 < size) {
                        ((AbstractC0900g) arrayList.get(i3)).getClass();
                        i3++;
                    }
                }
                break;
            default:
                RecyclerView recyclerView = ((C1258j) this.f543g).f4371d0;
                if (!recyclerView.f3450y) {
                    AbstractC0763I abstractC0763I = recyclerView.f3434p;
                    if (abstractC0763I != null) {
                        abstractC0763I.mo2022s0(recyclerView, this.f542f);
                    } else {
                        Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
                    }
                    break;
                }
                break;
        }
    }

    public RunnableC0225b(List list, int i3, Throwable th) {
        this.f541e = 1;
        AbstractC0493h0.m1010c("initCallbacks cannot be null", list);
        this.f543g = new ArrayList(list);
        this.f542f = i3;
    }
}
