package p147u;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Arrays;
import java.util.HashMap;
import p140s.AbstractC1869i;
import p140s.C1864d;

/* JADX INFO: renamed from: u.b */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1926b extends View {

    /* JADX INFO: renamed from: e */
    public int[] f6747e;

    /* JADX INFO: renamed from: f */
    public int f6748f;

    /* JADX INFO: renamed from: g */
    public Context f6749g;

    /* JADX INFO: renamed from: h */
    public AbstractC1869i f6750h;

    /* JADX INFO: renamed from: i */
    public String f6751i;

    /* JADX INFO: renamed from: j */
    public HashMap f6752j;

    public AbstractC1926b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6747e = new int[32];
        this.f6752j = new HashMap();
        this.f6749g = context;
        mo2289e(attributeSet);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x005b  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m4320a(java.lang.String r6) {
        /*
            r5 = this;
            if (r6 == 0) goto La7
            int r0 = r6.length()
            if (r0 != 0) goto La
            goto La7
        La:
            android.content.Context r0 = r5.f6749g
            if (r0 != 0) goto Lf
            return
        Lf:
            java.lang.String r6 = r6.trim()
            android.view.ViewParent r1 = r5.getParent()
            boolean r1 = r1 instanceof androidx.constraintlayout.widget.ConstraintLayout
            if (r1 == 0) goto L21
            android.view.ViewParent r1 = r5.getParent()
            androidx.constraintlayout.widget.ConstraintLayout r1 = (androidx.constraintlayout.widget.ConstraintLayout) r1
        L21:
            android.view.ViewParent r1 = r5.getParent()
            boolean r1 = r1 instanceof androidx.constraintlayout.widget.ConstraintLayout
            r2 = 0
            if (r1 == 0) goto L31
            android.view.ViewParent r1 = r5.getParent()
            androidx.constraintlayout.widget.ConstraintLayout r1 = (androidx.constraintlayout.widget.ConstraintLayout) r1
            goto L32
        L31:
            r1 = r2
        L32:
            boolean r3 = r5.isInEditMode()
            if (r3 == 0) goto L5b
            if (r1 == 0) goto L5b
            boolean r3 = r6 instanceof java.lang.String
            if (r3 == 0) goto L4f
            java.util.HashMap r3 = r1.f2884q
            if (r3 == 0) goto L4f
            boolean r3 = r3.containsKey(r6)
            if (r3 == 0) goto L4f
            java.util.HashMap r3 = r1.f2884q
            java.lang.Object r3 = r3.get(r6)
            goto L50
        L4f:
            r3 = r2
        L50:
            boolean r4 = r3 instanceof java.lang.Integer
            if (r4 == 0) goto L5b
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            goto L5c
        L5b:
            r3 = 0
        L5c:
            if (r3 != 0) goto L64
            if (r1 == 0) goto L64
            int r3 = r5.m4323d(r1, r6)
        L64:
            if (r3 != 0) goto L70
            java.lang.Class<u.o> r1 = p147u.AbstractC1939o.class
            java.lang.reflect.Field r1 = r1.getField(r6)     // Catch: java.lang.Exception -> L70
            int r3 = r1.getInt(r2)     // Catch: java.lang.Exception -> L70
        L70:
            if (r3 != 0) goto L80
            android.content.res.Resources r1 = r0.getResources()
            java.lang.String r2 = "id"
            java.lang.String r0 = r0.getPackageName()
            int r3 = r1.getIdentifier(r6, r2, r0)
        L80:
            if (r3 == 0) goto L8f
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)
            java.util.HashMap r1 = r5.f6752j
            r1.put(r0, r6)
            r5.m4321b(r3)
            goto La7
        L8f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Could not find id of \""
            r0.<init>(r1)
            r0.append(r6)
            java.lang.String r6 = "\""
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            java.lang.String r0 = "ConstraintHelper"
            android.util.Log.w(r0, r6)
        La7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p147u.AbstractC1926b.m4320a(java.lang.String):void");
    }

    /* JADX INFO: renamed from: b */
    public final void m4321b(int i3) {
        if (i3 == getId()) {
            return;
        }
        int i4 = this.f6748f + 1;
        int[] iArr = this.f6747e;
        if (i4 > iArr.length) {
            this.f6747e = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f6747e;
        int i5 = this.f6748f;
        iArr2[i5] = i3;
        this.f6748f = i5 + 1;
    }

    /* JADX INFO: renamed from: c */
    public final void m4322c() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ConstraintLayout)) {
            return;
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) parent;
        int visibility = getVisibility();
        float elevation = getElevation();
        for (int i3 = 0; i3 < this.f6748f; i3++) {
            View view = (View) constraintLayout.f2872e.get(this.f6747e[i3]);
            if (view != null) {
                view.setVisibility(visibility);
                if (elevation > 0.0f) {
                    view.setTranslationZ(view.getTranslationZ() + elevation);
                }
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public final int m4323d(ConstraintLayout constraintLayout, String str) {
        Resources resources;
        String resourceEntryName;
        if (str == null || constraintLayout == null || (resources = this.f6749g.getResources()) == null) {
            return 0;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = constraintLayout.getChildAt(i3);
            if (childAt.getId() != -1) {
                try {
                    resourceEntryName = resources.getResourceEntryName(childAt.getId());
                } catch (Resources.NotFoundException unused) {
                    resourceEntryName = null;
                }
                if (str.equals(resourceEntryName)) {
                    return childAt.getId();
                }
            }
        }
        return 0;
    }

    /* JADX INFO: renamed from: e */
    public void mo2289e(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, AbstractC1940p.f6925b);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i3);
                if (index == 19) {
                    String string = typedArrayObtainStyledAttributes.getString(index);
                    this.f6751i = string;
                    setIds(string);
                }
            }
        }
    }

    /* JADX INFO: renamed from: f */
    public abstract void mo2290f(C1864d c1864d, boolean z3);

    /* JADX INFO: renamed from: g */
    public final void m4324g() {
        if (this.f6750h == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof C1928d) {
            ((C1928d) layoutParams).f6801k0 = this.f6750h;
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f6747e, this.f6748f);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.f6751i;
        if (str != null) {
            setIds(str);
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public void onMeasure(int i3, int i4) {
        setMeasuredDimension(0, 0);
    }

    public void setIds(String str) {
        this.f6751i = str;
        if (str == null) {
            return;
        }
        int i3 = 0;
        this.f6748f = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i3);
            if (iIndexOf == -1) {
                m4320a(str.substring(i3));
                return;
            } else {
                m4320a(str.substring(i3, iIndexOf));
                i3 = iIndexOf + 1;
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f6751i = null;
        this.f6748f = 0;
        for (int i3 : iArr) {
            m4321b(i3);
        }
    }
}
