package p029J;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import io.getgrass.www.R;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import p032K.C0390h;
import p032K.InterfaceC0402t;
import p041N.C0531s;

/* JADX INFO: renamed from: J.S */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0323S {

    /* JADX INFO: renamed from: a */
    public static WeakHashMap f816a;

    /* JADX INFO: renamed from: b */
    public static Field f817b;

    /* JADX INFO: renamed from: c */
    public static boolean f818c;

    /* JADX INFO: renamed from: d */
    public static final int[] f819d;

    /* JADX INFO: renamed from: e */
    public static final C0372w f820e;

    /* JADX INFO: renamed from: f */
    public static final ViewTreeObserverOnGlobalLayoutListenerC0374y f821f;

    static {
        new AtomicInteger(1);
        f816a = null;
        f818c = false;
        f819d = new int[]{R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};
        f820e = new C0372w();
        f821f = new ViewTreeObserverOnGlobalLayoutListenerC0374y();
    }

    /* JADX INFO: renamed from: a */
    public static C0330Z m691a(View view) {
        if (f816a == null) {
            f816a = new WeakHashMap();
        }
        C0330Z c0330z = (C0330Z) f816a.get(view);
        if (c0330z != null) {
            return c0330z;
        }
        C0330Z c0330z2 = new C0330Z(view);
        f816a.put(view, c0330z2);
        return c0330z2;
    }

    /* JADX INFO: renamed from: b */
    public static View.AccessibilityDelegate m692b(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return AbstractC0318M.m682a(view);
        }
        if (f818c) {
            return null;
        }
        if (f817b == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f817b = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f818c = true;
                return null;
            }
        }
        try {
            Object obj = f817b.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            f818c = true;
            return null;
        }
    }

    /* JADX INFO: renamed from: c */
    public static CharSequence m693c(View view) {
        return AbstractC0317L.m674b(view);
    }

    /* JADX INFO: renamed from: d */
    public static ArrayList m694d(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_accessibility_actions);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(R.id.tag_accessibility_actions, arrayList2);
        return arrayList2;
    }

    /* JADX INFO: renamed from: e */
    public static String[] m695e(View view) {
        return Build.VERSION.SDK_INT >= 31 ? AbstractC0320O.m688a(view) : (String[]) view.getTag(R.id.tag_on_receive_content_mime_types);
    }

    /* JADX INFO: renamed from: f */
    public static void m696f(View view, int i3) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z3 = m693c(view) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (AbstractC0310E.m618a(view) != 0 || z3) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z3 ? 32 : 2048);
                AbstractC0310E.m624g(accessibilityEventObtain, i3);
                if (z3) {
                    accessibilityEventObtain.getText().add(m693c(view));
                    if (AbstractC0307B.m587c(view) == 0) {
                        AbstractC0307B.m603s(view, 1);
                    }
                    ViewParent parent = view.getParent();
                    while (true) {
                        if (!(parent instanceof View)) {
                            break;
                        }
                        if (AbstractC0307B.m587c((View) parent) == 4) {
                            AbstractC0307B.m603s(view, 2);
                            break;
                        }
                        parent = parent.getParent();
                    }
                }
                view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
                return;
            }
            if (i3 != 32) {
                if (view.getParent() != null) {
                    try {
                        AbstractC0310E.m622e(view.getParent(), view, view, i3);
                        return;
                    } catch (AbstractMethodError e3) {
                        Log.e("ViewCompat", view.getParent().getClass().getSimpleName().concat(" does not fully implement ViewParent"), e3);
                        return;
                    }
                }
                return;
            }
            AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain();
            view.onInitializeAccessibilityEvent(accessibilityEventObtain2);
            accessibilityEventObtain2.setEventType(32);
            AbstractC0310E.m624g(accessibilityEventObtain2, i3);
            accessibilityEventObtain2.setSource(view);
            view.onPopulateAccessibilityEvent(accessibilityEventObtain2);
            accessibilityEventObtain2.getText().add(m693c(view));
            accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: g */
    public static C0343g m697g(View view, C0343g c0343g) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + c0343g + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return AbstractC0320O.m689b(view, c0343g);
        }
        InterfaceC0369t interfaceC0369t = (InterfaceC0369t) view.getTag(R.id.tag_on_receive_content_listener);
        InterfaceC0370u interfaceC0370u = f820e;
        if (interfaceC0369t == null) {
            if (view instanceof InterfaceC0370u) {
                interfaceC0370u = (InterfaceC0370u) view;
            }
            return interfaceC0370u.mo838a(c0343g);
        }
        C0343g c0343gM1070a = ((C0531s) interfaceC0369t).m1070a(view, c0343g);
        if (c0343gM1070a == null) {
            return null;
        }
        if (view instanceof InterfaceC0370u) {
            interfaceC0370u = (InterfaceC0370u) view;
        }
        return interfaceC0370u.mo838a(c0343gM1070a);
    }

    /* JADX INFO: renamed from: h */
    public static void m698h(View view, int i3) {
        ArrayList arrayListM694d = m694d(view);
        for (int i4 = 0; i4 < arrayListM694d.size(); i4++) {
            if (((C0390h) arrayListM694d.get(i4)).m867a() == i3) {
                arrayListM694d.remove(i4);
                return;
            }
        }
    }

    /* JADX INFO: renamed from: i */
    public static void m699i(View view, C0390h c0390h, InterfaceC0402t interfaceC0402t) {
        C0390h c0390h2 = new C0390h(null, c0390h.f917b, null, interfaceC0402t, c0390h.f918c);
        View.AccessibilityDelegate accessibilityDelegateM692b = m692b(view);
        C0335c c0335c = accessibilityDelegateM692b == null ? null : accessibilityDelegateM692b instanceof C0331a ? ((C0331a) accessibilityDelegateM692b).f828a : new C0335c(accessibilityDelegateM692b);
        if (c0335c == null) {
            c0335c = new C0335c();
        }
        m701k(view, c0335c);
        m698h(view, c0390h2.m867a());
        m694d(view).add(c0390h2);
        m696f(view, 0);
    }

    /* JADX INFO: renamed from: j */
    public static void m700j(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i3) {
        if (Build.VERSION.SDK_INT >= 29) {
            AbstractC0318M.m684c(view, context, iArr, attributeSet, typedArray, i3, 0);
        }
    }

    /* JADX INFO: renamed from: k */
    public static void m701k(View view, C0335c c0335c) {
        if (c0335c == null && (m692b(view) instanceof C0331a)) {
            c0335c = new C0335c();
        }
        view.setAccessibilityDelegate(c0335c == null ? null : c0335c.f831b);
    }

    /* JADX INFO: renamed from: l */
    public static void m702l(View view, CharSequence charSequence) {
        new C0373x(R.id.tag_accessibility_pane_title, CharSequence.class, 8, 28, 1).m845e(view, charSequence);
        ViewTreeObserverOnGlobalLayoutListenerC0374y viewTreeObserverOnGlobalLayoutListenerC0374y = f821f;
        if (charSequence == null) {
            viewTreeObserverOnGlobalLayoutListenerC0374y.f884e.remove(view);
            view.removeOnAttachStateChangeListener(viewTreeObserverOnGlobalLayoutListenerC0374y);
            AbstractC0307B.m599o(view.getViewTreeObserver(), viewTreeObserverOnGlobalLayoutListenerC0374y);
        } else {
            viewTreeObserverOnGlobalLayoutListenerC0374y.f884e.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
            view.addOnAttachStateChangeListener(viewTreeObserverOnGlobalLayoutListenerC0374y);
            if (AbstractC0310E.m619b(view)) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(viewTreeObserverOnGlobalLayoutListenerC0374y);
            }
        }
    }
}
