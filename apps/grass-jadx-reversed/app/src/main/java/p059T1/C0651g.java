package p059T1;

import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p019F0.C0217a;
import p156w0.AbstractC1986a;

/* JADX INFO: renamed from: T1.g */
/* JADX INFO: loaded from: classes.dex */
public final class C0651g extends C0217a {

    /* JADX INFO: renamed from: g */
    public final /* synthetic */ int f1750g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0651g(int i3) {
        super(5);
        this.f1750g = i3;
    }

    @Override // p019F0.C0217a
    /* JADX INFO: renamed from: b */
    public final int mo428b(char c3, StringBuilder sb) {
        switch (this.f1750g) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                if (c3 == ' ') {
                    sb.append((char) 3);
                    return 1;
                }
                if (c3 >= '0' && c3 <= '9') {
                    sb.append((char) (c3 - ','));
                    return 1;
                }
                if (c3 >= 'a' && c3 <= 'z') {
                    sb.append((char) (c3 - 'S'));
                    return 1;
                }
                if (c3 < ' ') {
                    sb.append((char) 0);
                    sb.append(c3);
                } else if (c3 >= '!' && c3 <= '/') {
                    sb.append((char) 1);
                    sb.append((char) (c3 - '!'));
                } else if (c3 >= ':' && c3 <= '@') {
                    sb.append((char) 1);
                    sb.append((char) (c3 - '+'));
                } else if (c3 >= '[' && c3 <= '_') {
                    sb.append((char) 1);
                    sb.append((char) (c3 - 'E'));
                } else if (c3 == '`') {
                    sb.append((char) 2);
                    sb.append((char) (c3 - '`'));
                } else if (c3 >= 'A' && c3 <= 'Z') {
                    sb.append((char) 2);
                    sb.append((char) (c3 - '@'));
                } else {
                    if (c3 < '{' || c3 > 127) {
                        sb.append("\u0001\u001e");
                        return mo428b((char) (c3 - 128), sb) + 2;
                    }
                    sb.append((char) 2);
                    sb.append((char) (c3 - '`'));
                }
                return 2;
            default:
                if (c3 == '\r') {
                    sb.append((char) 0);
                } else if (c3 == ' ') {
                    sb.append((char) 3);
                } else if (c3 == '*') {
                    sb.append((char) 1);
                } else if (c3 == '>') {
                    sb.append((char) 2);
                } else if (c3 >= '0' && c3 <= '9') {
                    sb.append((char) (c3 - ','));
                } else {
                    if (c3 < 'A' || c3 > 'Z') {
                        AbstractC1986a.m4377e(c3);
                        throw null;
                    }
                    sb.append((char) (c3 - '3'));
                }
                return 1;
        }
    }

    @Override // p019F0.C0217a, p059T1.InterfaceC0646b
    /* JADX INFO: renamed from: c */
    public void mo429c(C0647c c0647c) {
        switch (this.f1750g) {
            case 1:
                StringBuilder sb = new StringBuilder();
                while (true) {
                    if (c0647c.m1595b()) {
                        char cM1594a = c0647c.m1594a();
                        c0647c.f1729d++;
                        mo428b(cM1594a, sb);
                        if (sb.length() % 3 == 0) {
                            C0217a.m427h(c0647c, sb);
                            if (AbstractC1986a.m4383k(c0647c.f1726a, c0647c.f1729d, 3) != 3) {
                                c0647c.f1730e = 0;
                            }
                        }
                    }
                }
                mo432f(c0647c, sb);
                break;
            default:
                super.mo429c(c0647c);
                break;
        }
    }

    @Override // p019F0.C0217a
    /* JADX INFO: renamed from: e */
    public final int mo431e() {
        switch (this.f1750g) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                return 2;
            default:
                return 3;
        }
    }

    @Override // p019F0.C0217a
    /* JADX INFO: renamed from: f */
    public void mo432f(C0647c c0647c, StringBuilder sb) {
        switch (this.f1750g) {
            case 1:
                StringBuilder sb2 = c0647c.f1728c;
                c0647c.m1596c(sb2.length());
                int length = c0647c.f1731f.f1739b - sb2.length();
                c0647c.f1729d -= sb.length();
                String str = c0647c.f1726a;
                if ((str.length() - c0647c.f1732g) - c0647c.f1729d > 1 || length > 1 || (str.length() - c0647c.f1732g) - c0647c.f1729d != length) {
                    c0647c.m1597d((char) 254);
                }
                if (c0647c.f1730e < 0) {
                    c0647c.f1730e = 0;
                }
                break;
            default:
                super.mo432f(c0647c, sb);
                break;
        }
    }
}
