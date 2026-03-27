package p098g;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertController$RecycleListView;
import androidx.core.widget.NestedScrollView;
import io.getgrass.www.R;
import java.lang.ref.WeakReference;
import p024H0.ViewOnClickListenerC0250d;
import p068X.HandlerC0696a;
import p094f.AbstractC1343a;

/* JADX INFO: renamed from: g.d */
/* JADX INFO: loaded from: classes.dex */
public final class C1365d {

    /* JADX INFO: renamed from: a */
    public final Context f4878a;

    /* JADX INFO: renamed from: b */
    public final DialogC1366e f4879b;

    /* JADX INFO: renamed from: c */
    public final Window f4880c;

    /* JADX INFO: renamed from: d */
    public CharSequence f4881d;

    /* JADX INFO: renamed from: e */
    public AlertController$RecycleListView f4882e;

    /* JADX INFO: renamed from: f */
    public Button f4883f;

    /* JADX INFO: renamed from: g */
    public Button f4884g;

    /* JADX INFO: renamed from: h */
    public Button f4885h;

    /* JADX INFO: renamed from: i */
    public NestedScrollView f4886i;

    /* JADX INFO: renamed from: k */
    public Drawable f4888k;

    /* JADX INFO: renamed from: l */
    public ImageView f4889l;

    /* JADX INFO: renamed from: m */
    public TextView f4890m;

    /* JADX INFO: renamed from: n */
    public TextView f4891n;

    /* JADX INFO: renamed from: o */
    public View f4892o;

    /* JADX INFO: renamed from: p */
    public ListAdapter f4893p;

    /* JADX INFO: renamed from: r */
    public final int f4895r;

    /* JADX INFO: renamed from: s */
    public final int f4896s;

    /* JADX INFO: renamed from: t */
    public final int f4897t;

    /* JADX INFO: renamed from: u */
    public final int f4898u;

    /* JADX INFO: renamed from: v */
    public final boolean f4899v;

    /* JADX INFO: renamed from: w */
    public final HandlerC0696a f4900w;

    /* JADX INFO: renamed from: j */
    public int f4887j = 0;

    /* JADX INFO: renamed from: q */
    public int f4894q = -1;

    /* JADX INFO: renamed from: x */
    public final ViewOnClickListenerC0250d f4901x = new ViewOnClickListenerC0250d(4, this);

    public C1365d(Context context, DialogC1366e dialogC1366e, Window window) {
        this.f4878a = context;
        this.f4879b = dialogC1366e;
        this.f4880c = window;
        HandlerC0696a handlerC0696a = new HandlerC0696a();
        handlerC0696a.f1893b = new WeakReference(dialogC1366e);
        this.f4900w = handlerC0696a;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, AbstractC1343a.f4781e, R.attr.alertDialogStyle, 0);
        this.f4895r = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.getResourceId(2, 0);
        this.f4896s = typedArrayObtainStyledAttributes.getResourceId(4, 0);
        typedArrayObtainStyledAttributes.getResourceId(5, 0);
        this.f4897t = typedArrayObtainStyledAttributes.getResourceId(7, 0);
        this.f4898u = typedArrayObtainStyledAttributes.getResourceId(3, 0);
        this.f4899v = typedArrayObtainStyledAttributes.getBoolean(6, true);
        typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        dialogC1366e.m3335c().mo3353i(1);
    }

    /* JADX INFO: renamed from: a */
    public static ViewGroup m3332a(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }
}
