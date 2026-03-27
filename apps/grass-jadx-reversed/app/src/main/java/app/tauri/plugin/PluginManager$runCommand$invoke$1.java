package app.tauri.plugin;

import p083b2.C1077v;
import p115l2.InterfaceC1693p;
import p119m2.AbstractC1766e;
import p119m2.AbstractC1767f;

/* JADX INFO: loaded from: classes.dex */
public final class PluginManager$runCommand$invoke$1 extends AbstractC1767f implements InterfaceC1693p {

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ long f3555f = 0;

    /* JADX INFO: renamed from: g */
    public final /* synthetic */ PluginManager f3556g;

    /* JADX INFO: renamed from: h */
    public final /* synthetic */ int f3557h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PluginManager$runCommand$invoke$1(PluginManager pluginManager, int i3) {
        super(2);
        this.f3556g = pluginManager;
        this.f3557h = i3;
    }

    @Override // p115l2.InterfaceC1693p
    /* JADX INFO: renamed from: c */
    public final Object mo317c(Object obj, Object obj2) {
        long jLongValue = ((Number) obj).longValue();
        String str = (String) obj2;
        AbstractC1766e.m3920e("result", str);
        String str2 = null;
        if (jLongValue != this.f3555f) {
            str2 = str;
            str = null;
        }
        this.f3556g.handlePluginResponse(this.f3557h, str, str2);
        return C1077v.f3761a;
    }
}
