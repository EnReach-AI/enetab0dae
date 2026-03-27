package p008B2;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import p005B.AbstractC0032g;
import p039M0.AbstractC0493h0;
import p119m2.AbstractC1766e;
import p119m2.C1763b;
import p135q2.InterfaceC1840a;
import p135q2.InterfaceC1841b;
import p161x2.C2017f;
import p161x2.InterfaceC2012a;
import p167z2.C2097i;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: B2.b0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0089b0 {

    /* JADX INFO: renamed from: a */
    public static final InterfaceC2095g[] f260a = new InterfaceC2095g[0];

    /* JADX INFO: renamed from: b */
    public static final InterfaceC2012a[] f261b = new InterfaceC2012a[0];

    /* JADX INFO: renamed from: c */
    public static final Object f262c = new Object();

    /* JADX INFO: renamed from: a */
    public static final C0067G m254a(String str, InterfaceC2012a interfaceC2012a) {
        return new C0067G(str, new C0068H(interfaceC2012a));
    }

    /* JADX INFO: renamed from: b */
    public static final Set m255b(InterfaceC2095g interfaceC2095g) {
        AbstractC1766e.m3920e("<this>", interfaceC2095g);
        if (interfaceC2095g instanceof InterfaceC0106k) {
            return ((InterfaceC0106k) interfaceC2095g).mo264e();
        }
        HashSet hashSet = new HashSet(interfaceC2095g.mo240l());
        int iMo240l = interfaceC2095g.mo240l();
        for (int i3 = 0; i3 < iMo240l; i3++) {
            hashSet.add(interfaceC2095g.mo230a(i3));
        }
        return hashSet;
    }

    /* JADX INFO: renamed from: c */
    public static final InterfaceC2095g[] m256c(List list) {
        InterfaceC2095g[] interfaceC2095gArr;
        if (list == null || list.isEmpty()) {
            list = null;
        }
        return (list == null || (interfaceC2095gArr = (InterfaceC2095g[]) list.toArray(new InterfaceC2095g[0])) == null) ? f260a : interfaceC2095gArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00dd, code lost:
    
        r12 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e9  */
    /* JADX INFO: renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final p161x2.InterfaceC2012a m257d(p135q2.InterfaceC1840a r16, p161x2.InterfaceC2012a... r17) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instruction units count: 509
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p008B2.AbstractC0089b0.m257d(q2.a, x2.a[]):x2.a");
    }

    /* JADX INFO: renamed from: e */
    public static final int m258e(InterfaceC2095g interfaceC2095g, InterfaceC2095g[] interfaceC2095gArr) {
        AbstractC1766e.m3920e("<this>", interfaceC2095g);
        AbstractC1766e.m3920e("typeParams", interfaceC2095gArr);
        int iHashCode = (interfaceC2095g.mo233d().hashCode() * 31) + Arrays.hashCode(interfaceC2095gArr);
        C2097i c2097i = new C2097i(interfaceC2095g, 0);
        int iHashCode2 = 1;
        int i3 = 1;
        while (true) {
            int iHashCode3 = 0;
            if (!c2097i.hasNext()) {
                break;
            }
            int i4 = i3 * 31;
            String strMo233d = ((InterfaceC2095g) c2097i.next()).mo233d();
            if (strMo233d != null) {
                iHashCode3 = strMo233d.hashCode();
            }
            i3 = i4 + iHashCode3;
        }
        C2097i c2097i2 = new C2097i(interfaceC2095g, 0);
        while (c2097i2.hasNext()) {
            int i5 = iHashCode2 * 31;
            AbstractC0493h0 abstractC0493h0Mo237i = ((InterfaceC2095g) c2097i2.next()).mo237i();
            iHashCode2 = i5 + (abstractC0493h0Mo237i != null ? abstractC0493h0Mo237i.hashCode() : 0);
        }
        return (((iHashCode * 31) + i3) * 31) + iHashCode2;
    }

    /* JADX INFO: renamed from: f */
    public static final InterfaceC2012a m259f(Object obj, InterfaceC2012a... interfaceC2012aArr) throws IllegalAccessException, InvocationTargetException {
        Class[] clsArr;
        try {
            if (interfaceC2012aArr.length == 0) {
                clsArr = new Class[0];
            } else {
                int length = interfaceC2012aArr.length;
                Class[] clsArr2 = new Class[length];
                for (int i3 = 0; i3 < length; i3++) {
                    clsArr2[i3] = InterfaceC2012a.class;
                }
                clsArr = clsArr2;
            }
            Object objInvoke = obj.getClass().getDeclaredMethod("serializer", (Class[]) Arrays.copyOf(clsArr, clsArr.length)).invoke(obj, Arrays.copyOf(interfaceC2012aArr, interfaceC2012aArr.length));
            if (objInvoke instanceof InterfaceC2012a) {
                return (InterfaceC2012a) objInvoke;
            }
            return null;
        } catch (NoSuchMethodException unused) {
            return null;
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause == null) {
                throw e3;
            }
            String message = cause.getMessage();
            if (message == null) {
                message = e3.getMessage();
            }
            throw new InvocationTargetException(cause, message);
        }
    }

    /* JADX INFO: renamed from: g */
    public static final InterfaceC1840a m260g(InterfaceC1841b interfaceC1841b) {
        AbstractC1766e.m3920e("<this>", interfaceC1841b);
        InterfaceC1840a interfaceC1840aMo248c = interfaceC1841b.mo248c();
        if (interfaceC1840aMo248c instanceof InterfaceC1840a) {
            return interfaceC1840aMo248c;
        }
        throw new IllegalStateException(("Only KClass supported as classifier, got " + interfaceC1840aMo248c).toString());
    }

    /* JADX INFO: renamed from: h */
    public static final void m261h(String str, InterfaceC1840a interfaceC1840a) {
        String strM157o;
        AbstractC1766e.m3920e("baseClass", interfaceC1840a);
        StringBuilder sb = new StringBuilder("in the scope of '");
        C1763b c1763b = (C1763b) interfaceC1840a;
        sb.append(c1763b.m3915b());
        sb.append('\'');
        String string = sb.toString();
        if (str == null) {
            strM157o = AbstractC0032g.m152j("Class discriminator was missing and no default polymorphic serializers were registered ", string);
        } else {
            StringBuilder sb2 = new StringBuilder("Class '");
            sb2.append(str);
            sb2.append("' is not registered for polymorphic serialization ");
            sb2.append(string);
            sb2.append(".\nTo be registered automatically, class '");
            sb2.append(str);
            sb2.append("' has to be '@Serializable', and the base class '");
            sb2.append(c1763b.m3915b());
            sb2.append("' has to be sealed and '@Serializable'.\nAlternatively, register the serializer for '");
            strM157o = AbstractC0032g.m157o(sb2, str, "' explicitly in a corresponding SerializersModule.");
        }
        throw new C2017f(strM157o);
    }
}
