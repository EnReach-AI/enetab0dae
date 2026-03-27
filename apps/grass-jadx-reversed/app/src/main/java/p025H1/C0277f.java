package p025H1;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import p003A1.C0023a;

/* JADX INFO: renamed from: H1.f */
/* JADX INFO: loaded from: classes.dex */
public final class C0277f extends Drawable.ConstantState {

    /* JADX INFO: renamed from: a */
    public C0281j f697a;

    /* JADX INFO: renamed from: b */
    public C0023a f698b;

    /* JADX INFO: renamed from: c */
    public ColorStateList f699c;

    /* JADX INFO: renamed from: d */
    public ColorStateList f700d;

    /* JADX INFO: renamed from: e */
    public ColorStateList f701e;

    /* JADX INFO: renamed from: f */
    public ColorStateList f702f;

    /* JADX INFO: renamed from: g */
    public PorterDuff.Mode f703g;

    /* JADX INFO: renamed from: h */
    public Rect f704h;

    /* JADX INFO: renamed from: i */
    public float f705i;

    /* JADX INFO: renamed from: j */
    public float f706j;

    /* JADX INFO: renamed from: k */
    public float f707k;

    /* JADX INFO: renamed from: l */
    public int f708l;

    /* JADX INFO: renamed from: m */
    public float f709m;

    /* JADX INFO: renamed from: n */
    public float f710n;

    /* JADX INFO: renamed from: o */
    public float f711o;

    /* JADX INFO: renamed from: p */
    public int f712p;

    /* JADX INFO: renamed from: q */
    public int f713q;

    /* JADX INFO: renamed from: r */
    public int f714r;

    /* JADX INFO: renamed from: s */
    public int f715s;

    /* JADX INFO: renamed from: t */
    public boolean f716t;

    /* JADX INFO: renamed from: u */
    public Paint.Style f717u;

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        C0278g c0278g = new C0278g(this);
        c0278g.f723i = true;
        return c0278g;
    }
}
