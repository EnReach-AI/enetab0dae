package p118m1;

import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p005B.AbstractC0032g;

/* JADX INFO: renamed from: m1.s */
/* JADX INFO: loaded from: classes.dex */
public final class C1754s extends AbstractC1757v {

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ int f6132f;

    /* JADX INFO: renamed from: g */
    public final /* synthetic */ String f6133g;

    public /* synthetic */ C1754s(int i3, String str) {
        this.f6132f = i3;
        this.f6133g = str;
    }

    @Override // p118m1.AbstractC1757v
    /* JADX INFO: renamed from: a */
    public final String mo3911a(String str) {
        switch (this.f6132f) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                return AbstractC0032g.m157o(new StringBuilder(), this.f6133g, str);
            default:
                return str + this.f6133g;
        }
    }

    public final String toString() {
        switch (this.f6132f) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                return AbstractC0032g.m157o(new StringBuilder("[PrefixTransformer('"), this.f6133g, "')]");
            default:
                return AbstractC0032g.m157o(new StringBuilder("[SuffixTransformer('"), this.f6133g, "')]");
        }
    }
}
