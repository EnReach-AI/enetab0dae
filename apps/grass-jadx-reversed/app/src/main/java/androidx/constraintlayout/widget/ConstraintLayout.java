package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import java.util.ArrayList;
import java.util.HashMap;
import p001A.C0009j;
import p136r.C1846e;
import p140s.C1864d;
import p140s.C1865e;
import p140s.C1868h;
import p147u.AbstractC1926b;
import p147u.AbstractC1927c;
import p147u.AbstractC1937m;
import p147u.AbstractC1940p;
import p147u.C1928d;
import p147u.C1929e;
import p147u.C1936l;
import p147u.C1938n;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {

    /* JADX INFO: renamed from: e */
    public final SparseArray f2872e;

    /* JADX INFO: renamed from: f */
    public final ArrayList f2873f;

    /* JADX INFO: renamed from: g */
    public final C1865e f2874g;

    /* JADX INFO: renamed from: h */
    public int f2875h;

    /* JADX INFO: renamed from: i */
    public int f2876i;

    /* JADX INFO: renamed from: j */
    public int f2877j;

    /* JADX INFO: renamed from: k */
    public int f2878k;

    /* JADX INFO: renamed from: l */
    public boolean f2879l;

    /* JADX INFO: renamed from: m */
    public int f2880m;

    /* JADX INFO: renamed from: n */
    public C1936l f2881n;

    /* JADX INFO: renamed from: o */
    public C0009j f2882o;

    /* JADX INFO: renamed from: p */
    public int f2883p;

    /* JADX INFO: renamed from: q */
    public HashMap f2884q;

    /* JADX INFO: renamed from: r */
    public final SparseArray f2885r;

    /* JADX INFO: renamed from: s */
    public final C1929e f2886s;

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2872e = new SparseArray();
        this.f2873f = new ArrayList(4);
        this.f2874g = new C1865e();
        this.f2875h = 0;
        this.f2876i = 0;
        this.f2877j = Integer.MAX_VALUE;
        this.f2878k = Integer.MAX_VALUE;
        this.f2879l = true;
        this.f2880m = 263;
        this.f2881n = null;
        this.f2882o = null;
        this.f2883p = -1;
        this.f2884q = new HashMap();
        this.f2885r = new SparseArray();
        this.f2886s = new C1929e(this);
        m2294c(attributeSet, 0);
    }

    /* JADX INFO: renamed from: a */
    public static C1928d m2292a() {
        C1928d c1928d = new C1928d(-2, -2);
        c1928d.f6780a = -1;
        c1928d.f6782b = -1;
        c1928d.f6784c = -1.0f;
        c1928d.f6786d = -1;
        c1928d.f6788e = -1;
        c1928d.f6790f = -1;
        c1928d.f6792g = -1;
        c1928d.f6794h = -1;
        c1928d.f6796i = -1;
        c1928d.f6798j = -1;
        c1928d.f6800k = -1;
        c1928d.f6802l = -1;
        c1928d.f6803m = -1;
        c1928d.f6804n = 0;
        c1928d.f6805o = 0.0f;
        c1928d.f6806p = -1;
        c1928d.f6807q = -1;
        c1928d.f6808r = -1;
        c1928d.f6809s = -1;
        c1928d.f6810t = -1;
        c1928d.f6811u = -1;
        c1928d.f6812v = -1;
        c1928d.f6813w = -1;
        c1928d.f6814x = -1;
        c1928d.f6815y = -1;
        c1928d.f6816z = 0.5f;
        c1928d.f6754A = 0.5f;
        c1928d.f6755B = null;
        c1928d.f6756C = 1;
        c1928d.f6757D = -1.0f;
        c1928d.f6758E = -1.0f;
        c1928d.f6759F = 0;
        c1928d.f6760G = 0;
        c1928d.f6761H = 0;
        c1928d.f6762I = 0;
        c1928d.f6763J = 0;
        c1928d.f6764K = 0;
        c1928d.f6765L = 0;
        c1928d.f6766M = 0;
        c1928d.f6767N = 1.0f;
        c1928d.f6768O = 1.0f;
        c1928d.f6769P = -1;
        c1928d.f6770Q = -1;
        c1928d.f6771R = -1;
        c1928d.f6772S = false;
        c1928d.f6773T = false;
        c1928d.f6774U = null;
        c1928d.f6775V = true;
        c1928d.f6776W = true;
        c1928d.f6777X = false;
        c1928d.f6778Y = false;
        c1928d.f6779Z = false;
        c1928d.f6781a0 = -1;
        c1928d.f6783b0 = -1;
        c1928d.f6785c0 = -1;
        c1928d.f6787d0 = -1;
        c1928d.f6789e0 = -1;
        c1928d.f6791f0 = -1;
        c1928d.f6793g0 = 0.5f;
        c1928d.f6801k0 = new C1864d();
        return c1928d;
    }

    private int getPaddingWidth() {
        int iMax = Math.max(0, getPaddingRight()) + Math.max(0, getPaddingLeft());
        int iMax2 = Math.max(0, getPaddingEnd()) + Math.max(0, getPaddingStart());
        return iMax2 > 0 ? iMax2 : iMax;
    }

    /* JADX INFO: renamed from: b */
    public final C1864d m2293b(View view) {
        if (view == this) {
            return this.f2874g;
        }
        if (view == null) {
            return null;
        }
        return ((C1928d) view.getLayoutParams()).f6801k0;
    }

    /* JADX INFO: renamed from: c */
    public final void m2294c(AttributeSet attributeSet, int i3) {
        C1865e c1865e = this.f2874g;
        c1865e.f6482U = this;
        C1929e c1929e = this.f2886s;
        c1865e.f6520g0 = c1929e;
        c1865e.f6519f0.f6665f = c1929e;
        this.f2872e.put(getId(), this);
        this.f2881n = null;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, AbstractC1940p.f6925b, i3, 0);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i4 = 0; i4 < indexCount; i4++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i4);
                if (index == 9) {
                    this.f2875h = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f2875h);
                } else if (index == 10) {
                    this.f2876i = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f2876i);
                } else if (index == 7) {
                    this.f2877j = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f2877j);
                } else if (index == 8) {
                    this.f2878k = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f2878k);
                } else if (index == 89) {
                    this.f2880m = typedArrayObtainStyledAttributes.getInt(index, this.f2880m);
                } else if (index == 38) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            m2295d(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.f2882o = null;
                        }
                    }
                } else if (index == 18) {
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    try {
                        C1936l c1936l = new C1936l();
                        this.f2881n = c1936l;
                        c1936l.m4337e(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.f2881n = null;
                    }
                    this.f2883p = resourceId2;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        int i5 = this.f2880m;
        c1865e.f6529p0 = i5;
        C1846e.f6377p = (i5 & 256) == 256;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C1928d;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0077  */
    /* JADX INFO: renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m2295d(int r10) {
        /*
            Method dump skipped, instruction units count: 228
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.m2295d(int):void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList arrayList = this.f2873f;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i3 = 0; i3 < size; i3++) {
                ((AbstractC1926b) arrayList.get(i3)).getClass();
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = getWidth();
            float height = getHeight();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] strArrSplit = ((String) tag).split(",");
                    if (strArrSplit.length == 4) {
                        int i5 = Integer.parseInt(strArrSplit[0]);
                        int i6 = Integer.parseInt(strArrSplit[1]);
                        int i7 = Integer.parseInt(strArrSplit[2]);
                        int i8 = (int) ((i5 / 1080.0f) * width);
                        int i9 = (int) ((i6 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f3 = i8;
                        float f4 = i9;
                        float f5 = i8 + ((int) ((i7 / 1080.0f) * width));
                        canvas.drawLine(f3, f4, f5, f4, paint);
                        float f6 = i9 + ((int) ((Integer.parseInt(strArrSplit[3]) / 1920.0f) * height));
                        canvas.drawLine(f5, f4, f5, f6, paint);
                        canvas.drawLine(f5, f6, f3, f6, paint);
                        canvas.drawLine(f3, f6, f3, f4, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f3, f4, f5, f6, paint);
                        canvas.drawLine(f3, f6, f5, f4, paint);
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:162:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0335  */
    /* JADX INFO: renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m2296e(p140s.C1865e r26, int r27, int r28, int r29) {
        /*
            Method dump skipped, instruction units count: 1684
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.m2296e(s.e, int, int, int):void");
    }

    @Override // android.view.View
    public final void forceLayout() {
        this.f2879l = true;
        super.forceLayout();
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return m2292a();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        int i3;
        Context context = getContext();
        C1928d c1928d = new C1928d(context, attributeSet);
        c1928d.f6780a = -1;
        c1928d.f6782b = -1;
        c1928d.f6784c = -1.0f;
        c1928d.f6786d = -1;
        c1928d.f6788e = -1;
        c1928d.f6790f = -1;
        c1928d.f6792g = -1;
        c1928d.f6794h = -1;
        c1928d.f6796i = -1;
        c1928d.f6798j = -1;
        c1928d.f6800k = -1;
        c1928d.f6802l = -1;
        c1928d.f6803m = -1;
        c1928d.f6804n = 0;
        c1928d.f6805o = 0.0f;
        c1928d.f6806p = -1;
        c1928d.f6807q = -1;
        c1928d.f6808r = -1;
        c1928d.f6809s = -1;
        c1928d.f6810t = -1;
        c1928d.f6811u = -1;
        c1928d.f6812v = -1;
        c1928d.f6813w = -1;
        c1928d.f6814x = -1;
        c1928d.f6815y = -1;
        c1928d.f6816z = 0.5f;
        c1928d.f6754A = 0.5f;
        c1928d.f6755B = null;
        c1928d.f6756C = 1;
        c1928d.f6757D = -1.0f;
        c1928d.f6758E = -1.0f;
        c1928d.f6759F = 0;
        c1928d.f6760G = 0;
        c1928d.f6761H = 0;
        c1928d.f6762I = 0;
        c1928d.f6763J = 0;
        c1928d.f6764K = 0;
        c1928d.f6765L = 0;
        c1928d.f6766M = 0;
        c1928d.f6767N = 1.0f;
        c1928d.f6768O = 1.0f;
        c1928d.f6769P = -1;
        c1928d.f6770Q = -1;
        c1928d.f6771R = -1;
        c1928d.f6772S = false;
        c1928d.f6773T = false;
        c1928d.f6774U = null;
        c1928d.f6775V = true;
        c1928d.f6776W = true;
        c1928d.f6777X = false;
        c1928d.f6778Y = false;
        c1928d.f6779Z = false;
        c1928d.f6781a0 = -1;
        c1928d.f6783b0 = -1;
        c1928d.f6785c0 = -1;
        c1928d.f6787d0 = -1;
        c1928d.f6789e0 = -1;
        c1928d.f6791f0 = -1;
        c1928d.f6793g0 = 0.5f;
        c1928d.f6801k0 = new C1864d();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC1940p.f6925b);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i4 = 0; i4 < indexCount; i4++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i4);
            int i5 = AbstractC1927c.f6753a.get(index);
            switch (i5) {
                case 1:
                    c1928d.f6771R = typedArrayObtainStyledAttributes.getInt(index, c1928d.f6771R);
                    break;
                case 2:
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, c1928d.f6803m);
                    c1928d.f6803m = resourceId;
                    if (resourceId == -1) {
                        c1928d.f6803m = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case FromStringDeserializer.Std.STD_URI /* 3 */:
                    c1928d.f6804n = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c1928d.f6804n);
                    break;
                case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                    float f3 = typedArrayObtainStyledAttributes.getFloat(index, c1928d.f6805o) % 360.0f;
                    c1928d.f6805o = f3;
                    if (f3 < 0.0f) {
                        c1928d.f6805o = (360.0f - f3) % 360.0f;
                    }
                    break;
                case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                    c1928d.f6780a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, c1928d.f6780a);
                    break;
                case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                    c1928d.f6782b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, c1928d.f6782b);
                    break;
                case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
                    c1928d.f6784c = typedArrayObtainStyledAttributes.getFloat(index, c1928d.f6784c);
                    break;
                case FromStringDeserializer.Std.STD_LOCALE /* 8 */:
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, c1928d.f6786d);
                    c1928d.f6786d = resourceId2;
                    if (resourceId2 == -1) {
                        c1928d.f6786d = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case FromStringDeserializer.Std.STD_CHARSET /* 9 */:
                    int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(index, c1928d.f6788e);
                    c1928d.f6788e = resourceId3;
                    if (resourceId3 == -1) {
                        c1928d.f6788e = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case FromStringDeserializer.Std.STD_TIME_ZONE /* 10 */:
                    int resourceId4 = typedArrayObtainStyledAttributes.getResourceId(index, c1928d.f6790f);
                    c1928d.f6790f = resourceId4;
                    if (resourceId4 == -1) {
                        c1928d.f6790f = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case FromStringDeserializer.Std.STD_INET_ADDRESS /* 11 */:
                    int resourceId5 = typedArrayObtainStyledAttributes.getResourceId(index, c1928d.f6792g);
                    c1928d.f6792g = resourceId5;
                    if (resourceId5 == -1) {
                        c1928d.f6792g = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case FromStringDeserializer.Std.STD_INET_SOCKET_ADDRESS /* 12 */:
                    int resourceId6 = typedArrayObtainStyledAttributes.getResourceId(index, c1928d.f6794h);
                    c1928d.f6794h = resourceId6;
                    if (resourceId6 == -1) {
                        c1928d.f6794h = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 13:
                    int resourceId7 = typedArrayObtainStyledAttributes.getResourceId(index, c1928d.f6796i);
                    c1928d.f6796i = resourceId7;
                    if (resourceId7 == -1) {
                        c1928d.f6796i = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 14:
                    int resourceId8 = typedArrayObtainStyledAttributes.getResourceId(index, c1928d.f6798j);
                    c1928d.f6798j = resourceId8;
                    if (resourceId8 == -1) {
                        c1928d.f6798j = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 15:
                    int resourceId9 = typedArrayObtainStyledAttributes.getResourceId(index, c1928d.f6800k);
                    c1928d.f6800k = resourceId9;
                    if (resourceId9 == -1) {
                        c1928d.f6800k = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 16:
                    int resourceId10 = typedArrayObtainStyledAttributes.getResourceId(index, c1928d.f6802l);
                    c1928d.f6802l = resourceId10;
                    if (resourceId10 == -1) {
                        c1928d.f6802l = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 17:
                    int resourceId11 = typedArrayObtainStyledAttributes.getResourceId(index, c1928d.f6806p);
                    c1928d.f6806p = resourceId11;
                    if (resourceId11 == -1) {
                        c1928d.f6806p = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 18:
                    int resourceId12 = typedArrayObtainStyledAttributes.getResourceId(index, c1928d.f6807q);
                    c1928d.f6807q = resourceId12;
                    if (resourceId12 == -1) {
                        c1928d.f6807q = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 19:
                    int resourceId13 = typedArrayObtainStyledAttributes.getResourceId(index, c1928d.f6808r);
                    c1928d.f6808r = resourceId13;
                    if (resourceId13 == -1) {
                        c1928d.f6808r = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 20:
                    int resourceId14 = typedArrayObtainStyledAttributes.getResourceId(index, c1928d.f6809s);
                    c1928d.f6809s = resourceId14;
                    if (resourceId14 == -1) {
                        c1928d.f6809s = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 21:
                    c1928d.f6810t = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c1928d.f6810t);
                    break;
                case 22:
                    c1928d.f6811u = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c1928d.f6811u);
                    break;
                case 23:
                    c1928d.f6812v = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c1928d.f6812v);
                    break;
                case 24:
                    c1928d.f6813w = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c1928d.f6813w);
                    break;
                case 25:
                    c1928d.f6814x = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c1928d.f6814x);
                    break;
                case 26:
                    c1928d.f6815y = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c1928d.f6815y);
                    break;
                case 27:
                    c1928d.f6772S = typedArrayObtainStyledAttributes.getBoolean(index, c1928d.f6772S);
                    break;
                case 28:
                    c1928d.f6773T = typedArrayObtainStyledAttributes.getBoolean(index, c1928d.f6773T);
                    break;
                case 29:
                    c1928d.f6816z = typedArrayObtainStyledAttributes.getFloat(index, c1928d.f6816z);
                    break;
                case 30:
                    c1928d.f6754A = typedArrayObtainStyledAttributes.getFloat(index, c1928d.f6754A);
                    break;
                case 31:
                    int i6 = typedArrayObtainStyledAttributes.getInt(index, 0);
                    c1928d.f6761H = i6;
                    if (i6 == 1) {
                        Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                    }
                    break;
                case 32:
                    int i7 = typedArrayObtainStyledAttributes.getInt(index, 0);
                    c1928d.f6762I = i7;
                    if (i7 == 1) {
                        Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                    }
                    break;
                case 33:
                    try {
                        c1928d.f6763J = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c1928d.f6763J);
                    } catch (Exception unused) {
                        if (typedArrayObtainStyledAttributes.getInt(index, c1928d.f6763J) == -2) {
                            c1928d.f6763J = -2;
                        }
                    }
                    break;
                case 34:
                    try {
                        c1928d.f6765L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c1928d.f6765L);
                    } catch (Exception unused2) {
                        if (typedArrayObtainStyledAttributes.getInt(index, c1928d.f6765L) == -2) {
                            c1928d.f6765L = -2;
                        }
                    }
                    break;
                case 35:
                    c1928d.f6767N = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, c1928d.f6767N));
                    c1928d.f6761H = 2;
                    break;
                case 36:
                    try {
                        c1928d.f6764K = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c1928d.f6764K);
                    } catch (Exception unused3) {
                        if (typedArrayObtainStyledAttributes.getInt(index, c1928d.f6764K) == -2) {
                            c1928d.f6764K = -2;
                        }
                    }
                    break;
                case 37:
                    try {
                        c1928d.f6766M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c1928d.f6766M);
                    } catch (Exception unused4) {
                        if (typedArrayObtainStyledAttributes.getInt(index, c1928d.f6766M) == -2) {
                            c1928d.f6766M = -2;
                        }
                    }
                    break;
                case 38:
                    c1928d.f6768O = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, c1928d.f6768O));
                    c1928d.f6762I = 2;
                    break;
                default:
                    switch (i5) {
                        case 44:
                            String string = typedArrayObtainStyledAttributes.getString(index);
                            c1928d.f6755B = string;
                            c1928d.f6756C = -1;
                            if (string != null) {
                                int length = string.length();
                                int iIndexOf = c1928d.f6755B.indexOf(44);
                                if (iIndexOf <= 0 || iIndexOf >= length - 1) {
                                    i3 = 0;
                                } else {
                                    String strSubstring = c1928d.f6755B.substring(0, iIndexOf);
                                    if (strSubstring.equalsIgnoreCase("W")) {
                                        c1928d.f6756C = 0;
                                    } else if (strSubstring.equalsIgnoreCase("H")) {
                                        c1928d.f6756C = 1;
                                    }
                                    i3 = iIndexOf + 1;
                                }
                                int iIndexOf2 = c1928d.f6755B.indexOf(58);
                                if (iIndexOf2 < 0 || iIndexOf2 >= length - 1) {
                                    String strSubstring2 = c1928d.f6755B.substring(i3);
                                    if (strSubstring2.length() > 0) {
                                        Float.parseFloat(strSubstring2);
                                    }
                                } else {
                                    String strSubstring3 = c1928d.f6755B.substring(i3, iIndexOf2);
                                    String strSubstring4 = c1928d.f6755B.substring(iIndexOf2 + 1);
                                    if (strSubstring3.length() > 0 && strSubstring4.length() > 0) {
                                        try {
                                            float f4 = Float.parseFloat(strSubstring3);
                                            float f5 = Float.parseFloat(strSubstring4);
                                            if (f4 > 0.0f && f5 > 0.0f) {
                                                if (c1928d.f6756C == 1) {
                                                    Math.abs(f5 / f4);
                                                } else {
                                                    Math.abs(f4 / f5);
                                                }
                                            }
                                        } catch (NumberFormatException unused5) {
                                        }
                                    }
                                }
                            }
                            break;
                        case 45:
                            c1928d.f6757D = typedArrayObtainStyledAttributes.getFloat(index, c1928d.f6757D);
                            break;
                        case 46:
                            c1928d.f6758E = typedArrayObtainStyledAttributes.getFloat(index, c1928d.f6758E);
                            break;
                        case 47:
                            c1928d.f6759F = typedArrayObtainStyledAttributes.getInt(index, 0);
                            break;
                        case 48:
                            c1928d.f6760G = typedArrayObtainStyledAttributes.getInt(index, 0);
                            break;
                        case 49:
                            c1928d.f6769P = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, c1928d.f6769P);
                            break;
                        case 50:
                            c1928d.f6770Q = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, c1928d.f6770Q);
                            break;
                        case 51:
                            c1928d.f6774U = typedArrayObtainStyledAttributes.getString(index);
                            break;
                    }
                    break;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        c1928d.m4325a();
        return c1928d;
    }

    public int getMaxHeight() {
        return this.f2878k;
    }

    public int getMaxWidth() {
        return this.f2877j;
    }

    public int getMinHeight() {
        return this.f2876i;
    }

    public int getMinWidth() {
        return this.f2875h;
    }

    public int getOptimizationLevel() {
        return this.f2874g.f6529p0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        int childCount = getChildCount();
        boolean zIsInEditMode = isInEditMode();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            C1928d c1928d = (C1928d) childAt.getLayoutParams();
            C1864d c1864d = c1928d.f6801k0;
            if (childAt.getVisibility() != 8 || c1928d.f6778Y || c1928d.f6779Z || zIsInEditMode) {
                int iM4157m = c1864d.m4157m();
                int iM4158n = c1864d.m4158n();
                childAt.layout(iM4157m, iM4158n, c1864d.m4156l() + iM4157m, c1864d.m4153i() + iM4158n);
            }
        }
        ArrayList arrayList = this.f2873f;
        int size = arrayList.size();
        if (size > 0) {
            for (int i8 = 0; i8 < size; i8++) {
                ((AbstractC1926b) arrayList.get(i8)).getClass();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:150:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0365  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x03f7  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x03ff  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x052c  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0532  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01a7  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r26, int r27) {
        /*
            Method dump skipped, instruction units count: 1577
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup
    public final void onViewAdded(View view) {
        super.onViewAdded(view);
        C1864d c1864dM2293b = m2293b(view);
        if ((view instanceof C1938n) && !(c1864dM2293b instanceof C1868h)) {
            C1928d c1928d = (C1928d) view.getLayoutParams();
            C1868h c1868h = new C1868h();
            c1928d.f6801k0 = c1868h;
            c1928d.f6778Y = true;
            c1868h.m4185B(c1928d.f6771R);
        }
        if (view instanceof AbstractC1926b) {
            AbstractC1926b abstractC1926b = (AbstractC1926b) view;
            abstractC1926b.m4324g();
            ((C1928d) view.getLayoutParams()).f6779Z = true;
            ArrayList arrayList = this.f2873f;
            if (!arrayList.contains(abstractC1926b)) {
                arrayList.add(abstractC1926b);
            }
        }
        this.f2872e.put(view.getId(), view);
        this.f2879l = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.f2872e.remove(view.getId());
        C1864d c1864dM2293b = m2293b(view);
        this.f2874g.f6517d0.remove(c1864dM2293b);
        c1864dM2293b.f6470I = null;
        this.f2873f.remove(view);
        this.f2879l = true;
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        this.f2879l = true;
        super.requestLayout();
    }

    public void setConstraintSet(C1936l c1936l) {
        this.f2881n = c1936l;
    }

    @Override // android.view.View
    public void setId(int i3) {
        int id = getId();
        SparseArray sparseArray = this.f2872e;
        sparseArray.remove(id);
        super.setId(i3);
        sparseArray.put(getId(), this);
    }

    public void setMaxHeight(int i3) {
        if (i3 == this.f2878k) {
            return;
        }
        this.f2878k = i3;
        requestLayout();
    }

    public void setMaxWidth(int i3) {
        if (i3 == this.f2877j) {
            return;
        }
        this.f2877j = i3;
        requestLayout();
    }

    public void setMinHeight(int i3) {
        if (i3 == this.f2876i) {
            return;
        }
        this.f2876i = i3;
        requestLayout();
    }

    public void setMinWidth(int i3) {
        if (i3 == this.f2875h) {
            return;
        }
        this.f2875h = i3;
        requestLayout();
    }

    public void setOnConstraintsChanged(AbstractC1937m abstractC1937m) {
        C0009j c0009j = this.f2882o;
        if (c0009j != null) {
            c0009j.getClass();
        }
    }

    public void setOptimizationLevel(int i3) {
        this.f2880m = i3;
        this.f2874g.f6529p0 = i3;
        C1846e.f6377p = (i3 & 256) == 256;
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f2872e = new SparseArray();
        this.f2873f = new ArrayList(4);
        this.f2874g = new C1865e();
        this.f2875h = 0;
        this.f2876i = 0;
        this.f2877j = Integer.MAX_VALUE;
        this.f2878k = Integer.MAX_VALUE;
        this.f2879l = true;
        this.f2880m = 263;
        this.f2881n = null;
        this.f2882o = null;
        this.f2883p = -1;
        this.f2884q = new HashMap();
        this.f2885r = new SparseArray();
        this.f2886s = new C1929e(this);
        m2294c(attributeSet, i3);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        C1928d c1928d = new C1928d(layoutParams);
        c1928d.f6780a = -1;
        c1928d.f6782b = -1;
        c1928d.f6784c = -1.0f;
        c1928d.f6786d = -1;
        c1928d.f6788e = -1;
        c1928d.f6790f = -1;
        c1928d.f6792g = -1;
        c1928d.f6794h = -1;
        c1928d.f6796i = -1;
        c1928d.f6798j = -1;
        c1928d.f6800k = -1;
        c1928d.f6802l = -1;
        c1928d.f6803m = -1;
        c1928d.f6804n = 0;
        c1928d.f6805o = 0.0f;
        c1928d.f6806p = -1;
        c1928d.f6807q = -1;
        c1928d.f6808r = -1;
        c1928d.f6809s = -1;
        c1928d.f6810t = -1;
        c1928d.f6811u = -1;
        c1928d.f6812v = -1;
        c1928d.f6813w = -1;
        c1928d.f6814x = -1;
        c1928d.f6815y = -1;
        c1928d.f6816z = 0.5f;
        c1928d.f6754A = 0.5f;
        c1928d.f6755B = null;
        c1928d.f6756C = 1;
        c1928d.f6757D = -1.0f;
        c1928d.f6758E = -1.0f;
        c1928d.f6759F = 0;
        c1928d.f6760G = 0;
        c1928d.f6761H = 0;
        c1928d.f6762I = 0;
        c1928d.f6763J = 0;
        c1928d.f6764K = 0;
        c1928d.f6765L = 0;
        c1928d.f6766M = 0;
        c1928d.f6767N = 1.0f;
        c1928d.f6768O = 1.0f;
        c1928d.f6769P = -1;
        c1928d.f6770Q = -1;
        c1928d.f6771R = -1;
        c1928d.f6772S = false;
        c1928d.f6773T = false;
        c1928d.f6774U = null;
        c1928d.f6775V = true;
        c1928d.f6776W = true;
        c1928d.f6777X = false;
        c1928d.f6778Y = false;
        c1928d.f6779Z = false;
        c1928d.f6781a0 = -1;
        c1928d.f6783b0 = -1;
        c1928d.f6785c0 = -1;
        c1928d.f6787d0 = -1;
        c1928d.f6789e0 = -1;
        c1928d.f6791f0 = -1;
        c1928d.f6793g0 = 0.5f;
        c1928d.f6801k0 = new C1864d();
        return c1928d;
    }
}
