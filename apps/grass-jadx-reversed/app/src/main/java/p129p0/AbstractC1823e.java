package p129p0;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import com.facebook.AbstractC1117n;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p010C0.AbstractC0147a;
import p156w0.ViewOnClickListenerC1991f;
import p166z0.AbstractC2056E;

/* JADX INFO: renamed from: p0.e */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1823e {

    /* JADX INFO: renamed from: a */
    public static WeakReference f6318a = new WeakReference(null);

    /* JADX INFO: renamed from: b */
    public static Method f6319b = null;

    /* JADX INFO: renamed from: a */
    public static View m4055a(View view) {
        if (AbstractC0147a.f354a.contains(AbstractC1823e.class)) {
            return null;
        }
        while (view != null) {
            try {
                boolean zEquals = false;
                if (!AbstractC0147a.f354a.contains(AbstractC1823e.class)) {
                    try {
                        zEquals = view.getClass().getName().equals("com.facebook.react.ReactRootView");
                    } catch (Throwable th) {
                        AbstractC0147a.m295a(th, AbstractC1823e.class);
                    }
                }
                if (!zEquals) {
                    Object parent = view.getParent();
                    if (!(parent instanceof View)) {
                        break;
                    }
                    view = (View) parent;
                } else {
                    return view;
                }
            } catch (Throwable th2) {
                AbstractC0147a.m295a(th2, AbstractC1823e.class);
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: b */
    public static ArrayList m4056b(View view) {
        if (AbstractC0147a.f354a.contains(AbstractC1823e.class)) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    arrayList.add(viewGroup.getChildAt(i3));
                }
            }
            return arrayList;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1823e.class);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x004b A[Catch: all -> 0x0049, TRY_LEAVE, TryCatch #2 {all -> 0x0049, blocks: (B:15:0x0022, B:18:0x002b, B:27:0x0042, B:32:0x004b, B:40:0x005d, B:38:0x0058, B:25:0x003c, B:22:0x0036), top: B:83:0x0022, outer: #1, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x005d A[Catch: all -> 0x0049, TRY_LEAVE, TryCatch #2 {all -> 0x0049, blocks: (B:15:0x0022, B:18:0x002b, B:27:0x0042, B:32:0x004b, B:40:0x005d, B:38:0x0058, B:25:0x003c, B:22:0x0036), top: B:83:0x0022, outer: #1, inners: #4 }] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m4057c(android.view.View r7) {
        /*
            java.util.Set r0 = p010C0.AbstractC0147a.f354a
            java.lang.Class<p0.e> r1 = p129p0.AbstractC1823e.class
            boolean r2 = r0.contains(r1)
            r3 = 0
            if (r2 == 0) goto Lc
            return r3
        Lc:
            boolean r2 = r7 instanceof android.widget.ImageView     // Catch: java.lang.Throwable -> L86
            if (r2 == 0) goto L12
            r2 = 2
            goto L13
        L12:
            r2 = r3
        L13:
            boolean r4 = r7.isClickable()     // Catch: java.lang.Throwable -> L86
            if (r4 == 0) goto L1b
            r2 = r2 | 32
        L1b:
            boolean r4 = r0.contains(r1)     // Catch: java.lang.Throwable -> L86
            if (r4 == 0) goto L22
            goto L69
        L22:
            android.view.ViewParent r4 = r7.getParent()     // Catch: java.lang.Throwable -> L49
            boolean r5 = r4 instanceof android.widget.AdapterView     // Catch: java.lang.Throwable -> L49
            if (r5 == 0) goto L2b
            goto L63
        L2b:
            java.lang.String r5 = "android.support.v4.view.NestedScrollingChild"
            boolean r0 = r0.contains(r1)     // Catch: java.lang.Throwable -> L49
            r6 = 0
            if (r0 == 0) goto L36
        L34:
            r0 = r6
            goto L40
        L36:
            java.lang.Class r0 = java.lang.Class.forName(r5)     // Catch: java.lang.ClassNotFoundException -> L34 java.lang.Throwable -> L3b
            goto L40
        L3b:
            r0 = move-exception
            p010C0.AbstractC0147a.m295a(r0, r1)     // Catch: java.lang.Throwable -> L49
            goto L34
        L40:
            if (r0 == 0) goto L4b
            boolean r0 = r0.isInstance(r4)     // Catch: java.lang.Throwable -> L49
            if (r0 == 0) goto L4b
            goto L63
        L49:
            r0 = move-exception
            goto L66
        L4b:
            java.util.Set r0 = p010C0.AbstractC0147a.f354a     // Catch: java.lang.Throwable -> L49
            boolean r0 = r0.contains(r1)     // Catch: java.lang.Throwable -> L49
            if (r0 == 0) goto L54
            goto L5b
        L54:
            java.lang.Class<J.n> r6 = p029J.InterfaceC0357n.class
            goto L5b
        L57:
            r0 = move-exception
            p010C0.AbstractC0147a.m295a(r0, r1)     // Catch: java.lang.Throwable -> L49
        L5b:
            if (r6 == 0) goto L69
            boolean r0 = r6.isInstance(r4)     // Catch: java.lang.Throwable -> L49
            if (r0 == 0) goto L69
        L63:
            r2 = r2 | 512(0x200, float:7.17E-43)
            goto L69
        L66:
            p010C0.AbstractC0147a.m295a(r0, r1)     // Catch: java.lang.Throwable -> L86
        L69:
            boolean r0 = r7 instanceof android.widget.TextView     // Catch: java.lang.Throwable -> L86
            if (r0 == 0) goto L8f
            r0 = r2 | 1025(0x401, float:1.436E-42)
            boolean r4 = r7 instanceof android.widget.Button     // Catch: java.lang.Throwable -> L86
            if (r4 == 0) goto L7b
            r0 = r2 | 1029(0x405, float:1.442E-42)
            boolean r4 = r7 instanceof android.widget.Switch     // Catch: java.lang.Throwable -> L86
            if (r4 == 0) goto L7d
            r0 = r2 | 9221(0x2405, float:1.2921E-41)
        L7b:
            r2 = r0
            goto L88
        L7d:
            boolean r4 = r7 instanceof android.widget.CheckBox     // Catch: java.lang.Throwable -> L86
            if (r4 == 0) goto L7b
            r0 = 33797(0x8405, float:4.736E-41)
            r0 = r0 | r2
            goto L7b
        L86:
            r7 = move-exception
            goto Lbf
        L88:
            boolean r7 = r7 instanceof android.widget.EditText     // Catch: java.lang.Throwable -> L86
            if (r7 == 0) goto Lbe
            r2 = r2 | 2048(0x800, float:2.87E-42)
            goto Lbe
        L8f:
            boolean r0 = r7 instanceof android.widget.Spinner     // Catch: java.lang.Throwable -> L86
            if (r0 != 0) goto Lbc
            boolean r0 = r7 instanceof android.widget.DatePicker     // Catch: java.lang.Throwable -> L86
            if (r0 == 0) goto L98
            goto Lbc
        L98:
            boolean r0 = r7 instanceof android.widget.RatingBar     // Catch: java.lang.Throwable -> L86
            if (r0 == 0) goto La0
            r7 = 65536(0x10000, float:9.1835E-41)
            r2 = r2 | r7
            goto Lbe
        La0:
            boolean r0 = r7 instanceof android.widget.RadioGroup     // Catch: java.lang.Throwable -> L86
            if (r0 == 0) goto La7
            r2 = r2 | 16384(0x4000, float:2.2959E-41)
            goto Lbe
        La7:
            boolean r0 = r7 instanceof android.view.ViewGroup     // Catch: java.lang.Throwable -> L86
            if (r0 == 0) goto Lbe
            java.lang.ref.WeakReference r0 = p129p0.AbstractC1823e.f6318a     // Catch: java.lang.Throwable -> L86
            java.lang.Object r0 = r0.get()     // Catch: java.lang.Throwable -> L86
            android.view.View r0 = (android.view.View) r0     // Catch: java.lang.Throwable -> L86
            boolean r7 = m4066l(r7, r0)     // Catch: java.lang.Throwable -> L86
            if (r7 == 0) goto Lbe
            r2 = r2 | 64
            goto Lbe
        Lbc:
            r2 = r2 | 4096(0x1000, float:5.74E-42)
        Lbe:
            return r2
        Lbf:
            p010C0.AbstractC0147a.m295a(r7, r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p129p0.AbstractC1823e.m4057c(android.view.View):int");
    }

    /* JADX INFO: renamed from: d */
    public static JSONObject m4058d(View view) {
        if (AbstractC0147a.f354a.contains(AbstractC1823e.class)) {
            return null;
        }
        try {
            if (view.getClass().getName().equals("com.facebook.react.ReactRootView")) {
                f6318a = new WeakReference(view);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                m4068n(view, jSONObject);
                JSONArray jSONArray = new JSONArray();
                ArrayList arrayListM4056b = m4056b(view);
                for (int i3 = 0; i3 < arrayListM4056b.size(); i3++) {
                    jSONArray.put(m4058d((View) arrayListM4056b.get(i3)));
                }
                jSONObject.put("childviews", jSONArray);
            } catch (JSONException e3) {
                Log.e("p0.e", "Failed to create JSONObject for view.", e3);
            }
            return jSONObject;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1823e.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: e */
    public static JSONObject m4059e(View view) {
        if (AbstractC0147a.f354a.contains(AbstractC1823e.class)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("top", view.getTop());
                jSONObject.put("left", view.getLeft());
                jSONObject.put("width", view.getWidth());
                jSONObject.put("height", view.getHeight());
                jSONObject.put("scrollx", view.getScrollX());
                jSONObject.put("scrolly", view.getScrollY());
                jSONObject.put("visibility", view.getVisibility());
            } catch (JSONException e3) {
                Log.e("p0.e", "Failed to create JSONObject for dimension.", e3);
            }
            return jSONObject;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1823e.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: f */
    public static View.OnClickListener m4060f(View view) {
        Field declaredField;
        if (AbstractC0147a.f354a.contains(AbstractC1823e.class)) {
            return null;
        }
        try {
            Field declaredField2 = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
            if (declaredField2 != null) {
                declaredField2.setAccessible(true);
            }
            Object obj = declaredField2.get(view);
            if (obj == null || (declaredField = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnClickListener")) == null) {
                return null;
            }
            declaredField.setAccessible(true);
            return (View.OnClickListener) declaredField.get(obj);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException unused) {
            return null;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1823e.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: g */
    public static View.OnTouchListener m4061g(View view) {
        Field declaredField;
        try {
            if (AbstractC0147a.f354a.contains(AbstractC1823e.class)) {
                return null;
            }
            try {
                Field declaredField2 = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
                if (declaredField2 != null) {
                    declaredField2.setAccessible(true);
                }
                Object obj = declaredField2.get(view);
                if (obj == null || (declaredField = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnTouchListener")) == null) {
                    return null;
                }
                declaredField.setAccessible(true);
                return (View.OnTouchListener) declaredField.get(obj);
            } catch (ClassNotFoundException unused) {
                HashSet hashSet = AbstractC1117n.f3875a;
                return null;
            } catch (IllegalAccessException unused2) {
                HashSet hashSet2 = AbstractC1117n.f3875a;
                return null;
            } catch (NoSuchFieldException unused3) {
                HashSet hashSet3 = AbstractC1117n.f3875a;
                return null;
            }
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1823e.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: h */
    public static String m4062h(View view) {
        if (AbstractC0147a.f354a.contains(AbstractC1823e.class)) {
            return null;
        }
        try {
            CharSequence hint = view instanceof EditText ? ((EditText) view).getHint() : view instanceof TextView ? ((TextView) view).getHint() : null;
            return hint == null ? "" : hint.toString();
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1823e.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: i */
    public static ViewGroup m4063i(View view) {
        if (AbstractC0147a.f354a.contains(AbstractC1823e.class) || view == null) {
            return null;
        }
        try {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                return (ViewGroup) parent;
            }
            return null;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1823e.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: j */
    public static String m4064j(View view) {
        CharSequence charSequenceValueOf;
        String text;
        Object selectedItem;
        if (AbstractC0147a.f354a.contains(AbstractC1823e.class)) {
            return null;
        }
        try {
            if (view instanceof TextView) {
                charSequenceValueOf = ((TextView) view).getText();
                if (view instanceof Switch) {
                    text = ((Switch) view).isChecked() ? "1" : "0";
                    charSequenceValueOf = text;
                    break;
                }
            } else if (view instanceof Spinner) {
                if (((Spinner) view).getCount() > 0 && (selectedItem = ((Spinner) view).getSelectedItem()) != null) {
                    text = selectedItem.toString();
                    charSequenceValueOf = text;
                    break;
                }
                charSequenceValueOf = null;
            } else if (view instanceof DatePicker) {
                DatePicker datePicker = (DatePicker) view;
                charSequenceValueOf = String.format("%04d-%02d-%02d", Integer.valueOf(datePicker.getYear()), Integer.valueOf(datePicker.getMonth()), Integer.valueOf(datePicker.getDayOfMonth()));
            } else if (view instanceof TimePicker) {
                TimePicker timePicker = (TimePicker) view;
                Integer currentHour = timePicker.getCurrentHour();
                currentHour.intValue();
                Integer currentMinute = timePicker.getCurrentMinute();
                currentMinute.intValue();
                charSequenceValueOf = String.format("%02d:%02d", currentHour, currentMinute);
            } else {
                if (view instanceof RadioGroup) {
                    RadioGroup radioGroup = (RadioGroup) view;
                    int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                    int childCount = radioGroup.getChildCount();
                    for (int i3 = 0; i3 < childCount; i3++) {
                        View childAt = radioGroup.getChildAt(i3);
                        if (childAt.getId() == checkedRadioButtonId && (childAt instanceof RadioButton)) {
                            text = ((RadioButton) childAt).getText();
                            charSequenceValueOf = text;
                            break;
                        }
                    }
                } else if (view instanceof RatingBar) {
                    charSequenceValueOf = String.valueOf(((RatingBar) view).getRating());
                }
                charSequenceValueOf = null;
            }
            return charSequenceValueOf == null ? "" : charSequenceValueOf.toString();
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1823e.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: k */
    public static void m4065k() {
        if (AbstractC0147a.f354a.contains(AbstractC1823e.class)) {
            return;
        }
        try {
            if (f6319b != null) {
                return;
            }
            try {
                Method declaredMethod = Class.forName("com.facebook.react.uimanager.TouchTargetHelper").getDeclaredMethod("findTouchTargetView", float[].class, ViewGroup.class);
                f6319b = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (ClassNotFoundException unused) {
                HashSet hashSet = AbstractC1117n.f3875a;
            } catch (NoSuchMethodException unused2) {
                HashSet hashSet2 = AbstractC1117n.f3875a;
            }
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1823e.class);
        }
    }

    /* JADX INFO: renamed from: l */
    public static boolean m4066l(View view, View view2) {
        float[] fArr;
        Set set = AbstractC0147a.f354a;
        if (set.contains(AbstractC1823e.class)) {
            return false;
        }
        try {
            if (!view.getClass().getName().equals("com.facebook.react.views.view.ReactViewGroup")) {
                return false;
            }
            View view3 = null;
            if (set.contains(AbstractC1823e.class)) {
                fArr = null;
            } else {
                try {
                    view.getLocationOnScreen(new int[2]);
                    fArr = new float[]{r3[0], r3[1]};
                } catch (Throwable th) {
                    AbstractC0147a.m295a(th, AbstractC1823e.class);
                    fArr = null;
                }
            }
            if (!AbstractC0147a.f354a.contains(AbstractC1823e.class)) {
                try {
                    m4065k();
                    Method method = f6319b;
                    if (method != null && view2 != null) {
                        try {
                            View view4 = (View) method.invoke(null, fArr, view2);
                            if (view4 != null && view4.getId() > 0) {
                                View view5 = (View) view4.getParent();
                                if (view5 != null) {
                                    view3 = view5;
                                }
                            }
                        } catch (IllegalAccessException unused) {
                            HashSet hashSet = AbstractC1117n.f3875a;
                        } catch (InvocationTargetException unused2) {
                            HashSet hashSet2 = AbstractC1117n.f3875a;
                        }
                    }
                } catch (Throwable th2) {
                    AbstractC0147a.m295a(th2, AbstractC1823e.class);
                }
            }
            if (view3 != null) {
                if (view3.getId() == view.getId()) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th3) {
            AbstractC0147a.m295a(th3, AbstractC1823e.class);
            return false;
        }
    }

    /* JADX INFO: renamed from: m */
    public static void m4067m(View view, ViewOnClickListenerC1991f viewOnClickListenerC1991f) {
        Field declaredField;
        Field declaredField2;
        if (AbstractC0147a.f354a.contains(AbstractC1823e.class)) {
            return;
        }
        Object obj = null;
        try {
            try {
                declaredField = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
                try {
                    declaredField2 = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnClickListener");
                } catch (ClassNotFoundException | NoSuchFieldException unused) {
                    declaredField2 = null;
                }
            } catch (Exception unused2) {
                return;
            } catch (Throwable th) {
                AbstractC0147a.m295a(th, AbstractC1823e.class);
                return;
            }
        } catch (ClassNotFoundException | NoSuchFieldException unused3) {
            declaredField = null;
        }
        if (declaredField == null || declaredField2 == null) {
            view.setOnClickListener(viewOnClickListenerC1991f);
            return;
        }
        declaredField.setAccessible(true);
        declaredField2.setAccessible(true);
        try {
            declaredField.setAccessible(true);
            obj = declaredField.get(view);
        } catch (IllegalAccessException unused4) {
        }
        if (obj == null) {
            view.setOnClickListener(viewOnClickListenerC1991f);
        } else {
            declaredField2.set(obj, viewOnClickListenerC1991f);
        }
    }

    /* JADX INFO: renamed from: n */
    public static void m4068n(View view, JSONObject jSONObject) {
        try {
            if (AbstractC0147a.f354a.contains(AbstractC1823e.class)) {
                return;
            }
            try {
                String strM4064j = m4064j(view);
                String strM4062h = m4062h(view);
                Object tag = view.getTag();
                CharSequence contentDescription = view.getContentDescription();
                jSONObject.put("classname", view.getClass().getCanonicalName());
                jSONObject.put("classtypebitmask", m4057c(view));
                jSONObject.put("id", view.getId());
                if (AbstractC1822d.m4049c(view)) {
                    jSONObject.put("text", "");
                    jSONObject.put("is_user_input", true);
                } else {
                    jSONObject.put("text", AbstractC2056E.m4536e(AbstractC2056E.m4530B(strM4064j)));
                }
                jSONObject.put("hint", AbstractC2056E.m4536e(AbstractC2056E.m4530B(strM4062h)));
                if (tag != null) {
                    jSONObject.put("tag", AbstractC2056E.m4536e(AbstractC2056E.m4530B(tag.toString())));
                }
                if (contentDescription != null) {
                    jSONObject.put("description", AbstractC2056E.m4536e(AbstractC2056E.m4530B(contentDescription.toString())));
                }
                jSONObject.put("dimension", m4059e(view));
            } catch (JSONException unused) {
                HashSet hashSet = AbstractC1117n.f3875a;
            }
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1823e.class);
        }
    }
}
