package p029J;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;

/* JADX INFO: renamed from: J.o */
/* JADX INFO: loaded from: classes.dex */
public final class C0359o {

    /* JADX INFO: renamed from: a */
    public ViewParent f866a;

    /* JADX INFO: renamed from: b */
    public ViewParent f867b;

    /* JADX INFO: renamed from: c */
    public final View f868c;

    /* JADX INFO: renamed from: d */
    public boolean f869d;

    /* JADX INFO: renamed from: e */
    public int[] f870e;

    public C0359o(View view) {
        this.f868c = view;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m812a(float f3, float f4, boolean z3) {
        ViewParent viewParentM817f;
        if (!this.f869d || (viewParentM817f = m817f(0)) == null) {
            return false;
        }
        try {
            return AbstractC0326V.m707a(viewParentM817f, this.f868c, f3, f4, z3);
        } catch (AbstractMethodError e3) {
            Log.e("ViewParentCompat", "ViewParent " + viewParentM817f + " does not implement interface method onNestedFling", e3);
            return false;
        }
    }

    /* JADX INFO: renamed from: b */
    public final boolean m813b(float f3, float f4) {
        ViewParent viewParentM817f;
        if (!this.f869d || (viewParentM817f = m817f(0)) == null) {
            return false;
        }
        try {
            return AbstractC0326V.m708b(viewParentM817f, this.f868c, f3, f4);
        } catch (AbstractMethodError e3) {
            Log.e("ViewParentCompat", "ViewParent " + viewParentM817f + " does not implement interface method onNestedPreFling", e3);
            return false;
        }
    }

    /* JADX INFO: renamed from: c */
    public final boolean m814c(int i3, int i4, int[] iArr, int[] iArr2, int i5) {
        ViewParent viewParentM817f;
        int i6;
        int i7;
        int[] iArr3;
        if (!this.f869d || (viewParentM817f = m817f(i5)) == null) {
            return false;
        }
        if (i3 == 0 && i4 == 0) {
            if (iArr2 == null) {
                return false;
            }
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
        View view = this.f868c;
        if (iArr2 != null) {
            view.getLocationInWindow(iArr2);
            i6 = iArr2[0];
            i7 = iArr2[1];
        } else {
            i6 = 0;
            i7 = 0;
        }
        if (iArr == null) {
            if (this.f870e == null) {
                this.f870e = new int[2];
            }
            iArr3 = this.f870e;
        } else {
            iArr3 = iArr;
        }
        iArr3[0] = 0;
        iArr3[1] = 0;
        boolean z3 = viewParentM817f instanceof InterfaceC0361p;
        View view2 = this.f868c;
        if (z3) {
            ((InterfaceC0361p) viewParentM817f).mo823c(view2, i3, i4, iArr3, i5);
        } else if (i5 == 0) {
            try {
                AbstractC0326V.m709c(viewParentM817f, view2, i3, i4, iArr3);
            } catch (AbstractMethodError e3) {
                Log.e("ViewParentCompat", "ViewParent " + viewParentM817f + " does not implement interface method onNestedPreScroll", e3);
            }
        }
        if (iArr2 != null) {
            view.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i6;
            iArr2[1] = iArr2[1] - i7;
        }
        return (iArr3[0] == 0 && iArr3[1] == 0) ? false : true;
    }

    /* JADX INFO: renamed from: d */
    public final void m815d(int i3, int i4, int i5, int[] iArr) {
        m816e(0, i3, 0, i4, null, i5, iArr);
    }

    /* JADX INFO: renamed from: e */
    public final boolean m816e(int i3, int i4, int i5, int i6, int[] iArr, int i7, int[] iArr2) {
        ViewParent viewParentM817f;
        int i8;
        int i9;
        int[] iArr3;
        if (!this.f869d || (viewParentM817f = m817f(i7)) == null) {
            return false;
        }
        if (i3 == 0 && i4 == 0 && i5 == 0 && i6 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        View view = this.f868c;
        if (iArr != null) {
            view.getLocationInWindow(iArr);
            i8 = iArr[0];
            i9 = iArr[1];
        } else {
            i8 = 0;
            i9 = 0;
        }
        if (iArr2 == null) {
            if (this.f870e == null) {
                this.f870e = new int[2];
            }
            int[] iArr4 = this.f870e;
            iArr4[0] = 0;
            iArr4[1] = 0;
            iArr3 = iArr4;
        } else {
            iArr3 = iArr2;
        }
        boolean z3 = viewParentM817f instanceof InterfaceC0363q;
        View view2 = this.f868c;
        if (z3) {
            ((InterfaceC0363q) viewParentM817f).mo827d(view2, i3, i4, i5, i6, i7, iArr3);
        } else {
            iArr3[0] = iArr3[0] + i5;
            iArr3[1] = iArr3[1] + i6;
            if (viewParentM817f instanceof InterfaceC0361p) {
                ((InterfaceC0361p) viewParentM817f).mo824e(view2, i3, i4, i5, i6, i7);
            } else if (i7 == 0) {
                try {
                    AbstractC0326V.m710d(viewParentM817f, view2, i3, i4, i5, i6);
                } catch (AbstractMethodError e3) {
                    Log.e("ViewParentCompat", "ViewParent " + viewParentM817f + " does not implement interface method onNestedScroll", e3);
                }
            }
        }
        if (iArr != null) {
            view.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i8;
            iArr[1] = iArr[1] - i9;
        }
        return true;
    }

    /* JADX INFO: renamed from: f */
    public final ViewParent m817f(int i3) {
        if (i3 == 0) {
            return this.f866a;
        }
        if (i3 != 1) {
            return null;
        }
        return this.f867b;
    }

    /* JADX INFO: renamed from: g */
    public final boolean m818g(int i3) {
        return m817f(i3) != null;
    }

    /* JADX INFO: renamed from: h */
    public final boolean m819h(int i3, int i4) {
        boolean zM712f;
        if (m818g(i4)) {
            return true;
        }
        if (this.f869d) {
            View view = this.f868c;
            View view2 = view;
            for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
                boolean z3 = parent instanceof InterfaceC0361p;
                if (z3) {
                    zM712f = ((InterfaceC0361p) parent).mo825f(view2, view, i3, i4);
                } else if (i4 == 0) {
                    try {
                        zM712f = AbstractC0326V.m712f(parent, view2, view, i3);
                    } catch (AbstractMethodError e3) {
                        Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onStartNestedScroll", e3);
                        zM712f = false;
                    }
                } else {
                    zM712f = false;
                }
                if (zM712f) {
                    if (i4 == 0) {
                        this.f866a = parent;
                    } else if (i4 == 1) {
                        this.f867b = parent;
                    }
                    if (z3) {
                        ((InterfaceC0361p) parent).mo821a(view2, view, i3, i4);
                    } else if (i4 == 0) {
                        try {
                            AbstractC0326V.m711e(parent, view2, view, i3);
                        } catch (AbstractMethodError e4) {
                            Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onNestedScrollAccepted", e4);
                        }
                    }
                    return true;
                }
                if (parent instanceof View) {
                    view2 = parent;
                }
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: i */
    public final void m820i(int i3) {
        ViewParent viewParentM817f = m817f(i3);
        if (viewParentM817f != null) {
            boolean z3 = viewParentM817f instanceof InterfaceC0361p;
            View view = this.f868c;
            if (z3) {
                ((InterfaceC0361p) viewParentM817f).mo822b(view, i3);
            } else if (i3 == 0) {
                try {
                    AbstractC0326V.m713g(viewParentM817f, view);
                } catch (AbstractMethodError e3) {
                    Log.e("ViewParentCompat", "ViewParent " + viewParentM817f + " does not implement interface method onStopNestedScroll", e3);
                }
            }
            if (i3 == 0) {
                this.f866a = null;
            } else {
                if (i3 != 1) {
                    return;
                }
                this.f867b = null;
            }
        }
    }
}
