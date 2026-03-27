package p148u0;

import android.graphics.Typeface;
import android.os.Bundle;
import com.facebook.AbstractC1117n;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
import p008B2.AbstractC0089b0;
import p010C0.AbstractC0147a;
import p015D2.C0198v;
import p117m0.C1711f;
import p119m2.AbstractC1766e;
import p119m2.AbstractC1770i;
import p119m2.AbstractC1772k;
import p119m2.C1763b;
import p133q0.AbstractC1838b;
import p135q2.InterfaceC1840a;
import p161x2.C2015d;
import p166z0.AbstractC2082t;
import p166z0.C2079q;

/* JADX INFO: renamed from: u0.c */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1944c {
    /* JADX INFO: renamed from: a */
    public static Bundle m4339a(int i3, String str, List list) {
        String str2;
        if (AbstractC0147a.f354a.contains(AbstractC1944c.class)) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList(list);
            Bundle bundle = new Bundle();
            if (i3 == 1) {
                str2 = "MOBILE_APP_INSTALL";
            } else {
                if (i3 != 2) {
                    throw null;
                }
                str2 = "CUSTOM_APP_EVENTS";
            }
            bundle.putString("event", str2);
            bundle.putString("app_id", str);
            if (2 == i3) {
                JSONArray jSONArrayM4340b = m4340b(arrayList, str);
                if (jSONArrayM4340b.length() == 0) {
                    return null;
                }
                bundle.putString("custom_events", jSONArrayM4340b.toString());
            }
            return bundle;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1944c.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    public static JSONArray m4340b(ArrayList arrayList, String str) {
        Set set = AbstractC0147a.f354a;
        if (set.contains(AbstractC1944c.class)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            AbstractC1838b.m4077b(arrayList);
            boolean z3 = false;
            if (!set.contains(AbstractC1944c.class)) {
                try {
                    C2079q c2079qM4625f = AbstractC2082t.m4625f(str, false);
                    if (c2079qM4625f != null) {
                        z3 = c2079qM4625f.f7350a;
                    }
                } catch (Throwable th) {
                    AbstractC0147a.m295a(th, AbstractC1944c.class);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                C1711f c1711f = (C1711f) it.next();
                String str2 = c1711f.f5988i;
                JSONObject jSONObject = c1711f.f5984e;
                if (str2 == null ? true : C1711f.m3790a(jSONObject.toString()).equals(str2)) {
                    boolean z4 = c1711f.f5985f;
                    if ((!z4) || (z4 && z3)) {
                        jSONArray.put(jSONObject);
                    }
                } else {
                    c1711f.toString();
                    HashSet hashSet = AbstractC1117n.f3875a;
                }
            }
            return jSONArray;
        } catch (Throwable th2) {
            AbstractC0147a.m295a(th2, AbstractC1944c.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: c */
    public static final void m4341c(C2015d c2015d, C0198v c0198v, Object obj) {
        boolean zIsInstance;
        AbstractC1766e.m3920e("<this>", c2015d);
        AbstractC1766e.m3920e("encoder", c0198v);
        AbstractC1766e.m3920e("value", obj);
        c0198v.m367s().getClass();
        InterfaceC1840a interfaceC1840a = c2015d.f7170a;
        AbstractC1766e.m3920e("baseClass", interfaceC1840a);
        Class clsM4345c = ((C1763b) interfaceC1840a).f6142a;
        AbstractC1766e.m3920e("jClass", clsM4345c);
        Map map = C1763b.f6140b;
        AbstractC1766e.m3918c("null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>", map);
        Integer num = (Integer) map.get(clsM4345c);
        if (num != null) {
            zIsInstance = AbstractC1772k.m3930b(num.intValue(), obj);
        } else {
            if (clsM4345c.isPrimitive()) {
                clsM4345c = AbstractC1946e.m4345c(AbstractC1770i.m3927a(clsM4345c));
            }
            zIsInstance = clsM4345c.isInstance(obj);
        }
        if (zIsInstance) {
            AbstractC1772k.m3930b(1, null);
        }
        C1763b c1763bM3927a = AbstractC1770i.m3927a(obj.getClass());
        String strM3915b = c1763bM3927a.m3915b();
        if (strM3915b == null) {
            strM3915b = String.valueOf(c1763bM3927a);
        }
        AbstractC0089b0.m261h(strM3915b, interfaceC1840a);
        throw null;
    }

    /* JADX INFO: renamed from: f */
    public static BigDecimal m4342f(int i3, char[] cArr, int i4) {
        int i5;
        BigDecimal bigDecimalM4343g;
        int i6 = i3;
        int i7 = -1;
        int i8 = -1;
        int i9 = 0;
        boolean z3 = false;
        boolean z4 = false;
        int i10 = 0;
        boolean z5 = false;
        for (int i11 = 0; i11 < i6; i11++) {
            char c3 = cArr[i11];
            if (c3 != '+') {
                if (c3 == 'E' || c3 == 'e') {
                    if (i7 >= 0) {
                        throw new NumberFormatException("Multiple exponent markers");
                    }
                    i7 = i11;
                } else if (c3 != '-') {
                    if (c3 == '.') {
                        if (i8 >= 0) {
                            throw new NumberFormatException("Multiple decimal points");
                        }
                        i8 = i11;
                    } else if (i8 >= 0 && i7 == -1) {
                        i9++;
                    }
                } else if (i7 >= 0) {
                    if (z4) {
                        throw new NumberFormatException("Multiple signs in exponent");
                    }
                    z4 = true;
                } else {
                    if (z3) {
                        throw new NumberFormatException("Multiple signs in number");
                    }
                    i10 = i11 + 1;
                    z3 = true;
                    z5 = true;
                }
            } else if (i7 >= 0) {
                if (z4) {
                    throw new NumberFormatException("Multiple signs in exponent");
                }
                z4 = true;
            } else {
                if (z3) {
                    throw new NumberFormatException("Multiple signs in number");
                }
                i10 = i11 + 1;
                z3 = true;
            }
        }
        if (i7 >= 0) {
            i5 = Integer.parseInt(new String(cArr, i7 + 1, (i6 - i7) - 1));
            long j2 = i5;
            long j3 = ((long) i9) - j2;
            if (j3 > 2147483647L || j3 < -2147483648L) {
                throw new NumberFormatException("Scale out of range: " + j3 + " while adjusting scale " + i9 + " to exponent " + j2);
            }
            i9 = (int) j3;
            i6 = i7;
        } else {
            i5 = 0;
        }
        if (i8 >= 0) {
            int i12 = (i6 - i8) - 1;
            bigDecimalM4343g = m4343g(cArr, i10, i8 - i10, i5, i4).add(m4343g(cArr, i8 + 1, i12, i5 - i12, i4));
        } else {
            bigDecimalM4343g = m4343g(cArr, i10, i6 - i10, i5, i4);
        }
        if (i9 != 0) {
            bigDecimalM4343g = bigDecimalM4343g.setScale(i9);
        }
        return z5 ? bigDecimalM4343g.negate() : bigDecimalM4343g;
    }

    /* JADX INFO: renamed from: g */
    public static BigDecimal m4343g(char[] cArr, int i3, int i4, int i5, int i6) {
        if (i4 <= i6) {
            return i4 == 0 ? BigDecimal.ZERO : new BigDecimal(cArr, i3, i4).scaleByPowerOfTen(i5);
        }
        int i7 = i4 / 2;
        return m4343g(cArr, i3, i7, (i5 + i4) - i7, i6).add(m4343g(cArr, i3 + i7, i4 - i7, i5, i6));
    }

    /* JADX INFO: renamed from: d */
    public abstract void mo209d(int i3);

    /* JADX INFO: renamed from: e */
    public abstract void mo210e(Typeface typeface, boolean z3);
}
