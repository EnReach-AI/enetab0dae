package app.tauri.plugin;

import p083b2.C1077v;
import p115l2.InterfaceC1693p;
import p119m2.AbstractC1766e;
import p119m2.AbstractC1767f;

/* JADX INFO: loaded from: classes.dex */
final class PluginManager$channelDeserializer$1 extends AbstractC1767f implements InterfaceC1693p {

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ PluginManager f3554f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PluginManager$channelDeserializer$1(PluginManager pluginManager) {
        super(2);
        this.f3554f = pluginManager;
    }

    @Override // p115l2.InterfaceC1693p
    /* JADX INFO: renamed from: c */
    public final Object mo317c(Object obj, Object obj2) {
        long jLongValue = ((Number) obj).longValue();
        String str = (String) obj2;
        AbstractC1766e.m3920e("payload", str);
        this.f3554f.sendChannelData(jLongValue, str);
        return C1077v.f3761a;
    }
}
