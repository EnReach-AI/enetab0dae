package p100g1;

import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import p039M0.EnumC0471T;
import p042N0.AbstractC0545m;
import p042N0.EnumC0548p;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0721l;
import p069X0.InterfaceC0714e;

/* JADX INFO: renamed from: g1.g */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1398g {
    /* JADX INFO: renamed from: a */
    public static Object m3399a(AbstractC0545m abstractC0545m, AbstractC0721l abstractC0721l) {
        Class cls = abstractC0721l.f2036e;
        EnumC0548p enumC0548pMo1190e = abstractC0545m.mo1190e();
        if (enumC0548pMo1190e == null) {
            return null;
        }
        switch (enumC0548pMo1190e.ordinal()) {
            case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
                if (cls.isAssignableFrom(String.class)) {
                    return abstractC0545m.mo1157B();
                }
                return null;
            case FromStringDeserializer.Std.STD_LOCALE /* 8 */:
                if (cls.isAssignableFrom(Integer.class)) {
                    return Integer.valueOf(abstractC0545m.mo1204s());
                }
                return null;
            case FromStringDeserializer.Std.STD_CHARSET /* 9 */:
                if (cls.isAssignableFrom(Double.class)) {
                    return Double.valueOf(abstractC0545m.mo1201p());
                }
                return null;
            case FromStringDeserializer.Std.STD_TIME_ZONE /* 10 */:
                if (cls.isAssignableFrom(Boolean.class)) {
                    return Boolean.TRUE;
                }
                return null;
            case FromStringDeserializer.Std.STD_INET_ADDRESS /* 11 */:
                if (cls.isAssignableFrom(Boolean.class)) {
                    return Boolean.FALSE;
                }
                return null;
            default:
                return null;
        }
    }

    /* JADX INFO: renamed from: b */
    public abstract Object mo3400b(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i);

    /* JADX INFO: renamed from: c */
    public abstract Object mo3401c(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i);

    /* JADX INFO: renamed from: d */
    public abstract Object mo3402d(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i);

    /* JADX INFO: renamed from: e */
    public abstract Object mo3403e(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i);

    /* JADX INFO: renamed from: f */
    public abstract AbstractC1398g mo3404f(InterfaceC0714e interfaceC0714e);

    /* JADX INFO: renamed from: g */
    public abstract EnumC0471T mo3405g();
}
