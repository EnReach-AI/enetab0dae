package p102h0;

import android.os.Build;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* JADX INFO: renamed from: h0.b */
/* JADX INFO: loaded from: classes.dex */
public final class C1402b extends AbstractC1403c {

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ int f5029d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1402b(int i3, String str, String str2) {
        super(str, str2);
        this.f5029d = i3;
    }

    @Override // p102h0.AbstractC1403c
    /* JADX INFO: renamed from: a */
    public final boolean mo3407a() {
        switch (this.f5029d) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                break;
            case 1:
                break;
            case 2:
                break;
            case FromStringDeserializer.Std.STD_URI /* 3 */:
                break;
            case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                break;
            case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                break;
            default:
                if (Build.VERSION.SDK_INT >= 29) {
                }
                break;
        }
        return true;
    }
}
