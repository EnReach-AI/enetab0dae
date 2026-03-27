package p128p;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* JADX INFO: renamed from: p.h */
/* JADX INFO: loaded from: classes.dex */
public final class C1814h implements Set {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f6284e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ C1807a f6285f;

    public /* synthetic */ C1814h(C1807a c1807a, int i3) {
        this.f6284e = i3;
        this.f6285f = c1807a;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean add(Object obj) {
        switch (this.f6284e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean addAll(Collection collection) {
        switch (this.f6284e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                C1807a c1807a = this.f6285f;
                int iM4009d = c1807a.m4009d();
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    c1807a.m4012g(entry.getKey(), entry.getValue());
                }
                return iM4009d != c1807a.m4009d();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final void clear() {
        switch (this.f6284e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                this.f6285f.m4006a();
                break;
            default:
                this.f6285f.m4006a();
                break;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean contains(Object obj) {
        switch (this.f6284e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                C1807a c1807a = this.f6285f;
                int iM4010e = c1807a.m4010e(key);
                if (iM4010e < 0) {
                    return false;
                }
                Object objM4007b = c1807a.m4007b(iM4010e, 1);
                Object value = entry.getValue();
                return objM4007b == value || (objM4007b != null && objM4007b.equals(value));
            default:
                return this.f6285f.m4010e(obj) >= 0;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean containsAll(Collection collection) {
        switch (this.f6284e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    if (!contains(it.next())) {
                        break;
                    }
                }
                break;
            default:
                Map mapM4008c = this.f6285f.m4008c();
                Iterator it2 = collection.iterator();
                while (it2.hasNext()) {
                    if (!mapM4008c.containsKey(it2.next())) {
                        break;
                    }
                }
                break;
        }
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean equals(Object obj) {
        switch (this.f6284e) {
        }
        return C1807a.m4005j(this, obj);
    }

    @Override // java.util.Set, java.util.Collection
    public final int hashCode() {
        switch (this.f6284e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                C1807a c1807a = this.f6285f;
                int iHashCode = 0;
                for (int iM4009d = c1807a.m4009d() - 1; iM4009d >= 0; iM4009d--) {
                    Object objM4007b = c1807a.m4007b(iM4009d, 0);
                    Object objM4007b2 = c1807a.m4007b(iM4009d, 1);
                    iHashCode += (objM4007b == null ? 0 : objM4007b.hashCode()) ^ (objM4007b2 == null ? 0 : objM4007b2.hashCode());
                }
                return iHashCode;
            default:
                C1807a c1807a2 = this.f6285f;
                int iHashCode2 = 0;
                for (int iM4009d2 = c1807a2.m4009d() - 1; iM4009d2 >= 0; iM4009d2--) {
                    Object objM4007b3 = c1807a2.m4007b(iM4009d2, 0);
                    iHashCode2 += objM4007b3 == null ? 0 : objM4007b3.hashCode();
                }
                return iHashCode2;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean isEmpty() {
        switch (this.f6284e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                if (this.f6285f.m4009d() == 0) {
                }
                break;
            default:
                if (this.f6285f.m4009d() == 0) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        switch (this.f6284e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                return new C1815i(this.f6285f);
            default:
                return new C1813g(this.f6285f, 0);
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean remove(Object obj) {
        switch (this.f6284e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                throw new UnsupportedOperationException();
            default:
                C1807a c1807a = this.f6285f;
                int iM4010e = c1807a.m4010e(obj);
                if (iM4010e < 0) {
                    return false;
                }
                c1807a.m4013h(iM4010e);
                return true;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean removeAll(Collection collection) {
        switch (this.f6284e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                throw new UnsupportedOperationException();
            default:
                Map mapM4008c = this.f6285f.m4008c();
                int size = mapM4008c.size();
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    mapM4008c.remove(it.next());
                }
                return size != mapM4008c.size();
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean retainAll(Collection collection) {
        switch (this.f6284e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                throw new UnsupportedOperationException();
            default:
                Map mapM4008c = this.f6285f.m4008c();
                int size = mapM4008c.size();
                Iterator it = mapM4008c.keySet().iterator();
                while (it.hasNext()) {
                    if (!collection.contains(it.next())) {
                        it.remove();
                    }
                }
                return size != mapM4008c.size();
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final int size() {
        switch (this.f6284e) {
        }
        return this.f6285f.m4009d();
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        switch (this.f6284e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                throw new UnsupportedOperationException();
            default:
                return this.f6285f.m4015k(objArr, 0);
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray() {
        switch (this.f6284e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                throw new UnsupportedOperationException();
            default:
                C1807a c1807a = this.f6285f;
                int iM4009d = c1807a.m4009d();
                Object[] objArr = new Object[iM4009d];
                for (int i3 = 0; i3 < iM4009d; i3++) {
                    objArr[i3] = c1807a.m4007b(i3, 0);
                }
                return objArr;
        }
    }
}
