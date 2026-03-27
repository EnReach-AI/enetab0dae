package p007B1;

import android.text.TextPaint;
import java.lang.ref.WeakReference;
import p016E1.C0206d;

/* JADX INFO: renamed from: B1.l */
/* JADX INFO: loaded from: classes.dex */
public final class C0052l {

    /* JADX INFO: renamed from: c */
    public float f193c;

    /* JADX INFO: renamed from: e */
    public final WeakReference f195e;

    /* JADX INFO: renamed from: f */
    public C0206d f196f;

    /* JADX INFO: renamed from: a */
    public final TextPaint f191a = new TextPaint(1);

    /* JADX INFO: renamed from: b */
    public final C0050j f192b = new C0050j(0, this);

    /* JADX INFO: renamed from: d */
    public boolean f194d = true;

    public C0052l(InterfaceC0051k interfaceC0051k) {
        this.f195e = new WeakReference(null);
        this.f195e = new WeakReference(interfaceC0051k);
    }
}
