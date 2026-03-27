package p006B0;

import com.facebook.C1128y;
import com.facebook.InterfaceC1121r;
import java.util.ArrayList;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import org.json.JSONException;
import p002A0.C0021c;
import p013D0.C0175a;
import p033K0.AbstractC0406d;

/* JADX INFO: renamed from: B0.b */
/* JADX INFO: loaded from: classes.dex */
public final class C0039b implements InterfaceC1121r {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f103a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ArrayList f104b;

    public /* synthetic */ C0039b(ArrayList arrayList, int i3) {
        this.f103a = i3;
        this.f104b = arrayList;
    }

    @Override // com.facebook.InterfaceC1121r
    /* JADX INFO: renamed from: a */
    public final void mo74a(C1128y c1128y) {
        switch (this.f103a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                ArrayList arrayList = this.f104b;
                try {
                    if (c1128y.f3921c == null && c1128y.f3920b.getBoolean("success")) {
                        for (int i3 = 0; arrayList.size() > i3; i3++) {
                            AbstractC0406d.m895b(((C0021c) arrayList.get(i3)).f65a);
                            break;
                        }
                        break;
                    }
                } catch (JSONException unused) {
                    return;
                }
                break;
            default:
                ArrayList arrayList2 = this.f104b;
                try {
                    if (c1128y.f3921c == null && c1128y.f3920b.getBoolean("success")) {
                        for (int i4 = 0; arrayList2.size() > i4; i4++) {
                            AbstractC0406d.m895b(((C0175a) arrayList2.get(i4)).f409a);
                            break;
                        }
                        break;
                    }
                } catch (JSONException unused2) {
                    return;
                }
                break;
        }
    }
}
