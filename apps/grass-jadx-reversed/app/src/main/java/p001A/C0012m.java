package p001A;

import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;

/* JADX INFO: renamed from: A.m */
/* JADX INFO: loaded from: classes.dex */
public final class C0012m {

    /* JADX INFO: renamed from: a */
    public final ColorStateList f32a;

    /* JADX INFO: renamed from: b */
    public final Configuration f33b;

    /* JADX INFO: renamed from: c */
    public final int f34c;

    public C0012m(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
        this.f32a = colorStateList;
        this.f33b = configuration;
        this.f34c = theme == null ? 0 : theme.hashCode();
    }
}
