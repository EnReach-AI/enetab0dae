package p082b1;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p083b2.C1068m;
import p115l2.InterfaceC1678a;
import p167z2.C2097i;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: b1.q */
/* JADX INFO: loaded from: classes.dex */
public final class C1046q implements Iterable {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f3712e;

    /* JADX INFO: renamed from: f */
    public Object f3713f;

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        switch (this.f3712e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                Map map = (Map) this.f3713f;
                return map == null ? Collections.emptyIterator() : map.values().iterator();
            case 1:
                return new C1068m((Iterator) ((InterfaceC1678a) this.f3713f).mo263a());
            default:
                return new C2097i((InterfaceC2095g) this.f3713f, 1);
        }
    }

    public /* synthetic */ C1046q(int i3, Object obj) {
        this.f3712e = i3;
        this.f3713f = obj;
    }
}
