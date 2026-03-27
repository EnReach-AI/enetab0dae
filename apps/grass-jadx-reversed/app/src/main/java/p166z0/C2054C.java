package p166z0;

import com.facebook.C1114k;
import com.facebook.C1128y;
import com.facebook.InterfaceC1121r;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: renamed from: z0.C */
/* JADX INFO: loaded from: classes.dex */
public final class C2054C implements InterfaceC1121r {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ InterfaceC2055D f7263a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ String f7264b;

    public C2054C(InterfaceC2055D interfaceC2055D, String str) {
        this.f7263a = interfaceC2055D;
        this.f7264b = str;
    }

    @Override // com.facebook.InterfaceC1121r
    /* JADX INFO: renamed from: a */
    public final void mo74a(C1128y c1128y) {
        C1114k c1114k = c1128y.f3921c;
        InterfaceC2055D interfaceC2055D = this.f7263a;
        if (c1114k != null) {
            interfaceC2055D.mo2845a(c1114k.f3872m);
            return;
        }
        ConcurrentHashMap concurrentHashMap = AbstractC2088z.f7384a;
        String str = this.f7264b;
        JSONObject jSONObject = c1128y.f3920b;
        concurrentHashMap.put(str, jSONObject);
        interfaceC2055D.mo2846b(jSONObject);
    }
}
