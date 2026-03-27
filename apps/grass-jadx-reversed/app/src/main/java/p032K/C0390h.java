package p032K;

import android.R;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;

/* JADX INFO: renamed from: K.h */
/* JADX INFO: loaded from: classes.dex */
public final class C0390h {

    /* JADX INFO: renamed from: e */
    public static final C0390h f908e;

    /* JADX INFO: renamed from: f */
    public static final C0390h f909f;

    /* JADX INFO: renamed from: g */
    public static final C0390h f910g;

    /* JADX INFO: renamed from: h */
    public static final C0390h f911h;

    /* JADX INFO: renamed from: i */
    public static final C0390h f912i;

    /* JADX INFO: renamed from: j */
    public static final C0390h f913j;

    /* JADX INFO: renamed from: k */
    public static final C0390h f914k;

    /* JADX INFO: renamed from: l */
    public static final C0390h f915l;

    /* JADX INFO: renamed from: a */
    public final Object f916a;

    /* JADX INFO: renamed from: b */
    public final int f917b;

    /* JADX INFO: renamed from: c */
    public final Class f918c;

    /* JADX INFO: renamed from: d */
    public final InterfaceC0402t f919d;

    static {
        new C0390h(1);
        new C0390h(2);
        new C0390h(4);
        new C0390h(8);
        f908e = new C0390h(16);
        new C0390h(32);
        new C0390h(64);
        new C0390h(128);
        new C0390h(256, AbstractC0395m.class);
        new C0390h(512, AbstractC0395m.class);
        new C0390h(1024, AbstractC0396n.class);
        new C0390h(2048, AbstractC0396n.class);
        f909f = new C0390h(4096);
        f910g = new C0390h(8192);
        new C0390h(16384);
        new C0390h(32768);
        new C0390h(65536);
        new C0390h(131072, AbstractC0400r.class);
        f911h = new C0390h(262144);
        f912i = new C0390h(524288);
        f913j = new C0390h(1048576);
        new C0390h(2097152, AbstractC0401s.class);
        int i3 = Build.VERSION.SDK_INT;
        new C0390h(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN, R.id.accessibilityActionShowOnScreen, null, null, null);
        new C0390h(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION, R.id.accessibilityActionScrollToPosition, null, null, AbstractC0398p.class);
        f914k = new C0390h(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP, R.id.accessibilityActionScrollUp, null, null, null);
        new C0390h(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT, R.id.accessibilityActionScrollLeft, null, null, null);
        f915l = new C0390h(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN, R.id.accessibilityActionScrollDown, null, null, null);
        new C0390h(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT, R.id.accessibilityActionScrollRight, null, null, null);
        new C0390h(i3 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, R.id.accessibilityActionPageUp, null, null, null);
        new C0390h(i3 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, R.id.accessibilityActionPageDown, null, null, null);
        new C0390h(i3 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, R.id.accessibilityActionPageLeft, null, null, null);
        new C0390h(i3 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, R.id.accessibilityActionPageRight, null, null, null);
        new C0390h(AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK, R.id.accessibilityActionContextClick, null, null, null);
        new C0390h(AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS, R.id.accessibilityActionSetProgress, null, null, AbstractC0399q.class);
        new C0390h(AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW, R.id.accessibilityActionMoveWindow, null, null, AbstractC0397o.class);
        new C0390h(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP, R.id.accessibilityActionShowTooltip, null, null, null);
        new C0390h(AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP, R.id.accessibilityActionHideTooltip, null, null, null);
        new C0390h(i3 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, R.id.accessibilityActionPressAndHold, null, null, null);
        new C0390h(i3 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null, R.id.accessibilityActionImeEnter, null, null, null);
        new C0390h(i3 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START : null, R.id.accessibilityActionDragStart, null, null, null);
        new C0390h(i3 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP : null, R.id.accessibilityActionDragDrop, null, null, null);
        new C0390h(i3 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL : null, R.id.accessibilityActionDragCancel, null, null, null);
        new C0390h(i3 >= 33 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS : null, R.id.accessibilityActionShowTextSuggestions, null, null, null);
    }

    public C0390h(int i3) {
        this(null, i3, null, null, null);
    }

    /* JADX INFO: renamed from: a */
    public final int m867a() {
        return ((AccessibilityNodeInfo.AccessibilityAction) this.f916a).getId();
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof C0390h)) {
            return false;
        }
        Object obj2 = ((C0390h) obj).f916a;
        Object obj3 = this.f916a;
        return obj3 == null ? obj2 == null : obj3.equals(obj2);
    }

    public final int hashCode() {
        Object obj = this.f916a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public C0390h(int i3, Class cls) {
        this(null, i3, null, null, cls);
    }

    public C0390h(Object obj, int i3, String str, InterfaceC0402t interfaceC0402t, Class cls) {
        this.f917b = i3;
        this.f919d = interfaceC0402t;
        if (obj == null) {
            this.f916a = new AccessibilityNodeInfo.AccessibilityAction(i3, str);
        } else {
            this.f916a = obj;
        }
        this.f918c = cls;
    }
}
