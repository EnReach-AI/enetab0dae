package p098g;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListAdapter;

/* JADX INFO: renamed from: g.b */
/* JADX INFO: loaded from: classes.dex */
public final class C1363b {

    /* JADX INFO: renamed from: a */
    public final Context f4868a;

    /* JADX INFO: renamed from: b */
    public final LayoutInflater f4869b;

    /* JADX INFO: renamed from: c */
    public Drawable f4870c;

    /* JADX INFO: renamed from: d */
    public CharSequence f4871d;

    /* JADX INFO: renamed from: e */
    public View f4872e;

    /* JADX INFO: renamed from: f */
    public DialogInterface.OnKeyListener f4873f;

    /* JADX INFO: renamed from: g */
    public ListAdapter f4874g;

    /* JADX INFO: renamed from: h */
    public DialogInterface.OnClickListener f4875h;

    /* JADX INFO: renamed from: i */
    public boolean f4876i;

    /* JADX INFO: renamed from: j */
    public int f4877j = -1;

    public C1363b(ContextThemeWrapper contextThemeWrapper) {
        this.f4868a = contextThemeWrapper;
        this.f4869b = (LayoutInflater) contextThemeWrapper.getSystemService("layout_inflater");
    }
}
