package p011C2;

import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p115l2.InterfaceC1678a;
import p119m2.AbstractC1767f;

/* JADX INFO: renamed from: C2.k */
/* JADX INFO: loaded from: classes.dex */
public final class C0158k extends AbstractC1767f implements InterfaceC1678a {

    /* JADX INFO: renamed from: g */
    public static final C0158k f380g = new C0158k(0, 0);

    /* JADX INFO: renamed from: h */
    public static final C0158k f381h = new C0158k(0, 1);

    /* JADX INFO: renamed from: i */
    public static final C0158k f382i = new C0158k(0, 2);

    /* JADX INFO: renamed from: j */
    public static final C0158k f383j = new C0158k(0, 3);

    /* JADX INFO: renamed from: k */
    public static final C0158k f384k = new C0158k(0, 4);

    /* JADX INFO: renamed from: l */
    public static final C0158k f385l = new C0158k(0, 5);

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ int f386f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0158k(int i3, int i4) {
        super(i3);
        this.f386f = i4;
    }

    @Override // p115l2.InterfaceC1678a
    /* JADX INFO: renamed from: a */
    public final Object mo263a() {
        switch (this.f386f) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                C0173z.f407a.getClass();
                return C0173z.f408b;
            case 1:
                C0166s.f399a.getClass();
                return C0166s.f400b;
            case 2:
                C0163p c0163p = C0163p.f396a;
                return C0163p.f397b;
            case FromStringDeserializer.Std.STD_URI /* 3 */:
                return C0170w.f406b;
            case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                return C0152e.f365b;
            default:
                return C0166s.f399a;
        }
    }
}
