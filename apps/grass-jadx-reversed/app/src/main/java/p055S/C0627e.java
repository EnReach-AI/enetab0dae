package p055S;

import android.text.Editable;
import android.text.method.KeyListener;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.View;
import p019F0.C0217a;
import p166z0.C2071i;

/* JADX INFO: renamed from: S.e */
/* JADX INFO: loaded from: classes.dex */
public final class C0627e implements KeyListener {

    /* JADX INFO: renamed from: a */
    public final KeyListener f1611a;

    /* JADX INFO: renamed from: b */
    public final C0217a f1612b;

    public C0627e(KeyListener keyListener) {
        C0217a c0217a = new C0217a(4);
        this.f1611a = keyListener;
        this.f1612b = c0217a;
    }

    @Override // android.text.method.KeyListener
    public final void clearMetaKeyState(View view, Editable editable, int i3) {
        this.f1611a.clearMetaKeyState(view, editable, i3);
    }

    @Override // android.text.method.KeyListener
    public final int getInputType() {
        return this.f1611a.getInputType();
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyDown(View view, Editable editable, int i3, KeyEvent keyEvent) {
        boolean z3;
        this.f1612b.getClass();
        if (i3 != 67 ? i3 != 112 ? false : C2071i.m4585c(editable, keyEvent, true) : C2071i.m4585c(editable, keyEvent, false)) {
            MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
            z3 = true;
        } else {
            z3 = false;
        }
        return z3 || this.f1611a.onKeyDown(view, editable, i3, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
        return this.f1611a.onKeyOther(view, editable, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyUp(View view, Editable editable, int i3, KeyEvent keyEvent) {
        return this.f1611a.onKeyUp(view, editable, i3, keyEvent);
    }
}
