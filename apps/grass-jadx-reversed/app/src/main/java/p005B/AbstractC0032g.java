package p005B;

import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import java.util.HashSet;
import p089d2.InterfaceC1315i;
import p136r.AbstractC1849h;

/* JADX INFO: renamed from: B.g */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC0032g {
    /* JADX INFO: renamed from: a */
    public static final void m143a(View view, int i3) {
        int iM4118b = AbstractC1849h.m4118b(i3);
        if (iM4118b == 0) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                }
                viewGroup.removeView(view);
                return;
            }
            return;
        }
        if (iM4118b == 1) {
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
            }
            view.setVisibility(0);
            return;
        }
        if (iM4118b == 2) {
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
            }
            view.setVisibility(8);
            return;
        }
        if (iM4118b != 3) {
            return;
        }
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
        }
        view.setVisibility(4);
    }

    /* JADX INFO: renamed from: b */
    public static final boolean m144b(int i3, int i4) {
        return (m147e(i3) & i4) != 0;
    }

    /* JADX INFO: renamed from: c */
    public static int m145c(int i3) {
        if (i3 == 0) {
            return 2;
        }
        if (i3 == 4) {
            return 4;
        }
        if (i3 == 8) {
            return 3;
        }
        throw new IllegalArgumentException("Unknown visibility " + i3);
    }

    /* JADX INFO: renamed from: d */
    public static int m146d(View view) {
        if (view.getAlpha() == 0.0f && view.getVisibility() == 0) {
            return 4;
        }
        return m145c(view.getVisibility());
    }

    /* JADX INFO: renamed from: e */
    public static final int m147e(int i3) {
        return 1 << AbstractC1849h.m4118b(i3);
    }

    /* JADX INFO: renamed from: f */
    public static final String m148f(int i3) {
        int iM4118b = AbstractC1849h.m4118b(i3);
        return iM4118b != 0 ? iM4118b != 1 ? "Unknown" : "app_event_pred" : "integrity_detect";
    }

    /* JADX INFO: renamed from: g */
    public static final String m149g(int i3) {
        int iM4118b = AbstractC1849h.m4118b(i3);
        if (iM4118b == 0) {
            return "MTML_INTEGRITY_DETECT";
        }
        if (iM4118b != 1) {
            return null;
        }
        return "MTML_APP_EVENT_PRED";
    }

    /* JADX INFO: renamed from: h */
    public static /* synthetic */ boolean m150h(int i3) {
        switch (i3) {
            case 1:
                return true;
            case 2:
            case FromStringDeserializer.Std.STD_URI /* 3 */:
                return false;
            case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                return true;
            case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                return false;
            case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                return true;
            case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
                return false;
            default:
                throw null;
        }
    }

    /* JADX INFO: renamed from: i */
    public static /* synthetic */ String m151i(int i3) {
        if (i3 == 1) {
            return null;
        }
        if (i3 == 2) {
            return "only_me";
        }
        if (i3 == 3) {
            return "friends";
        }
        if (i3 == 4) {
            return "everyone";
        }
        throw null;
    }

    /* JADX INFO: renamed from: j */
    public static String m152j(String str, String str2) {
        return str + str2;
    }

    /* JADX INFO: renamed from: k */
    public static String m153k(String str, String str2, char c3) {
        return str + str2 + c3;
    }

    /* JADX INFO: renamed from: l */
    public static String m154l(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    /* JADX INFO: renamed from: m */
    public static String m155m(String str, String str2, String str3, String str4) {
        return str + str2 + str3 + str4;
    }

    /* JADX INFO: renamed from: n */
    public static String m156n(String str, String str2, String str3, String str4, String str5) {
        return str + str2 + str3 + str4 + str5;
    }

    /* JADX INFO: renamed from: o */
    public static String m157o(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    /* JADX INFO: renamed from: p */
    public static /* synthetic */ void m158p(Parcelable parcelable) {
        if (parcelable != null) {
            throw new ClassCastException();
        }
    }

    /* JADX INFO: renamed from: q */
    public static /* synthetic */ void m159q(InterfaceC1315i interfaceC1315i) {
        if (interfaceC1315i != null) {
            throw new ClassCastException();
        }
    }

    /* JADX INFO: renamed from: r */
    public static /* synthetic */ void m160r(Object obj) {
        throw new ClassCastException();
    }

    /* JADX INFO: renamed from: s */
    public static void m161s(HashSet hashSet, String str, String str2, String str3, String str4) {
        hashSet.add(str);
        hashSet.add(str2);
        hashSet.add(str3);
        hashSet.add(str4);
    }

    /* JADX INFO: renamed from: t */
    public static /* synthetic */ void m162t(Object obj) {
        if (obj != null) {
            throw new ClassCastException();
        }
    }

    /* JADX INFO: renamed from: u */
    public static /* synthetic */ String m163u(int i3) {
        switch (i3) {
            case 1:
                return "NATIVE_WITH_FALLBACK";
            case 2:
                return "NATIVE_ONLY";
            case FromStringDeserializer.Std.STD_URI /* 3 */:
                return "KATANA_ONLY";
            case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                return "WEB_ONLY";
            case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                return "WEB_VIEW_ONLY";
            case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                return "DIALOG_ONLY";
            case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
                return "DEVICE_AUTH";
            default:
                throw null;
        }
    }

    /* JADX INFO: renamed from: v */
    public static /* synthetic */ String m164v(int i3) {
        switch (i3) {
            case 1:
                return "NONE";
            case 2:
                return "LEFT";
            case FromStringDeserializer.Std.STD_URI /* 3 */:
                return "TOP";
            case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                return "RIGHT";
            case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                return "BOTTOM";
            case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                return "BASELINE";
            case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
                return "CENTER";
            case FromStringDeserializer.Std.STD_LOCALE /* 8 */:
                return "CENTER_X";
            case FromStringDeserializer.Std.STD_CHARSET /* 9 */:
                return "CENTER_Y";
            default:
                throw null;
        }
    }

    /* JADX INFO: renamed from: w */
    public static /* synthetic */ String m165w(int i3) {
        switch (i3) {
            case 1:
                return "AZTEC";
            case 2:
                return "CODABAR";
            case FromStringDeserializer.Std.STD_URI /* 3 */:
                return "CODE_39";
            case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                return "CODE_93";
            case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                return "CODE_128";
            case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                return "DATA_MATRIX";
            case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
                return "EAN_8";
            case FromStringDeserializer.Std.STD_LOCALE /* 8 */:
                return "EAN_13";
            case FromStringDeserializer.Std.STD_CHARSET /* 9 */:
                return "ITF";
            case FromStringDeserializer.Std.STD_TIME_ZONE /* 10 */:
                return "MAXICODE";
            case FromStringDeserializer.Std.STD_INET_ADDRESS /* 11 */:
                return "PDF_417";
            case FromStringDeserializer.Std.STD_INET_SOCKET_ADDRESS /* 12 */:
                return "QR_CODE";
            case 13:
                return "RSS_14";
            case 14:
                return "RSS_EXPANDED";
            case 15:
                return "UPC_A";
            case 16:
                return "UPC_E";
            case 17:
                return "UPC_EAN_EXTENSION";
            default:
                return "null";
        }
    }

    /* JADX INFO: renamed from: x */
    public static /* synthetic */ String m166x(int i3) {
        return i3 != 1 ? i3 != 2 ? i3 != 3 ? "null" : "REMOVING" : "ADDING" : "NONE";
    }

    /* JADX INFO: renamed from: y */
    public static /* synthetic */ String m167y(int i3) {
        return i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? "null" : "INVISIBLE" : "GONE" : "VISIBLE" : "REMOVED";
    }
}
