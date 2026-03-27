package p077a0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.lifecycle.C0976i;
import java.util.LinkedHashSet;
import p009C.AbstractC0139b;
import p029J.AbstractC0323S;
import p041N.AbstractC0514b;
import p041N.AbstractC0515c;
import p069X0.C0703E;
import p094f.AbstractC1343a;
import p110k.AbstractC1589g0;
import p116m.C1702c;
import p116m.C1705f;
import p119m2.AbstractC1766e;
import p125o0.AbstractC1800j;
import p166z0.C2071i;

/* JADX INFO: renamed from: a0.e */
/* JADX INFO: loaded from: classes.dex */
public final class C0846e {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f2511a;

    /* JADX INFO: renamed from: b */
    public boolean f2512b;

    /* JADX INFO: renamed from: c */
    public boolean f2513c;

    /* JADX INFO: renamed from: d */
    public boolean f2514d;

    /* JADX INFO: renamed from: e */
    public final Object f2515e;

    /* JADX INFO: renamed from: f */
    public Object f2516f;

    /* JADX INFO: renamed from: g */
    public Object f2517g;

    public /* synthetic */ C0846e(TextView textView, int i3) {
        this.f2511a = i3;
        this.f2516f = null;
        this.f2517g = null;
        this.f2512b = false;
        this.f2513c = false;
        this.f2515e = textView;
    }

    /* JADX INFO: renamed from: a */
    public C0846e m2171a(C0846e c0846e) {
        C0846e c0846e2 = (C0846e) this.f2516f;
        return c0846e2 == null ? m2179i(c0846e) : m2179i(c0846e2.m2171a(c0846e));
    }

