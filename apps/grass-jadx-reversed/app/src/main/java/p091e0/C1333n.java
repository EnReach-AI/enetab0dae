package p091e0;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

/* JADX INFO: renamed from: e0.n */
/* JADX INFO: loaded from: classes.dex */
public final class C1333n extends Drawable.ConstantState {

    /* JADX INFO: renamed from: a */
    public int f4741a;

    /* JADX INFO: renamed from: b */
    public C1332m f4742b;

    /* JADX INFO: renamed from: c */
    public ColorStateList f4743c;

    /* JADX INFO: renamed from: d */
    public PorterDuff.Mode f4744d;

    /* JADX INFO: renamed from: e */
    public boolean f4745e;

    /* JADX INFO: renamed from: f */
    public Bitmap f4746f;

    /* JADX INFO: renamed from: g */
    public ColorStateList f4747g;

    /* JADX INFO: renamed from: h */
    public PorterDuff.Mode f4748h;

    /* JADX INFO: renamed from: i */
    public int f4749i;

    /* JADX INFO: renamed from: j */
    public boolean f4750j;

    /* JADX INFO: renamed from: k */
    public boolean f4751k;

    /* JADX INFO: renamed from: l */
    public Paint f4752l;

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        return this.f4741a;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        return new C1335p(this);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources) {
        return new C1335p(this);
    }
}
