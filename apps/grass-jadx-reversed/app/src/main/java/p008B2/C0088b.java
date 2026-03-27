package p008B2;

import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: B2.b */
/* JADX INFO: loaded from: classes.dex */
public final class C0088b extends AbstractC0073M {

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ int f259c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0088b(InterfaceC2095g interfaceC2095g, int i3) {
        super(interfaceC2095g);
        this.f259c = i3;
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: d */
    public final String mo233d() {
        switch (this.f259c) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                return "kotlin.Array";
            case 1:
                return "kotlin.collections.ArrayList";
            case 2:
                return "kotlin.collections.HashSet";
            default:
                return "kotlin.collections.LinkedHashSet";
        }
    }
}
