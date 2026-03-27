package p025H1;

import android.graphics.Canvas;
import android.graphics.Matrix;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p022G1.C0237a;

/* JADX INFO: renamed from: H1.m */
/* JADX INFO: loaded from: classes.dex */
public final class C0284m extends AbstractC0290s {

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ List f767c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Matrix f768d;

    public C0284m(ArrayList arrayList, Matrix matrix) {
        this.f767c = arrayList;
        this.f768d = matrix;
    }

    @Override // p025H1.AbstractC0290s
    /* JADX INFO: renamed from: a */
    public final void mo562a(Matrix matrix, C0237a c0237a, int i3, Canvas canvas) {
        Iterator it = this.f767c.iterator();
        while (it.hasNext()) {
            ((AbstractC0290s) it.next()).mo562a(this.f768d, c0237a, i3, canvas);
        }
    }
}
