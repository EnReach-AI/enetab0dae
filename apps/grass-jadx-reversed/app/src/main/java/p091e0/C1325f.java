package p091e0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p009C.AbstractC0138a;
import p009C.AbstractC0139b;
import p034K1.C0424k;
import p117m0.AbstractC1720o;

/* JADX INFO: renamed from: e0.f */
/* JADX INFO: loaded from: classes.dex */
public final class C1325f extends AbstractC1326g implements Animatable {

    /* JADX INFO: renamed from: g */
    public final Context f4693g;

    /* JADX INFO: renamed from: h */
    public C0424k f4694h = null;

    /* JADX INFO: renamed from: i */
    public ArrayList f4695i = null;

    /* JADX INFO: renamed from: j */
    public final C1322c f4696j = new C1322c(this);

    /* JADX INFO: renamed from: f */
    public final C1323d f4692f = new C1323d();

    public C1325f(Context context) {
        this.f4693g = context;
    }

    @Override // p091e0.AbstractC1326g, android.graphics.drawable.Drawable
    public final void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f4697e;
        if (drawable != null) {
            AbstractC0139b.m273a(drawable, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        Drawable drawable = this.f4697e;
        if (drawable != null) {
            return AbstractC0139b.m274b(drawable);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Drawable drawable = this.f4697e;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        C1323d c1323d = this.f4692f;
        c1323d.f4687a.draw(canvas);
        if (c1323d.f4688b.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        Drawable drawable = this.f4697e;
        return drawable != null ? AbstractC0138a.m268a(drawable) : this.f4692f.f4687a.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        Drawable drawable = this.f4697e;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        int changingConfigurations = super.getChangingConfigurations();
        this.f4692f.getClass();
        return changingConfigurations | 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        Drawable drawable = this.f4697e;
        return drawable != null ? AbstractC0139b.m275c(drawable) : this.f4692f.f4687a.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.f4697e != null) {
            return new C1324e(this.f4697e.getConstantState());
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        Drawable drawable = this.f4697e;
        return drawable != null ? drawable.getIntrinsicHeight() : this.f4692f.f4687a.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        Drawable drawable = this.f4697e;
        return drawable != null ? drawable.getIntrinsicWidth() : this.f4692f.f4687a.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.f4697e;
        return drawable != null ? drawable.getOpacity() : this.f4692f.f4687a.getOpacity();
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ca, code lost:
    
        if (r3.f4688b != null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00cc, code lost:
    
        r3.f4688b = new android.animation.AnimatorSet();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d3, code lost:
    
        r3.f4688b.playTogether(r3.f4689c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00da, code lost:
    
        return;
     */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void inflate(android.content.res.Resources r10, org.xmlpull.v1.XmlPullParser r11, android.util.AttributeSet r12, android.content.res.Resources.Theme r13) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 219
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p091e0.C1325f.inflate(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):void");
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        Drawable drawable = this.f4697e;
        return drawable != null ? AbstractC0138a.m271d(drawable) : this.f4692f.f4687a.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        Drawable drawable = this.f4697e;
        return drawable != null ? ((AnimatedVectorDrawable) drawable).isRunning() : this.f4692f.f4688b.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        Drawable drawable = this.f4697e;
        return drawable != null ? drawable.isStateful() : this.f4692f.f4687a.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        Drawable drawable = this.f4697e;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f4697e;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f4692f.f4687a.setBounds(rect);
        }
    }

    @Override // p091e0.AbstractC1326g, android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i3) {
        Drawable drawable = this.f4697e;
        return drawable != null ? drawable.setLevel(i3) : this.f4692f.f4687a.setLevel(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f4697e;
        return drawable != null ? drawable.setState(iArr) : this.f4692f.f4687a.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i3) {
        Drawable drawable = this.f4697e;
        if (drawable != null) {
            drawable.setAlpha(i3);
        } else {
            this.f4692f.f4687a.setAlpha(i3);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z3) {
        Drawable drawable = this.f4697e;
        if (drawable != null) {
            AbstractC0138a.m272e(drawable, z3);
        } else {
            this.f4692f.f4687a.setAutoMirrored(z3);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f4697e;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f4692f.f4687a.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i3) {
        Drawable drawable = this.f4697e;
        if (drawable != null) {
            AbstractC1720o.m3822c(drawable, i3);
        } else {
            this.f4692f.f4687a.setTint(i3);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f4697e;
        if (drawable != null) {
            AbstractC0139b.m280h(drawable, colorStateList);
        } else {
            this.f4692f.f4687a.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f4697e;
        if (drawable != null) {
            AbstractC0139b.m281i(drawable, mode);
        } else {
            this.f4692f.f4687a.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z3, boolean z4) {
        Drawable drawable = this.f4697e;
        if (drawable != null) {
            return drawable.setVisible(z3, z4);
        }
        this.f4692f.f4687a.setVisible(z3, z4);
        return super.setVisible(z3, z4);
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        Drawable drawable = this.f4697e;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
            return;
        }
        C1323d c1323d = this.f4692f;
        if (c1323d.f4688b.isStarted()) {
            return;
        }
        c1323d.f4688b.start();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        Drawable drawable = this.f4697e;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f4692f.f4688b.end();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }
}
