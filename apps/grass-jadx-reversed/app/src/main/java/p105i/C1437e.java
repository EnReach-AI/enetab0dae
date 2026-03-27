package p105i;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import io.getgrass.www.R;

/* JADX INFO: renamed from: i.e */
/* JADX INFO: loaded from: classes.dex */
public final class C1437e extends ContextWrapper {

    /* JADX INFO: renamed from: f */
    public static Configuration f5079f;

    /* JADX INFO: renamed from: a */
    public int f5080a;

    /* JADX INFO: renamed from: b */
    public Resources.Theme f5081b;

    /* JADX INFO: renamed from: c */
    public LayoutInflater f5082c;

    /* JADX INFO: renamed from: d */
    public Configuration f5083d;

    /* JADX INFO: renamed from: e */
    public Resources f5084e;

    public C1437e(Context context, int i3) {
        super(context);
        this.f5080a = i3;
    }

    /* JADX INFO: renamed from: a */
    public final void m3444a(Configuration configuration) {
        if (this.f5084e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.f5083d != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.f5083d = new Configuration(configuration);
    }

    @Override // android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX INFO: renamed from: b */
    public final void m3445b() {
        if (this.f5081b == null) {
            this.f5081b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f5081b.setTo(theme);
            }
        }
        this.f5081b.applyStyle(this.f5080a, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final AssetManager getAssets() {
        return getResources().getAssets();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002c  */
    @Override // android.content.ContextWrapper, android.content.Context
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.content.res.Resources getResources() {
        /*
            r3 = this;
            android.content.res.Resources r0 = r3.f5084e
            if (r0 != 0) goto L32
            android.content.res.Configuration r0 = r3.f5083d
            if (r0 == 0) goto L2c
            android.content.res.Configuration r1 = p105i.C1437e.f5079f
            if (r1 != 0) goto L16
            android.content.res.Configuration r1 = new android.content.res.Configuration
            r1.<init>()
            r2 = 0
            r1.fontScale = r2
            p105i.C1437e.f5079f = r1
        L16:
            android.content.res.Configuration r1 = p105i.C1437e.f5079f
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L1f
            goto L2c
        L1f:
            android.content.res.Configuration r0 = r3.f5083d
            android.content.Context r0 = p105i.AbstractC1436d.m3443a(r3, r0)
            android.content.res.Resources r0 = r0.getResources()
            r3.f5084e = r0
            goto L32
        L2c:
            android.content.res.Resources r0 = super.getResources()
            r3.f5084e = r0
        L32:
            android.content.res.Resources r0 = r3.f5084e
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p105i.C1437e.getResources():android.content.res.Resources");
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f5082c == null) {
            this.f5082c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f5082c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources.Theme getTheme() {
        Resources.Theme theme = this.f5081b;
        if (theme != null) {
            return theme;
        }
        if (this.f5080a == 0) {
            this.f5080a = R.style.Theme_AppCompat_Light;
        }
        m3445b();
        return this.f5081b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i3) {
        if (this.f5080a != i3) {
            this.f5080a = i3;
            m3445b();
        }
    }
}
