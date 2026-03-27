package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.AbstractC0964I;
import java.util.HashMap;
import java.util.Iterator;
import p166z0.C2068f;

/* JADX INFO: renamed from: androidx.fragment.app.F */
/* JADX INFO: loaded from: classes.dex */
public final class C0920F extends AbstractC0964I {

    /* JADX INFO: renamed from: i */
    public static final C2068f f3063i = new C2068f(7);

    /* JADX INFO: renamed from: f */
    public final boolean f3067f;

    /* JADX INFO: renamed from: c */
    public final HashMap f3064c = new HashMap();

    /* JADX INFO: renamed from: d */
    public final HashMap f3065d = new HashMap();

    /* JADX INFO: renamed from: e */
    public final HashMap f3066e = new HashMap();

    /* JADX INFO: renamed from: g */
    public boolean f3068g = false;

    /* JADX INFO: renamed from: h */
    public boolean f3069h = false;

    public C0920F(boolean z3) {
        this.f3067f = z3;
    }

    @Override // androidx.lifecycle.AbstractC0964I
    /* JADX INFO: renamed from: a */
    public final void mo1631a() {
        if (Log.isLoggable("FragmentManager", 3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f3068g = true;
    }

    /* JADX INFO: renamed from: b */
    public final void m2411b(AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o) {
        if (this.f3069h) {
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
                return;
            }
            return;
        }
        HashMap map = this.f3064c;
        if (map.containsKey(abstractComponentCallbacksC0944o.f3226i)) {
            return;
        }
        map.put(abstractComponentCallbacksC0944o.f3226i, abstractComponentCallbacksC0944o);
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Updating retained Fragments: Added " + abstractComponentCallbacksC0944o);
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m2412c(AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o) {
        if (this.f3069h) {
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else {
            if (this.f3064c.remove(abstractComponentCallbacksC0944o.f3226i) == null || !Log.isLoggable("FragmentManager", 2)) {
                return;
            }
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + abstractComponentCallbacksC0944o);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0920F.class != obj.getClass()) {
            return false;
        }
        C0920F c0920f = (C0920F) obj;
        return this.f3064c.equals(c0920f.f3064c) && this.f3065d.equals(c0920f.f3065d) && this.f3066e.equals(c0920f.f3066e);
    }

    public final int hashCode() {
        return this.f3066e.hashCode() + ((this.f3065d.hashCode() + (this.f3064c.hashCode() * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator it = this.f3064c.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator it2 = this.f3065d.keySet().iterator();
        while (it2.hasNext()) {
            sb.append((String) it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator it3 = this.f3066e.keySet().iterator();
        while (it3.hasNext()) {
            sb.append((String) it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
