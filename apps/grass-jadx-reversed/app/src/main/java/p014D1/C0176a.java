package p014D1;

import android.R;
import android.content.res.ColorStateList;
import p041N.AbstractC0514b;
import p110k.C1629z;
import p144t0.AbstractC1920f;

/* JADX INFO: renamed from: D1.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0176a extends C1629z {

    /* JADX INFO: renamed from: k */
    public static final int[][] f412k = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* JADX INFO: renamed from: i */
    public ColorStateList f413i;

    /* JADX INFO: renamed from: j */
    public boolean f414j;

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f413i == null) {
            int iM4302c = AbstractC1920f.m4302c(this, io.getgrass.www.R.attr.colorControlActivated);
            int iM4302c2 = AbstractC1920f.m4302c(this, io.getgrass.www.R.attr.colorOnSurface);
            int iM4302c3 = AbstractC1920f.m4302c(this, io.getgrass.www.R.attr.colorSurface);
            this.f413i = new ColorStateList(f412k, new int[]{AbstractC1920f.m4309l(iM4302c3, iM4302c, 1.0f), AbstractC1920f.m4309l(iM4302c3, iM4302c2, 0.54f), AbstractC1920f.m4309l(iM4302c3, iM4302c2, 0.38f), AbstractC1920f.m4309l(iM4302c3, iM4302c2, 0.38f)});
        }
        return this.f413i;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f414j && AbstractC0514b.m1022a(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z3) {
        this.f414j = z3;
        if (z3) {
            AbstractC0514b.m1024c(this, getMaterialThemeColorsTintList());
        } else {
            AbstractC0514b.m1024c(this, null);
        }
    }
}
