package app.tauri.notification;

import app.tauri.annotation.InvokeArg;
import java.util.List;
import p119m2.AbstractC1766e;

/* JADX INFO: loaded from: classes.dex */
@InvokeArg
public final class RegisterActionTypesArgs {
    public List<ActionType> types;

    public final List<ActionType> getTypes() {
        List<ActionType> list = this.types;
        if (list != null) {
            return list;
        }
        AbstractC1766e.m3924i("types");
        throw null;
    }

    public final void setTypes(List<ActionType> list) {
        AbstractC1766e.m3920e("<set-?>", list);
        this.types = list;
    }
}
