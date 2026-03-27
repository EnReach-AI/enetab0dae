package p040M1;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import p105i.C1437e;

/* JADX INFO: renamed from: M1.a */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0512a {

    /* JADX INFO: renamed from: a */
    public static final int[] f1188a = {R.attr.theme, io.getgrass.www.R.attr.theme};

    /* JADX INFO: renamed from: b */
    public static final int[] f1189b = {io.getgrass.www.R.attr.materialThemeOverlay};

    /* JADX INFO: renamed from: a */
    public static Context m1020a(Context context, AttributeSet attributeSet, int i3, int i4) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1189b, i3, i4);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        boolean z3 = (context instanceof C1437e) && ((C1437e) context).f5080a == resourceId;
        if (resourceId == 0 || z3) {
            return context;
        }
        C1437e c1437e = new C1437e(context, resourceId);
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, f1188a);
        int resourceId2 = typedArrayObtainStyledAttributes2.getResourceId(0, 0);
        int resourceId3 = typedArrayObtainStyledAttributes2.getResourceId(1, 0);
        typedArrayObtainStyledAttributes2.recycle();
        if (resourceId2 == 0) {
            resourceId2 = resourceId3;
        }
        if (resourceId2 != 0) {
            c1437e.getTheme().applyStyle(resourceId2, true);
        }
        return c1437e;
    }
}
