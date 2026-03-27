package p045O0;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import p042N0.AbstractC0534b;
import p042N0.AbstractC0540h;
import p042N0.AbstractC0549q;
import p042N0.C0538f;
import p042N0.EnumC0539g;
import p042N0.InterfaceC0551s;
import p058T0.AbstractC0637b;
import p058T0.C0640e;
import p125o0.C1803m;

/* JADX INFO: renamed from: O0.a */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0569a extends AbstractC0540h {

    /* JADX INFO: renamed from: j */
    public static final int f1380j = (EnumC0539g.WRITE_NUMBERS_AS_STRINGS.f1267f | EnumC0539g.ESCAPE_NON_ASCII.f1267f) | EnumC0539g.STRICT_DUPLICATE_DETECTION.f1267f;

    /* JADX INFO: renamed from: f */
    public AbstractC0549q f1381f;

    /* JADX INFO: renamed from: g */
    public int f1382g;

    /* JADX INFO: renamed from: h */
    public boolean f1383h;

    /* JADX INFO: renamed from: i */
    public C0640e f1384i;

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: B */
    public final void mo1109B(Object obj) {
        if (obj == null) {
            mo1146s();
            return;
        }
        AbstractC0549q abstractC0549q = this.f1381f;
        if (abstractC0549q != null) {
            abstractC0549q.mo1223c(this, obj);
            return;
        }
        if (obj instanceof String) {
            mo1125R((String) obj);
            return;
        }
        if (obj instanceof Number) {
            Number number = (Number) obj;
            if (number instanceof Integer) {
                mo1149v(number.intValue());
                return;
            }
            if (number instanceof Long) {
                mo1150w(number.longValue());
                return;
            }
            if (number instanceof Double) {
                mo1147t(number.doubleValue());
                return;
            }
            if (number instanceof Float) {
                mo1148u(number.floatValue());
                return;
            }
            if (number instanceof Short) {
                mo1108A(number.shortValue());
                return;
            }
            if (number instanceof Byte) {
                mo1108A(number.byteValue());
                return;
            }
            if (number instanceof BigInteger) {
                mo1153z((BigInteger) number);
                return;
            }
            if (number instanceof BigDecimal) {
                mo1152y((BigDecimal) number);
                return;
            } else if (number instanceof AtomicInteger) {
                mo1149v(((AtomicInteger) number).get());
                return;
            } else if (number instanceof AtomicLong) {
                mo1150w(((AtomicLong) number).get());
                return;
            }
        } else if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            mo1139l(AbstractC0534b.f1228b, bArr, 0, bArr.length);
            return;
        } else if (obj instanceof Boolean) {
            mo1140m(((Boolean) obj).booleanValue());
            return;
        } else if (obj instanceof AtomicBoolean) {
            mo1140m(((AtomicBoolean) obj).get());
            return;
        }
        throw new IllegalStateException("No ObjectCodec defined for the generator, can only serialize simple wrapper types (type passed " + obj.getClass().getName() + ")");
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: H */
    public void mo1115H(InterfaceC0551s interfaceC0551s) {
        mo1248Y("write raw value");
        mo1112E(interfaceC0551s);
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: I */
    public final void mo1116I(String str) {
        mo1248Y("write raw value");
        mo1113F(str);
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: O */
    public void mo1122O(Object obj) {
        mo1121N(obj);
    }

    /* JADX INFO: renamed from: V */
    public final String m1245V(BigDecimal bigDecimal) throws C0538f {
        if (!EnumC0539g.WRITE_BIGDECIMAL_AS_PLAIN.m1106a(this.f1382g)) {
            return bigDecimal.toString();
        }
        int iScale = bigDecimal.scale();
        if (iScale >= -9999 && iScale <= 9999) {
            return bigDecimal.toPlainString();
        }
        m1129a(String.format("Attempt to write plain `java.math.BigDecimal` (see JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN) with illegal scale (%d): needs to be between [-%d, %d]", Integer.valueOf(iScale), 9999, 9999));
        throw null;
    }

    /* JADX INFO: renamed from: W */
    public final void m1246W(int i3, byte[] bArr, int i4) throws C0538f {
        if (bArr == null) {
            m1129a("Invalid `byte[]` argument: `null`");
            throw null;
        }
        int length = bArr.length;
        int i5 = i3 + i4;
        if (((length - i5) | i3 | i4 | i5) >= 0) {
            return;
        }
        m1129a(String.format("Invalid 'offset' (%d) and/or 'len' (%d) arguments for `byte[]` of length %d", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(length)));
        throw null;
    }

    /* JADX INFO: renamed from: X */
    public final void m1247X(char[] cArr, int i3) throws C0538f {
        if (cArr == null) {
            m1129a("Invalid `char[]` argument: `null`");
            throw null;
        }
        int length = cArr.length;
        if (((length - i3) | i3) >= 0) {
            return;
        }
        m1129a(String.format("Invalid 'offset' (%d) and/or 'len' (%d) arguments for `char[]` of length %d", 0, Integer.valueOf(i3), Integer.valueOf(length)));
        throw null;
    }

    /* JADX INFO: renamed from: Y */
    public abstract void mo1248Y(String str);

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: f */
    public final C0640e mo1133f() {
        return this.f1384i;
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: g */
    public final boolean mo1134g(EnumC0539g enumC0539g) {
        return (enumC0539g.f1267f & this.f1382g) != 0;
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: h */
    public final AbstractC0540h mo1135h(int i3, int i4) {
        int i5 = this.f1382g;
        int i6 = (i3 & i4) | ((~i4) & i5);
        int i7 = i5 ^ i6;
        if (i7 != 0) {
            this.f1382g = i6;
            AbstractC0637b abstractC0637b = (AbstractC0637b) this;
            if ((f1380j & i7) != 0) {
                abstractC0637b.f1383h = EnumC0539g.WRITE_NUMBERS_AS_STRINGS.m1106a(i6);
                EnumC0539g enumC0539g = EnumC0539g.ESCAPE_NON_ASCII;
                if (enumC0539g.m1106a(i7)) {
                    if (enumC0539g.m1106a(i6)) {
                        abstractC0637b.m1464b0(127);
                    } else {
                        abstractC0637b.m1464b0(0);
                    }
                }
                EnumC0539g enumC0539g2 = EnumC0539g.STRICT_DUPLICATE_DETECTION;
                if (enumC0539g2.m1106a(i7)) {
                    if (enumC0539g2.m1106a(i6)) {
                        C0640e c0640e = abstractC0637b.f1384i;
                        if (c0640e.f1659e == null) {
                            c0640e.f1659e = new C1803m(abstractC0637b);
                            abstractC0637b.f1384i = c0640e;
                        }
                    } else {
                        C0640e c0640e2 = abstractC0637b.f1384i;
                        c0640e2.f1659e = null;
                        abstractC0637b.f1384i = c0640e2;
                    }
                }
            }
            abstractC0637b.f1643o = !EnumC0539g.QUOTE_FIELD_NAMES.m1106a(i6);
            abstractC0637b.f1644p = EnumC0539g.WRITE_HEX_UPPER_CASE.m1106a(i6);
        }
        return this;
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: i */
    public final void mo1136i(Object obj) {
        C0640e c0640e = this.f1384i;
        if (c0640e != null) {
            c0640e.f1662h = obj;
        }
    }
}
