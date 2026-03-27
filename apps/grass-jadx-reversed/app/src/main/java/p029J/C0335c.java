package p029J;

import android.os.Bundle;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeProvider;
import io.getgrass.www.R;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
import p005B.AbstractC0032g;
import p031J1.C0382f;
import p032K.C0390h;
import p032K.C0391i;
import p032K.InterfaceC0402t;

/* JADX INFO: renamed from: J.c */
/* JADX INFO: loaded from: classes.dex */
public class C0335c {

    /* JADX INFO: renamed from: c */
    public static final View.AccessibilityDelegate f829c = new View.AccessibilityDelegate();

    /* JADX INFO: renamed from: a */
    public final View.AccessibilityDelegate f830a;

    /* JADX INFO: renamed from: b */
    public final C0331a f831b;

    public C0335c() {
        this(f829c);
    }

    /* JADX INFO: renamed from: a */
    public boolean mo723a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f830a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    /* JADX INFO: renamed from: b */
    public C0382f mo724b(View view) {
        AccessibilityNodeProvider accessibilityNodeProviderM720a = AbstractC0333b.m720a(this.f830a, view);
        if (accessibilityNodeProviderM720a != null) {
            return new C0382f(accessibilityNodeProviderM720a);
        }
        return null;
    }

    /* JADX INFO: renamed from: c */
    public void mo191c(View view, AccessibilityEvent accessibilityEvent) {
        this.f830a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    /* JADX INFO: renamed from: d */
    public void mo192d(View view, C0391i c0391i) {
        this.f830a.onInitializeAccessibilityNodeInfo(view, c0391i.f920a);
    }

    /* JADX INFO: renamed from: e */
    public void mo725e(View view, AccessibilityEvent accessibilityEvent) {
        this.f830a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    /* JADX INFO: renamed from: f */
    public boolean mo726f(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f830a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    /* JADX INFO: renamed from: g */
    public boolean mo727g(View view, int i3, Bundle bundle) {
        boolean zM721b;
        WeakReference weakReference;
        ClickableSpan clickableSpan;
        List listEmptyList = (List) view.getTag(R.id.tag_accessibility_actions);
        if (listEmptyList == null) {
            listEmptyList = Collections.emptyList();
        }
        boolean z3 = false;
        int i4 = 0;
        while (true) {
            if (i4 >= listEmptyList.size()) {
                break;
            }
            C0390h c0390h = (C0390h) listEmptyList.get(i4);
            if (c0390h.m867a() == i3) {
                InterfaceC0402t interfaceC0402t = c0390h.f919d;
                if (interfaceC0402t != null) {
                    Class cls = c0390h.f918c;
                    if (cls != null) {
                        try {
                            AbstractC0032g.m162t(cls.getDeclaredConstructor(null).newInstance(null));
                            throw null;
                        } catch (Exception e3) {
                            Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: ".concat(cls.getName()), e3);
                        }
                    }
                    zM721b = interfaceC0402t.mo338e(view);
                }
            } else {
                i4++;
            }
        }
        zM721b = false;
        if (!zM721b) {
            zM721b = AbstractC0333b.m721b(this.f830a, view, i3, bundle);
        }
        if (zM721b || i3 != R.id.accessibility_action_clickable_span || bundle == null) {
            return zM721b;
        }
        int i5 = bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1);
        SparseArray sparseArray = (SparseArray) view.getTag(R.id.tag_accessibility_clickable_spans);
        if (sparseArray != null && (weakReference = (WeakReference) sparseArray.get(i5)) != null && (clickableSpan = (ClickableSpan) weakReference.get()) != null) {
            CharSequence text = view.createAccessibilityNodeInfo().getText();
            ClickableSpan[] clickableSpanArr = text instanceof Spanned ? (ClickableSpan[]) ((Spanned) text).getSpans(0, text.length(), ClickableSpan.class) : null;
            int i6 = 0;
            while (true) {
                if (clickableSpanArr == null || i6 >= clickableSpanArr.length) {
                    break;
                }
                if (clickableSpan.equals(clickableSpanArr[i6])) {
                    clickableSpan.onClick(view);
                    z3 = true;
                    break;
                }
                i6++;
            }
        }
        return z3;
    }

    /* JADX INFO: renamed from: h */
    public void mo728h(View view, int i3) {
        this.f830a.sendAccessibilityEvent(view, i3);
    }

    /* JADX INFO: renamed from: i */
    public void mo729i(View view, AccessibilityEvent accessibilityEvent) {
        this.f830a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public C0335c(View.AccessibilityDelegate accessibilityDelegate) {
        this.f830a = accessibilityDelegate;
        this.f831b = new C0331a(this);
    }
}
