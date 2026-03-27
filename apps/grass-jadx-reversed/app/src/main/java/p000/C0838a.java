package p000;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.util.Log;
import app.tauri.plugin.JSObject;
import p079a2.C0858c;
import p115l2.InterfaceC1693p;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: a */
/* JADX INFO: loaded from: classes.dex */
public final class C0838a extends ConnectivityManager.NetworkCallback {

    /* JADX INFO: renamed from: a */
    public final InterfaceC1693p f2504a;

    /* JADX INFO: renamed from: b */
    public final Context f2505b;

    public C0838a(C0858c c0858c, Context context) {
        AbstractC1766e.m3920e("context", context);
        this.f2504a = c0858c;
        this.f2505b = context;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        AbstractC1766e.m3920e("network", network);
        super.onAvailable(network);
        Log.d(this.f2505b.getPackageName(), "ConnectivityCallback:triggerOnNetworkStatusChanged");
        JSObject jSObject = new JSObject();
        jSObject.put("connected", true);
        this.f2504a.mo317c("onNetworkStatusChanged", jSObject);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        AbstractC1766e.m3920e("network", network);
        super.onLost(network);
        Log.d(this.f2505b.getPackageName(), "ConnectivityCallback:triggerOnNetworkStatusChanged");
        JSObject jSObject = new JSObject();
        jSObject.put("connected", false);
        this.f2504a.mo317c("onNetworkStatusChanged", jSObject);
    }
}
