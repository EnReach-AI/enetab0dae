package p029J;

import android.text.TextUtils;
import android.view.View;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* JADX INFO: renamed from: J.x */
/* JADX INFO: loaded from: classes.dex */
public final class C0373x extends AbstractC0375z {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f883e;

    public C0373x(int i3, Class cls, int i4, int i5, int i6) {
        this.f883e = i6;
        this.f885a = i3;
        this.f888d = cls;
        this.f887c = i4;
        this.f886b = i5;
    }

    @Override // p029J.AbstractC0375z
    /* JADX INFO: renamed from: b */
    public final Object mo840b(View view) {
        switch (this.f883e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                return Boolean.valueOf(AbstractC0317L.m676d(view));
            case 1:
                return AbstractC0317L.m674b(view);
            default:
                return Boolean.valueOf(AbstractC0317L.m675c(view));
        }
    }

    @Override // p029J.AbstractC0375z
    /* JADX INFO: renamed from: c */
    public final void mo841c(View view, Object obj) {
        switch (this.f883e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                AbstractC0317L.m681i(view, ((Boolean) obj).booleanValue());
                break;
            case 1:
                AbstractC0317L.m680h(view, (CharSequence) obj);
                break;
            default:
                AbstractC0317L.m679g(view, ((Boolean) obj).booleanValue());
                break;
        }
    }

    @Override // p029J.AbstractC0375z
    /* JADX INFO: renamed from: f */
    public final boolean mo842f(Object obj, Object obj2) {
        switch (this.f883e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                Boolean bool = (Boolean) obj;
                Boolean bool2 = (Boolean) obj2;
                return !((bool != null && bool.booleanValue()) == (bool2 != null && bool2.booleanValue()));
            case 1:
                return !TextUtils.equals((CharSequence) obj, (CharSequence) obj2);
            default:
                Boolean bool3 = (Boolean) obj;
                Boolean bool4 = (Boolean) obj2;
                return !((bool3 != null && bool3.booleanValue()) == (bool4 != null && bool4.booleanValue()));
        }
    }
}
