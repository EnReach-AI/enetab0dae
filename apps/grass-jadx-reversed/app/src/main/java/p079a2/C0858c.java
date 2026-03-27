package p079a2;

import app.tauri.plugin.JSObject;
import io.getgrass.plugin.ExamplePlugin;
import p083b2.C1077v;
import p115l2.InterfaceC1693p;
import p119m2.AbstractC1766e;
import p119m2.AbstractC1767f;

/* JADX INFO: renamed from: a2.c */
/* JADX INFO: loaded from: classes.dex */
public final class C0858c extends AbstractC1767f implements InterfaceC1693p {

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ ExamplePlugin f2531f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0858c(ExamplePlugin examplePlugin) {
        super(2);
        this.f2531f = examplePlugin;
    }

    @Override // p115l2.InterfaceC1693p
    /* JADX INFO: renamed from: c */
    public final Object mo317c(Object obj, Object obj2) {
        String str = (String) obj;
        JSObject jSObject = (JSObject) obj2;
        AbstractC1766e.m3920e("event", str);
        AbstractC1766e.m3920e("payload", jSObject);
        this.f2531f.m2687e(str, jSObject);
        return C1077v.f3761a;
    }
}
