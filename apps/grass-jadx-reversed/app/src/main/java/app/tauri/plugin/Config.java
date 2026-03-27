package app.tauri.plugin;

import app.tauri.annotation.InvokeArg;
import java.util.Map;
import p069X0.AbstractC0725p;
import p119m2.AbstractC1766e;

/* JADX INFO: loaded from: classes.dex */
@InvokeArg
public final class Config {
    public Map<String, ? extends AbstractC0725p> plugins;

    public final Map<String, AbstractC0725p> getPlugins() {
        Map map = this.plugins;
        if (map != null) {
            return map;
        }
        AbstractC1766e.m3924i("plugins");
        throw null;
    }

    public final void setPlugins(Map<String, ? extends AbstractC0725p> map) {
        AbstractC1766e.m3920e("<set-?>", map);
        this.plugins = map;
    }
}
