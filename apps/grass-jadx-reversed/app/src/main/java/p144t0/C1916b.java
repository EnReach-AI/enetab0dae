package p144t0;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
import p005B.AbstractC0032g;
import p010C0.AbstractC0147a;
import p024H0.C0266t;
import p025H1.C0272a;
import p025H1.C0275d;
import p025H1.C0276e;
import p025H1.C0280i;
import p025H1.C0281j;
import p025H1.InterfaceC0274c;
import p033K0.AbstractC0406d;
import p136r.AbstractC1849h;
import p141s0.C1876f;

/* JADX INFO: renamed from: t0.b */
/* JADX INFO: loaded from: classes.dex */
public final class C1916b {

    /* JADX INFO: renamed from: a */
    public Object f6699a;

    /* JADX INFO: renamed from: b */
    public Object f6700b;

    /* JADX INFO: renamed from: c */
    public Object f6701c;

    /* JADX INFO: renamed from: d */
    public Object f6702d;

    /* JADX INFO: renamed from: e */
    public Object f6703e;

    /* JADX INFO: renamed from: f */
    public Object f6704f;

    /* JADX INFO: renamed from: g */
    public Object f6705g;

    /* JADX INFO: renamed from: h */
    public Object f6706h;

    /* JADX INFO: renamed from: i */
    public Object f6707i;

    /* JADX INFO: renamed from: j */
    public Object f6708j;

    /* JADX INFO: renamed from: k */
    public Object f6709k;

    /* JADX INFO: renamed from: l */
    public Object f6710l;