    /* JADX INFO: renamed from: b */
    public void m2172b() {
        CompoundButton compoundButton = (CompoundButton) this.f2515e;
        Drawable drawableM1026a = AbstractC0515c.m1026a(compoundButton);
        if (drawableM1026a != null) {
            if (this.f2512b || this.f2513c) {
                Drawable drawableMutate = drawableM1026a.mutate();
                if (this.f2512b) {
                    AbstractC0139b.m280h(drawableMutate, (ColorStateList) this.f2516f);
                }
                if (this.f2513c) {
                    AbstractC0139b.m281i(drawableMutate, (PorterDuff.Mode) this.f2517g);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(compoundButton.getDrawableState());
                }
                compoundButton.setButtonDrawable(drawableMutate);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public void m2173c() {
        CheckedTextView checkedTextView = (CheckedTextView) this.f2515e;
        Drawable checkMarkDrawable = checkedTextView.getCheckMarkDrawable();
        if (checkMarkDrawable != null) {
            if (this.f2512b || this.f2513c) {
                Drawable drawableMutate = checkMarkDrawable.mutate();
                if (this.f2512b) {
                    AbstractC0139b.m280h(drawableMutate, (ColorStateList) this.f2516f);
                }
                if (this.f2513c) {
                    AbstractC0139b.m281i(drawableMutate, (PorterDuff.Mode) this.f2517g);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(checkedTextView.getDrawableState());
                }
                checkedTextView.setCheckMarkDrawable(drawableMutate);
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public Bundle m2174d(String str) {
        if (!this.f2513c) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component".toString());
        }
        Bundle bundle = (Bundle) this.f2516f;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle.getBundle(str);
        Bundle bundle3 = (Bundle) this.f2516f;
        if (bundle3 != null) {
            bundle3.remove(str);
        }
        Bundle bundle4 = (Bundle) this.f2516f;
        if (bundle4 == null || bundle4.isEmpty()) {
            this.f2516f = null;
        }
        return bundle2;
    }

    /* JADX INFO: renamed from: e */
    public void m2175e(AttributeSet attributeSet, int i3) {
        int resourceId;
        int resourceId2;
        CompoundButton compoundButton = (CompoundButton) this.f2515e;
        Context context = compoundButton.getContext();
        int[] iArr = AbstractC1343a.f4789m;
        C2071i c2071iM4591v = C2071i.m4591v(context, attributeSet, iArr, i3, 0);
        TypedArray typedArray = (TypedArray) c2071iM4591v.f7315b;
        AbstractC0323S.m700j(compoundButton, compoundButton.getContext(), iArr, attributeSet, (TypedArray) c2071iM4591v.f7315b, i3);
        try {
            if (typedArray.hasValue(1) && (resourceId2 = typedArray.getResourceId(1, 0)) != 0) {
                try {
                    compoundButton.setButtonDrawable(AbstractC1800j.m3991i(compoundButton.getContext(), resourceId2));
                } catch (Resources.NotFoundException unused) {
                    if (typedArray.hasValue(0)) {
                        compoundButton.setButtonDrawable(AbstractC1800j.m3991i(compoundButton.getContext(), resourceId));
                    }
                }
            } else if (typedArray.hasValue(0) && (resourceId = typedArray.getResourceId(0, 0)) != 0) {
                compoundButton.setButtonDrawable(AbstractC1800j.m3991i(compoundButton.getContext(), resourceId));
            }
            if (typedArray.hasValue(2)) {
                AbstractC0514b.m1024c(compoundButton, c2071iM4591v.m4600j(2));
            }
            if (typedArray.hasValue(3)) {
                AbstractC0514b.m1025d(compoundButton, AbstractC1589g0.m3652b(typedArray.getInt(3, -1), null));
            }
        } finally {
            c2071iM4591v.m4608x();
        }
    }

    /* JADX INFO: renamed from: f */
    public void m2176f(String str, InterfaceC0845d interfaceC0845d) {
        Object obj;
        AbstractC1766e.m3920e("provider", interfaceC0845d);
        C1705f c1705f = (C1705f) this.f2515e;
        C1702c c1702cMo3783a = c1705f.mo3783a(str);
        if (c1702cMo3783a != null) {
            obj = c1702cMo3783a.f5962f;
        } else {
            C1702c c1702c = new C1702c(str, interfaceC0845d);
            c1705f.f5971h++;
            C1702c c1702c2 = c1705f.f5969f;
            if (c1702c2 == null) {
                c1705f.f5968e = c1702c;
                c1705f.f5969f = c1702c;
            } else {
                c1702c2.f5963g = c1702c;
                c1702c.f5964h = c1702c2;
                c1705f.f5969f = c1702c;
            }
            obj = null;
        }
        if (((InterfaceC0845d) obj) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered".toString());
        }
    }

    /* JADX INFO: renamed from: g */
    public void m2177g() {
        if (!this.f2514d) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState".toString());
        }
        C0842a c0842a = (C0842a) this.f2517g;
        if (c0842a == null) {
            c0842a = new C0842a(this);
        }
        this.f2517g = c0842a;
        try {
            C0976i.class.getDeclaredConstructor(null);
            C0842a c0842a2 = (C0842a) this.f2517g;
            if (c0842a2 != null) {
                ((LinkedHashSet) c0842a2.f2509b).add(C0976i.class.getName());
            }
        } catch (NoSuchMethodException e3) {
            throw new IllegalArgumentException("Class " + C0976i.class.getSimpleName() + " must have default constructor in order to be automatically recreated", e3);
        }
    }

    /* JADX INFO: renamed from: h */
    public C0846e m2178h() {
        C0846e c0846e = (C0846e) this.f2516f;
        if (c0846e == null) {
            return this;
        }
        C0846e c0846eM2178h = c0846e.m2178h();
        if (((C0703E) this.f2517g) != null) {
            return ((C0703E) c0846eM2178h.f2517g) == null ? m2179i(null) : m2179i(c0846eM2178h);
        }
        if (((C0703E) c0846eM2178h.f2517g) != null) {
            return c0846eM2178h;
        }
        boolean z3 = c0846eM2178h.f2513c;
        boolean z4 = this.f2513c;
        return z4 == z3 ? m2179i(c0846eM2178h) : z4 ? m2179i(null) : c0846eM2178h;
    }

    /* JADX INFO: renamed from: i */
    public C0846e m2179i(C0846e c0846e) {
        if (c0846e == ((C0846e) this.f2516f)) {
            return this;
        }
        return new C0846e(this.f2515e, c0846e, (C0703E) this.f2517g, this.f2512b, this.f2513c, this.f2514d);
    }

    /* JADX INFO: renamed from: j */
    public C0846e m2180j() {
        C0846e c0846eM2180j;
        boolean z3 = this.f2514d;
        C0846e c0846e = (C0846e) this.f2516f;
        if (!z3) {
            return (c0846e == null || (c0846eM2180j = c0846e.m2180j()) == c0846e) ? this : m2179i(c0846eM2180j);
        }
        if (c0846e == null) {
            return null;
        }
        return c0846e.m2180j();
    }

    /* JADX INFO: renamed from: k */
    public C0846e m2181k() {
        if (((C0846e) this.f2516f) == null) {
            return this;
        }
        return new C0846e(this.f2515e, null, (C0703E) this.f2517g, this.f2512b, this.f2513c, this.f2514d);
    }

    /* JADX INFO: renamed from: l */
    public C0846e m2182l() {
        C0846e c0846e = (C0846e) this.f2516f;
        C0846e c0846eM2182l = c0846e == null ? null : c0846e.m2182l();
        return this.f2513c ? m2179i(c0846eM2182l) : c0846eM2182l;
    }

    public String toString() {
        switch (this.f2511a) {
            case 1:
                String str = this.f2515e.toString() + "[visible=" + this.f2513c + ",ignore=" + this.f2514d + ",explicitName=" + this.f2512b + "]";
                C0846e c0846e = (C0846e) this.f2516f;
                if (c0846e == null) {
                    return str;
                }
                return str + ", " + c0846e.toString();
            default:
                return super.toString();
        }
    }

    public C0846e() {
        this.f2511a = 0;
        this.f2515e = new C1705f();
        this.f2514d = true;
    }

    public C0846e(Object obj, C0846e c0846e, C0703E c0703e, boolean z3, boolean z4, boolean z5) {
        this.f2511a = 1;
        this.f2515e = obj;
        this.f2516f = c0846e;
        C0703E c0703e2 = (c0703e == null || c0703e.m1688c()) ? null : c0703e;
        this.f2517g = c0703e2;
        if (z3) {
            if (c0703e2 != null) {
                if (!(!c0703e.f1928e.isEmpty())) {
                    z3 = false;
                }
            } else {
                throw new IllegalArgumentException("Cannot pass true for 'explName' if name is null/empty");
            }
        }
        this.f2512b = z3;
        this.f2513c = z4;
        this.f2514d = z5;
    }
}
