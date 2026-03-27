package p110k;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;

/* JADX INFO: renamed from: k.e1 */
/* JADX INFO: loaded from: classes.dex */
public final class C1584e1 implements InterfaceC1586f0 {

    /* JADX INFO: renamed from: a */
    public Toolbar f5618a;

    /* JADX INFO: renamed from: b */
    public int f5619b;

    /* JADX INFO: renamed from: c */
    public View f5620c;

    /* JADX INFO: renamed from: d */
    public Drawable f5621d;

    /* JADX INFO: renamed from: e */
    public Drawable f5622e;

    /* JADX INFO: renamed from: f */
    public Drawable f5623f;

    /* JADX INFO: renamed from: g */
    public boolean f5624g;

    /* JADX INFO: renamed from: h */
    public CharSequence f5625h;

    /* JADX INFO: renamed from: i */
    public CharSequence f5626i;

    /* JADX INFO: renamed from: j */
    public CharSequence f5627j;

    /* JADX INFO: renamed from: k */
    public Window.Callback f5628k;

    /* JADX INFO: renamed from: l */
    public boolean f5629l;

    /* JADX INFO: renamed from: m */
    public C1594i f5630m;

    /* JADX INFO: renamed from: n */
    public int f5631n;

    /* JADX INFO: renamed from: o */
    public Drawable f5632o;

    /* JADX INFO: renamed from: a */
    public final void m3647a(int i3) {
        View view;
        int i4 = this.f5619b ^ i3;
        this.f5619b = i3;
        if (i4 != 0) {
            if ((i4 & 4) != 0) {
                if ((i3 & 4) != 0) {
                    m3648b();
                }
                int i5 = this.f5619b & 4;
                Toolbar toolbar = this.f5618a;
                if (i5 != 0) {
                    Drawable drawable = this.f5623f;
                    if (drawable == null) {
                        drawable = this.f5632o;
                    }
                    toolbar.setNavigationIcon(drawable);
                } else {
                    toolbar.setNavigationIcon((Drawable) null);
                }
            }
            if ((i4 & 3) != 0) {
                m3649c();
            }
            int i6 = i4 & 8;
            Toolbar toolbar2 = this.f5618a;
            if (i6 != 0) {
                if ((i3 & 8) != 0) {
                    toolbar2.setTitle(this.f5625h);
                    toolbar2.setSubtitle(this.f5626i);
                } else {
                    toolbar2.setTitle((CharSequence) null);
                    toolbar2.setSubtitle((CharSequence) null);
                }
            }
            if ((i4 & 16) == 0 || (view = this.f5620c) == null) {
                return;
            }
            if ((i3 & 16) != 0) {
                toolbar2.addView(view);
            } else {
                toolbar2.removeView(view);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m3648b() {
        if ((this.f5619b & 4) != 0) {
            boolean zIsEmpty = TextUtils.isEmpty(this.f5627j);
            Toolbar toolbar = this.f5618a;
            if (zIsEmpty) {
                toolbar.setNavigationContentDescription(this.f5631n);
            } else {
                toolbar.setNavigationContentDescription(this.f5627j);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m3649c() {
        Drawable drawable;
        int i3 = this.f5619b;
        if ((i3 & 2) == 0) {
            drawable = null;
        } else if ((i3 & 1) == 0 || (drawable = this.f5622e) == null) {
            drawable = this.f5621d;
        }
        this.f5618a.setLogo(drawable);
    }
}