    public C1916b(HashMap map) {
        this.f6710l = new HashMap();
        this.f6699a = (C1915a) map.get("embed.weight");
        this.f6700b = AbstractC1919e.m4301v((C1915a) map.get("convs.0.weight"));
        this.f6701c = AbstractC1919e.m4301v((C1915a) map.get("convs.1.weight"));
        this.f6702d = AbstractC1919e.m4301v((C1915a) map.get("convs.2.weight"));
        this.f6703e = (C1915a) map.get("convs.0.bias");
        this.f6704f = (C1915a) map.get("convs.1.bias");
        this.f6705g = (C1915a) map.get("convs.2.bias");
        this.f6706h = AbstractC1919e.m4300u((C1915a) map.get("fc1.weight"));
        this.f6707i = AbstractC1919e.m4300u((C1915a) map.get("fc2.weight"));
        this.f6708j = (C1915a) map.get("fc1.bias");
        this.f6709k = (C1915a) map.get("fc2.bias");
        C0266t<String> c0266t = new C0266t();
        c0266t.add(AbstractC0032g.m148f(1));
        c0266t.add(AbstractC0032g.m148f(2));
        for (String str : c0266t) {
            String strM4117a = AbstractC1849h.m4117a(str, ".weight");
            String strM4117a2 = AbstractC1849h.m4117a(str, ".bias");
            C1915a c1915a = (C1915a) map.get(strM4117a);
            C1915a c1915a2 = (C1915a) map.get(strM4117a2);
            if (c1915a != null) {
                ((HashMap) this.f6710l).put(strM4117a, AbstractC1919e.m4300u(c1915a));
            }
            if (c1915a2 != null) {
                ((HashMap) this.f6710l).put(strM4117a2, c1915a2);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m4264b(AbstractC0406d abstractC0406d) {
        if (abstractC0406d instanceof C0280i) {
            ((C0280i) abstractC0406d).getClass();
        } else if (abstractC0406d instanceof C0275d) {
            ((C0275d) abstractC0406d).getClass();
        }
    }

    /* JADX INFO: renamed from: c */
    public static HashMap m4265c(File file) {
        C1876f c1876f;
        HashMap map = null;
        if (AbstractC0147a.f354a.contains(C1916b.class)) {
            return null;
        }
        try {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                int iAvailable = fileInputStream.available();
                DataInputStream dataInputStream = new DataInputStream(fileInputStream);
                byte[] bArr = new byte[iAvailable];
                dataInputStream.readFully(bArr);
                dataInputStream.close();
                if (iAvailable < 4) {
                    return null;
                }
                int i3 = 0;
                ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr, 0, 4);
                byteBufferWrap.order(ByteOrder.LITTLE_ENDIAN);
                int i4 = byteBufferWrap.getInt();
                int i5 = i4 + 4;
                if (iAvailable < i5) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject(new String(bArr, 4, i4));
                JSONArray jSONArrayNames = jSONObject.names();
                int length = jSONArrayNames.length();
                String[] strArr = new String[length];
                for (int i6 = 0; i6 < length; i6++) {
                    strArr[i6] = jSONArrayNames.getString(i6);
                }
                Arrays.sort(strArr);
                HashMap map2 = new HashMap();
                try {
                    if (AbstractC0147a.f354a.contains(C1916b.class)) {
                        c1876f = null;
                    } else {
                        try {
                            c1876f = new C1876f();
                        } catch (Throwable th) {
                            AbstractC0147a.m295a(th, C1916b.class);
                            c1876f = null;
                        }
                    }
                    int i7 = 0;
                    while (i7 < length) {
                        String str = strArr[i7];
                        JSONArray jSONArray = jSONObject.getJSONArray(str);
                        int length2 = jSONArray.length();
                        int[] iArr = new int[length2];
                        int i8 = 1;
                        for (int i9 = i3; i9 < length2; i9++) {
                            int i10 = jSONArray.getInt(i9);
                            iArr[i9] = i10;
                            i8 *= i10;
                        }
                        int i11 = i8 * 4;
                        int i12 = i5 + i11;
                        if (i12 > iAvailable) {
                            return null;
                        }
                        ByteBuffer byteBufferWrap2 = ByteBuffer.wrap(bArr, i5, i11);
                        byteBufferWrap2.order(ByteOrder.LITTLE_ENDIAN);
                        C1915a c1915a = new C1915a(iArr);
                        byteBufferWrap2.asFloatBuffer().get(c1915a.f6696a, 0, i8);
                        if (c1876f.containsKey(str)) {
                            str = (String) c1876f.get(str);
                        }
                        map2.put(str, c1915a);
                        i7++;
                        i5 = i12;
                        i3 = 0;
                        map = null;
                    }
                    return map2;
                } catch (Exception unused) {
                    return null;
                }
            } catch (Throwable th2) {
                AbstractC0147a.m295a(th2, C1916b.class);
                return null;
            }
        } catch (Exception unused2) {
            return map;
        }
    }

    /* JADX INFO: renamed from: a */
    public C0281j m4266a() {
        C0281j c0281j = new C0281j();
        c0281j.f742a = (AbstractC0406d) this.f6699a;
        c0281j.f743b = (AbstractC0406d) this.f6700b;
        c0281j.f744c = (AbstractC0406d) this.f6701c;
        c0281j.f745d = (AbstractC0406d) this.f6702d;
        c0281j.f746e = (InterfaceC0274c) this.f6703e;
        c0281j.f747f = (InterfaceC0274c) this.f6704f;
        c0281j.f748g = (InterfaceC0274c) this.f6705g;
        c0281j.f749h = (InterfaceC0274c) this.f6706h;
        c0281j.f750i = (C0276e) this.f6707i;
        c0281j.f751j = (C0276e) this.f6708j;
        c0281j.f752k = (C0276e) this.f6709k;
        c0281j.f753l = (C0276e) this.f6710l;
        return c0281j;
    }

    /* JADX INFO: renamed from: d */
    public C1915a m4267d(C1915a c1915a, String[] strArr, String str) {
        if (AbstractC0147a.f354a.contains(this)) {
            return null;
        }
        try {
            C1915a c1915aM4284e = AbstractC1919e.m4284e(AbstractC1919e.m4286g(strArr, (C1915a) this.f6699a), (C1915a) this.f6700b);
            AbstractC1919e.m4280a(c1915aM4284e, (C1915a) this.f6703e);
            AbstractC1919e.m4295p(c1915aM4284e);
            C1915a c1915aM4284e2 = AbstractC1919e.m4284e(c1915aM4284e, (C1915a) this.f6701c);
            AbstractC1919e.m4280a(c1915aM4284e2, (C1915a) this.f6704f);
            AbstractC1919e.m4295p(c1915aM4284e2);
            C1915a c1915aM4291l = AbstractC1919e.m4291l(c1915aM4284e2, 2);
            C1915a c1915aM4284e3 = AbstractC1919e.m4284e(c1915aM4291l, (C1915a) this.f6702d);
            AbstractC1919e.m4280a(c1915aM4284e3, (C1915a) this.f6705g);
            AbstractC1919e.m4295p(c1915aM4284e3);
            C1915a c1915aM4291l2 = AbstractC1919e.m4291l(c1915aM4284e, c1915aM4284e.f6697b[1]);
            C1915a c1915aM4291l3 = AbstractC1919e.m4291l(c1915aM4291l, c1915aM4291l.f6697b[1]);
            C1915a c1915aM4291l4 = AbstractC1919e.m4291l(c1915aM4284e3, c1915aM4284e3.f6697b[1]);
            AbstractC1919e.m4287h(c1915aM4291l2);
            AbstractC1919e.m4287h(c1915aM4291l3);
            AbstractC1919e.m4287h(c1915aM4291l4);
            C1915a c1915aM4285f = AbstractC1919e.m4285f(AbstractC1919e.m4283d(new C1915a[]{c1915aM4291l2, c1915aM4291l3, c1915aM4291l4, c1915a}), (C1915a) this.f6706h, (C1915a) this.f6708j);
            AbstractC1919e.m4295p(c1915aM4285f);
            C1915a c1915aM4285f2 = AbstractC1919e.m4285f(c1915aM4285f, (C1915a) this.f6707i, (C1915a) this.f6709k);
            AbstractC1919e.m4295p(c1915aM4285f2);
            HashMap map = (HashMap) this.f6710l;
            C1915a c1915a2 = (C1915a) map.get(str.concat(".weight"));
            C1915a c1915a3 = (C1915a) map.get(str.concat(".bias"));
            if (c1915a2 != null && c1915a3 != null) {
                C1915a c1915aM4285f3 = AbstractC1919e.m4285f(c1915aM4285f2, c1915a2, c1915a3);
                AbstractC1919e.m4299t(c1915aM4285f3);
                return c1915aM4285f3;
            }
            return null;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, this);
            return null;
        }
    }

    public C1916b() {
        this.f6699a = new C0280i();
        this.f6700b = new C0280i();
        this.f6701c = new C0280i();
        this.f6702d = new C0280i();
        this.f6703e = new C0272a(0.0f);
        this.f6704f = new C0272a(0.0f);
        this.f6705g = new C0272a(0.0f);
        this.f6706h = new C0272a(0.0f);
        this.f6707i = new C0276e(0);
        this.f6708j = new C0276e(0);
        this.f6709k = new C0276e(0);
        this.f6710l = new C0276e(0);
    }
}
