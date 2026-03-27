package androidx.lifecycle;

import p036L0.C0444d;

/* JADX INFO: renamed from: androidx.lifecycle.v */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0989v {

    /* JADX INFO: renamed from: a */
    public final C0444d f3337a;

    /* JADX INFO: renamed from: b */
    public boolean f3338b;

    /* JADX INFO: renamed from: c */
    public int f3339c = -1;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ C0990w f3340d;

    public AbstractC0989v(C0990w c0990w, C0444d c0444d) {
        this.f3340d = c0990w;
        this.f3337a = c0444d;
    }

    /* JADX INFO: renamed from: c */
    public final void m2525c(boolean z3) {
        if (z3 == this.f3338b) {
            return;
        }
        this.f3338b = z3;
        int i3 = z3 ? 1 : -1;
        C0990w c0990w = this.f3340d;
        int i4 = c0990w.f3344c;
        c0990w.f3344c = i3 + i4;
        if (!c0990w.f3345d) {
            c0990w.f3345d = true;
            while (true) {
                try {
                    int i5 = c0990w.f3344c;
                    if (i4 == i5) {
                        break;
                    } else {
                        i4 = i5;
                    }
                } finally {
                    c0990w.f3345d = false;
                }
            }
        }
        if (this.f3338b) {
            c0990w.m2528c(this);
        }
    }

    /* JADX INFO: renamed from: d */
    public void mo2506d() {
    }

    /* JADX INFO: renamed from: e */
    public abstract boolean mo2507e();
}
