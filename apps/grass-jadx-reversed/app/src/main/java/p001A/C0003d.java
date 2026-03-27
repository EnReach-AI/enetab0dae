package p001A;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.facebook.C1124u;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import java.lang.reflect.Array;
import p015D2.C0191o;
import p029J.AbstractC0323S;
import p041N.AbstractC0518f;
import p094f.AbstractC1343a;
import p110k.AbstractC1589g0;
import p110k.C1613r;
import p118m1.AbstractC1745j;
import p119m2.AbstractC1766e;
import p125o0.AbstractC1800j;
import p166z0.C2071i;
import p167z2.C2100l;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: A.d */
/* JADX INFO: loaded from: classes.dex */
public final class C0003d {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f14a;

    /* JADX INFO: renamed from: b */
    public int f15b;

    /* JADX INFO: renamed from: c */
    public Object f16c;

    /* JADX INFO: renamed from: d */
    public Object f17d;

    public /* synthetic */ C0003d() {
        this.f14a = 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01f1, code lost:
    
        if (r5 == 1) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01f3, code lost:
    
        if (r5 == 2) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01f5, code lost:
    
        r1 = android.graphics.Shader.TileMode.CLAMP;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01f7, code lost:
    
        r17 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01fa, code lost:
    
        r1 = android.graphics.Shader.TileMode.MIRROR;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01fd, code lost:
    
        r1 = android.graphics.Shader.TileMode.REPEAT;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0200, code lost:
    
        r1 = 0;
        r3 = new android.graphics.LinearGradient(r11, r27, r26, r25, (int[]) r0.f30f, (float[]) r0.f31g, r17);
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0217, code lost:
    
        r1 = 0;
        r3 = new android.graphics.SweepGradient(r22, r23, (int[]) r0.f30f, (float[]) r0.f31g);
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x022a, code lost:
    
        r9 = r22;
        r15 = r23;
        r1 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0232, code lost:
    
        if (r24 <= 0.0f) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0237, code lost:
    
        if (r5 == 1) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x023a, code lost:
    
        if (r5 == 2) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x023c, code lost:
    
        r2 = android.graphics.Shader.TileMode.CLAMP;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0241, code lost:
    
        r2 = android.graphics.Shader.TileMode.MIRROR;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0244, code lost:
    
        r2 = android.graphics.Shader.TileMode.REPEAT;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0247, code lost:
    
        r3 = new android.graphics.RadialGradient(r9, r15, r24, (int[]) r0.f30f, (float[]) r0.f31g, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0264, code lost:
    
        return new p001A.C0003d(r3, (android.content.res.ColorStateList) null, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x026c, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01cf, code lost:
    
        if (r14.size() <= 0) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01d1, code lost:
    
        r0 = new p001A.C0009j(r14, r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01d7, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01d8, code lost:
    
        if (r0 == null) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01dc, code lost:
    
        if (r19 == false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01de, code lost:
    
        r0 = new p001A.C0009j(r6, r9, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01e4, code lost:
    
        r0 = new p001A.C0009j(r6, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01ea, code lost:
    
        if (r8 == 1) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01ed, code lost:
    
        if (r8 == 2) goto L107;
     */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static p001A.C0003d m17b(android.content.res.Resources r29, int r30, android.content.res.Resources.Theme r31) {
        /*
            Method dump skipped, instruction units count: 659
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p001A.C0003d.m17b(android.content.res.Resources, int, android.content.res.Resources$Theme):A.d");
    }

    /* JADX INFO: renamed from: a */
    public void m18a() {
        C1124u c1124u;
        ImageView imageView = (ImageView) this.f16c;
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            AbstractC1589g0.m3651a(drawable);
        }
        if (drawable == null || (c1124u = (C1124u) this.f17d) == null) {
            return;
        }
        C1613r.m3682d(drawable, c1124u, imageView.getDrawableState());
    }

    /* JADX INFO: renamed from: c */
    public String m19c() {
        StringBuilder sb = new StringBuilder("$");
        int i3 = this.f15b + 1;
        for (int i4 = 0; i4 < i3; i4++) {
            Object obj = ((Object[]) this.f16c)[i4];
            if (obj instanceof InterfaceC2095g) {
                InterfaceC2095g interfaceC2095g = (InterfaceC2095g) obj;
                if (!AbstractC1766e.m3916a(interfaceC2095g.mo237i(), C2100l.f7425d)) {
                    int i5 = ((int[]) this.f17d)[i4];
                    if (i5 >= 0) {
                        sb.append(".");
                        sb.append(interfaceC2095g.mo230a(i5));
                    }
                } else if (((int[]) this.f17d)[i4] != -1) {
                    sb.append("[");
                    sb.append(((int[]) this.f17d)[i4]);
                    sb.append("]");
                }
            } else if (obj != C0191o.f441a) {
                sb.append("['");
                sb.append(obj);
                sb.append("']");
            }
        }
        String string = sb.toString();
        AbstractC1766e.m3919d("StringBuilder().apply(builderAction).toString()", string);
        return string;
    }

    /* JADX INFO: renamed from: d */
    public boolean m20d() {
        ColorStateList colorStateList;
        return ((Shader) this.f16c) == null && (colorStateList = (ColorStateList) this.f17d) != null && colorStateList.isStateful();
    }

    /* JADX INFO: renamed from: e */
    public void m21e(AttributeSet attributeSet, int i3) {
        int resourceId;
        ImageView imageView = (ImageView) this.f16c;
        Context context = imageView.getContext();
        int[] iArr = AbstractC1343a.f4782f;
        C2071i c2071iM4591v = C2071i.m4591v(context, attributeSet, iArr, i3, 0);
        AbstractC0323S.m700j(imageView, imageView.getContext(), iArr, attributeSet, (TypedArray) c2071iM4591v.f7315b, i3);
        try {
            Drawable drawable = imageView.getDrawable();
            TypedArray typedArray = (TypedArray) c2071iM4591v.f7315b;
            if (drawable == null && (resourceId = typedArray.getResourceId(1, -1)) != -1 && (drawable = AbstractC1800j.m3991i(imageView.getContext(), resourceId)) != null) {
                imageView.setImageDrawable(drawable);
            }
            if (drawable != null) {
                AbstractC1589g0.m3651a(drawable);
            }
            if (typedArray.hasValue(2)) {
                AbstractC0518f.m1033c(imageView, c2071iM4591v.m4600j(2));
            }
            if (typedArray.hasValue(3)) {
                AbstractC0518f.m1034d(imageView, AbstractC1589g0.m3652b(typedArray.getInt(3, -1), null));
            }
            c2071iM4591v.m4608x();
        } catch (Throwable th) {
            c2071iM4591v.m4608x();
            throw th;
        }
    }

    public boolean equals(Object obj) {
        switch (this.f14a) {
            case FromStringDeserializer.Std.STD_URI /* 3 */:
                if (obj == this) {
                    return true;
                }
                if (AbstractC1745j.m3896s(obj, (Class) this.f16c)) {
                    int length = Array.getLength(obj);
                    int i3 = this.f15b;
                    if (length == i3) {
                        for (int i4 = 0; i4 < i3; i4++) {
                            Object obj2 = Array.get(this.f17d, i4);
                            Object obj3 = Array.get(obj, i4);
                            if (obj2 == obj3 || obj2 == null || obj2.equals(obj3)) {
                            }
                        }
                        return true;
                    }
                }
                return false;
            default:
                return super.equals(obj);
        }
    }

    public String toString() {
        switch (this.f14a) {
            case 1:
                return m19c();
            default:
                return super.toString();
        }
    }

    public C0003d(ImageView imageView) {
        this.f14a = 2;
        this.f15b = 0;
        this.f16c = imageView;
    }

    public C0003d(Shader shader, ColorStateList colorStateList, int i3) {
        this.f14a = 0;
        this.f16c = shader;
        this.f17d = colorStateList;
        this.f15b = i3;
    }

    public C0003d(int i3, Object obj) {
        this.f14a = 4;
        this.f16c = obj;
        this.f15b = i3;
    }

    public C0003d(Class cls, int i3, Object obj) {
        this.f14a = 3;
        this.f16c = cls;
        this.f15b = i3;
        this.f17d = obj;
    }
}
