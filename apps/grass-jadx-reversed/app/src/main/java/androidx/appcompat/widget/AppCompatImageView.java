package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.facebook.C1124u;
import p001A.C0003d;
import p110k.AbstractC1561V0;
import p110k.AbstractC1563W0;
import p110k.AbstractC1589g0;
import p110k.C1605n;
import p125o0.AbstractC1800j;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatImageView extends ImageView {

    /* JADX INFO: renamed from: e */
    public final C1605n f2751e;

    /* JADX INFO: renamed from: f */
    public final C0003d f2752f;

    /* JADX INFO: renamed from: g */
    public boolean f2753g;

    public AppCompatImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C1605n c1605n = this.f2751e;
        if (c1605n != null) {
            c1605n.m3669a();
        }
        C0003d c0003d = this.f2752f;
        if (c0003d != null) {
            c0003d.m18a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C1605n c1605n = this.f2751e;
        if (c1605n != null) {
            return c1605n.m3670d();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C1605n c1605n = this.f2751e;
        if (c1605n != null) {
            return c1605n.m3671e();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        C1124u c1124u;
        C0003d c0003d = this.f2752f;
        if (c0003d == null || (c1124u = (C1124u) c0003d.f17d) == null) {
            return null;
        }
        return (ColorStateList) c1124u.f3898g;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        C1124u c1124u;
        C0003d c0003d = this.f2752f;
        if (c0003d == null || (c1124u = (C1124u) c0003d.f17d) == null) {
            return null;
        }
        return (PorterDuff.Mode) c1124u.f3899h;
    }

    @Override // android.widget.ImageView, android.view.View
    public final boolean hasOverlappingRendering() {
        return ((((ImageView) this.f2752f.f16c).getBackground() instanceof RippleDrawable) ^ true) && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C1605n c1605n = this.f2751e;
        if (c1605n != null) {
            c1605n.m3673g();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        super.setBackgroundResource(i3);
        C1605n c1605n = this.f2751e;
        if (c1605n != null) {
            c1605n.m3674h(i3);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        C0003d c0003d = this.f2752f;
        if (c0003d != null) {
            c0003d.m18a();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        C0003d c0003d = this.f2752f;
        if (c0003d != null && drawable != null && !this.f2753g) {
            c0003d.f15b = drawable.getLevel();
        }
        super.setImageDrawable(drawable);
        if (c0003d != null) {
            c0003d.m18a();
            if (this.f2753g) {
                return;
            }
            ImageView imageView = (ImageView) c0003d.f16c;
            if (imageView.getDrawable() != null) {
                imageView.getDrawable().setLevel(c0003d.f15b);
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int i3) {
        super.setImageLevel(i3);
        this.f2753g = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i3) {
        C0003d c0003d = this.f2752f;
        if (c0003d != null) {
            ImageView imageView = (ImageView) c0003d.f16c;
            if (i3 != 0) {
                Drawable drawableM3991i = AbstractC1800j.m3991i(imageView.getContext(), i3);
                if (drawableM3991i != null) {
                    AbstractC1589g0.m3651a(drawableM3991i);
                }
                imageView.setImageDrawable(drawableM3991i);
            } else {
                imageView.setImageDrawable(null);
            }
            c0003d.m18a();
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        C0003d c0003d = this.f2752f;
        if (c0003d != null) {
            c0003d.m18a();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C1605n c1605n = this.f2751e;
        if (c1605n != null) {
            c1605n.m3676j(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C1605n c1605n = this.f2751e;
        if (c1605n != null) {
            c1605n.m3677k(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        C0003d c0003d = this.f2752f;
        if (c0003d != null) {
            if (((C1124u) c0003d.f17d) == null) {
                c0003d.f17d = new C1124u();
            }
            C1124u c1124u = (C1124u) c0003d.f17d;
            c1124u.f3898g = colorStateList;
            c1124u.f3897f = true;
            c0003d.m18a();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        C0003d c0003d = this.f2752f;
        if (c0003d != null) {
            if (((C1124u) c0003d.f17d) == null) {
                c0003d.f17d = new C1124u();
            }
            C1124u c1124u = (C1124u) c0003d.f17d;
            c1124u.f3899h = mode;
            c1124u.f3896e = true;
            c0003d.m18a();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        AbstractC1563W0.m3634a(context);
        this.f2753g = false;
        AbstractC1561V0.m3628a(this, getContext());
        C1605n c1605n = new C1605n(this);
        this.f2751e = c1605n;
        c1605n.m3672f(attributeSet, i3);
        C0003d c0003d = new C0003d(this);
        this.f2752f = c0003d;
        c0003d.m21e(attributeSet, i3);
    }
}
