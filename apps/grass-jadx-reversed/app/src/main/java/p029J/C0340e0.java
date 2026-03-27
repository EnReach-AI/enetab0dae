package p029J;

import android.graphics.Rect;
import android.util.Log;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import p005B.C0029d;

/* JADX INFO: renamed from: J.e0 */
/* JADX INFO: loaded from: classes.dex */
public final class C0340e0 extends AbstractC0346h0 {

    /* JADX INFO: renamed from: c */
    public static Field f842c = null;

    /* JADX INFO: renamed from: d */
    public static boolean f843d = false;

    /* JADX INFO: renamed from: e */
    public static Constructor f844e = null;

    /* JADX INFO: renamed from: f */
    public static boolean f845f = false;

    /* JADX INFO: renamed from: a */
    public WindowInsets f846a;

    /* JADX INFO: renamed from: b */
    public C0029d f847b;

    public C0340e0() {
        this.f846a = m735e();
    }

    /* JADX INFO: renamed from: e */
    private static WindowInsets m735e() {
        if (!f843d) {
            try {
                f842c = WindowInsets.class.getDeclaredField("CONSUMED");
            } catch (ReflectiveOperationException e3) {
                Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e3);
            }
            f843d = true;
        }
        Field field = f842c;
        if (field != null) {
            try {
                WindowInsets windowInsets = (WindowInsets) field.get(null);
                if (windowInsets != null) {
                    return new WindowInsets(windowInsets);
                }
            } catch (ReflectiveOperationException e4) {
                Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e4);
            }
        }
        if (!f845f) {
            try {
                f844e = WindowInsets.class.getConstructor(Rect.class);
            } catch (ReflectiveOperationException e5) {
                Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e5);
            }
            f845f = true;
        }
        Constructor constructor = f844e;
        if (constructor != null) {
            try {
                return (WindowInsets) constructor.newInstance(new Rect());
            } catch (ReflectiveOperationException e6) {
                Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e6);
            }
        }
        return null;
    }

    @Override // p029J.AbstractC0346h0
    /* JADX INFO: renamed from: b */
    public C0364q0 mo736b() {
        m745a();
        C0364q0 c0364q0M829g = C0364q0.m829g(this.f846a, null);
        C0360o0 c0360o0 = c0364q0M829g.f874a;
        c0360o0.mo755o(null);
        c0360o0.mo766q(this.f847b);
        return c0364q0M829g;
    }

    @Override // p029J.AbstractC0346h0
    /* JADX INFO: renamed from: c */
    public void mo737c(C0029d c0029d) {
        this.f847b = c0029d;
    }

    @Override // p029J.AbstractC0346h0
    /* JADX INFO: renamed from: d */
    public void mo738d(C0029d c0029d) {
        WindowInsets windowInsets = this.f846a;
        if (windowInsets != null) {
            this.f846a = windowInsets.replaceSystemWindowInsets(c0029d.f81a, c0029d.f82b, c0029d.f83c, c0029d.f84d);
        }
    }

    public C0340e0(C0364q0 c0364q0) {
        super(c0364q0);
        this.f846a = c0364q0.m834f();
    }
}
