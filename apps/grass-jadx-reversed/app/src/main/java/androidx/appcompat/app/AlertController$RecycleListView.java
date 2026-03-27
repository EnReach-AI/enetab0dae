package androidx.appcompat.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ListView;
import p094f.AbstractC1343a;

/* JADX INFO: loaded from: classes.dex */
public class AlertController$RecycleListView extends ListView {

    /* JADX INFO: renamed from: e */
    public final int f2649e;

    /* JADX INFO: renamed from: f */
    public final int f2650f;

    public AlertController$RecycleListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC1343a.f4796t);
        this.f2650f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(0, -1);
        this.f2649e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, -1);
    }
}
