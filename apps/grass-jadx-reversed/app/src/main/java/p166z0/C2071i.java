package p166z0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.Selection;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.emoji2.text.C0896c;
import androidx.emoji2.text.C0906m;
import androidx.emoji2.text.C0913t;
import androidx.emoji2.text.InterfaceC0899f;
import androidx.fragment.app.AbstractComponentCallbacksC0944o;
import androidx.fragment.app.C0920F;
import androidx.fragment.app.C0923I;
import com.fasterxml.jackson.databind.deser.std.C1186b;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p001A.AbstractC0017r;
import p005B.AbstractC0030e;
import p005B.AbstractC0031f;
import p052R.C0603a;
import p110k.C1549P;
import p110k.C1613r;
import p125o0.AbstractC1800j;
import p136r.AbstractC1849h;
import p141s0.C1876f;
import p160x0.AbstractC2008c;
import p160x0.C2006a;
import p160x0.C2007b;
import p160x0.C2009d;
import p160x0.C2010e;
import p160x0.C2011f;
import p165z.AbstractC2049e;

/* JADX INFO: renamed from: z0.i */
/* JADX INFO: loaded from: classes.dex */
public final class C2071i {

    /* JADX INFO: renamed from: d */
    public static C2071i f7310d;

    /* JADX INFO: renamed from: e */
    public static C2071i f7311e;

    /* JADX INFO: renamed from: f */
    public static C2071i f7312f;

    /* JADX INFO: renamed from: g */
    public static Method f7313g;

    /* JADX INFO: renamed from: a */
    public Object f7314a;

    /* JADX INFO: renamed from: b */
    public Object f7315b;

    /* JADX INFO: renamed from: c */
    public Object f7316c;

    public C2071i(int i3) {
        switch (i3) {
            case FromStringDeserializer.Std.STD_CHARSET /* 9 */:
                this.f7314a = new C2007b();
                C2011f c2011f = new C2011f();
                c2011f.f7168a = new HashSet();
                c2011f.f7169b = new HashMap();
                this.f7315b = c2011f;
                break;
            default:
                this.f7314a = new ArrayList();
                this.f7315b = new HashMap();
                break;
        }
    }

