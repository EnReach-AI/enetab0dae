package p011C2;

import java.util.Map;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p015D2.AbstractC0201y;
import p083b2.C1077v;
import p115l2.InterfaceC1689l;
import p119m2.AbstractC1766e;
import p119m2.AbstractC1767f;
import p167z2.C2089a;

/* JADX INFO: renamed from: C2.l */
/* JADX INFO: loaded from: classes.dex */
public final class C0159l extends AbstractC1767f implements InterfaceC1689l {

    /* JADX INFO: renamed from: g */
    public static final C0159l f387g = new C0159l(1, 0);

    /* JADX INFO: renamed from: h */
    public static final C0159l f388h = new C0159l(1, 1);

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ int f389f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0159l(int i3, int i4) {
        super(i3);
        this.f389f = i4;
    }

    @Override // p115l2.InterfaceC1689l
    /* JADX INFO: renamed from: f */
    public final Object mo249f(Object obj) {
        switch (this.f389f) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                C2089a c2089a = (C2089a) obj;
                AbstractC1766e.m3920e("$this$buildSerialDescriptor", c2089a);
                C2089a.m4643a(c2089a, "JsonPrimitive", new C0161n(C0158k.f380g));
                C2089a.m4643a(c2089a, "JsonNull", new C0161n(C0158k.f381h));
                C2089a.m4643a(c2089a, "JsonLiteral", new C0161n(C0158k.f382i));
                C2089a.m4643a(c2089a, "JsonObject", new C0161n(C0158k.f383j));
                C2089a.m4643a(c2089a, "JsonArray", new C0161n(C0158k.f384k));
                return C1077v.f3761a;
            default:
                Map.Entry entry = (Map.Entry) obj;
                AbstractC1766e.m3920e("<name for destructuring parameter 0>", entry);
                String str = (String) entry.getKey();
                AbstractC0156i abstractC0156i = (AbstractC0156i) entry.getValue();
                StringBuilder sb = new StringBuilder();
                AbstractC0201y.m394a(sb, str);
                sb.append(':');
                sb.append(abstractC0156i);
                String string = sb.toString();
                AbstractC1766e.m3919d("StringBuilder().apply(builderAction).toString()", string);
                return string;
        }
    }
}
