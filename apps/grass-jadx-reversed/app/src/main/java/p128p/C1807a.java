package p128p;

import java.lang.reflect.Array;
import java.util.Map;
import java.util.Set;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* JADX INFO: renamed from: p.a */
/* JADX INFO: loaded from: classes.dex */
public final class C1807a {

    /* JADX INFO: renamed from: a */
    public C1814h f6251a;

    /* JADX INFO: renamed from: b */
    public C1814h f6252b;

    /* JADX INFO: renamed from: c */
    public C1816j f6253c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ int f6254d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ Object f6255e;

    public /* synthetic */ C1807a(int i3, Object obj) {
        this.f6254d = i3;
        this.f6255e = obj;
    }

    /* JADX INFO: renamed from: j */
    public static boolean m4005j(Set set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    public final void m4006a() {
        switch (this.f6254d) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                ((C1808b) this.f6255e).clear();
                break;
            default:
                ((C1809c) this.f6255e).clear();
                break;
        }
    }

    /* JADX INFO: renamed from: b */
    public final Object m4007b(int i3, int i4) {
        switch (this.f6254d) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                return ((C1808b) this.f6255e).f6296f[(i3 << 1) + i4];
            default:
                return ((C1809c) this.f6255e).f6264f[i3];
        }
    }

    /* JADX INFO: renamed from: c */
    public final Map m4008c() {
        switch (this.f6254d) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                return (C1808b) this.f6255e;
            default:
                throw new UnsupportedOperationException("not a map");
        }
    }

    /* JADX INFO: renamed from: d */
    public final int m4009d() {
        switch (this.f6254d) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                return ((C1808b) this.f6255e).f6297g;
            default:
                return ((C1809c) this.f6255e).f6265g;
        }
    }

    /* JADX INFO: renamed from: e */
    public final int m4010e(Object obj) {
        switch (this.f6254d) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                return ((C1808b) this.f6255e).m4036e(obj);
            default:
                return ((C1809c) this.f6255e).indexOf(obj);
        }
    }

    /* JADX INFO: renamed from: f */
    public final int m4011f(Object obj) {
        switch (this.f6254d) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                return ((C1808b) this.f6255e).m4038g(obj);
            default:
                return ((C1809c) this.f6255e).indexOf(obj);
        }
    }

    /* JADX INFO: renamed from: g */
    public final void m4012g(Object obj, Object obj2) {
        switch (this.f6254d) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                ((C1808b) this.f6255e).put(obj, obj2);
                break;
            default:
                ((C1809c) this.f6255e).add(obj);
                break;
        }
    }

    /* JADX INFO: renamed from: h */
    public final void m4013h(int i3) {
        switch (this.f6254d) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                ((C1808b) this.f6255e).m4040i(i3);
                break;
            default:
                ((C1809c) this.f6255e).m4020e(i3);
                break;
        }
    }

    /* JADX INFO: renamed from: i */
    public final Object m4014i(int i3, Object obj) {
        switch (this.f6254d) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                int i4 = (i3 << 1) + 1;
                Object[] objArr = ((C1808b) this.f6255e).f6296f;
                Object obj2 = objArr[i4];
                objArr[i4] = obj;
                return obj2;
            default:
                throw new UnsupportedOperationException("not a map");
        }
    }

    /* JADX INFO: renamed from: k */
    public final Object[] m4015k(Object[] objArr, int i3) {
        int iM4009d = m4009d();
        if (objArr.length < iM4009d) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), iM4009d);
        }
        for (int i4 = 0; i4 < iM4009d; i4++) {
            objArr[i4] = m4007b(i4, i3);
        }
        if (objArr.length > iM4009d) {
            objArr[iM4009d] = null;
        }
        return objArr;
    }
}
