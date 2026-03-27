package p105i;

import android.support.v4.media.session.AbstractC0864a;
import android.view.View;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p029J.InterfaceC0332a0;
import p110k.C1584e1;

/* JADX INFO: renamed from: i.k */
/* JADX INFO: loaded from: classes.dex */
public final class C1443k extends AbstractC0864a {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5133a;

    /* JADX INFO: renamed from: b */
    public boolean f5134b;

    /* JADX INFO: renamed from: c */
    public int f5135c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f5136d;

    public C1443k(C1444l c1444l) {
        this.f5133a = 0;
        this.f5136d = c1444l;
        this.f5134b = false;
        this.f5135c = 0;
    }

    @Override // p029J.InterfaceC0332a0
    /* JADX INFO: renamed from: a */
    public final void mo341a() {
        switch (this.f5133a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                int i3 = this.f5135c + 1;
                this.f5135c = i3;
                C1444l c1444l = (C1444l) this.f5136d;
                if (i3 == c1444l.f5137a.size()) {
                    InterfaceC0332a0 interfaceC0332a0 = c1444l.f5140d;
                    if (interfaceC0332a0 != null) {
                        interfaceC0332a0.mo341a();
                    }
                    this.f5135c = 0;
                    this.f5134b = false;
                    c1444l.f5141e = false;
                }
                break;
            default:
                if (!this.f5134b) {
                    ((C1584e1) this.f5136d).f5618a.setVisibility(this.f5135c);
                }
                break;
        }
    }

    @Override // android.support.v4.media.session.AbstractC0864a, p029J.InterfaceC0332a0
    /* JADX INFO: renamed from: b */
    public void mo342b(View view) {
        switch (this.f5133a) {
            case 1:
                this.f5134b = true;
                break;
        }
    }

    @Override // android.support.v4.media.session.AbstractC0864a, p029J.InterfaceC0332a0
    /* JADX INFO: renamed from: c */
    public final void mo343c() {
        switch (this.f5133a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                if (!this.f5134b) {
                    this.f5134b = true;
                    InterfaceC0332a0 interfaceC0332a0 = ((C1444l) this.f5136d).f5140d;
                    if (interfaceC0332a0 != null) {
                        interfaceC0332a0.mo343c();
                    }
                    break;
                }
                break;
            default:
                ((C1584e1) this.f5136d).f5618a.setVisibility(0);
                break;
        }
    }

    public C1443k(C1584e1 c1584e1, int i3) {
        this.f5133a = 1;
        this.f5136d = c1584e1;
        this.f5135c = i3;
        this.f5134b = false;
    }
}
