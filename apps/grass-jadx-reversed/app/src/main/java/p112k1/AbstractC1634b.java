package p112k1;

import com.fasterxml.jackson.databind.deser.impl.C1160l;
import com.fasterxml.jackson.databind.ser.std.AbstractC1229b;
import com.fasterxml.jackson.databind.ser.std.BooleanSerializer;
import com.fasterxml.jackson.databind.ser.std.CalendarSerializer;
import com.fasterxml.jackson.databind.ser.std.ClassSerializer;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import com.fasterxml.jackson.databind.ser.std.FileSerializer;
import com.fasterxml.jackson.databind.ser.std.JsonValueSerializer;
import com.fasterxml.jackson.databind.ser.std.NullSerializer;
import com.fasterxml.jackson.databind.ser.std.NumberSerializer;
import com.fasterxml.jackson.databind.ser.std.SerializableSerializer;
import com.fasterxml.jackson.databind.ser.std.StdDelegatingSerializer;
import com.fasterxml.jackson.databind.ser.std.StdJdkSerializers$AtomicBooleanSerializer;
import com.fasterxml.jackson.databind.ser.std.StdJdkSerializers$AtomicIntegerSerializer;
import com.fasterxml.jackson.databind.ser.std.StdJdkSerializers$AtomicLongSerializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer;
import com.fasterxml.jackson.databind.ser.std.UUIDSerializer;
import java.io.File;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;
import p039M0.C0453A;
import p069X0.AbstractC0709K;
import p069X0.AbstractC0711b;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0728s;
import p069X0.C0707I;
import p069X0.EnumC0731v;
import p069X0.InterfaceC0727r;
import p071Y0.EnumC0747k;
import p074Z0.C0835u;
import p082b1.AbstractC1031b;
import p082b1.AbstractC1041l;
import p082b1.C1005A;
import p082b1.C1033d;
import p100g1.AbstractC1399h;
import p100g1.C1394c;
import p103h1.AbstractC1431s;
import p103h1.C1425m;
import p103h1.C1426n;
import p118m1.AbstractC1745j;
import p118m1.C1730E;
import p118m1.InterfaceC1748m;

