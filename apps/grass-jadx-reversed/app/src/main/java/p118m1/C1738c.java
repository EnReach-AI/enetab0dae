package p118m1;

import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p001A.C0003d;

/* JADX INFO: renamed from: m1.c */
/* JADX INFO: loaded from: classes.dex */
public final class C1738c {

    /* JADX INFO: renamed from: a */
    public Object f6085a;

    /* JADX INFO: renamed from: b */
    public C0003d f6086b;

    /* JADX INFO: renamed from: c */
    public C0003d f6087c;

    /* JADX INFO: renamed from: d */
    public int f6088d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f6089e;

    /* JADX INFO: renamed from: a */
    public final Object m3864a(int i3) {
        switch (this.f6089e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                return new boolean[i3];
            case 1:
                return new byte[i3];
            case 2:
                return new double[i3];
            case FromStringDeserializer.Std.STD_URI /* 3 */:
                return new float[i3];
            case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                return new int[i3];
            case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                return new long[i3];
            default:
                return new short[i3];
        }
    }

    /* JADX INFO: renamed from: b */
    public final Object m3865b(int i3, Object obj) {
        C0003d c0003d = new C0003d(i3, obj);
        if (this.f6086b == null) {
            this.f6087c = c0003d;
            this.f6086b = c0003d;
        } else {
            C0003d c0003d2 = this.f6087c;
            if (((C0003d) c0003d2.f17d) != null) {
                throw new IllegalStateException();
            }
            c0003d2.f17d = c0003d;
            this.f6087c = c0003d;
        }
        this.f6088d += i3;
        return m3864a(i3 < 16384 ? i3 + i3 : i3 + (i3 >> 2));
    }

    /* JADX INFO: renamed from: c */
    public final Object m3866c(int i3, Object obj) {
        int i4 = this.f6088d + i3;
        Object objM3864a = m3864a(i4);
        int i5 = 0;
        for (C0003d c0003d = this.f6086b; c0003d != null; c0003d = (C0003d) c0003d.f17d) {
            Object obj2 = c0003d.f16c;
            int i6 = c0003d.f15b;
            System.arraycopy(obj2, 0, objM3864a, i5, i6);
            i5 += i6;
        }
        System.arraycopy(obj, 0, objM3864a, i5, i3);
        int i7 = i5 + i3;
        if (i7 == i4) {
            return objM3864a;
        }
        throw new IllegalStateException("Should have gotten " + i4 + " entries, got " + i7);
    }

    /* JADX INFO: renamed from: d */
    public final Object m3867d() {
        C0003d c0003d = this.f6087c;
        if (c0003d != null) {
            this.f6085a = c0003d.f16c;
        }
        this.f6087c = null;
        this.f6086b = null;
        this.f6088d = 0;
        Object obj = this.f6085a;
        return obj == null ? m3864a(12) : obj;
    }
}
