package p147u;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;

/* JADX INFO: renamed from: u.f */
/* JADX INFO: loaded from: classes.dex */
public final class C1930f {

    /* JADX INFO: renamed from: a */
    public final float f6824a;

    /* JADX INFO: renamed from: b */
    public final float f6825b;

    /* JADX INFO: renamed from: c */
    public final float f6826c;

    /* JADX INFO: renamed from: d */
    public final float f6827d;

    /* JADX INFO: renamed from: e */
    public final int f6828e;

    public C1930f(Context context, XmlResourceParser xmlResourceParser) {
        this.f6824a = Float.NaN;
        this.f6825b = Float.NaN;
        this.f6826c = Float.NaN;
        this.f6827d = Float.NaN;
        this.f6828e = -1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), AbstractC1940p.f6932i);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i3);
            if (index == 0) {
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.f6828e);
                this.f6828e = resourceId;
                String resourceTypeName = context.getResources().getResourceTypeName(resourceId);
                context.getResources().getResourceName(resourceId);
                if ("layout".equals(resourceTypeName)) {
                    new C1936l().m4336b((ConstraintLayout) LayoutInflater.from(context).inflate(resourceId, (ViewGroup) null));
                }
            } else if (index == 1) {
                this.f6827d = typedArrayObtainStyledAttributes.getDimension(index, this.f6827d);
            } else if (index == 2) {
                this.f6825b = typedArrayObtainStyledAttributes.getDimension(index, this.f6825b);
            } else if (index == 3) {
                this.f6826c = typedArrayObtainStyledAttributes.getDimension(index, this.f6826c);
            } else if (index == 4) {
                this.f6824a = typedArrayObtainStyledAttributes.getDimension(index, this.f6824a);
            } else {
                Log.v("ConstraintLayoutStates", "Unknown tag");
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
