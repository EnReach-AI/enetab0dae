package p002A0;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* JADX INFO: renamed from: A0.d */
/* JADX INFO: loaded from: classes.dex */
public final class C0022d implements FilenameFilter {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f72a;

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        switch (this.f72a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                return str.matches("^analysis_log_[0-9]+.json$");
            case 1:
                return str.matches("^(crash_log_|shield_log_|thread_check_log_)[0-9]+.json$");
            case 2:
                return str.matches("^error_log_[0-9]+.json$");
            default:
                return Pattern.matches("cpu[0-9]+", str);
        }
    }
}
