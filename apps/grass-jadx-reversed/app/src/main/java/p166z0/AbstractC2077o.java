package p166z0;

import com.facebook.AbstractC1117n;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: renamed from: z0.o */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2077o {

    /* JADX INFO: renamed from: a */
    public static final HashMap f7345a = new HashMap();

    /* JADX INFO: renamed from: a */
    public static void m4612a(InterfaceC2075m interfaceC2075m, EnumC2076n enumC2076n) {
        AbstractC2078p.m4616c(new C2074l(interfaceC2075m, enumC2076n));
    }

    /* JADX INFO: renamed from: b */
    public static boolean m4613b(EnumC2076n enumC2076n) {
        boolean z3;
        boolean z4 = false;
        if (EnumC2076n.Unknown == enumC2076n) {
            return false;
        }
        if (EnumC2076n.Core == enumC2076n) {
            return true;
        }
        HashSet hashSet = AbstractC1117n.f3875a;
        AbstractC2069g.m4584h();
        String string = AbstractC1117n.f3882h.getSharedPreferences("com.facebook.internal.FEATURE_MANAGER", 0).getString("FBSDKFeature".concat(enumC2076n.toString()), null);
        if (string != null && string.equals("8.2.0")) {
            return false;
        }
        int i3 = enumC2076n.f7344e;
        EnumC2076n enumC2076nM4611a = (i3 & 255) > 0 ? EnumC2076n.m4611a(i3 & (-256)) : (65280 & i3) > 0 ? EnumC2076n.m4611a(i3 & (-65536)) : (16711680 & i3) > 0 ? EnumC2076n.m4611a(i3 & (-16777216)) : EnumC2076n.m4611a(0);
        if (enumC2076nM4611a == enumC2076n) {
            switch (enumC2076n.ordinal()) {
                case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
                case FromStringDeserializer.Std.STD_LOCALE /* 8 */:
                case FromStringDeserializer.Std.STD_CHARSET /* 9 */:
                case FromStringDeserializer.Std.STD_TIME_ZONE /* 10 */:
                case FromStringDeserializer.Std.STD_INET_ADDRESS /* 11 */:
                case FromStringDeserializer.Std.STD_INET_SOCKET_ADDRESS /* 12 */:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                case 20:
                case 21:
                    break;
                case 19:
                default:
                    z4 = true;
                    break;
            }
            String strConcat = "FBSDKFeature".concat(enumC2076n.toString());
            AbstractC2069g.m4584h();
            return AbstractC2078p.m4615b(strConcat, AbstractC1117n.f3877c, z4);
        }
        if (!m4613b(enumC2076nM4611a)) {
            return false;
        }
        switch (enumC2076n.ordinal()) {
            case FromStringDeserializer.Std.STD_CLASS /* 4 */:
            case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
            case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
            case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
            case FromStringDeserializer.Std.STD_LOCALE /* 8 */:
            case FromStringDeserializer.Std.STD_CHARSET /* 9 */:
            case FromStringDeserializer.Std.STD_TIME_ZONE /* 10 */:
            case FromStringDeserializer.Std.STD_INET_ADDRESS /* 11 */:
            case FromStringDeserializer.Std.STD_INET_SOCKET_ADDRESS /* 12 */:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 20:
            case 21:
                z3 = false;
                break;
            case 19:
            default:
                z3 = true;
                break;
        }
        String strConcat2 = "FBSDKFeature".concat(enumC2076n.toString());
        AbstractC2069g.m4584h();
        return AbstractC2078p.m4615b(strConcat2, AbstractC1117n.f3877c, z3);
    }
}
