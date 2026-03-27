package p073Z;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewGroup;

/* JADX INFO: renamed from: Z.J */
/* JADX INFO: loaded from: classes.dex */
public class C0764J extends ViewGroup.MarginLayoutParams {

    /* JADX INFO: renamed from: a */
    public AbstractC0777X f2154a;

    /* JADX INFO: renamed from: b */
    public final Rect f2155b;

    /* JADX INFO: renamed from: c */
    public boolean f2156c;

    /* JADX INFO: renamed from: d */
    public boolean f2157d;

    public C0764J(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2155b = new Rect();
        this.f2156c = true;
        this.f2157d = false;
    }

    public C0764J(int i3, int i4) {
        super(i3, i4);
        this.f2155b = new Rect();
        this.f2156c = true;
        this.f2157d = false;
    }

    public C0764J(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.f2155b = new Rect();
        this.f2156c = true;
        this.f2157d = false;
    }

    public C0764J(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.f2155b = new Rect();
        this.f2156c = true;
        this.f2157d = false;
    }

    public C0764J(C0764J c0764j) {
        super((ViewGroup.LayoutParams) c0764j);
        this.f2155b = new Rect();
        this.f2156c = true;
        this.f2157d = false;
    }
}
