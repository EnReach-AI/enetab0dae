package app.tauri.plugin;

import p042N0.AbstractC0545m;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0722m;
import p069X0.C0734y;
import p083b2.C1077v;
import p115l2.InterfaceC1689l;
import p115l2.InterfaceC1693p;
import p119m2.AbstractC1766e;
import p119m2.AbstractC1767f;
import p142s2.AbstractC1899n;

/* JADX INFO: loaded from: classes.dex */
public final class ChannelDeserializer extends AbstractC0722m {
    private final C0734y objectMapper;
    private final InterfaceC1693p sendChannelData;

    /* JADX INFO: renamed from: app.tauri.plugin.ChannelDeserializer$deserialize$1 */
    public static final class C09951 extends AbstractC1767f implements InterfaceC1689l {

        /* JADX INFO: renamed from: g */
        public final /* synthetic */ long f3529g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C09951(long j2) {
            super(1);
            this.f3529g = j2;
        }

        @Override // p115l2.InterfaceC1689l
        /* JADX INFO: renamed from: f */
        public final Object mo249f(Object obj) {
            String str = (String) obj;
            AbstractC1766e.m3920e("res", str);
            ChannelDeserializer.this.getSendChannelData().mo317c(Long.valueOf(this.f3529g), str);
            return C1077v.f3761a;
        }
    }

    public ChannelDeserializer(InterfaceC1693p interfaceC1693p, C0734y c0734y) {
        AbstractC1766e.m3920e("sendChannelData", interfaceC1693p);
        AbstractC1766e.m3920e("objectMapper", c0734y);
        this.sendChannelData = interfaceC1693p;
        this.objectMapper = c0734y;
    }

    public final InterfaceC1693p getSendChannelData() {
        return this.sendChannelData;
    }

    @Override // p069X0.AbstractC0722m
    public Channel deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
        AbstractC1766e.m3920e("deserializationContext", abstractC0718i);
        String str = (String) abstractC0718i.m1837O(abstractC0545m, String.class);
        AbstractC1766e.m3917b(str);
        String strSubstring = str.substring(12);
        AbstractC1766e.m3919d("substring(...)", strSubstring);
        Long lM4230g = AbstractC1899n.m4230g(strSubstring);
        if (lM4230g == null) {
            throw new Error("unexpected channel value ".concat(str));
        }
        long jLongValue = lM4230g.longValue();
        return new Channel(jLongValue, new C09951(jLongValue), this.objectMapper);
    }
}
