package p117m0;

import android.content.Context;
import android.os.Bundle;
import com.facebook.AbstractC1117n;
import com.facebook.C1125v;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p010C0.AbstractC0147a;
import p133q0.AbstractC1838b;
import p141s0.AbstractC1878h;
import p141s0.EnumC1877g;
import p166z0.C2064b;

/* JADX INFO: renamed from: m0.s */
/* JADX INFO: loaded from: classes.dex */
public final class C1724s {

    /* JADX INFO: renamed from: a */
    public ArrayList f6012a;

    /* JADX INFO: renamed from: b */
    public ArrayList f6013b;

    /* JADX INFO: renamed from: c */
    public int f6014c;

    /* JADX INFO: renamed from: d */
    public C2064b f6015d;

    /* JADX INFO: renamed from: e */
    public String f6016e;

    /* JADX INFO: renamed from: a */
    public final synchronized void m3824a(C1711f c1711f) {
        Set set = AbstractC0147a.f354a;
        if (set.contains(this)) {
            return;
        }
        try {
            if (this.f6012a.size() + this.f6013b.size() >= (set.contains(this) ? 0 : 1000)) {
                this.f6014c++;
            } else {
                this.f6012a.add(c1711f);
            }
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, this);
        }
    }

    /* JADX INFO: renamed from: b */
    public final synchronized void m3825b(boolean z3) {
        if (AbstractC0147a.f354a.contains(this)) {
            return;
        }
        if (!z3) {
            this.f6013b.clear();
            this.f6014c = 0;
            return;
        }
        try {
            this.f6012a.addAll(this.f6013b);
            this.f6013b.clear();
            this.f6014c = 0;
            return;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, this);
            return;
        }
    }

    /* JADX INFO: renamed from: c */
    public final synchronized List m3826c() {
        if (AbstractC0147a.f354a.contains(this)) {
            return null;
        }
        try {
            ArrayList arrayList = this.f6012a;
            this.f6012a = new ArrayList();
            return arrayList;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, this);
            return null;
        }
    }

    /* JADX INFO: renamed from: d */
    public final int m3827d(C1125v c1125v, Context context, boolean z3, boolean z4) {
        if (AbstractC0147a.f354a.contains(this)) {
            return 0;
        }
        try {
            synchronized (this) {
                try {
                    int i3 = this.f6014c;
                    AbstractC1838b.m4077b(this.f6012a);
                    this.f6013b.addAll(this.f6012a);
                    this.f6012a.clear();
                    JSONArray jSONArray = new JSONArray();
                    for (C1711f c1711f : this.f6013b) {
                        String str = c1711f.f5988i;
                        if (!(str == null ? true : C1711f.m3790a(c1711f.f5984e.toString()).equals(str))) {
                            c1711f.toString();
                            HashSet hashSet = AbstractC1117n.f3875a;
                        } else if (z3 || !c1711f.f5985f) {
                            jSONArray.put(c1711f.f5984e);
                        }
                    }
                    if (jSONArray.length() == 0) {
                        return 0;
                    }
                    m3828e(c1125v, context, i3, jSONArray, z4);
                    return jSONArray.length();
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            AbstractC0147a.m295a(th2, this);
            return 0;
        }
    }

    /* JADX INFO: renamed from: e */
    public final void m3828e(C1125v c1125v, Context context, int i3, JSONArray jSONArray, boolean z3) {
        JSONObject jSONObject;
        try {
            if (AbstractC0147a.f354a.contains(this)) {
                return;
            }
            try {
                jSONObject = AbstractC1878h.m4199a(EnumC1877g.f6611f, this.f6015d, this.f6016e, z3, context);
                if (this.f6014c > 0) {
                    jSONObject.put("num_skipped_events", i3);
                }
            } catch (JSONException unused) {
                jSONObject = new JSONObject();
            }
            c1125v.f3906d = jSONObject;
            Bundle bundle = c1125v.f3907e;
            if (bundle == null) {
                bundle = new Bundle();
            }
            String string = jSONArray.toString();
            if (string != null) {
                bundle.putString("custom_events", string);
                c1125v.f3909g = string;
            }
            c1125v.f3907e = bundle;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, this);
        }
    }
}
