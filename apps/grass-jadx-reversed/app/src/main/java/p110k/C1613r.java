package p110k;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
import com.facebook.C1124u;
import p085c1.C1080a;

/* JADX INFO: renamed from: k.r */
/* JADX INFO: loaded from: classes.dex */
public final class C1613r {

    /* JADX INFO: renamed from: b */
    public static final PorterDuff.Mode f5721b = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: c */
    public static C1613r f5722c;

    /* JADX INFO: renamed from: a */
    public C1532G0 f5723a;

    /* JADX INFO: renamed from: a */
    public static synchronized C1613r m3680a() {
        try {
            if (f5722c == null) {
                m3681c();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f5722c;
    }

    /* JADX INFO: renamed from: c */
    public static synchronized void m3681c() {
        if (f5722c == null) {
            C1613r c1613r = new C1613r();
            f5722c = c1613r;
            c1613r.f5723a = C1532G0.m3578c();
            C1532G0 c1532g0 = f5722c.f5723a;
            C1080a c1080a = new C1080a();
            synchronized (c1532g0) {
                c1532g0.f5494e = c1080a;
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m3682d(Drawable drawable, C1124u c1124u, int[] iArr) {
        PorterDuff.Mode mode = C1532G0.f5487f;
        int[] state = drawable.getState();
        int[] iArr2 = AbstractC1589g0.f5636a;
        if (drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
            drawable.setState(new int[0]);
            drawable.setState(state);
        }
        boolean z3 = c1124u.f3897f;
        if (!z3 && !c1124u.f3896e) {
            drawable.clearColorFilter();
            return;
        }
        PorterDuffColorFilter porterDuffColorFilterM3579g = null;
        ColorStateList colorStateList = z3 ? (ColorStateList) c1124u.f3898g : null;
        PorterDuff.Mode mode2 = c1124u.f3896e ? (PorterDuff.Mode) c1124u.f3899h : C1532G0.f5487f;
        if (colorStateList != null && mode2 != null) {
            porterDuffColorFilterM3579g = C1532G0.m3579g(colorStateList.getColorForState(iArr, 0), mode2);
        }
        drawable.setColorFilter(porterDuffColorFilterM3579g);
    }

    /* JADX INFO: renamed from: b */
    public final synchronized Drawable m3683b(Context context, int i3) {
        return this.f5723a.m3583e(context, i3);
    }
}
