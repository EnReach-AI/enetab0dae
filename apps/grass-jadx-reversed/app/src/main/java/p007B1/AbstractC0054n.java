package p007B1;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import io.getgrass.www.R;
import java.util.ArrayList;
import java.util.WeakHashMap;
import p005B.AbstractC0032g;
import p006B0.C0038a;
import p029J.AbstractC0308C;
import p029J.AbstractC0323S;
import p126o1.AbstractC1805a;

/* JADX INFO: renamed from: B1.n */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0054n {

    /* JADX INFO: renamed from: a */
    public static final int[] f197a = {R.attr.colorPrimary};

    /* JADX INFO: renamed from: b */
    public static final int[] f198b = {R.attr.colorPrimaryVariant};

    /* JADX INFO: renamed from: c */
    public static final C0038a f199c = new C0038a(1);

    /* JADX INFO: renamed from: a */
    public static void m211a(Context context, AttributeSet attributeSet, int i3, int i4) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC1805a.f6224A, i3, i4);
        boolean z3 = typedArrayObtainStyledAttributes.getBoolean(1, false);
        typedArrayObtainStyledAttributes.recycle();
        if (z3) {
            TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(R.attr.isMaterialTheme, typedValue, true) || (typedValue.type == 18 && typedValue.data == 0)) {
                m213c(context, f198b, "Theme.MaterialComponents");
            }
        }
        m213c(context, f197a, "Theme.AppCompat");
    }

    /* JADX INFO: renamed from: b */
    public static void m212b(Context context, AttributeSet attributeSet, int[] iArr, int i3, int i4, int... iArr2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC1805a.f6224A, i3, i4);
        boolean z3 = false;
        if (!typedArrayObtainStyledAttributes.getBoolean(2, false)) {
            typedArrayObtainStyledAttributes.recycle();
            return;
        }
        if (iArr2.length != 0) {
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr, i3, i4);
            for (int i5 : iArr2) {
                if (typedArrayObtainStyledAttributes2.getResourceId(i5, -1) == -1) {
                    typedArrayObtainStyledAttributes2.recycle();
                    break;
                }
            }
            typedArrayObtainStyledAttributes2.recycle();
            z3 = true;
        } else if (typedArrayObtainStyledAttributes.getResourceId(0, -1) != -1) {
            z3 = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!z3) {
            throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
        }
    }

    /* JADX INFO: renamed from: c */
    public static void m213c(Context context, int[] iArr, String str) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iArr);
        for (int i3 = 0; i3 < iArr.length; i3++) {
            if (!typedArrayObtainStyledAttributes.hasValue(i3)) {
                typedArrayObtainStyledAttributes.recycle();
                throw new IllegalArgumentException(AbstractC0032g.m154l("The style on this component requires your app theme to be ", str, " (or a descendant)."));
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX INFO: renamed from: d */
    public static ArrayList m214d(Toolbar toolbar, CharSequence charSequence) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < toolbar.getChildCount(); i3++) {
            View childAt = toolbar.getChildAt(i3);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (TextUtils.equals(textView.getText(), charSequence)) {
                    arrayList.add(textView);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: e */
    public static boolean m215e(View view) {
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        return AbstractC0308C.m607d(view) == 1;
    }

    /* JADX INFO: renamed from: f */
    public static TypedArray m216f(Context context, AttributeSet attributeSet, int[] iArr, int i3, int i4, int... iArr2) {
        m211a(context, attributeSet, i3, i4);
        m212b(context, attributeSet, iArr, i3, i4, iArr2);
        return context.obtainStyledAttributes(attributeSet, iArr, i3, i4);
    }

    /* JADX INFO: renamed from: g */
    public static PorterDuff.Mode m217g(int i3, PorterDuff.Mode mode) {
        if (i3 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i3 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i3 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i3) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }
}
