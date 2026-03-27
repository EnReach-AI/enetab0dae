package p069X0;

import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* JADX INFO: renamed from: X0.F */
/* JADX INFO: loaded from: classes.dex */
public final class C0704F extends AbstractC0705G {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f1931e;

    @Override // p069X0.AbstractC0705G
    /* JADX INFO: renamed from: a */
    public final String mo1689a(String str) {
        return m1693e(str);
    }

    @Override // p069X0.AbstractC0705G
    /* JADX INFO: renamed from: b */
    public final String mo1690b(String str) {
        return m1693e(str);
    }

    @Override // p069X0.AbstractC0705G
    /* JADX INFO: renamed from: c */
    public final String mo1691c(String str) {
        return m1693e(str);
    }

    @Override // p069X0.AbstractC0705G
    /* JADX INFO: renamed from: d */
    public final String mo1692d(String str) {
        return m1693e(str);
    }

    /* JADX INFO: renamed from: e */
    public final String m1693e(String str) {
        char cCharAt;
        char upperCase;
        switch (this.f1931e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                if (str == null) {
                    return str;
                }
                int length = str.length();
                StringBuilder sb = new StringBuilder(length * 2);
                int i3 = 0;
                boolean z3 = false;
                for (int i4 = 0; i4 < length; i4++) {
                    char cCharAt2 = str.charAt(i4);
                    if (i4 > 0 || cCharAt2 != '_') {
                        if (Character.isUpperCase(cCharAt2)) {
                            if (!z3 && i3 > 0 && sb.charAt(i3 - 1) != '_') {
                                sb.append('_');
                                i3++;
                            }
                            cCharAt2 = Character.toLowerCase(cCharAt2);
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        sb.append(cCharAt2);
                        i3++;
                    }
                }
                return i3 > 0 ? sb.toString() : str;
            default:
                if (str == null || str.isEmpty() || cCharAt == (upperCase = Character.toUpperCase((cCharAt = str.charAt(0))))) {
                    return str;
                }
                StringBuilder sb2 = new StringBuilder(str);
                sb2.setCharAt(0, upperCase);
                return sb2.toString();
        }
    }
}
