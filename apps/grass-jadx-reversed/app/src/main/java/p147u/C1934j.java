package p147u;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

/* JADX INFO: renamed from: u.j */
/* JADX INFO: loaded from: classes.dex */
public final class C1934j {

    /* JADX INFO: renamed from: a */
    public int f6902a;

    /* JADX INFO: renamed from: b */
    public int f6903b;

    /* JADX INFO: renamed from: c */
    public float f6904c;

    /* JADX INFO: renamed from: d */
    public float f6905d;

    /* JADX INFO: renamed from: a */
    public final void m4330a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC1940p.f6929f);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i3);
            if (index == 1) {
                this.f6904c = typedArrayObtainStyledAttributes.getFloat(index, this.f6904c);
            } else if (index == 0) {
                int i4 = typedArrayObtainStyledAttributes.getInt(index, this.f6902a);
                this.f6902a = i4;
                this.f6902a = C1936l.f6919d[i4];
            } else if (index == 4) {
                this.f6903b = typedArrayObtainStyledAttributes.getInt(index, this.f6903b);
            } else if (index == 3) {
                this.f6905d = typedArrayObtainStyledAttributes.getFloat(index, this.f6905d);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