/* JADX INFO: renamed from: k1.b */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1634b extends AbstractC1644l implements Serializable {

    /* JADX INFO: renamed from: f */
    public static final HashMap f5807f;

    /* JADX INFO: renamed from: g */
    public static final HashMap f5808g;

    /* JADX INFO: renamed from: e */
    public final C0835u f5809e = new C0835u();

    static {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        map2.put(String.class.getName(), new StringSerializer());
        ToStringSerializer toStringSerializer = ToStringSerializer.instance;
        map2.put(StringBuffer.class.getName(), toStringSerializer);
        map2.put(StringBuilder.class.getName(), toStringSerializer);
        map2.put(Character.class.getName(), toStringSerializer);
        map2.put(Character.TYPE.getName(), toStringSerializer);
        AbstractC1229b.m3105a(map2);
        map2.put(Boolean.TYPE.getName(), new BooleanSerializer(true));
        map2.put(Boolean.class.getName(), new BooleanSerializer(false));
        map2.put(BigInteger.class.getName(), new NumberSerializer(BigInteger.class));
        map2.put(BigDecimal.class.getName(), new NumberSerializer(BigDecimal.class));
        map2.put(Calendar.class.getName(), CalendarSerializer.instance);
        map2.put(Date.class.getName(), DateSerializer.instance);
        HashMap map3 = new HashMap();
        map3.put(URL.class, new ToStringSerializer(URL.class));
        map3.put(URI.class, new ToStringSerializer(URI.class));
        map3.put(Currency.class, new ToStringSerializer(Currency.class));
        map3.put(UUID.class, new UUIDSerializer());
        map3.put(Pattern.class, new ToStringSerializer(Pattern.class));
        map3.put(Locale.class, new ToStringSerializer(Locale.class));
        map3.put(AtomicBoolean.class, StdJdkSerializers$AtomicBooleanSerializer.class);
        map3.put(AtomicInteger.class, StdJdkSerializers$AtomicIntegerSerializer.class);
        map3.put(AtomicLong.class, StdJdkSerializers$AtomicLongSerializer.class);
        map3.put(File.class, FileSerializer.class);
        map3.put(Class.class, ClassSerializer.class);
        NullSerializer nullSerializer = NullSerializer.instance;
        map3.put(Void.class, nullSerializer);
        map3.put(Void.TYPE, nullSerializer);
        for (Map.Entry entry : map3.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof AbstractC0728s) {
                map2.put(((Class) entry.getKey()).getName(), (AbstractC0728s) value);
            } else {
                map.put(((Class) entry.getKey()).getName(), (Class) value);
            }
        }
        map.put(C1730E.class.getName(), TokenBufferSerializer.class);
        f5807f = map2;
        f5808g = map;
    }

    /* JADX INFO: renamed from: c */
    public static C0453A m3710c(AbstractC0709K abstractC0709K, C1005A c1005a, AbstractC0721l abstractC0721l, Class cls) {
        C0707I c0707i = abstractC0709K.f1966e;
        C0453A c0453a = c0707i.f2490m.f2448f;
        AbstractC0711b abstractC0711b = c1005a.f3581d;
        if (abstractC0711b != null) {
            C0453A c0453aMo1739K = abstractC0711b.mo1739K(c1005a.f3582e);
            if (c0453a != null) {
                c0453aMo1739K = c0453a.m989a(c0453aMo1739K);
            }
            c0453a = c0453aMo1739K;
        }
        c0707i.mo2150e(cls);
        c0707i.mo2150e(abstractC0721l.f2036e);
        return c0453a;
    }

    /* JADX INFO: renamed from: e */
    public static AbstractC0728s m3711e(AbstractC0709K abstractC0709K, AbstractC1031b abstractC1031b) {
        Object objMo1750V = abstractC0709K.f1966e.m2149d().mo1750V(abstractC1031b);
        if (objMo1750V == null) {
            return null;
        }
        AbstractC0728s abstractC0728sMo1709I = abstractC0709K.mo1709I(abstractC1031b, objMo1750V);
        Object objMo1746R = abstractC0709K.f1966e.m2149d().mo1746R(abstractC1031b);
        InterfaceC1748m interfaceC1748mM1812d = objMo1746R != null ? abstractC0709K.m1812d(objMo1746R) : null;
        if (interfaceC1748mM1812d == null) {
            return abstractC0728sMo1709I;
        }
        abstractC0709K.mo1711f();
        return new StdDelegatingSerializer(interfaceC1748mM1812d, ((C1160l) interfaceC1748mM1812d).f4009a, abstractC0728sMo1709I);
    }

    /* JADX INFO: renamed from: f */
    public static boolean m3712f(C0707I c0707i, C1005A c1005a) {
        EnumC0747k enumC0747kMo1749U = c0707i.m2149d().mo1749U(c1005a.f3582e);
        return (enumC0747kMo1749U == null || enumC0747kMo1749U == EnumC0747k.f2110g) ? c0707i.m2157l(EnumC0731v.USE_STATIC_TYPING) : enumC0747kMo1749U == EnumC0747k.f2109f;
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0157  */
    @Override // p112k1.AbstractC1644l
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final p069X0.AbstractC0728s mo3713a(p069X0.AbstractC0709K r12, p069X0.AbstractC0721l r13, p069X0.AbstractC0728s r14) {
        /*
            Method dump skipped, instruction units count: 378
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p112k1.AbstractC1634b.mo3713a(X0.K, X0.l, X0.s):X0.s");
    }

    @Override // p112k1.AbstractC1644l
    /* JADX INFO: renamed from: b */
    public final AbstractC1431s mo3714b(C0707I c0707i, AbstractC0721l abstractC0721l) {
        ArrayList arrayList;
        C1005A c1005aM2156k = c0707i.m2156k(abstractC0721l.f2036e);
        AbstractC0711b abstractC0711bM2149d = c0707i.m2149d();
        C1033d c1033d = c1005aM2156k.f3582e;
        C1426n c1426nMo1754Z = abstractC0711bM2149d.mo1754Z(abstractC0721l, c0707i, c1033d);
        if (c1426nMo1754Z == null) {
            c1426nMo1754Z = c0707i.f2481f.f2424j;
            arrayList = null;
        } else {
            ((C1425m) c0707i.f2485h).getClass();
            AbstractC0711b abstractC0711bM2149d2 = c0707i.m2149d();
            HashMap map = new HashMap();
            C1425m.m3433d(c1033d, new C1394c(c1033d.f3666f, null), c0707i, abstractC0711bM2149d2, map);
            arrayList = new ArrayList(map.values());
        }
        if (c1426nMo1754Z == null) {
            return null;
        }
        return c1426nMo1754Z.m3437b(c0707i, abstractC0721l, arrayList);
    }

    /* JADX INFO: renamed from: d */
    public final StdSerializer m3715d(AbstractC0709K abstractC0709K, AbstractC0721l abstractC0721l, C1005A c1005a) {
        if (InterfaceC0727r.class.isAssignableFrom(abstractC0721l.f2036e)) {
            return SerializableSerializer.instance;
        }
        AbstractC1041l abstractC1041lMo1801c = c1005a.mo1801c();
        if (abstractC1041lMo1801c == null) {
            return null;
        }
        C0707I c0707i = abstractC0709K.f1966e;
        c0707i.getClass();
        boolean zM2157l = c0707i.m2157l(EnumC0731v.CAN_OVERRIDE_ACCESS_MODIFIERS);
        C0707I c0707i2 = abstractC0709K.f1966e;
        if (zM2157l) {
            AbstractC1745j.m3882e(abstractC1041lMo1801c.mo2771k(), c0707i2.m2157l(EnumC0731v.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        AbstractC0721l abstractC0721lMo2769f = abstractC1041lMo1801c.mo2769f();
        AbstractC0728s abstractC0728sM3711e = m3711e(abstractC0709K, abstractC1041lMo1801c);
        if (abstractC0728sM3711e == null) {
            abstractC0728sM3711e = (AbstractC0728s) abstractC0721lMo2769f.f2038g;
        }
        AbstractC1399h abstractC1399hMo3714b = (AbstractC1399h) abstractC0721lMo2769f.f2039h;
        if (abstractC1399hMo3714b == null) {
            abstractC1399hMo3714b = mo3714b(c0707i2, abstractC0721lMo2769f);
        }
        return new JsonValueSerializer(abstractC1041lMo1801c, abstractC1399hMo3714b, abstractC0728sM3711e);
    }
}
