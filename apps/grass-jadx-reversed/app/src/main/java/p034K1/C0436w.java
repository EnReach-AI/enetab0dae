package p034K1;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.WeakHashMap;
import p005B.AbstractC0026a;
import p009C.AbstractC0139b;
import p029J.AbstractC0307B;
import p029J.AbstractC0323S;

/* JADX INFO: renamed from: K1.w */
/* JADX INFO: loaded from: classes.dex */
public final class C0436w extends ArrayAdapter {

    /* JADX INFO: renamed from: e */
    public ColorStateList f1051e;

    /* JADX INFO: renamed from: f */
    public ColorStateList f1052f;

    /* JADX INFO: renamed from: g */
    public final /* synthetic */ C0437x f1053g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0436w(C0437x c0437x, Context context, int i3, String[] strArr) {
        super(context, i3, strArr);
        this.f1053g = c0437x;
        m966a();
    }

    /* JADX INFO: renamed from: a */
    public final void m966a() {
        ColorStateList colorStateList;
        C0437x c0437x = this.f1053g;
        ColorStateList colorStateList2 = c0437x.f1060o;
        ColorStateList colorStateList3 = null;
        if (colorStateList2 != null) {
            int[] iArr = {R.attr.state_pressed};
            colorStateList = new ColorStateList(new int[][]{iArr, new int[0]}, new int[]{colorStateList2.getColorForState(iArr, 0), 0});
        } else {
            colorStateList = null;
        }
        this.f1052f = colorStateList;
        if (c0437x.f1059n != 0 && c0437x.f1060o != null) {
            int[] iArr2 = {R.attr.state_hovered, -16842919};
            int[] iArr3 = {R.attr.state_selected, -16842919};
            colorStateList3 = new ColorStateList(new int[][]{iArr3, iArr2, new int[0]}, new int[]{AbstractC0026a.m105b(c0437x.f1060o.getColorForState(iArr3, 0), c0437x.f1059n), AbstractC0026a.m105b(c0437x.f1060o.getColorForState(iArr2, 0), c0437x.f1059n), c0437x.f1059n});
        }
        this.f1051e = colorStateList3;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final View getView(int i3, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i3, view, viewGroup);
        if (view2 instanceof TextView) {
            TextView textView = (TextView) view2;
            C0437x c0437x = this.f1053g;
            Drawable rippleDrawable = null;
            if (c0437x.getText().toString().contentEquals(textView.getText()) && c0437x.f1059n != 0) {
                ColorDrawable colorDrawable = new ColorDrawable(c0437x.f1059n);
                if (this.f1052f != null) {
                    AbstractC0139b.m280h(colorDrawable, this.f1051e);
                    rippleDrawable = new RippleDrawable(this.f1052f, colorDrawable, null);
                } else {
                    rippleDrawable = colorDrawable;
                }
            }
            WeakHashMap weakHashMap = AbstractC0323S.f816a;
            AbstractC0307B.m601q(textView, rippleDrawable);
        }
        return view2;
    }
}
