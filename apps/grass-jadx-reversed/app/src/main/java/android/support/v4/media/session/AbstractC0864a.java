package android.support.v4.media.session;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.View;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import p001A.C0006g;
import p021G.C0233j;
import p025H1.C0276e;
import p029J.InterfaceC0332a0;
import p117m0.AbstractC1717l;
import p125o0.C1803m;

/* JADX INFO: renamed from: android.support.v4.media.session.a */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0864a implements InterfaceC0332a0 {
    public AbstractC0864a() {
        new ConcurrentHashMap();
    }

    @Override // p029J.InterfaceC0332a0
    /* JADX INFO: renamed from: b */
    public void mo342b(View view) {
    }

    @Override // p029J.InterfaceC0332a0
    /* JADX INFO: renamed from: c */
    public void mo343c() {
    }

    /* JADX INFO: renamed from: d */
    public abstract Typeface mo175d(Context context, C0006g c0006g, Resources resources, int i3);

    /* JADX INFO: renamed from: e */
    public abstract Typeface mo176e(Context context, C0233j[] c0233jArr, int i3);

    /* JADX INFO: renamed from: f */
    public Typeface mo177f(Context context, Resources resources, int i3, String str, int i4) {
        File fileM3803f = AbstractC1717l.m3803f(context);
        if (fileM3803f == null) {
            return null;
        }
        try {
            if (AbstractC1717l.m3800c(fileM3803f, resources, i3)) {
                return Typeface.createFromFile(fileM3803f.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileM3803f.delete();
        }
    }

    /* JADX INFO: renamed from: g */
    public C0233j mo188g(C0233j[] c0233jArr, int i3) {
        C0276e c0276e = new C0276e(1);
        int i4 = (i3 & 1) == 0 ? 400 : 700;
        boolean z3 = (i3 & 2) != 0;
        C0233j c0233j = null;
        int i5 = Integer.MAX_VALUE;
        for (C0233j c0233j2 : c0233jArr) {
            int iAbs = (Math.abs(c0276e.m535f(c0233j2) - i4) * 2) + (c0276e.m536g(c0233j2) == z3 ? 0 : 1);
            if (c0233j == null || i5 > iAbs) {
                c0233j = c0233j2;
                i5 = iAbs;
            }
        }
        return c0233j;
    }

    /* JADX INFO: renamed from: h */
    public abstract void mo2191h(Throwable th);

    /* JADX INFO: renamed from: i */
    public abstract void mo2192i(C1803m c1803m);
}
