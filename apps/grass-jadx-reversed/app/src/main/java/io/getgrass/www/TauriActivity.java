package io.getgrass.www;

import android.content.Intent;
import app.tauri.plugin.PluginHandle;
import app.tauri.plugin.PluginManager;
import java.util.Iterator;
import p119m2.AbstractC1766e;

/* JADX INFO: loaded from: classes.dex */
public abstract class TauriActivity extends WryActivity {

    /* JADX INFO: renamed from: z */
    public final PluginManager f5234z = new PluginManager(this);

    public final PluginManager getPluginManager() {
        return this.f5234z;
    }

    @Override // androidx.fragment.app.AbstractActivityC0947r, androidx.activity.AbstractActivityC0873h, android.app.Activity
    public final void onNewIntent(Intent intent) {
        AbstractC1766e.m3920e("intent", intent);
        super.onNewIntent(intent);
        PluginManager pluginManager = this.f5234z;
        pluginManager.getClass();
        Iterator it = pluginManager.f3550b.values().iterator();
        while (it.hasNext()) {
            ((PluginHandle) it.next()).f3541b.mo2661c(intent);
        }
    }

    @Override // io.getgrass.www.WryActivity, androidx.fragment.app.AbstractActivityC0947r, android.app.Activity
    public final void onPause() {
        super.onPause();
        Iterator it = this.f5234z.f3550b.values().iterator();
        while (it.hasNext()) {
            ((PluginHandle) it.next()).f3541b.getClass();
        }
    }

    @Override // io.getgrass.www.WryActivity, androidx.fragment.app.AbstractActivityC0947r, android.app.Activity
    public final void onResume() {
        super.onResume();
        Iterator it = this.f5234z.f3550b.values().iterator();
        while (it.hasNext()) {
            ((PluginHandle) it.next()).f3541b.getClass();
        }
    }
}
