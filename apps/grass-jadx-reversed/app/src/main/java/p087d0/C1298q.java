package p087d0;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import p136r.AbstractC1849h;

/* JADX INFO: renamed from: d0.q */
/* JADX INFO: loaded from: classes.dex */
public final class C1298q {

    /* JADX INFO: renamed from: b */
    public final View f4643b;

    /* JADX INFO: renamed from: a */
    public final HashMap f4642a = new HashMap();

    /* JADX INFO: renamed from: c */
    public final ArrayList f4644c = new ArrayList();

    public C1298q(View view) {
        this.f4643b = view;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C1298q)) {
            return false;
        }
        C1298q c1298q = (C1298q) obj;
        return this.f4643b == c1298q.f4643b && this.f4642a.equals(c1298q.f4642a);
    }

    public final int hashCode() {
        return this.f4642a.hashCode() + (this.f4643b.hashCode() * 31);
    }

    public final String toString() {
        String strM4117a = AbstractC1849h.m4117a(("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f4643b + "\n", "    values:");
        HashMap map = this.f4642a;
        for (String str : map.keySet()) {
            strM4117a = strM4117a + "    " + str + ": " + map.get(str) + "\n";
        }
        return strM4117a;
    }
}
