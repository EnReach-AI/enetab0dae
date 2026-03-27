package app.tauri.deep_link;

import android.app.Activity;
import android.content.Intent;
import android.webkit.WebView;
import app.tauri.annotation.Command;
import app.tauri.annotation.TauriPlugin;
import app.tauri.plugin.Channel;
import app.tauri.plugin.Invoke;
import app.tauri.plugin.JSObject;
import app.tauri.plugin.Plugin;
import p119m2.AbstractC1766e;

/* JADX INFO: loaded from: classes.dex */
@TauriPlugin
public final class DeepLinkPlugin extends Plugin {

    /* JADX INFO: renamed from: d */
    public final Activity f3484d;

    /* JADX INFO: renamed from: e */
    public String f3485e;

    /* JADX INFO: renamed from: f */
    public Channel f3486f;

    public static final class Companion {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeepLinkPlugin(Activity activity) {
        super(activity);
        AbstractC1766e.m3920e("activity", activity);
        this.f3484d = activity;
    }

    @Override // app.tauri.plugin.Plugin
    /* JADX INFO: renamed from: b */
    public final void mo2660b(WebView webView) {
        AbstractC1766e.m3920e("webView", webView);
        Intent intent = this.f3484d.getIntent();
        if (AbstractC1766e.m3916a(intent.getAction(), "android.intent.action.VIEW")) {
            this.f3485e = String.valueOf(intent.getData());
            JSObject jSObject = new JSObject();
            jSObject.put("url", this.f3485e);
            Channel channel = this.f3486f;
            if (channel != null) {
                channel.m2679a(jSObject);
            }
        }
    }

    @Override // app.tauri.plugin.Plugin
    /* JADX INFO: renamed from: c */
    public final void mo2661c(Intent intent) {
        AbstractC1766e.m3920e("intent", intent);
        if (AbstractC1766e.m3916a(intent.getAction(), "android.intent.action.VIEW")) {
            this.f3485e = String.valueOf(intent.getData());
            JSObject jSObject = new JSObject();
            jSObject.put("url", this.f3485e);
            Channel channel = this.f3486f;
            if (channel != null) {
                channel.m2679a(jSObject);
            }
        }
    }

    @Command
    public final void getCurrent(Invoke invoke) {
        AbstractC1766e.m3920e("invoke", invoke);
        JSObject jSObject = new JSObject();
        jSObject.put("url", this.f3485e);
        invoke.m2683d(jSObject);
    }

    @Command
    public final void setEventHandler(Invoke invoke) {
        AbstractC1766e.m3920e("invoke", invoke);
        this.f3486f = ((SetEventHandlerArgs) invoke.m2680a(SetEventHandlerArgs.class)).getHandler();
        invoke.m2682c();
    }
}
