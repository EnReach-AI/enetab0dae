package p110k;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.TypedValue;
import io.getgrass.www.R;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import p085c1.C1080a;
import p128p.AbstractC1810d;
import p128p.C1811e;
import p128p.C1818l;

/* JADX INFO: renamed from: k.G0 */
/* JADX INFO: loaded from: classes.dex */
public final class C1532G0 {

    /* JADX INFO: renamed from: g */
    public static C1532G0 f5488g;

    /* JADX INFO: renamed from: a */
    public WeakHashMap f5490a;

    /* JADX INFO: renamed from: b */
    public final WeakHashMap f5491b = new WeakHashMap(0);

    /* JADX INFO: renamed from: c */
    public TypedValue f5492c;

    /* JADX INFO: renamed from: d */
    public boolean f5493d;

    /* JADX INFO: renamed from: e */
    public C1080a f5494e;

    /* JADX INFO: renamed from: f */
    public static final PorterDuff.Mode f5487f = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: h */
    public static final C1530F0 f5489h = new C1530F0(6);

    /* JADX INFO: renamed from: c */
    public static synchronized C1532G0 m3578c() {
        try {
            if (f5488g == null) {
                f5488g = new C1532G0();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f5488g;
    }

    /* JADX INFO: renamed from: g */
    public static synchronized PorterDuffColorFilter m3579g(int i3, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        C1530F0 c1530f0 = f5489h;
        c1530f0.getClass();
        int i4 = (31 + i3) * 31;
        porterDuffColorFilter = (PorterDuffColorFilter) c1530f0.m4030a(Integer.valueOf(mode.hashCode() + i4));
        if (porterDuffColorFilter == null) {
            porterDuffColorFilter = new PorterDuffColorFilter(i3, mode);
        }
        return porterDuffColorFilter;
    }

    /* JADX INFO: renamed from: a */
    public final synchronized void m3580a(Context context, long j2, Drawable drawable) {
        try {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                C1811e c1811e = (C1811e) this.f5491b.get(context);
                if (c1811e == null) {
                    c1811e = new C1811e();
                    this.f5491b.put(context, c1811e);
                }
                c1811e.m4027e(j2, new WeakReference(constantState));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: renamed from: b */
    public final Drawable m3581b(Context context, int i3) {
        if (this.f5492c == null) {
            this.f5492c = new TypedValue();
        }
        TypedValue typedValue = this.f5492c;
        context.getResources().getValue(i3, typedValue, true);
        long j2 = (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
        Drawable drawableM3582d = m3582d(context, j2);
        if (drawableM3582d != null) {
            return drawableM3582d;
        }
        LayerDrawable layerDrawableM2819c = null;
        if (this.f5494e != null) {
            if (i3 == R.drawable.abc_cab_background_top_material) {
                layerDrawableM2819c = new LayerDrawable(new Drawable[]{m3583e(context, R.drawable.abc_cab_background_internal_bg), m3583e(context, R.drawable.abc_cab_background_top_mtrl_alpha)});
            } else if (i3 == R.drawable.abc_ratingbar_material) {
                layerDrawableM2819c = C1080a.m2819c(this, context, R.dimen.abc_star_big);
            } else if (i3 == R.drawable.abc_ratingbar_indicator_material) {
                layerDrawableM2819c = C1080a.m2819c(this, context, R.dimen.abc_star_medium);
            } else if (i3 == R.drawable.abc_ratingbar_small_material) {
                layerDrawableM2819c = C1080a.m2819c(this, context, R.dimen.abc_star_small);
            }
        }
        if (layerDrawableM2819c != null) {
            layerDrawableM2819c.setChangingConfigurations(typedValue.changingConfigurations);
            m3580a(context, j2, layerDrawableM2819c);
        }
        return layerDrawableM2819c;
    }

    /* JADX INFO: renamed from: d */
    public final synchronized Drawable m3582d(Context context, long j2) {
        C1811e c1811e = (C1811e) this.f5491b.get(context);
        if (c1811e == null) {
            return null;
        }
        WeakReference weakReference = (WeakReference) c1811e.m4026d(j2, null);
        if (weakReference != null) {
            Drawable.ConstantState constantState = (Drawable.ConstantState) weakReference.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            int iM4022b = AbstractC1810d.m4022b(c1811e.f6271f, c1811e.f6273h, j2);
            if (iM4022b >= 0) {
                Object[] objArr = c1811e.f6272g;
                Object obj = objArr[iM4022b];
                Object obj2 = C1811e.f6269i;
                if (obj != obj2) {
                    objArr[iM4022b] = obj2;
                    c1811e.f6270e = true;
                }
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: e */
    public final synchronized Drawable m3583e(Context context, int i3) {
        return m3584f(context, i3, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00c9 A[Catch: all -> 0x00d8, TryCatch #0 {, blocks: (B:3:0x0001, B:12:0x0026, B:14:0x002c, B:16:0x0032, B:18:0x0039, B:25:0x0050, B:23:0x004c, B:26:0x0055, B:30:0x006c, B:37:0x00a2, B:38:0x00c9, B:43:0x00d4, B:6:0x0006, B:8:0x0012, B:10:0x0016, B:50:0x00dd, B:51:0x00e6), top: B:54:0x0001 }] */
    /* JADX INFO: renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized android.graphics.drawable.Drawable m3584f(android.content.Context r9, int r10, boolean r11) {
        /*
            Method dump skipped, instruction units count: 233
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p110k.C1532G0.m3584f(android.content.Context, int, boolean):android.graphics.drawable.Drawable");
    }

    /* JADX INFO: renamed from: h */
    public final synchronized ColorStateList m3585h(Context context, int i3) {
        ColorStateList colorStateList;
        C1818l c1818l;
        WeakHashMap weakHashMap = this.f5490a;
        ColorStateList colorStateListM2821d = null;
        colorStateList = (weakHashMap == null || (c1818l = (C1818l) weakHashMap.get(context)) == null) ? null : (ColorStateList) c1818l.m4044c(i3, null);
        if (colorStateList == null) {
            C1080a c1080a = this.f5494e;
            if (c1080a != null) {
                colorStateListM2821d = c1080a.m2821d(context, i3);
            }
            if (colorStateListM2821d != null) {
                if (this.f5490a == null) {
                    this.f5490a = new WeakHashMap();
                }
                C1818l c1818l2 = (C1818l) this.f5490a.get(context);
                if (c1818l2 == null) {
                    c1818l2 = new C1818l();
                    this.f5490a.put(context, c1818l2);
                }
                c1818l2.m4042a(i3, colorStateListM2821d);
            }
            colorStateList = colorStateListM2821d;
        }
        return colorStateList;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m3586i(android.content.Context r8, int r9, android.graphics.drawable.Drawable r10) {
        /*
            r7 = this;
            c1.a r0 = r7.f5494e
            r1 = 0
            if (r0 == 0) goto L76
            android.graphics.PorterDuff$Mode r2 = p110k.C1613r.f5721b
            java.lang.Object r3 = r0.f3764a
            int[] r3 = (int[]) r3
            boolean r3 = p085c1.C1080a.m2817a(r3, r9)
            r4 = 1
            r5 = -1
            if (r3 == 0) goto L19
            r9 = 2130903251(0x7f0300d3, float:1.7413315E38)
        L16:
            r3 = r4
        L17:
            r0 = r5
            goto L55
        L19:
            java.io.Serializable r3 = r0.f3766c
            int[] r3 = (int[]) r3
            boolean r3 = p085c1.C1080a.m2817a(r3, r9)
            if (r3 == 0) goto L27
            r9 = 2130903249(0x7f0300d1, float:1.741331E38)
            goto L16
        L27:
            java.lang.Object r0 = r0.f3767d
            int[] r0 = (int[]) r0
            boolean r0 = p085c1.C1080a.m2817a(r0, r9)
            r3 = 16842801(0x1010031, float:2.3693695E-38)
            if (r0 == 0) goto L38
            android.graphics.PorterDuff$Mode r2 = android.graphics.PorterDuff.Mode.MULTIPLY
        L36:
            r9 = r3
            goto L16
        L38:
            r0 = 2131165262(0x7f07004e, float:1.7944736E38)
            if (r9 != r0) goto L4c
            r9 = 1109603123(0x42233333, float:40.8)
            int r9 = java.lang.Math.round(r9)
            r0 = 16842800(0x1010030, float:2.3693693E-38)
            r3 = r4
            r6 = r0
            r0 = r9
            r9 = r6
            goto L55
        L4c:
            r0 = 2131165244(0x7f07003c, float:1.79447E38)
            if (r9 != r0) goto L52
            goto L36
        L52:
            r9 = r1
            r3 = r9
            goto L17
        L55:
            if (r3 == 0) goto L76
            int[] r1 = p110k.AbstractC1589g0.f5636a
            android.graphics.drawable.Drawable r10 = r10.mutate()
            int r8 = p110k.AbstractC1561V0.m3630c(r8, r9)
            java.lang.Class<k.r> r9 = p110k.C1613r.class
            monitor-enter(r9)
            android.graphics.PorterDuffColorFilter r8 = m3579g(r8, r2)     // Catch: java.lang.Throwable -> L73
            monitor-exit(r9)
            r10.setColorFilter(r8)
            if (r0 == r5) goto L71
            r10.setAlpha(r0)
        L71:
            r1 = r4
            goto L76
        L73:
            r8 = move-exception
            monitor-exit(r9)
            throw r8
        L76:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p110k.C1532G0.m3586i(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
    }
}
