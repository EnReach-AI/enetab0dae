package p079a2;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import app.tauri.plugin.JSObject;
import io.getgrass.plugin.ExamplePlugin;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: a2.b */
/* JADX INFO: loaded from: classes.dex */
public final class C0857b extends BroadcastReceiver {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ DownloadManager f2528a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ long f2529b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ ExamplePlugin f2530c;

    public C0857b(DownloadManager downloadManager, long j2, ExamplePlugin examplePlugin) {
        this.f2528a = downloadManager;
        this.f2529b = j2;
        this.f2530c = examplePlugin;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Uri uriForDownloadedFile = this.f2528a.getUriForDownloadedFile(this.f2529b);
        JSObject jSObject = new JSObject();
        jSObject.put("isDownloading", false);
        ExamplePlugin examplePlugin = this.f2530c;
        examplePlugin.m2687e("onDownloadAndInstall", jSObject);
        AbstractC1766e.m3917b(uriForDownloadedFile);
        examplePlugin.getClass();
        Intent intent2 = new Intent("android.intent.action.VIEW");
        intent2.setDataAndType(uriForDownloadedFile, "application/vnd.android.package-archive");
        intent2.setFlags(268435457);
        examplePlugin.f5153g.startActivity(intent2);
    }
}
