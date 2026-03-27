package p098g;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import java.lang.reflect.Constructor;
import p110k.C1564X;
import p110k.C1603m;
import p110k.C1607o;
import p110k.C1609p;
import p110k.C1629z;
import p128p.C1817k;

/* JADX INFO: renamed from: g.x */
/* JADX INFO: loaded from: classes.dex */
public class C1385x {

    /* JADX INFO: renamed from: b */
    public static final Class[] f5007b = {Context.class, AttributeSet.class};

    /* JADX INFO: renamed from: c */
    public static final int[] f5008c = {R.attr.onClick};

    /* JADX INFO: renamed from: d */
    public static final int[] f5009d = {R.attr.accessibilityHeading};

    /* JADX INFO: renamed from: e */
    public static final int[] f5010e = {R.attr.accessibilityPaneTitle};

    /* JADX INFO: renamed from: f */
    public static final int[] f5011f = {R.attr.screenReaderFocusable};

    /* JADX INFO: renamed from: g */
    public static final String[] f5012g = {"android.widget.", "android.view.", "android.webkit."};

    /* JADX INFO: renamed from: h */
    public static final C1817k f5013h = new C1817k();

    /* JADX INFO: renamed from: a */
    public final Object[] f5014a = new Object[2];

    /* JADX INFO: renamed from: a */
    public C1603m mo3221a(Context context, AttributeSet attributeSet) {
        return new C1603m(context, attributeSet);
    }

    /* JADX INFO: renamed from: b */
    public C1607o mo3222b(Context context, AttributeSet attributeSet) {
        return new C1607o(context, attributeSet, io.getgrass.www.R.attr.buttonStyle);
    }

    /* JADX INFO: renamed from: c */
    public C1609p mo3223c(Context context, AttributeSet attributeSet) {
        return new C1609p(context, attributeSet, io.getgrass.www.R.attr.checkboxStyle);
    }

    /* JADX INFO: renamed from: d */
    public C1629z mo3224d(Context context, AttributeSet attributeSet) {
        return new C1629z(context, attributeSet);
    }

    /* JADX INFO: renamed from: e */
    public C1564X mo3225e(Context context, AttributeSet attributeSet) {
        return new C1564X(context, attributeSet);
    }

    /* JADX INFO: renamed from: f */
    public final View m3391f(Context context, String str, String str2) {
        String strConcat;
        C1817k c1817k = f5013h;
        Constructor constructor = (Constructor) c1817k.getOrDefault(str, null);
        if (constructor == null) {
            if (str2 != null) {
                try {
                    strConcat = str2.concat(str);
                } catch (Exception unused) {
                    return null;
                }
            } else {
                strConcat = str;
            }
            constructor = Class.forName(strConcat, false, context.getClassLoader()).asSubclass(View.class).getConstructor(f5007b);
            c1817k.put(str, constructor);
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.f5014a);
    }
}
