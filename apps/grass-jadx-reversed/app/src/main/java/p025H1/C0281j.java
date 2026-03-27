package p025H1;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import p033K0.AbstractC0406d;
import p039M0.AbstractC0473V;
import p126o1.AbstractC1805a;
import p144t0.C1916b;

/* JADX INFO: renamed from: H1.j */
/* JADX INFO: loaded from: classes.dex */
public final class C0281j {

    /* JADX INFO: renamed from: a */
    public AbstractC0406d f742a = new C0280i();

    /* JADX INFO: renamed from: b */
    public AbstractC0406d f743b = new C0280i();

    /* JADX INFO: renamed from: c */
    public AbstractC0406d f744c = new C0280i();

    /* JADX INFO: renamed from: d */
    public AbstractC0406d f745d = new C0280i();

    /* JADX INFO: renamed from: e */
    public InterfaceC0274c f746e = new C0272a(0.0f);

    /* JADX INFO: renamed from: f */
    public InterfaceC0274c f747f = new C0272a(0.0f);

    /* JADX INFO: renamed from: g */
    public InterfaceC0274c f748g = new C0272a(0.0f);

    /* JADX INFO: renamed from: h */
    public InterfaceC0274c f749h = new C0272a(0.0f);

    /* JADX INFO: renamed from: i */
    public C0276e f750i = new C0276e(0);

    /* JADX INFO: renamed from: j */
    public C0276e f751j = new C0276e(0);

    /* JADX INFO: renamed from: k */
    public C0276e f752k = new C0276e(0);

    /* JADX INFO: renamed from: l */
    public C0276e f753l = new C0276e(0);

    /* JADX INFO: renamed from: a */
    public static C1916b m551a(Context context, int i3, int i4, C0272a c0272a) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i3);
        if (i4 != 0) {
            contextThemeWrapper = new ContextThemeWrapper(contextThemeWrapper, i4);
        }
        TypedArray typedArrayObtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(AbstractC1805a.f6245u);
        try {
            int i5 = typedArrayObtainStyledAttributes.getInt(0, 0);
            int i6 = typedArrayObtainStyledAttributes.getInt(3, i5);
            int i7 = typedArrayObtainStyledAttributes.getInt(4, i5);
            int i8 = typedArrayObtainStyledAttributes.getInt(2, i5);
            int i9 = typedArrayObtainStyledAttributes.getInt(1, i5);
            InterfaceC0274c interfaceC0274cM553c = m553c(typedArrayObtainStyledAttributes, 5, c0272a);
            InterfaceC0274c interfaceC0274cM553c2 = m553c(typedArrayObtainStyledAttributes, 8, interfaceC0274cM553c);
            InterfaceC0274c interfaceC0274cM553c3 = m553c(typedArrayObtainStyledAttributes, 9, interfaceC0274cM553c);
            InterfaceC0274c interfaceC0274cM553c4 = m553c(typedArrayObtainStyledAttributes, 7, interfaceC0274cM553c);
            InterfaceC0274c interfaceC0274cM553c5 = m553c(typedArrayObtainStyledAttributes, 6, interfaceC0274cM553c);
            C1916b c1916b = new C1916b();
            AbstractC0406d abstractC0406dM997I = AbstractC0473V.m997I(i6);
            c1916b.f6699a = abstractC0406dM997I;
            C1916b.m4264b(abstractC0406dM997I);
            c1916b.f6703e = interfaceC0274cM553c2;
            AbstractC0406d abstractC0406dM997I2 = AbstractC0473V.m997I(i7);
            c1916b.f6700b = abstractC0406dM997I2;
            C1916b.m4264b(abstractC0406dM997I2);
            c1916b.f6704f = interfaceC0274cM553c3;
            AbstractC0406d abstractC0406dM997I3 = AbstractC0473V.m997I(i8);
            c1916b.f6701c = abstractC0406dM997I3;
            C1916b.m4264b(abstractC0406dM997I3);
            c1916b.f6705g = interfaceC0274cM553c4;
            AbstractC0406d abstractC0406dM997I4 = AbstractC0473V.m997I(i9);
            c1916b.f6702d = abstractC0406dM997I4;
            C1916b.m4264b(abstractC0406dM997I4);
            c1916b.f6706h = interfaceC0274cM553c5;
            return c1916b;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: renamed from: b */
    public static C1916b m552b(Context context, AttributeSet attributeSet, int i3, int i4) {
        C0272a c0272a = new C0272a(0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC1805a.f6239o, i3, i4);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        return m551a(context, resourceId, resourceId2, c0272a);
    }

    /* JADX INFO: renamed from: c */
    public static InterfaceC0274c m553c(TypedArray typedArray, int i3, InterfaceC0274c interfaceC0274c) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i3);
        if (typedValuePeekValue == null) {
            return interfaceC0274c;
        }
        int i4 = typedValuePeekValue.type;
        return i4 == 5 ? new C0272a(TypedValue.complexToDimensionPixelSize(typedValuePeekValue.data, typedArray.getResources().getDisplayMetrics())) : i4 == 6 ? new C0279h(typedValuePeekValue.getFraction(1.0f, 1.0f)) : interfaceC0274c;
    }

    /* JADX INFO: renamed from: d */
    public final boolean m554d(RectF rectF) {
        boolean z3 = this.f753l.getClass().equals(C0276e.class) && this.f751j.getClass().equals(C0276e.class) && this.f750i.getClass().equals(C0276e.class) && this.f752k.getClass().equals(C0276e.class);
        float fMo529a = this.f746e.mo529a(rectF);
        return z3 && ((this.f747f.mo529a(rectF) > fMo529a ? 1 : (this.f747f.mo529a(rectF) == fMo529a ? 0 : -1)) == 0 && (this.f749h.mo529a(rectF) > fMo529a ? 1 : (this.f749h.mo529a(rectF) == fMo529a ? 0 : -1)) == 0 && (this.f748g.mo529a(rectF) > fMo529a ? 1 : (this.f748g.mo529a(rectF) == fMo529a ? 0 : -1)) == 0) && ((this.f743b instanceof C0280i) && (this.f742a instanceof C0280i) && (this.f744c instanceof C0280i) && (this.f745d instanceof C0280i));
    }

    /* JADX INFO: renamed from: e */
    public final C1916b m555e() {
        C1916b c1916b = new C1916b();
        c1916b.f6699a = this.f742a;
        c1916b.f6700b = this.f743b;
        c1916b.f6701c = this.f744c;
        c1916b.f6702d = this.f745d;
        c1916b.f6703e = this.f746e;
        c1916b.f6704f = this.f747f;
        c1916b.f6705g = this.f748g;
        c1916b.f6706h = this.f749h;
        c1916b.f6707i = this.f750i;
        c1916b.f6708j = this.f751j;
        c1916b.f6709k = this.f752k;
        c1916b.f6710l = this.f753l;
        return c1916b;
    }
}
