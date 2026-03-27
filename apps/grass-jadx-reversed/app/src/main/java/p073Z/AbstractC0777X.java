package p073Z;

import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;
import p029J.AbstractC0307B;
import p029J.AbstractC0323S;

/* JADX INFO: renamed from: Z.X */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0777X {

    /* JADX INFO: renamed from: s */
    public static final List f2201s = Collections.emptyList();

    /* JADX INFO: renamed from: a */
    public final View f2202a;

    /* JADX INFO: renamed from: b */
    public WeakReference f2203b;

    /* JADX INFO: renamed from: j */
    public int f2211j;

    /* JADX INFO: renamed from: r */
    public RecyclerView f2219r;

    /* JADX INFO: renamed from: c */
    public int f2204c = -1;

    /* JADX INFO: renamed from: d */
    public int f2205d = -1;

    /* JADX INFO: renamed from: e */
    public long f2206e = -1;

    /* JADX INFO: renamed from: f */
    public int f2207f = -1;

    /* JADX INFO: renamed from: g */
    public int f2208g = -1;

    /* JADX INFO: renamed from: h */
    public AbstractC0777X f2209h = null;

    /* JADX INFO: renamed from: i */
    public AbstractC0777X f2210i = null;

    /* JADX INFO: renamed from: k */
    public final ArrayList f2212k = null;

    /* JADX INFO: renamed from: l */
    public final List f2213l = null;

    /* JADX INFO: renamed from: m */
    public int f2214m = 0;

    /* JADX INFO: renamed from: n */
    public C0769O f2215n = null;

    /* JADX INFO: renamed from: o */
    public boolean f2216o = false;

    /* JADX INFO: renamed from: p */
    public int f2217p = 0;

    /* JADX INFO: renamed from: q */
    public int f2218q = -1;

    public AbstractC0777X(View view) {
        if (view == null) {
            throw new IllegalArgumentException("itemView may not be null");
        }
        this.f2202a = view;
    }

    /* JADX INFO: renamed from: a */
    public final void m2050a(int i3) {
        this.f2211j = i3 | this.f2211j;
    }

    /* JADX INFO: renamed from: b */
    public final int m2051b() {
        int i3 = this.f2208g;
        return i3 == -1 ? this.f2204c : i3;
    }

    /* JADX INFO: renamed from: c */
    public final List m2052c() {
        ArrayList arrayList;
        return ((this.f2211j & 1024) != 0 || (arrayList = this.f2212k) == null || arrayList.size() == 0) ? f2201s : this.f2213l;
    }

    /* JADX INFO: renamed from: d */
    public final boolean m2053d(int i3) {
        return (i3 & this.f2211j) != 0;
    }

    /* JADX INFO: renamed from: e */
    public final boolean m2054e() {
        View view = this.f2202a;
        return (view.getParent() == null || view.getParent() == this.f2219r) ? false : true;
    }

    /* JADX INFO: renamed from: f */
    public final boolean m2055f() {
        return (this.f2211j & 1) != 0;
    }

    /* JADX INFO: renamed from: g */
    public final boolean m2056g() {
        return (this.f2211j & 4) != 0;
    }

    /* JADX INFO: renamed from: h */
    public final boolean m2057h() {
        if ((this.f2211j & 16) == 0) {
            WeakHashMap weakHashMap = AbstractC0323S.f816a;
            if (!AbstractC0307B.m593i(this.f2202a)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: i */
    public final boolean m2058i() {
        return (this.f2211j & 8) != 0;
    }

    /* JADX INFO: renamed from: j */
    public final boolean m2059j() {
        return this.f2215n != null;
    }

    /* JADX INFO: renamed from: k */
    public final boolean m2060k() {
        return (this.f2211j & 256) != 0;
    }

    /* JADX INFO: renamed from: l */
    public final boolean m2061l() {
        return (this.f2211j & 2) != 0;
    }

    /* JADX INFO: renamed from: m */
    public final void m2062m(int i3, boolean z3) {
        if (this.f2205d == -1) {
            this.f2205d = this.f2204c;
        }
        if (this.f2208g == -1) {
            this.f2208g = this.f2204c;
        }
        if (z3) {
            this.f2208g += i3;
        }
        this.f2204c += i3;
        View view = this.f2202a;
        if (view.getLayoutParams() != null) {
            ((C0764J) view.getLayoutParams()).f2156c = true;
        }
    }

    /* JADX INFO: renamed from: n */
    public final void m2063n() {
        this.f2211j = 0;
        this.f2204c = -1;
        this.f2205d = -1;
        this.f2206e = -1L;
        this.f2208g = -1;
        this.f2214m = 0;
        this.f2209h = null;
        this.f2210i = null;
        ArrayList arrayList = this.f2212k;
        if (arrayList != null) {
            arrayList.clear();
        }
        this.f2211j &= -1025;
        this.f2217p = 0;
        this.f2218q = -1;
        RecyclerView.m2576j(this);
    }

    /* JADX INFO: renamed from: o */
    public final void m2064o(boolean z3) {
        int i3 = this.f2214m;
        int i4 = z3 ? i3 - 1 : i3 + 1;
        this.f2214m = i4;
        if (i4 < 0) {
            this.f2214m = 0;
            Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            return;
        }
        if (!z3 && i4 == 1) {
            this.f2211j |= 16;
        } else if (z3 && i4 == 0) {
            this.f2211j &= -17;
        }
    }

    /* JADX INFO: renamed from: p */
    public final boolean m2065p() {
        return (this.f2211j & 128) != 0;
    }

    /* JADX INFO: renamed from: q */
    public final boolean m2066q() {
        return (this.f2211j & 32) != 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder((getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName()) + "{" + Integer.toHexString(hashCode()) + " position=" + this.f2204c + " id=" + this.f2206e + ", oldPos=" + this.f2205d + ", pLpos:" + this.f2208g);
        if (m2059j()) {
            sb.append(" scrap ");
            sb.append(this.f2216o ? "[changeScrap]" : "[attachedScrap]");
        }
        if (m2056g()) {
            sb.append(" invalid");
        }
        if (!m2055f()) {
            sb.append(" unbound");
        }
        if ((this.f2211j & 2) != 0) {
            sb.append(" update");
        }
        if (m2058i()) {
            sb.append(" removed");
        }
        if (m2065p()) {
            sb.append(" ignored");
        }
        if (m2060k()) {
            sb.append(" tmpDetached");
        }
        if (!m2057h()) {
            sb.append(" not recyclable(" + this.f2214m + ")");
        }
        if ((this.f2211j & 512) != 0 || m2056g()) {
            sb.append(" undefined adapter position");
        }
        if (this.f2202a.getParent() == null) {
            sb.append(" no parent");
        }
        sb.append("}");
        return sb.toString();
    }
}
