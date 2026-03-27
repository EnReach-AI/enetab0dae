package p015D2;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertController$RecycleListView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.Arrays;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p032K.InterfaceC0402t;
import p098g.C1362a;
import p098g.C1363b;
import p098g.C1364c;
import p098g.C1365d;
import p098g.DialogC1366e;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: D2.p */
/* JADX INFO: loaded from: classes.dex */
public final class C0192p implements InterfaceC0402t {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f442e;

    /* JADX INFO: renamed from: f */
    public int f443f;

    /* JADX INFO: renamed from: g */
    public Object f444g;

    /* JADX INFO: renamed from: a */
    public DialogC1366e m334a() {
        C1363b c1363b = (C1363b) this.f444g;
        DialogC1366e dialogC1366e = new DialogC1366e((ContextThemeWrapper) c1363b.f4868a, this.f443f);
        View view = c1363b.f4872e;
        C1365d c1365d = dialogC1366e.f4906i;
        if (view != null) {
            c1365d.f4892o = view;
        } else {
            CharSequence charSequence = c1363b.f4871d;
            if (charSequence != null) {
                c1365d.f4881d = charSequence;
                TextView textView = c1365d.f4890m;
                if (textView != null) {
                    textView.setText(charSequence);
                }
            }
            Drawable drawable = c1363b.f4870c;
            if (drawable != null) {
                c1365d.f4888k = drawable;
                c1365d.f4887j = 0;
                ImageView imageView = c1365d.f4889l;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    c1365d.f4889l.setImageDrawable(drawable);
                }
            }
        }
        if (c1363b.f4874g != null) {
            AlertController$RecycleListView alertController$RecycleListView = (AlertController$RecycleListView) c1363b.f4869b.inflate(c1365d.f4896s, (ViewGroup) null);
            int i3 = c1363b.f4876i ? c1365d.f4897t : c1365d.f4898u;
            ListAdapter c1364c = c1363b.f4874g;
            if (c1364c == null) {
                c1364c = new C1364c(c1363b.f4868a, i3, R.id.text1, null);
            }
            c1365d.f4893p = c1364c;
            c1365d.f4894q = c1363b.f4877j;
            if (c1363b.f4875h != null) {
                alertController$RecycleListView.setOnItemClickListener(new C1362a(c1363b, c1365d));
            }
            if (c1363b.f4876i) {
                alertController$RecycleListView.setChoiceMode(1);
            }
            c1365d.f4882e = alertController$RecycleListView;
        }
        dialogC1366e.setCancelable(true);
        dialogC1366e.setCanceledOnTouchOutside(true);
        dialogC1366e.setOnCancelListener(null);
        dialogC1366e.setOnDismissListener(null);
        DialogInterface.OnKeyListener onKeyListener = c1363b.f4873f;
        if (onKeyListener != null) {
            dialogC1366e.setOnKeyListener(onKeyListener);
        }
        return dialogC1366e;
    }

    /* JADX INFO: renamed from: b */
    public void m335b(int i3, int i4) {
        int i5 = i4 + i3;
        char[] cArr = (char[]) this.f444g;
        if (cArr.length <= i5) {
            int i6 = i3 * 2;
            if (i5 < i6) {
                i5 = i6;
            }
            char[] cArrCopyOf = Arrays.copyOf(cArr, i5);
            AbstractC1766e.m3919d("copyOf(this, newSize)", cArrCopyOf);
            this.f444g = cArrCopyOf;
        }
    }

    /* JADX INFO: renamed from: c */
    public void m336c() {
        C0178b c0178b = C0178b.f416c;
        char[] cArr = (char[]) this.f444g;
        c0178b.getClass();
        AbstractC1766e.m3920e("array", cArr);
        synchronized (c0178b) {
            int i3 = c0178b.f418b;
            if (cArr.length + i3 < AbstractC0177a.f415a) {
                c0178b.f418b = i3 + cArr.length;
                c0178b.f417a.addLast(cArr);
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public void m337d(String str) {
        AbstractC1766e.m3920e("text", str);
        int length = str.length();
        if (length == 0) {
            return;
        }
        m335b(this.f443f, length);
        str.getChars(0, str.length(), (char[]) this.f444g, this.f443f);
        this.f443f += length;
    }

    @Override // p032K.InterfaceC0402t
    /* JADX INFO: renamed from: e */
    public boolean mo338e(View view) {
        ((BottomSheetBehavior) this.f444g).m3157z(this.f443f);
        return true;
    }

    public String toString() {
        switch (this.f442e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                return new String((char[]) this.f444g, 0, this.f443f);
            default:
                return super.toString();
        }
    }

    public /* synthetic */ C0192p(int i3, int i4, Object[] objArr) {
        this.f442e = i4;
        this.f443f = i3;
        this.f444g = objArr;
    }

    public C0192p(Context context) {
        this.f442e = 3;
        int iM3334i = DialogC1366e.m3334i(context, 0);
        this.f444g = new C1363b(new ContextThemeWrapper(context, DialogC1366e.m3334i(context, iM3334i)));
        this.f443f = iM3334i;
    }

    public C0192p(BottomSheetBehavior bottomSheetBehavior, int i3) {
        this.f442e = 5;
        this.f444g = bottomSheetBehavior;
        this.f443f = i3;
    }
}
