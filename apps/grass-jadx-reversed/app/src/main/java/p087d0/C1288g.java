package p087d0;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;
import java.util.WeakHashMap;
import p019F0.C0222f;
import p029J.AbstractC0310E;
import p029J.AbstractC0323S;
import p039M0.AbstractC0493h0;

/* JADX INFO: renamed from: d0.g */
/* JADX INFO: loaded from: classes.dex */
public final class C1288g extends AbstractC1293l {

    /* JADX INFO: renamed from: A */
    public static final String[] f4598A = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};

    /* JADX INFO: renamed from: B */
    public static final C1284c f4599B;

    /* JADX INFO: renamed from: C */
    public static final C1284c f4600C;

    /* JADX INFO: renamed from: D */
    public static final C1284c f4601D;

    /* JADX INFO: renamed from: E */
    public static final C1284c f4602E;

    /* JADX INFO: renamed from: F */
    public static final C1284c f4603F;

    static {
        new C1283b(PointF.class, "boundsOrigin").f4587a = new Rect();
        f4599B = new C1284c(PointF.class, "topLeft", 0);
        f4600C = new C1284c(PointF.class, "bottomRight", 1);
        f4601D = new C1284c(PointF.class, "bottomRight", 2);
        f4602E = new C1284c(PointF.class, "topLeft", 3);
        f4603F = new C1284c(PointF.class, "position", 4);
    }

    /* JADX INFO: renamed from: F */
    public static void m3254F(C1298q c1298q) {
        View view = c1298q.f4643b;
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        if (!AbstractC0310E.m620c(view) && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        HashMap map = c1298q.f4642a;
        map.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        map.put("android:changeBounds:parent", c1298q.f4643b.getParent());
    }

    @Override // p087d0.AbstractC1293l
    /* JADX INFO: renamed from: c */
    public final void mo3239c(C1298q c1298q) {
        m3254F(c1298q);
    }

    @Override // p087d0.AbstractC1293l
    /* JADX INFO: renamed from: f */
    public final void mo3241f(C1298q c1298q) {
        m3254F(c1298q);
    }

    @Override // p087d0.AbstractC1293l
    /* JADX INFO: renamed from: j */
    public final Animator mo3255j(ViewGroup viewGroup, C1298q c1298q, C1298q c1298q2) {
        int i3;
        C1288g c1288g;
        Animator animatorOfObject;
        if (c1298q == null || c1298q2 == null) {
            return null;
        }
        HashMap map = c1298q.f4642a;
        HashMap map2 = c1298q2.f4642a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        Rect rect = (Rect) map.get("android:changeBounds:bounds");
        Rect rect2 = (Rect) map2.get("android:changeBounds:bounds");
        int i4 = rect.left;
        int i5 = rect2.left;
        int i6 = rect.top;
        int i7 = rect2.top;
        int i8 = rect.right;
        int i9 = rect2.right;
        int i10 = rect.bottom;
        int i11 = rect2.bottom;
        int i12 = i8 - i4;
        int i13 = i10 - i6;
        int i14 = i9 - i5;
        int i15 = i11 - i7;
        Rect rect3 = (Rect) map.get("android:changeBounds:clip");
        Rect rect4 = (Rect) map2.get("android:changeBounds:clip");
        if ((i12 == 0 || i13 == 0) && (i14 == 0 || i15 == 0)) {
            i3 = 0;
        } else {
            i3 = (i4 == i5 && i6 == i7) ? 0 : 1;
            if (i8 != i9 || i10 != i11) {
                i3++;
            }
        }
        if ((rect3 != null && !rect3.equals(rect4)) || (rect3 == null && rect4 != null)) {
            i3++;
        }
        if (i3 <= 0) {
            return null;
        }
        View view = c1298q2.f4643b;
        AbstractC1299r.m3277a(view, i4, i6, i8, i10);
        if (i3 != 2) {
            c1288g = this;
            if (i4 == i5 && i6 == i7) {
                c1288g.f4634w.getClass();
                animatorOfObject = ObjectAnimator.ofObject(view, f4601D, (TypeConverter) null, C0222f.m462b(i8, i10, i9, i11));
            } else {
                c1288g.f4634w.getClass();
                animatorOfObject = ObjectAnimator.ofObject(view, f4602E, (TypeConverter) null, C0222f.m462b(i4, i6, i5, i7));
            }
        } else if (i12 == i14 && i13 == i15) {
            c1288g = this;
            c1288g.f4634w.getClass();
            animatorOfObject = ObjectAnimator.ofObject(view, f4603F, (TypeConverter) null, C0222f.m462b(i4, i6, i5, i7));
        } else {
            c1288g = this;
            C1287f c1287f = new C1287f();
            c1287f.f4595e = view;
            c1288g.f4634w.getClass();
            ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(c1287f, f4599B, (TypeConverter) null, C0222f.m462b(i4, i6, i5, i7));
            c1288g.f4634w.getClass();
            ObjectAnimator objectAnimatorOfObject2 = ObjectAnimator.ofObject(c1287f, f4600C, (TypeConverter) null, C0222f.m462b(i8, i10, i9, i11));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(objectAnimatorOfObject, objectAnimatorOfObject2);
            animatorSet.addListener(new C1285d(c1287f));
            animatorOfObject = animatorSet;
        }
        if (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup4 = (ViewGroup) view.getParent();
            AbstractC0493h0.m1012e(viewGroup4, true);
            c1288g.m3266a(new C1286e(viewGroup4));
        }
        return animatorOfObject;
    }

    @Override // p087d0.AbstractC1293l
    /* JADX INFO: renamed from: o */
    public final String[] mo3256o() {
        return f4598A;
    }
}
