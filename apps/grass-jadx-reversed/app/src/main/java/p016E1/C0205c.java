package p016E1;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import p148u0.AbstractC1944c;

/* JADX INFO: renamed from: E1.c */
/* JADX INFO: loaded from: classes.dex */
public final class C0205c extends AbstractC1944c {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Context f494a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ TextPaint f495b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ AbstractC1944c f496c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ C0206d f497d;

    public C0205c(C0206d c0206d, Context context, TextPaint textPaint, AbstractC1944c abstractC1944c) {
        this.f497d = c0206d;
        this.f494a = context;
        this.f495b = textPaint;
        this.f496c = abstractC1944c;
    }

    @Override // p148u0.AbstractC1944c
    /* JADX INFO: renamed from: d */
    public final void mo209d(int i3) {
        this.f496c.mo209d(i3);
    }

    @Override // p148u0.AbstractC1944c
    /* JADX INFO: renamed from: e */
    public final void mo210e(Typeface typeface, boolean z3) {
        this.f497d.m402g(this.f494a, this.f495b, typeface);
        this.f496c.mo210e(typeface, z3);
    }
}
