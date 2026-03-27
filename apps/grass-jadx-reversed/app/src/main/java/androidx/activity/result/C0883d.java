package androidx.activity.result;

import java.util.HashMap;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p033K0.AbstractC0406d;
import p039M0.AbstractC0493h0;

/* JADX INFO: renamed from: androidx.activity.result.d */
/* JADX INFO: loaded from: classes.dex */
public final class C0883d extends AbstractC0493h0 {

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ int f2629c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ String f2630d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ AbstractC0406d f2631e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ AbstractC0886g f2632f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0883d(AbstractC0886g abstractC0886g, String str, AbstractC0406d abstractC0406d, int i3) {
        super(3);
        this.f2629c = i3;
        this.f2632f = abstractC0886g;
        this.f2630d = str;
        this.f2631e = abstractC0406d;
    }

    /* JADX INFO: renamed from: f */
    public final void m2213f(Object obj) {
        switch (this.f2629c) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                AbstractC0886g abstractC0886g = this.f2632f;
                HashMap map = abstractC0886g.f2639c;
                String str = this.f2630d;
                Integer num = (Integer) map.get(str);
                AbstractC0406d abstractC0406d = this.f2631e;
                if (num != null) {
                    abstractC0886g.f2641e.add(str);
                    try {
                        abstractC0886g.mo2194b(num.intValue(), abstractC0406d, obj);
                        return;
                    } catch (Exception e3) {
                        abstractC0886g.f2641e.remove(str);
                        throw e3;
                    }
                }
                throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + abstractC0406d + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
            default:
                AbstractC0886g abstractC0886g2 = this.f2632f;
                HashMap map2 = abstractC0886g2.f2639c;
                String str2 = this.f2630d;
                Integer num2 = (Integer) map2.get(str2);
                AbstractC0406d abstractC0406d2 = this.f2631e;
                if (num2 != null) {
                    abstractC0886g2.f2641e.add(str2);
                    try {
                        abstractC0886g2.mo2194b(num2.intValue(), abstractC0406d2, obj);
                        return;
                    } catch (Exception e4) {
                        abstractC0886g2.f2641e.remove(str2);
                        throw e4;
                    }
                }
                throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + abstractC0406d2 + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
        }
    }
}
