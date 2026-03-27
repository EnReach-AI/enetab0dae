package p029J;

import android.os.Build;
import android.view.View;
import java.nio.ByteBuffer;
import p025H1.C0276e;

/* JADX INFO: renamed from: J.z */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0375z {

    /* JADX INFO: renamed from: a */
    public int f885a;

    /* JADX INFO: renamed from: b */
    public int f886b;

    /* JADX INFO: renamed from: c */
    public int f887c;

    /* JADX INFO: renamed from: d */
    public Object f888d;

    public AbstractC0375z() {
        if (C0276e.f695f == null) {
            C0276e.f695f = new C0276e(3);
        }
    }

    /* JADX INFO: renamed from: a */
    public int m843a(int i3) {
        if (i3 < this.f887c) {
            return ((ByteBuffer) this.f888d).getShort(this.f886b + i3);
        }
        return 0;
    }

    /* JADX INFO: renamed from: b */
    public abstract Object mo840b(View view);

    /* JADX INFO: renamed from: c */
    public abstract void mo841c(View view, Object obj);

    /* JADX INFO: renamed from: d */
    public Object m844d(View view) {
        if (Build.VERSION.SDK_INT >= this.f886b) {
            return mo840b(view);
        }
        Object tag = view.getTag(this.f885a);
        if (((Class) this.f888d).isInstance(tag)) {
            return tag;
        }
        return null;
    }

    /* JADX INFO: renamed from: e */
    public void m845e(View view, Object obj) {
        if (Build.VERSION.SDK_INT >= this.f886b) {
            mo841c(view, obj);
            return;
        }
        if (mo842f(m844d(view), obj)) {
            View.AccessibilityDelegate accessibilityDelegateM692b = AbstractC0323S.m692b(view);
            C0335c c0335c = accessibilityDelegateM692b == null ? null : accessibilityDelegateM692b instanceof C0331a ? ((C0331a) accessibilityDelegateM692b).f828a : new C0335c(accessibilityDelegateM692b);
            if (c0335c == null) {
                c0335c = new C0335c();
            }
            AbstractC0323S.m701k(view, c0335c);
            view.setTag(this.f885a, obj);
            AbstractC0323S.m696f(view, this.f887c);
        }
    }

    /* JADX INFO: renamed from: f */
    public abstract boolean mo842f(Object obj, Object obj2);
}
