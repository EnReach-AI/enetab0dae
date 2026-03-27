package p161x2;

import java.util.List;
import p115l2.InterfaceC1678a;
import p119m2.AbstractC1767f;
import p135q2.InterfaceC1841b;

/* JADX INFO: renamed from: x2.g */
/* JADX INFO: loaded from: classes.dex */
public final class C2018g extends AbstractC1767f implements InterfaceC1678a {

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ int f7172f;

    /* JADX INFO: renamed from: g */
    public final /* synthetic */ List f7173g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C2018g(List list, int i3) {
        super(0);
        this.f7172f = i3;
        this.f7173g = list;
    }

    @Override // p115l2.InterfaceC1678a
    /* JADX INFO: renamed from: a */
    public final Object mo263a() {
        switch (this.f7172f) {
        }
        return ((InterfaceC1841b) this.f7173g.get(0)).mo248c();
    }
}
