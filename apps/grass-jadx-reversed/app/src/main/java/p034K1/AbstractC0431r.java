package p034K1;

import android.content.Context;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import p032K.C0391i;
import p032K.InterfaceC0386d;

/* JADX INFO: renamed from: K1.r */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0431r {

    /* JADX INFO: renamed from: a */
    public final TextInputLayout f1011a;

    /* JADX INFO: renamed from: b */
    public final C0430q f1012b;

    /* JADX INFO: renamed from: c */
    public final Context f1013c;

    /* JADX INFO: renamed from: d */
    public final CheckableImageButton f1014d;

    public AbstractC0431r(C0430q c0430q) {
        this.f1011a = c0430q.f989e;
        this.f1012b = c0430q;
        this.f1013c = c0430q.getContext();
        this.f1014d = c0430q.f995k;
    }

    /* JADX INFO: renamed from: a */
    public void mo914a() {
    }

    /* JADX INFO: renamed from: b */
    public void mo954b() {
    }

    /* JADX INFO: renamed from: c */
    public int mo915c() {
        return 0;
    }

    /* JADX INFO: renamed from: d */
    public int mo916d() {
        return 0;
    }

    /* JADX INFO: renamed from: e */
    public View.OnFocusChangeListener mo917e() {
        return null;
    }

    /* JADX INFO: renamed from: f */
    public View.OnClickListener mo918f() {
        return null;
    }

    /* JADX INFO: renamed from: g */
    public View.OnFocusChangeListener mo919g() {
        return null;
    }

    /* JADX INFO: renamed from: h */
    public InterfaceC0386d mo927h() {
        return null;
    }

    /* JADX INFO: renamed from: i */
    public boolean mo928i(int i3) {
        return true;
    }

    /* JADX INFO: renamed from: j */
    public boolean mo929j() {
        return false;
    }

    /* JADX INFO: renamed from: k */
    public boolean mo955k() {
        return this instanceof C0425l;
    }

    /* JADX INFO: renamed from: l */
    public boolean mo930l() {
        return false;
    }

    /* JADX INFO: renamed from: m */
    public void mo920m(EditText editText) {
    }

    /* JADX INFO: renamed from: n */
    public void mo931n(C0391i c0391i) {
    }

    /* JADX INFO: renamed from: o */
    public void mo932o(AccessibilityEvent accessibilityEvent) {
    }

    /* JADX INFO: renamed from: p */
    public void mo921p(boolean z3) {
    }

    /* JADX INFO: renamed from: q */
    public final void m956q() {
        this.f1012b.m945e(false);
    }

    /* JADX INFO: renamed from: r */
    public void mo922r() {
    }

    /* JADX INFO: renamed from: s */
    public void mo923s() {
    }
}
