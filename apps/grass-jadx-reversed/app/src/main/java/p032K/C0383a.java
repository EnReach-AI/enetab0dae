package p032K;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* JADX INFO: renamed from: K.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0383a extends ClickableSpan {

    /* JADX INFO: renamed from: a */
    public final int f904a;

    /* JADX INFO: renamed from: b */
    public final C0391i f905b;

    /* JADX INFO: renamed from: c */
    public final int f906c;

    public C0383a(int i3, C0391i c0391i, int i4) {
        this.f904a = i3;
        this.f905b = c0391i;
        this.f906c = i4;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f904a);
        this.f905b.f920a.performAction(this.f906c, bundle);
    }
}
