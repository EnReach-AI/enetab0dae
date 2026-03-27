package p021G;

import android.content.Context;
import com.facebook.C1107d;
import java.util.concurrent.Callable;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* JADX INFO: renamed from: G.f */
/* JADX INFO: loaded from: classes.dex */
public final class CallableC0229f implements Callable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f545a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ String f546b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Context f547c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ C1107d f548d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f549e;

    public /* synthetic */ CallableC0229f(String str, Context context, C1107d c1107d, int i3, int i4) {
        this.f545a = i4;
        this.f546b = str;
        this.f547c = context;
        this.f548d = c1107d;
        this.f549e = i3;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f545a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                return AbstractC0232i.m475a(this.f546b, this.f547c, this.f548d, this.f549e);
            default:
                try {
                    return AbstractC0232i.m475a(this.f546b, this.f547c, this.f548d, this.f549e);
                } catch (Throwable unused) {
                    return new C0231h(-3);
                }
        }
    }
}
