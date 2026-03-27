package p032K;

import android.R;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityNodeInfo;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p036L0.C0444d;
import p156w0.AbstractC1986a;

/* JADX INFO: renamed from: K.i */
/* JADX INFO: loaded from: classes.dex */
public final class C0391i {

    /* JADX INFO: renamed from: a */
    public final AccessibilityNodeInfo f920a;

    /* JADX INFO: renamed from: b */
    public int f921b = -1;

    /* JADX INFO: renamed from: c */
    public int f922c = -1;

    public C0391i(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f920a = accessibilityNodeInfo;
    }

    /* JADX INFO: renamed from: a */
    public final void m868a(int i3) {
        this.f920a.addAction(i3);
    }

    /* JADX INFO: renamed from: b */
    public final void m869b(C0390h c0390h) {
        this.f920a.addAction((AccessibilityNodeInfo.AccessibilityAction) c0390h.f916a);
    }

    /* JADX INFO: renamed from: c */
    public final ArrayList m870c(String str) {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f920a;
        ArrayList<Integer> integerArrayList = accessibilityNodeInfo.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        accessibilityNodeInfo.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    /* JADX INFO: renamed from: d */
    public final void m871d(Rect rect) {
        this.f920a.getBoundsInParent(rect);
    }

    /* JADX INFO: renamed from: e */
    public final CharSequence m872e() {
        boolean z3 = !m870c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
        AccessibilityNodeInfo accessibilityNodeInfo = this.f920a;
        if (!z3) {
            return accessibilityNodeInfo.getText();
        }
        ArrayList arrayListM870c = m870c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        ArrayList arrayListM870c2 = m870c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        ArrayList arrayListM870c3 = m870c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        ArrayList arrayListM870c4 = m870c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(accessibilityNodeInfo.getText(), 0, accessibilityNodeInfo.getText().length()));
        for (int i3 = 0; i3 < arrayListM870c.size(); i3++) {
            spannableString.setSpan(new C0383a(((Integer) arrayListM870c4.get(i3)).intValue(), this, accessibilityNodeInfo.getExtras().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), ((Integer) arrayListM870c.get(i3)).intValue(), ((Integer) arrayListM870c2.get(i3)).intValue(), ((Integer) arrayListM870c3.get(i3)).intValue());
        }
        return spannableString;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof C0391i)) {
            return false;
        }
        C0391i c0391i = (C0391i) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = c0391i.f920a;
        AccessibilityNodeInfo accessibilityNodeInfo2 = this.f920a;
        if (accessibilityNodeInfo2 == null) {
            if (accessibilityNodeInfo != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo2.equals(accessibilityNodeInfo)) {
            return false;
        }
        return this.f922c == c0391i.f922c && this.f921b == c0391i.f921b;
    }

    /* JADX INFO: renamed from: f */
    public final void m873f(C0444d c0444d) {
        this.f920a.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) c0444d.f1085e);
    }

    public final int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f920a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.util.ArrayList] */
    public final String toString() {
        ?? EmptyList;
        String string;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        m871d(rect);
        sb.append("; boundsInParent: " + rect);
        AccessibilityNodeInfo accessibilityNodeInfo = this.f920a;
        accessibilityNodeInfo.getBoundsInScreen(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ");
        sb.append(accessibilityNodeInfo.getPackageName());
        sb.append("; className: ");
        sb.append(accessibilityNodeInfo.getClassName());
        sb.append("; text: ");
        sb.append(m872e());
        sb.append("; contentDescription: ");
        sb.append(accessibilityNodeInfo.getContentDescription());
        sb.append("; viewId: ");
        sb.append(accessibilityNodeInfo.getViewIdResourceName());
        sb.append("; uniqueId: ");
        sb.append(AbstractC1986a.m4379g() ? accessibilityNodeInfo.getUniqueId() : accessibilityNodeInfo.getExtras().getString("androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY"));
        sb.append("; checkable: ");
        sb.append(accessibilityNodeInfo.isCheckable());
        sb.append("; checked: ");
        sb.append(accessibilityNodeInfo.isChecked());
        sb.append("; focusable: ");
        sb.append(accessibilityNodeInfo.isFocusable());
        sb.append("; focused: ");
        sb.append(accessibilityNodeInfo.isFocused());
        sb.append("; selected: ");
        sb.append(accessibilityNodeInfo.isSelected());
        sb.append("; clickable: ");
        sb.append(accessibilityNodeInfo.isClickable());
        sb.append("; longClickable: ");
        sb.append(accessibilityNodeInfo.isLongClickable());
        sb.append("; enabled: ");
        sb.append(accessibilityNodeInfo.isEnabled());
        sb.append("; password: ");
        sb.append(accessibilityNodeInfo.isPassword());
        sb.append("; scrollable: " + accessibilityNodeInfo.isScrollable());
        sb.append("; [");
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = accessibilityNodeInfo.getActionList();
        if (actionList != null) {
            EmptyList = new ArrayList();
            int size = actionList.size();
            for (int i3 = 0; i3 < size; i3++) {
                EmptyList.add(new C0390h(actionList.get(i3), 0, null, null, null));
            }
        } else {
            EmptyList = Collections.emptyList();
        }
        for (int i4 = 0; i4 < EmptyList.size(); i4++) {
            C0390h c0390h = (C0390h) EmptyList.get(i4);
            int iM867a = c0390h.m867a();
            if (iM867a == 1) {
                string = "ACTION_FOCUS";
            } else if (iM867a != 2) {
                switch (iM867a) {
                    case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                        string = "ACTION_SELECT";
                        break;
                    case FromStringDeserializer.Std.STD_LOCALE /* 8 */:
                        string = "ACTION_CLEAR_SELECTION";
                        break;
                    case 16:
                        string = "ACTION_CLICK";
                        break;
                    case 32:
                        string = "ACTION_LONG_CLICK";
                        break;
                    case 64:
                        string = "ACTION_ACCESSIBILITY_FOCUS";
                        break;
                    case 128:
                        string = "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
                        break;
                    case 256:
                        string = "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
                        break;
                    case 512:
                        string = "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
                        break;
                    case 1024:
                        string = "ACTION_NEXT_HTML_ELEMENT";
                        break;
                    case 2048:
                        string = "ACTION_PREVIOUS_HTML_ELEMENT";
                        break;
                    case 4096:
                        string = "ACTION_SCROLL_FORWARD";
                        break;
                    case 8192:
                        string = "ACTION_SCROLL_BACKWARD";
                        break;
                    case 16384:
                        string = "ACTION_COPY";
                        break;
                    case 32768:
                        string = "ACTION_PASTE";
                        break;
                    case 65536:
                        string = "ACTION_CUT";
                        break;
                    case 131072:
                        string = "ACTION_SET_SELECTION";
                        break;
                    case 262144:
                        string = "ACTION_EXPAND";
                        break;
                    case 524288:
                        string = "ACTION_COLLAPSE";
                        break;
                    case 2097152:
                        string = "ACTION_SET_TEXT";
                        break;
                    case R.id.accessibilityActionMoveWindow:
                        string = "ACTION_MOVE_WINDOW";
                        break;
                    default:
                        switch (iM867a) {
                            case R.id.accessibilityActionShowOnScreen:
                                string = "ACTION_SHOW_ON_SCREEN";
                                break;
                            case R.id.accessibilityActionScrollToPosition:
                                string = "ACTION_SCROLL_TO_POSITION";
                                break;
                            case R.id.accessibilityActionScrollUp:
                                string = "ACTION_SCROLL_UP";
                                break;
                            case R.id.accessibilityActionScrollLeft:
                                string = "ACTION_SCROLL_LEFT";
                                break;
                            case R.id.accessibilityActionScrollDown:
                                string = "ACTION_SCROLL_DOWN";
                                break;
                            case R.id.accessibilityActionScrollRight:
                                string = "ACTION_SCROLL_RIGHT";
                                break;
                            case R.id.accessibilityActionContextClick:
                                string = "ACTION_CONTEXT_CLICK";
                                break;
                            case R.id.accessibilityActionSetProgress:
                                string = "ACTION_SET_PROGRESS";
                                break;
                            default:
                                switch (iM867a) {
                                    case R.id.accessibilityActionShowTooltip:
                                        string = "ACTION_SHOW_TOOLTIP";
                                        break;
                                    case R.id.accessibilityActionHideTooltip:
                                        string = "ACTION_HIDE_TOOLTIP";
                                        break;
                                    case R.id.accessibilityActionPageUp:
                                        string = "ACTION_PAGE_UP";
                                        break;
                                    case R.id.accessibilityActionPageDown:
                                        string = "ACTION_PAGE_DOWN";
                                        break;
                                    case R.id.accessibilityActionPageLeft:
                                        string = "ACTION_PAGE_LEFT";
                                        break;
                                    case R.id.accessibilityActionPageRight:
                                        string = "ACTION_PAGE_RIGHT";
                                        break;
                                    case R.id.accessibilityActionPressAndHold:
                                        string = "ACTION_PRESS_AND_HOLD";
                                        break;
                                    default:
                                        switch (iM867a) {
                                            case R.id.accessibilityActionImeEnter:
                                                string = "ACTION_IME_ENTER";
                                                break;
                                            case R.id.accessibilityActionDragStart:
                                                string = "ACTION_DRAG_START";
                                                break;
                                            case R.id.accessibilityActionDragDrop:
                                                string = "ACTION_DRAG_DROP";
                                                break;
                                            case R.id.accessibilityActionDragCancel:
                                                string = "ACTION_DRAG_CANCEL";
                                                break;
                                            default:
                                                string = "ACTION_UNKNOWN";
                                                break;
                                        }
                                        break;
                                }
                                break;
                        }
                        break;
                }
            } else {
                string = "ACTION_CLEAR_FOCUS";
            }
            if (string.equals("ACTION_UNKNOWN")) {
                Object obj = c0390h.f916a;
                if (((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel() != null) {
                    string = ((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel().toString();
                }
            }
            sb.append(string);
            if (i4 != EmptyList.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
