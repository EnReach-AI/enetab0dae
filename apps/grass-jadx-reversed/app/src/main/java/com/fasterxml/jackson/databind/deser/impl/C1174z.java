package com.fasterxml.jackson.databind.deser.impl;

import androidx.fragment.app.AbstractC0935f;
import com.fasterxml.jackson.databind.deser.AbstractC1204t;
import java.util.Map;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.impl.z */
/* JADX INFO: loaded from: classes.dex */
public final class C1174z extends AbstractC0935f {

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ int f4037c;

    /* JADX INFO: renamed from: d */
    public final Object f4038d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1174z(AbstractC0935f abstractC0935f, Object obj, Object obj2, int i3) {
        super(abstractC0935f, obj);
        this.f4037c = i3;
        this.f4038d = obj2;
    }

    @Override // androidx.fragment.app.AbstractC0935f
    /* JADX INFO: renamed from: c */
    public final void mo2448c(Object obj) {
        switch (this.f4037c) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                ((Map) obj).put(this.f4038d, this.f3161b);
                break;
            default:
                ((AbstractC1204t) this.f4038d).mo2961B(obj, this.f3161b);
                break;
        }
    }
}
