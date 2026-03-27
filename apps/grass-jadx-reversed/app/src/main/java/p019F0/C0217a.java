package p019F0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.cardview.widget.CardView;
import com.facebook.AbstractC1103F;
import com.facebook.AbstractC1117n;
import com.facebook.C1125v;
import com.facebook.C1127x;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;
import p001A.C0009j;
import p002A0.C0019a;
import p002A0.C0021c;
import p002A0.C0022d;
import p006B0.C0040c;
import p010C0.AbstractC0147a;
import p020F2.AbstractC0223a;
import p025H1.C0272a;
import p025H1.C0281j;
import p033K0.AbstractC0405c;
import p033K0.AbstractC0406d;
import p039M0.AbstractC0493h0;
import p043N1.InterfaceC0562d;
import p059T1.C0647c;
import p059T1.InterfaceC0646b;
import p121n0.AbstractC1776a;
import p124o.AbstractC1790b;
import p124o.C1789a;
import p126o1.AbstractC1805a;
import p144t0.AbstractC1920f;
import p156w0.AbstractC1986a;
import p166z0.AbstractC2056E;
import p166z0.AbstractC2069g;
import p166z0.AbstractC2077o;
import p166z0.EnumC2076n;
import p166z0.InterfaceC2075m;

/* JADX INFO: renamed from: F0.a */
/* JADX INFO: loaded from: classes.dex */
public class C0217a implements InterfaceC2075m, InterfaceC0646b, InterfaceC0562d {

    /* JADX INFO: renamed from: f */
    public static C0217a f521f;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f522e;

    public /* synthetic */ C0217a(int i3) {
        this.f522e = i3;
    }

