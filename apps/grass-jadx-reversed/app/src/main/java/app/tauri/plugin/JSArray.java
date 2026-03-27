package app.tauri.plugin;

import java.util.Collection;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public final class JSArray extends JSONArray {

    public static final class Companion {
    }

    public JSArray() {
    }

    public JSArray(String str) {
        super(str);
    }

    public JSArray(Collection<?> collection) {
        super((Collection) collection);
    }

    public JSArray(Object obj) {
        super(obj);
    }
}