    /* JADX INFO: renamed from: c */
    public static boolean m4585c(Editable editable, KeyEvent keyEvent, boolean z3) {
        C0913t[] c0913tArr;
        if (!KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState())) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (selectionStart != -1 && selectionEnd != -1 && selectionStart == selectionEnd && (c0913tArr = (C0913t[]) editable.getSpans(selectionStart, selectionEnd, C0913t.class)) != null && c0913tArr.length > 0) {
            for (C0913t c0913t : c0913tArr) {
                int spanStart = editable.getSpanStart(c0913t);
                int spanEnd = editable.getSpanEnd(c0913t);
                if ((z3 && spanStart == selectionStart) || ((!z3 && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                    editable.delete(spanStart, spanEnd);
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: g */
    public static String m4586g(CharSequence charSequence, int i3) {
        if (charSequence == null || charSequence.length() < 1) {
            return "";
        }
        String strReplace = charSequence.toString().replace(" \n", " ").replace("\n", " ").replace("\"", "");
        if (charSequence.length() <= i3) {
            return strReplace;
        }
        return strReplace.substring(0, i3) + "...";
    }

    /* JADX INFO: renamed from: k */
    public static C2071i m4587k() {
        C1876f c1876f = new C1876f();
        c1876f.put(2, null);
        c1876f.put(4, null);
        c1876f.put(9, null);
        c1876f.put(17, null);
        c1876f.put(341, null);
        C1876f c1876f2 = new C1876f();
        c1876f2.put(102, null);
        c1876f2.put(190, null);
        c1876f2.put(412, null);
        return new C2071i(null, c1876f, c1876f2, null, null, null);
    }

    /* JADX INFO: renamed from: p */
    public static boolean m4588p(String str, String[] strArr) {
        if (strArr == null) {
            return false;
        }
        for (String str2 : strArr) {
            if (str.equalsIgnoreCase(str2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: t */
    public static boolean m4589t(String str, PrintWriter printWriter, String[] strArr) {
        if (strArr == null || strArr.length <= 0 || !"e2e".equals(strArr[0])) {
            return false;
        }
        if (f7312f == null) {
            f7312f = new C2071i(9);
        }
        C2071i c2071i = f7312f;
        c2071i.getClass();
        printWriter.print(str);
        printWriter.println("Top Level Window View Hierarchy:");
        boolean zM4588p = m4588p("all-roots", strArr);
        boolean zM4588p2 = m4588p("top-root", strArr);
        boolean zM4588p3 = m4588p("webview", strArr);
        boolean zM4588p4 = m4588p("props", strArr);
        try {
            ArrayList<C2006a> arrayListM4461a = ((C2007b) c2071i.f7314a).m4461a();
            if (arrayListM4461a != null && !arrayListM4461a.isEmpty()) {
                Collections.reverse(arrayListM4461a);
                WindowManager.LayoutParams layoutParams = null;
                for (C2006a c2006a : arrayListM4461a) {
                    if (c2006a.f7153a.getVisibility() == 0) {
                        WindowManager.LayoutParams layoutParams2 = c2006a.f7154b;
                        if (!zM4588p && layoutParams != null && Math.abs(layoutParams2.type - layoutParams.type) != 1) {
                            break;
                        }
                        c2071i.m4595d(str + "  ", printWriter, c2006a.f7153a, 0, 0, zM4588p3, zM4588p4);
                        if (zM4588p2) {
                            break;
                        }
                        layoutParams = layoutParams2;
                    }
                }
                ((C2011f) c2071i.f7315b).m4464a(printWriter);
            }
        } catch (Exception e3) {
            printWriter.println("Failure in view hierarchy dump: " + e3.getMessage());
        }
        return true;
    }

    /* JADX INFO: renamed from: u */
    public static void m4590u(PrintWriter printWriter, View view) {
        Object tag = view.getTag();
        if (tag instanceof String) {
            String str = (String) tag;
            if (str.length() <= 0) {
                return;
            }
            printWriter.print(" app:tag/");
            printWriter.print(m4586g(str, 60));
        }
    }

    /* JADX INFO: renamed from: v */
    public static C2071i m4591v(Context context, AttributeSet attributeSet, int[] iArr, int i3, int i4) {
        return new C2071i(context, context.obtainStyledAttributes(attributeSet, iArr, i3, i4));
    }

    /* JADX INFO: renamed from: w */
    public static HashMap m4592w(JSONObject jSONObject) {
        int iOptInt;
        HashSet hashSet;
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("items");
        if (jSONArrayOptJSONArray.length() == 0) {
            return null;
        }
        HashMap map = new HashMap();
        for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i3);
            if (jSONObjectOptJSONObject != null && (iOptInt = jSONObjectOptJSONObject.optInt("code")) != 0) {
                JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("subcodes");
                if (jSONArrayOptJSONArray2 == null || jSONArrayOptJSONArray2.length() <= 0) {
                    hashSet = null;
                } else {
                    hashSet = new HashSet();
                    for (int i4 = 0; i4 < jSONArrayOptJSONArray2.length(); i4++) {
                        int iOptInt2 = jSONArrayOptJSONArray2.optInt(i4);
                        if (iOptInt2 != 0) {
                            hashSet.add(Integer.valueOf(iOptInt2));
                        }
                    }
                }
                map.put(Integer.valueOf(iOptInt), hashSet);
            }
        }
        return map;
    }

    /* JADX INFO: renamed from: a */
    public void m4593a(Object obj) {
        ArrayList arrayList = (ArrayList) this.f7316c;
        if (arrayList.isEmpty()) {
            ((Collection) this.f7315b).add(obj);
        } else {
            ((C1186b) arrayList.get(arrayList.size() - 1)).f4053c.add(obj);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m4594b(AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o) {
        if (((ArrayList) this.f7314a).contains(abstractComponentCallbacksC0944o)) {
            throw new IllegalStateException("Fragment already added: " + abstractComponentCallbacksC0944o);
        }
        synchronized (((ArrayList) this.f7314a)) {
            ((ArrayList) this.f7314a).add(abstractComponentCallbacksC0944o);
        }
        abstractComponentCallbacksC0944o.f3232o = true;
    }

    /* JADX INFO: renamed from: d */
    public void m4595d(String str, PrintWriter printWriter, View view, int i3, int i4, boolean z3, boolean z4) {
        ViewGroup viewGroup;
        int childCount;
        String string;
        Object tag;
        printWriter.print(str);
        if (view == null) {
            printWriter.println("null");
            return;
        }
        printWriter.print(view.getClass().getName());
        printWriter.print("{");
        printWriter.print(Integer.toHexString(view.hashCode()));
        printWriter.print(" ");
        int visibility = view.getVisibility();
        if (visibility == 0) {
            printWriter.print("V");
        } else if (visibility == 4) {
            printWriter.print("I");
        } else if (visibility != 8) {
            printWriter.print(".");
        } else {
            printWriter.print("G");
        }
        printWriter.print(view.isFocusable() ? "F" : ".");
        printWriter.print(view.isEnabled() ? "E" : ".");
        printWriter.print(".");
        printWriter.print(view.isHorizontalScrollBarEnabled() ? "H" : ".");
        printWriter.print(view.isVerticalScrollBarEnabled() ? "V" : ".");
        printWriter.print(view.isClickable() ? "C" : ".");
        printWriter.print(view.isLongClickable() ? "L" : ".");
        printWriter.print(" ");
        printWriter.print(view.isFocused() ? "F" : ".");
        printWriter.print(view.isSelected() ? "S" : ".");
        printWriter.print(view.isHovered() ? "H" : ".");
        printWriter.print(view.isActivated() ? "A" : ".");
        printWriter.print(view.isDirty() ? "D" : ".");
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        printWriter.print(" ");
        printWriter.print(iArr[0] - i3);
        printWriter.print(",");
        printWriter.print(iArr[1] - i4);
        printWriter.print("-");
        printWriter.print((view.getWidth() + iArr[0]) - i3);
        printWriter.print(",");
        printWriter.print((view.getHeight() + iArr[1]) - i4);
        try {
            int id = view.getId();
            if (id == -1) {
                m4590u(printWriter, view);
            } else {
                printWriter.append(" #");
                printWriter.append((CharSequence) Integer.toHexString(id));
                Resources resources = view.getResources();
                if (id <= 0 || resources == null) {
                    m4590u(printWriter, view);
                } else {
                    int i5 = (-16777216) & id;
                    String resourcePackageName = i5 != 16777216 ? i5 != 2130706432 ? resources.getResourcePackageName(id) : "app" : "android";
                    printWriter.print(" ");
                    printWriter.print(resourcePackageName);
                    printWriter.print(":");
                    printWriter.print(resources.getResourceTypeName(id));
                    printWriter.print("/");
                    printWriter.print(resources.getResourceEntryName(id));
                }
            }
        } catch (Exception unused) {
            m4590u(printWriter, view);
        }
        try {
            if (view instanceof TextView) {
                string = ((TextView) view).getText().toString();
            } else if (view.getClass().getSimpleName().equals("RCTextView")) {
                if (f7313g == null) {
                    f7313g = view.getClass().getDeclaredMethod("getText", null);
                }
                Object objInvoke = f7313g.invoke(view, null);
                string = objInvoke != null ? objInvoke.toString() : null;
            } else {
                CharSequence contentDescription = view.getContentDescription();
                string = contentDescription != null ? contentDescription.toString() : null;
                if ((string == null || string.isEmpty()) && (tag = view.getTag()) != null) {
                    string = tag.toString().trim();
                }
            }
            if (string != null && !string.isEmpty()) {
                printWriter.print(" text=\"");
                printWriter.print(m4586g(string, 600));
                printWriter.print("\"");
            }
        } catch (Exception unused2) {
        }
        if (z4) {
            Field field = AbstractC2008c.f7159a;
            AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain();
            try {
                view.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoObtain);
            } catch (NullPointerException unused3) {
                if (accessibilityNodeInfoObtain != null) {
                    accessibilityNodeInfoObtain.recycle();
                }
                accessibilityNodeInfoObtain = null;
            }
            if (accessibilityNodeInfoObtain != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (view instanceof TextView) {
                        TextView textView = (TextView) view;
                        jSONObject.put("textColor", textView.getTextColors().getDefaultColor());
                        jSONObject.put("textSize", textView.getTextSize());
                        jSONObject.put("hint", m4586g(textView.getHint(), 100));
                    }
                    JSONObject jSONObjectM4462a = AbstractC2008c.m4462a(view);
                    if (jSONObjectM4462a != null) {
                        jSONObject.put("keyedTags", jSONObjectM4462a);
                    }
                    JSONArray jSONArray = new JSONArray();
                    Iterator<AccessibilityNodeInfo.AccessibilityAction> it = accessibilityNodeInfoObtain.getActionList().iterator();
                    while (it.hasNext()) {
                        String str2 = (String) it.next().getLabel();
                        if (str2 != null) {
                            jSONArray.put(m4586g(str2, 50));
                        }
                    }
                    if (jSONArray.length() > 0) {
                        jSONObject.put("actions", jSONArray);
                    }
                    String strM4586g = m4586g(accessibilityNodeInfoObtain.getContentDescription(), 50);
                    if (strM4586g != null && strM4586g.length() > 0) {
                        jSONObject.put("content-description", strM4586g);
                    }
                    jSONObject.put("accessibility-focused", accessibilityNodeInfoObtain.isAccessibilityFocused()).put("checkable", accessibilityNodeInfoObtain.isCheckable()).put("checked", accessibilityNodeInfoObtain.isChecked()).put("class-name", m4586g(accessibilityNodeInfoObtain.getClassName(), 50)).put("clickable", accessibilityNodeInfoObtain.isClickable()).put("content-invalid", accessibilityNodeInfoObtain.isContentInvalid()).put("dismissable", accessibilityNodeInfoObtain.isDismissable()).put("editable", accessibilityNodeInfoObtain.isEditable()).put("enabled", accessibilityNodeInfoObtain.isEnabled()).put("focusable", accessibilityNodeInfoObtain.isFocusable()).put("focused", accessibilityNodeInfoObtain.isFocused()).put("long-clickable", accessibilityNodeInfoObtain.isLongClickable()).put("multiline", accessibilityNodeInfoObtain.isMultiLine()).put("password", accessibilityNodeInfoObtain.isPassword()).put("scrollable", accessibilityNodeInfoObtain.isScrollable()).put("selected", accessibilityNodeInfoObtain.isSelected()).put("visible-to-user", accessibilityNodeInfoObtain.isVisibleToUser());
                    jSONObject.put("context-clickable", accessibilityNodeInfoObtain.isContextClickable()).put("drawing-order", accessibilityNodeInfoObtain.getDrawingOrder()).put("important-for-accessibility", accessibilityNodeInfoObtain.isImportantForAccessibility());
                } catch (Exception e3) {
                    try {
                        jSONObject.put("DUMP-ERROR", m4586g(e3.getMessage(), 50));
                    } catch (JSONException unused4) {
                    }
                }
                printWriter.append(" props=\"").append((CharSequence) jSONObject.toString()).append("\"");
            }
        }
        printWriter.println("}");
        Class<?> superclass = view.getClass();
        while (true) {
            if (superclass == null) {
                break;
            }
            if (superclass.getName().equals("com.facebook.litho.LithoView")) {
                try {
                    if (((Method) this.f7316c) == null) {
                        this.f7316c = Class.forName("com.facebook.litho.LithoViewTestHelper").getDeclaredMethod("viewToStringForE2E", View.class, Integer.TYPE, Boolean.TYPE);
                    }
                    printWriter.append((CharSequence) ((Method) this.f7316c).invoke(null, view, Integer.valueOf((str.length() / 2) + 1), Boolean.valueOf(z4)));
                } catch (Exception e4) {
                    printWriter.append((CharSequence) str).append("Failed litho view sub hierarch dump: ").append((CharSequence) m4586g(e4.getMessage(), 100)).println();
                }
            } else {
                superclass = superclass.getSuperclass();
            }
        }
        if (z3 && (view instanceof WebView)) {
            WebView webView = (WebView) view;
            C2011f c2011f = (C2011f) this.f7315b;
            c2011f.getClass();
            C2010e c2010e = new C2010e(webView);
            ((HashSet) c2011f.f7168a).add(c2010e);
            webView.evaluateJavascript(String.format("(function() {  try {    const leftOf = %d;    const topOf = %d;    const density = %f;    const elements = Array.from(document.querySelectorAll('body, body *'));    for (const el of elements) {      const rect = el.getBoundingClientRect();      const left = Math.round(leftOf + rect.left * density);      const top = Math.round(topOf + rect.top * density);      const width = Math.round(rect.width * density);      const height = Math.round(rect.height * density);      el.setAttribute('data-rect', `${left},${top},${width},${height}`);      const style = window.getComputedStyle(el);      const hidden = style.display === 'none' || style.visibility !== 'visible' || el.getAttribute('hidden') === 'true';      const disabled = el.disabled || el.getAttribute('aria-disabled') === 'true';      const focused = el === document.activeElement;      if (hidden || disabled || focused) {        el.setAttribute('data-flag', `${hidden ? 'H' : ''}${disabled ? 'D' : ''}${focused ? 'F' : ''}`);      } else {        el.removeAttribute('data-flag');      }    }    document.activeElement.setAttribute('focused', 'true');    const doc = document.cloneNode(true);    for (const el of Array.from(doc.querySelectorAll('script, link'))) {      el.remove();    }    for (const el of Array.from(doc.querySelectorAll('*'))) {      el.removeAttribute('class');    }    return doc.getElementsByTagName('body')[0].outerHTML.trim();  } catch (e) {    return 'Failed: ' + e;  }})();", Integer.valueOf(c2010e.f7164b), Integer.valueOf(c2010e.f7165c), Float.valueOf(webView.getResources().getDisplayMetrics().scaledDensity)), new C2009d(c2011f, c2010e));
        }
        if ((view instanceof ViewGroup) && (childCount = (viewGroup = (ViewGroup) view).getChildCount()) > 0) {
            String strM4117a = AbstractC1849h.m4117a(str, "  ");
            int[] iArr2 = new int[2];
            view.getLocationOnScreen(iArr2);
            for (int i6 = 0; i6 < childCount; i6++) {
                m4595d(strM4117a, printWriter, viewGroup.getChildAt(i6), iArr2[0], iArr2[1], z3, z4);
            }
        }
    }

    /* JADX INFO: renamed from: e */
    public AbstractComponentCallbacksC0944o m4596e(String str) {
        C0923I c0923i = (C0923I) ((HashMap) this.f7315b).get(str);
        if (c0923i != null) {
            return c0923i.f3090c;
        }
        return null;
    }

    /* JADX INFO: renamed from: f */
    public AbstractComponentCallbacksC0944o m4597f(String str) {
        for (C0923I c0923i : ((HashMap) this.f7315b).values()) {
            if (c0923i != null) {
                AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944oM4597f = c0923i.f3090c;
                if (!str.equals(abstractComponentCallbacksC0944oM4597f.f3226i)) {
                    abstractComponentCallbacksC0944oM4597f = abstractComponentCallbacksC0944oM4597f.f3241x.f3031c.m4597f(str);
                }
                if (abstractComponentCallbacksC0944oM4597f != null) {
                    return abstractComponentCallbacksC0944oM4597f;
                }
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: h */
    public ArrayList m4598h() {
        ArrayList arrayList = new ArrayList();
        for (C0923I c0923i : ((HashMap) this.f7315b).values()) {
            if (c0923i != null) {
                arrayList.add(c0923i);
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: i */
    public ArrayList m4599i() {
        ArrayList arrayList = new ArrayList();
        for (C0923I c0923i : ((HashMap) this.f7315b).values()) {
            if (c0923i != null) {
                arrayList.add(c0923i.f3090c);
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: j */
    public ColorStateList m4600j(int i3) {
        int resourceId;
        ColorStateList colorStateListM4525c;
        TypedArray typedArray = (TypedArray) this.f7315b;
        return (!typedArray.hasValue(i3) || (resourceId = typedArray.getResourceId(i3, 0)) == 0 || (colorStateListM4525c = AbstractC2049e.m4525c((Context) this.f7314a, resourceId)) == null) ? typedArray.getColorStateList(i3) : colorStateListM4525c;
    }

    /* JADX INFO: renamed from: l */
    public Drawable m4601l(int i3) {
        int resourceId;
        TypedArray typedArray = (TypedArray) this.f7315b;
        return (!typedArray.hasValue(i3) || (resourceId = typedArray.getResourceId(i3, 0)) == 0) ? typedArray.getDrawable(i3) : AbstractC1800j.m3991i((Context) this.f7314a, resourceId);
    }

    /* JADX INFO: renamed from: m */
    public Drawable m4602m(int i3) {
        int resourceId;
        Drawable drawableM3584f;
        if (!((TypedArray) this.f7315b).hasValue(i3) || (resourceId = ((TypedArray) this.f7315b).getResourceId(i3, 0)) == 0) {
            return null;
        }
        C1613r c1613rM3680a = C1613r.m3680a();
        Context context = (Context) this.f7314a;
        synchronized (c1613rM3680a) {
            drawableM3584f = c1613rM3680a.f5723a.m3584f(context, resourceId, true);
        }
        return drawableM3584f;
    }

    /* JADX INFO: renamed from: n */
    public Typeface m4603n(int i3, int i4, C1549P c1549p) {
        int resourceId = ((TypedArray) this.f7315b).getResourceId(i3, 0);
        if (resourceId == 0) {
            return null;
        }
        if (((TypedValue) this.f7316c) == null) {
            this.f7316c = new TypedValue();
        }
        TypedValue typedValue = (TypedValue) this.f7316c;
        ThreadLocal threadLocal = AbstractC0017r.f43a;
        Context context = (Context) this.f7314a;
        if (context.isRestricted()) {
            return null;
        }
        return AbstractC0017r.m73b(context, resourceId, typedValue, i4, c1549p, true, false);
    }

    /* JADX INFO: renamed from: o */
    public List m4604o() {
        ArrayList arrayList;
        if (((ArrayList) this.f7314a).isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (((ArrayList) this.f7314a)) {
            arrayList = new ArrayList((ArrayList) this.f7314a);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: q */
    public boolean m4605q(CharSequence charSequence, int i3, int i4, C0906m c0906m) {
        if (c0906m.f2990c == 0) {
            InterfaceC0899f interfaceC0899f = (InterfaceC0899f) this.f7316c;
            C0603a c0603aM2350c = c0906m.m2350c();
            int iM843a = c0603aM2350c.m843a(8);
            if (iM843a != 0) {
                ((ByteBuffer) c0603aM2350c.f888d).getShort(iM843a + c0603aM2350c.f885a);
            }
            C0896c c0896c = (C0896c) interfaceC0899f;
            c0896c.getClass();
            ThreadLocal threadLocal = C0896c.f2964b;
            if (threadLocal.get() == null) {
                threadLocal.set(new StringBuilder());
            }
            StringBuilder sb = (StringBuilder) threadLocal.get();
            sb.setLength(0);
            while (i3 < i4) {
                sb.append(charSequence.charAt(i3));
                i3++;
            }
            TextPaint textPaint = c0896c.f2965a;
            String string = sb.toString();
            int i5 = AbstractC0031f.f85a;
            c0906m.f2990c = AbstractC0030e.m142a(textPaint, string) ? 2 : 1;
        }
        return c0906m.f2990c == 2;
    }

    /* JADX INFO: renamed from: r */
    public void m4606r(C0923I c0923i) {
        AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = c0923i.f3090c;
        String str = abstractComponentCallbacksC0944o.f3226i;
        HashMap map = (HashMap) this.f7315b;
        if (map.get(str) != null) {
            return;
        }
        map.put(abstractComponentCallbacksC0944o.f3226i, c0923i);
        if (abstractComponentCallbacksC0944o.f3206F) {
            if (abstractComponentCallbacksC0944o.f3205E) {
                ((C0920F) this.f7316c).m2411b(abstractComponentCallbacksC0944o);
            } else {
                ((C0920F) this.f7316c).m2412c(abstractComponentCallbacksC0944o);
            }
            abstractComponentCallbacksC0944o.f3206F = false;
        }
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Added fragment to active set " + abstractComponentCallbacksC0944o);
        }
    }

    /* JADX INFO: renamed from: s */
    public void m4607s(C0923I c0923i) {
        AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = c0923i.f3090c;
        if (abstractComponentCallbacksC0944o.f3205E) {
            ((C0920F) this.f7316c).m2412c(abstractComponentCallbacksC0944o);
        }
        if (((C0923I) ((HashMap) this.f7315b).put(abstractComponentCallbacksC0944o.f3226i, null)) != null && Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + abstractComponentCallbacksC0944o);
        }
    }

    /* JADX INFO: renamed from: x */
    public void m4608x() {
        ((TypedArray) this.f7315b).recycle();
    }

    public C2071i(Context context, TypedArray typedArray) {
        this.f7314a = context;
        this.f7315b = typedArray;
    }

    public C2071i(HashMap map, HashMap map2, HashMap map3, String str, String str2, String str3) {
        this.f7314a = map;
        this.f7315b = map2;
        this.f7316c = map3;
    }
}