    /* JADX INFO: renamed from: a */
    public static C0217a m426a(Context context, int i3) {
        AbstractC0493h0.m1008a("Cannot create a CalendarItemStyle with a styleResId of 0", i3 != 0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i3, AbstractC1805a.f6236l);
        Rect rect = new Rect(typedArrayObtainStyledAttributes.getDimensionPixelOffset(0, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(2, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(3, 0));
        ColorStateList colorStateListM4303d = AbstractC1920f.m4303d(context, typedArrayObtainStyledAttributes, 4);
        ColorStateList colorStateListM4303d2 = AbstractC1920f.m4303d(context, typedArrayObtainStyledAttributes, 9);
        ColorStateList colorStateListM4303d3 = AbstractC1920f.m4303d(context, typedArrayObtainStyledAttributes, 7);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(8, 0);
        C0281j c0281jM4266a = C0281j.m551a(context, typedArrayObtainStyledAttributes.getResourceId(5, 0), typedArrayObtainStyledAttributes.getResourceId(6, 0), new C0272a(0)).m4266a();
        typedArrayObtainStyledAttributes.recycle();
        return new C0217a(colorStateListM4303d, colorStateListM4303d2, colorStateListM4303d3, dimensionPixelSize, c0281jM4266a, rect);
    }

    /* JADX INFO: renamed from: h */
    public static void m427h(C0647c c0647c, StringBuilder sb) {
        int iCharAt = (sb.charAt(1) * '(') + (sb.charAt(0) * 1600) + sb.charAt(2) + 1;
        c0647c.f1728c.append(new String(new char[]{(char) (iCharAt / 256), (char) (iCharAt % 256)}));
        sb.delete(0, 3);
    }

    /* JADX INFO: renamed from: b */
    public int mo428b(char c3, StringBuilder sb) {
        if (c3 == ' ') {
            sb.append((char) 3);
            return 1;
        }
        if (c3 >= '0' && c3 <= '9') {
            sb.append((char) (c3 - ','));
            return 1;
        }
        if (c3 >= 'A' && c3 <= 'Z') {
            sb.append((char) (c3 - '3'));
            return 1;
        }
        if (c3 < ' ') {
            sb.append((char) 0);
            sb.append(c3);
            return 2;
        }
        if (c3 >= '!' && c3 <= '/') {
            sb.append((char) 1);
            sb.append((char) (c3 - '!'));
            return 2;
        }
        if (c3 >= ':' && c3 <= '@') {
            sb.append((char) 1);
            sb.append((char) (c3 - '+'));
            return 2;
        }
        if (c3 >= '[' && c3 <= '_') {
            sb.append((char) 1);
            sb.append((char) (c3 - 'E'));
            return 2;
        }
        if (c3 < '`' || c3 > 127) {
            sb.append("\u0001\u001e");
            return mo428b((char) (c3 - 128), sb) + 2;
        }
        sb.append((char) 2);
        sb.append((char) (c3 - '`'));
        return 2;
    }

    @Override // p059T1.InterfaceC0646b
    /* JADX INFO: renamed from: c */
    public void mo429c(C0647c c0647c) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!c0647c.m1595b()) {
                break;
            }
            char cM1594a = c0647c.m1594a();
            c0647c.f1729d++;
            int iMo428b = mo428b(cM1594a, sb);
            int length = c0647c.f1728c.length() + ((sb.length() / 3) << 1);
            c0647c.m1596c(length);
            int i3 = c0647c.f1731f.f1739b - length;
            if (!c0647c.m1595b()) {
                StringBuilder sb2 = new StringBuilder();
                if (sb.length() % 3 == 2 && (i3 < 2 || i3 > 2)) {
                    int length2 = sb.length();
                    sb.delete(length2 - iMo428b, length2);
                    c0647c.f1729d--;
                    iMo428b = mo428b(c0647c.m1594a(), sb2);
                    c0647c.f1731f = null;
                }
                while (sb.length() % 3 == 1 && ((iMo428b <= 3 && i3 != 1) || iMo428b > 3)) {
                    int length3 = sb.length();
                    sb.delete(length3 - iMo428b, length3);
                    c0647c.f1729d--;
                    iMo428b = mo428b(c0647c.m1594a(), sb2);
                    c0647c.f1731f = null;
                }
            } else if (sb.length() % 3 == 0) {
                if (AbstractC1986a.m4383k(c0647c.f1726a, c0647c.f1729d, mo431e()) != mo431e()) {
                    c0647c.f1730e = 0;
                    break;
                }
            }
        }
        mo432f(c0647c, sb);
    }

    @Override // p166z0.InterfaceC2075m
    /* JADX INFO: renamed from: d */
    public void mo430d(boolean z3) {
        File[] fileArrListFiles;
        int i3 = 0;
        switch (this.f522e) {
            case 1:
                if (z3) {
                    synchronized (C0040c.class) {
                        try {
                            HashSet hashSet = AbstractC1117n.f3875a;
                            if (AbstractC1103F.m2866c()) {
                                C0040c.m190a();
                            }
                            if (C0040c.f105b != null) {
                                Log.w("B0.c", "Already enabled!");
                            } else {
                                C0040c c0040c = new C0040c(Thread.getDefaultUncaughtExceptionHandler());
                                C0040c.f105b = c0040c;
                                Thread.setDefaultUncaughtExceptionHandler(c0040c);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    if (AbstractC2077o.m4613b(EnumC2076n.CrashShield)) {
                        AbstractC0223a.f537a = true;
                        if (AbstractC1103F.m2866c() && !AbstractC2056E.m4549r()) {
                            File fileM898f = AbstractC0406d.m898f();
                            if (fileM898f == null) {
                                fileArrListFiles = new File[0];
                            } else {
                                fileArrListFiles = fileM898f.listFiles(new C0022d(0));
                                if (fileArrListFiles == null) {
                                    fileArrListFiles = new File[0];
                                }
                            }
                            ArrayList arrayList = new ArrayList();
                            for (File file : fileArrListFiles) {
                                C0021c c0021cM889k = AbstractC0405c.m889k(file);
                                if (c0021cM889k.m75a()) {
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        jSONObject.put("crash_shield", c0021cM889k.toString());
                                        AbstractC2069g.m4584h();
                                        arrayList.add(C1125v.m2913l(null, AbstractC1117n.f3877c + "/instruments", jSONObject, new C0019a(i3, c0021cM889k)));
                                    } catch (JSONException unused) {
                                    }
                                }
                            }
                            if (!arrayList.isEmpty()) {
                                C1125v.m2910g(new C1127x(arrayList));
                            }
                        }
                        AbstractC0147a.f355b = true;
                    }
                    AbstractC2077o.m4613b(EnumC2076n.ThreadCheck);
                    return;
                }
                return;
            case FromStringDeserializer.Std.STD_CHARSET /* 9 */:
                if (z3) {
                    AbstractC1117n.f3886l = true;
                    return;
                }
                return;
            default:
                if (z3) {
                    try {
                        if (AbstractC0147a.f354a.contains(AbstractC1776a.class)) {
                            return;
                        }
                        try {
                            AbstractC1117n.m2891a().execute(new RunnableC0218b(7));
                            break;
                        } catch (Exception unused2) {
                            HashSet hashSet2 = AbstractC1117n.f3875a;
                        }
                        return;
                    } catch (Throwable th2) {
                        AbstractC0147a.m295a(th2, AbstractC1776a.class);
                        return;
                    }
                }
                return;
        }
    }

    /* JADX INFO: renamed from: e */
    public int mo431e() {
        return 1;
    }

    /* JADX INFO: renamed from: f */
    public void mo432f(C0647c c0647c, StringBuilder sb) {
        int length = (sb.length() / 3) << 1;
        int length2 = sb.length() % 3;
        int length3 = c0647c.f1728c.length() + length;
        c0647c.m1596c(length3);
        int i3 = c0647c.f1731f.f1739b - length3;
        if (length2 == 2) {
            sb.append((char) 0);
            while (sb.length() >= 3) {
                m427h(c0647c, sb);
            }
            if (c0647c.m1595b()) {
                c0647c.m1597d((char) 254);
            }
        } else if (i3 == 1 && length2 == 1) {
            while (sb.length() >= 3) {
                m427h(c0647c, sb);
            }
            if (c0647c.m1595b()) {
                c0647c.m1597d((char) 254);
            }
            c0647c.f1729d--;
        } else {
            if (length2 != 0) {
                throw new IllegalStateException("Unexpected case. Please report!");
            }
            while (sb.length() >= 3) {
                m427h(c0647c, sb);
            }
            if (i3 > 0 || c0647c.m1595b()) {
                c0647c.m1597d((char) 254);
            }
        }
        c0647c.f1730e = 0;
    }

    /* JADX INFO: renamed from: g */
    public void m433g(C0009j c0009j, float f3) {
        C1789a c1789a = (C1789a) ((Drawable) c0009j.f30f);
        CardView cardView = (CardView) c0009j.f31g;
        boolean useCompatPadding = cardView.getUseCompatPadding();
        boolean preventCornerOverlap = cardView.getPreventCornerOverlap();
        if (f3 != c1789a.f6172e || c1789a.f6173f != useCompatPadding || c1789a.f6174g != preventCornerOverlap) {
            c1789a.f6172e = f3;
            c1789a.f6173f = useCompatPadding;
            c1789a.f6174g = preventCornerOverlap;
            c1789a.m3946b(null);
            c1789a.invalidateSelf();
        }
        if (!cardView.getUseCompatPadding()) {
            c0009j.m38P(0, 0, 0, 0);
            return;
        }
        C1789a c1789a2 = (C1789a) ((Drawable) c0009j.f30f);
        float f4 = c1789a2.f6172e;
        float f5 = c1789a2.f6168a;
        int iCeil = (int) Math.ceil(AbstractC1790b.m3947a(f4, f5, cardView.getPreventCornerOverlap()));
        int iCeil2 = (int) Math.ceil(AbstractC1790b.m3948b(f4, f5, cardView.getPreventCornerOverlap()));
        c0009j.m38P(iCeil, iCeil2, iCeil, iCeil2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:69:0x00e2, code lost:
    
        r4 = r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x065b  */
    /* JADX WARN: Removed duplicated region for block: B:399:0x06d6  */
    /* JADX WARN: Removed duplicated region for block: B:455:0x00e4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00c8  */
    @Override // p043N1.InterfaceC0562d
    /* JADX INFO: renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public p051Q1.C0601b mo434i(java.lang.String r25, int r26, java.util.EnumMap r27) throws p043N1.C0563e {
        /*
            Method dump skipped, instruction units count: 2102
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p019F0.C0217a.mo434i(java.lang.String, int, java.util.EnumMap):Q1.b");
    }

    public C0217a(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i3, C0281j c0281j, Rect rect) {
        this.f522e = 10;
        AbstractC0493h0.m1009b(rect.left);
        AbstractC0493h0.m1009b(rect.top);
        AbstractC0493h0.m1009b(rect.right);
        AbstractC0493h0.m1009b(rect.bottom);
    }
}
