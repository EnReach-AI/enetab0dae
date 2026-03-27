package p003A1;

import android.content.Context;
import android.util.TypedValue;
import io.getgrass.www.R;
import p144t0.AbstractC1919e;
import p165z.AbstractC2048d;

/* JADX INFO: renamed from: A1.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0023a {

    /* JADX INFO: renamed from: f */
    public static final int f73f = (int) Math.round(5.1000000000000005d);

    /* JADX INFO: renamed from: a */
    public final boolean f74a;

    /* JADX INFO: renamed from: b */
    public final int f75b;

    /* JADX INFO: renamed from: c */
    public final int f76c;

    /* JADX INFO: renamed from: d */
    public final int f77d;

    /* JADX INFO: renamed from: e */
    public final float f78e;

    public C0023a(Context context) {
        int iM4520a;
        int iM4520a2;
        int iM4520a3 = 0;
        boolean zM4297r = AbstractC1919e.m4297r(context, R.attr.elevationOverlayEnabled, false);
        TypedValue typedValueM4296q = AbstractC1919e.m4296q(context, R.attr.elevationOverlayColor);
        if (typedValueM4296q != null) {
            int i3 = typedValueM4296q.resourceId;
            iM4520a = i3 != 0 ? AbstractC2048d.m4520a(context, i3) : typedValueM4296q.data;
        } else {
            iM4520a = 0;
        }
        TypedValue typedValueM4296q2 = AbstractC1919e.m4296q(context, R.attr.elevationOverlayAccentColor);
        if (typedValueM4296q2 != null) {
            int i4 = typedValueM4296q2.resourceId;
            iM4520a2 = i4 != 0 ? AbstractC2048d.m4520a(context, i4) : typedValueM4296q2.data;
        } else {
            iM4520a2 = 0;
        }
        TypedValue typedValueM4296q3 = AbstractC1919e.m4296q(context, R.attr.colorSurface);
        if (typedValueM4296q3 != null) {
            int i5 = typedValueM4296q3.resourceId;
            iM4520a3 = i5 != 0 ? AbstractC2048d.m4520a(context, i5) : typedValueM4296q3.data;
        }
        float f3 = context.getResources().getDisplayMetrics().density;
        this.f74a = zM4297r;
        this.f75b = iM4520a;
        this.f76c = iM4520a2;
        this.f77d = iM4520a3;
        this.f78e = f3;
    }
}
